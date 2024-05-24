import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TutorialScreen extends World
{
    public TutorialScreen()
    {    
        super(768, 512, 1); 
        showText("Use WASD / Arrow keys to move", 32*12, 32*4);
        showText("Use W / Spacebar to jump", 32*12, 32*6); 
        showText("Press E to interact with ports", 32*12, 32*7);

        prepare();
    }
    
    private void prepare()
    {
        if( MyWorld.LEVEL != -3) {
            MyWorld.LEVEL = -3;
        }
        
        Button startButton = new Button("start.png", new Level1());
        addObject(startButton, 32*12, 32*9);
    }
}
