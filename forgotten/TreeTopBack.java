import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TreeTopBack extends NonMoving
{
    private GreenfootImage image;
  
    
    public TreeTopBack() {
        image = getImage();
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
    }
    
    public void act()
    {
        move();
    }
    
    public void move() {
        int horzSpeed;
        if(Player.isPlayerAlive) {
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
}
