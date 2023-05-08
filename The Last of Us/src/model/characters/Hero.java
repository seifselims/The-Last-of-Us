package model.characters;
import java.awt.Point;
import java.util.ArrayList;

import engine.Game;
import exceptions.GameActionException;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import model.collectibles.Collectible;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.Cell;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
abstract public class Hero extends Character implements Collectible {
private int actionsAvailable;
private int maxActions;
private boolean specialAction;
private  ArrayList<Vaccine> vaccineInventory;
private  ArrayList<Supply> supplyInventory;
public int getActionsAvailable() {
	return actionsAvailable;
}
public void setActionsAvailable(int actionsAvailable) {
	this.actionsAvailable = actionsAvailable;
}
public boolean isSpecialAction() {
	return specialAction;
}
public void setSpecialAction(boolean specialAction) {
	this.specialAction = specialAction;
}
public int getMaxActions() {
	return maxActions;
}
public ArrayList<Vaccine> getVaccineInventory() {
	return vaccineInventory;
}

public ArrayList<Supply> getSupplyInventory() {
	return supplyInventory;
}
public Hero(String name, int maxHp, int attackDmg, int maxActions ) {
		super(name, maxHp, attackDmg);
		this.maxActions=maxActions;
		this.actionsAvailable=maxActions;
		this.vaccineInventory=new ArrayList<Vaccine>();
		this.supplyInventory=new ArrayList<Supply>();

		

	}

public void move  (Direction d) throws MovementException, NotEnoughActionsException  {
	if(this.getActionsAvailable()>0)	{
	Point b=this.getLocation();
	this.setVisiblity(true);
		switch(d) {
		case UP:
			if((b.x>=0&&b.x<14)) {
				b.x+=1;
				this.setNewLoc(b);
				this.setVisiblity(true);
			}
			else throw new MovementException("Out of borders");
		break;
		case DOWN:
			if((b.x>0&&b.x<=14)) {
				b.x-=1; 
			this.setNewLoc(b);
			this.setVisiblity(true);

			}
			else throw new MovementException("Out of borders");

		break;
		case RIGHT:
			if((b.y>0&&b.y<14)) {
			b.y+=1;
			this.setNewLoc(b);
			this.setVisiblity(true);

			}
			else throw new MovementException("Out of borders");

		break;
		case LEFT:
			if((b.y>0&&b.y<15)) {
			b.y-=1;
			this.setNewLoc(b);
			this.setVisiblity(true);

			}
			else throw new MovementException("Out of borders");
		break;
		}
		
			this.setVisiblity(false);
	int a=this.getActionsAvailable()-1;
	this.setActionsAvailable(a);
		}
	else
		throw new NotEnoughActionsException("No enough action points available");
	}


public void cure() throws NoAvailableResourcesException, Exception {
	
	if (this.getTarget()==null || !(this.getTarget() instanceof Zombie))
		throw new InvalidTargetException("You should cure a Zombie");
	else
		if(this.getActionsAvailable()>0)	{
			if(this.adjacent(this.getTarget())) {
				ArrayList<Vaccine> vaccine =this.getVaccineInventory();
				if(vaccine!=null) {
				((Collectible) vaccine).use(this);
				int a= this.getActionsAvailable()-1;
				this.setActionsAvailable(a);
				Point l=this.getTarget().getLocation();
				Game.zombies.remove(this.getTarget());
				Game.map[l.x][l.y]=null;
				Hero h=Game.availableHeroes.get((int)(Math.random()*(Game.availableHeroes.size()-1-0+1)+0));
				h.setNewLoc(l);
				this.setTarget(null);
			}
				}
			else
				throw new InvalidTargetException ("Target is not adjacent");
		}
			else
				throw new NotEnoughActionsException("No action points available");
}

public void useSpecial() throws NoAvailableResourcesException, Exception {
		if(this instanceof Medic) {
			if(this.getSupplyInventory()!=null ) {
				setSpecialAction(true);
				this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);
			    
			this.curehero();
			this.cureself(); }
			else {
				setSpecialAction(false);
				throw new NoAvailableResourcesException("No available resources");
			}
		}
		else if(this instanceof Explorer) {
			if(this.getSupplyInventory()!=null ) {
			setSpecialAction(true);
			this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);

		    
			for(int i=0;i<15;i++) {
				for(int j=0;j<15;j++) {
					Game.map[i][j].setVisible(true);
				}
			} }
			else {
				setSpecialAction(false);
				throw new NoAvailableResourcesException("No available resources");
			}
		}
		else if(this instanceof Fighter)  {
			if(this.getSupplyInventory()!=null ) {
				setSpecialAction(true);
				this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);
			this.attack2();
		    }
			else {
				setSpecialAction(false);
				throw new NoAvailableResourcesException("No available resources");
			}
		
		}	
}

	private void setNewLoc(Point b) throws MovementException {
		Cell targetCell=Game.map[b.x][b.y];
			if(targetCell instanceof TrapCell) {
					this.setCurrentHp(this.getCurrentHp()-((TrapCell) targetCell).getTrapDamage());
					if(this.getCurrentHp()==0) {
					this.onCharacterDeath();}
					else {
					CharacterCell newCell=new CharacterCell(this);
					targetCell=newCell;
					this.setLocation(b);
				}
	}
	else if(targetCell instanceof CollectibleCell) {
		((Collectible) targetCell).pickUp(this);
		CharacterCell newCell=new CharacterCell(this);
		targetCell=newCell;	
		this.setLocation(b);
	}
	else if(targetCell instanceof CharacterCell) {
		if (((CharacterCell) targetCell).getCharacter()!=null) {
			CharacterCell newCell=new CharacterCell(this);
			targetCell=newCell;	
			this.setLocation(b);
		}
		else	
		throw new MovementException("Cell is occupied");
	}
	
	}
	public void curehero() throws NoAvailableResourcesException, Exception {
		if (this instanceof Medic) {
		if (this.getTarget() instanceof Hero && this.adjacent(this.getTarget()) ) {
			Hero x=(Hero) this.getTarget();
			x.setCurrentHp(x.getMaxHp());
		}
	
		ArrayList<Supply> supply =this.getSupplyInventory();
		if(supply!=null) {
		((Collectible) supply).use(this);
		this.setSpecialAction(true);}
		}
		else
			return;
}
	public void cureself() throws NoAvailableResourcesException, Exception {
		if (this instanceof Medic) {
			if(this.getCurrentHp()!=this.getMaxHp())
				this.setCurrentHp(this.getMaxHp());
			ArrayList<Supply> supply =this.getSupplyInventory();
			if(supply!=null) {
			((Collectible) supply).use(this);
			this.setSpecialAction(true); }
			}
		else
			return;
	}
	public void attack2() {
		Zombie e= (Zombie)this.getTarget();
		e.setCurrentHp(e.getCurrentHp()-this.getAttackDmg());
		e.onCharacterDeath();
		}

	public void setVisiblity(boolean bool) {
		Point l=this.getLocation();
		if(l.x==14 && l.y==0){
			Game.map[l.x-1][l.y].setVisible(bool);
			Game.map[l.x][l.y+1].setVisible(bool);
			Game.map[l.x-1][l.y+1].setVisible(bool);
		}
		else if(l.x==14 && l.y==14) {
			Game.map[l.x-1][l.y].setVisible(bool);
			Game.map[l.x][l.y-1].setVisible(bool);
			Game.map[l.x-1][l.y-1].setVisible(bool);
		}
		else if(l.x==0 && l.y==0) {
			Game.map[l.x+1][l.y].setVisible(bool);
			Game.map[l.x][l.y+1].setVisible(bool);
			Game.map[l.x+1][l.y+1].setVisible(bool);
		}
		else if (l.x==0 && l.y==14) {
			Game.map[l.x+1][l.y].setVisible(bool);
			Game.map[l.x][l.y-1].setVisible(bool);
			Game.map[l.x+1][l.y-1].setVisible(bool);
		}
		else if (l.x==0 && l.y>0 && l.y<14) {
			Game.map[l.x+1][l.y].setVisible(bool);
			Game.map[l.x][l.y-1].setVisible(bool);
			Game.map[l.x][l.y+1].setVisible(bool);
			Game.map[l.x+1][l.y-1].setVisible(bool);
			Game.map[l.x+1][l.y+1].setVisible(bool);

		}
		else if (l.x==14 && l.y>0 && l.y<14) {
			Game.map[l.x-1][l.y].setVisible(bool);
			Game.map[l.x][l.y-1].setVisible(bool);
			Game.map[l.x][l.y+1].setVisible(bool);
			Game.map[l.x-1][l.y-1].setVisible(bool);
			Game.map[l.x-1][l.y+1].setVisible(bool);

		}
		else if (l.y==0 && l.x>0 && l.x<14) {
			Game.map[l.x-1][l.y].setVisible(bool);
			Game.map[l.x+1][l.y].setVisible(bool);
			Game.map[l.x][l.y+1].setVisible(bool);
			Game.map[l.x-1][l.y+1].setVisible(bool);
			Game.map[l.x+1][l.y+1].setVisible(bool);

		}
		else if (l.y==14 && l.x>0 && l.x<14) {
			Game.map[l.x-1][l.y].setVisible(bool);
			Game.map[l.x+1][l.y].setVisible(bool);
			Game.map[l.x][l.y-1].setVisible(bool);
			Game.map[l.x-1][l.y-1].setVisible(bool);
			Game.map[l.x+1][l.y-1].setVisible(bool);

		}
		else {
			Game.map[l.x][l.y+1].setVisible(bool);
			Game.map[l.x][l.y-1].setVisible(bool);
			Game.map[l.x+1][l.y].setVisible(bool);
			Game.map[l.x+1][l.y+1].setVisible(bool);
			Game.map[l.x+1][l.y-1].setVisible(bool);
			Game.map[l.x-1][l.y].setVisible(bool);
			Game.map[l.x-1][l.y-1].setVisible(bool);
			Game.map[l.x-1][l.y+1].setVisible(bool);

		}
	}
	public void attack() throws NotEnoughActionsException, InvalidTargetException {
		if (this.getTarget()==null || !(this.getTarget() instanceof Zombie) )
			throw new InvalidTargetException("Character does not have a Zombie target");
		Character e= this.getTarget();
		if (this.adjacent(e)){
		if (this.getTarget() instanceof Zombie) {
			if (this instanceof Fighter) {
				this.attack2();
				e.setTarget(this);
				int y=this.getCurrentHp()-(e.getAttackDmg()/2);
				this.setCurrentHp(y);
			}
			else {
		int a=this.getActionsAvailable()-1;
		this.setActionsAvailable(a);
		e.defend(this);
		if (a<0){
			this.setActionsAvailable(0);
			throw new NotEnoughActionsException("Not enough Action points available");
		}
		
		} }
	}
		else throw new InvalidTargetException("Target cell is not adjacent");
}
	public void defend(Character c) throws NotEnoughActionsException {
		
			int a=this.getActionsAvailable()-1;
			this.setActionsAvailable(a);
			if (a<0){
				this.setActionsAvailable(0);
				throw new NotEnoughActionsException("No action points available");
			
		}
		this.setTarget(c);
		int x=this.getCurrentHp()-c.getAttackDmg();
		this.setCurrentHp(x);
			int y=c.getCurrentHp()-(this.getAttackDmg()/2);
			c.setCurrentHp(y);	
			if (this.getCurrentHp()==0)
				this.onCharacterDeath();
	}


}

