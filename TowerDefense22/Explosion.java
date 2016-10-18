import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**A removeable image with the explosion as the assigned image.
 * Nicholas Paul
 * @version 22
 */
public class Explosion extends RemoveableImages
{
    /**This is a basic constructor for the Explosion class.
     */
    public Explosion(){
       timer =0;
       existing = false;
       //play a sound
    }  
    /**This act method calls the super's act method to envoke the removability.
     * 
     */
    public void act(){
        super.act();
        
     }
}
