import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level3 extends World
{
    public Level3()
    {    
        super(768, 512, 1, false); 
        showText("LEVEL 3", 32*2, 32*2);
        generateSky();
        prepare();
    }
        
    public void prepare() {  
        if( MyWorld.LEVEL != 3) {
            MyWorld.LEVEL = 3;
        }
        
        int waterLen1 = 24*2;
        int waterPos1 = 0;
        generateWater(waterPos1, waterLen1,14);
        
        int platLen23 = 3;
        int platPos23 = 82;
        generateFloatPlatform(platPos23, platLen23,3);
        
        int platLen22 = 3;
        int platPos22 = 87;
        generateFloatPlatform(platPos22, platLen22,3);
        
        int platLen21 = 3;
        int platPos21 = 91;
        generateFloatPlatform(platPos21, platLen21,6);
        
        int platLen20 = 3;
        int platPos20 = 87;
        generateFloatPlatform(platPos20, platLen20,9);
        
        int platLen19 = 3;
        int platPos19 = 91;
        generateFloatPlatform(platPos19, platLen19,12);
        
        int platLen18 = 3;
        int platPos18 = 87;
        generateFloatPlatform(platPos18, platLen18,14);
        
        int platLen17 = 3;
        int platPos17 = 83;
        generateFloatPlatform(platPos17, platLen17,14);
        
        int platLen16 = 3;
        int platPos16 = 77;
        generateFloatPlatform(platPos16, platLen16,14);
        
        int platLen15 = 4;
        int platPos15 = 70;
        generateFloatPlatform(platPos15, platLen15,11);
        
        int platLen14 = 4;
        int platPos14 = 64;
        generateFloatPlatform(platPos14, platLen14,11);
        
        int platLen13 = 4;
        int platPos13 = 57;
        generateFloatPlatform(platPos13, platLen13,11);
        
        int platLen12 = 2;
        int platPos12 = 38;
        generatePlatform(platPos12, platLen12,14);
        
        int platLen11 = 3;
        int platPos11 = 51;
        generatePlatform(platPos11, platLen11,12);
        
        int platLen10 = 3;
        int platPos10 = 46;
        generatePlatform(platPos10, platLen10,13);
        
        int platLen9 = 4;
        int platPos9 = 40;
        generatePlatform(platPos9, platLen9,14);
        
        int platLen8 = 10;
        int platPos8 = 28;
        generateFloatPlatform(platPos8, platLen8,5);
        
        int platLen7 = 3;
        int platPos7 = 24;
        generateFloatPlatform(platPos7, platLen7,7);
        
        int platLen6 = 3;
        int platPos6 = 28;
        generateFloatPlatform(platPos6, platLen6,9);
        
        int platLen5 = 3;
        int platPos5 = 24;
        generateFloatPlatform(platPos5, platLen5,11);
        
        int platLen4 = 3;
        int platPos4 = 20;
        generatePlatform(platPos4, platLen4,14);
        
        int platLen3 = 3;
        int platPos3 = 15;
        generatePlatform(platPos3, platLen3,13);
        
        int platLen2 = 3;
        int platPos2 = 9;
        generatePlatform(platPos2, platLen2,14);
        
        int platLen1 = 6;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,14);    
        
        Portal portal = new Portal();
        addObject(portal, (32*84)-16, (32*2));
               
        LevelGem levelGem = new LevelGem();
        addObject(levelGem, (32*40) - 16,(32*13));
        
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
