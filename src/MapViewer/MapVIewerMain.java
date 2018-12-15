package MapViewer;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class MapVIewerMain extends Application {


	@Override
	public void start(Stage primaryStage) {

		try {		
			//Extract boat and axe sprite from items.gif
			ImageIcon icon = new ImageIcon("@../../Resources/Sprites/items.gif");
			java.awt.Image image = icon.getImage();
		    BufferedImage buffImg = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		    java.awt.Graphics items = buffImg.getGraphics();
		    items.drawImage(image, 16, -16, null);
		    Controller.Boat = buffImg.getSubimage(16, 0, 16, 16);
		    Controller.Axe = buffImg.getSubimage(32, 0, 16, 16);
		    
		    //Open up Map Viewer application window when launched.
			Parent root = FXMLLoader.load(getClass().getResource("MapViewer.fxml"));
			Scene scene = new Scene(root,909,640);
			scene.getStylesheets().add(getClass().getResource("MapViewer.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Diamond Hunter Map");
		    
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
