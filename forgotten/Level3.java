import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level3 extends World
{
    //SimpleTimer time = new SimpleTimer();
    public Level3()
    {    
        super(768, 512, 1, false); 
        showText("Level : " + MyWorld.LEVEL, 32*2, 32*1);
        generateSky();
        prepare();
    }
        
    public void prepare() {  
        if( MyWorld.LEVEL != 3) {
            MyWorld.LEVEL = 3;
            Player.gemCounter = 0;
        }
        
        int waterLen1 = 24*2;
        int waterPos1 = 0;
        generateWater(waterPos1, waterLen1,14);
        
        Dirt dirt3 = new Dirt();
        addObject(dirt3, 32*92-16, 32*5+16);
        
        int platLen20 = 5;
        int platPos20 = 87;
        generateFloatPlatform(platPos20, platLen20,4);
        
        int platLen19 = 5;
        int platPos19 = 92;
        generatePlatform(platPos19, platLen19,5);
        
        int platLen28 = 1;
        int platPos28 = 91;
        generatePlatform(platPos28, platLen28,11);
        
        int platLen18 = 2;
        int platPos18 = 89;
        generatePlatform(platPos18, platLen18,13);
        
        int platLen27 = 2;
        int platPos27 = 86;
        generateFloatPlatform(platPos27, platLen27,8);
        
        int platLen17 = 3;
        int platPos17 = 80;
        generateFloatPlatform(platPos17, platLen17,6);
        
        int platLen16 = 5;
        int platPos16 = 81;
        generatePlatform(platPos16, platLen16,14);
        
        int platLen15 = 3;
        int platPos15 = 74;
        generateFloatPlatform(platPos15, platLen15,11);
        
        int platLen24 = 1;
        int platPos24 = 69;
        generatePlatform(platPos24, platLen24,11);
        
        int platLen14 = 3;
        int platPos14 = 66;
        generatePlatform(platPos14, platLen14,10);
        
        int platLen13 = 10;
        int platPos13 = 56;
        generateFloatPlatform(platPos13, platLen13,9);
        
        Dirt dirt = new Dirt();
        addObject(dirt, 32*57-16, 32*10+16);
        
        int platLen32 = 2;
        int platPos32 = 43;
        generateFloatPlatform(platPos32, platLen32,5);
        
        int platLen12 = 2;
        int platPos12 = 48  ;
        generateFloatPlatform(platPos12, platLen12,6);
        
        int platLen31 = 1;
        int platPos31 = 52;
        generatePlatform(platPos31, platLen31,11);
        
        int platLen11 = 3;
        int platPos11 = 53;
        generatePlatform(platPos11, platLen11,10);
        
        int platLen10 = 3;
        int platPos10 = 46;
        generatePlatform(platPos10, platLen10,12);
        
        int platLen9 = 4;
        int platPos9 = 39;
        generatePlatform(platPos9, platLen9,13);
        
        int platLen8 = 11;
        int platPos8 = 28;
        generateFloatPlatform(platPos8, platLen8,4);
        
        int platLen7 = 1;
        int platPos7 = 35;
        generatePlatform(platPos7, platLen7,14);
        
        int platLen6 = 1;
        int platPos6 = 34;
        generatePlatform(platPos6, platLen6,12);
        
        int platLen4 = 6;
        int platPos4 = 28;
        generatePlatform(platPos4, platLen4,11);
        
        int platLen3 = 4;
        int platPos3 = 21;
        generatePlatform(platPos3, platLen3,13);
        
        int platLen2 = 3;
        int platPos2 = 15;
        generatePlatform(platPos2, platLen2,14);
        
        int platLen1 = 12;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,14);    
        
        Portal portal = new Portal();
        addObject(portal, (32*90)-16, (32*3));
               
        LevelGem levelGem1 = new LevelGem();
        addObject(levelGem1, (32*29) - 16,(32*3));
        
        LevelGem levelGem2 = new LevelGem();
        addObject(levelGem2, (32*41),(32*5));
        
        LevelGem levelGem3 = new LevelGem();
        addObject(levelGem3, (32*72),(32*7));
        
        MissingGem missingGem1 = new MissingGem();
        missingGem1.getImage().scale(missingGem1.getImage().getWidth() * 2, missingGem1.getImage().getHeight() * 2);
        addObject(missingGem1, (32*18),(32*1)+4);
        
        MissingGem missingGem2 = new MissingGem();
        missingGem2.getImage().scale(missingGem2.getImage().getWidth() * 2, missingGem2.getImage().getHeight() * 2);
        addObject(missingGem2, (32*20),(32*1)+4);
        
        MissingGem missingGem3 = new MissingGem();
        missingGem3.getImage().scale(missingGem3.getImage().getWidth() * 2, missingGem3.getImage().getHeight() * 2);
        addObject(missingGem3, (32*22),(32*1)+4);
            
        Player player = new Player();
        addObject(player, 0, MyWorld.HEIGHT - 142 + 32);
        
        addObject(new Counter(), (32*2), (32*2));
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
