import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int vertSpeed;
    private int acceleration;
    private int jumpHeight;
    private boolean isCrouching;
    private int initialX;
    private int initialY;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Player() {
        vertSpeed = 0;
        acceleration = 1;
        jumpHeight = -25;
        isCrouching = false;
    }
    public void act(){
        moveAround();
        checkFalling();
        if(Greenfoot.isKeyDown("right")|| Greenfoot.isKeyDown("d"))
        {
            move(4);
        }
        if(Greenfoot.isKeyDown("left")|| Greenfoot.isKeyDown("a"))
        {
            move(-4);
        }
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
            crouch();
        } else {
            standUp();
        }
        checkBottom();
    }
    public void addedToWorld(World world) {
        initialX = getX();
        initialY = getY();
    }
    private void fall(){
        setLocation(getX(), getY() + vertSpeed);
        vertSpeed += acceleration;
    }
    public void moveAround(){
        if(Greenfoot.isKeyDown("w") && (onGround() == true))
        {
            vertSpeed = jumpHeight;
            fall();
        }
        if(Greenfoot.isKeyDown("up") && (onGround() == true))
        {
            vertSpeed = jumpHeight;
            fall();
        }
    }
    boolean onGround(){
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
        return under != null;
    }
    private void checkFalling(){
        if (onGround() == false){
            fall();
        }
    }
     private void crouch() {
        if (!isCrouching) {
            GreenfootImage image = getImage();
            image.scale(image.getWidth(), image.getHeight() / 2);
            setImage(image);
            isCrouching = true;
        }
    }
    private void standUp() {
        if (isCrouching) {
            GreenfootImage image = getImage();
            image.scale(image.getWidth(), image.getHeight() * 2);
            setImage(image);
            isCrouching = false;
        }
    }
    private void checkBottom() {
        if (getY() >= getWorld().getHeight() - getImage().getHeight() / 2) {
            GameOver gameOver = new GameOver();
            Greenfoot.setWorld(gameOver);
        }
    }
}