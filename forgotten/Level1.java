import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level1 extends World
{
    //SimpleTimer time = new SimpleTimer();
    public Level1()
    {    
        super(768, 512, 1, false); 
        showText("Level : " + MyWorld.LEVEL, 32*2, 32*1);
        generateSky();
        prepare();
    }
        
    public void prepare() { 
        if( MyWorld.LEVEL != 1) {
            MyWorld.LEVEL = 1;
            Player.gemCounter = 0;
        }
        
        int waterLen1 = 24*2;
        int waterPos1 = 0;
        generateWater(waterPos1, waterLen1,14);
        
        TreeTopBack treeTopBack1 = new TreeTopBack();
        addObject(treeTopBack1,(32*0)+16,(32*5));
        
        TreeTopBack treeTopBack2 = new TreeTopBack();
        addObject(treeTopBack2,(32*3),(32*5));
            
        TreeTopBack treeTopFront4 = new TreeTopBack();
        addObject(treeTopFront4,(32*25),(32*4));
        
        TreeTopBack treeTopFront5 = new TreeTopBack();
        addObject(treeTopFront5,(32*29),(32*4));
        
        Tree1 tree1 = new Tree1();
        addObject(tree1,(32*0)+16,(32*8));
        
        Tree1 tree2= new Tree1();
        addObject(tree2,(32*2),(32*8));
        
        tree2.getImage().mirrorHorizontally();
        Tree2 tree3 = new Tree2();
        addObject(tree3,(32*3),(32*8));
        
        Tree1 tree5 = new Tree1();
        addObject(tree5,(32*25),(32*8));
        
        Tree2 tree6 = new Tree2();
        addObject(tree6,(32*29),(32*8));
        
        TreeTopFront treeTopFront1 = new TreeTopFront();
        addObject(treeTopFront1,(32*0)+16,(32*4));
        
        TreeTopFront treeTopFront2 = new TreeTopFront();
        addObject(treeTopFront2,(32*3),(32*5));
        
        TreeTopFront treeTopFront3 = new TreeTopFront();
        addObject(treeTopFront3,(32*24),(32*5)); 

        TreeTopFront treeTopFront6 = new TreeTopFront();
        addObject(treeTopFront6,(32*29),(32*4)); 
        
        Dirt dirt = new Dirt();
        addObject(dirt, (32*55)+16,(32*6)-16);
        
        
        int platLen10 = 10;
        int platPos10 = 56;
        generatePlatform(platPos10, platLen10, 5);
        
        int platLen11 = 10;
        int platPos11 = 55;
        generatePlatform(platPos11, platLen11, 12);
        
        int platLen9 = 12;
        int platPos9 = 52;
        generatePlatform(platPos9, platLen9, 14);

        int platLen8 = 5;
        int platPos8 = 51;
        generateFloatPlatform(platPos8, platLen8, 4);

        int platLen7 = 3;
        int platPos7 = 45;
        generateFloatPlatform(platPos7, platLen7, 5);

        int platLen6 = 3;
        int platPos6 = 40;
        generateFloatPlatform(platPos6, platLen6, 7);

        int platLen5 = 5;
        int platPos5 = 45;
        generatePlatform(platPos5, platLen5, 11);
        
        //______________________________________________
        
        int platLen3 = 21;
        int platPos3 = 22;
        generatePlatform(platPos3, platLen3, 13);

        int platLen2 = 4;
        int platPos2 = 16;
        generatePlatform(platPos2, platLen2,14); 
        
        int platLen0 = 8;
        int platPos0 = 0;
        generatePlatform(platPos0, platLen0,13); 

        int platLen1 = 14;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,14);
        
        Spirit spirit0 = new Spirit();
        addObject(spirit0, (32*9)+16, (32*12));
        
        Spirit spirit1 = new Spirit();
        addObject(spirit1, (32*12)+16, (32*12));
        
        Spirit spirit2 = new Spirit();
        addObject(spirit2, (32*23), (32*11)-8);
        
        Spirit spirit3 = new Spirit();
        addObject(spirit3, (32*21)+8, (32*10));
        
        Spirit spirit4 = new Spirit();
        addObject(spirit4, (32*19)+16, (32*12)-16);
        
        Portal portal = new Portal();
        addObject(portal, (32*54)-16, (32*12));

        LevelGem levelGem = new LevelGem();
        addObject(levelGem, (32*53),(32*3)-16);

        MissingGem missingGem = new MissingGem();
        missingGem.getImage().scale(missingGem.getImage().getWidth() * 2, missingGem.getImage().getHeight() * 2);
        addObject(missingGem, (32*22),(32*1)+4);
        
        Player player = new Player();
        addObject(player, 1, (32*11));
        
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
