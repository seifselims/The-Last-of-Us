package model.characters;

import engine.Game;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;

public class Explorer extends Hero {

	public Explorer(String name, int maxHp, int attackDmg, int maxActions) {
		super(name, maxHp, attackDmg, maxActions);
	}
public void useSpecial() throws NoAvailableResourcesException, NotEnoughActionsException {
	if(this.getActionsAvailable() == 0)
	{
		throw new NotEnoughActionsException();
	}
	else {
	if(this.getSupplyInventory().size()==0 ) {
		setSpecialAction(false);
			throw new NoAvailableResourcesException("No available resources");
		}
	else {
		setSpecialAction(true);
		this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);

	    
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				Game.map[i][j].setVisible(true);
			}
		}
	}
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

