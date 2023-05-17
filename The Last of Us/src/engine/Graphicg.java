package engine;

import java.io.File;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Background;
public class Graphicg  extends Application  {
	public void start(Stage primaryStage) {
		try {
//			String path = ("file:The Last of Us Part II Live Wallpaper.mp4"); 
			Image image=new Image("file:wp5432176.jpg");
			Image image2=new Image("file:0w00hui3yqsi27q7.jpg");
			Image image3 =new Image("file:The-Last-Of-Us-2-Wallpapers-Wallpaper-Cave.jpg");
			Image image4=new Image("file:67a657199d523f8c4e3a9175a3e19f1d.jpg");
//			Media media = new Media(new File(path).toURI().toString());  
//			MediaPlayer mediaPlayer = new MediaPlayer(media); 
//			MediaView mediaView = new MediaView(mediaPlayer);  
			ImageView imageview=new ImageView(image);
			ImageView imageview2=new ImageView(image3);
			ImageView imageview3=new ImageView(image2);
			ImageView imageview4=new ImageView(image4);
			
			
//			mediaPlayer.setAutoPlay(true);
			imageview.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
			imageview2.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview2.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
			imageview3.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview3.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
			imageview4.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
			imageview4.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
			
			
//			BorderPane root = new BorderPane();
		
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			VBox root1=new VBox();
			Button button=new Button("START NEW GAME");
			Button button2=new Button("HELP");
			Button button3=new Button("Back");
			Button button4=new Button("Back");
			DropShadow i=new DropShadow();
			InnerShadow i1=new InnerShadow();
			i.setColor(Color.RED);
			i1.setColor(Color.RED);
			InnerShadow i2=new InnerShadow();
			i2.setColor(Color.WHITE);
			button.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			button.setTextFill(Color.WHITE);
			button.setStyle("-fx-background-color:black");
			button.setLayoutX(630);
			button.setLayoutY(310);
			button.setEffect(i1);
			button2.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			button2.setTextFill(Color.WHITE);
			button2.setStyle("-fx-background-color:black");
			button2.setLayoutX(700);
			button2.setLayoutY(430);
			button3.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			button3.setTextFill(Color.WHITE);
			button3.setStyle("-fx-background-color:black");
			button3.setLayoutX(700);
			button3.setLayoutY(20);
			button2.setEffect(i1);
			button3.setEffect(i1);
			button4.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,25));
			button4.setTextFill(Color.WHITE);
			button4.setStyle("-fx-background-color:black");
			button4.setLayoutX(730);
			button4.setLayoutY(600);
			button4.setEffect(i1);
			Group root=new Group();
			Group root2 = new Group();
			root.getChildren().addAll(imageview,button,button2);
			Scene scene2=new Scene(root2);
			Scene scene = new Scene(root);
			Text des=new Text();	
			des.setText("The player starts off in a 15x15 grid map with just one hero and 10 zombies. The player can\r\n"
					+ "only see the directly adjacent cells next to their pool of heroes. The player then keeps taking\r\n"
					+ "his turn trying to collect vaccines, and cure or kill zombies. The game ends when the player\r\n"
					+ "has collected and used all vaccines or when all heroes have been overwhelmed and defeated by\r\n"
					+ "the zombies.\r\n"
					+ "The player only wins if he has successfully collected and used all vaccines and has 5 or more\r\n"
					+ "heroes alive");
			des.setFill(Color.WHITE);
			des.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,45));
			des.setStyle("-fx-background-color:black");
			des.setX(150);
			des.setY(300);	
			des.setEffect(i);
			root2.getChildren().addAll(imageview2,button3,des);
			button2.setOnAction(e -> primaryStage.setScene(scene2)); 
			button3.setOnAction(e -> primaryStage.setScene(scene)); 
			primaryStage.setResizable(true);	
			primaryStage.setScene(scene);
			Label user_id=new Label("Player Name");
			TextField tf1=new TextField(); 
		    Button submit = new Button("Submit"); 
		    user_id.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			user_id.setTextFill(Color.WHITE);
			user_id.setStyle("-fx-background-color:black");
		    submit.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			submit.setTextFill(Color.WHITE);
			submit.setStyle("-fx-background-color:black");
			submit.setLayoutX(710);
			submit.setLayoutY(490);
			tf1.setFont(Font.font("Chiller",FontWeight.EXTRA_BOLD,35));
			tf1.setStyle("-fx-background-color:black");
			tf1.setLayoutX(630);
			tf1.setLayoutY(400);
			user_id.setLayoutX(700);
			user_id.setLayoutY(320);
			submit.setEffect(i1);
			tf1.setEffect(i);
			user_id.setEffect(i1);
//		    GridPane field = new GridPane(); 
//		    field.addRow(0, user_id, tf1);  
//		    field.addRow(2,submit); 
//		    field.setLayoutX(350);
//		    field.setLayoutY(350);
		    Group root3 = new Group();
		    root3.getChildren().addAll(imageview3,submit,tf1,user_id,button4);
		    Scene submission=new Scene(root3); 
		    button.setOnAction(e -> primaryStage.setScene(submission)); 
		    button4.setOnAction(e -> primaryStage.setScene(scene)); 
		    GridPane gameBoard = new GridPane();
	        gameBoard.setPrefSize(755, 755);
	        gameBoard.setAlignment(Pos.CENTER);
	        for (int h = 0; h < 15; h++) {
	            for (int j = 0; j < 15; j++) {

	                Rectangle tile = new Rectangle(50, 50);
	                tile.setFill(Color.TRANSPARENT);
	                tile.setStroke(Color.WHITE);
	                tile.setEffect(i2);

	                Text text = new Text();
	                text.setFont(Font.font(40));


	                GridPane.setRowIndex(tile, h);
	                GridPane.setColumnIndex(tile, j);

	            
	                gameBoard.getChildren().addAll(tile, text);
	            }
	        }
//            gameBoard.setStyle("-fx background-image:url('file:67a657199d523f8c4e3a9175a3e19f1d.jpg')");
//	        gameBoard.getChildren().add(imageview4);
	        gameBoard.setStyle("-fx-background-image: url('file:d49j4ct-15acb69a-35e7-486a-92dc-c50498448571.jpg')");
	        
//	        gameBoard.setBackground(Background.fill(Color.FLORALWHITE));
	        gameBoard.prefHeight(Screen.getPrimary().getVisualBounds().getHeight());
			gameBoard.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
	        Scene scene3=new Scene(gameBoard);
		    submit.setOnAction(e -> primaryStage.setScene(scene3)); 
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@FXML
//	public void handleclosed(ActionEvent event) {
//		Stage stage=(Stage)button.getScene().getWindow();
//		stage.close();
//		stage.show();
//	}
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
	public void music() {
		String path = "file:The Last Of us - Theme song.mp3";
		Media media = new Media(Paths.get(path).toUri().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}////		primaryStage.show();
	//}
	public static void main(String[] args) {
		launch(args);
	}
	//public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		VBox root = new VBox();
//		Image img = new Image("C:\\Users\\walid\\Desktop\\Computer Programing Lab\\WhatsApp Image 2023-05-16 at 16.43.00.jpg");
//		ImageView view = new ImageView(img);
//		view.setFitHeight(100);
//		view.setFitWidth(100);
//		Button b = new Button();
//		b.setGraphic(view);
//		b.setPrefSize(100, 100);
//		root.getChildren().add(b);
//		Scene s = new Scene(root,1000,600);
//		primaryStage.setScene(s);
//		primaryStage.show();
//		}
}
