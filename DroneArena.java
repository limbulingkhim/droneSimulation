
package drone_david;
/**
 *
 * @author davidlimbu
 */
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.ListView;


 
public class DroneArena {
    Random randomGenerator = new Random();
    
    private int xmax,ymax,drone_x,drone_y;
    //public Drone d;
    public ArrayList<Drone> dronelist;
    double xSize, ySize, randomX, randomY, randomAngle, randomSpeed;					// size of arena, random angle, position and speed of the objects
    public ArrayList<Obstacle> allObjects;
    
    public DroneArena(int bx,int by){
        xmax = bx;
        ymax = by;
        dronelist = new ArrayList<Drone>();
        allObjects = new ArrayList<Obstacle>();	
             
    }
    
    
    public int getXmax() {
        return xmax;
    }

    public void setXmax(int xmax) {
        this.xmax = xmax;
    }

    public int getYmax() {
        return ymax;
    }

    public void setYmax(int ymax) {
        this.ymax = ymax;
    }
    public void addDrone(MyCanvas mc, ListView<Drone> Objects,ListView<Obstacle> Object) {
		//randomly generates direction and x and y based on arena
		int newx;
		int newy; // and
		boolean check = true;
                while(check){
                drone_x = randomGenerator.nextInt(xmax);
                drone_y = randomGenerator.nextInt(ymax);
                if(drone_x>0 && drone_x<xmax-20 && drone_y>0 && drone_y<ymax-25 && isHere(drone_x,drone_y)==false){
                Direction.DirectionsEnum x = Direction.DirectionsEnum.getRandomDirection();
                dronelist.add(new Drone(drone_x,drone_y,x));
                check = false;
                }
		// new drone with unique X & Y and random direction
		mc.drawDrone(this);
		Animation.fillList(Objects,Object);

	}}
  
   
    


    
    public void moveAllDrones(MyCanvas mc){
       for(Drone dr: dronelist){       
           dr.tryToMove(this) ;
	  }
       mc.updateCanvas(this,allObjects);
       
    }
    public void addObstacle(MyCanvas mc,ListView<Drone> Objects,ListView<Obstacle> Object) {
        drone_x = randomGenerator.nextInt(xmax);
        drone_y = randomGenerator.nextInt(ymax);
    allObjects.add(new Obstacle(drone_x, drone_y));
    Animation.fillList(Objects,Object);
    }

    public String toString(){
        String s = "Drone Arena is " + xmax +" by "+ymax+"\n";
        for(Drone dr: dronelist){
            s = s + dr.toString() + "\n";
            //System.out.println(dr.toString());
	  }
        for(Obstacle Ob: allObjects){
            s = s + Ob.toString() + "\n";
            //System.out.println(dr.toString());
	  }
        
        return s;
        
    }
     public boolean canMoveHere(int nx,int ny ){
          if(nx>0 && nx<xmax-20  && ny>0 && ny<ymax-25 && isHere(nx,ny)==false ){
              return true;  
          }
          else{
          return false;
          }
            
        
    
    }
     
     public void drawArena(MyCanvas mc) {
		for (Obstacle b : allObjects) b.drawObject(mc);		// draw all objects
	}
	
    public boolean isHere (int sx, int sy) {
        int j =0;int k = 0;
            for(Drone dr: dronelist){
             if(sy==dr.getY() || sy+30==dr.getY() || sy-30==dr.getY() ){     
            ++j;
            }
             if(sx==dr.getX() || sx+30==dr.getX() || sx-30==dr.getX() ){     
            ++k;
            }
             else{
            continue;
            }
            }
             
             for(Obstacle b : allObjects){
             if(sy==b.getY() || sy+30==b.getY() || sy-30==b.getY() ){     
            ++j;
            }
             if(sx==b.getX() || sx+30==b.getX() || sx-30==b.getX() ){     
            ++k;
            }
            
            else{
            continue;
            }
           
                       
	   }
            if(j>0 && k>0){
                System.out.println("Can't Move!");
            return true;
            }
            else{
            return false;
            }
   
    }

    

    public void adjustObjects() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void checkObjects() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
    
}
