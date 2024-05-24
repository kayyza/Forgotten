import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level0 extends World
{
    //SimpleTimer time = new SimpleTimer();
    
    public Level0()
    {    
        super(768, 512, 1, false); 

        showText("Level : " + MyWorld.LEVEL, 32*2, 32*1);
        generateSky();
        prepare();
    }
        
    public void prepare() {        
        if( MyWorld.LEVEL != 0) {
            MyWorld.LEVEL = 0;
        }
        
        TreeTopBack treeTopBack = new TreeTopBack();
        addObject(treeTopBack,(32*15), (32*5));
        
        TreeTopBack treeTopBack2 = new TreeTopBack();
        addObject(treeTopBack2,(32*24), (32*5));
        
        TreeTopBack treeTopBack3 = new TreeTopBack();
        addObject(treeTopBack3,(32*17), (32*5));
        
        TreeTopBack treeTopBack4 = new TreeTopBack();
        addObject(treeTopBack4,(32*11), (32*5));
        
        Tree1 tree1 = new Tree1();
        addObject(tree1,(32*10), (32*8));
        
        Tree1 tree12 = new Tree1();
        addObject(tree12,(32*15)-16, (32*8));
        tree12.getImage().mirrorHorizontally();
        
        Tree2 tree2 = new Tree2();
        addObject(tree2,(32*16), (32*8));
        
        Tree2 tree22 = new Tree2();
        addObject(tree22,(32*24), (32*8));
        
        TreeTopFront treeTopFront = new TreeTopFront();
        addObject(treeTopFront,(32*24), (32*5));
        
        TreeTopFront treeTopFront2 = new TreeTopFront();
        addObject(treeTopFront2,(32*16), (32*5));
        
        TreeTopFront treeTopFront3 = new TreeTopFront();
        addObject(treeTopFront3,(32*11), (32*5));
        
        int platLen1 = 30;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,13); 

        int platLen = 1;
        int platPos = -1;
        generatePlatform(platPos, platLen,0); 
        
        
        
        Spirit spirit1 = new Spirit();
        addObject(spirit1, (32*20), (32*11));
        
        Spirit spirit2 = new Spirit();
        addObject(spirit2, (32*24)+4, (32*11));
        
        Portal portal = new Portal();
        addObject(portal, (32*25), (32*13));

        Player player = new Player();
        addObject(player, 0, (32*11));
        
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
    
    public void generateTrees(int x, int length, int y, int distance) {
        int blockSize = 32;
        int startPos = 16 + (blockSize*x);
        int rand = Greenfoot.getRandomNumber(333);
        boolean isFlipped = false;
        y =(blockSize * y);
        for (int i = startPos; i < startPos + length*blockSize; i+=(blockSize*distance)) {
            if (rand % 2 == 0) {
                    addObject(new Tree1(), i, y + blockSize - 16);
                    rand = Greenfoot.getRandomNumber(333);
                } else {
                    addObject(new Tree2(), i, y + blockSize - blockSize/4);
                    rand = Greenfoot.getRandomNumber(333);
                }
            rand = Greenfoot.getRandomNumber(333);
        }
    }
    
    public void generateGrid()
    {
        GreenfootImage col = new GreenfootImage(1, MyWorld.HEIGHT);
        col.setColor(Color.BLACK);
        col.fillRect(0, 0, 1, MyWorld.WIDTH);
        
        GreenfootImage row = new GreenfootImage(MyWorld.WIDTH, 1);
        row.setColor(Color.WHITE);
        row.fillRect(0, 0, MyWorld.HEIGHT, 1);
        
        for(int i=0; i<(16*32); i++) {
            getBackground().drawImage(col, i * 32 - 1, 0);
            for (int j=0; j<(16*32)/ 32; j++) {
            getBackground().drawImage(row, 0, i * 32 + 32);
            GreenfootImage coord = new GreenfootImage("" + i + j, 12, Color.WHITE, Color.BLACK);
            }
        }
    }
}
