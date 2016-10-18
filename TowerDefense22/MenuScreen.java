import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**This is a subclass of world that is a menu screen.
 * This class has multiple buttons and changes the 
 * world depedant on the button clicked.
 * Nicholas Paul
 * @version 22
 */
public class MenuScreen extends World
{
    Button instr, credits; 
    Button play;
    
    Label l,e,t,p,startLevel,one,two,three,four,five;
    MyWorld world;
    Instructions ins;
    Credits cr;
    
    /**This is a general constructor for the MenuScreen class.
     * It creates the butotns and starts the songs
     * 
     */
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
       if(MyWorld.music == false){ //only run the first time or when it's told
            Sounds s = new Sounds(); 
            MyWorld.ss.add(s);
            s.CelticElfMusic(); //commented out for sanity's sake
            MyWorld.music =true;
        }   
        
        startLevel = new Label("Start at level:",40);
        one = new Label("1",40);
        two = new Label("2",40); //fix the locations and the locations they're added to 
        three = new Label("3",40);
        four = new Label("4",40);
        five = new Label("5",40);
        
        
        play = new Button(100,50); //button accepts a length and a width
        addObject(play,getWidth()/2,getHeight()/2);
        
        l = new Label("Play",50);
        addObject(l,play.getX(),play.getY());
        
        
        instr = new Button(250,50);
        addObject(instr,(getWidth()/2)/2,300);
        
        e = new Label("Instructions",50);
        addObject(e,(getWidth()/2)/2,300);
        
        credits = new Button(250,50);
        addObject(credits,(getWidth()*3/4),300);
        
        t = new Label("Credits",50);
        addObject(t,(getWidth()*3/4),300);
        
        //instr = new button();
        //addObject(instr,(getWidth()/2)/2,300);
        
        p = new Label("A Knight's Call",100);
        addObject(p,getWidth()/2,100);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(l)){
            addObject(startLevel,play.getX()-100,play.getY()+50);
            addObject(one,play.getX()+30,play.getY()+50);
            addObject(two,play.getX()+60,play.getY()+50);
            addObject(three,play.getX()+90,play.getY()+50);
            addObject(four,play.getX()+120,play.getY()+50);
            addObject(five,play.getX()+150,play.getY()+50);
        }
        if((Greenfoot.mouseClicked(one))||(Greenfoot.mouseClicked(two))||(Greenfoot.mouseClicked(three))||(Greenfoot.mouseClicked(four))||(Greenfoot.mouseClicked(five))){ //this handles starting at different levels 
            for(int i =0; i <=MyWorld.ss.size()-1;i++){
                Sounds m = MyWorld.ss.get(i);
                m.stopCelticElfMusic(); //greenfoot's finicky so the music needs to be changed before the world
            }
            Sounds m = new Sounds();
            MyWorld.ss.add(m);
            
            if(Greenfoot.mouseClicked(one)){ //assign a different level dependant on the specific label clicked
                MyWorld.level =1;
                if(MyWorld.egg == false){ //if it's not easter egg time
                    m.EpicBattleMusic();
                }
                else{
                    m.playNorrisSong();
                }
            }
            else if (Greenfoot.mouseClicked(two)){
                MyWorld.level =2;
                if(MyWorld.egg == false){ //if it's not easter egg time
                    m.playCelticMusicWolfBlood();
                }
                else{
                    m.playNorrisSong();
                }
            }
            else if (Greenfoot.mouseClicked(three)){
                MyWorld.level =3;
                if(MyWorld.egg == false){ //if it's not easter egg time
                    m.playCelticMusicLegend();
                }
                else{
                    m.playNorrisSong();
                }
            }
            else if (Greenfoot.mouseClicked(four)){
                MyWorld.level =4;
                if(MyWorld.egg == false){ //if it's not easter egg time
                    m.EpicBattleMusic();
                }
                else{
                    m.playNorrisSong();
                }
            }
            else if (Greenfoot.mouseClicked(five)){
                MyWorld.level =5;
                if(MyWorld.egg == false){ //if it's not easter egg time
                    m.playCelticMusicWolfBlood();
                }
                else{
                    m.playNorrisSong();
                }
            }
             
            world = new MyWorld();  //make a new world with the new level
            Greenfoot.setWorld(world);
        }
        if(Greenfoot.mouseClicked(e)){
            ins= new Instructions();
            Greenfoot.setWorld(ins);
        }
         if(Greenfoot.mouseClicked(t)){
            cr= new Credits();
            Greenfoot.setWorld(cr);
        }
        
    }
}
