import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int Score = 0;
    
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
        //death();
        brainPickup();
        
        if(Score >= 3)
        {
            Greenfoot.setWorld(new WinWorld());
        }
    }
    
    public void movement()
    {
        
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D"))
        {
            setLocation(getX()+2, getY()); // right
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
    
    public void death()
    {
        if(getOneIntersectingObject(Zombie.class) != null)
        {
            getWorld().removeObject(this);
            Greenfoot.setWorld(new LoseWorld());
        }
    }
    public void brainPickup()
    {
        if(getOneIntersectingObject(Brain.class) != null)
        {
            getWorld().removeObject(getOneIntersectingObject(Brain.class));
            Score += 1;
        }
    }
}
