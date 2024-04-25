import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**import java.util.ArrayList;
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public static int HEIGHT;
    public static int WIDTH;
    
    private int LEVEL;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(768, 512, 1, false);
         
        HEIGHT = getHeight();
        WIDTH = getWidth();
        LEVEL = 1;
    
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
        
        if (LEVEL == 0) {

            //Greenfoot.setWorld(new Level0());
            // Generate tall Grass:
            int platLen1 = 10;
            int platPos1 = 0;
            generatePlatform(platPos1, platLen1,14); 
        
            int platLen2 = 4;
            int platPos2 = 12;
            generatePlatform(platPos2, platLen2,14); 
        
            int platLen3 = 30;
            int platPos3 = 18;
            generatePlatform(platPos3, platLen3, 13); 
        
            //int platLen4 = 16;
            //int platPos4 = 14;
            //generatePlatform(platPos4, platLen4,14); 
        
            Player player = new Player();
            addObject(player, 80, MyWorld.HEIGHT - 26 - 88); 
            if(player.getX() >= MyWorld.WIDTH) {
                LEVEL += 1;
            }
        }
        if  (LEVEL == 1) {
            int platLen1 = 4;
            int platPos1 = 0;
            generatePlatform(platPos1, platLen1,13); 
        
            int platLen2 = 3;
            int platPos2 = 6;
            generatePlatform(platPos2, platLen2,15); 
            
            int platLen3 = 2;
            int platPos3 = 10;
            generateFloatPlatform(platPos3, platLen3, 13);
        
            int platLen4 = 2;
            int platPos4 = 14;
            generateFloatPlatform(platPos4, platLen4, 11);
            
            int platLen5 = 4;
            int platPos5 = 7;
            generateFloatPlatform(platPos5, platLen5, 9);
            
            int platLen6 = 3;
            int platPos6 = 1;
            generateFloatPlatform(platPos6, platLen6, 6);
            
            int platLen7 = 6;
            int platPos7 = 19;
            generatePlatform(platPos7, platLen7,14);
            
            LevelGem levelGem = new LevelGem();
            addObject(levelGem, (32*2 + 16),(32*5));
            
            Portal portal = new Portal();
            addObject(portal, (32*22), (32*12));
            
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
}
