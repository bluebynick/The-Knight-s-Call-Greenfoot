import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**A removeable image with the normal tower as the assigned image.
 * Nicholas Paul
 * @version 22
 */
public class Stamp extends RemoveableImages
{
    private int towerX,towerY;
    /**This is a method that gets the x location of this stamp.
     */
    public int towerX(){
        towerX = this.getX();
        return towerX;
    }
    /**This is a method that gets the y location of this stamp.
     */
    public int towerY(){
        towerY = this.getY();
        return towerY;
    }
    public void act(){
    }
}
