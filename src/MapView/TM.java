package MapView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TM {
	
	int numCols;
	int numRows;
	int [][]map;
	static int width;
	static int height;
	int tileSize;
	
	public TM(int tileSize) {
		this.tileSize = tileSize;
	}
	
	// map loading function
	public void loadMap(String s) {
		
		try {
			
			InputStream in = getClass().getResourceAsStream(s);
			BufferedReader br = new BufferedReader(
						new InputStreamReader(in)
					);
			
			// getting the size of the map
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new int[numRows][numCols];
			width = numCols * tileSize;
			height = numRows * tileSize;
			
			String delims = "\\s+";
			for(int row = 0; row < numRows; row++) {
				String line = br.readLine();
				String[] tokens = line.split(delims);
				for(int col = 0; col < numCols; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// extracting images to draw on map
	public void drawMap(GraphicsContext g) {
		Image tile = new Image("@../../MapView/testtileset.gif");
		for(int row = 0; row < numRows; row++) {
			for(int col = 0; col < numCols; col++) {
				if(map[row][col] == 0) continue;
				
				// multiple conditions to determine which items to insert in
				// the current location of the map
				int rc = map[row][col];
				if(rc == 20){
					g.drawImage(tile, 0, 16, tileSize, tileSize, col*16, row*16, tileSize, tileSize);
				}
				else if(rc == 1){
					g.drawImage(tile,  16, 0, tileSize, tileSize, col*16, row*16, tileSize, tileSize);
				}
				else if(rc == 3){
					g.drawImage(tile, 48, 0, tileSize, tileSize, col*16, row*16, tileSize, tileSize);
				}
				else if(rc == 2){
					g.drawImage(tile, 32, 0, tileSize, tileSize, col*16, row*16, tileSize, tileSize);
				}
				else if(rc == 21){
					g.drawImage(tile, 16, 16, tileSize, tileSize, col*16, row*16, tileSize, tileSize);
				}
				else if(rc == 22){
					g.drawImage(tile, 32, 16, tileSize, tileSize, col*16, row*16, tileSize, tileSize);
				}
			}
		}
	}
	
}
