import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Granade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grenade extends Actor
{
    private int duration = 20;
    /**
     * Act - do whatever the Granade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (duration >= 0) {
            move(duration);
            duration = duration - 1;
        }
    }
}
