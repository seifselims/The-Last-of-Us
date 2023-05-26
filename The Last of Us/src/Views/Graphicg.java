package views;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.characters.*;
import model.characters.Character;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import java.awt.Point;
import javafx.concurrent.Task;
import java.util.concurrent.FutureTask;
import  java.util.concurrent.RunnableFuture;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.application.Platform;
import java.lang.Long;

public class Graphicg  extends Application  {
	public void start(Stage primaryStage) {
		try {
			ArrayList <Hero> myhero=new ArrayList();
			Image image=new Image("file:wp5432176.jpg");
			Image image2=new Image("file:0w00hui3yqsi27q7.jpg");
			Image image3 =new Image("file:The-Last-Of-Us-2-Wallpapers-Wallpaper-Cave.jpg");
			Image image4=new Image("file:67a657199d523f8c4e3a9175a3e19f1d.jpg");
			Image image5=new Image("file:459748.jpg");

			ImageView imageview=new ImageView(image);
			ImageView imageview2=new ImageView(image3);
			ImageView imageview3=new ImageView(image2);
			ImageView imageview4=new ImageView(image4);
			ImageView imageview5=new ImageView(image5);
			ImageView imageview6=new ImageView("file:thumb-1920-532407.jpg");
			
			

			imageview.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
			imageview2.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview2.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
			imageview3.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview3.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
			imageview4.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview4.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
			imageview5.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview5.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
			imageview6.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview6.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
	        Button button=new Button("START NEW GAME");
			Button button2=new Button("GAME FLOW");
			Button button3=new Button("Back To Main Menu");
			Button button4=new Button("Back To Main Menu");

		        
			stylebutton(button);
			stylebutton(button2);
			stylebutton(button3);
			stylebutton(button4);		    
			VBox boxscene1 = new VBox();
		    boxscene1.setAlignment(Pos.CENTER);
		    boxscene1.setSpacing(10);
		    boxscene1.setPadding(new Insets(10));
		    boxscene1.getChildren().addAll(button,button2);
		    GridPane scene1x=new GridPane();
		    scene1x.getChildren().addAll(imageview,boxscene1);
		
		 
		    Scene scene = new Scene(scene1x);
		    button4.setOnAction(e -> primaryStage.setScene(scene));
			Text des=new Text();	
			des.setText("The player starts off in a 15x15 grid map with just one hero and 10 zombies. The player can\r\n"
					+ "only see the directly adjacent cells next to their pool of heroes. The player then keeps taking\r\n"
					+ "his turn trying to collect vaccines, and cure or kill zombies. The game ends when the player\r\n"
					+ "has collected and used all vaccines or when all heroes have been overwhelmed and defeated by\r\n"
					+ "the zombies"
					+ "The player only wins if he has successfully collected and used all vaccines and has 5 or more\r\n"
					+ "heroes alive. \r\n GOODLUCK :)");
			des.setFill(Color.WHITE);
			des.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,45));

			des.setTextAlignment(TextAlignment.CENTER);

			VBox boxscene2 = new VBox();
		    boxscene2.setAlignment(Pos.CENTER);
		    boxscene2.setSpacing(10);
		    boxscene2.setPadding(new Insets(10));
		    boxscene2.getChildren().addAll(button3,des);
		    GridPane scene2x=new GridPane();
		    scene2x.getChildren().addAll(imageview2,boxscene2);
			Scene scene2=new Scene(scene2x);
			button2.setOnAction(e -> primaryStage.setScene(scene2)); 
			primaryStage.setResizable(true);	
			Label user_id=new Label("User Name");
			TextField tf1=new TextField(); 
		    user_id.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			user_id.setTextFill(Color.WHITE);
			user_id.setStyle("-fx-background-color:black");
			tf1.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			tf1.setStyle("-fx-background-color:black");
			button3.setOnAction(e -> primaryStage.setScene(scene)); 
			primaryStage.setScene(scene);
//	        Game.loadHeroes("test_Exp.csv");
//		    Game.loadHeroes("test_Fighters.csv");
//		    Game.loadHeroes("test_MEDS.csv");
			Game.loadHeroes("Heroes.csv");
		    GridPane heroesroot=new GridPane();
		    GridPane heroesroot2=new GridPane();
		    VBox pick=new VBox();
		    Button pickh=new Button("PICK YOUR DESIRED HERO");
		    pickh.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			pickh.setTextFill(Color.WHITE);
			pickh.setStyle("-fx-background-color:black");
			pick.getChildren().add(pickh);
			pick.setAlignment(Pos.BASELINE_CENTER);
		    heroesroot2.getChildren().addAll(imageview6, pick,heroesroot);
		    Button Howtoplay=new Button();
		    Howtoplay.setText("How To Play");
		    Text mech = new Text();
		    mech.setText("READ INSTRUCTIONS CAREFULLY!\r\n"
		    		+ "You are only allowed to move up, left, right, and down.To move press on \'↑\' for moving upwards, \'←\' for moving to the left cell, \'→\' for moving to the right cell, and \'↓\' for moving downwards. \r\n"
		    		+ "You can move to vaccine and supply cells to pick them up. \r\n"
		    		+ "While near a zombie press on 'Z' to set target on it and 'A' to attack the Zombie or 'C' to cure the Zombie if You have Vaccines left.\r\n"
		    		+ "To Target another Hero press on 'H' to set target on it.\r\n"
		    		+ "To Use a hero's Special ability press on 'U' if you have Supplies left.\r\n"
		    		+ "You are free to control another hero if you successfully cured the zombie. Press 'P'or 'H'(if hero is adjacent) to set target on other heroes then click control to change hero. \r\n"
		    		+ "Take Care of Zombies! They will attack you if you are in their sight!");
		    Howtoplay.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			Howtoplay.setTextFill(Color.WHITE);
			Howtoplay.setStyle("-fx-background-color:black");
		    styleText(mech);
		    mech.setFont(Font.font(15));
		    Button ready=new Button("READY");
		    stylebutton(ready);
		    VBox f = new VBox();
		    f.setAlignment(Pos.CENTER);
		    f.setSpacing(10);
		    f.setPadding(new Insets(10));
		    f.setBackground(Background.fill(Color.BLACK));
		    f.getChildren().addAll(Howtoplay,mech,ready);
		    GridPane fscene=new GridPane();
		    fscene.getChildren().addAll(imageview5,f);
			Scene semiscene=new Scene(fscene);
			 GridPane gameBoard = new GridPane();
		        gameBoard.setPrefSize(755, 755);

		        for (int i = 0; i < 15; i++) {
		            for (int j = 0; j < 15; j++) {

		                Rectangle tile = new Rectangle(50, 50);
		                tile.setFill(Color.BLACK);
		                tile.setStroke(Color.WHITE);

		                Text text = new Text();
		                text.setFont(Font.font(40));


		                GridPane.setRowIndex(tile, i);
		                GridPane.setColumnIndex(tile, j);
		    	        gameBoard.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
		    	        gameBoard.getChildren().addAll(tile, text);
			           
		            }
		        }
		       
		     		       
		        gameBoard.setAlignment(Pos.CENTER);
			    gameBoard.setGridLinesVisible(true);
			   

			
			    VBox vbox = new VBox();
			    vbox.setAlignment(Pos.TOP_RIGHT);
			    vbox.setSpacing(10);
			    vbox.setPadding(new Insets(10));
			    Button quit=new Button("Quit Game");
			    stylebutton3(quit);
			       
			   

			        Button cure=new Button("Cure");
			        
			        stylebutton3(cure);

			        Button specialaction=new Button("Special Action");
			        specialaction.setOnAction(e -> { scene2.setOnMouseClicked(new EventHandler<MouseEvent>() {

						public void handle(MouseEvent e) {
							 for(Hero h2:Game.availableHeroes) {
								 	try {
										h2.useSpecial();
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								
								
							   }	
						}
						});
			        });
			        	
			        stylebutton3(specialaction);
			        Button  attackz=new Button("Attack");
			        stylebutton3( attackz);
			       

			        
			    GridPane gameex=new GridPane();
			   VBox info =new VBox();
			   info.setSpacing(10);
			   info.setPadding(new Insets(10));
			   info.setAlignment(Pos.TOP_LEFT);
			   Text name=new Text();
			   styleText(name);
			   Text acpts=new Text();
			   styleText(acpts);
			   Text type= new Text();
			   styleText(type);
			   Text admg= new Text();
			   styleText(admg);
			   Text vax= new Text();
			   styleText(vax);
			   Text supz= new Text();
			   styleText(supz);
			   Text hp= new Text();
			   styleText(hp);
			   info.getChildren().addAll(name,type,hp,acpts,admg, vax, supz);							
			   

			   Button control=new Button("Control");
			   stylebutton(control);
			   Button endturn=new Button("End Turn");
			   stylebutton(endturn);
			   gameex.setStyle("-fx-background-color:black");
			    vbox.getChildren().addAll(control,endturn);
			    gameex.getChildren().addAll(info,gameBoard,vbox );
			    
			    Scene gamee=new Scene(gameex);
			    ready.setOnAction(e -> primaryStage.setScene(gamee));
			    Scene heroescene=new Scene(heroesroot2);
			    button.setOnAction(e -> primaryStage.setScene(heroescene));
			    heroesroot.setAlignment(Pos.BOTTOM_CENTER);

			    ColumnConstraints column1 = new ColumnConstraints();
			    column1.setPercentWidth(20);
			    ColumnConstraints column2 = new ColumnConstraints();
			    column2.setPercentWidth(20);
			    ColumnConstraints column3 = new ColumnConstraints();
			    column3.setPercentWidth(20);
			    ColumnConstraints column4 = new ColumnConstraints();
			    column4.setPercentWidth(20);
			    RowConstraints row1 = new RowConstraints();
			    row1.setPercentHeight(90);
			    RowConstraints row2 = new RowConstraints();
			    row2.setPercentHeight(90);

			    RowConstraints row3 = new RowConstraints();
			    row3.setPercentHeight(30);

			    RowConstraints row4 = new RowConstraints();
			    row4.setPercentHeight(30);

			    heroesroot.getColumnConstraints().addAll(column1,column2,column3,column4);
			    heroesroot.getRowConstraints().addAll(row1,row2,row3,row4);
			    heroesroot.setPadding(new Insets(10));
			    int herox=0;
			    int heroy=0;
			    for(Hero h:Game.availableHeroes) {
		    	if(heroy==4) {
		    		heroy=0;
		    		herox++;
		    	}
			    Button heroo=new Button(h.getName());
		    	stylebutton(heroo);
		    	heroesroot.getChildren().add(heroo);
		    	heroesroot.setRowIndex(heroo,herox);
		    	heroesroot.setColumnIndex(heroo, heroy);
		    	heroy++;
		        heroo.setOnMouseEntered(e -> {
		        heroo.setText("Type: "+h.herotype()+"\r\n HP: "+h.getMaxHp()+"\r\n AttackDamage:"+h.getAttackDmg()+"\r\n ActionPoints:"+h.getActionsAvailable());
		        heroo.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,25));
		        });
		        heroo.setOnMouseExited(e-> {
		        	heroo.setText(h.getName());
		        	heroo.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));	        
		        	});
		    	heroo.setOnAction (e -> {primaryStage.setScene(semiscene);
		    	myhero.add(h);
		    	Game.startGame(h)  ; 	
		    	updatemap(gameBoard ,myhero.get(0));
		    	
		    	});
		    	
				
		    

		    	
		    }
			    gamee.setOnKeyReleased(new EventHandler<KeyEvent>() {
		    		
					public void handle(KeyEvent e) {
						movehero(gameex,gameBoard, myhero.get(0), e);
						 name.setText("Name:"+myhero.get(0).getName());
						   	type.setText("Type:"+myhero.get(0).herotype());
						   	acpts.setText("Action Points:"+myhero.get(0).getActionsAvailable());
						   	admg.setText("Attack Damage:"+myhero.get(0).getAttackDmg());
						   	vax.setText("No. of Vaccines:"+myhero.get(0).getVaccineInventory().size());
						   	supz.setText("No. of Supplies:"+myhero.get(0).getSupplyInventory().size());
								hp.setText("Health:"+myhero.get(0).getCurrentHp());
							targetsetter(myhero.get(0),e);
							updatepast(gameBoard,myhero.get(0));
							try {
								attacktest(gameex,myhero.get(0),gameBoard,e);
								updatepast(gameBoard,myhero.get(0));


							} catch (Exception e1) {
								e1.printStackTrace();
							}
							throughmap(gameBoard,myhero.get(0),e);
						
					}
					
					
			    });
			    

			    control.setOnAction(e-> {
			    	if(myhero.get(0).getTarget() instanceof Hero) {
			    	Hero b=(Hero)myhero.get(0).getTarget();
			    	myhero.remove(0);
			    	myhero.add(b);
			    	updatepast(gameBoard,myhero.get(0));
			    	 name.setText("Name:"+myhero.get(0).getName());
					   	type.setText("Type:"+myhero.get(0).herotype());
					   	acpts.setText("Action Points:"+myhero.get(0).getActionsAvailable());
					   	admg.setText("Attack Damage:"+myhero.get(0).getAttackDmg());
					   	vax.setText("No. of Vaccines:"+myhero.get(0).getVaccineInventory().size());
					   	supz.setText("No. of Supplies:"+myhero.get(0).getSupplyInventory().size());
							hp.setText("Health:"+myhero.get(0).getCurrentHp());
			    	}
			    	
			    });
			    endturn.setOnAction(e-> {
			    	try {
						Game.endTurn();
						
				    		updatemap(gameBoard,myhero.get(0));
								 name.setText("Name:"+myhero.get(0).getName());
								   	type.setText("Type:"+myhero.get(0).herotype());
								   	acpts.setText("Action Points:"+myhero.get(0).getActionsAvailable());
								   	admg.setText("Attack Damage:"+myhero.get(0).getAttackDmg());
								   	vax.setText("No. of Vaccines:"+myhero.get(0).getVaccineInventory().size());
								   	supz.setText("No. of Supplies:"+myhero.get(0).getSupplyInventory().size());
										hp.setText("Health:"+myhero.get(0).getCurrentHp());
							
							
							
					   
						
						
					} catch (InvalidTargetException | NotEnoughActionsException e1) {
						e1.printStackTrace();
					}
			    	
			    });
		   
			    primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
public void stylebutton(Button button) {
	final String HOVERED_BUTTON_STYLE = "-fx-background-color:red";
    final String DEFAULTBUTTONSTYLE="-fx-background-color:black";
	DropShadow i=new DropShadow();
	InnerShadow i1=new InnerShadow();
	i.setColor(Color.RED);
	i1.setColor(Color.RED);
	InnerShadow i2=new InnerShadow();
	i2.setColor(Color.WHITE);
	button.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
	button.setTextFill(Color.WHITE);
	button.setStyle(DEFAULTBUTTONSTYLE);
    button.setOnMouseEntered(e -> button.setStyle(HOVERED_BUTTON_STYLE));
    button.setOnMouseExited(e -> button.setStyle(DEFAULTBUTTONSTYLE));
	
}
public void stylebutton3(Button button) {
	final String HOVERED_BUTTON_STYLE = "-fx-background-color:red";
    final String DEFAULTBUTTONSTYLE="-fx-background-color:black";
	DropShadow i=new DropShadow();
	InnerShadow i1=new InnerShadow();
	i.setColor(Color.RED);
	i1.setColor(Color.RED);
	InnerShadow i2=new InnerShadow();
	i2.setColor(Color.WHITE);
	button.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,25));
	button.setTextFill(Color.WHITE);
	button.setStyle(DEFAULTBUTTONSTYLE);
    button.setOnMouseEntered(e -> button.setStyle(HOVERED_BUTTON_STYLE));
    button.setOnMouseExited(e -> button.setStyle(DEFAULTBUTTONSTYLE));
	
}
public void styleText(Text button) {
		final String HOVERED_BUTTON_STYLE = "-fx-background-color:red";
	    final String DEFAULTBUTTONSTYLE="-fx-background-color:black";
		DropShadow i=new DropShadow();
		InnerShadow i1=new InnerShadow();
		i.setColor(Color.RED);
		i1.setColor(Color.RED);
		InnerShadow i2=new InnerShadow();
		i2.setColor(Color.WHITE);
		button.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,20));
		button.setFill(Color.WHITE);
		button.setStyle(DEFAULTBUTTONSTYLE);

}
public void stylebutton2(Button button) {
	final String HOVERED_BUTTON_STYLE = "-fx-background-color:black";
    final String DEFAULTBUTTONSTYLE="-fx-background-color:burgundy";
	DropShadow i=new DropShadow();
	InnerShadow i1=new InnerShadow();
	i.setColor(Color.RED);
	i1.setColor(Color.RED);
	InnerShadow i2=new InnerShadow();
	i2.setColor(Color.WHITE);
	button.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
	button.setTextFill(Color.WHITE);
	button.setStyle(DEFAULTBUTTONSTYLE);
    button.setOnMouseEntered(e -> button.setStyle(HOVERED_BUTTON_STYLE));
    button.setOnMouseExited(e -> button.setStyle(DEFAULTBUTTONSTYLE));
}
    public void updatemap (GridPane g, Hero h) {
    	Image vaci=new Image("file:Vaccines.png");
    	Image supp=new Image("file:isolated-red-apple-pixel-art-white-background-apple-big-pixels-apple-pixel-art-106403017-removebg-preview.png");
    	Image figh=new Image("file:c11fd6e23823559e0df4e6d99fc6094c-removebg-preview.png");
    	Image zom=new Image("file:zombie_walk___pixel_by_genbaku_d8fh6px-fullview.png");
    	Image exp=new Image("file:yan-silva-torres-de-siqueira-yan-pixel-removebg-preview.png");
    	Image med=new Image("file:medic.png");
        

         
        for(int i=0;i<15;i++) {
        	for(int j=0;j<15;j++) {
        		if(!Game.map[i][j].isVisible()) {
        			Rectangle tile = new Rectangle(50, 50);
    		        tile.setFill(Color.BLACK);
    		        tile.setStroke(Color.WHITE);
    		    	int i1= 14-i;
    		    	g.getChildren().add(tile);
    		    	
    		    	g.setRowIndex(tile, i1);
    				g.setColumnIndex(tile,j);
        		}
        		else {
        		if (Game.map[i][j]instanceof CollectibleCell) {
        			if(((CollectibleCell)Game.map[i][j]).getCollectible() instanceof Vaccine) {
        				Rectangle vac=new Rectangle(50,50);
        		        vac.setStroke(Color.WHITE);
        		        vac.setFill(new ImagePattern(vaci));
        				int i1= 14-i;
        				g.getChildren().add(vac);
        				g.setRowIndex(vac, i1);	
        				g.setColumnIndex(vac,j);
     			}
        			else {
        				Rectangle suppi=new Rectangle(50,50);
        				suppi.setStroke(Color.WHITE);
        		        suppi.setFill(new ImagePattern(supp)); 
        				int i1= 14-i;
        				g.getChildren().add(suppi);
        				g.setRowIndex(suppi, i1);
        				g.setColumnIndex(suppi,j);
        			}
        			
     				
     		}
        		else {
        			if(Game.map[i][j] instanceof CharacterCell) {


        			
        				if(((CharacterCell)Game.map[i][j]).getCharacter() instanceof Hero) {
            				if (((CharacterCell)Game.map[i][j]).getCharacter() instanceof Fighter){
            					Rectangle fight=new Rectangle(50,50);
                				fight.setStroke(Color.WHITE);
                		        fight.setFill(new ImagePattern(figh)); 
                				int i1= 14-i;
                				g.getChildren().add(fight);

                				g.setRowIndex(fight, i1);
                				g.setColumnIndex(fight,j);
                				int i2=i;
                				int j2=j;


                			
            				}
            				
            				else if (((CharacterCell)Game.map[i][j]).getCharacter() instanceof Explorer){
            					Rectangle expo=new Rectangle(50,50);
                				expo.setStroke(Color.WHITE);
                		        expo.setFill(new ImagePattern(exp)); 
                				int i1= 14-i;
//                				
                				g.getChildren().add(expo);


                				g.setRowIndex(expo, i1);
                				g.setColumnIndex(expo,j);
                				int i2=i;
                				int j2=j;
                			
            				}
            				else {
            					Rectangle medi=new Rectangle(50,50);
                				medi.setStroke(Color.WHITE);
                		        medi.setFill(new ImagePattern(med)); 
                				int i1= 14-i;
                				g.getChildren().add(medi);

                				g.setRowIndex(medi, i1);
                				g.setColumnIndex(medi,j);
                				int i2=i;
                				int j2=j;
                			
            				}
            			}
            			else if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie) {
            				Rectangle zomi=new Rectangle(50,50);
            				zomi.setStroke(Color.WHITE);
            		        zomi.setFill(new ImagePattern(zom)); 
            				int i1= 14-i;
            				g.getChildren().add(zomi);
            				g.setRowIndex(zomi, i1);
            				g.setColumnIndex(zomi,j);
            				int i2=i;
            				int j2=j;
            			
            			}
        			}
        		
        			else {
        				
        				Rectangle tile = new Rectangle(50, 50);
        		        tile.setFill(Color.BLACK);
        		        tile.setStroke(Color.WHITE);
        		    	int i1= 14-i;
        		    	g.getChildren().add(tile);
        		    	
        		    	g.setRowIndex(tile, i1);
        				g.setColumnIndex(tile,j);
        			}
        		}
     	}
     }

}
    }


public void movehero(GridPane g, GridPane gameBoard, Hero h, KeyEvent e) {
	switch(e.getCode()) {
	case UP:
		try {
			if(Game.checkWin()) {
				checkend(g,"CONGRATULATIONS YOU HAVE WON THE GAME!");
				return;
			}
			if(Game.checkGameOver()) {
				checkend(g,"OH NO! YOU HAVE LOST!");
				return;
			}
			int x=h.getCurrentHp();
			h.move(Direction.UP);
			if(x!=h.getCurrentHp()) {
				int y= x-h.getCurrentHp();
				dealexception(g,"YOU HAVB STEPPED ON A TRAPCELL -"+y);
			}
			updatepast(gameBoard,h);
			
		} catch (NotEnoughActionsException e1) {
			dealexception(g,"No Action Points for movement, End turn or change Hero");
			e1.printStackTrace();
		} catch (MovementException e1) {
			dealexception(g,"Cannot move out of map or to an occupied cell");
			e1.printStackTrace();
		}
		break;
	case DOWN:
		try {
			if(Game.checkWin()) {
				checkend(g,"CONGRATULATIONS YOU HAVE WON THE GAME!");
				return;
			}
			if(Game.checkGameOver()) {
				checkend(g,"OH NO! YOU HAVE LOST!");
				return;
			}
			int x=h.getCurrentHp();
			h.move(Direction.DOWN);
			updatepast(gameBoard,h);
			if(x!=h.getCurrentHp()) {
				int y= x-h.getCurrentHp();
				dealexception(g,"YOU HAVB STEPPED ON A TRAPCELL -"+y);
			}
		} catch (NotEnoughActionsException e1) {
			dealexception(g,"No Action Points for movement, End turn or change Hero");
			e1.printStackTrace();
		} catch (MovementException e1) {
			dealexception(g,"Cannot move out of map or to an occupied cell");
			e1.printStackTrace();
		}
		break;
	
	case LEFT:
		try {

			if(Game.checkWin()) {
				checkend(g,"CONGRATULATIONS YOU HAVE WON THE GAME!");
				return;
			}
			if(Game.checkGameOver()) {
				checkend(g,"OH NO! YOU HAVE LOST!");
				return;
			}
			int x=h.getCurrentHp();
			h.move(Direction.LEFT);
			updatepast(gameBoard,h);
			if(x!=h.getCurrentHp()) {
				int y= x-h.getCurrentHp();
				dealexception(g,"YOU HAVB STEPPED ON A TRAPCELL -"+y);
			}
		} catch (NotEnoughActionsException e1) {
			dealexception(g,"No Action Points for movement, End turn or change Hero");
			e1.printStackTrace();
		} catch (MovementException e1) {
			dealexception(g,"Cannot move out of map or to an occupied cell");
			e1.printStackTrace();
		}
		break;
	case RIGHT:
		try {

			if(Game.checkWin()) {
				checkend(g,"CONGRATULATIONS YOU HAVE WON THE GAME!");
				return;
			}
			if(Game.checkGameOver()) {
				checkend(g,"OH NO! YOU HAVE LOST!");
				return;
			}
			int x=h.getCurrentHp();
			h.move(Direction.RIGHT);
			updatepast(gameBoard,h);
			if(x!=h.getCurrentHp()) {
				int y= x-h.getCurrentHp();
				dealexception(g,"YOU HAVB STEPPED ON A TRAPCELL -"+y);
			}
		} catch (NotEnoughActionsException e1) {
			dealexception(g,"No Action Points for movement, End turn or change Hero");
			e1.printStackTrace();
		} catch (MovementException e1) {
			dealexception(g,"Cannot move out of map or to an occupied cell");
			e1.printStackTrace();
		}
	}
	
}

public void updatepast(GridPane gameBoard, Hero h) {
	for (int i=0;i<gameBoard.getChildren().size();i++) {
		gameBoard.getChildren().remove(i);

		}
	gameBoard.setPrefSize(755, 755);

    for (int i = 0; i < 15; i++) {
        for (int j = 0; j < 15; j++) {

            Rectangle tile = new Rectangle(50, 50);
            tile.setFill(Color.BLACK);
            tile.setStroke(Color.WHITE);

            Text text = new Text();
            text.setFont(Font.font(40));

            GridPane.setRowIndex(tile, i);
            GridPane.setColumnIndex(tile, j);
	        gameBoard.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
	        gameBoard.getChildren().addAll(tile, text);
	    
        }
    }       
    gameBoard.setAlignment(Pos.CENTER);
    gameBoard.setGridLinesVisible(true);
   
	updatemap(gameBoard,h);

	}
public void targetsetter(Hero h, KeyEvent e) {
	switch(e.getCode()) {
	case S:
		h.setTarget(h);
		break;
	case Z:
		for(int i=0;i<h.adjcells().size();i++) {
			int x=h.adjcells().get(i).x;
			int y=h.adjcells().get(i).y;
			if(Game.map[x][y] instanceof CharacterCell) {
				if(((CharacterCell)Game.map[x][y]).getCharacter() instanceof Zombie) {
					h.setTarget(((CharacterCell)Game.map[x][y]).getCharacter());
					break;
				}
			}
		}
		break;
	case H:
		for(int i=0;i<h.adjcells().size();i++) {
			int x=h.adjcells().get(i).x;
			int y=h.adjcells().get(i).y;
			if(Game.map[x][y] instanceof CharacterCell) {
				if(((CharacterCell)Game.map[x][y]).getCharacter() instanceof Hero) {
					h.setTarget(((CharacterCell)Game.map[x][y]).getCharacter());
					break;
				}
			}
		}
		break;
	}
}
public void attacktest(GridPane gamee,Hero h,GridPane g, KeyEvent e)  {
	switch(e.getCode()) {
	case A:
		try {
			int x=h.getCurrentHp();
			h.attack();
			dealexceptionzz(gamee,"Zombie has been damaged by -"+h.getAttackDmg());
			if(x!=h.getCurrentHp()) {
				int y= x-h.getCurrentHp();
				dealexceptionz(gamee,"Hero has been damaged by -"+y);
			}
		} catch (NotEnoughActionsException e1) {
			dealexception(gamee,"No action Points to attack");
			e1.printStackTrace();
		} catch (InvalidTargetException e1) {
			dealexception(gamee,"Cannot attack current Target");
			e1.printStackTrace();
		}
		
		break;
	case C:
		try {
			h.cure();
			h.setTarget(null);
			dealexceptionss(gamee,"ZOMBIE CURED!");
		} catch (NoAvailableResourcesException e1) {
			dealexception(gamee,"No vaccines available");
			e1.printStackTrace();
		} catch (InvalidTargetException e1) {
			dealexception(gamee,"Cannot cure current Target");
			e1.printStackTrace();
		} catch (NotEnoughActionsException e1) {
			dealexception(gamee,"No action points to cure");
			e1.printStackTrace();
		} catch (MovementException e1) {
			
			e1.printStackTrace();
		}
		break;
	case U:
		try {
			int x=h.getCurrentHp();
			int y=h.getTarget().getCurrentHp();
			h.useSpecial();
			dealexceptionss(gamee,"Special Action:ON");
			if(h.herotype().equals("Medic")) {
				if (h.getCurrentHp()>x)
					dealexceptionzz(gamee,"Hero Healed!");
				if(h.getTarget() instanceof Hero) {
				if (y>h.getTarget().getCurrentHp())
					dealexceptionzz(gamee,"Hero Healed!");
				}
			}
		} catch (NoAvailableResourcesException e1) {
			dealexception(gamee,"No supplies available");
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		break;
	}
	updatepast(g,h);

}
//public void throughmap(Hero h, KeyEvent e) {
//	switch(e.getCode()) {
//	case I:
//		
//	}
//}
public void throughmap(GridPane g, Hero h, KeyEvent e) {
	switch(e.getCode()) {
	case P:
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(Game.map[i][j] instanceof CharacterCell) {
					if (((CharacterCell)Game.map[i][j]).getCharacter() instanceof Hero) {
						int i2=14-i;
						h.setTarget((Hero)((CharacterCell)Game.map[i][j]).getCharacter());
						for(int k=0;k<g.getChildren().size();k++) {
							Rectangle r=(Rectangle)(g.getChildren().get(k));
							if(g.getColumnIndex(r)==j && g.getRowIndex(r)==i2)
							r.setFill(Color.WHITE);
						}
					}
					}
				}
			}
		}
	}
	

public void time(long millis, Runnable continutation) {
	Task <Void> sleeper=new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			try { Thread.sleep(millis); 
			}
			catch(InterruptedException e) {
				
			}
			return null;
		
		}
	};
	sleeper.setOnSucceeded(event -> continutation.run());
	new Thread (sleeper).start();
	}

public void checkend(GridPane g, String s) {
	Button x=new Button(s);
	VBox a=new VBox();
	x.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,40));
	x.setTextFill(Color.YELLOW);
	x.setStyle("-fx-background-color:black");
	a.getChildren().add(x);
	a.setAlignment(Pos.CENTER);
	g.getChildren().add(a);
}
public void dealexception (GridPane g, String s) {
	Button x=new Button(s);
	VBox a=new VBox();
	x.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,40));
	x.setTextFill(Color.RED);
	x.setStyle("-fx-background-color:black");
	a.getChildren().add(x);
	a.setAlignment(Pos.CENTER);
	g.getChildren().add(a);
	time(1000, () -> {
		g.getChildren().remove(a);
	});
}

public void dealexceptionss (GridPane g, String s) {
	Button x=new Button(s);
	VBox a=new VBox();
	x.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,40));
	x.setTextFill(Color.GREEN);
	x.setStyle("-fx-background-color:black");
	a.getChildren().add(x);
	a.setAlignment(Pos.CENTER);
	g.getChildren().add(a);
	time(1000, () -> {
		g.getChildren().remove(a);
	});
}
public void dealexceptionz (GridPane g, String s) {
	Button x=new Button(s);
	VBox a=new VBox();
	x.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,40));
	x.setTextFill(Color.RED);
	x.setStyle("-fx-background-color:black");
	a.getChildren().add(x);
	a.setAlignment(Pos.BOTTOM_LEFT);
	g.getChildren().add(a);
	time(1000, () -> {
		g.getChildren().remove(a);
	});
}
public void dealexceptionzz (GridPane g, String s) {
	Button x=new Button(s);
	VBox a=new VBox();
	x.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,40));
	x.setTextFill(Color.GREEN);
	x.setStyle("-fx-background-color:black");
	a.getChildren().add(x);
	a.setAlignment(Pos.BOTTOM_RIGHT);
	g.getChildren().add(a);
	time(1000, () -> {
		g.getChildren().remove(a);
	});
}

}