package drone_david;
/**
 *
 * @author davidlimbu
 */
import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * MyCanvas will contain info based on drone images and canvas size
 *
 */
public class MyCanvas extends Application {
	//variables and declarations related to the file
	int xCanvasSize = 1500; // constants for relevant sizes, default values set
	int yCanvasSize = 1000;
	//Images loaded in at the start
	Image drone = new Image("drone1.jpg");
        Image obstacle = new Image("pole.png");
        private ArrayList<Obstacle> allObjects = new ArrayList<Obstacle>();	
	
	GraphicsContext gc;
        public void drawIt (Image i, double x, double y) {
			// to draw centred at x,y, give top left position and x,y size
			// sizes/position in range 0..1, so scale to canvassize 
		gc.drawImage(i, x, y, 40, 30);
	}

	/**
	 * constructor for canvas
	 */
	public MyCanvas(GraphicsContext g, int xcs, int ycs) {
		//canvas variables
		gc = g;
		xCanvasSize = xcs;
		yCanvasSize = ycs;
	}
         public void clearCanvas() {
		gc.clearRect(0,  0,  xCanvasSize,  yCanvasSize);		// clear canvas
    }
	/**
	 * fill canvas 
	 * sets formatting for the canvas
	 * @param width
	 * @param height
	 */
	public void fillCanvas(int width, int height) {
		//sets colour, size and formatting for canvas
                //gc.drawImage(fbarena, width, width);
                
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, width, height);
		gc.setStroke(Color.BLACK);
		gc.strokeRect(0, 0, width, height);
	}
	/**
	 * update canvas
	 * will update the canvas and re-draw drone images
	 * @param myArena
	 */
	public void updateCanvas(DroneArena myArena,ArrayList<Obstacle> allObjects){
		//sets formatting and clears canvas
		gc.clearRect(0, 0, xCanvasSize, yCanvasSize);
		//fills the canvas
		fillCanvas(xCanvasSize, yCanvasSize);
		//draws all drones
		drawDrone(myArena);
                drawObstacle(myArena,allObjects);
		
		
	}
	
	/**
	 * draw drone
	 * draws images of drone
	 * @param myArena
	 */
	public void drawDrone(DroneArena myArena) {
		//loops through drone array multidrone
		for (Drone d : myArena.dronelist) {
			//draws images based on information inside of multidrone, giving size and location
			gc.drawImage(drone, d.getX(), d.getY(), 30, 20);
			}
                
		}
        public void drawObstacle(DroneArena myArena,ArrayList<Obstacle> allObjects){
        
        for(Obstacle ob: allObjects){
          gc.drawImage(obstacle, ob.getX(), ob.getY(), 80, 50);  
	}
        }
        
        
	 
	public int getXCanvasSize() {
		return xCanvasSize;
	}

	public int getYCanvasSize() {
		return yCanvasSize;
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
