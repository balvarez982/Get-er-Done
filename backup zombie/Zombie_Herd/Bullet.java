import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    final int bulletSpeed = 5;
    
    public Bullet() {
        GreenfootImage image = getImage();
        image.scale(10,10);
        setImage(image);
    }
    
    public void shoot() {
        move(bulletSpeed);
    }
    
    private void bulletHit() {
        if(isAtEdge())
            getWorld().removeObject(this);
        else if(getOneIntersectingObject(Zombie.class) != null) {
            getWorld().removeObject(getOneIntersectingObject(Zombie.class));
            getWorld().removeObject(this);
        }
    }
    
    public void act()
    {
        // Add your action code here.
        shoot();
        bulletHit();
    }
}
