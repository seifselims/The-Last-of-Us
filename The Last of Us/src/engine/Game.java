package engine;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import exceptions.GameActionException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.characters.Character;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.collectibles.Collectible;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.Cell;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class Game extends Application {
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
			

public void start(Stage primaryStage) {
	try {
		Image image=new Image("C:\\Users\\walid\\Desktop\\TLOU.jpg");
		ImageView imageview=new ImageView(image);
		
//		BorderPane root = new BorderPane();
	
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		VBox root1=new VBox();
		Button button=new Button("START NEW GAME");
		button.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,25));
		button.setTextFill(Color.WHITE);
		button.setStyle("-fx-background-color:black");
		button.setLayoutX(340);
		button.setLayoutY(200);
		
		Group root=new Group();
		root.getChildren().addAll(imageview,button);

		
		Scene scene = new Scene(root);
		
		
		primaryStage.setResizable(true);	
		primaryStage.setScene(scene);
		primaryStage.show();
//		Stage stage=(Stage)button.getScene().getWindow();
//		stage.close();
//		stage.show();
		
	} catch(Exception e) {
		e.printStackTrace();
	}
}
//public void handleclosed(ActionEvent event) {
//((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
//}
//public void start1(Stage primaryStage) throws Exception {
//GridPane root1 = new GridPane();
//Label l1 = new Label("Text 1");
//Label l2 = new Label("Text 2");
//Label l3 = new Label("Text 3");
//Label l4 = new Label("Text 4");
//root1.add(l1,0,0);
//root1.add(l2,1,0);
//root1.add(l3,0,1);
//root1.add(l4,1,1);
//Scene s = new Scene(root1,1000,600);
//primaryStage.setScene(s);
//primaryStage.show();}
//public void music(Stage primaryStage) {
//	String path = "C:\\Users\\walid\\Desktop\\The Last Of us - Theme song.mp3";
//	Media media = new Media(new File(path).toURI().toString());
//	MediaPlayer mediaPlayer = new MediaPlayer(media);
//	mediaPlayer.setAutoPlay(true);
//	primaryStage.setTitle("Playing Audio");
////	primaryStage.show();
//}
public static void main(String[] args) {
	launch(args);
}
//public void start(Stage primaryStage) throws Exception {
//	// TODO Auto-generated method stub
//	VBox root = new VBox();
//	Image img = new Image("C:\\Users\\walid\\Desktop\\Computer Programing Lab\\WhatsApp Image 2023-05-16 at 16.43.00.jpg");
//	ImageView view = new ImageView(img);
//	view.setFitHeight(100);
//	view.setFitWidth(100);
//	Button b = new Button();
//	b.setGraphic(view);
//	b.setPrefSize(100, 100);
//	root.getChildren().add(b);
//	Scene s = new Scene(root,1000,600);
//	primaryStage.setScene(s);
//	primaryStage.show();
//	}

}


