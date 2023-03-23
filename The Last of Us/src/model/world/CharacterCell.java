package model.world;
import model.characters.Character;
public class CharacterCell extends Cell {
public CharacterCell(Character character, boolean isSafe) {
		super();
		this.character = character;
		this.isSafe = isSafe;
	}
private Character character;
public CharacterCell(Character character) {
	super();
	this.character = character;
}
private boolean isSafe;
public Character getCharacter() {
	return character;
}
public void setCharacter(Character character) {
	this.character = character;
}
public boolean isSafe() {
	return isSafe;
}
public void setSafe(boolean isSafe) {
	this.isSafe = isSafe;
}
}