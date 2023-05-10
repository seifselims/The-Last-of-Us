package model.characters;

import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;

 public class Zombie extends Character {
	static int ZOMBIES_COUNT;
public Zombie() {
	super("Zombie "+ ++ZOMBIES_COUNT,40,10);
}
public void attack() throws NotEnoughActionsException, InvalidTargetException {
	
	if(this.getTarget() instanceof Hero) {
		if(this.adjacent(this.getTarget()))
			super.attack();
			else
			throw new InvalidTargetException("Target is not adjacent");
	}


	
}
public void defend(Character c)  {
this.setTarget(c);
int x=this.getCurrentHp()-c.getAttackDmg();
this.setCurrentHp(x);
if (this.getCurrentHp()==0)
	this.onCharacterDeath();
else {
	int y=c.getCurrentHp()-(this.getAttackDmg()/2);
	c.setCurrentHp(y);
	if (c.getCurrentHp()==0){
		c.onCharacterDeath();
	}
}
}
}
