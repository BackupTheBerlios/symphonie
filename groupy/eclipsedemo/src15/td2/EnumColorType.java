/**
 * Created on 28 janv. 2005
 *@author jsie
 */
import java.awt.Color;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class EnumColorType {
    public enum CourseType{
        TD(Color.RED),
        TP(Color.GREEN),
        COURS(Color.BLUE),
        EXAMEN(Color.YELLOW);
        
        private final Color color;
        
        CourseType(Color color){this.color = color;}
        
        public Color getColor(){return color;}
        
        /*public Color getCourseTypeColor(CourseType type){
            return type.getColor();
        }*/
        
        public static CourseType getCourseType(String course){
            assert course!=null : "unable to find course empty";
            return valueOf(course);
        }
    }
    
    public static void main(String[] args){
        assert (args.length != 0) :"No parameter";
        for(String s : args){
            System.out.println("RGB Values of "+s+" = "+CourseType.getCourseType(s).getColor());

        }
        
        
    	
    }
}
