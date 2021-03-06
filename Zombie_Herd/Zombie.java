import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    private int wanderTimer;
    
    public Zombie() {
        GreenfootImage image = getImage();
        image.scale(50,50);
        setImage(image);
        
    }
    
    private void wander() {
        wanderTimer = (wanderTimer+1)%180;
        if(wanderTimer == 0) {
            move(10);
        }
    }
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        wander();
    }
}
