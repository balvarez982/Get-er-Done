import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    private int state = 0;
    // idle = 0
    // move = 1
    
    final int speed = 2;  
    final int maxDistance = 100; 
    final int minPauseTime = 50;
    final int maxPauseTime = 150;
    final int followRange = 75;
    
    private int direction = 0;
    private int targetDistance = 0;
    private int pauseTimer = 0;
    
    private GreenfootImage[] images = new GreenfootImage[2];
    
    private int hoardState;
    
    public Zombie() {
        GreenfootImage image = getImage();
        image.scale(50,50);
        setImage(image);
        
        //images[0] = image;
        //images[1] = new GreenfootImage(images[0]);
        //images[1].mirrorHorizontally();
        
        setState(state);
    }
    
    private void movement() {
        if (direction == 0) { //right
            setRotation(0);
            setLocation(getX()+speed, getY());
            targetDistance -= speed;
        } else if (direction == 1) { //up
            setRotation(-90);
            setLocation(getX(), getY()-speed);
            targetDistance -= speed;
        } else if (direction == 2) { //left
            setRotation(-180);
            setLocation(getX()-speed, getY());
            targetDistance -= speed;
        } else if (direction == 3) { //down
            setRotation(90);
            setLocation(getX(), getY()+speed);
            targetDistance -= speed;
        }
    }
    
    private void wander() {
        if (state == 0) {
            if (pauseTimer > 0) {
                pauseTimer--;
            } else if (pauseTimer == 0) {
                setState(1);
            }
        } else if (state == 1) {
            if (targetDistance > 0) {
                movement();
            } else if (targetDistance <= 0) {
                setState(0);
            }
        }
    }
    
    private void setState(int newState) {
        state = newState;
        
        if (newState == 0) {
            pauseTimer = minPauseTime+Greenfoot.getRandomNumber(maxPauseTime-minPauseTime);
        } else if (newState == 1) {
            direction = Greenfoot.getRandomNumber(4);
            targetDistance = Greenfoot.getRandomNumber(maxDistance);
        }
    }
    
    private void hoard(int hoardState) {
        if(hoardState == 1) {
            List<Zombie> listZom = getObjectsInRange(followRange, Zombie.class);
            for(Zombie z : listZom) {
                turnTowards(z.getX(),z.getY());
                move(speed-1);
            }
        }
        else {
            wander();
        }
    }
    
    private void walkTowards() {
        List<Player> listPlay = getObjectsInRange(100, Player.class);
        if(listPlay.size() >= 1) {
            for(Player p : listPlay) {
                turnTowards(p.getX(), p.getY());
                move(speed);
            }
        }
        else {
            wander();
        }
    }
    
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        walkTowards();
    }
}
