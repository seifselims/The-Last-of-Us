package model.characters;

public class Zombie extends Character {
	static int ZOMBIES_COUNT;

public Zombie(String name, int maxHp, int attackDmg) {
		super(name, maxHp, attackDmg);

	}
public Zombie() {
	new Zombie(getName(),40,10);

}


}
