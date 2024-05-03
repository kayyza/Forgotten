import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sky3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sky3 extends NonMoving
{
    /**
     * Act - do whatever the Sky3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    
    public Sky3() {
        image = getImage();
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
