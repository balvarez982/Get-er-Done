import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{

    public void act()
    {
        move(6);
        if (atWorldEdge())
        {
          getWorld().removeObject(this);
        }
    }
    
    public boolean atWorldEdge()
    {
        if(getX() < 5 || getX() > getWorld().getWidth()-5)
        {
            return true;
        }
        if(getY() < 5 || getY() > getWorld().getHeight()-5)
        {
           return true;
        }
        if(getX() < 5 || getY() < 5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
