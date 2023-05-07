package model.characters;
import java.awt.Point;
import java.util.ArrayList;

import engine.Game;
import exceptions.GameActionException;
import exceptions.InvalidTargetException;
import exceptions.NoAvailableResourcesException;
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

public void move  (Direction d)  {
	if(this.getActionsAvailable()>0)	{
	Point b=this.getLocation();
	this.setVisiblity(true);
		switch(d) {
		case UP:
			if((b.x>=0&&b.x<15)) {
				b.x+=1;
				this.setNewLoc(b);
			}	
		break;
		case DOWN:
			if((b.x>0&&b.x<=14)) {
				b.x-=1; 
			this.setNewLoc(b);
			}
		break;
		case RIGHT:
			if((b.y>0&&b.y<=14)) {
			b.y-=1;
			this.setNewLoc(b);
			}
		break;
		case LEFT:
			if((b.y>=0&&b.y<15)) {
			b.y+=1;
			this.setNewLoc(b);
			}
		break;
		}
		
			this.setVisiblity(true);
	int a=this.getActionsAvailable()-1;
	this.setActionsAvailable(a);
		}
	else
		return;
	}


public void cure() throws NoAvailableResourcesException, Exception {
	if(this.getActionsAvailable()>0)	{
	Zombie z=(Zombie)this.getTarget();
	if(this.adjacent(z)) {
		ArrayList<Vaccine> vaccine =this.getVaccineInventory();
		if(vaccine!=null) {
		((Collectible) vaccine).use(this);
		int a= this.getActionsAvailable()-1;
		this.setActionsAvailable(a);	
	}
		}
}
	else
		return;
}

public void useSpecial() throws NoAvailableResourcesException, Exception {
		if(this instanceof Medic) {
			this.curehero();
			this.cureself();
		}
		else if(this instanceof Explorer) {
			if(this.getSupplyInventory()!=null ) {
			setSpecialAction(true);
			this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);

		    }
		}
		else if(this instanceof Fighter) {
			if(this.getSupplyInventory()!=null) {
			setSpecialAction(true);
			this.attack2();
		    }
		}
		else {
			setSpecialAction(false);
		}	
}

	private void setNewLoc(Point b) {
		Cell targetCell=Game.map[b.x][b.y];
			if(targetCell instanceof TrapCell) {
				this.onCharacterDeath();
				if(this.getCurrentHp()>0) {
					this.setCurrentHp(this.getCurrentHp()-((TrapCell) targetCell).getTrapDamage());
					CharacterCell newCell=new CharacterCell(this);
					targetCell=newCell;
					b.setLocation(b);
				}
	}
	else if(targetCell instanceof CollectibleCell) {
		((Collectible) targetCell).pickUp(this);
		CharacterCell newCell=new CharacterCell(this);
		targetCell=newCell;	
		b.setLocation(b);
	}
	else if(targetCell instanceof CharacterCell) {
		return ;
	}
	else {
		CharacterCell newCell=new CharacterCell(null);
		targetCell=newCell;	
		b.setLocation(b);
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
		Cell i=Game.map[l.x][l.y];
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
}





