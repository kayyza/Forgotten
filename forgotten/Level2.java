import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2 extends World
{
    public Level2()
    {    
        super(768, 512, 1, false); 
        showText("LEVEL 2", 32*2, 32*2);
        generateSky();
        prepare();
    }
        
    public void prepare() {  
        if( MyWorld.LEVEL != 2) {
            MyWorld.LEVEL = 2;
        }
        
        int waterLen1 = 24*2;
        int waterPos1 = 0;
        generateWater(waterPos1, waterLen1,14);
        
        int platLen4 = 4;
        int platPos4 = 13;
        generatePlatform(platPos4, platLen4, 14);
        
        int platLen3 = 3;
        int platPos3 = 8;
        generatePlatform(platPos3, platLen3, 15);
        
        int platLen2 = 10;
        int platPos2 = 17;
        generatePlatform(platPos2, platLen2,13); 
        
        int platLen1 = 6;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,14); 
        
        Portal portal = new Portal();
        addObject(portal, (32*20)-16, (32*11));
               
        LevelGem levelGem = new LevelGem();
        addObject(levelGem, (32*10) - 16,(32*11));
            
        Player player = new Player();
        addObject(player, 0, MyWorld.HEIGHT - 142 + 32);
    }   
    
    public void generateSky() {
        int rand = Greenfoot.getRandomNumber(333);

        for (int i = 0; i < 12000; i+=60) {
            addObject(new Sky5(), +i, 450);
            addObject(new Sky4(), +i, 0);
            if (rand % 3 == 0) { 
                addObject(new Sky3(), +i, 200);
            } else if (rand % 2 == 0) {
                addObject(new Sky2(), +i, 200);
            } else {
                addObject(new Sky1(), +i, 200);
            }
            rand = Greenfoot.getRandomNumber(333);
        }
    }
    
     public void generateWater(int x, int length, int y) {
        int blockSize = 32;
        int startPos = 16 + (blockSize*x);
        y = 16 + (blockSize * y);
        for (int i = startPos; i < startPos + length*blockSize; i+=blockSize) {
            addObject(new WaterSurface(), i, y);
            addObject(new WaterBody(), i, y + blockSize );
            if((y / blockSize) < 14) {
                int depth = 14 - (y / blockSize);

                for (int d=0; d < depth*2; d++){
                    addObject(new WaterBody(), i, y + blockSize + (blockSize*d) );
                }
            }
        
        }
    }
    
    public void generatePlatform(int x, int length, int y) {
        int blockSize = 32;
        int startPos = 16 + (blockSize*x);
        y = 16 + (blockSize * y);
        for (int i = startPos; i < startPos + length*blockSize; i+=blockSize) {
            addObject(new TallGrass(), i, y - 16);
            addObject(new Dirt(), i, y + blockSize );
            if((y / blockSize) < 14) {
                int depth = 14 - (y / blockSize);

                for (int d=0; d < depth*2; d++){
                    addObject(new Dirt(), i, y + blockSize + (blockSize*d) );
                }
            }
        
        }
    }
    
    public void generateFloatPlatform(int x, int length, int y) {
        int blockSize = 32;
        int startPos = 16 + (blockSize*x);
        y = 16 + (blockSize * y);
        for (int i = startPos; i < startPos + length*blockSize; i+=blockSize) {
            addObject(new Grass(), i, y);
        }
    }
}
