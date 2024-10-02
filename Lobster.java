import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lobster extends Actor
{
    private int speed = 5;
    public void act()
    {
        move(speed);     
        turnAtEdge(); 
        lookForCrab(); 
    }

    /**
     * Turn the Lobster when it reaches the edge of the screen.
     */
    public void turnAtEdge()
    {
        if (isAtEdge()) {
            turn(5);  
        }
    }

    /**
     * Check if the Lobster touches the Crab, if so, end the game.
     */
    public void lookForCrab()
    {
        if (isTouching(Crab.class)) {
            Greenfoot.playSound("au.wav");  
            Greenfoot.stop();  
            getWorld().showText("You Lost!", getWorld().getWidth() / 2, getWorld().getHeight() / 2); 
        }
    }
    
}