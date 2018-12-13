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
import javafx.scene.input.KeyEvent;
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
    
    //Generating Map Viewer map in Map Viewer application window.
    public void initialize()
    {
    	tm = new TM(16);
		initCanvas();
    	try
    	{
    		tm = new TM(16);
    		initCanvas();   		
    		
    		Image image_boat = SwingFXUtils.toFXImage(Boat, null);
        	Image image_axe = SwingFXUtils.toFXImage(Axe, null);	    	
    		boat = new ImageView(image_boat);
			axe = new ImageView(image_axe);
    		gridPane.add(boat, 4, 12);
        	gridPane.add(axe, 37, 26);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    //Function plotting map in map viewer 
    void initCanvas() {
    	mapCanvas.setWidth((double) TM.width);
		mapCanvas.setHeight((double) TM.height);

		tm.loadMap("/Maps/testmap.map");
		mapGraphics = mapCanvas.getGraphicsContext2D();
		tm.drawMap(mapGraphics);
		mapCanvas.getGraphicsContext2D().drawImage(mapGraphics.getCanvas().snapshot(new SnapshotParameters(), null), 0, 0);
		
	}

    //Getting user input for axe x-coordinate
	@FXML
    void get_X_Axe(KeyEvent event) {
		x_Axe.textProperty().addListener((observable, oldValue, newValue) -> {
    		x_axe = x_Axe.getText(); 
    	});

    }

	//Getting user input for axe y-coordinate
    @FXML
    void get_Y_Axe(KeyEvent event) {
    	y_Axe.textProperty().addListener((observable, oldValue, newValue) -> {
    		y_axe = y_Axe.getText(); 
    	});
    }
    
  //Getting user input for boat x-coordinate
    @FXML
    void get_X_Boat(KeyEvent event) {
    	x_Boat.textProperty().addListener((observable, oldValue, newValue) -> {
    		x_boat = x_Boat.getText(); 
    	});
    	  	
    }

  //Getting user input for boat y-coordinate
    @FXML
    void get_Y_Boat(KeyEvent event) {
    	y_Boat.textProperty().addListener((observable, oldValue, newValue) -> {
    		y_boat = y_Boat.getText(); 
    	});
    }

    //Button function which set axe and boat sprite on both Map Viewer and Diamond Hunter application window.
    @FXML
	void confirmButton (ActionEvent event) throws IOException {
    	
    	Image image_boat = SwingFXUtils.toFXImage(Boat, null);
    	Image image_axe = SwingFXUtils.toFXImage(Axe, null);
    	
    	// removing existing axe and boat
    	gridPane.getChildren().remove(boat);
    	gridPane.getChildren().remove(axe);
    	    	    	
    	int ax = 37;
    	int ay = 26;
    	int bx = 4;
    	int by = 12;
    	
    	//set boat and axe sprite location to user desirable location else to default when user doesn't input any coordinates
        browIndex = ((x_boat) == null || x_boat == "")?bx:Integer.parseInt(x_boat);
       	bcolIndex = ((y_boat) == null || y_boat == "")?by:Integer.parseInt(y_boat);
       	arowIndex = ((x_axe) == null|| x_axe == "")?ax:Integer.parseInt(x_axe);
       	acolIndex = ((y_axe) == null|| y_axe == "")?ay:Integer.parseInt(y_axe);
    	         	    	
    	boat = new ImageView(image_boat);
    	axe = new ImageView(image_axe);
    	   	
    	//update location of boat and axe sprite
    	gridPane.add(boat, browIndex, bcolIndex);
    	gridPane.add(axe, arowIndex, acolIndex); 	    
   	}
    
    //Launch Diamond Hunter application window when Play button is clicked
    @FXML
   	void playButton (ActionEvent event) throws IOException {
    	com.neet.DiamondHunter.Main.Game.main(null);
    }
}
