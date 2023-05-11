package model.characters;

import java.util.ArrayList;

import model.world.CharacterCell;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;

 public class Zombie extends Character {
	static int ZOMBIES_COUNT;
public Zombie() {
	super("Zombie "+ ++ZOMBIES_COUNT,40,10);
}
public void attack() throws NotEnoughActionsException, InvalidTargetException {
if((this.getTarget() instanceof Zombie))
	throw new InvalidTargetException("Target is not a hero");
else if(this.getTarget() instanceof Hero) {
//		if(!(this.adjacent(this.getTarget())))
//			throw new InvalidTargetException("Target is not adjacent");
//			else
				super.attack();
	}
else if(this.getTarget()==null ) {
	ArrayList<java.awt.Point> x=this.adjcells();
	for(int i=0;i<x.size();i++) {
		if(Game.map[x.get(i).x][x.get(i).y] instanceof CharacterCell) {
			if(((CharacterCell)Game.map[x.get(i).x][x.get(i).y]).getCharacter() instanceof Hero) {
				this.setTarget(((CharacterCell)Game.map[x.get(i).x][x.get(i).y]).getCharacter());
				super.attack();
				break;
			}
		}
	}
}
}
//public void attackz() throws NotEnoughActionsException  {
//	if(this.getTarget()==null || (!(this.getTarget() instanceof Hero))) {
//		java.awt.Point o=this.adjcells().get(0);
//		CharacterCell x=((CharacterCell)Game.map[o.x][o.y]);
//		this.setTarget(x.getCharacter());
//		this.getTarget().defend(this);
//	}
//	}
public void defend(Character c)  {
this.setTarget(c);
 {int x=this.getCurrentHp()-c.getAttackDmg();
this.setCurrentHp(x);
	int y=c.getCurrentHp()-(this.getAttackDmg()/2);
	c.setCurrentHp(y);
	if (this.getCurrentHp()==0)
		this.onCharacterDeath();
	if (c.getCurrentHp()==0){
		c.onCharacterDeath();
	}
}
}
}
