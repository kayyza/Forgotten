import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spirit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spirit extends NonMoving
{
    GreenfootImage[] animation= new GreenfootImage[3];
    private int animationCounter = 0;
    
    public Spirit() {
        initAnimation();
    }
    
    public void act()
    {
        move();
        Animation();
    }
    
     public void initAnimation() {
        for (int i=0; i<3; i++) {
            String imgSrc = "spirit" + i + ".png";
            GreenfootImage imgSetter = new GreenfootImage(imgSrc);
            animation[i] = imgSetter;
        }
    }
    
     public void Animation() {
        setImage(animation[animationCounter % 3]);

        animationCounter++;        
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
