package engine;
import java.io.FileReader;
import java.util.ArrayList;

import model.characters.Hero;
import model.characters.Zombie;
import model.world.Cell;
public class Game {
public  static ArrayList<Hero> availableHeros;
public static ArrayList<Hero> heros;
public static ArrayList<Zombie> zombies;
public static Cell [][] map;
public static void loadHeros(String filePath) 
			
		throws Exception {
			FileReader reader = new FileReader("heros.csv"); }

}

