import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level1 extends World
{
    public Level1()
    {    
        super(768, 512, 1, false); 
        showText("LEVEL 1", 32*2, 32*2);
        generateSky();
         prepare();
    }
        
    public void prepare() {   
        int platLen9 = 10;
        int platPos9 = 54;
        generatePlatform(platPos9, platLen9, 14);
        
        int platLen8 = 4;
        int platPos8 = 39   ;
        generateFloatPlatform(platPos8, platLen8, 4);
        
        int platLen7 = 4;
        int platPos7 = 45;
        generateFloatPlatform(platPos7, platLen7, 7);
        
        int platLen6 = 3;
        int platPos6 = 50;
        generateFloatPlatform(platPos6, platLen6, 11);
        
        int platLen5 = 3;
        int platPos5 = 46;
        generateFloatPlatform(platPos5, platLen5, 13);
        
        int platLen4 = 2;
        int platPos4 = 42;
        generatePlatform(platPos4, platLen4, 15);
        
        int platLen3 = 21;
        int platPos3 = 18;
        generatePlatform(platPos3, platLen3, 13);
        
        int platLen2 = 4;
        int platPos2 = 12;
        generatePlatform(platPos2, platLen2,14); 
        
        int platLen1 = 10;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,14); 
        
        Portal portal = new Portal();
        addObject(portal, (32*56)-16, (32*12));
               
        LevelGem levelGem = new LevelGem();
        addObject(levelGem, (32*39),(32*3));
        
            
        Player player = new Player();
        addObject(player, 1, MyWorld.HEIGHT - 142 + 32);
    }   
    
    public void generateSky() {
        int rand = Greenfoot.getRandomNumber(333);

        for (int i = 0; i < 12000; i+=60) {
            if (rand % 3 == 0) { 
                addObject(new Sky3(), +i, 266);
            } else if (rand % 2 == 0) {
                addObject(new Sky2(), +i, 266);
            } else {
                addObject(new Sky1(), +i, 266);
            }
            
            rand = Greenfoot.getRandomNumber(333);
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
