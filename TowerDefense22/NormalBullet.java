import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**This is a subclass of Bullet that has the specific damage and properties of a normal bullet
 * Nicholas Paul
 * @version 22
 */
public class NormalBullet extends Bullet
{
    int damage =5; //for the  first iteration of the loop the damage needs to be 5 
    
    /**Constructor for the icebullet class that accepts the damage as a parameter. 
     * 
     */
    public NormalBullet(int i){
        if(MyWorld.egg == false){
            t.setColor(java.awt.Color.RED);
            t.fill();
            setImage(t);
        }
        else{
            setImage("sinha1.png");
            
        }

        damage = i;
        
    }
    /**This is a method that gets the current damage. 
     * 
     */
    public int getDamage(){
        int i = damage;//*MyWorld.damageUpgrades or something like that
        return i;
        
    }
    public void act() 
    {
        super.bulletMovement();
    }    
}
