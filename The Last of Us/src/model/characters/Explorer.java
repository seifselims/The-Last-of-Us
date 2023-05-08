package model.characters;

import engine.Game;
import exceptions.NoAvailableResourcesException;

public class Explorer extends Hero {

	public Explorer(String name, int maxHp, int attackDmg, int maxActions) {
		super(name, maxHp, attackDmg, maxActions);
	}
public void useSpecial() throws NoAvailableResourcesException {
	if(this.getSupplyInventory()!=null ) {
		setSpecialAction(true);
		this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);

	    
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				Game.map[i][j].setVisible(true);
			}
		}
	}
		else {
			setSpecialAction(false);
			throw new NoAvailableResourcesException("No available resources");
		}	
	}
}

