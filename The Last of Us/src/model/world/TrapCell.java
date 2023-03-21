package model.world;
public class TrapCell extends Cell {
private int trapDamage;

public int getTrapDamage() {
	return trapDamage;
}

public TrapCell() {
	int[ ] numbers = { 10,20,30 };
    int max = numbers.length;
    int random = (int)(Math.random() * max);
    trapDamage = numbers[random];
   
}


}
