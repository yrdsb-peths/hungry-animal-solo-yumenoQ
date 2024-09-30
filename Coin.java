public class Coin extends Food {

    public Coin() {
        // Automatically set image based on class name
        speed = 1;  // Default speed for coins
    }

    @Override
    public int getScoreValue() {
        return 5;  // Coin increases score by 5
    }
}
