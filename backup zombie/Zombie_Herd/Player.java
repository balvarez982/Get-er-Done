import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int speed = 3;
    private int score = 0;
    private int timer = 0;
    private int ammo = 0;
    private int health = 7;
    private int inTimer = 0;
    private int grenade = 1;

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
        movementImproved();
        brainPickup();
        ammoPickup();
        checkFire();
        checkGrenade();
        checkWin();
        checkLose();
    }
    
    public void checkGrenade() {
        if(grenade == 1 && Greenfoot.isKeyDown("F")) {
            Grenade gnade = new Grenade(40,20);
            getWorld().addObject(gnade, getX(), getY());
            grenade--;
        }
    }
    
    public void checkFire() {
        if(ammo > 0) {
            if(timer > 0) 
                timer--;
            if(timer == 0 && Greenfoot.isKeyDown("space")) {
                Bullet bullet = new Bullet();
                getWorld().addObject(bullet, getX(), getY());
                bullet.setRotation(this.getRotation());
                ammo--;
                timer = 30;
            }
        }
    }
    
    public void movementImproved() {
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
        if(Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("A")) 
            setRotation(-135); // up left
        if(Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("D")) 
            setRotation(-45); // up right
        if(Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("A")) 
            setRotation(135); // down left
        if(Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("D")) 
            setRotation(45); // down right
        setLocation(getX()+dx*speed, getY()+dy*speed);
    }
    
    public void checkLose()
    {
        if(getOneIntersectingObject(Zombie.class) != null)
        {
            if(inTimer > 0)
                inTimer--;
            else if(inTimer == 0) {
                health--;
                if(health == 0) {
                    Greenfoot.setWorld(new Losing());
                }
                inTimer = 30;
            }
        }
    }
    
    public void brainPickup()
    {
        if(getOneIntersectingObject(Brain.class) != null)
        {
            getWorld().removeObject(getOneIntersectingObject(Brain.class));
            score += 1;
        }
    }
    
    public void ammoPickup() {
        if(getOneIntersectingObject(Ammo.class) != null)
        {
            getWorld().removeObject(getOneIntersectingObject(Ammo.class));
            ammo = 3;
        }
    }
    
    public void checkWin() {
        if(score == 3 && getOneIntersectingObject(Exit.class) != null) {
            Greenfoot.setWorld(new Winning());
        }
    }
}
