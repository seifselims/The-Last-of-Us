package model.characters;
import java.util.ArrayList;
import model.collectibles.Vaccine;
public class Hero extends Character {
private int actionsAvailable;
private int maxActions;
private boolean specialAction;
private  ArrayList<Vaccine> vaccineInventory;
private  ArrayList<Vaccine> supplyInventory;
public int getActionsAvailable() {
	return actionsAvailable;
}
public void setActionsAvailable(int actionsAvailable) {
	this.actionsAvailable = actionsAvailable;
}
public boolean isSpecialAction() {
	return specialAction;
}
public void setSpecialAction(boolean specialAction) {
	this.specialAction = specialAction;
}
public int getMaxActions() {
	return maxActions;
}
public ArrayList<Vaccine> getVaccineInventory() {
	return vaccineInventory;
}
public ArrayList<Vaccine> getSupplyInventory() {
	return supplyInventory;
}
public Hero(String name, int maxHp, int attackDmg, int maxActions) {
		super(name, maxHp, attackDmg);
		this.maxActions=maxActions;
		this.actionsAvailable=maxActions;
	}
}

