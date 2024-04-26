import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static int HEIGHT;
    public static int WIDTH;
    public static int LEVEL;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(768, 512, 1, false);
         
        HEIGHT = getHeight();
        WIDTH = getWidth();
        LEVEL = 0;
    
        GreenfootImage bg = getBackground();
        bg.setColor(Color.LIGHT_GRAY);
        bg.fill();
        
        prepare();
    }
    
    public void act()
    {
        super.act();
    }
    
    private void prepare()
    {
        
        generateGrid();
        // Generate sky panels:
        for (int i = 0; i < 12000; i+=60) {
            //addObject(new Sky(), +i, 266);
        }
        
        //changeWorld();        
        // Since the code isn't working, I'm just going to hardcode it for now...
        if  (LEVEL == 0) {
            int platLen1 = 24;
            int platPos1 = 0;
            generatePlatform(platPos1, platLen1,13);
            
            LevelGem levelGem = new LevelGem();
            addObject(levelGem, (32*13 - 4),(32*10));
                
            Portal portal = new Portal();
            addObject(portal, (32*22), (32*11));
            
                
            Player player = new Player();
            addObject(player, 0, MyWorld.HEIGHT - 142);
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
        GreenfootImage col = new GreenfootImage(1, HEIGHT);
        col.setColor(Color.BLACK);
        col.fillRect(0, 0, 1, WIDTH);
        
        GreenfootImage row = new GreenfootImage(WIDTH, 1);
        row.setColor(Color.WHITE);
        row.fillRect(0, 0, HEIGHT, 1);
        
        for(int i=0; i<(16*32); i++) {
            getBackground().drawImage(col, i * 32 - 1, 0);
            for (int j=0; j<(16*32)/ 32; j++) {
            getBackground().drawImage(row, 0, i * 32 + 32);
            GreenfootImage coord = new GreenfootImage("" + i + j, 12, Color.WHITE, Color.BLACK);
            }
        }
    }
    
    //Code isn't working :((
    public void changeWorld() {
        if  (LEVEL == -1) {
            Greenfoot.setWorld(new StartScreen());
        }
        if (LEVEL == 0) {
            Greenfoot.setWorld(new Level0());
        }
        if (LEVEL == 1) { 
            Greenfoot.setWorld(new Level1());
        }
        /*switch(LEVEL) {
            case -1 : Greenfoot.setWorld(new StartScreen()); 
            case 0 : Greenfoot.setWorld(new Level0()); 
            case 1: Greenfoot.setWorld(new Level1()); 
            
        }*/
    }
}
