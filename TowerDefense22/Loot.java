import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**This is a class that is used for the loot dropped from killed enemies.
 * Nicholas Paul
 * @version 22
 */
public abstract class Loot extends Actor
{
    protected boolean boo1,boo2,boo3; 
    protected int value,timer;
    /**Basic constructor for the Loot class.
     */
    public Loot(){
        boo1 = false;
    }
    /**Abstract method that gets the x location of the loot.
     */
    public abstract int getX();
    /**Abstract method that gets the y location of the loot.
     */
    public abstract int getY();
    /**Abstract method that checks if it's removable.
     */
    public abstract void removability();
}
