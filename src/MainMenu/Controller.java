package MainMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import javax.swing.JFrame;

import com.neet.DiamondHunter.Main.*;
import MapView.Main;

public class Controller {
		
    @FXML
    private Button runGameButton;

    @FXML
    private Button mapViewerButton;

    private Stage stage;
    
    
    @FXML
    void runGameOnClick(ActionEvent event) {
    	Game.main(null);
    }
        
    @FXML
    public void runMapOnClick(ActionEvent event) throws IOException {
    	try 
    	{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MapView/MapView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } 
    	catch(Exception e) 
    	{
    		e.printStackTrace();
        }
    	  	
    		
    }

}
