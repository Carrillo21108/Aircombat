import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * MyWorld class
 * 
 * @Brian Carrillo
 * @02/08/2021
 */
public class MyWorld extends World
{
    Counter scoreCounter;
    Counter lifeCounter;
    Label gameLevel;
    GameOver gameOver;
    GreenfootSound myMusic = new GreenfootSound("background-sound.mp3");
    GreenfootSound myMusic2 = new GreenfootSound("fail.mp3");
    public int probability=1;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(int probability)
    {    
        super(900, 600, 1);
        this.probability = probability;
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
        if(Greenfoot.getRandomNumber(100)<probability-0.9){
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
        gameLevel = new Label("Dificultad: "+this.probability,30);
        addObject(gameLevel,350,31);
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
        myMusic.stop();
        myMusic2.play();
        Greenfoot.delay(400);
        myMusic2.stop();
        Greenfoot.setWorld(new Welcome(this.probability));
    }
}