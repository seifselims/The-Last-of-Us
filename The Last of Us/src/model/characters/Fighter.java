package model.characters;

import exceptions.NoAvailableResourcesException;


public class Fighter extends Hero {

	public Fighter(String name, int maxHp, int attackDmg, int maxActions) {
		super(name, maxHp, attackDmg, maxActions);
		
	}
public void useSpecial() throws NoAvailableResourcesException {
	if(this.getSupplyInventory()!=null ) {
		setSpecialAction(true);
		this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);
	this.attack2();
    }

else {
	setSpecialAction(false);
	throw new NoAvailableResourcesException("No available resources");
}	
}

}
