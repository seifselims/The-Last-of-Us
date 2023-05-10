package model.characters;


import model.collectibles.Collectible;
import model.collectibles.Supply;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;


public class Medic extends Hero {
	public Medic(String name, int maxHp, int attackDmg, int maxActions) {
		super(name, maxHp, attackDmg, maxActions);

}
	public void useSpecial() throws NoAvailableResourcesException, NotEnoughActionsException, InvalidTargetException, MovementException  {
		if(this.isSpecialAction()==false) {
		if(this.getActionsAvailable() == 0)
		{
			throw new NotEnoughActionsException();
		}
		else {	
			if(this.getSupplyInventory().size()!=0) {
				((Collectible) this.getSupplyInventory()).use(this);
				this.setSpecialAction(true);
				this.setActionsAvailable(this.getActionsAvailable()-1);
				this.heal();}
			else {
//				throw new NoAvailableResourcesException ("Cannot supply");
				throw new InvalidTargetException("must heal a Hero or self");
			}
			}
		}
		else {
			throw new NotEnoughActionsException();
		}
	}
	
	public void heal() throws InvalidTargetException, NoAvailableResourcesException, MovementException {
		if ((this.getTarget() instanceof Zombie) || this.getTarget()==null) 
			throw new InvalidTargetException("must heal a Hero or self");
			else {
		if (this.adjacent(this.getTarget())){
			this.getTarget().setCurrentHp(this.getTarget().getMaxHp());		
			
			}
		else
			throw new InvalidTargetException ("Target is not adjacent");
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
	
