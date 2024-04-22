import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dirt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dirt extends NonMoving
{
    /**
     * Act - do whatever the Dirt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dirt()
    {
        // getImage().scale(getImage().getWidth(),getImage().getHeight());
        getImage().mirrorVertically();
    }
   public void act()
    {
        move();
    }
    
    public void move() {
        int horzSpeed;
        if(Greenfoot.isKeyDown("shift")) {
            horzSpeed = -3;
        } else {

            horzSpeed = -2;
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            move(horzSpeed);
        }
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            move(-horzSpeed);    
        }
        
    }
}
