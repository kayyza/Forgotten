import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 800, 1); 
        showTextWithBigRedFont("GAME OVER",600, getHeight() / 2);
    }
    public void showTextWithBigRedFont(String message, int x, int y)
    {
    GreenfootImage bg = getBackground();
    Font font =  new  Font(50);
    bg.setFont(font);
    bg.setColor(Color.RED);
    bg.drawString(message, x, y);
    }
 }
