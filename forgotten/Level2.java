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
        
        int platLen10 = 3;
        int platPos10 = 33;
        generatePlatform(platPos10, platLen10, 14);
        
        int platLen9 = 4;
        int platPos9 = 38;
        generatePlatform(platPos9, platLen9, 14);
        
        int platLen8 = 5;
        int platPos8 = 45;
        generatePlatform(platPos8, platLen8, 12);
        
        int platLen7 = 12;
        int platPos7 = 29;
        generateFloatPlatform(platPos7, platLen7, 7);
        
        int platLen6 = 3;
        int platPos6 = 23;
        generateFloatPlatform(platPos6, platLen6, 9);
        
        int platLen5 = 5;
        int platPos5 = 25;
        generateFloatPlatform(platPos5, platLen5, 12);
        
        int platLen3 = 8;
        int platPos3 = 15;
        generatePlatform(platPos3, platLen3, 14);
        
        int platLen2 = 3;
        int platPos2 = 8;
        generatePlatform(platPos2, platLen2, 12);
        
        int platLen1 = 6;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,14); 
        
        Portal portal = new Portal();
        addObject(portal, (32*19), (32*12));
               
        LevelGem levelGem = new LevelGem();
        addObject(levelGem, (32*48) - 16,(32*10));

         MissingGem missingGem = new MissingGem();
        missingGem.getImage().scale(missingGem.getImage().getWidth() * 2, missingGem.getImage().getHeight() * 2);
        addObject(missingGem, (32*22),(32*2));
        
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
