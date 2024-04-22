import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sky extends NonMoving
{
    /**
     * Act - do whatever the Sky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Sky() {
        getImage().scale(getImage().getWidth()*2,getImage().getHeight()*2);
    }
    public void act()
    {
        // Add your action code here.
        move();
    }
    
    public void prepare() {
        
    }
    
    public void move() {
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            move(1);
        }
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            move(-1);    
        }
        
    }
}
