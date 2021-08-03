import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Settings class
 * 
 * @Brian Carrillo 
 * @02/08/2021
 */
public class Settings extends World
{
    /**
     * Constructor for objects of class Settings.
     * 
     */
    public Settings()
    {    
        super(900, 600, 1);
        setBackground("clouds.gif");
        prepare();
    }

    public void act(){

        if(Greenfoot.isKeyDown("1")){
            Greenfoot.setWorld(new Welcome(1));
        }

        if(Greenfoot.isKeyDown("2")){
            Greenfoot.setWorld(new Welcome(2));
        }

        if(Greenfoot.isKeyDown("3")){
            Greenfoot.setWorld(new Welcome(3));
        }

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Level1 level1 = new Level1();
        addObject(level1,460,239);
        Level2 level2 = new Level2();
        addObject(level2,460,299);
        Level3 level3 = new Level3();
        addObject(level3,460,355);
    }
}
