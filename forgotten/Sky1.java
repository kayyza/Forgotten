import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sky1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sky1 extends NonMoving
{
    private GreenfootImage image;
    
    public Sky1() {
        image = getImage();
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
