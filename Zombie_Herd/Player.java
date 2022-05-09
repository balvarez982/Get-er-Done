import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed = 2;
    private GreenfootImage[] images = new GreenfootImage[2];
    private int Score = 0;
    private boolean spaceKeyDown;  
    private boolean gKeyDown;
    private int ableToThrow = 250;

    public Player() {
        GreenfootImage image = getImage();
        image.scale(50,50);
        setImage(image);
        
        //images[0] = image;
        
        //images[1] = new GreenfootImage(images[0]);
        //images[1].mirrorHorizontally();
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movement2();
        brainPickup();
        //death();
        if(Score >= 3)
        {
            Greenfoot.setWorld(new WinWorld());
        }
        
        if (spaceKeyDown != Greenfoot.isKeyDown("space")) // detect change in state of space key
        {
            spaceKeyDown = ! spaceKeyDown; // tracking state of space key
            if (spaceKeyDown) shoot();
        }
        
        if (gKeyDown != Greenfoot.isKeyDown("g")) // detect change in state of space key
        {
            gKeyDown = ! gKeyDown; // tracking state of space key
            if (gKeyDown) throwGrenade();
        }
        ableToThrow = ableToThrow + 1;
        if (ableToThrow >= 250) {
        List<Grenade> listGrenade = getWorld().getObjects(Grenade.class);
            if(listGrenade.size() >= 1) {
                for(Grenade g : listGrenade) {
                    getWorld().removeObject(g);
                }
            }
        }
    }
    
    public void movement2() {
        int dx=0, dy=0;
        if (Greenfoot.isKeyDown("W")) {
            dy--;
            setRotation(-90);
        } //up
        if (Greenfoot.isKeyDown("S")) {
            dy++;
            setRotation(90);
        } //down
        if (Greenfoot.isKeyDown("D")) {
            dx++;
            setRotation(0);
        } //right
        if (Greenfoot.isKeyDown("A")) {
            dx--;
            setRotation(-180);
        } //left
        if(Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("A")) setRotation(-135); // up left
        if(Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("D")) setRotation(-45); // up right
        if(Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("A")) setRotation(135); // down left
        if(Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("D")) setRotation(45); // down right
        setLocation(getX()+dx*speed, getY()+dy*speed);
    }
    
    public void checkDiagonal() {
        if(Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("A")) {
            setLocation(getX()-speed/2, getY()-speed/2);// up left
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("D")) {
            setLocation(getX()+speed/2, getY()-speed/2); // up right
            setRotation(-180);
        }
        if(Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("A")) {
            setLocation(getX()-speed/2, getY()+speed/2); // down left
            setRotation(-90);
        }
        if(Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("D")) {
            setLocation(getX()+speed/2, getY()+speed/2); // down right
            setRotation(90);
        }
    }
    
    public void movement()
    {
        //checkDiagonal();
        if(Greenfoot.isKeyDown("D"))
        {
            setLocation(getX()+speed, getY());// right
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            setLocation(getX()-speed, getY()); // left
            setRotation(-180);
        }
        if(Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(), getY()-speed); // up
            setRotation(-90);
        }
        if(Greenfoot.isKeyDown("S"))
        {
            setLocation(getX(), getY()+speed); // down
            setRotation(90);
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
    
    public void shoot()
    {
        Bullet bullet = new Bullet();
        GreenfootImage image = bullet.getImage();
        image.scale(10, 10);
        bullet.setImage(image);
        getWorld().addObject(bullet, getX(), getY());
        bullet.setRotation(getRotation()); 
    }
    
    public void throwGrenade()
    {
        if (ableToThrow >= 250) {
            Grenade grenade = new Grenade();
            GreenfootImage image = grenade.getImage();
            image.scale(40, 40);
            grenade.setImage(image);
            getWorld().addObject(grenade, getX(), getY());
            grenade.setRotation(getRotation());
            ableToThrow = 0;
        }
    }
}
