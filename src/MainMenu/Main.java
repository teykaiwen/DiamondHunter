package MainMenu;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import application.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import com.neet.DiamondHunter.GameState.PlayState;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {

		try {

			Parent root = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
			Scene scene = new Scene(root,440,443);
			scene.getStylesheets().add(getClass().getResource("FrontPageButton.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Diamond Hunter");
			primaryStage.setResizable(false);					
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}