package model.characters;
import java.awt.Point;

import engine.Game;
import model.world.CharacterCell;

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
	if(l.x>14 || l.x<0)
		return false;
	else if (l.y>14 || l.y<0)
		return false;
	else if (l2.x>14 ||l2.x<0)
		return false;
	else if (l2.y>14 || l2.y<0)
		return false;
	if (l.x==0 || l.x==14) {
		if(l2.y==l.y-1 || l2.y==l.y+1 || (l2.x==1 && (l2.y==l.y+1 || l2.y==l.y-1)))
			return true;
		else
			return false;
	}
	else if (l.y==0 || l.y==14) {
		if(l2.x==l.x-1 || l2.x==l.x+1 || (l2.y==1 && (l2.x==l.x+1 || l2.x==l.x-1)))
			return true;
		else
			return false;
	}
	else if(((l2.x==l.x+1||l2.x==l.x-1) && l2.y==l.y)|| ((l2.y==l.y+1 || l2.y==l.y-1) && l2.x==l.x )|| (l2.x==l.x+1 && (l2.y==l.y+1 || l2.y==l.y-1)) || (l2.x==l.x-1 && (l2.y==l.y-1 || l2.y==l.y+1)))
			return true;
	else
		return false;
}
public void attack() {
	Character e= this.getTarget();
	if (this.adjacent(e)){
	if (this instanceof Hero) {
	Hero h=(Hero) this;
	int a=h.getActionsAvailable()-1;
	h.setActionsAvailable(a);
	if (a<0){
		h.setActionsAvailable(0);
		return;
	}
}
	e.defend(this);
	}
}

public void defend(Character c) {
	if (this instanceof Hero) {
		Hero h=(Hero) this;
		int a=h.getActionsAvailable()-1;
		h.setActionsAvailable(a);
		if (a<0){
			h.setActionsAvailable(0);
			return;
		}
	}
	this.setTarget(c);
	int x=this.getCurrentHp()-c.attackDmg;
	this.setCurrentHp(x);
	if (this.getCurrentHp()==0)
		this.onCharacterDeath();
	else {
		int y=c.getCurrentHp()-(this.attackDmg/2);
		c.setCurrentHp(y);	
	}
}
public void onCharacterDeath(){
	if (this.getCurrentHp()==0) {
		if (this instanceof Hero)
		{
			Game.availableHeroes.remove(this);
			this.setLocation(null);
		}
		else {
			Game.zombies.remove(this);
			this.setLocation(null);
		}
	}
}
}
