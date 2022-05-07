import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    private GreenfootImage[] images = new GreenfootImage[2];
    public Player() {
        GreenfootImage image = getImage();
        image.scale(50,50);
        setImage(image);
        
        images[0] = image;
        
        images[1] = new GreenfootImage(images[0]);
        images[1].mirrorHorizontally();
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movement();
        //death();
    }
    
    public void movement()
    {
        
        if(Greenfoot.isKeyDown("D"))
        {
            setLocation(getX()+2, getY());// right
            setRotation(0);
            setImage(images[1]);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            setLocation(getX()-2, getY()); // left
            setRotation(0);
            setImage(images[0]);
        }
        if(Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(), getY()-2); // up
            setRotation(90);
            setImage(images[0]);
        }
        if(Greenfoot.isKeyDown("S"))
        {
            setLocation(getX(), getY()+2); // down
            setRotation(-90);
            setImage(images[0]);
        }
    }
    
    public void death()
    {
        if(getOneIntersectingObject(Zombie.class) != null)
        {
            getWorld().removeObject(this);
        }
    }
}
