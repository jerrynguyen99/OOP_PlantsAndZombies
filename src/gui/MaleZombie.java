package gui;



import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class MaleZombie extends BasicGameState {

    private Animation Malezombie;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Image[] malezombie = {
                new Image("res/Zombie/MaleZombie/walk/Walk (1).png"),
                new Image("res/Zombie/MaleZombie/walk/Walk (2).png"),
                new Image("res/Zombie/MaleZombie/walk/Walk (3).png"),
                new Image("res/Zombie/MaleZombie/walk/Walk (4).png"),
                new Image("res/Zombie/MaleZombie/walk/Walk (5).png"),
                new Image("res/Zombie/MaleZombie/walk/Walk (6).png"),
                new Image("res/Zombie/MaleZombie/walk/Walk (7).png"),
                new Image("res/Zombie/MaleZombie/walk/Walk (8).png"),
                new Image("res/Zombie/MaleZombie/walk/Walk (9).png"),
                new Image("res/Zombie/MaleZombie/walk/Walk (99).png"),
        };
        Malezombie = new Animation(malezombie, 100);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Malezombie.draw();


    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    }
}
