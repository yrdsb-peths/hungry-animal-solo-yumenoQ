import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{

    Label titleLabel = new Label("Hungry elephant", 60);
    public TitleScreen()
    {    

        super(600, 400, 1); 
        addObject(titleLabel, getWidth()/2, 200);
        prepare();
    }

    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("you can press space to start", 60);
        addObject(label,288,271);
        label.setLocation(300,300);

        Label label2 = new Label("Press \u2190 \u2192 to move!", 50);
        addObject(label2,296,254);
        elephant elephant = new elephant();
        addObject(elephant,523,49);
    }
}
