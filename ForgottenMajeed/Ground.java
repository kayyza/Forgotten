import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
   
{
    public Ground (){
    getImage().scale(getImage().getWidth()*3,getImage().getHeight());
    }
    /*
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right")|| Greenfoot.isKeyDown("d"))
        {
            move(-4);
        }
        if(Greenfoot.isKeyDown("left")|| Greenfoot.isKeyDown("a"))
        {
            move(4);
        }
        if (getX()==0){
             getWorld().removeObject(this);
        /*if (getX()==0){
             setLocation(getWorld().getWidth() - 1, Greenfoot.getRandomNumber (799) + 270); 
        */}
        }
    }
