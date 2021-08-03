import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bird class
 * 
 * @Brian Carrillo 
 * @02/08/2021
 */
public class Bird extends Actor
{   
    
    private int direction;
    private int seedsEaten;
    private int life=3;
    
    public Bird(){
    }
    
    public void act()
    {
        moveOn();
        if(foundSeed()) {
            eatSeed();
        }
        
        if(foundHawk()){
            hitHawk();
        }
    }
    
    public void moveOn(){
        
        setLocation(getX(),getY()+2);
       
       if(Greenfoot.isKeyDown("left")){
            move(-5);
        }
        
        if(Greenfoot.isKeyDown("right")){
            move(5);
        }
        
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-5);
        }
        
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+5);
        }
    }
    
    public boolean foundSeed(){
        Actor seed = getOneObjectAtOffset(0,0,Seed.class);
        
        if(seed != null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean foundHawk(){
        Actor hawk = getOneObjectAtOffset(0,0,Hawk.class);
        
        if(hawk != null){
            return true;
        }else{
            return false;
        }
    }
    
    public void eatSeed(){
        Actor seed = getOneObjectAtOffset(0,0,Seed.class);
        if(seed != null){
            World world;
            world = getWorld();
            world.removeObject(seed);
            MyWorld myWorld = (MyWorld)world;
            Counter scoreCounter = myWorld.getScoreCounter();
            scoreCounter.add(10);
            Greenfoot.playSound("eating.wav");
        }
    }
    
    public void hitHawk(){
        Actor hawk = getOneObjectAtOffset(0,0,Hawk.class);
        if(hawk != null){
            Greenfoot.playSound("hit.mp3");
            World world;
            world = getWorld();
            world.removeObject(hawk);
            MyWorld myWorld = (MyWorld)world;
            Counter lifeCounter = myWorld.getLifeCounter();
            lifeCounter.substract(1);
        }
    }
}
