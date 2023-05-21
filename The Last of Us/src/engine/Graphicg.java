package engine;

import java.io.File;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.characters.Hero;
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
public class Graphicg  extends Application  {
	public void start(Stage primaryStage) {
		try {
//			DropShadow i=new DropShadow();
//			InnerShadow i1=new InnerShadow();
//			i.setColor(Color.RED);
//			i1.setColor(Color.RED);
			Image image=new Image("file:wp5432176.jpg");
			Image image2=new Image("file:0w00hui3yqsi27q7.jpg");
			Image image3 =new Image("file:The-Last-Of-Us-2-Wallpapers-Wallpaper-Cave.jpg");
			Image image4=new Image("file:67a657199d523f8c4e3a9175a3e19f1d.jpg");
			Image image5=new Image("file:058e9f57ae7ea9001a12b6022c9d985c.png");

			ImageView imageview=new ImageView(image);
			ImageView imageview2=new ImageView(image3);
			ImageView imageview3=new ImageView(image2);
			ImageView imageview4=new ImageView(image4);
			ImageView imageview5=new ImageView(image5);
			
			

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

//			des.setEffect(i);
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
		    Button submit = new Button("Go To Choose Your Hero ->"); 
		    user_id.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			user_id.setTextFill(Color.WHITE);
			user_id.setStyle("-fx-background-color:black");
			stylebutton(submit);
			tf1.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			tf1.setStyle("-fx-background-color:black");
//			tf1.setEffect(i);
//			user_id.setEffect(i1);

			VBox boxscene3 = new VBox();
		    boxscene3.setAlignment(Pos.CENTER);
		    boxscene3.setSpacing(10);
		    boxscene3.setPadding(new Insets(10));
		    boxscene3.getChildren().addAll(button4,user_id,tf1,submit);
		    GridPane scene3x=new GridPane();
		    scene3x.getChildren().addAll(imageview3,boxscene3);
		    Scene submission=new Scene(scene3x); 
		    button.setOnAction(e -> primaryStage.setScene(submission));
			button3.setOnAction(e -> primaryStage.setScene(scene)); 
			primaryStage.setScene(scene);
	        Game.loadHeroes("test_Exp.csv");
		    Game.loadHeroes("test_Fighters.csv");
		    Game.loadHeroes("test_MEDS.csv");
		    GridPane heroesroot=creategrid();
		    heroesroot.setStyle("-fx-background-image:url('file:thumb-1920-532407.jpg')");
		    int herox=1;
		    int heroy=1 ;
		    Button pick = new Button("Hello "+tf1.getText()+", pick your desired hero to start the game");
//		    stylebutton(pick);
//			heroesroot.getChildren().add(pick);
//			heroesroot.setColumnIndex(pick, 3);
//			heroesroot.setRowIndex(pick, 0);
		    GridPane gameboard=creategrid();
		    Group gameroot=new Group();
		    gameroot.getChildren().add(gameboard);
		    Scene game=new Scene(gameroot);
		    gameboard.setStyle("-fx-background-image:url('file:058e9f57ae7ea9001a12b6022c9d985c.png')");
//		    gameboard.setGridLinesVisible(true);
		    Button Howtoplay=new Button();
		    Howtoplay.setText("How To Play");
		    Text mech = new Text();
		    mech.setText("You are only allowed to move up, left, right, and down.\r\n"
		    		+ "To move press on '_' for moving upwards, '_' for moving to the left cell, '_' for moving to the right cell, and '_' for moving downwards.\r\n"
		    		+ "You can move to vaccine and supply cells to pick them up.\r\n"
		    		+ "Take Care of Zombies! They will attack you if you are in their sight!");
		    stylebutton(Howtoplay);
		    styleText(mech);
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
		    
		    for(Hero h:Game.availableHeroes) {
		    	Button heroo=new Button(h.getName());
		    	stylebutton(heroo);
		    	heroesroot.getChildren().add(heroo);
		    	heroo.setMaxWidth(Double.MAX_VALUE);
		        heroo.setOnMouseEntered(e -> {
		        heroo.setMaxHeight(Double.MAX_VALUE);
		        heroo.setText("Type: "+h.herotype()+"\r\n HP: "+h.getMaxHp()+"\r\n AttackDamage:"+h.getAttackDmg()+"\r\n ActionPoints:"+h.getActionsAvailable());
		        	
		        });
		        heroo.setOnMouseExited(e-> {
		        	heroo.setText(h.getName());
		        });
		    	heroo.setOnAction (e -> {primaryStage.setScene(semiscene);
		    	Game.startGame(h);
		    	});
		    	
		    	if(herox>3) {
		    		herox=1;
		    		heroy=heroy+2;
		    	}
		    	heroesroot.setColumnIndex(heroo,herox );
		    	heroesroot.setRowIndex(heroo, heroy);
		    	herox++;
		    	herox++;
		    }
		   
	        Scene heroescene=new Scene(heroesroot);
		    submit.setOnAction(e -> primaryStage.setScene(heroescene)); 
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
//		
	}
	public GridPane creategrid() {
		GridPane g=new GridPane();  
		for (int i = 0; i < 15; i++) {
	            ColumnConstraints colConst = new ColumnConstraints();
	            colConst.setPercentWidth(100.0 / 15);
	            g.getColumnConstraints().add(colConst);
		    }
	        for (int i = 0; i < 15; i++) {
	            RowConstraints rowConst = new RowConstraints();
	            rowConst.setPercentHeight(100.0 / 15);
	            g.getRowConstraints().add(rowConst);
	}
	        
	        return g;
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
//	button.setEffect(i1);
	
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
		button.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,25));
		button.setFill(Color.WHITE);
		button.setStyle(DEFAULTBUTTONSTYLE);
//	    button.setOnMouseEntered(e -> button.setStyle(HOVERED_BUTTON_STYLE));
//	    button.setOnMouseExited(e -> button.setStyle(DEFAULTBUTTONSTYLE));
}
}