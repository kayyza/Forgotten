import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    SimpleTimer time = new SimpleTimer();
    Counter timeCount = new Counter();

    public static int HEIGHT;
    public static int WIDTH;
    public static int LEVEL;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(768, 512, 1, false);
        
        addObject(timeCount, getWidth() / 2, getHeight() / 2);
        time.mark();
         
        HEIGHT = getHeight();
        WIDTH = getWidth();
        LEVEL = -2;
    
        GreenfootImage bg = getBackground();
        bg.setColor(Color.LIGHT_GRAY);
        bg.fill();
        
        prepare();
    }
    
    public void act()
    {
        super.act();
        timeCount.setValue(time.millisElapsed());
    }
    
    private void prepare()
    {
        changeWorld();
        //playMusic();    
    }
    
    public void playMusic() {
        GreenfootSound song = new GreenfootSound ("background.mp3");
        song.setVolume(8);
        if (LEVEL >= 0 ) {
            song.playLoop();
        } else {
            song.setVolume(0);
            song.stop();
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
    
    public static void changeWorld() {
        switch(LEVEL) {
            case -3 : Greenfoot.setWorld(new TutorialScreen()); break;
            case -2 : Greenfoot.setWorld(new SplashScreen()); break;
            case -1 : Greenfoot.setWorld(new StartScreen()); break;
            case 0 : Greenfoot.setWorld(new Level0()); break;
            case 1 : Greenfoot.setWorld(new Level1()); break;
            case 2 : Greenfoot.setWorld(new Level2()); break;
            case 3 : Greenfoot.setWorld(new Level3()); break;
            default: Greenfoot.setWorld(new SplashScreen()); 
        }
    }
}
