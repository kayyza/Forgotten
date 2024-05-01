import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Portal extends NonMoving
{
       public void act()
    {
        move();
    }
    
    public void move() {
        int horzSpeed;
        if(Greenfoot.isKeyDown("shift")) {
            //horzSpeed = -2;
            horzSpeed = (MyWorld.LEVEL == 0) ? 0 : -2;
        } else {
            //horzSpeed = -1;
            horzSpeed = (MyWorld.LEVEL == 0) ? 0 : -1;
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
