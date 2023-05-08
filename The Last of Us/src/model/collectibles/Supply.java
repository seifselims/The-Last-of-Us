package model.collectibles;

import exceptions.NoAvailableResourcesException;
import model.characters.Hero;


public class Supply implements Collectible {

public Supply () {
}
public void pickUp(Hero h) {
	h.getSupplyInventory().add((Supply)this);
}
public void use(Hero h)throws NoAvailableResourcesException {
		if(h.getSupplyInventory().size()!=0)
		h.getSupplyInventory().remove((Supply)this);
		else {
			throw new NoAvailableResourcesException("No resources available"); 
		}
}
}

