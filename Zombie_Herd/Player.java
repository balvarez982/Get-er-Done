import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
<<<<<<< Updated upstream
    public void resize()
    {
=======
    public int Score = 0;
    public Player() {
>>>>>>> Stashed changes
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
        resize();
        movement();
<<<<<<< Updated upstream
=======
        //death();
        brainPickup();
        
        if(Score >= 3)
        {
            Greenfoot.setWorld(new WinWorld());
        }
>>>>>>> Stashed changes
    }
    
    public void movement()
    {
        
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D"))
        {
            setLocation(getX()+1, getY()); // right
        }
        if(Greenfoot.isKeyDown("left")|| Greenfoot.isKeyDown("A"))
        {
            setLocation(getX()-1, getY()); // left
        }
        if(Greenfoot.isKeyDown("up")|| Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(), getY()-1); // up
        }
        if(Greenfoot.isKeyDown("down")|| Greenfoot.isKeyDown("S"))
        {
            setLocation(getX(), getY()+1); // down
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
