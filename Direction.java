
package drone_david;
/**
 *
 * @author davidlimbu
 */
import java.util.Random;



public class Direction {
    public enum DirectionsEnum {
    North,
    South,
    East,
    West;
    
     public static DirectionsEnum getRandomDirection() {
            Random random = new Random();
            //System.out.println(values().length);
           // System.out.println(random.nextInt(values().length));
           // System.out.println(values().length);
            //System.out.println(random.nextInt(values().length));
            return values()[random.nextInt(values().length)];
        }
     public DirectionsEnum getNextDirection(DirectionsEnum x){
    if (x == DirectionsEnum.North){
        return DirectionsEnum.East;
    }
    else if (x == DirectionsEnum.East){
        return DirectionsEnum.South;
    }
    else if (x == DirectionsEnum.South){
        return DirectionsEnum.West;
    }
    else if (x == DirectionsEnum.West){
        return DirectionsEnum.North;
    }
    return DirectionsEnum.North;
    }
    }
    
    
}
