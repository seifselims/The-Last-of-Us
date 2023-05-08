package model.characters;

import exceptions.NoAvailableResourcesException;


public class Medic extends Hero {
	public Medic(String name, int maxHp, int attackDmg, int maxActions) {
		super(name, maxHp, attackDmg, maxActions);

}
	public void useSpecial() throws NoAvailableResourcesException, Exception {
		if(this instanceof Medic) {
			if(this.getSupplyInventory()!=null ) {
				setSpecialAction(true);
				this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);
			    
			this.curehero();
			this.cureself();
		} }
		else {
			setSpecialAction(false);
			throw new NoAvailableResourcesException("No available resources");
		}	
		}
	}
	
