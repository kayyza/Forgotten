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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(768, 512, 1); 
        Button titleButton = new Button("title.png", new Level0());
        addObject(titleButton, 32*12, 32*5);
        Button startButton = new Button("start.png", new Level0());
        addObject(startButton, 32*12, 32*8);
        Button tutorialButton = new Button("tutorial.png", new Level0());
        addObject(tutorialButton, 32*12, 32*9);
    }
}
