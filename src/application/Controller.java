package application;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import com.neet.DiamondHunter.Main.*;

public class Controller {

    @FXML
    private AnchorPane ok_button;
    
    public void printOKbutton() {
		System.out.println("Program is running..");
		com.neet.DiamondHunter.Main.Game.main(null);
	}

}
