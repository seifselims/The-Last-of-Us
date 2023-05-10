package model.collectibles;

import java.awt.Point;

import engine.Game;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import model.characters.Hero;
import model.world.CharacterCell;

public class Vaccine implements Collectible {
public Vaccine() {
}
public void pickUp(Hero h) {
	h.getVaccineInventory().add((Vaccine)this);
}
public void use(Hero h)throws NoAvailableResourcesException, MovementException {
	if(h.getVaccineInventory().size()!=0){
	h.getVaccineInventory().remove((Vaccine)this);
	Point l=h.getTarget().getLocation();
	Game.zombies.remove(h.getTarget());
	Game.map[l.x][l.y]=new CharacterCell(null);
	for(int i=0;i<Game.availableHeroes.size();i++) {
	if(!(Game.availableHeroes.get(i).equals(h))) {
	Game.heroes.add(Game.availableHeroes.get(i));
	Game.map[l.x][l.y]=new CharacterCell(Game.availableHeroes.get(i));
	Game.availableHeroes.get(i).setLocation(l);
	Game.availableHeroes.remove(Game.availableHeroes.get(i));
	break;
	}
	}
	}
	else {
		throw new NoAvailableResourcesException("No resources available"); 
	}

}
}
