package model.world;
public class TrapCell {
private int trapDamage;

public TrapCell() {
	int[ ] numbers = { 10,20,30 };
    int max = numbers.length;
    int random = (int)(Math.random() * max);
    trapDamage = numbers[random];
    System.out.print(trapDamage);
}
}
