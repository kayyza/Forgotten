import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends MyWorld
{

    /**
     * Constructor for objects of class level0.
     * 
     */
    public Level1()
    {
        prepare();
    }
    public void prepare() {
        int platLen1 = 4;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,13); 
    
        int platLen2 = 3;
        int platPos2 = 6;
        generatePlatform(platPos2, platLen2,15); 
            
        int platLen3 = 2;
        int platPos3 = 10;
        generateFloatPlatform(platPos3, platLen3, 13);
        
        int platLen4 = 2;
        int platPos4 = 14;
        generateFloatPlatform(platPos4, platLen4, 11);
            
        int platLen5 = 4;
        int platPos5 = 7;
        generateFloatPlatform(platPos5, platLen5, 9);
            
        int platLen6 = 3;
        int platPos6 = 1;
        generateFloatPlatform(platPos6, platLen6, 6);
            
        int platLen7 = 6;
        int platPos7 = 19;
        generatePlatform(platPos7, platLen7,14);
            
        LevelGem levelGem = new LevelGem();
        addObject(levelGem, (32*2 + 16),(32*5));
            
        Portal portal = new Portal();
        addObject(portal, (32*22), (32*12));
        
            
        Player player = new Player();
        addObject(player, 0, MyWorld.HEIGHT - 142);
    }
    
}
