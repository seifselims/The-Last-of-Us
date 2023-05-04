package engine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.Cell;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
public class Game {
public  static ArrayList<Hero> availableHeroes=new ArrayList<Hero>();
public static ArrayList<Hero> heroes=new ArrayList<Hero>();
public static ArrayList<Zombie> zombies=new ArrayList<Zombie>();
public static Cell [][] map=new Cell[15][15];
public static void loadHeroes(String filePath) throws Exception {
			FileReader reader = new FileReader(filePath);
			BufferedReader br = new BufferedReader(reader);

			String line=null;
			while( ((line =br.readLine()) != null)) 	{
				String[] tempArr = line.split(",");	
			

				if (tempArr[1].equals("FIGH")) {
				Hero f = new Fighter(tempArr[0], (Integer.parseInt(tempArr[2])), (Integer.parseInt(tempArr[4])), (Integer.parseInt(tempArr[3])));
				availableHeroes.add(f);
				}
				else if (tempArr[1].equals("MED")) {
					Hero m = new Medic(tempArr[0], (Integer.parseInt(tempArr[2])), (Integer.parseInt(tempArr[4])), (Integer.parseInt(tempArr[3])));
					availableHeroes.add(m);
					}
				else {
					Hero e = new Explorer(tempArr[0], (Integer.parseInt(tempArr[2])), (Integer.parseInt(tempArr[4])), (Integer.parseInt(tempArr[3])));
					availableHeroes.add(e);
					}
			}
		
		br.close();
		}
public static void startGame(Hero h) {
	availableHeroes.remove(h);
	CharacterCell x=new CharacterCell((h));
	map [0][0]=x;
/*	for (int i=0;i<5;i++) {
		CollectibleCell m=new CollectibleCell(new Vaccine());
		CollectibleCell n=new CollectibleCell(new Supply());
		int a = (int)(Math.random()*(14-0+1)+0);  
		int b = (int)(Math.random()*(14-0+1)+0);  
		while(map[a][b]!=null) {
			 a = (int)(Math.random()*(14-0+1)+0);  
			 b = (int)(Math.random()*(14-0+1)+0);  
		}
		map[a][b]=m;
		a = (int)(Math.random()*(14-0+1)+0);  
		b = (int)(Math.random()*(14-0+1)+0); 
		while(map[a][b]!=null) {
			 a = (int)(Math.random()*(14-0+1)+0);  
			 b = (int)(Math.random()*(14-0+1)+0);  
		}
		map[a][b]=n;
	}*/
	for (int i=0;i<5;i++) {
		int a = (int)(Math.random()*(14-0+1)+0);  
		int b = (int)(Math.random()*(14-0+1)+0); 
		while(map[a][b]!=null) {
			 a = (int)(Math.random()*(14-0+1)+0);  
			 b = (int)(Math.random()*(14-0+1)+0);  
		}
		map[a][b]=new TrapCell();
	}
	for(int i=0;i<10;i++) {
		CharacterCell z=new CharacterCell(new Zombie());
		int a = (int)(Math.random()*(14-0+1)+0);  
		int b = (int)(Math.random()*(14-0+1)+0); 
		while(map[a][b]!=null) {
			 a = (int)(Math.random()*(14-0+1)+0);  
			 b = (int)(Math.random()*(14-0+1)+0);  
		}
		map[a][b]=z;
	}
}
public static boolean checkWin() {
	if(availableHeroes.size()>=5)
		return true;
	else
		return false;
}
		}




