package MainMenu;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.neet.DiamondHunter.Main.*;

public class Controller implements Initializable {
		
    @FXML
    private Button runGameButton;

    @FXML
    private Button mapViewerButton;   
    
    @FXML
    private ImageView welcomeText;
    
    //Launch Diamond Hunter game window when the run game button is clicked.
    @FXML
    void runGameOnClick(ActionEvent event) {
    	Game.main(null);
    }
        
    //Launch Map Viewer application window when Map Viewer button is clicked.
    @FXML
    public void runMapOnClick(ActionEvent event) throws IOException {
    	try 
    	{
    		// This function is to solve the problem that we cannot run
    		// multiple javafx application at once
    		Platform.runLater(new Runnable() {

				@Override
				public void run() {
					new MapView.Main().start(new Stage());
					
				}
    			
    		});
 
        } 
    	catch(Exception e) 
    	{
    		e.printStackTrace();
        }
    	  	
    		
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Transition of Main Menu Title 
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.seconds(1.5));
		fadeTransition.setNode(welcomeText);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();
		
		// Transition of runGameButton
		TranslateTransition playButton = new TranslateTransition();
		playButton.setDuration(Duration.millis(500));
		playButton.setNode(runGameButton);
		playButton.setFromX(-300);
		playButton.setToX(0);
		
		// Transition of mapViewerButton
		TranslateTransition mapButton = new TranslateTransition();
		mapButton.setDuration(Duration.millis(500));
		mapButton.setNode(mapViewerButton);
		mapButton.setFromX(300);
		mapButton.setToX(0);
		
		SequentialTransition sq = new SequentialTransition(playButton,mapButton);
		sq.play();
	}

}
