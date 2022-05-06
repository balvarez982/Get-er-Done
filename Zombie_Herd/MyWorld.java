import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        addObject(new Player(), 750, 550);
        SpawnZombies();
        SpawnBrains();
    }
    
    public void SpawnBrains()
    {
        addObject(new Brain(), 50, 50);
        addObject(new Brain(), 50, 550);
        addObject(new Brain(), 750, 50);
    }
    public void SpawnZombies()
    {
        //Bottom Left
        addObject(new Zombie(), 100, 500);
        addObject(new Zombie(), 125, 500);
        addObject(new Zombie(), 100, 525);
        
        //Top Left
        addObject(new Zombie(), 100, 50);
        addObject(new Zombie(), 150, 50);
        addObject(new Zombie(), 125, 75);
        
        //Top Right
        addObject(new Zombie(),750, 50);
        addObject(new Zombie(),725, 50);
        addObject(new Zombie(),725, 75);
        
        
        //Middle
        addObject(new Zombie(),750, 100);
        addObject(new Zombie(),750, 300);
        addObject(new Zombie(),550, 500);
    }
}
