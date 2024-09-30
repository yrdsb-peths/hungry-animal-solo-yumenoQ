import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int level = 1;

    public MyWorld() {    
        super(600, 400, 1);
        elephant elephant = new elephant();
        addObject(elephant, 300, 200);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        createFood();  // Change to createFood
    }

    public void gameOver() {
       Label gameOverLabel = new Label("Game Over", 100);
       addObject(gameOverLabel, 300, 200);
    }

    public void increaseScore(int amount) {
        score += amount;  // Add the score based on food type
        scoreLabel.setValue(score);  // Update score display
        if (score % 5 == 0) {
            level += 1;  // Increase level every 5 points
        }
    }

    public void createFood() {
        Food food;
        if (Greenfoot.getRandomNumber(2) == 0) {
            food = new Apple();  // 50% chance to spawn an Apple
        } else {
            food = new Coin();  // 50% chance to spawn a Coin
        }

        food.setSpeed(level);  // Set the speed based on the current level
        int x = Greenfoot.getRandomNumber(600);  // Random x-coordinate
        addObject(food, x, 0);  // Add the food object to the world
    }
}
