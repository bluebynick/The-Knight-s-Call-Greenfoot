import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**This is a class that is used for the star loot that spawns upon towers. 
 * Nicholas Paul
 * @version 22
 */
public class BulletUpgrade extends Star
{
    ArrayList <Label> list;
    Label l;
    Tower t;
    /**This is a basic constructor for the class BulletUpgrade.
     */
    public BulletUpgrade(){
        list = new ArrayList();
        l = new Label("",25); //to add the new label
    }
    public void removability(){
    }
    /**This is the method that constantly checks whether or not the item is clicked.
     * If it is, it performs certain functionality. 
     */
    
    public void removed(){
        if(Greenfoot.mouseClicked(this)){
            Actor a = this.getOneIntersectingObject(Tower.class); //get the object it was spawned on
            t = (Tower) a; //make it a tower
            t.setDamage(5); //add 5 to the tower specific damage
            t.setLevel(1); //add 1 to the specific tower level
            l.setValue(t.getLevel());
            getWorld().addObject(l,t.getX(),t.getY());
            getWorld().removeObject(this);
            
            
        }
        
    }
    public void act() 
    {
        super.animation();// Add your action code here.
        removed();
    }    
}
