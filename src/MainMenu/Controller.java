package MainMenu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import com.neet.DiamondHunter.Main.*;

public class Controller {
		
    @FXML
    private Button runGameButton;

    @FXML
    private Button mapViewerButton;    
    
    @FXML
    void runGameOnClick(ActionEvent event) {
    	Game.main(null);
    }
        
    @FXML
    public void runMapOnClick(ActionEvent event) throws IOException {
    	try 
    	{
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

}
