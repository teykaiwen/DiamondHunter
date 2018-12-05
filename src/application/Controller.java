package application;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.neet.DiamondHunter.Main.*;

public class Controller {

	String x_axe;
	String y_axe;
	String x_boat;
	String y_boat;
		
	ImageView boat;
	ImageView axe;
	
	@FXML
    private GridPane gridPane;
	
    @FXML
    private BufferedImage b;

    @FXML
    private BufferedImage a;

    @FXML
    private TextField x_Axe;

    @FXML
    private TextField y_Axe;

    @FXML
    private TextField x_Boat;

    @FXML
    private TextField y_Boat;

    @FXML
    void get_X_Axe(ActionEvent event) {
    	x_axe = x_Axe.getText();
    	//System.out.println(x_axe);
    }

    @FXML
    void get_Y_Axe(ActionEvent event) {
    	y_axe = y_Axe.getText();
    }
    
    @FXML
    void get_X_Boat(ActionEvent event) {
    	x_boat = x_Boat.getText();
    }

    @FXML
    void get_Y_Boat(ActionEvent event) {
    	y_boat = y_Boat.getText();
    }

    @FXML
	void confirmButton (ActionEvent event) throws IOException {
    	
    	// read image of boat and axe
    	File f_boat = new File("@../../Resources/boat.png");
    	File f_axe = new File("@../../Resources/axe.png");
    	b = ImageIO.read(f_boat);
    	a = ImageIO.read(f_axe);
    	Image image_boat = SwingFXUtils.toFXImage(b, null);
    	Image image_axe = SwingFXUtils.toFXImage(a, null);
    	
    	gridPane.getChildren().remove(boat);
    	gridPane.getChildren().remove(axe);
    	
    	// get latest update of boat and axe coordinates
       	Integer browIndex = ((x_boat)!= null)?Integer.valueOf(x_boat):4;
    	Integer bcolIndex = ((y_boat)!= null)?Integer.valueOf(y_boat):12;
    	Integer arowIndex = ((x_axe)!= null)?Integer.valueOf(x_axe):37;
    	Integer acolIndex = ((y_axe)!= null)?Integer.valueOf(y_axe):26;
    	
    	boat = new ImageView(image_boat);
    	axe = new ImageView(image_axe);
    	
    	//update location of boat and axe
    	gridPane.add(boat, browIndex, bcolIndex);
    	gridPane.add(axe, arowIndex, acolIndex);
    	
    	//com.neet.DiamondHunter.Main.Game.main(null);
   	}
}
