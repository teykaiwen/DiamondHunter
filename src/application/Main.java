package application;

		import javafx.application.Application;
		import javafx.fxml.FXMLLoader;
		import javafx.stage.Stage;
		import javafx.scene.Scene;
		import javafx.scene.layout.BorderPane;

		import javafx.scene.Parent;


public class Main extends Application {


	@Override
	public void start(Stage primaryStage) {

		try {
			//BorderPane root = new BorderPane(); should be AnchorPane since my root is AnchorPane? but root is VBox

			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Parent root = FXMLLoader.load(getClass().getResource("MapView.fxml"));
			Scene scene = new Scene(root,700,550);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Diamond Hunter"); //

			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
