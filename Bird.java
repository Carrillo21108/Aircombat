import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird extends Actor
{   
    
    /*private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;*/
    
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
        }/*else if(canMove()) {
            move();
        }else {
            turnLeft();
        }*/
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
            World world;
            world = getWorld();
            world.removeObject(hawk);
            MyWorld myWorld = (MyWorld)world;
            Counter lifeCounter = myWorld.getLifeCounter();
            lifeCounter.substract(1);
        }
    }
    
    /*public boolean foundHawk(){
        Actor hawk = getOneObjectAtOffset(0,0,Hawk.class);
        
        if(hawk != null){
            return true;
        }else{
            return false;
        }
    }
    
    public void decreaseLife(){
       Actor hawk = getOneObjectAtOffset(0,0,Hawk.class);
        
        if(hawk != null){
            life -= 1;
            if(life == 0){
                //
            }
        } 
    }
    
    public boolean canMove(){
        World myWorld = getWorld();
        int x =  getX();
        int y = getY();
        
        switch(direction){
            case SOUTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case NORTH:
                y--;
                break;
            case WEST:
                x--;
                break;
        }
        
        if(x >= myWorld.getWidth() || y >= myWorld.getHeight()){
            return false;
        }else if(x < 0 || y < 0){
            return false;
        }
        
        return true;
    }
    
    public void move(){
        if(!canMove()){
            return;
        }
        
        switch(direction){
            case SOUTH:
                setLocation(getX(),getY()+1);
                break;
            case EAST:
                setLocation(getX()+1,getY());
                break;
            case NORTH:
                setLocation(getX(),getY()-1);
                break;
            case WEST:
                setLocation(getX()-1,getY());
                break;
        }
    }
    
    public void turnLeft(){
        switch(direction){
            case SOUTH:
                setDirection(EAST);
        }
    }*/
}
