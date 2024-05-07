import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tree2 extends NonMoving
{
    private GreenfootImage image;
    /*private GreenfootImage topFront;
    private GreenfootImage topBack;*/
    
    public Tree2() {
        image = getImage();
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
        
        
        
        int rand = Greenfoot.getRandomNumber(333);
        boolean isFlipped = false;

        for (int i = 0; i < 12000; i+=60) {
            if (rand % 2 == 0) {
                if (!isFlipped) {
                    getImage().mirrorHorizontally();
                    isFlipped = true;
                }
            } else {
                if (isFlipped) {
                    getImage().mirrorHorizontally();
                    isFlipped = false;
                }
            }
            rand = Greenfoot.getRandomNumber(333);
        }
    }
    
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
