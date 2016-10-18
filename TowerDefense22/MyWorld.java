import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;  //ArrayLists

/**MyWorld is the princile world class where the game is created and run. 
 * 
 * This is a tower defense game with a lot of funtionality. It is highlighted 
 * in the attached word doc exactly what functionality is included. There is 
 * also an attached .txt file that may help to locate some of the functionality.
 * enjoy!
 * 
 * @Nicholas Paul
 * @version 18
 * Sept 30th 2016
 */
public class MyWorld extends World
{
    int height, timer, enemyCounter,waves;
    boolean boo5,boo6,boo7;
    
    static boolean shot = false;
    static boolean hit = false;
    static boolean music = false; // a static boolean for the music
    static boolean boo2;
    static boolean boo4;
    static boolean egg  =false;
    static int lives =5;
    static int level =3;
    static int freezeShots = 1;
    static int coins = 100;
    static ArrayList <Sounds> ss = new ArrayList();
    
    Label l,c,lvl,lvs,a,s,d;
    Button b,r,t,y;
    Stamp stamp;
    Stamp2 stamp2;
    //Tower twr;
    static ArrayList <Tower> towers;
    ArrayList <Enemies> e;
    CastleSprite cas;
    Tower currentTower;
    ArrayList <ArrayList> listOfArrayLists;
    Road rd;
     Tower twr; //declare the actor twr
    
    MenuScreen menu = new MenuScreen(); //this needs to be decalred up here so it doesn't make a new menu, and therefore a new song, each time the constructor is called
    MyWorld levelUp;
    Instructions instructions = new Instructions();
    boolean turn1, ice,musicBoo;
    
    RangeImg range;
    
    /**
     * Basic, no parameter constructer for MyWorld. 
     * This immediately sets the world to an instance of MenuScreen, whilst
     * generating a world by initializing the variables and calling create
     * world in the background. The world is then changed from MenuScreen 
     * back to the already created game world. 
     * 
     */
   
    public MyWorld()
    {    
       super(600, 400, 1);
      
       Greenfoot.setWorld(menu); //commented out for ease of work rn
       
       height = 10;
       timer = 0;
       
       turn1 = false;
       ice = false;
       boo2 = false;
       boo4 = false;
       boo5 = false;
       boo6 = false; //towers
       boo7 = false; //buttons
       musicBoo= false;
       waves = 1;
       lives = 5;
       
       MenuGraphic m = new MenuGraphic();
       addObject(m,495,75); //this is the graphic behind the shop
       
       createWorld();
       
       stamp = new Stamp(); //this object needs to be here
       addObject(stamp,525,200);
       
       stamp2 = new Stamp2(); //this object needs to be here
       addObject(stamp2,525,275);
       
       cas = new CastleSprite();
       addObject(cas,250,350);
       cas.turnTowards(0,cas.getY()); //turn it towards the top
       
       b = new Button(100,50);
       addObject(b,500,350);
       
       l = new Label("back", 50);
       addObject(l,500,350);
       
       
       
       s = new Label("Next Level?", 25); //these labels need to be declaredbut not added so as to not break the game
       d = new Label("Restart", 25);
       a = new Label("Level Complete", 25);   
        
       
       
       enemyCounter =1;
        
       
       towers = new ArrayList<Tower>();       
       
       
        
    }
     /**
      * This is an initializer method that resets all the static variables.
      * It is used when the game uses it's restart feature. 
      */
    public void initialize(){ //dang it sinha
        shot = false;
        hit = false;
        music = false; // a static boolean for the music
        boo2 = false;
        boo4 =false;
        lives =5;
        level =1;
        freezeShots = 1;
        coins = 100;
    }
    
    /**This is a method used to create the map. 
     * This method crreates an ArrayList to hold ArrayLists, each one being 
     * populate with specific parameters of ones and zeroes. The method then
     * scans each ArrayList in the ArrayList of ArrayLists for ones and 
     * generates a road at the index of the list x40 for accurate grid placement.
     * All remaining zeroes are generated as dirt blocks.
     * 
     */
    
    public void createWorld(){
        
        listOfArrayLists = new ArrayList<ArrayList>(); //this is a 2d ArrayList. his name is bob. he says hi. it's basically an arraylist of arraylists. holy crap it took a long time
        
    
        if(level % 2 ==0){
            for(int i = 0; i < 10; i++){ // each 'y' row
                
                ArrayList <Integer> tempArray = new ArrayList<Integer>(); //new arraylist stored in temparray
                
                for(int j = 0; j < 10; j++){ //populate specific temparrays
                    if(((i >=0) && i<=1) && (j ==4)){
                        tempArray.add(1);
                    }
                    else if((i ==2) && ((j >=1) && (j <=4))){
                        tempArray.add(1);
                    }
                    else if(((i >=2) && (i<=4)) && (j ==1)){
                        tempArray.add(1);
                    }
                    else if((i ==5) && ((j >=1) && (j <=6))){
                        tempArray.add(1);
                    }
                    else if(((i >=5) && i<=9) && (j ==6)){
                       tempArray.add(1); 
                    }
                    
                    else{
                        tempArray.add(0);
                    }
                    
                }
                listOfArrayLists.add(tempArray); //add temparray to the arraylist of arraylists
            }
        }
        
        else{
            for(int i = 0; i < 10; i++){ // each 'y' row
                
                ArrayList <Integer> tempArray = new ArrayList<Integer>(); //new arraylist stored in temparray
                
                for(int j = 0; j < 10; j++){ //populate specific temparrays
                    if(((i >=0) && i<=3) && (j ==1)){
                        tempArray.add(1);
                    }
                    else if((i ==4) && ((j >=1) && (j <=6))){
                        tempArray.add(1);
                    }
                    else if(((i >=5) && i<=9) && (j ==6)){
                       tempArray.add(1); 
                    }
                    
                    else{
                        tempArray.add(0);
                    }
                    
                }
                listOfArrayLists.add(tempArray); //add temparray to the arraylist of arraylists
            }
        }
        
        int loopCounter =0; //this signifies the amount of arraylists
        for (ArrayList a : listOfArrayLists) { //for each Arraylist in the list of arrays
            
             for (int i = 0; i < 10; i++) { //go through each element of the array list
               //System.out.print(a.get(i)); //print the array
                 if((int) a.get(i) == 0){ //if a 0 has been assigned . 
                    Dirt d = new Dirt(); //create dirt at the designated spot on my 'grid'
                    addObject(d,(i*40)+10 ,(loopCounter*40) +20); //*60 to put it in the right spot 'cause 400/10 = 40. 20 'cause greenfoot uses imgmode center. same concept with the *40 and +20     
                }
                
                else{ //if a one  has been assigned 
                    rd = new Road(); //create a road at the designated spot on my 'grid' (a 10 by 10 grid so 600 and 400 each divided by 10)      
                    addObject(rd,(i*40)+10 ,(loopCounter*40)+20); //*40 to put it in the right spot 'cause 400/10 = 40. 20 'cause greenfoot uses imgmode center. same concept with the *40 and +20     
                   
                }
                
            }
            //System.out.println(" "); //print a new line
            loopCounter +=1; //add one to this so the grid knows to move on to the next arraylist
        }
    
       
    }
    
    /**This is a method that is used to spawn enemies into the game at 
     * a health and speed variable which is a multiple of the current waves.
     * The spawning occurs at regular intervals and on the 10th spawn of 
     * every round this method handles the spawning of a wizard. 
     */
    
    public void spawning(){
        
        if((timer % 50 == 0) &&(enemyCounter%10 ==0)){ //if the counter is exactly 10, spawn a wizard
            Wizard w = new Wizard(1,level*10); //spawn waves 1 enemy
            
            if(level % 2 ==0){
                addObject(w,175,10); //spawn the enemy at the top of the path
            }
            else{
                addObject(w,50,10); //40 location +20/2 for centering
            }
            enemyCounter +=1;
            
            
        }
        
        if ((timer % 50 == 0) && (enemyCounter <waves*10) &&(enemyCounter >(waves-1)*10)) { //if time is an exact multiple of 50. if the enemy counter is less than the waves*10 and greater than the (waves-1)*10. thus it will spawn 9 per waves on 50 timer intervals    
            
            LevelOne e1 = new LevelOne(level, waves*10); //spawn enemy with speed = level and health = level*10
             if(level % 2 ==0){
                addObject(e1,175,10); //spawn the enemy at the top of the path
            }
            else{
                addObject(e1,50,10); //40 location +20/2 for centering
            }
            enemyCounter +=1;
            
        }
       
    }
    
    /**This is a method that deals with tower placement. 
     * This adds a tower when the stamp is clicked and adds it to an 
     * arraylist of towers that is called in the firing method to
     * make each tower fire it's own specific bullet. 
     * */
     
    public void towerDragger(){
        MouseInfo i;
        i = Greenfoot.getMouseInfo(); //this gets the mouse info 
        try{
            if(i != null){ //if the mouse doesn't go of the screen
                if(Greenfoot.mouseClicked(stamp) && (coins >=50)){
                    twr= new NormTower(); //make the memory location twr a new tower
                    coins -=50;
                    boo6 = true;
                }
                
                if(Greenfoot.mouseClicked(stamp2) && (coins >=100)){
                    twr= new FreezeTower(); //make the memory location twr a new tower
                    coins -=100;
                    boo6 = true;
                }
                if(boo6 == true){ //if the stamp is clicked
                    range = new RangeImg();
                    towers.add(twr);
                    addObject(range,500,250);
                    addObject(twr,500,250);//add tower to the stamps location
                    boo6 = false;
                }
                if((Greenfoot.mouseDragged(twr)) && (twr != null)){ //if twr is dragged away from the stamp 
                    range.setLocation(i.getX(), i.getY()); //put the range with it
                    twr.setLocation(i.getX(), i.getY()); //asign the location of twr to the current mouse location
                   
                }
                if(Greenfoot.mouseDragEnded(twr)){
                    Sounds s = new Sounds();
                    s.towerSound();
                        if((twr.canSpawn() != true)){ //if the tower can spawn ihe location it's dragged
                           Tower hey = twr;
                           towers.remove(twr); 
                           removeObject(hey);
                           removeObject(range);
                           if(twr instanceof NormTower){
                               coins +=50;
                            }
                           else{
                               coins += 100; //if the tower couldnt spawn reset the coins value
                           }
                        }
                         else{
                             if(lives>0){//if it's not after the game over
                                boo2 = true; //allow the ennemies to start spawning 
                             }
                           twr.razeTimerBoo = true;//this lets the razing function begin in tower
                         }
                    }
                    
            }
        }
        catch(Exception NullPointerException){
            String s = "Congrats you found an error, courtesy of Sonia.";
        }
    }
        //System.out.println(boo2);
    
    
    /**This is a method that handles the firing of the bulllets. 
     * It starts with checking if it's to be a freeze bullet or not, 
     * then fires the bullets on regular intervals from each tower in the 
     * tower ArrayList that is populated in the towerDragger() method.
     **/
    public void firing(){
        MouseInfo i;
        
        i = Greenfoot.getMouseInfo(); //this gets the mouse info 
        if(i != null){ //if the mouse doesn't go of the screen
            
            if(Greenfoot.isKeyDown("space")){ //if the space bar is pressed 
               if( freezeShots >0){ //order is important when changing boolean states 
                   ice = true; //change ice's state 
                }
               else{
                   ice = false;
                }
                   
            }
            
            shot = true; //allow the functionality in NormalBullet and IceBullet to go off
            if( timer % 50 ==0){   //this is the cooldown, 50 on the timer

                if(ice == true){ //if all the towers are supposed to shoot ice
                    for (int p=0; p<=towers.size()-1; p++){ //go through each tower
                        IceBullet b1 = new IceBullet(1); //create a bullet
                        addObject(b1,towers.get(p).getX(),towers.get(p).getY());//add the object to the current tower's position
                        Recoil rc = new Recoil(); //instantiate an instance of recoil
                        addObject(rc,towers.get(p).getX(),towers.get(p).getY()-10); //add the recoil to the tower's position as an animation
                        Sounds s = new Sounds(); //call the sounds class
                        s.freeze(); //play the freeze sound
                        rc.turnTowards(rc.enemyX(),rc.enemyY()); //turn the recoil towards the enemy
                        b1.turnTowards(b1.enemyX(),b1.enemyY()); //turn the bullet towards the current position of the closest enenmy from the method in bullet 
                    }
                    freezeShots -=1;
                }
                else{
                    
                    
                    for (int p=0; p<=towers.size()-1; p++){ //go through each tower
                        Bullet b1;
                        if(towers.get(p) instanceof FreezeTower){ //if the current tower is a freeze tower
                            b1 = new IceBullet(1); //b1 is actually an icebullet
                            Sounds s = new Sounds(); //call the sounds class
                            s.freeze(); //play the freeze sound
                        }
                        else{
                            b1 = new NormalBullet(towers.get(p).getDamage()); //create a bullet and give it the appropriate tower's damage
                            Sounds s = new Sounds(); //call the sounds class
                            s.gun(); //call the gun sound
                        }
                        addObject(b1,towers.get(p).getX(),towers.get(p).getY());//add the object to the current tower
                        Recoil rc = new Recoil(); //instantiate an instance of recoil
                        addObject(rc,towers.get(p).getX(),towers.get(p).getY());  //add the recoil to the tower's position as an animation
                        rc.turnTowards(rc.enemyX(),rc.enemyY()); //turn the recoil towards the enemy
                        b1.turnTowards(b1.enemyX(),b1.enemyY()); //turn the bullet towards the current position of the closest enenmy from the method in bullet 
                        
                    }
                    
                    ///  b1.turnTowards((int)i.getX(),(int)i.getY()); that is how it aims at the mouse
                }
           }
        
        }
    }
    
    /**
     * This is a method called in act to run continously throughout the 
     * program. It is used to display different textual values to the screen
     * in various locations.
     */
    public void textualStuff(){
        if(lives >0){
            showText("Lives: " + lives,500,40);
        }
        else{
            showText("Lives: 0",500,40);
        }
        
        showText("Wave: " + waves,cas.getX(),cas.getY() +15);
        showText("Coins: " + coins,500,10);
        showText("Level: " + level, 500,70);
        showText("Cost ", 450,150);
        showText("50 ", 450,200);
        showText("100 ", 450,275);
        
    }
    
    /**
     * This is a method to handle the fuctions of the buttons in the game screen.
     * It's essentially just handling the back button, stopping the music and 
     * changing the world back to the menu. 
     */
    
    public void buttonsFunctions(){
        if((Greenfoot.mouseClicked(l))|| (Greenfoot.mouseClicked(d))){//if the back button is clicked
            MyWorld.music = false; //allow the menu music to play again
            initialize(); //call the reset method
            for(int i =0; i <=ss.size()-1;i++){
                Sounds m = ss.get(i); //get the first index of the sounds arraylist (the only instance of sounds in the program) and tell it to stop the music it's playing
                m.stopEpicBattleMusic(); //greenfoot's finicky so the music needs to be changed before the world
                m.stopCelticMusicWolfBlood();
                m.stopCelticMusicLegend();
                m.stopNorrisSong();
            }
            egg = false; //reset the easter egg
            menu = new MenuScreen(); //make a new world, and therefore a new song
            Greenfoot.setWorld(menu); //greenfoot's finicky so the music needs to be changed before the world
        }
        if(Greenfoot.mouseClicked(s)){
            level+=1;
            //NormalBullet.damage = 5;
            levelUp = new MyWorld();
            for(int i =0; i <=ss.size()-1;i++){
                Sounds m = ss.get(i); //get the first index of the sounds arraylist (the only instance of sounds in the program) and tell it to stop the music it's playing
                m.stopEpicBattleMusic(); //greenfoot's finicky so the music needs to be changed before the world
                m.stopNorrisSong();
            }
            
            Sounds z = new Sounds();
            ss.add(z);
            if((level ==2)|| (level ==5)){
                z.playCelticMusicWolfBlood();
            }
            else if((level ==3) || (level ==6)){
                z.playCelticMusicLegend();
            }
            else{
                z.EpicBattleMusic();
            }
            //z.
            
            Greenfoot.setWorld(levelUp);
        }
            
    }
    /**This is a method that creates a popup window once the user has completed the level. 
     * It basically creates the window that allows for world transfer
     */
    
    public void moveOn(){
        if(boo7 == false){ //this is to generate the objects only once
            //t = new button 
            addObject(a,150,10);
            r = new Button(125,25);
            addObject(r,300,10);
            addObject(s,300,10);
            y = new Button(125,25);
            addObject(y,300,40);
            addObject(d,300,40);
            coins = 100;
            boo7 = true;
        }
        
    }
    
    /**This is a method that does the easter egg stuff
     * aka the different song
     */
    
    public void easerEgg(){ //different ennemies and song are handled else where
        if(timer == 50){
            Sounds z = new Sounds();
            ss.add(z);
            z.playNorrisSound();
            
        }
    }
    
     public void act(){
         
        textualStuff();
        buttonsFunctions();
        
        if(egg == true){
            easerEgg();
        }
         
        if(waves <=5){ //if it's not after the fifth wave
            towerDragger();
            if (boo2 == true){ //this is a kill switch boolean. so freaking useful
                spawning();
                timer++;
                firing();
                if(timer % 1000 ==0){ //if boo2 is still active when timer > 1000 it means they've gone to the next waves. send in next waves
                    waves +=1;
                    
                }
                /*if(timer > 2000){ //if boo2 is still active when timer > 1000 it means they've gone to the next waves. send in waves 2
                    waves =3;
                    showText("Coming Soon!", 200,200);
                    boo2 = false; //this ends the game
                }*/
            }
        }
        if(waves >=6){
           moveOn();
        }
        //System.out.println(egg);
        
        }
       
    }
    



