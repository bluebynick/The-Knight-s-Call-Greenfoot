import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**This is a subclass of Bullet that has the specific damage and properties of icebullet.
 * Nicholas Paul
 * @version 22
 */
public class IceBullet extends Bullet
{
    int damage =1;
    /**Constructor for the icebullet class that accepts the damage as a parameter. 
     * 
     */
    public IceBullet(int i){
        if(MyWorld.egg == false){
            t.setColor(java.awt.Color.BLUE);
            t.fill();
            setImage(t);
        }
        else{
            setImage("sinha1.png");
            
        }

        damage = i; //small damage 'cause ice freezes
    }
    /**This is a method that gets the current damage. 
     * 
     */
    public int getDamage(){
        int i = damage;
        return i;
        
    }
    public void act() 
    {
        super.bulletMovement();
    }    
}
