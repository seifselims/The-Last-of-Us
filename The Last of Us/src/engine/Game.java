package engine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.world.Cell;
public class Game {
public  static ArrayList<Hero> availableHeros;
public static ArrayList<Hero> heros;
public static ArrayList<Zombie> zombies;
public static Cell [][] map;
public static void loadHeros(String filePath) 
			
		throws Exception {
			FileReader reader = new FileReader(filePath);
			BufferedReader br = new BufferedReader(reader);
			while(br.readLine() != null) 
			{
				String line=br.readLine();
				String[] tempArr = line.split(",");
				if (tempArr[1].equals("FIGH")) {
				Hero f = new Fighter(tempArr[0], (Integer.parseInt(tempArr[2])), (Integer.parseInt(tempArr[3])), (Integer.parseInt(tempArr[4])));
				availableHeros.add(f);
				}
				else if (tempArr[1].equals("MED")) {
					Hero m = new Medic(tempArr[0], (Integer.parseInt(tempArr[2])), (Integer.parseInt(tempArr[3])), (Integer.parseInt(tempArr[4])));
					availableHeros.add(m);
					}
				else {
					Hero e = new Explorer(tempArr[0], (Integer.parseInt(tempArr[2])), (Integer.parseInt(tempArr[3])), (Integer.parseInt(tempArr[4])));
					availableHeros.add(e);
					}
			}
			br.close();
}
}

