import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Sounds is a class to handle the suite of sounds used in The Knight's Call.
 * 
 * Nicholas Paul
 * @version 22
 */
public class Sounds extends Actor
{
    GreenfootSound towerSound, freeze,gun,EpicBattleMusic,celticMusicLegend;
    GreenfootSound celticMusicWolfBlood;
    GreenfootSound CelticElfMusic, norrisSong, norrisSound ;
    /**This is a general constructor for the Sounds class.
     * Specifically it assigns all the sound files to memory locations. 
     * 
     */
    public Sounds(){
        towerSound = new GreenfootSound("towerSound.mp3");
        norrisSong = new GreenfootSound("NorrisSong.mp3");
        norrisSound = new GreenfootSound("norrisSound.mp3");
        celticMusicLegend = new GreenfootSound("CelticMusicLegend.mp3");
        celticMusicWolfBlood = new GreenfootSound("CelticMusicWolfBlood.mp3");
        freeze = new GreenfootSound("freeze.mp3");
        gun = new GreenfootSound("gun.mp3");
        CelticElfMusic= new GreenfootSound("CelticElfMusic.mp3");
        EpicBattleMusic = new GreenfootSound("EpicBattleMusic.mp3");
    }
    /**This is a method that plays a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void playNorrisSound(){
        norrisSound.setVolume(100);
        norrisSound.play();
    }
    /**This is a method that stops a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void stopNorrisSound(){
        norrisSound.stop();
    }
    /**This is a method that plays a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void playNorrisSong(){
        norrisSong.play();
    }
    /**This is a method that stops a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void stopNorrisSong(){
        norrisSong.stop();
    }
    /**This is a method that plays a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void playCelticMusicLegend(){
        celticMusicLegend.play();
    }
    /**This is a method that stops a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void stopCelticMusicLegend(){
        celticMusicLegend.stop();
    }
    /**This is a method that plays a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void playCelticMusicWolfBlood(){
        celticMusicWolfBlood.play();
    }
    /**This is a method that stops a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void stopCelticMusicWolfBlood(){
        celticMusicWolfBlood.stop();
    }
    /**This is a method that plays a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void towerSound(){
        towerSound.play();
    }
    /**This is a method that stops a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void stopTowerSound(){
        towerSound.stop();
    }
    /**This is a method that plays a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void freeze(){
        freeze.play();
    }
    /**This is a method that stops a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void stopFreeze(){
        freeze.stop();
    }
    /**This is a method that plays a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void gun(){
        gun.play();
    }
    /**This is a method that stops a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void stopGun(){
        gun.stop();
    }
    /**This is a method that plays a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void CelticElfMusic(){
        CelticElfMusic.setVolume(40);
        CelticElfMusic.play();
    }
    /**This is a method that stops a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void stopCelticElfMusic(){
        CelticElfMusic.stop();
    }
    /**This is a method that plays a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void EpicBattleMusic(){
        EpicBattleMusic.play();
    }
    /**This is a method that stops a specific song. 
     * It can be called whenever an instance of Sounds is initialized 
     * around the program.
     */
    public void stopEpicBattleMusic(){
        EpicBattleMusic.stop();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
