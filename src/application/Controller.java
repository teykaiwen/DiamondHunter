package application;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import com.neet.DiamondHunter.Main.*;

public class Controller {

    @FXML
    private AnchorPane ok_button;
    @FXML
    private ImageView boat = new ImageView("D:\\Documents\\Computer Science\\Year 2\\Software Maintenance\\Coursework2\\SRC\\DiamondHunter\\Resources\\boat");
       
    public void printOKbutton() {
		System.out.println("Program is running..");
		com.neet.DiamondHunter.Main.Game.main(null);
	}
    
    

}
