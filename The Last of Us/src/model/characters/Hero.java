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
	if(this.getActionsAvailable()==0)
		throw new NotEnoughActionsException("No enough action points available");
	else {
	Point b=this.getLocation();
	this.setVisiblity(true);
		switch(d) {
		case UP:
			if((b.x>=0&&b.x<14)) {
				Point x=new Point(b.x+1,b.y);
				b.x+=1;
				this.setNewLoc(x);
				this.setVisiblity(true);
			}
			else throw new MovementException("Out of borders");
		break;
		case DOWN:
			if((b.x>0&&b.x<=14)) {
				Point x=new Point(b.x-1,b.y);
			this.setNewLoc(x);
			if(this.getCurrentHp()==0)
				this.onCharacterDeath();
			else
			this.setVisiblity(true);

			}
			else throw new MovementException("Out of borders");

		break;
		case RIGHT:
			if((b.y>0&&b.y<14)) {
				Point x=new Point(b.x,b.y+1);
			this.setNewLoc(x);
			this.setVisiblity(true);

			}
			else throw new MovementException("Out of borders");

		break;
		case LEFT:
			if((b.y>0&&b.y<15)) {
				Point x=new Point(b.x,b.y-1);
			this.setNewLoc(x);
			this.setVisiblity(true);

			}
			else throw new MovementException("Out of borders");
		break;
		}
		
			this.setVisiblity(false);
	int a=this.getActionsAvailable()-1;
	this.setActionsAvailable(a);
		}
	}


public void cure() throws NoAvailableResourcesException, Exception {
	
	if (this.getTarget()==null || !(this.getTarget() instanceof Zombie))
		throw new InvalidTargetException("You should cure a Zombie");
	else
		if(this.getActionsAvailable()==0)	
			throw new NotEnoughActionsException("No action points available");
		else {		
	if(this.adjacent(this.getTarget())) {
				if(this.getVaccineInventory().size()==0)
				throw new NoAvailableResourcesException("No Vaccine available.");
				else {
				((Collectible) this.getVaccineInventory()).use(this);
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
			
}

public abstract void useSpecial() throws NoAvailableResourcesException, Exception;

	private void setNewLoc(Point b) throws MovementException {
		Cell targetCell=Game.map[b.x][b.y];
			if(targetCell instanceof TrapCell) {
					this.setCurrentHp(this.getCurrentHp()-((TrapCell) targetCell).getTrapDamage());
					Game.map[this.getLocation().x][this.getLocation().y] = new CharacterCell(null);
					CharacterCell newCell=new CharacterCell(this);
					targetCell=newCell;
					this.setLocation(b);
					if(this.getCurrentHp()==0) {
						this.onCharacterDeath();
						}
				
	}
	else if(targetCell instanceof CollectibleCell) {
		((Collectible) targetCell).pickUp(this);
		Game.map[this.getLocation().x][this.getLocation().y] = new CharacterCell(null);
		CharacterCell newCell=new CharacterCell(this);
		targetCell=newCell;	
		this.setLocation(b);
	}
	else if(targetCell instanceof CharacterCell) {
		if (((CharacterCell) targetCell).getCharacter()==null) {
			Game.map[this.getLocation().x][this.getLocation().y] = new CharacterCell(null);
			CharacterCell newCell=new CharacterCell(this);
			targetCell=newCell;	
			this.setLocation(b);
		}
		else	
		throw new MovementException("Cell is occupied");
	}
	
	}
	
	public void attack2() throws NotEnoughActionsException {
		Zombie e= (Zombie)this.getTarget();
		e.setCurrentHp(e.getCurrentHp()-this.getAttackDmg());
	}
	public void attack() throws NotEnoughActionsException, InvalidTargetException {
		if (this.getTarget()==null || (this.getTarget() instanceof Hero) )
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
		if (a<0){
			this.setActionsAvailable(0);
			throw new NotEnoughActionsException("Not enough Action points available");
		}
		else
			e.defend(this);
		
		} }
	}
		else throw new InvalidTargetException("Target cell is not adjacent");
}
	public void defend(Character c) throws NotEnoughActionsException {
		this.setTarget(c);
		int x=this.getCurrentHp()-c.getAttackDmg();
		this.setCurrentHp(x);
		
			int y=c.getCurrentHp()-(this.getAttackDmg()/2);
			c.setCurrentHp(y);	
			if (this.getCurrentHp()==0) {
				this.onCharacterDeath();
				return;
			}
			
			
			
	}


}

