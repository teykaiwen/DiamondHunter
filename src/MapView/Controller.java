package MapView;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Controller {

	String x_axe;
	String y_axe;
	String x_boat;
	String y_boat;
	
	public static int browIndex;
	public static int bcolIndex;
	public static int arowIndex;
	public static int acolIndex;
	public static BufferedImage Axe;
	public static BufferedImage Boat;
					
	ImageView boat;
	ImageView axe;
	TM tm;
	
	GraphicsContext mapGraphics;
	
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
    private Canvas mapCanvas;
    
    public void initialize()
    {
    	tm = new TM(16);
		initCanvas();
    	try
    	{
    		tm = new TM(16);
    		initCanvas();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    void initCanvas() {
    	mapCanvas.setWidth((double) TM.width);
		mapCanvas.setHeight((double) TM.height);

		tm.loadMap("/Maps/testmap.map");
		mapGraphics = mapCanvas.getGraphicsContext2D();
		tm.drawMap(mapGraphics);
		mapCanvas.getGraphicsContext2D().drawImage(mapGraphics.getCanvas().snapshot(new SnapshotParameters(), null), 0, 0);
		
	}

	@FXML
    void get_X_Axe(ActionEvent event) {
    	x_axe = x_Axe.getText();

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
    	
    	Image image_boat = SwingFXUtils.toFXImage(Boat, null);
    	Image image_axe = SwingFXUtils.toFXImage(Axe, null);
    	
    	gridPane.getChildren().remove(boat);
    	gridPane.getChildren().remove(axe);
    	
    	// get latest update of boat and axe coordinates
    	
    	int ax = 37;
    	int ay = 26;
    	int bx = 4;
    	int by = 12;
    	
        browIndex = ((x_boat) == null || x_boat == "")?bx:Integer.parseInt(x_boat);
       	bcolIndex = ((y_boat) == null || y_boat == "")?by:Integer.parseInt(y_boat);
       	arowIndex = ((x_axe) == null|| x_axe == "")?ax:Integer.parseInt(x_axe);
       	acolIndex = ((y_axe) == null|| y_axe == "")?ay:Integer.parseInt(y_axe);
    	         	
    	
    	boat = new ImageView(image_boat);
    	axe = new ImageView(image_axe);
    	
    	//update location of boat and axe
    	gridPane.add(boat, browIndex, bcolIndex);
    	gridPane.add(axe, arowIndex, acolIndex);
    	    	

   	}
    @FXML
   	void playButton (ActionEvent event) throws IOException {
    	com.neet.DiamondHunter.Main.Game.main(null);
    }
}
