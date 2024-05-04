import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level0 extends World
{
    public Level0()
    {    
        super(768, 512, 1, false); 
        showText("TUTORIAL", 32*2, 32*2);
        showText("" + MyWorld.LEVEL, 32*2, 32*3);
        generateSky();
        prepare();
    }
        
    public void prepare() {        
        int treesLen1 = 24;
        int treesPos1 = 10;
        int treesDis1 = 9;
        generateTrees(treesPos1, treesLen1,8, treesDis1); 
        
        int treesLen2 = 24;
        int treesPos2 = 16;
        int treesDis2 = 6;
        generateTrees(treesPos2, treesLen2,8, treesDis2);
        
        int platLen1 = 24;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,14); 
        
        int treesLen3 = 24;
        int treesPos3 = 20;
        int treesDis3 = 3;
        generateTrees(treesPos3, treesLen3,8, treesDis3);
        
        
        Portal portal = new Portal();
        addObject(portal, (32*25), (32*12));
         
        Player player = new Player();
        addObject(player, 0, MyWorld.HEIGHT - 142 + 16);
    }    
    
    public void generateSky() {
        int rand = Greenfoot.getRandomNumber(333);

        for (int i = 0; i < 12000; i+=120) {
            if (rand % 3 == 0) { 
                addObject(new Sky3(), +i, (32*8)+16);
            } else if (rand % 2 == 0) {
                addObject(new Sky2(), +i, (32*8)+16);
            } else {
                addObject(new Sky1(), +i, (32*8)+16);
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
