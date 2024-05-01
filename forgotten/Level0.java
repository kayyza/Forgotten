import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level0 extends World
{
    public Level0()
    {    
        super(768, 512, 1, false); 
        showText("TUTORIAL", 32*2, 32*2);
        generateSky();
        prepare();
    }
        
    public void prepare() {    
        int platLen1 = 24;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,14); 
        
        Portal portal = new Portal();
        addObject(portal, (32*25), (32*12));
               
        //LevelGem levelGem = new LevelGem();
        //addObject(levelGem, (32*21),(32*10));
            
        Player player = new Player();
        addObject(player, 0, MyWorld.HEIGHT - 142 + 32);
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
