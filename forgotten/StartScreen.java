import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        super(768, 512, 1); 
        // does the title have to be a button? can't it just be a plain image?
        //Button titleButton = new Button("title.png", new SplashScreen());
        GreenfootImage title = new GreenfootImage("title.png");
        getBackground().drawImage(title, (32*4)+16, -(32*2));
        

        Button startButton = new Button("start.png", new Level1());
        addObject(startButton, 32*12, 32*8);
        
        Button tutorialButton = new Button("tutorial.png", new Level0());
        addObject(tutorialButton, 32*12, 32*9);
    }
}
