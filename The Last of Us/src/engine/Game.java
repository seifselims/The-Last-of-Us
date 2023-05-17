package engine;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;

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

public class Game{
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
	for(int i=0;i<15;i++) {
		for(int j=0;j<15;j++) {
			map[i][j]=new CharacterCell(null);
		}
	}
	availableHeroes.remove(h);
	heroes.add(h);
	CharacterCell x=new CharacterCell((h));
	boolean flag=true;
	map [0][0]=x;
	Point loc=new Point(0,0);
	h.setLocation(loc);
	h.setVisiblity(true);
	x.setVisible(true);
	for (int i=0;i<5;i++) {
		CollectibleCell m=new CollectibleCell(new Vaccine());
		CollectibleCell n=new CollectibleCell(new Supply());
		int a = (int)(Math.random()*(14-0+1)+0);  
		int b = (int)(Math.random()*(14-0+1)+0);  
		do{
			 a = (int)(Math.random()*(14-0+1)+0);  
			 b = (int)(Math.random()*(14-0+1)+0); 
			 if(map[a][b] instanceof TrapCell || map[a][b] instanceof CollectibleCell)
				 flag=true;
			 else if (((CharacterCell)map[a][b]).getCharacter() != null) {
				 flag=true;
			 }
			 else
				 flag=false;
		}while(flag);
		map[a][b]=m;
		do{a = (int)(Math.random()*(14-0+1)+0);  
		 b = (int)(Math.random()*(14-0+1)+0); 
			 if(map[a][b] instanceof TrapCell || map[a][b] instanceof CollectibleCell)
				 flag=true;
			 else if (((CharacterCell)map[a][b]).getCharacter() != null) {
				 flag=true;
			 }
			 else
				 flag=false;
		}while(flag);
		map[a][b]=n;
	}
	for (int i=0;i<5;i++) {
		int a = (int)(Math.random()*(14-0+1)+0);  
		int b = (int)(Math.random()*(14-0+1)+0); 
		do{a = (int)(Math.random()*(14-0+1)+0);  
		 b = (int)(Math.random()*(14-0+1)+0); 
			 if(map[a][b] instanceof TrapCell || map[a][b] instanceof CollectibleCell)
				 flag=true;
			 else if (((CharacterCell)map[a][b]).getCharacter() != null) {
				 flag=true;
			 }
			 else
				 flag=false;
		}while(flag);
		map[a][b]=new TrapCell();
	}
while(zombies.size()<10) {
	Zombie z1=new Zombie();
CharacterCell z=new CharacterCell(z1);
		int a = (int)(Math.random()*(14-0+1)+0);  
		int b = (int)(Math.random()*(14-0+1)+0); 
		do{a = (int)(Math.random()*(14-0+1)+0);  
		 b = (int)(Math.random()*(14-0+1)+0); 
			 if(map[a][b] instanceof TrapCell || map[a][b] instanceof CollectibleCell)
				 flag=true;
			 else if (((CharacterCell)map[a][b]).getCharacter() != null) {
				 flag=true;
			 }
			 else
				 flag=false;
		}while(flag);
		map[a][b]=z;
		z.getCharacter().setLocation(new Point(a,b));
		zombies.add(z1);
	}
for(int i=0;i<heroes.size();i++ ) {
	heroes.get(i).setVisiblity(true);
}
}
public static boolean checkWin() {
	boolean x=true;
	boolean y=true;
	int count=0;
	for(int a=0;a<15;a++) {
		for(int b=0;b<15;b++) {
			if (map[a][b] instanceof CollectibleCell) {
				CollectibleCell m=(CollectibleCell)map[a][b];
				if(m.getCollectible() instanceof Vaccine)
					y=false;
			}
			else if(map[a][b] instanceof CharacterCell) {
				CharacterCell c=(CharacterCell)map[a][b];
				if(c.getCharacter() instanceof Hero)
					count++;
			}
		}
	}
	if (count<5) {
		x=false;
	}
	for(int i=0;i<heroes.size();i++) {
		if(heroes.get(i).getVaccineInventory().size()!=0)
			y=false;
	}
	if((availableHeroes.size()>=5 || heroes.size()>=5) && x==true && y==true )
		return true;
	else
		return false;
}
public static boolean checkGameOver() {
	boolean x=true;
	boolean y=true;
	int count=0;
	for(int a=0;a<15;a++) {
		for(int b=0;b<15;b++) {
			if (map[a][b] instanceof CollectibleCell) {
				CollectibleCell m=(CollectibleCell)map[a][b];
				if(m.getCollectible() instanceof Vaccine)
					x=false;
			}
			else if(map[a][b] instanceof CharacterCell) {
				CharacterCell c=(CharacterCell)map[a][b];
				if(c.getCharacter() instanceof Hero)
					count++;
			}
		}
	}
	if (count>0) {
		y=false;
	}
	for(int i=0;i<heroes.size();i++) {
		if(heroes.get(i).getVaccineInventory().size()!=0)
			return false;
			heroes.get(i).onCharacterDeath();
	}
	for(int i=0;i<availableHeroes.size();i++) {
		if(availableHeroes.get(i).getVaccineInventory().size()!=0)
			return false;
			availableHeroes.get(i).onCharacterDeath();
	}
	if(heroes.size()==0  || y==true || x==true)  {
		return true;
	}
	return false;	
}

public static void endTurn() throws InvalidTargetException, NotEnoughActionsException {
	
	
			for(int a=0;a<15;a++) {
				for(int b=0;b<15;b++) {
							map[a][b].setVisible(false);}}
			
	
	for(int i=0;i<heroes.size();i++) {
		heroes.get(i).setCurrentHp(heroes.get(i).getMaxHp());
		heroes.get(i).setTarget(null);
		heroes.get(i).setSpecialAction(false);
		heroes.get(i).setVisiblity(true);
		heroes.get(i).setActionsAvailable(heroes.get(i).getMaxActions());
	}
	for(int i=0;i<zombies.size();i++) {				
		zombies.get(i).attack();}	
	
	
	Zombie zombie=new Zombie();
	int random= (int) (Math.random()*(14-0+1)+0);
	int random1=(int)(Math.random()*(14-0+1)+0);
	boolean flag=true;
	do{
		 random = (int)(Math.random()*(14-0+1)+0);  
		 random1 = (int)(Math.random()*(14-0+1)+0); 
		 if(map[random][random1] instanceof TrapCell || map[random][random1] instanceof CollectibleCell)
			 flag=true;
		 else if (((CharacterCell)map[random][random1]).getCharacter() != null) {
			 flag=true;
		 }
		 else
			 flag=false;
	}while(flag);
	((CharacterCell)map[random][random1]).setCharacter(zombie);
	CharacterCell charzombie= new CharacterCell(zombie);
	map[random][random1]=charzombie;
	zombies.add(zombie);
	zombie.setLocation(new Point(random,random1));

	for(int i=0;i<zombies.size();i++) {
		zombies.get(i).setTarget(null);
	}
	for(int i=0;i<heroes.size();i++ ) {
		heroes.get(i).setVisiblity(true);
	}
}
			



}


