import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level0 extends MyWorld {

    /**
     * Constructor for objects of class level0.
     * 
     */
    public Level0()
    {
        prepare();
    }
    public void prepare() {
        int platLen1 = 12;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,13); 
    
        int platLen2 = 2;
        int platPos2 = 12;
        generatePlatform(platPos2, platLen2,14); 
          
        int platLen3 = 3;
        int platPos3 = 14;
        generatePlatform(platPos3, platLen3,12); 
        
        int platLen4 = 8;
        int platPos4 = 17;
        generatePlatform(platPos4, platLen4,11); 
        
        LevelGem levelGem = new LevelGem();
        addObject(levelGem, (32*13 - 4),(32*10));
            
        Portal portal = new Portal();
        addObject(portal, (32*22), (32*9));
        
            
        Player player = new Player();
        addObject(player, 0, MyWorld.HEIGHT - 142);
    }
    
}
