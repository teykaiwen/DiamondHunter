package MapViewer;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
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
    	         	    	
       	// error handling to alert user of invalid item position
       	if(browIndex>39||bcolIndex>39||arowIndex>39||acolIndex>39) {
       		alert(event);
       	}else {
       		if(tm.map[bcolIndex][browIndex] == 20|| tm.map[bcolIndex][browIndex] == 21) {
           		alert(event,0,1);
           	}
           	if(tm.map[acolIndex][arowIndex] == 20||tm.map[acolIndex][arowIndex] == 21) {
           		alert(event,0,0);
           	}
           	if(tm.map[bcolIndex][browIndex] == 22) {
           		alert(event,1,1);
           	}
           	if(tm.map[acolIndex][arowIndex] == 22) {
           		alert(event,1,0);
           	}
       	}
       	
       	
    	boat = new ImageView(image_boat);
    	axe = new ImageView(image_axe);
    	   	
    	//update location of boat and axe sprite
    	gridPane.add(boat, browIndex, bcolIndex);
    	gridPane.add(axe, arowIndex, acolIndex); 	    
   	}
    
    // function to pop out alert box
    
    void alert (ActionEvent event) {
    	Alert al = new Alert(Alert.AlertType.INFORMATION);
    	al.setTitle("Warning");
    	al.setHeaderText("Warning: Invalid item position.");
    	al.setContentText("The item position is out of scope. Please readjust the item position for a better game experience.");
    	al.showAndWait();
    }
    
    // function with flags to pop out specific alert box
    void alert (ActionEvent event, int flag_position, int flag_item) {
    	
    	Alert al = new Alert(Alert.AlertType.INFORMATION);
    	al.setTitle("Warning");
    	al.setHeaderText("Warning: Invalid item position.");
    	
    	// when flag_item is 1, the item is boat
    	// when flag_position is 1 ,the item is place in the river.
   	
    	if(flag_position==1) {
    		if(flag_item==1) {
    			al.setContentText("The boat is in the river. Please readjust the item position for a better game experience.");
    		}else {
    			al.setContentText("The axe is in the river. Please readjust the item position for a better game experience.");
    		}  		
    	}
    	else{
    		if(flag_item==1) {
    			al.setContentText("The boat is on a tree. Please readjust the item position for a better game experience.");
    		}else {
    			al.setContentText("The axe is on a tree. Please readjust the item position for a better game experience.");
    		}
    	}
    	
    	al.showAndWait();
    }
    
    //Launch Diamond Hunter application window when Play button is clicked
    @FXML
   	void playButton (ActionEvent event) throws IOException {
    	com.neet.DiamondHunter.Main.Game.main(null);
    }
}
