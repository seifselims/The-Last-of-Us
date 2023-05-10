package model.characters;

import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;


public class Fighter extends Hero {

	public Fighter(String name, int maxHp, int attackDmg, int maxActions) {
		super(name, maxHp, attackDmg, maxActions);
		
	}
public void useSpecial() throws NoAvailableResourcesException, NotEnoughActionsException {
	
	if(this.getSupplyInventory().size()==0 ) {
	setSpecialAction(false);
	throw new NoAvailableResourcesException("No available resources");	}
	else {
		setSpecialAction(true);
		this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);
	this.attack2();
	}
}

@Override
public void pickUp(Hero h) {
	// TODO Auto-generated method stub
	
}
@Override
public void use(Hero h) throws NoAvailableResourcesException {
	// TODO Auto-generated method stub
	
}
}
