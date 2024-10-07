import greenfoot.*;

/**
 * The Lobster class chases the crab.
 * @author BrittneyHung
 * @version 10/7/2024 12:17pm
 */
public class Lobster extends Actor
{
    private int speed = 1;

    public void act()
    {
        chaseCrab();
        turnAtEdge();
        checkForCollision();
    }

    private void chaseCrab()
    {
        Crab crab = (Crab) getWorld().getObjects(Crab.class).get(0);
        
        if (crab != null) {
            turnTowards(crab.getX(), crab.getY());
        }

        move(speed);
    }

    private void turnAtEdge()
    {
        if (isAtEdge()) {
            turn(17);
        }
    }

    private void checkForCollision() 
    {
        if (isTouching(Crab.class)) 
        {
            removeTouching(Crab.class);
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
            getWorld().showText("You Lose!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }
}