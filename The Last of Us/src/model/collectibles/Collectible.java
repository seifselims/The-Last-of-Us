package model.collectibles;

import model.characters.Hero;

public interface Collectible {
default void pickUp(Hero h){
	if (this instanceof Supply)
	h.getSupplyInventory().add((Supply)this);
	else
	h.getVaccineInventory().add((Vaccine)this);
}
 default void use(Hero h) {
	if (this instanceof Supply)
		h.getSupplyInventory().remove((Supply)this);
	else
		h.getVaccineInventory().remove((Vaccine)this);
}
}
