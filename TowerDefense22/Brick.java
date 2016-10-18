import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Brick is an abstract class that is used only for the graphic of the map
 * generation. 
 * Nicholas Paul
 * @version 22
 */
public abstract class  Brick extends Actor
{
    GreenfootImage g;
    /**Basic constructor for the class Brick.
     */

    public Brick(){
        g = new GreenfootImage(40,40);
        
    }
    
}
