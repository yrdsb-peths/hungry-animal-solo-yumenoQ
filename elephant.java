import greenfoot.*;  

public class elephant extends Actor {
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];

    String facing = "right"; 
    SimpleTimer animationTimer = new SimpleTimer();
    
    public elephant() {
        for(int i = 0; i < idleRight.length; i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(75, 75);
        }
        for(int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally(); 
            idleLeft[i].scale(75, 75);
        }
        
        animationTimer.mark();
        setImage(idleRight[0]);
    }

    int imageIndex = 0;
    
    public void animateElephant() {
        if(animationTimer.millisElapsed() < 500) {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right")) {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        } else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }

    public void act() {
        if(Greenfoot.isKeyDown("left")) {
            move(-10);
            facing = "left";
        } else if(Greenfoot.isKeyDown("right")) {
            move(10);
            facing = "right";
        }
        eat(); 
        animateElephant();
    }

    public void eat() {
        if(isTouching(Food.class)) {
            Food food = (Food) getOneIntersectingObject(Food.class);  // Use polymorphism to reference any food item
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore(food.getScoreValue());  // Increase score based on the type of food
            world.removeObject(food);  // Remove the eaten food
            world.createFood();  // Create a new food object
            elephantSound.play();
        }
    }
}
