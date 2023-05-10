package model.characters;
import java.awt.Point;
import java.util.ArrayList;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;
import model.world.Cell;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;

abstract public class Character {
private String name;
private Point location;
private int maxHp;
private int currentHp;
private int attackDmg;
private Character target;
public Character(String name, int maxHp, int attackDmg) {
	this.name=name;
	this.maxHp=maxHp;
	this.attackDmg=attackDmg;
	this.currentHp=maxHp;
}
public Character() {
	
}
public Point getLocation() {
	return location;
}
public void setLocation(Point location) {
	this.location = location;
}
public int getCurrentHp() {
	return currentHp;
}
public void setCurrentHp(int currentHp) {
	this.currentHp=currentHp;
	if (this.currentHp<0)
	this.currentHp=0;
	if(this.currentHp>maxHp)
	this.currentHp=maxHp;
}
public Character getTarget() {
	return target;
}
public void setTarget(Character target) {
	this.target = target;
}
public String getName() {
	return name;
}
public int getMaxHp() {
	return maxHp;
}
public int getAttackDmg() {
	return attackDmg;
}
public boolean adjacent(Character e) {
	Point l=this.getLocation();
	Point l2=e.getLocation();
	if(l.x==14 && l.y==0){
		if (l2.x==l.x-1 && l2.y==l.y)
			return true;
		else if(l2.x==l.x && l2.y==l.y+1)
			return true;
		else if (l2.x==l.x-1 && l2.y==l.y+1)
			return true;
		else
			return false;
	}
	else if (l.x==14 && l.y==14){
		if (l2.x==l.x-1 && l2.y==l.y)
			return true;
		else if(l2.x==l.x && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x-1 && l2.y==l.y-1)
			return true;
		else
			return false;
	}
	else if (l.x==0&& l.y==0){
		if (l2.x==l.x+1 && l2.y==l.y)
			return true;
		else if(l2.x==l.x && l2.y==l.y+1)
			return true;
		else if (l2.x==l.x+1 && l2.y==l.y+1)
			return true;
		else
			return false;
	}
	else if (l.x==0&& l.y==14){
		if (l2.x==l.x+1 && l2.y==l.y)
			return true;
		else if(l2.x==l.x && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x+1 && l2.y==l.y-1)
			return true;
		else
			return false;
	}
	else if (l.x==0 && l.y>0 && l.y<14) {
		if (l2.x==l.x+1 && l2.y==l.y)
			return true;
		else if(l2.x==l.x && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x && l2.y==l.y+1)
			return true;
		else if (l2.x==l.x+1 && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x+1 && l2.y==l.y+1)
			return true;
		else
			return false;
	}
	else if (l.x==14 && l.y>0 && l.y<14) {
		if (l2.x==l.x-1 && l2.y==l.y)
			return true;
		else if(l2.x==l.x && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x && l2.y==l.y+1)
			return true;
		else if (l2.x==l.x-1 && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x-1 && l2.y==l.y+1)
			return true;
		else
			return false;
	}
	else if (l.y==0 && l.x>0 && l.x<14) {
		if (l2.x==l.x-1 && l2.y==l.y)
			return true;
		else if(l2.x==l.x+1 && l2.y==l.y)
			return true;
		else if (l2.x==l.x && l2.y==l.y+1)
			return true;
		else if (l2.x==l.x-1 && l2.y==l.y+1)
			return true;
		else if (l2.x==l.x+1 && l2.y==l.y+1)
			return true;
		else
			return false;
	}
	else if (l.y==14 && l.x>0 && l.x<14) {
		if (l2.x==l.x-1 && l2.y==l.y)
			return true;
		else if(l2.x==l.x+1 && l2.y==l.y)
			return true;
		else if (l2.x==l.x && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x-1 && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x+1 && l2.y==l.y-1)
			return true;
		else
			return false;
	}
	else {
		if (l2.x==l.x && l2.y==l.y+1)
			return true;
		else if(l2.x==l.x && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x+1 && l2.y==l.y)
			return true;
		else if (l2.x==l.x+1 && l2.y==l.y+1)
			return true;
		else if (l2.x==l.x+1 && l2.y==l.y-1)
			return true;
		else if (l2.x==l.x-1 && l2.y==l.y)
			return true;
		else if (l2.x==l.x-1 && l2.y==l.y+1)
			return true;
		else if (l2.x==l.x-1 && l2.y==l.y-1)
			return true;
		else
			return false;
	}
}
	
	
public void attack() throws NotEnoughActionsException, InvalidTargetException {
	this.target.defend(this);
}

public void defend(Character c) throws NotEnoughActionsException {
	this.setTarget(c);
	int x=this.getCurrentHp()-c.attackDmg;
	this.setCurrentHp(x);
	
		int y=c.getCurrentHp()-(this.getAttackDmg()/2);
		c.setCurrentHp(y);	
		if (this.getCurrentHp()==0) {
			this.onCharacterDeath();
		}
		else if(c.getCurrentHp()==0) {
			c.onCharacterDeath();
		}
		
}
public void onCharacterDeath(){
	if (this.getCurrentHp()==0) {
		if (this instanceof Hero)
		{
			Game.map[this.getLocation().x][this.getLocation().y]=new CharacterCell(null);
			Game.heroes.remove(this);
			this.setLocation(null);
		}
		else {
			Game.map[this.getLocation().x][this.getLocation().y]=null;
			Game.map[this.getLocation().x][this.getLocation().y]=new CharacterCell(null);
			this.setLocation(null);
			Game.zombies.remove(this);
			Zombie z=new Zombie();
			int random= (int) (Math.random()*(14-0+1)+0);
			int random1=(int)(Math.random()*(14-0+1)+0);
			boolean flag=true;
			do{
				 random = (int)(Math.random()*(14-0+1)+0);  
				 random1 = (int)(Math.random()*(14-0+1)+0); 
				 if(Game.map[random][random1] instanceof TrapCell || Game.map[random][random1] instanceof CollectibleCell)
					 flag=true;
				 else if (((CharacterCell)Game.map[random][random1]).getCharacter() != null) {
					 flag=true;
				 }
				 else
					 flag=false;
			}while(flag);
			((CharacterCell)Game.map[random][random1]).setCharacter(z);
			CharacterCell charzombie= new CharacterCell(z);
			Game.map[random][random1]=charzombie;
			Game.zombies.add(z);
		}
	}
}
public ArrayList<Point> adjcells() {
		Point l=this.getLocation();
		ArrayList<Point>adjCells=new ArrayList<Point>();
		if(l.x==14 && l.y==0){
			adjCells.add(new Point(l.x-1,l.y));
			adjCells.add(new Point(l.x,l.y+1));
			adjCells.add(new Point(l.x-1,l.y+1));
		}
		else if(l.x==14 && l.y==14) {
			adjCells.add(new Point(l.x-1,l.y));
			adjCells.add(new Point(l.x,l.y-1));
			adjCells.add(new Point(l.x-1,l.y-1));
		}
		else if(l.x==0 && l.y==0) {
			adjCells.add(new Point(l.x+1,l.y));
			adjCells.add(new Point(l.x,l.y+1));
			adjCells.add(new Point(l.x+1,l.y+1));
		}
		else if (l.x==0 && l.y==14) {
			adjCells.add(new Point(l.x+1,l.y));
			adjCells.add(new Point(l.x,l.y-1));
			adjCells.add(new Point(l.x+1,l.y-1));
		}
		else if (l.x==0 && l.y>0 && l.y<14) {
			adjCells.add(new Point(l.x+1,l.y));
			adjCells.add(new Point(l.x,l.y-1));
			adjCells.add(new Point(l.x,l.y+1));
			adjCells.add(new Point(l.x+1,l.y-1));
			adjCells.add(new Point(l.x+1,l.y+1));

		}
		else if (l.x==14 && l.y>0 && l.y<14) {
			adjCells.add(new Point(l.x-1,l.y));
			adjCells.add(new Point(l.x,l.y-1));
			adjCells.add(new Point(l.x,l.y+1));
			adjCells.add(new Point(l.x-1,l.y-1));
			adjCells.add(new Point(l.x-1,l.y+1));

		}
		else if (l.y==0 && l.x>0 && l.x<14) {
			adjCells.add(new Point(l.x-1,l.y));
			adjCells.add(new Point(l.x+1,l.y));
			adjCells.add(new Point(l.x,l.y+1));
			adjCells.add(new Point(l.x-1,l.y+1));
			adjCells.add(new Point(l.x+1,l.y+1));

		}
		else if (l.y==14 && l.x>0 && l.x<14) {
			adjCells.add(new Point(l.x-1,l.y));
			adjCells.add(new Point(l.x+1,l.y));
			adjCells.add(new Point(l.x,l.y-1));
			adjCells.add(new Point(l.x-1,l.y-1));
			adjCells.add(new Point(l.x+1,l.y-1));

		}
		else {
			adjCells.add(new Point(l.x,l.y+1));
			adjCells.add(new Point(l.x,l.y-1));
			adjCells.add(new Point(l.x+1,l.y));
			adjCells.add(new Point(l.x+1,l.y+1));
			adjCells.add(new Point(l.x+1,l.y-1));
			adjCells.add(new Point(l.x-1,l.y));
			adjCells.add(new Point(l.x-1,l.y-1));
			adjCells.add(new Point(l.x-1,l.y+1));

		}
	
return adjCells;
}
public void setVisiblity(boolean bool) {
	Point l=this.getLocation();
	
	if(l.x==14 && l.y==0){
		Game.map[l.x][l.y].setVisible(bool);
		Game.map[l.x-1][l.y].setVisible(bool);
		Game.map[l.x][l.y+1].setVisible(bool);
		Game.map[l.x-1][l.y+1].setVisible(bool);
	}
	else if(l.x==14 && l.y==14) {
		Game.map[l.x][l.y].setVisible(bool);
		Game.map[l.x-1][l.y].setVisible(bool);
		Game.map[l.x][l.y-1].setVisible(bool);
		Game.map[l.x-1][l.y-1].setVisible(bool);
	}
	else if(l.x==0 && l.y==0) {
		Game.map[l.x][l.y].setVisible(bool);
		Game.map[l.x+1][l.y].setVisible(bool);
		Game.map[l.x][l.y+1].setVisible(bool);
		Game.map[l.x+1][l.y+1].setVisible(bool);
	}
	else if (l.x==0 && l.y==14) {
		Game.map[l.x][l.y].setVisible(bool);
		Game.map[l.x+1][l.y].setVisible(bool);
		Game.map[l.x][l.y-1].setVisible(bool);
		Game.map[l.x+1][l.y-1].setVisible(bool);
	}
	else if (l.x==0 && l.y>0 && l.y<14) {
		Game.map[l.x][l.y].setVisible(bool);
		Game.map[l.x+1][l.y].setVisible(bool);
		Game.map[l.x][l.y-1].setVisible(bool);
		Game.map[l.x][l.y+1].setVisible(bool);
		Game.map[l.x+1][l.y-1].setVisible(bool);
		Game.map[l.x+1][l.y+1].setVisible(bool);

	}
	else if (l.x==14 && l.y>0 && l.y<14) {
		Game.map[l.x][l.y].setVisible(bool);
		Game.map[l.x-1][l.y].setVisible(bool);
		Game.map[l.x][l.y-1].setVisible(bool);
		Game.map[l.x][l.y+1].setVisible(bool);
		Game.map[l.x-1][l.y-1].setVisible(bool);
		Game.map[l.x-1][l.y+1].setVisible(bool);

	}
	else if (l.y==0 && l.x>0 && l.x<14) {
		Game.map[l.x][l.y].setVisible(bool);
		Game.map[l.x-1][l.y].setVisible(bool);
		Game.map[l.x+1][l.y].setVisible(bool);
		Game.map[l.x][l.y+1].setVisible(bool);
		Game.map[l.x-1][l.y+1].setVisible(bool);
		Game.map[l.x+1][l.y+1].setVisible(bool);

	}
	else if (l.y==14 && l.x>0 && l.x<14) {
		Game.map[l.x][l.y].setVisible(bool);
		Game.map[l.x-1][l.y].setVisible(bool);
		Game.map[l.x+1][l.y].setVisible(bool);
		Game.map[l.x][l.y-1].setVisible(bool);
		Game.map[l.x-1][l.y-1].setVisible(bool);
		Game.map[l.x+1][l.y-1].setVisible(bool);

	}
	else {
		Game.map[l.x][l.y].setVisible(bool);
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
/*public static void main (String [] args) {
	Fighter x=new Fighter("Batman",100,22,294);
	x.setLocation(new Point(12,12));
	Game.map[14][0]=new CharacterCell(x);
	System.out.print(x.adjcells());
	
	
}*/
}