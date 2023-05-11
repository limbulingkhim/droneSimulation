package drone_david;
/**
 *
 * @author davidlimbu
 */
import javafx.scene.image.Image;

/*
 * obstacle which gets in way of other drones
 */
public class Obstacle extends Object {
	
	Image obstacle_1; //image of the obstacle

	public Obstacle() {
		
	}

	/**
	 * Obstacle
	 * @param ix x position of the obstacle
	 * @param iy y position of the obstacle
	 */
	public Obstacle(double ix, double iy) {
		super(ix, iy);
			//Image drone = new Image("drone1.jpg");
		obstacle_1 = new Image("pole.png"); //gets the image of the obstacle
	}
	
	/**
	 * drawObject
	 * calls drawObstacle
	 */

	public void drawObject(MyCanvas mc) {
		drawObstacle(mc);
	}
	
	/**
	 * drawObstacle
	 * @param mc canvas
	 */
	public void drawObstacle(MyCanvas mc) {
		mc.drawIt(obstacle_1, x/mc.getXCanvasSize(), y/mc.getYCanvasSize()); }

//draws the obstacle in the x and y position with size
                
        

	
	/**
	 * checkObject
	 */
	
	protected void checkObject(DroneArena b) {
		

	}
	
	/**
	 * adjustObject
	 */
	
	protected void adjustObject() {
		

	}
	
	/**
	 * saving
	 * string that will store data that will be saved
	 */

	public String toString() {
		return ("Obstacle at: " + x + " , "+ y);
	}
	
	/**
	 * getStrType
	 * return string defining drone type
	 */
	protected String getStrType() {
		return "House";
	}	

}
