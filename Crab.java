import greenfoot.*;  

/**
 * This class defines a Crab. The crab eats worms, and avoids the lobster.
 * @author BrittneyHung
 * @version 10/7/2024 12:15pm
 */
public class Crab extends Actor
{
    private int speed = 3;   
    private int turnSpeed = 5;  

    public void act()
    {
        moveCrab();     
        checkForCollision(); 
        turnAtEdge();   
    }

    private void moveCrab() 
    {
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) 
        {
            move(speed); 
        }

        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) 
        {
            move(-speed);
        }

        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) 
        {
            turn(-turnSpeed);
        }

        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) 
        {
            turn(turnSpeed);
        }
    }

    private void turnAtEdge()
    {
        if (isAtEdge()) {
            turn(17);  
        }
    }

    private void checkForCollision() 
    {
        if (isTouching(Lobster.class)) 
        {
            Greenfoot.playSound("au.wav");  
            Greenfoot.stop();               
            getWorld().showText("You Lose!", getWorld().getWidth() / 2, getWorld().getHeight() / 2); 
        }

        if (isTouching(Worm.class)) 
        {
            removeTouching(Worm.class);     
            Greenfoot.playSound("slurp.wav");  

            if (getWorld().getObjects(Worm.class).isEmpty()) 
            {
                Greenfoot.playSound("fanfare.wav");  
                Greenfoot.stop();                    
                getWorld().showText("You Won!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);  
            }
        }
    }
}