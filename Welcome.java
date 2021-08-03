import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Welcome class
 * 
 * @Brian Carrillo
 * @02/08/2021
 */
public class Welcome extends World
{
    public int probability=1;
    /**
     * Constructor for objects of class Welcome.
     * 
     */
    
    public Welcome(){
       super(900, 600, 1);
        prepare(); 
    }
    
    public Welcome(int probability)
    {    
        super(900, 600, 1);
        prepare();
        this.probability = probability;
    }

    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new MyWorld(this.probability));
        }
        
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Settings());
        }

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Start start = new Start();
        addObject(start,448,263);
        Configuration configuration = new Configuration();
        addObject(configuration,440,468);
    }
}
