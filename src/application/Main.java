package application;
	
import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	Player player;
	FileChooser filechooser;
	public void start(Stage primaryStage) {
		
		
		MenuItem open = new MenuItem("Open");
		Menu file = new Menu("file");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		
		filechooser = new FileChooser();
		
		open.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent e){
				
				player.player.pause();
				File file = filechooser.showOpenDialog(primaryStage);
				
				if(file != null){
					try {
						player = new Player(file.toURI().toURL().toExternalForm());
						Scene scene = new Scene(player, 1200, 700, Color.BLACK);
						primaryStage.setScene(scene);
						primaryStage.show();
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		player = new Player("file:///~/trailer.mp4");
		player.setTop(menu);
		Scene scene = new Scene(player, 1200, 700,Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
