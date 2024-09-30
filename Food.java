import greenfoot.*; 

public abstract class Food extends Actor {
    protected int speed;  // Shared speed property

    public abstract int getScoreValue();  // Abstract method to implement score value in subclasses

    public void act() {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);

        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight() - 1) {
            world.gameOver();
            world.removeObject(this);
        }
    }

    public void setSpeed(int spd) {
        speed = spd;
    }
}
