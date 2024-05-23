import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Moving
{
    //GifImage runAnimation;
    GreenfootImage[] runAnimationRight = new GreenfootImage[7];
    GreenfootImage[] runAnimationLeft = new GreenfootImage[7];
    private int animationCounter = 0;
    
    private boolean isCrouching;
    private boolean isFalling;
    private boolean isSprinting;
    private boolean onGround;
    private boolean hasLevelGem;
    private boolean isPortalOpen;
    public static boolean isPlayerAlive;
    public static boolean isPlayerMoving;
    
    public static int section;
    
    private int initialX;
    private int initialY;
    
    private double acceleration;
    private double health;
    private double jumpHeight;
    private double currentSpeed;
    
    private int height;
    private int width;
     
    private int horzSpeed;
    private int vertSpeed;
    
    private int leftKeyPressCount;
    private int rightKeyPressCount;
    
    private int soundLoop;
    GreenfootSound walk = new GreenfootSound("walking.wav");
    GreenfootSound run = new GreenfootSound("running.wav");
    
    public Player()
    {
        isCrouching = false;
        isFalling = true;
        isSprinting = false;
        onGround = false;
        hasLevelGem = false;
        isPortalOpen =  false;
        isPlayerAlive = true;
        isPlayerMoving = false;
        
        section = 0;
        
        acceleration = 1;
        health = 3;
        jumpHeight = -44;
    
        height = 36*2;
        width = 43*2;
        vertSpeed = 2;
        horzSpeed = 4;
        
        leftKeyPressCount = 0;
        rightKeyPressCount = 0;
        
        walk.setVolume(45);
        run.setVolume(85);
        
        initRunAnimationRight();
        initRunAnimationLeft();
    }
    
    public void act()
    {
        moveAround();
        inWater();
        checkFalling();
        hitGem();
        hitSpirit();
        hitPortal();
        checkEdges();
        onGround();
        checkPlayerStatus();
    }
    
    public void addedToWorld(World world) {
        initialX = getX();
        initialY = getY();
    }
    
    public void initRunAnimationRight() {
        for (int i=0; i<7; i++) {
            String imgSrc = "runF" + i + ".png";
            GreenfootImage imgSetter = new GreenfootImage(imgSrc);
            imgSetter.scale(imgSetter.getWidth()*2, imgSetter.getHeight()*2);
            runAnimationRight[i] = imgSetter;
        }
    }
    
    public void runAnimationRight() {
        setImage(runAnimationRight[animationCounter % 7]);

        for (int d=0; d <= 9; d++) {
            if  (d == 9) {
                animationCounter++;        
            }
        }
    }
    
    public void initRunAnimationLeft() {
        for (int i=0; i<7; i++) {
            String imgSrc = "runF" + i + ".png";
            GreenfootImage imgSetter = new GreenfootImage(imgSrc);
            imgSetter.scale(imgSetter.getWidth()*2, imgSetter.getHeight()*2);
            imgSetter.mirrorHorizontally();
            runAnimationLeft[i] = imgSetter;
        }
    }
    
    public void runAnimationLeft() {
        setImage(runAnimationLeft[animationCounter % 7]);
        for (int d=0; d <= 9; d++) {
            if  (d == 9) {
                animationCounter++;        
            }
        }
    }
    
    public void moveAround(){
        if(Greenfoot.isKeyDown("shift") && isPlayerMoving == true) {
            walk.stop();
            if(soundLoop < 0 && !run.isPlaying()) {
                  run.play();
                  soundLoop = 80;
               } else {
                  soundLoop--;
               }
            } else {
                run.stop();
            }
            
        if(Greenfoot.isKeyDown("shift")) {
            isSprinting = true;
            acceleration = 2;
            horzSpeed = 6;
        } else {
            isSprinting = false;
            acceleration = 1.25;
            horzSpeed = 4;
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            runAnimationRight();
            move(horzSpeed);
            isPlayerMoving = true;
            if (rightKeyPressCount == 25) {
            rightKeyPressCount = 0;
            } else {
            rightKeyPressCount++;
            }
        }
        
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            runAnimationLeft();
            move(-horzSpeed);
            isPlayerMoving = true;
             if (leftKeyPressCount == 25) {
            leftKeyPressCount = 0;
            } else {
            leftKeyPressCount++;
            }
        }
        if(!(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")||  Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")))
        {
                isPlayerMoving = false;
                
        }
        if (onGround() == true)
        {
            if(isPlayerMoving == true)
            {
                if(soundLoop < 0 && !walk.isPlaying()) {
                  walk.play();
                  soundLoop = 80;
               } else {
                  soundLoop--;
               }
            } else {
                walk.stop();
            }
            
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space"))
            {
                GreenfootSound sound = new GreenfootSound("jump.wav");
                sound.setVolume(75);
                sound.play();
                if  (isSprinting) {
                    vertSpeed = (int) (jumpHeight * acceleration / 4);    
                } else {
                    vertSpeed = (int) (jumpHeight * acceleration / 3);
                }
                standUp();
                fall();
            }
        }
    }
    
    private void fall() {
        if (isPlayerAlive == true) {
            setLocation(getX(), getY() + vertSpeed);
            vertSpeed++;
        }
        vertSpeed++;
    }
    
    private boolean onGround() {
        Actor under1 = getOneObjectAtOffset(0, 32, TallGrass.class);
        Actor under2 = getOneObjectAtOffset(0, 32, Grass.class);
        Actor under3 = getOneObjectAtOffset(0, 32, Dirt.class); 

        return (under1 != null || under2 != null || under3 != null);
    }
    
    private boolean inWater() {
        Actor under1 = getOneObjectAtOffset(0, 32, WaterBody.class);
        Actor under2 = getOneObjectAtOffset(0, 32, WaterSurface.class);
        GreenfootSound sound = new GreenfootSound("splash.wav");
        sound.setVolume(75);
                
        if (getOneIntersectingObject(WaterSurface.class) != null) {
            health -= 1;
            sound.play();
        } else if (getOneIntersectingObject(WaterBody.class) != null) {
            health -= 1;
            sound.play();
        }
        return (under1 != null || under2 != null);

    }
    
    private void checkPlayerStatus() {
        World world = getWorld();
        if ( health == 0) {
                run.stop();
                walk.stop();
                isPlayerMoving = false;
                isPlayerAlive = false;
                getImage().setTransparency(0);
                world.removeObject(this);
            }
        if (!isPlayerAlive) {
            world.addObject(new LevelFailed(), MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
            world.addObject(new Ribbon(), MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
            world.showText("Level Failed!", (32*12),(32*8)-8);
            world.showText("retry?", (32*10)+8,(32*11));

            if(MyWorld.LEVEL == 1){
                Button retryButton = new Button("btn1.png", new Level1());
                world.addObject(retryButton, MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
            }
            if(MyWorld.LEVEL == 2){
                Button retryButton = new Button("btn1.png", new Level2());
                world.addObject(retryButton, MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
            }
            if(MyWorld.LEVEL == 3){
                Button retryButton = new Button("btn1.png", new Level3());
                world.addObject(retryButton, MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
            }
        }
    }
    
    private void checkFalling() {
        if (!onGround()) {
            isFalling = true;
            fall();
        } else {
            isFalling = false;
        } 
    }
    
    private void crouch() {
        GreenfootImage image = getImage();
        if (!isCrouching && Greenfoot.isKeyDown("Ctrl")) {
            if (image != null) {
                image.scale(width, height/2);
                setImage(image);
                isCrouching = true;
            }
        }
    }
    
    private void standUp() {
        GreenfootImage image = getImage();
        if (isCrouching) {
            if(image != null) {
                image.scale(width, height);
                setImage(image);
                isCrouching = false;
            }
        }
    }
    
    private void hitSpirit() {
        if (getOneIntersectingObject(Spirit.class) != null) {
            getOneIntersectingObject(Spirit.class).getImage().setTransparency(0);
            getWorld().removeObject(getOneIntersectingObject(Spirit.class));                  
        }
    }
    
    private void hitGem() {
        Portal portal = (Portal) getWorld().getObjects(Portal.class).get(0);
        if( MyWorld.LEVEL >= 1) {
            MissingGem missingGem = (MissingGem) getWorld().getObjects(MissingGem.class).get(0);
            if (getOneIntersectingObject(LevelGem.class) != null) {
                Greenfoot.playSound("gem.wav");
                getWorld().removeObject(getOneIntersectingObject(LevelGem.class));
                hasLevelGem = true;
                missingGem.setImage("gem2.png");
                missingGem.getImage().scale(missingGem.getImage().getWidth() * 2, missingGem.getImage().getHeight() * 2);
                isPortalOpen = true;
                portal.setImage("lift-open.png");
            }
        }
    }
    
    private void hitPortal() {
        Portal portal = (Portal) getWorld().getObjects(Portal.class).get(0);
        World world = getWorld();
        
            if(getOneIntersectingObject(Portal.class) != null) {
                if (MyWorld.LEVEL == 0) {
                    MyWorld.LEVEL = 1;
                    Greenfoot.setWorld(new Level1());
                } else if (MyWorld.LEVEL > 0 && Greenfoot.isKeyDown("e") && isPortalOpen && hasLevelGem) {
                    world.addObject(new LevelCompleted(), MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
                    world.addObject(new Ribbon(), MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
                    world.showText("Level Complete!", (32*12),(32*8)-8);
                    if(MyWorld.LEVEL == 3){
                        Button retryButton = new Button("btn1.png", new Level3());
                        world.addObject(retryButton, MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
                        Button nextButton = new Button("btn2.png", new SplashScreen());
                    world.addObject(nextButton, MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
                    }   
                    if(MyWorld.LEVEL == 2){
                        Button retryButton = new Button("btn1.png", new Level2());
                        world.addObject(retryButton, MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
                        world.showText("retry?", (32*10)+8,(32*11));
                        Button nextButton = new Button("btn2.png", new Level3());
                        world.addObject(nextButton, MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
                        world.showText("next level", (32*14),(32*11));
                    }
                    if(MyWorld.LEVEL == 1){
                        Button retryButton = new Button("btn1.png", new Level1());
                        world.addObject(retryButton, MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
                        world.showText("retry?", (32*10)+8,(32*11));
                        Button nextButton = new Button("btn2.png", new Level2());
                        world.addObject(nextButton, MyWorld.WIDTH/2, MyWorld.HEIGHT/2);
                        world.showText("next level", (32*14),(32*11));
                        
                    }
                    
                      
                }
        }
    }
    
    private void checkEdges() {
        // Left edge:
        if (MyWorld.LEVEL > 0){
            if (getX() >= MyWorld.WIDTH) {
                section -= 1;
                setLocation(1, getY());
                for (Object obj : getWorld().getObjects(TallGrass.class)) {
                    Actor tallGrass = (Actor) obj;
                    tallGrass.setLocation((tallGrass.getX() - MyWorld.WIDTH), tallGrass.getY());
                }
                for (Object obj : getWorld().getObjects(Grass.class)) {
                    Actor grass = (Actor) obj;
                    grass.setLocation((grass.getX() - MyWorld.WIDTH), grass.getY());
                }
                for (Object obj : getWorld().getObjects(Dirt.class)) {
                    Actor dirt = (Actor) obj;
                    dirt.setLocation((dirt.getX() - MyWorld.WIDTH), dirt.getY());
                }
                for (Object obj : getWorld().getObjects(LevelGem.class)) {
                    Actor levelGem = (Actor) obj;
                    levelGem.setLocation((levelGem.getX() - MyWorld.WIDTH), levelGem.getY());
                }
                for (Object obj : getWorld().getObjects(Portal.class)) {
                    Actor portal = (Actor) obj;
                    portal.setLocation((portal.getX() - MyWorld.WIDTH), portal.getY());
                }
                for (Object obj : getWorld().getObjects(Tree1.class)) {
                    Actor tree1 = (Actor) obj;
                    tree1.setLocation((tree1.getX() + MyWorld.WIDTH), tree1.getY());
                    getWorld().removeObject(tree1);
                }
                for (Object obj : getWorld().getObjects(Tree2.class)) {
                    Actor tree2 = (Actor) obj;
                    tree2.setLocation((tree2.getX() + MyWorld.WIDTH), tree2.getY());
                    getWorld().removeObject(tree2);
                }
                for (Object obj : getWorld().getObjects(TreeTopBack.class)) {
                    Actor treeTopBack = (Actor) obj;
                    treeTopBack.setLocation((treeTopBack.getX() + MyWorld.WIDTH), treeTopBack.getY());
                    getWorld().removeObject(treeTopBack);
                }
                for (Object obj : getWorld().getObjects(TreeTopFront.class)) {
                    Actor treeTopFront = (Actor) obj;
                    treeTopFront.setLocation((treeTopFront.getX() + MyWorld.WIDTH), treeTopFront.getY());
                    getWorld().removeObject(treeTopFront);
                }
            }
            
            // Right edge:
            if (getX() < 0) {
                section += 1;
                setLocation(MyWorld.WIDTH, getY());
                for (Object obj : getWorld().getObjects(TallGrass.class)) {
                    Actor tallGrass = (Actor) obj;
                    tallGrass.setLocation((tallGrass.getX() + MyWorld.WIDTH), tallGrass.getY());
                }
                for (Object obj : getWorld().getObjects(Grass.class)) {
                    Actor grass = (Actor) obj;
                    grass.setLocation((grass.getX() + MyWorld.WIDTH), grass.getY());
                }
                for (Object obj : getWorld().getObjects(Dirt.class)) {
                    Actor dirt = (Actor) obj;
                    dirt.setLocation((dirt.getX() + MyWorld.WIDTH), dirt.getY());
                }
                for (Object obj : getWorld().getObjects(LevelGem.class)) {
                    Actor levelGem = (Actor) obj;
                    levelGem.setLocation((levelGem.getX() + MyWorld.WIDTH), levelGem.getY());
                }
                for (Object obj : getWorld().getObjects(Portal.class)) {
                    Actor portal = (Actor) obj;
                    portal.setLocation((portal.getX() + MyWorld.WIDTH), portal.getY());
                }
                for (Object obj : getWorld().getObjects(Tree1.class)) {
                    Actor tree1 = (Actor) obj;
                    tree1.setLocation((tree1.getX() + MyWorld.WIDTH), tree1.getY());
                    
                }
                for (Object obj : getWorld().getObjects(Tree2.class)) {
                    Actor tree2 = (Actor) obj;
                    tree2.setLocation((tree2.getX() + MyWorld.WIDTH), tree2.getY());
                }
                for (Object obj : getWorld().getObjects(TreeTopBack.class)) {
                    Actor treeTopBack = (Actor) obj;
                    treeTopBack.setLocation((treeTopBack.getX() + MyWorld.WIDTH), treeTopBack.getY());
                }
                for (Object obj : getWorld().getObjects(TreeTopFront.class)) {
                    Actor treeTopFront = (Actor) obj;
                    treeTopFront.setLocation((treeTopFront.getX() + MyWorld.WIDTH), treeTopFront.getY());
                }
            }
            
            // Bottom edge:
              if (getY() >= getWorld().getHeight() - getImage().getHeight()/2) {
                health = 0;
                vertSpeed = 0;
            }
        }
    }
}