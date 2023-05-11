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

public void move  (Direction d) throws MovementException, NotEnoughActionsException  {
	if(this.getActionsAvailable()==0)
		throw new NotEnoughActionsException("No enough action points available");
	else {
		int a=this.getActionsAvailable()-1;
		this.setActionsAvailable(a);
	Point b=this.getLocation();
		switch(d) {
		case UP:
			if((b.x>=0&&b.x<14)) {
				Point x=new Point(b.x+1,b.y);
				this.setNewLoc(x);
			}
			else throw new MovementException("Out of borders");
		break;
		case DOWN:
			if((b.x>0&&b.x<=14)) {
				Point x=new Point(b.x-1,b.y);
			this.setNewLoc(x);
			}
			else throw new MovementException("Out of borders");

		break;
		case RIGHT:
			if((b.y>=0&&b.y<14)) {
			Point x=new Point(b.x,b.y+1);
			this.setNewLoc(x);

			}
			else throw new MovementException("Out of borders");

		break;
		case LEFT:
			if((b.y>0&&b.y<=14)) {
				Point x=new Point(b.x,b.y-1);
			this.setNewLoc(x);

			}
			else throw new MovementException("Out of borders");
		break;
		}
		
//			this.setVisiblity(true);
		}
	}


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

	public void setNewLoc(Point b) throws MovementException {
		Cell targetCell=Game.map[b.x][b.y];
		int x=this.getLocation().x;
		int y=this.getLocation().y;
			if(targetCell instanceof TrapCell) {
					this.setCurrentHp(this.getCurrentHp()-((TrapCell) targetCell).getTrapDamage());
					this.setLocation(b);
					CharacterCell newCell=new CharacterCell(this);
					targetCell.setVisible(true);
					Game.map[b.x][b.y] = newCell;
					targetCell=newCell;
					Game.map[x][y] = new CharacterCell(null);
					if(this.getCurrentHp()==0) {
						this.onCharacterDeath();
						this.setVisiblity(false);
						}
					else {
						this.setVisiblity(true);
					}
				
	}
	else if(targetCell instanceof CollectibleCell) {
		((CollectibleCell) targetCell).getCollectible().pickUp(this);
		this.setLocation(b);
		CharacterCell newCell=new CharacterCell(this);
		targetCell.setVisible(true);
		Game.map[b.x][b.y] = newCell;
		targetCell=newCell;	
		Game.map[x][y] = new CharacterCell(null);
		this.setVisiblity(true);

	}
	else if(targetCell instanceof CharacterCell) {
		if (((CharacterCell) targetCell).getCharacter()==null) {
			this.setLocation(b);
			CharacterCell newCell=new CharacterCell(this);
			targetCell.setVisible(true);
			Game.map[b.x][b.y] = newCell;
			targetCell=newCell;	
			Game.map[x][y] = new CharacterCell(null);
			if(this.getCurrentHp()==0) {
				this.onCharacterDeath();
				this.setVisiblity(false);
				}
			else {
				this.setVisiblity(true);
			}
		}
		else	
		throw new MovementException("Cell is occupied");
	}
	
	}
	
	public void attack2() throws NotEnoughActionsException {
		if (this.specialAction==true){
		Zombie e= (Zombie)this.getTarget();
		e.setCurrentHp(e.getCurrentHp()-this.getAttackDmg());}
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
	
/*	public static void main (String [] args) throws MovementException, NotEnoughActionsException {
		Fighter x=new Fighter("Batman",100,22,294);
		x.setLocation(new Point(12,12));
		Game.map[14][0]=new CharacterCell(x);
		x.move(Direction.UP);
		System.out.prinln(x.getLocation());
		
		
	}*/

}

