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
        addObject(new Brain(), 20, 20);
        addObject(new Brain(), 20, 580);
        addObject(new Brain(), 780, 20);
    }
    public void SpawnZombies()
    {
        //Bottom Left
        addObject(new Zombie(), 50, 550);
        addObject(new Zombie(), 30, 475);
        addObject(new Zombie(), 80, 525);
        
        //Top Left
        addObject(new Zombie(), 50, 30);
        addObject(new Zombie(), 20, 100);
        addObject(new Zombie(), 90, 75);
        
        //Top Right
        addObject(new Zombie(), 775, 50);
        addObject(new Zombie(), 725, 20);
        addObject(new Zombie(), 725, 75);
        
        //Middle
        addObject(new Zombie(), 400, 350);
        addObject(new Zombie(), 400, 250);
        addObject(new Zombie(), 350, 300);
    }
}
