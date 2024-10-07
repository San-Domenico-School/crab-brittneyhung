import greenfoot.*;  
/**
 * @author BrittneyHung
 * @version 10/7/2024 12:15pm
 */
public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    
    public CrabWorld() 
    {
        super(560, 560, 1);
        prepareScene();
    }
    private void prepareScene()
    {
        Crab crab = new Crab();
        addObject(crab, getWidth() / 2, getHeight() / 2);
        
        Lobster lobster = new Lobster();
        addObject(lobster, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));

        for (int i = 0; i < 8; i++) {
            Worm worm = new Worm();
            addObject(worm, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }
}