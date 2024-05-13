import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SplashScreen extends World
{
    public SplashScreen()
    {    
        super(768, 512, 1, false); 
        showText("SPLASH SCREEN", 32*10, 32*6);
        
        GreenfootSound music = new GreenfootSound("splashScreen.ogg");
            music.setVolume(40);
            music.play();
    }
}
