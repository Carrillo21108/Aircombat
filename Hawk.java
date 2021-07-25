import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hawk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hawk extends Actor
{
    /**
     * Act - do whatever the Hawk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveOn(7);
        end();
    }
    
    public void moveOn(int speed){
        setLocation(getX()+speed, getY());
    }
    
    public void end(){
        if(getX()>=880){
            getWorld().removeObject(this);
        }
    }
    
}
