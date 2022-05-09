import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Grenade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grenade extends Actor
{
    /**
     * Act - do whatever the Grenade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int ySpeed, wind; // these are current speeds
    double xSpeed;
    
    public Grenade(int angle, int power) {
        GreenfootImage image = getImage();
        image.scale(40,40);
        setImage(image);
        
        xSpeed = (double) power * Math.cos(angle * Math.PI / 180);
        ySpeed = (int) (power * Math.sin(angle * Math.PI / 180));
        
        getImage().scale(50, 50);
    }
    
    private void rightToss() {
        int newX = getX() - (int) Math.round(xSpeed); // calculates the new x-coordinate value
        int newY = getY() - ySpeed; // calculates the new y-coordinate value 
        setLocation(newX, newY);
        xSpeed += ((double) - xSpeed) / 100; // change due to wind
        ySpeed--; // change due to gravity
    }
    
    private void leftToss() {
        int newX = getX() + (int) Math.round(xSpeed); // calculates the new x-coordinate value
        int newY = getY() - ySpeed; // calculates the new y-coordinate value 
        setLocation(newX, newY);
        xSpeed += ((double) - xSpeed) / 100; // change due to wind
        ySpeed--; // change due to gravity
    }
    
    public void toss() {
        Actor player = (Actor)getWorld().getObjects(Player.class).get(0);
        if(player.getRotation() == 0 ||
           player.getRotation() == 45 ||
           player.getRotation() == 270 ||
           player.getRotation() == 315) {
            leftToss();            
        }
        else if(player.getRotation() == 90 ||
                player.getRotation() == 135 ||
                player.getRotation() == 180 ||
                player.getRotation() == 225) {
            rightToss();
        }
    }
    
    private void grenadeHit() {
        if(isAtEdge())
            getWorld().removeObject(this);
        else if(getOneIntersectingObject(Zombie.class) != null) {
            List<Zombie> listZom = getObjectsInRange(150, Zombie.class);
            for(Zombie z : listZom) {
                getWorld().removeObject(z);
            }
            getWorld().removeObject(this);
        }
    }
    
    public void act()
    {
        toss();
        grenadeHit();
    }
}
