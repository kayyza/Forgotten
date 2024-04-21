import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{

    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 800, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground = new Ground();
        addObject(ground,111,670);
        Ground ground2 = new Ground();
        addObject(ground2,490,452);
        Ground ground3 = new Ground();
        addObject(ground3,820,658);
        ground2.setLocation(579,528);
        ground3.setLocation(802,729);
        ground2.setLocation(401,470);
        ground.setLocation(172,592);
        ground2.setLocation(396,414);
        Ground ground4 = new Ground();
        addObject(ground4,637,568);
        Player player = new Player();
        addObject(player,52,547);
        ground.setLocation(80,590);
        ground.setLocation(86,627);
        ground2.setLocation(292,428);
        Ground ground5 = new Ground();
        addObject(ground5,480,260);
        Cloud cloud = new Cloud();
        addObject(cloud,887,136);
        Cloud cloud2 = new Cloud();
        addObject(cloud2,436,162);
        cloud2.setLocation(297,77);
        cloud2.setLocation(419,187);
        cloud2.setLocation(383,133);
        Cloud cloud3 = new Cloud();
        addObject(cloud3,1363,89);
        Cloud cloud4 = new Cloud();
        addObject(cloud4,215,77);
        cloud.setLocation(811,131);
        Cloud cloud5 = new Cloud();
        addObject(cloud5,811,131);
        cloud2.setLocation(439,168);
        cloud4.setLocation(268,70);
        cloud5.setLocation(607,31);
        cloud.setLocation(1024,162);
        cloud5.setLocation(728,52);
        Ground ground6 = new Ground();
        addObject(ground6,962,360);
        Ground ground7 = new Ground();
        addObject(ground7,1062,593);
        Ground ground8 = new Ground();
        addObject(ground8,1357,299);
        Ground ground9 = new Ground();
        addObject(ground9,1343,712);
        Ground ground10 = new Ground();
        addObject(ground10,1389,510);
    }
}
