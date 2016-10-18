import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**This is a class that is used for the specific star loot.
 * Nicholas Paul
 * @version 22
 */
public abstract class Star extends Loot
{
    /**This is a basic constructor for the class Star.
     */
    public Star(){
        value = 5;
        this.timer = 0;
        boo2 = false;
        boo3 = false;
        
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
    /**Abstract method to check if the star is removed. 
     */
    public abstract void removed();
    /**Method that handles the animation.
     */
    public void animation(){
        if(timer % 5 ==0){
           if(boo2 == false){
               this.setImage("stars1.png"); //change to star animation
            }
           else if(boo3 == false){
               this.setImage("stars3.png"); //change to star animation
            }
               
           else{
               this.setImage("stars2.png");
            }
           boo2 = ! boo2; 
           boo3 = ! boo2;
           
        }
       this.timer++;
    }
}
