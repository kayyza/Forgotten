import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Moving
{
    GifImage runAnimation;
    GreenfootImage image;
    
    private boolean isImageFlipped;
    private boolean isCrouching;
    private boolean isFalling;
    private boolean isSprinting;
    private boolean onGround;
    private boolean hasLevelGem;
    private boolean isPortalOpen;
    private boolean isPlayerAlive;
    
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
    
    public Player()
    {
        runAnimation = new GifImage("run_animation.gif");
        isImageFlipped = false;
        isCrouching = false;
        isFalling = true;
        isSprinting = false;
        onGround = false;
        hasLevelGem = false;
        isPortalOpen =  false;
        isPlayerAlive = true;
        
        acceleration = 1;
        health = 1;
        jumpHeight = -44;
    
        height = 36;
        width = 43;
        vertSpeed = 1;
        horzSpeed = 3;
        
        leftKeyPressCount = 0;
        rightKeyPressCount = 0;
        
    }
    
    public void act()
    {
        if (image != null) {
            image = runAnimation.getCurrentImage();
            image.scale(width,height);
            setImage(image);
        }
        
        moveAround();
        checkFalling();
        hitGem();
        hitPortal();
        checkEdges();
        onGround();
        checkPlayerStatus();
    }
    
    public void addedToWorld(World world) {
        //is this method necessary?
        initialX = getX();
        initialY = getY();
    }
    
    public void moveAround(){
        if(Greenfoot.isKeyDown("shift")) {
            isSprinting = true;
            acceleration = 1.5;
            horzSpeed = 5;
        } else {
            isSprinting = false;
            acceleration = 1.25;
            horzSpeed = 3;
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            move(horzSpeed);
            if(isImageFlipped) {
                getImage().mirrorHorizontally();
                isImageFlipped = false;
            }
            if (rightKeyPressCount == 25) {
            //  I accidentally removed the grassStep sound file from the folder, so it bugs now ;;
            // (If someone can fix this, or send me the sound file so I can fix it that would be great!!) 
            //Greenfoot.playSound("grassStep.wav");
            rightKeyPressCount = 0;
            } else {
            rightKeyPressCount++;
            }
        }
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            move(-horzSpeed);
            if (!isImageFlipped) {
                getImage().mirrorHorizontally();
                isImageFlipped = true;
            }
             if (leftKeyPressCount == 25) {
            //Greenfoot.playSound("grassStep.wav");
            leftKeyPressCount = 0;
            } else {
            leftKeyPressCount++;
            }
        }
        if (onGround() == true)
        {
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space"))
            {
                crouch();
                vertSpeed = (int) (jumpHeight * acceleration / 4);
                standUp();
                fall();
                //Greenfoot.playSound("jump_11.wav");
            }
            if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
                crouch();
            } else {
                standUp();
            }
        }
        
    }
    
    private void fall() {
        setLocation(getX(), getY() + vertSpeed);
        vertSpeed++;
    }
    
    private boolean onGround() {
        Actor under1 = getOneObjectAtOffset(0, 32, TallGrass.class);
        Actor under2 = getOneObjectAtOffset(0, 32, Grass.class);
        Actor under3 = getOneObjectAtOffset(0, 32, Dirt.class); 

        return (under1 != null || under2 != null || under3 != null);
    }
    
    private void inWater() {
        if (getOneIntersectingObject(WaterSurface.class) != null) {
            health = 0;
            if ( health == 0) {
                isPlayerAlive = false;
            }
        }
    }
    
    private void checkPlayerStatus() {
        if (!isPlayerAlive) {
            Greenfoot.setWorld(new LevelFailed());
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
        if (!isCrouching) {
            if (image != null) {
                image.scale(width, height/2);
                setImage(image);
                isCrouching = true;
            }
        }
    }
    
    private void standUp() {
        if (isCrouching) {
            if(image != null) {
                image.scale(width, height);
                setImage(image);
                isCrouching = false;
            }
        }
    }
    
    private void hitGem() {
        Portal portal = (Portal) getWorld().getObjects(Portal.class).get(0);
        
        if (getOneIntersectingObject(LevelGem.class) != null) {
            getWorld().removeObject(getOneIntersectingObject(LevelGem.class));
            hasLevelGem = true;
            isPortalOpen = true;
            portal.setImage("lift-open.png");
        } 
    }
    
    private void hitPortal() {
        Portal portal = (Portal) getWorld().getObjects(Portal.class).get(0);
            
            if(getOneIntersectingObject(Portal.class) != null && hasLevelGem) {
                //Greenfoot.
                if (MyWorld.LEVEL == 0) {
                    MyWorld.LEVEL = 1;
                    Greenfoot.setWorld(new Level1());
                } else if (MyWorld.LEVEL > 0 && Greenfoot.isKeyDown("e")) {
                    MyWorld.LEVEL++;
                    MyWorld.changeWorld();        
                }
        }
    }
    
    private void checkEdges() {
        // Left edge:
        if (getX() >= MyWorld.WIDTH) {
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
        }
        
        // Right edge:
        if (getX() < 0) {
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
        }
        
        // Bottom edge:
          if (getY() >= getWorld().getHeight() - getImage().getHeight()/2) {
            setLocation(getX() - (32*2), initialY - (32*2));
            vertSpeed = 0;
        }
    }
}