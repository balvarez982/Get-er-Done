import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    private int test = 0;
    private int wanderCheck;
    private int timer2 = 150;
    private int wanderTime = 150;
    
    
    private GreenfootImage[] images = new GreenfootImage[2];
    public Zombie() {
        GreenfootImage image = getImage();
        image.scale(50,50);
        setImage(image);
        
        images[0] = image;
        images[1] = new GreenfootImage(images[0]);
        images[1].mirrorHorizontally();
    }
    
    private int timer = 1;
    private int speed = 1;  
    
    private void movement(int check) {
        timer--;
        if (timer > 0) {
            if(speed < 0) {
               move(speed);
               setImage(images[1]);
            }
            else {
               move(speed);
               setImage(images[0]);
            }
        }
        if (timer == 0) {
            speed = -2-Greenfoot.getRandomNumber(100); // max -2; min -31
        }
        if (timer < 0 && timer == speed) {
            speed = 1-2*Greenfoot.getRandomNumber(2); // 1 or -1
            timer = 2+Greenfoot.getRandomNumber(100); // min 2; max 31
        }
    }
    
    private void wander() {
        //wanderTimer = (wanderTimer+1)%180;
        //if(wanderTimer == 0) {
        //}
        wanderCheck = Greenfoot.getRandomNumber(1);
        movement(wanderCheck);
        }
        
        
        /*
        if(wanderTimer < 0) {
            wanderTimer++;
        }
        else if(wanderTimer >= 300) {
            setRotation(Greenfoot.getRandomNumber(360));
            move(5);
            wanderTimer++;
        }
        */
       
       
        
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
