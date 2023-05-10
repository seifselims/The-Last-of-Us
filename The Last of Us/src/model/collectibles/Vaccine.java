package model.collectibles;

import engine.Game;
import exceptions.NoAvailableResourcesException;
import model.characters.Hero;

public class Vaccine implements Collectible {
public Vaccine() {
}
public void pickUp(Hero h) {
	h.getVaccineInventory().add((Vaccine)this);
}
public void use(Hero h)throws NoAvailableResourcesException {
	if(h.getVaccineInventory().size()!=0){
	h.getVaccineInventory().remove((Vaccine)this);
	h.setTarget(null);
	}
	else {
		throw new NoAvailableResourcesException("No resources available"); 
	}

}
}
