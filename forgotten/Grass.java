import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Grass extends NonMoving
{
    public Grass() 
    {
        // getImage().scale(getImage().getWidth()*3,getImage().getHeight()/2);
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
