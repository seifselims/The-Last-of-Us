package model.characters;
import java.awt.Point;
import java.util.ArrayList;

import engine.Game;
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

//public void move  (Direction d) throws MovementException, NotEnoughActionsException  {
//	if(this.getActionsAvailable()==0)
//		throw new NotEnoughActionsException("No enough action points available");
//	else {
//		int a=this.getActionsAvailable()-1;
//		this.setActionsAvailable(a);
//	Point b=this.getLocation();
//		switch(d) {
//		case UP:
//			if((b.x>=0&&b.x<14)) {
//				Point x=new Point(b.x+1,b.y);
//				this.setNewLoc(x);
//			}
//			else throw new MovementException("Out of borders");
//		break;
//		case DOWN:
//			if((b.x>0&&b.x<=14)) {
//				Point x=new Point(b.x-1,b.y);
//			this.setNewLoc(x);
//			}
//			else throw new MovementException("Out of borders");
//
//		break;
//		case RIGHT:
//			if((b.y>=0&&b.y<14)) {
//			Point x=new Point(b.x,b.y+1);
//			this.setNewLoc(x);
//
//			}
//			else throw new MovementException("Out of borders");
//
//		break;
//		case LEFT:
//			if((b.y>0&&b.y<=14)) {
//				Point x=new Point(b.x,b.y-1);
//			this.setNewLoc(x);
//
//			}
//			else throw new MovementException("Out of borders");
//		break;
//		}
//		
////			this.setVisiblity(true);
//		}
//	}


public void cure() throws NoAvailableResourcesException, InvalidTargetException, NotEnoughActionsException, MovementException  {
	
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
				int a= this.getActionsAvailable()-1;
				this.setActionsAvailable(a);
				(this.getVaccineInventory().get(0)).use(this);
				
			}
				}
			else
				throw new InvalidTargetException ("Target is not adjacent");
		}
			
}

public abstract void useSpecial() throws NoAvailableResourcesException, Exception;


	
public void move(Direction d) throws NotEnoughActionsException, MovementException {
	if(this.getActionsAvailable()==0)
		throw new NotEnoughActionsException ("Cannot move without Action Pts");
	else {
		this.setActionsAvailable(this.getActionsAvailable()-1);
		switch(d) {
			case UP:
				if(this.getLocation().x>=0 && this.getLocation().x<14) {
					Point y=new Point(this.getLocation().x+1,this.getLocation().y);
					this.newloc(y);
					
				}
				else throw new MovementException("Cannot move out of map");
				break;
			case DOWN:
				if(this.getLocation().x>0 && this.getLocation().x<=14) {
					Point y=new Point(this.getLocation().x-1,this.getLocation().y);
					this.newloc(y);
				}
				else throw new MovementException("Cannot move out of map");
				break;
			case RIGHT:
				if(this.getLocation().y>=0 && this.getLocation().y<14) {
					Point y=new Point(this.getLocation().x,this.getLocation().y+1);
					this.newloc(y);
				}
				else throw new MovementException("Cannot move out of map");
				break;
			case LEFT:
				if(this.getLocation().y>0 && this.getLocation().y<=14) {
					Point y=new Point(this.getLocation().x,this.getLocation().y-1);
					this.newloc(y);
				}
				else throw new MovementException("Cannot move out of map");
				break;
				
				
				
			
		}
	}
	if(this.getCurrentHp()==0)
		this.onCharacterDeath();
}
	public void attack2() throws NotEnoughActionsException {
		if (this.specialAction==true){
//		Zombie e= (Zombie)this.getTarget();
		this.getTarget().setTarget(this);
		int x=this.getTarget().getCurrentHp()-this.getAttackDmg();
		this.getTarget().setCurrentHp(x);
		
			int y=this.getCurrentHp()-(this.getTarget().getAttackDmg()/2);
			this.setCurrentHp(y);	
			if (this.getTarget().getCurrentHp()==0) {
				this.getTarget().onCharacterDeath();
			}
			else if(this.getCurrentHp()==0) {
				this.onCharacterDeath();
			}
			//		this.getTarget().defend(this);
		}
		else {
			if (this.actionsAvailable==0) {
				throw new NotEnoughActionsException("No action points");
			}
			else{
				this.setActionsAvailable(this.getActionsAvailable()-1);
				this.getTarget().defend(this);
			}
				
		}
			
	}
	public void attack() throws NotEnoughActionsException, InvalidTargetException {
		
		if (this.getTarget()==null || (this.getTarget() instanceof Hero) )
			throw new InvalidTargetException("Character does not have a Zombie target");
		Character e= this.getTarget();
		if (this.adjacent(e)){
		if (this.getTarget() instanceof Zombie) {
			if (this instanceof Fighter) {
				this.attack2();
				
			}
			else {
		int a=this.getActionsAvailable()-1;
		this.setActionsAvailable(a);
		if (a<0){
			this.setActionsAvailable(0);
			throw new NotEnoughActionsException("Not enough Action points available");
		}
		else
			super.attack();
				
		
		} }
	}
		else throw new InvalidTargetException("Target cell is not adjacent");
}
	public void defend(Character c)  {
		this.setTarget(c);
		int x=this.getCurrentHp()-c.getAttackDmg();
		this.setCurrentHp(x);
			int y=c.getCurrentHp()-(this.getAttackDmg()/2);
			c.setCurrentHp(y);	
			if (this.getCurrentHp()==0) {
				this.onCharacterDeath();
				
			}
			if(c.getCurrentHp()==0) {
				c.onCharacterDeath();
				
			}
			
			
			
	}
	public void newloc(Point y) throws MovementException {
		if(Game.map[y.x][y.y] instanceof TrapCell) {
			Point x=this.getLocation();
			this.setLocation(y);
			this.setCurrentHp(this.getCurrentHp()-((TrapCell)Game.map[y.x][y.y]).getTrapDamage());
			if (this.getCurrentHp()==0) {
				Game.map[y.x][y.y]=new CharacterCell(this);
				this.setVisiblity(false);
				Game.map[x.x][x.y]=new CharacterCell(null);
//				((CharacterCell)Game.map[this.getLocation().x][this.getLocation().y]).setCharacter(null);
//				this;
				this.onCharacterDeath();
				
			return;}
			Game.map[x.x][x.y]=new CharacterCell(null);
//			((CharacterCell)Game.map[this.getLocation().x][this.getLocation().y]).setCharacter(null);
			this.setLocation(y);
			Game.map[y.x][y.y]=new CharacterCell(this);
			((CharacterCell)Game.map[y.x][y.y]).setCharacter(this);
			if(this.getCurrentHp()==0) {
				
				this.setVisiblity(false);
				this.onCharacterDeath();
			}
			else
				this.setVisiblity(true);
			
		}
		else if(Game.map[y.x][y.y] instanceof CollectibleCell) {
			((CollectibleCell)Game.map[y.x][y.y]).getCollectible().pickUp(this);
			Game.map[this.getLocation().x][this.getLocation().y]=new CharacterCell(null);
			((CharacterCell)Game.map[this.getLocation().x][this.getLocation().y]).setCharacter(null);
			this.setLocation(y);
			Game.map[y.x][y.y]=new CharacterCell(this);
			((CharacterCell)Game.map[y.x][y.y]).setCharacter(this);
			this.setVisiblity(true);
		}
		else if(Game.map[y.x][y.y] instanceof CharacterCell) {
			if(((CharacterCell)Game.map[y.x][y.y]).getCharacter()!=null) {
				throw new MovementException("Cannot move to an occupied cell");
			}
			else {
				Game.map[this.getLocation().x][this.getLocation().y]=new CharacterCell(null);
				((CharacterCell)Game.map[this.getLocation().x][this.getLocation().y]).setCharacter(null);
				this.setLocation(y);
				Game.map[y.x][y.y]=new CharacterCell(this);
				((CharacterCell)Game.map[y.x][y.y]).setCharacter(this);
				if(this.getCurrentHp()==0) {
					
					this.setVisiblity(false);
				}
				else
					this.setVisiblity(true);
			}
		}	
	}
	public String herotype() {
		if(this instanceof Fighter) 
			return "Fighter";
		else if(this instanceof Medic)
			return "Medic";
		else
			return "Explorer";
	}
	


}

