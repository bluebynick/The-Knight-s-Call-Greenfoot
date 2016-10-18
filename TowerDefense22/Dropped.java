import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**This is a class that is used for the specific star loot dropped from killed enemies.
 * Nicholas Paul
 * @version 22
 */
public class Dropped extends Star
{
    /**This is a method that checks if the star is removed.
     */
    public void removed(){
        if(boo1 == false){
            if(Greenfoot.mouseClicked(this)){ //if the loot is clicked change the value of damage in the other class    
                
                for(int i =0; i<MyWorld.towers.size();i++){
                    BulletUpgrade b = new BulletUpgrade(); 
                    getWorld().addObject(b,MyWorld.towers.get(i).getX(),MyWorld.towers.get(i).getY());
                }
                getWorld().removeObject(this);
                //NormalBullet.damage += this.value;
                
                boo1 = true;
            }
        }
    }
    /**This method i just here becuase it's abstract in star.
     * 
     */
    public void removability(){
    }
    public void act() 
    {
        removed();// Add your action code here.
        super.animation();
    }    
}
