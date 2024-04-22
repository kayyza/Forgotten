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
    
    private int HEIGHT = getHeight();
    private int WIDTH = getWidth();
    private static double GRAVITY;
    private Actor clone = new Sky();
    
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(768, 512, 1);
        
        GRAVITY = 9.807; 
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
        generateBG();
       
        // Generate sky panels:
        for (int i = 0; i < 12000; i+=60) {
            addObject(new Sky(), +i, 266);
        }
        
        // Generate tall Grass:
        int platLen1 = 4;
        int platPos1 = 0;
        generatePlatform(platPos1, platLen1,14); 
        
        int platLen2 = 2;
        int platPos2 = 6;
        generatePlatform(platPos2, platLen2,15); 
        
        int platLen3 = 3;
        int platPos3 = 10;
        generatePlatform(platPos3, platLen3, 12); 
        
        int platLen4 = 16;
        int platPos4 = 14;
        generatePlatform(platPos4, platLen4,14); 
        
        Player player = new Player();
        addObject(player, 80, HEIGHT - 26 - 88);        
        
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
        
    public void generateBG()
    {
        GreenfootImage bg = new GreenfootImage(1,1);
    }
    
    public static double getGravity()
    {
        return GRAVITY;
    }
}
