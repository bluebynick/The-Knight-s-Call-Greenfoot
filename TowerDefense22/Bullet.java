import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; 

/**This is an abstract class for all the bullets in the Knight's call.
 * This class handles the range, and the position of the closest enemy 
 * which will be targeted and it sends the memory location of that enemy
 * to the targeting functionality in MyWorld. 
 * Nicholas Paul
 * @version 22
 */
public abstract class Bullet extends Actor
{
    int bSpeed;
    
    GreenfootImage t;
    
    
    boolean ice; //for freeze effects later
    boolean realBoo;
    int health;
    List <Enemies> b; 
    /**This is a general constructor for the class Bullet. 
     * It creates the size of the GreenfootImage and the bullet's speed.
     */
    public Bullet(){
        t = new GreenfootImage(15,15);
        bSpeed = 10;
        realBoo = true; //this is a boolean to make sure that the actor exists before checking it's locations

    }
    /**This is a method that works the x  range.
     * This method gets the distance between the x position of the bullet 
     * and the x position of the tower.
     */
    public int distanceX(){
        int i =0;
        List <Tower> a = this.getObjectsInRange(80, Tower.class); //get a tower within 80 of the current bullet 
        if(a.size() >=1){ //if there's a tower for it to attach to
            Tower t = a.get(a.size()-1); //get the most recent tower
            i = Math.abs(this.getX()-t.getX()); //find the disance between the bullet's x and the tower's x
        }  
        return i;
    }
    /**This is a method that works the y range.
     * This method gets the distance between the y position of the bullet 
     * and the x position of the tower.
     */
    public int distanceY(){
        int i =0;
        List <Tower> a = this.getObjectsInRange(80, Tower.class); //get a tower within 80 of the current bullet 
        if(a.size() >=1){ //if there's a tower for it to attach to
            Tower t = a.get(a.size()-1); //get the most recent tower
            i = Math.abs(this.getY()-t.getY()); //find the distance between the bullet's Y and the tower's Y
        }  
        return i;
    }
    /**This is a method that gets the x position of the enemy.
     */
    public int enemyX(){
        b = this.getObjectsInRange(80,Enemies.class); //get all enemies in range 
        int i =0;
        if(b.size() >=1){//if there's something for it to shoot
            Enemies t =  b.get(0);  //get the first added enemies to target
            i = t.getX();
       }
        return i;
    }
    /**This is a method that gets the y position of the enemy.
     */
    public int enemyY(){
        b = this.getObjectsInRange(80,Enemies.class); //get all enemies in range
        int i =0;
        if(b.size() >=1){//if there's something for it to shoot
            Enemies t = b.get(0); //get the first added enemies to target
            i = t.getY();
       }
        return i;
    }
    
    /**This is a method that makes the bullet move until it has eclipsed a range.
     * It gets the value of distanceX and distanceY and checks if it's > 50. If 
     * so, it removes the bullet.
     */    
    public void bulletMovement(){
        if(MyWorld.shot == true){
            move(10);            //i.e update the position
            if((this.isAtEdge()) || ((this.distanceX() >=50) || (this.distanceY() >=50))) { //check to see if the bullet has reached the range 
                getWorld().removeObject(this); //remove the object if it's at the edge
                realBoo = false; //tells it not to check below
                
            }
         }     
    }   
    /**An abstract method to get the current damage of the bullet.
     */
    public abstract int getDamage();
        
}
