package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ImageView boat;

    @FXML
    private ImageView axe;

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
    	String s = x_Axe.getText();
    }

    @FXML
    void get_Y_Axe(ActionEvent event) {
    	String s = y_Axe.getText();
    }
    
    @FXML
    void get_X_Boat(ActionEvent event) {
    	String s = x_Boat.getText();
    }

    @FXML
    void get_Y_Boat(ActionEvent event) {
    	String s = y_Boat.getText();
    }

}
