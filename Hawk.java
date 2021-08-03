import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hawk class
 * 
 * @Brian Carrillo
 * @02/08/2021
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
