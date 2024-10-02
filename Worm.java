import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Worm extends Actor
{
    public void act()
    {
        move(2);      // Move the worm forward at a speed of 2
        turnAtEdge(); // Turn when reaching the edge of the screen
    }

    /**
     * Turn the Worm when it reaches the edge of the screen.
     */
    public void turnAtEdge()
    {
        if (isAtEdge()) {
            turn(Greenfoot.getRandomNumber(90) - 45);  // Turn in a random direction between -45 to 45 degrees
        }
    }
}