import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2 extends World
{
    //SimpleTimer time = new SimpleTimer();
    public Level2()
    {    
        super(768, 512, 1, false); 
        showText("Level : " + MyWorld.LEVEL, 32*2, 32*1);
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
        
        int platLen15 = 5;
        int platPos15 = 44;
        generateFloatPlatform(platPos15, platLen15, 4);
        
        int platLen14 = 10;
        int platPos14 = 57;
        generatePlatform(platPos14, platLen14, 9);
        
        int platLen13 = 10;
        int platPos13 = 58;
        generatePlatform(platPos13, platLen13, 7);
        
        int platLen12 = 4;
        int platPos12 = 54;
        generatePlatform(platPos12, platLen12, 10);
        
        int platLen11 = 3;
        int platPos11 = 51;
        generatePlatform(platPos11, platLen11, 11);
        
        int platLen10 = 3;
        int platPos10 = 45;
        generatePlatform(platPos10, platLen10, 13);
        
        int platLen9 = 5;
        int platPos9 = 26;
        generatePlatform(platPos9, platLen9, 13);
        
        int platLen7 = 3;
        int platPos7 = 36;
        generatePlatform(platPos7, platLen7, 6);
        
        int platLen8 = 9;
        int platPos8 = 33;
        generatePlatform(platPos8, platLen8, 14);
        
        Dirt dirt21 = new Dirt();
        addObject(dirt21, (32*40)-16,(32*6)+16);
        
        Dirt dirt11 = new Dirt();
        addObject(dirt11, (32*36)-16,(32*6)+16);
        
        Dirt dirt12 = new Dirt();
        addObject(dirt12, (32*35)-16,(32*6)+16);
        
        Dirt dirt13 = new Dirt();
        addObject(dirt13, (32*36)-16,(32*7)+16);
        
        Dirt dirt01 = new Dirt();
        addObject(dirt01, (32*14)-16,(32*6)+16);
        
        Dirt dirt02 = new Dirt();
        addObject(dirt02, (32*15)-16,(32*6)+16);
        
        Dirt dirt03 = new Dirt();
        addObject(dirt03, (32*14)-16,(32*7)+16);
        
        int platLen6 = 29;
        int platPos6 = 12;
        generateFloatPlatform(platPos6, platLen6, 5);
        
        int platLen55 = 1;
        int platPos55 = 23;
        generatePlatform(platPos55, platLen55, 15);
        
        int platLen5 = 8;
        int platPos5 = 15;
        generatePlatform(platPos5, platLen5, 14);
        
        int platLen4 = 1;
        int platPos4 = 14;
        generatePlatform(platPos4, platLen4, 13);
        
        int platLen3 = 1;
        int platPos3 = 13;
        generatePlatform(platPos3, platLen3, 12);
        
        int platLen2 = 7;
        int platPos2 = 6;
        generatePlatform(platPos2, platLen2, 6);
        
        int platLen1 = 6;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,5); 
        
        Portal portal = new Portal();
        addObject(portal, (32*19), (32*12));
               
        LevelGem levelGem1 = new LevelGem();
        addObject(levelGem1, (32*38) - 16,(32*12));
        
        LevelGem levelGem2 = new LevelGem();
        addObject(levelGem2, (32*56) - 16,(32*8));

        MissingGem missingGem1 = new MissingGem();
        missingGem1.getImage().scale(missingGem1.getImage().getWidth() * 2, missingGem1.getImage().getHeight() * 2);
        addObject(missingGem1, (32*20),(32*1)+4);
        
        MissingGem missingGem2 = new MissingGem();
        missingGem2.getImage().scale(missingGem2.getImage().getWidth() * 2, missingGem2.getImage().getHeight() * 2);
        addObject(missingGem2, (32*22),(32*1)+4);
        
        Player player = new Player();
        addObject(player, 0, (32*3));
        
        //addObject(new Counter(), (32*2), (32*2));
        //time.mark();
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
