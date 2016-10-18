import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**This is a class that is used for the star loot that spawns upon towers. 
 * Nicholas Paul
 * @version 22
 */
public class Gold extends Loot
{
    /**This is a basic constructor for the class Gold.
     * 
     */
    public Gold(){
        value = 10;
        this.timer = 0;
        
    }
    /**This is a method that gets the x location of the loot.
     */
    public int getX(){
        int i = this.getX();
        return i;
    }
    /**This is a method that gets the y location of the loot.
     */
    public int getY(){
        int i = this.getY();
        return i;
    }
    /**Method that checks if it's removable.
     */
    public void removability(){
        if(boo1 == false){
            if(Greenfoot.mouseClicked(this)){
                getWorld().removeObject(this);
                MyWorld.coins += this.value;
                boo1 = true;
            }
        }
    }
    public void act() 
    {
       removability();
       if(timer % 5 ==0){
           if(boo2 == false){
               this.setImage("coin1.png");
            }
           else{
               this.setImage("coin6.png");
            }
           boo2 = ! boo2; 
           
        }
       this.timer++;
    }    
}
