package model.characters;
import java.awt.Point;
import java.util.ArrayList;

import engine.Game;
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

public void move (Direction d)  {
		Point b=this.getLocation();
		switch(d) {
		case UP:
			if((b.y>=0&&b.y<15)) {
				b.y+=1;
				this.setNewLoc(b);
			}	
		break;
		case DOWN:
			if((b.y>0&&b.y<=15)) {
				b.y-=1; 
			this.setNewLoc(b);
			}
		break;
		case RIGHT:
			if((b.x>0&&b.x<=15)) {
			b.x-=1;
			this.setNewLoc(b);
			}
		break;
		case LEFT:
			if((b.x>=0&&b.x<15)) {
			b.x+=1;
			this.setNewLoc(b);
			}
		break;
		}
		if(this.adjacent(this)) {
			Cell.setVisible(true);
		}
	int a=this.getActionsAvailable()-1;
	this.setActionsAvailable(a);
	if (a<0){
		this.setActionsAvailable(0);
		return;
		}
	}


public void cure() {
	Zombie z=new Zombie();
	if(this.adjacent(z)) {
		ArrayList<Vaccine> vaccine =this.getVaccineInventory();
		if(vaccine!=null) {
		((Collectible) vaccine).use(this);
		int a= this.getActionsAvailable()-1;
		this.setActionsAvailable(a);	
		if (a<0){
			this.setActionsAvailable(0);
			return;
			}	
	}
		}	
}

public void useSpecial() {
		if(this instanceof Medic) {
			if(getCurrentHp()<getMaxHp() && this.adjacent(this)) {
				setSpecialAction(true);
			    this.cure();
			    int s= this.getSupplyInventory().size();
			    s-=1;
			    this.setCurrentHp(getMaxHp());
			}
			else {
				setSpecialAction(false);
			}
		}
		if(this instanceof Explorer) {
			if(this.getSupplyInventory()!=null ) {
			setSpecialAction(true);
			Cell.isVisible();
			int s= this.getSupplyInventory().size();
		    s-=1;
		    }
		}
		else {
			setSpecialAction(false);
		}
		if(this instanceof Fighter) {
			if(this.getSupplyInventory()!=null && this.getActionsAvailable()!=0) {
			setSpecialAction(true);
			this.attack();
			int a=this.getActionsAvailable()+1;
			this.setActionsAvailable(a);
			int s= this.getSupplyInventory().size();
		    s-=1;
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
}





