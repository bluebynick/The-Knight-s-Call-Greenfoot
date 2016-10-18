import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**An image with the different menu square as the image
 * Nicholas Paul
 * @version 22
 */
public class MenuGraphic extends RemoveableImages
{
    GreenfootImage g;
    /**In this basic constructor the greenfoot image is created and assigned to the class's i
     * 
     */
    public MenuGraphic(){
        g = new GreenfootImage(210,700);
        
        g.setColor(new Color(105,105,105) ); //make a new colour from java.awt.color
        g.fill();
        setImage(g);
        
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
