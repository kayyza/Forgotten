import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class StartScreen extends World
{

   
    public StartScreen()
    {    
        super(768, 512, 1); 
        
        if( MyWorld.LEVEL != -1) {
            MyWorld.LEVEL = -1;
        }
        
        GreenfootImage title = new GreenfootImage("title.png");
        getBackground().drawImage(title, (32*4)+16, -(32*2));
        

        Button startButton = new Button("start.png", new Level1());
        addObject(startButton, 32*12, 32*8);
        
        Button tutorialButton = new Button("tutorial.png", new TutorialScreen());
        addObject(tutorialButton, 32*12, 32*9);
    }
}
