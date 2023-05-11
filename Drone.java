/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drone_david;
/**
 *
 * @author davidlimbu
 */
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Drone {
    protected int x ,y ,DroneID,dx,dy;
    protected Direction.DirectionsEnum direction;
    private static int DroneCount = 0;
    protected Image droneImage;
    
    //constructor
    public Drone (int bx,int by,Direction.DirectionsEnum dir){
        x = bx;
        y = by;
        DroneID = DroneCount++;
        direction = dir;
        dx = 1;
        dy = 1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
 

   public void setXY(int nx, int ny){
        x = nx;
        y = ny;
        
    }
   public String toString(){
    
        return "Drone "+ DroneID + " at " + x +","+y+" with direction -> "+direction;
    }
   public void tryToMove(DroneArena d){
        int newx=0;int newy =0;
        if(direction == Direction.DirectionsEnum.North){
            newx = x+0;
            newy = y+dy;
        }
        if(direction == Direction.DirectionsEnum.South){
            newx = x+0;
            newy = y-1;
        }
        if(direction == Direction.DirectionsEnum.East){
            newx = x+dx;
            newy = y+0;
        }
        if(direction == Direction.DirectionsEnum.West){
            newx = x-1;
            newy = y+0;
        }
        
        boolean status = d.canMoveHere(newx,newy) ;
        if(status == true){
        System.out.println("Updating Drones");
        this.x=newx;
        this.y=newy;
        System.out.println(this.toString());
        }
        else{
            direction = direction.getNextDirection(direction);
        }
        
    
    }
   
   
}
