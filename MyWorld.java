import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Counter scoreCounter;
    Counter lifeCounter;
    GameOver gameOver;
    GreenfootSound myMusic = new GreenfootSound("background-sound.mp3");
    
    //GifImage background = new GifImage("clouds.gif");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        prepare();
    }

    public void act(){
        //setBackground(background.getCurrentImage());
        myMusic.play();
        validLifeCounter();
        generateHawks();
        generateSeeds();
        
    }
    
    public void validLifeCounter(){
        if(lifeCounter.getValue()==0){
            this.finishGame();
        }
    }
    
    public void generateHawks(){
        if(Greenfoot.getRandomNumber(100)<2){
            boolean validPosition = false;
            do{
                int random = Greenfoot.getRandomNumber(600);
                
                if(random>10 || random<685){
                    validPosition = true;
                    Hawk newHawk = new Hawk();
                    addObject(newHawk,0,random);
                }
            }while(!validPosition);
        }
    }
    
    public void generateSeeds(){
        List<Seed> seeds = new ArrayList<Seed>();
        seeds = getObjects(Seed.class);
        
        if(seeds.size()<2){
            for(int i=0; i<4; i++){
            Seed seed = new Seed();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(seed,x,y);
            }
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        scoreCounter = new Counter("Puntos: ");
        addObject(scoreCounter,73,31);
        Bird bird = new Bird();
        addObject(bird,798,316);
        lifeCounter = new Counter("Vidas: ");
        lifeCounter.add(3);
        addObject(lifeCounter,200,31);
    }
    
    public Counter getScoreCounter(){
        return scoreCounter;
    }
    
    public Counter getLifeCounter(){
        return lifeCounter;
    }
    
    public void finishGame(){
        gameOver = new GameOver();
        addObject(gameOver,getWidth()/2,getHeight()/2);
        gameOver.message();
        Greenfoot.stop();
    }
}