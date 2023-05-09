package model.characters;

import java.util.ArrayList;

import model.collectibles.Collectible;
import model.collectibles.Supply;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;


public class Medic extends Hero {
	public Medic(String name, int maxHp, int attackDmg, int maxActions) {
		super(name, maxHp, attackDmg, maxActions);

}
	public void useSpecial() throws NoAvailableResourcesException, NotEnoughActionsException  {
		if(this.getActionsAvailable() == 0)
		{
			throw new NotEnoughActionsException();
		}
		else {	
		if(this.getSupplyInventory().size()==0) {
			setSpecialAction(false);
			throw new NoAvailableResourcesException("No available resources");
		}
			else {
				setSpecialAction(true);
				this.getSupplyInventory().remove(this.getSupplyInventory().size()-1);
			    
			this.curehero();
			this.cureself();
			}
		}
	}
	public void curehero() throws NoAvailableResourcesException {
		if (this instanceof Medic) {
		if (this.getTarget() instanceof Hero && this.adjacent(this.getTarget()) ) {
			Hero x=(Hero) this.getTarget();
			x.setCurrentHp(x.getMaxHp());
		}
	
		ArrayList<Supply> supply =this.getSupplyInventory();
		if(supply!=null) {
		((Collectible) supply).use(this);
		this.setSpecialAction(true);}
		}
		else
			return;
}
	public void cureself() throws NoAvailableResourcesException {
		if (this instanceof Medic) {
			if(this.getCurrentHp()!=this.getMaxHp())
				this.setCurrentHp(this.getMaxHp());
			ArrayList<Supply> supply =this.getSupplyInventory();
			if(supply!=null) {
			((Collectible) supply).use(this);
			this.setSpecialAction(true); }
			}
		else
			return;
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
	
