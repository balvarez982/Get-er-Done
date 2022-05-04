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
        
        addObject(new Player(), 400, 300);
        SpawnZombies();
    }
    
    public void SpawnZombies()
    {
        //Bottom Row
        addObject(new Zombie(), 100, 500);
        addObject(new Zombie(), 300, 550);
        addObject(new Zombie(), 500, 550);
        addObject(new Zombie(), 700, 550);
        
        //Top Row
        addObject(new Zombie(), 100, 50);
        addObject(new Zombie(), 300, 50);
        addObject(new Zombie(), 500, 50);
        addObject(new Zombie(), 700, 50);
        
        //Left Collum
        addObject(new Zombie(),50, 100);
        addObject(new Zombie(),50, 300);
        addObject(new Zombie(),50, 500);
        
        //Right Collum
        addObject(new Zombie(),750, 100);
        addObject(new Zombie(),750, 300);
        addObject(new Zombie(),750, 500);
    }
}
