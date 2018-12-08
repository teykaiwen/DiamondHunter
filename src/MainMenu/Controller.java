package MainMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.neet.DiamondHunter.Main.*;
import application.Main;

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
    void runMapOnClick(ActionEvent event) {
    	Main.main(null);
    }

}
