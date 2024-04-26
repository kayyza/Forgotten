import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Moving
{
    private GreenfootImage image;
    private boolean isImageFlipped;
    private boolean isCrouching;
    private boolean isFalling;
    private boolean isSprinting;
    private boolean isOnGround;
    private boolean hasLevelGem;
    
    private int initialX;
    private int initialY;
    
    private double acceleration;
    private double health;
    private double jumpHeight;
    private int height;
    private int width;
    private int horzSpeed;
    private int vertSpeed;
<<<<<<< HEAD

=======
    private int leftKeyPressCount;
    private int rightKeyPressCount;
/**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
>>>>>>> 4dd78821ca0b4968f43e83342f5cc3baffa82edd
     public Player() {
        image = getImage();
        isImageFlipped = false;
        isCrouching = false;
        isFalling = true;
        isSprinting = false;
        isOnGround = false;
        hasLevelGem = false;
        
        acceleration = 1;
        health = 3;
        jumpHeight = -image.getHeight();
        height = image.getHeight();
        width = image.getWidth();
        vertSpeed = 1;
        horzSpeed = 3;
        
        leftKeyPressCount = 0;
        rightKeyPressCount = 0;
    }
    
    public void act(){
        moveAround();
        checkFalling();
        checkBottom();
        hitGem();
        hitPortal();
    }
    
    public void addedToWorld(World world) {
        initialX = getX();
        initialY = getY();
    }
    
    public void moveAround(){
        MyWorld myWorld = (MyWorld) getWorld();
        
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
            Greenfoot.playSound("grassStep.wav");
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
            Greenfoot.playSound("grassStep.wav");
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
                Greenfoot.playSound("jump_11.wav");
            }
            if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
                crouch();
            } else {
                standUp();
            }
        }
        
    }
    
      private void fall(){
        setLocation(getX(), getY() + vertSpeed);
        vertSpeed++;
    }
    
    boolean onGround(){
        Actor under1 = getOneObjectAtOffset(0, getImage().getHeight()/2, TallGrass.class);
        Actor under2 = getOneObjectAtOffset(0, getImage().getHeight()/2, Grass.class);
        Actor under3 = getOneObjectAtOffset(0, getImage().getHeight()/2, Dirt.class); 
        
        // return actor is not equal to null, meaning actor.. is falling???
        return (under1 != null || under2 != null || under3 != null);
    }
    
    private void checkFalling(){
        if (onGround() == false){
            isFalling = true;
            fall();
        } else {
            isFalling = false;
        }
    }
     
    private void crouch() {
        if (!isCrouching) {
            image.scale(width, height / 2);
            setImage(image);
            isCrouching = true;
        }
    }
    
    private void standUp() {
        if (isCrouching) {
            image.scale(width, height);
            setImage(image);
            isCrouching = false;
        }
    }
    
    private void checkBottom() {
        if (getY() >= getWorld().getHeight() - getImage().getHeight() / 2) {
            setLocation(initialX, initialY); 
            vertSpeed = 0; 
        }
    }
    private void hitGem() {
        Portal portal = (Portal) getWorld().getObjects(Portal.class).get(0);
        if (getOneIntersectingObject(LevelGem.class) != null) {
            getWorld().removeObject(getOneIntersectingObject(LevelGem.class));
            hasLevelGem = true;
            portal.setImage("lift-open.png");
        } 
    }
    
    private void hitPortal() {
        if  (Greenfoot.isKeyDown("e")) {
            //MyWorld.LEVEL++;
            if ( MyWorld.LEVEL == 0) {
                MyWorld.LEVEL++;
                Greenfoot.setWorld(new Level1());
            }
        }
    }
    
}