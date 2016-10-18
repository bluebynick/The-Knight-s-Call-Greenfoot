import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**A removeable image with the recoil as the assigned image.
 * Nicholas Paul
 * @version 22
 */
public class Recoil extends RemoveableImages
{
    /**Basic constructor for the recoil class
     * 
     */
    public Recoil(){
       timer =0;
       existing = false;
    }    
    /**This is a method that gets the x location of the closest enemy
     */
    public int enemyX(){
        return super.enemyX();
    }
    /**This is a method that gets the y location of the closest enemy
     */
    public int enemyY(){
        return super.enemyY();
    }
    /**This is a method that gets the object's location
     */
    public int actorX(){
        
        int i = this.getX();
        return 1;
    }
    /**This is a method that gets the object's location
     */
     public int actorY(){
        
        int i = this.getY();
        return 1;
        
    }
    public void act(){
        super.act();
        
    }  
}
