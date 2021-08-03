import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Over class
 * 
 * @Brian Carrillo 
 * @02/08/2021
 */
public class GameOver extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void message(){
        setImage(new GreenfootImage("Game Over",48,Color.BLACK,transparent));
    }
}
