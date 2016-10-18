import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**LevelOne is a subclass of enemies with it's specific health and speed determined by the level.
 * Nicholas Paul
 * @version 22
 */
public class LevelOne extends Enemies
{
    /**
     * Act - do whatever the LevelOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Ennemies enm;
     int timer;
    boolean turn;
    /**This is the constructor for the LevelOne class. It accept and int i to represent the speed and int j to be the enemy's health.
     * Specifically the waypoint booleans and the movement booleans are turned
     * false until need true.
     */
    public LevelOne(int i,int j){ //the first one's speed and the second one's health
        touchingBoo = false;
        this.waypoint1boo = false;
        this.waypoint2boo = false;
        movementBoo = false;
        this.health = j;
        timer = 0;
        turn = false;
        
        speed =i;
    }
    /**This is a method to determine the x location of the enemy. 
     */
    public int enemyX(){
        enemyX = this.getX();
        return enemyX;
    }
    /**This is a method to determine the y location of the enemy. 
     */
    public int enemyY(){
        enemyY = this.getY();
        return enemyY;
    }
    
    public void act() 
    {   
        super.movement(speed); //go through the movement method in the super
        super.health(health); //check the health
        if(MyWorld.egg == false){ //if it's not easter egg time
            if( turn == true) setImage("walk1.png");
            
            else setImage("walk2.png");
            
            if (timer  % 20==0){
                turn = !turn;
            }
         }
        else{ //it's chuck time
            if( turn == true) setImage("head1.png");
            
            else setImage("head2.png");
            
            if (timer  % 10==0){
                turn = !turn;
            }
        }
        
        timer++;
    }    
}
