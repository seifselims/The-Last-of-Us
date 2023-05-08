package model.collectibles;

import exceptions.NoAvailableResourcesException;
import model.characters.Hero;

public interface Collectible {
default void pickUp(Hero h) {
	if (this instanceof Supply)
	h.getSupplyInventory().add((Supply)this);
	else
	h.getVaccineInventory().add((Vaccine)this);
}
 default void use(Hero h)throws NoAvailableResourcesException {
	if (this instanceof Supply) {
		if(h.getSupplyInventory().size()!=0)
		h.getSupplyInventory().remove((Supply)this);
		else {
			throw new NoAvailableResourcesException("No resources available"); 
		}
	}
	else {
		if(h.getVaccineInventory().size()!=0)
		h.getVaccineInventory().remove((Vaccine)this);
		else
			throw new NoAvailableResourcesException("No resources available");
	}
}
}
