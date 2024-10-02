import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Worm extends Actor
{
    public void act()
    {
        move(2);      
        turnAtEdge(); 
    }

    /**
     * Turn the Worm when it reaches the edge of the screen.
     */
    public void turnAtEdge()
    {
        if (isAtEdge()) {
            turn(Greenfoot.getRandomNumber(90) - 45);  
        }
    }
}