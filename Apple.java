public class Apple extends Food {

    public Apple() {
        // Automatically set image based on class name
        speed = 1;  // Default speed for apples
    }

    @Override
    public int getScoreValue() {
        return 1;  // Apple increases score by 1
    }
}
