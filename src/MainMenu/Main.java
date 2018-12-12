package MainMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class Main extends Application{
	
	//Open up main menu application window when launched.
	@Override
	public void start(Stage primaryStage) {

		try {
			
			// initializing scene and stage for main menu
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
		//launching main menu
		launch(args);
	}
}