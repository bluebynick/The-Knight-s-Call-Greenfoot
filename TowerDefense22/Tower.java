import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**This is a class for the towers  
 * Nicholas Paul
 * @version 22
 */
public class Tower extends Actor
{
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.

     * tower has
     * health
     * location
     * image
     * level (health points dependant on level)
     * spawn (so it's accesible by ennemies)

     * Tower does
     * upgrade
     * shoots bullets
    
    **/
    private int towerX,towerY;
    public int damage;
    protected int level, razeTimer;
    protected boolean canRaze, razeTimerBoo;
    GreenfootImage towerImage;
    
    
    /**Basic constructor for the class Tower.
     */
    public Tower(){
        //towerImage =towerImage.png;
        this.damage =5;
        if(MyWorld.egg == true){ //your bullets have no effect on chuck norris
             this.damage = 0;
        }
        this.razeTimer =0;
        this.canRaze = false;
        this.razeTimerBoo = false; //this is a timer that makes the razing only happen after a certain amount of time   
        level = 1;
    }
    /**This is a method that sets the damage of this specific tower. It accepts a damage to be added to the current and it returns an int.
     */
    public int setDamage(int i){
         this.damage+=i;
         
         return damage;
    }
    /**This is a method that gets the damage of this specific tower and it returns an int.
     */
    public int getDamage(){
        return this.damage;
    }
    /**This is a method that sets the level of this specific tower. It accepts a level to be added to the current and it returns an int. 
     */
    public int setLevel(int i){
         this.level+=i;
         return level;
    }
    /**This is a method that gets the level of this specific tower and it returns an int. 
     */
    public int getLevel(){
        return this.level;
    }
    /**This is a method that increases the level of this specific tower. 
     */
    public void levelUp(){
        level +=1;
    
    }
    /**This is a method that gets the x location of the tower and it returns an int.
     */

    public int towerX(){
        towerX = this.getX();
        return towerX;
    }
    /**This is a method that gets the y location of the tower and it returns an int.
     */

    public int towerY(){
        towerY = this.getY();
        return towerY;
    }
    /**This is a method that checks whether or not this.isTouching anything it shouldn't be and it returns an boolean.
     */

    public boolean canSpawn(){
        boolean spawn = true;
        if(this.isTouching(Road.class) || this.isTouching(Tower.class) || this.isTouching(CastleSprite.class)){
            spawn = false;
            this.canRaze = true;
            //System.out.println("heyyy");
        }
        
        return spawn;
    }
    /**This is a method that creates a timer then allows the specific tower to raze.
     */
    public void razeTimer(){ //this is a method to control that the razing is not just the placing of the tower
        if(this.razeTimerBoo == true){ //if the timer is told to start
            if(razeTimer <5){ //if the timer is less than or equal to 9
                razeTimer+=1; //add 1
            }
            if(razeTimer >=5){ //if it's greater than or equal to 10
                this.canRaze = true; //make the razing able to happen
            }
        }
        
    }
    /**This is a method that handles the removing of towers.
     */
    public void raze(){
        if(this.canRaze==true){
            if( Greenfoot.mouseClicked (this)){// if the mouse is clicked on any target
                List <RangeImg> a = this.getObjectsInRange(80, RangeImg.class); //get any ranges in range of the tower
                getWorld().removeObject(a.get(0)); //remove the range
                Actor e = this.getOneIntersectingObject(Label.class); //get the level label
                Label t = (Label) e; //make it a Label
                getWorld().removeObject(t);
                MyWorld.towers.remove(this); //remove this tower from the towers arraylist
                getWorld().removeObject(this); //remove this tower
             }
        }
            }
    
    public void act(){
        razeTimer();
        raze();
    }  
}