import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

/**
 * CrabWorld class - This is the world where the Crab, Lobster, and Worms exist.
 */
public class CrabWorld extends World
{
    /**
     * Constructor for CrabWorld - Create the crab world (the beach).
     * The world has a size of 560x560 cells, where each cell is 1 pixel.
     */
    public CrabWorld() 
    {
        super(560, 560, 1);  
        prepareScene();      
    }
    
    /**
     * Prepare the world for the start of the program.
     * This will create the initial objects and add them to the world.
     */
    private void prepareScene()
    {
        addPlayer();  
        addFood();   
        addEnemy();  
    }
    
    /**
     * Add the Crab (player) to the center of the screen.
     */
    private void addPlayer()
    {
        Crab crab = new Crab(); 
        addObject(crab, 280, 280); 
    }
    
    /**
     * Add 8 Worms (food) at random locations in the world.
     * Worms are static objects that don't move.
     */
    private void addFood()
    {
        for (int i = 0; i < 8; i++) { // Add 8 worms
            Worm worm = new Worm();
            int x = Greenfoot.getRandomNumber(getWidth());  
            int y = Greenfoot.getRandomNumber(getHeight()); 
            addObject(worm, x, y);  
        }
    }
    
    /**
     * Add one Lobster (enemy) at a random location in the world.
     * The Lobster will be moving around.
     */
    private void addEnemy()
    {
        Lobster lobster = new Lobster(); 
        int x = Greenfoot.getRandomNumber(getWidth());  
        int y = Greenfoot.getRandomNumber(getHeight()); 
        addObject(lobster, x, y); 
    }
}

/**
 * Crab class - Defines the behavior of the Crab (player).
 */
class Crab extends Actor
{
    public void act()
    {
        checkKeyPress(); 
        turnAtEdge();   
        lookForWorm();  
        lookForLobster(); 
    }

    /**
     * Check for key presses to control the Crab's movement.
     */
    public void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("left")) {
            turn(-4); 
        }
        if (Greenfoot.isKeyDown("right")) {
            turn(4);   
        }
        move(5);  
    }

    /**
     * Turn the Crab when it reaches the edge of the world.
     */
    public void turnAtEdge()
    {
        if (isAtEdge()) {
            turn(90);  
        }
    }

    /**
     * Check if the Crab touches a Worm and remove it.
     * If all worms are eaten, the game is won.
     */
    public void lookForWorm()
    {
        if (isTouching(Worm.class)) {
            removeTouching(Worm.class);  
            Greenfoot.playSound("slurp.wav");  
            
        
            if (getWorld().getObjects(Worm.class).isEmpty()) {
                Greenfoot.playSound("fanfare.wav"); 
                Greenfoot.stop(); 
                getWorld().showText("You Won", getWorld().getWidth()/2, getWorld().getHeight()/2);  
            }
        }
    }

    /**
     * Check if the Crab touches a Lobster and end the game.
     */
    public void lookForLobster()
    {
        if (isTouching(Lobster.class)) {
            Greenfoot.playSound("au.wav"); 
            Greenfoot.stop(); 
            getWorld().showText("You Lost", getWorld().getWidth()/2, getWorld().getHeight()/2); 
        }
    }
}

/**
 * Lobster class - Defines the behavior of the Lobster (enemy).
 * The Lobster moves around the world and turns at the edges.
 */
class Lobster extends Actor
{
    public void act()
    {
        chaseCrab();   
        move(1);       
        turnAtEdge();  
    }

    /**
     * Turn the Lobster 180 degrees when it reaches the edge of the world.
     */
    public void turnAtEdge()
    {
        if (isAtEdge()) {
            turn(180); 
        }
    }

    /**
     * Make the Lobster chase the Crab, if the Crab exists.
     */
    public void chaseCrab()
    {
        
        if (!getWorld().getObjects(Crab.class).isEmpty()) {
            Crab crab = (Crab) getWorld().getObjects(Crab.class).get(0);  

            turnTowards(crab.getX(), crab.getY());
        }
    }
}

/**
 * Worm class - Worms are static and do not move.
 */
class Worm extends Actor
{
    
}