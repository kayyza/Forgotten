import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SplashScreen extends World
{
    private int timer = 0;
    public SplashScreen()
    {    
        super(768, 512, 1); 
        showText("GAME PROGRAMMING 1", 32*12, 32*4);
        showText("Developed by: Abdulmajeed Kakar, Eva Adejor, Gregory Denis,", 32*12, 32*6); 
        showText("Rachel Herron and Sabrina Robinson", 32*12, 32*7);

        //GreenfootSound music = new GreenfootSound("splashScreen.ogg");
        //music.setVolume(40);
        //music.play();
        prepare();
    }
    
    public void act(){
        timer++;
        if (timer == 200) {
            MyWorld.LEVEL = -1;
            MyWorld.changeWorld();
        }
    }
    
    private void prepare()
    {
        if( MyWorld.LEVEL != -2) {
            MyWorld.LEVEL = -2;
        }
        
        Logo logo = new Logo();
        addObject(logo,385,345);
    }
}
