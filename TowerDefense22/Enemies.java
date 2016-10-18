import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Enemies is an abstract class that provides functionality to the 
 * enemies in the game. It provides code for enemies to move and what
 * to do when they are killed. It provides a foundation for the subclasses
 * to specify their graphics and specific details seperate from each other
 * while having built off the same framework. The waypoint functionality 
 * and booleans is handled in this class.
 * 
 * Nicholas Paul
 * @version 22
 */
public abstract class Enemies extends Actor
{
    /**
     * 
     * Ennemies have
     * a different sprite than the tower
     * (location and size inherited)
     * 
     * 
     * Ennemies do:
     * move
     * interact with tower (and maybe obstacles)
     * disapear when killed
     * have the ability to be killed
     * 
     * 
     * 
     */
    int xx,y; //xx is the x position of the ennemy (1)
    int enemyX;
    int enemyY;
    protected int timer;
    protected int health;
    MouseInfo i;
    boolean movementBoo, touchingBoo;
    protected boolean boo3;
    protected GreenfootImage g;
    int speed;
    
    int waypoint1X, waypoint1Y, waypoint2X,waypoint2Y,waypoint3X,waypoint3Y,waypoint4X,waypoint4Y,waypoint5X,waypoint5Y;
    List <Tower> tower;
    ArrayList <Explosion> aList = new ArrayList();
    //Explosion exp;
    //Explosion exp1;
    boolean waypoint1boo, waypoint2boo,waypoint3boo,waypoint4boo,waypoint5boo;; //these are booleas that allow the ennemies to know when to change headings
     //GreenfootSound freeze = new GreenfootSound("freeze.mp3");  

    /**General constructor for the enemies class. 
     * The way point booleans and the locations of the waypoints are created here.
     */
    public Enemies(){
       touchingBoo = false;
       movementBoo = false;
       waypoint1boo = false;
       waypoint2boo = false;
       waypoint3boo = false;
       waypoint4boo = false;
       waypoint5boo = false;
       
       
       if(MyWorld.level % 2==0){
           waypoint1X =175;
           waypoint1Y =100;
           waypoint2X =50;
           waypoint2Y =100;
           waypoint3X =50;
           waypoint3Y =200;
           waypoint4X =250;
           waypoint4Y =200;
           waypoint5X =250;
           waypoint5Y =400;
       }
       else{
           waypoint1X =50;
           waypoint1Y =180;
           waypoint2X =250;
           waypoint2Y =180;
           waypoint3X =250;
           waypoint3Y =400;
       }
       this.boo3 = false;
       y=300;
       timer =1;
    }
    
    
    /**This is a method that provides the enemy's movement. It accepts the speed of the enemy.
     * In this class is runs a variety of conditions to determine where the enemy
     * is located and utilizes Greenfoot's move and turnTowards to make the enemy 
     * travel along the pre-determined path (given in the constructor).
     * 
     */
    public void movement(int i ){
        if(movementBoo == false){
           
           
        if((this.waypoint1boo == false) &&  (this.waypoint2boo == false) &&  (this.waypoint3boo == false) &&  (this.waypoint4boo == false&&  (this.waypoint5boo == false))){
             
            // System.out.println("ooooo");//if it hasn't reached any waypoints
             turnTowards(waypoint1X,waypoint1Y); //head it towards the first waypoint
             if(this.enemyY() >= waypoint1Y){ //if it reaches the first waypoint
                  this.waypoint1boo = true; //make it so the first waypoint 
             }
        }
         
        if((this.waypoint1boo == true) &&  (this.waypoint2boo == false) &&  (this.waypoint3boo == false) &&  (this.waypoint4boo == false)&&  (this.waypoint5boo == false)){     
            turnTowards(waypoint2X,waypoint2Y); //head it towards the second waypoint
             
             if(MyWorld.level % 2==0){//if(MyWorld.level ==2){
                 if((this.enemyX() <= waypoint2X)){
                     this.waypoint2boo = true;
                  }
             }
             else{
                 if((this.enemyX() >= waypoint2X)){
                     this.waypoint2boo = true;
                  }
             }
         }
         
        if((this.waypoint1boo == true) &&  (this.waypoint2boo == true) &&  (this.waypoint3boo == false) &&  (this.waypoint4boo == false)&&  (this.waypoint5boo == false)){        
            turnTowards(waypoint3X,waypoint3Y); //head it towards the third point
               
               if((this.enemyY() >= waypoint3Y-1)){
                   if(MyWorld.level % 2==0){//if(MyWorld.level == 2){ 
                       this.waypoint3boo = true;
                       
                    }
                    
                   else{ //if it's level  one the game ends here
                        MyWorld.lives -=1;
                        if(MyWorld.lives == 0){
                            getWorld().showText("Game Over", 200,200);
                            MyWorld.boo2 = false; //this ends the game
                        }
                        getWorld().removeObject(this);
                        
                        this.boo3 = true;
                   }
                   
                   
               }
         }   
         if((this.waypoint1boo == true) &&  (this.waypoint2boo == true) &&  (this.waypoint3boo == true) &&  (this.waypoint4boo == false)&&  (this.waypoint5boo == false)){   
             turnTowards(waypoint4X,waypoint4Y); //head it towards the third point
               
               if((this.enemyX() >= waypoint4X)){
                   this.waypoint4boo = true;
            }
            
        }
        if((this.waypoint1boo == true) &&  (this.waypoint2boo == true) &&  (this.waypoint3boo == true) &&  (this.waypoint4boo == true)  &&  (this.waypoint5boo == false)){    
            turnTowards(waypoint4X,waypoint4Y); //head it towards the third point
               
               if((this.enemyX() >= waypoint5X)){
                    waypoint5boo = true;
            }
            
        }
        if((this.waypoint1boo == true) &&  (this.waypoint2boo == true) &&  (this.waypoint3boo == true) &&  (this.waypoint4boo == true)  &&  (this.waypoint5boo == true)){
             turnTowards(waypoint5X,waypoint5Y);
            if((this.enemyY() >= waypoint5Y-1)){
                    MyWorld.lives -=1;
                        if(MyWorld.lives == 0){
                            getWorld().showText("Game Over", 200,200);
                            MyWorld.boo2 = false; //this ends the game
                        }
                        getWorld().removeObject(this);
                        
                        this.boo3 = true;
            }
        }
          move(i);             //i.e update the position
            
        }
        else{ // if it stops moving
            //g.setColor(java.awt.Color.BLUE); //make it frozen 
            //g.fill();
            
            move(0);
            if(isAtEdge()){ //(4) check for edge
                movementBoo = false;
            }
            
        }
        
        //setLocation(xx,y); //(5) set the location = to the current x 
                           //draw 
    }
    /**This is an abstract method to get the enemy's X.
       */
    public abstract int enemyX();
    /**This is an abstract method to get the enemy's X.
       */
    public abstract int enemyY();
    
    /* this was a method i made to checki if the enemy was clicked 
    public void isClicked(){
       i = Greenfoot.getMouseInfo(); //this gets the mouse info everytime it's clicked
       
        if(i!=null){ //if it's not null (cause this happens a lot)  
          
            if(Greenfoot.mouseClicked(this) == true){ //if the mouse pos goes overthe current actor pos
                World world; //create variable to store the world 
                world = getWorld(); //give the variable the correct world to hold
                world.removeObject(this); //use the variable to tell the world to remove the current object    
            }
        }
    }*/
    
    /**This is a method that determines the enemy's health. It takes in the inital health as a parameter.
     * It detemines if the enemy is touching a bullet, what kind of bullet
     * and handles the functionality if an enemy dies (spawning loot and 
     * removing enemies).
     * 
     */
    
    public void health(int i){
            if(this.boo3 == false){
                if(this.isTouching(NormalBullet.class)){  //if the enemy is touching a normal bullet
                        Actor e = this.getOneIntersectingObject(Bullet.class);//get the bullet
                        Bullet b = (Bullet) e; //cast the actor to a bullet
                        this.health -=b.getDamage(); //decrease the enemy's health by the current bullet damage. 
                        Explosion exp = new Explosion(); // create explosion
                        getWorld().addObject(exp,this.getX(),this.getY()); 
                        getWorld().removeObject(e); //remove the bullet
                        
                        
                        if(this.health <=0){ //if the enemy's health reaches 0
                            if(LevelOne.class.isInstance(this)){ //if this is an instance of levelone
                                Gold g = new Gold(); //spawn a gold
                                getWorld().addObject(g,this.enemyX(), this.enemyY());
                            }
                            else if(Wizard.class.isInstance(this)){ //if this is an instance of wizard
                                 Dropped g = new Dropped(); //spawn a bullet upgrade
                                 getWorld().addObject(g,this.enemyX(), this.enemyY()); 
                            }
                            
                            getWorld().removeObject(this); //remove the enemy
                            this.boo3 = true;
                        }
                        
                        timer ++;
                    }
              }
             if(this.boo3 == false){   //this condition is double so you can exit it from the first loop    
                if(this.isTouching(IceBullet.class)){ //if the enemy is touching an ice bullet
                        Actor e = this.getOneIntersectingObject(Bullet.class);//get the bullet
                        Bullet b = (Bullet) e; //cast the actor to a bullet
                        this.health -=b.getDamage(); //decrease the enemy's health by the current bullet damage. 
                        this.movementBoo = true; //stop this enemies movement
                        Explosion exp1 = new Explosion(); //
                        getWorld().addObject(exp1,this.getX(),this.getY());
                        getWorld().removeObject(e); //remove the bullet
                        
                        
                        if(this.health <=0){ //if the enemy's health reaches 0
                            if(LevelOne.class.isInstance(this)){ //if this is an instance of levelone
                                Gold g = new Gold(); //spawn a gold
                                getWorld().addObject(g,this.enemyX(), this.enemyY());
                            }
                            else if(Wizard.class.isInstance(this)){ //if this is an instance of wizard
                                BulletUpgrade g = new BulletUpgrade(); //spawn a bullet upgrade
                                 getWorld().addObject(g,this.enemyX(), this.enemyY()); 
                            }
                            
                            getWorld().removeObject(this); //remove the enemy
                            this.boo3 = true;
                        }
                        //System.out.println(this.health);
                        timer++;
                    }
                
            }
           
        
    }
            
    public void act(){
        
    }
}
