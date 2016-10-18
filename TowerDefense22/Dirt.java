import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.Random;

/**This is a class that is used for the non road locations in the game.
 * Nicholas Paul
 * @version 22
 */
public class Dirt extends Brick
{
    Random rn;
    /**Basic constructor for the class Dirt.
     */
    public Dirt(){
        if(MyWorld.level % 2 ==0){
           g.setColor(new Color(178, 34, 34)); 
        }
        else{
            g.setColor(new Color(0,100,0));
        }
        g.fill();
        setImage(g);
        
        rn = new Random();
        
    }
    /**This is a method that makes the a new random colour.
     */
    public Color c(){
        Color c = new Color(rn.nextInt(251),rn.nextInt(251),rn.nextInt(251)); 
       
        return c;
    }
    
    public void act(){
        if(MyWorld.egg == true){
            g.setColor(c());
            g.fill();
        }
    }
    
}
