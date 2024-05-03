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
        
        // Im not sure why, but they're being recognized as the same thing
        // Im not sure if the buttons are at fault, or if its the changeWorld() method?
        // Maybe the level isn't being updated?
        if (Greenfoot.mousePressed(tutorialButton)) {
            MyWorld.LEVEL = 0;
            MyWorld.changeWorld();
        }
        if (Greenfoot.mousePressed(tutorialButton)) {
            MyWorld.LEVEL = 1;
            MyWorld.changeWorld();
        }
    
    }
}
