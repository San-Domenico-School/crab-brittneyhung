import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 * @author BGustin
 * @version 6/1/2022 5:48am
 */
public class Crab extends Actor
{

    /**
     * The act method is called by Greenfoot each frame about 68 times per second 
     * whenever the 'Run' button gets pressed in the Action window.
     */
    public void act()
    {
        move(3);  
        checkKeys();  
    }
    
    /**
     * Check for arrow key presses and move the crab accordingly.
     */
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left")) {
            setRotation(180); 
        }
        if (Greenfoot.isKeyDown("right")) {
            setRotation(0); 
        }
        if (Greenfoot.isKeyDown("up")) {
            setRotation(270); 
        }
        if (Greenfoot.isKeyDown("down")) {
            setRotation(90); 
        }
    }
}