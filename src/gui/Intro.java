package gui;



import com.ShowSound;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static gui.ShowGUI.isAA;

/**
 * @author Nguyen Truong Dat
 */
public class Intro extends BasicGameState {

    private Image background;
    public Image logo;
    public Image playButton;

    /**
     * Create In App Game
     * @param state	State index
     */
    public Intro(int state) {

        ShowSound.play("res/sound/Intro.ogx",false,1f,1f);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        gameContainer.getGraphics().setAntiAlias(isAA());

        background = new Image("res/image/other/Wallpaper.jpg");
        logo =new Image("res/image/other/Logo.png");

        System.out.println("Intro Complete");
        System.out.println("Width: " + ShowGUI.width);
        System.out.println("Height: " + ShowGUI.height);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
