import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public Player() {
        GreenfootImage image = getImage();
        image.scale(50,50);
        setImage(image);
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movement();
    }
    
    public void movement()
    {
        
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D"))
        {
            setLocation(getX()+2, getY());// right
        }
        if(Greenfoot.isKeyDown("left")|| Greenfoot.isKeyDown("A"))
        {
            setLocation(getX()-2, getY()); // left
        }
        if(Greenfoot.isKeyDown("up")|| Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(), getY()-2); // up
        }
        if(Greenfoot.isKeyDown("down")|| Greenfoot.isKeyDown("S"))
        {
            setLocation(getX(), getY()+2); // down
        }
    }
}
