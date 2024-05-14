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
        if( MyWorld.LEVEL != 1) {
            MyWorld.LEVEL = 1;
        }
        
        int waterLen1 = 24*2;
        int waterPos1 = 0;
        generateWater(waterPos1, waterLen1,14);

        int platLen9 = 10;
        int platPos9 = 54;
        generatePlatform(platPos9, platLen9, 14);

        int platLen8 = 4;
        int platPos8 = 39   ;
        generateFloatPlatform(platPos8, platLen8, 4);

        int platLen7 = 4;
        int platPos7 = 44;
        generateFloatPlatform(platPos7, platLen7, 7);

        int platLen6 = 3;
        int platPos6 = 50;
        generateFloatPlatform(platPos6, platLen6, 9);

        int platLen5 = 3;
        int platPos5 = 46;
        generateFloatPlatform(platPos5, platLen5, 11);

        int platLen4 = 3;
        int platPos4 = 42;
        generatePlatform(platPos4, platLen4, 14);
        
        Tree1 tree1 = new Tree1();
        addObject(tree1,(32*0)+16,(32*9));
        
        Tree1 tree2= new Tree1();
        addObject(tree2,(32*2),(32*9));
        
        tree2.getImage().mirrorHorizontally();
        Tree2 tree3 = new Tree2();
        addObject(tree3,(32*3),(32*9));
        
        Tree2 tree4 = new Tree2();
        addObject(tree4,(32*22),(32*8));
        
        Tree1 tree5 = new Tree1();
        addObject(tree5,(32*25),(32*8));
        
        Tree2 tree6 = new Tree2();
        addObject(tree6,(32*29),(32*8));
        
        Tree2 tree7 = new Tree2();
        addObject(tree7,(32*33),(32*8));
        
        Tree1 tree8 = new Tree1();
        tree8.getImage().mirrorHorizontally();
        addObject(tree8,(32*32),(32*8));
        
        TreeTopBack treeTopBack1 = new TreeTopBack();
        addObject(treeTopBack1,(32*0)+16,(32*6));
        
        TreeTopBack treeTopBack2 = new TreeTopBack();
        addObject(treeTopBack2,(32*3),(32*6));
        
        TreeTopBack treeTopBack3 = new TreeTopBack();
        addObject(treeTopBack3,(32*22),(32*5));
        
        TreeTopBack treeTopBack4 = new TreeTopBack();
        addObject(treeTopBack4,(32*25),(32*4));
        
        TreeTopBack treeTopBack5 = new TreeTopBack();
        addObject(treeTopBack5,(32*29),(32*4));
        
        TreeTopFront treeTopFront1 = new TreeTopFront();
        addObject(treeTopFront1,(32*0)+16,(32*6));
        
        TreeTopBack treeTopFront4 = new TreeTopBack();
        addObject(treeTopFront4,(32*25),(32*4));
        
        TreeTopBack treeTopFront5 = new TreeTopBack();
        addObject(treeTopFront5,(32*29),(32*4));
        
        TreeTopFront treeTopFront2 = new TreeTopFront();
        addObject(treeTopFront2,(32*3),(32*6));
        
        TreeTopFront treeTopFront3 = new TreeTopFront();
        addObject(treeTopFront3,(32*22),(32*5)); 

        TreeTopFront treeTopFront6 = new TreeTopFront();
        addObject(treeTopFront6,(32*29),(32*4)); 
        
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
        addObject(levelGem, (32*41),(32*3));

        MissingGem missingGem = new MissingGem();
        missingGem.getImage().scale(missingGem.getImage().getWidth() * 2, missingGem.getImage().getHeight() * 2);
        addObject(missingGem, (32*22),(32*2));
        
        Player player = new Player();
        addObject(player, 1, MyWorld.HEIGHT - 142 + 16);
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
