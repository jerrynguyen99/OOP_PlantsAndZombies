package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.SSound;

/**
 * 
 * @author Nguyen Truong Dat & Tran To Que Phuong
 *
 */
public class SplashScreen extends BasicGameState {
	
	// Declare variable
	private Image background;
	public Image logo;
	public Image playButton;
	private float rate;
	private float posX;
	private float posY;
	private float edgeX;
	private float edgeY;
	private float width;
	private float height;
	private SSound sSound = new SSound("res/Sound/sound/Intro.ogg");
	/**
	 * Create splash screen
	 * @param state	State index
	 */
	public SplashScreen(int state) {
		sSound.play(false, 1f, 1f);
	}
	
	// Initialization
	/**
	 * Initialize SplashScreen state
	 */
	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

		background = new Image("res/other/Wallpaper.jpg");
		playButton = new Image("res/Button/PlayDemo.png");
		logo = new Image("res/other/Logo.png");
		System.out.println("SplashScreen Init complete");
		System.out.println("Wid: " + PZGUI.getWidth());
		System.out.println("Hei: " + PZGUI.getHeight());
	}

	public void setLogo(GameContainer gameContainer,
						StateBasedGame stateBasedGame,
						Graphics graphics) throws SlickException {
		rate = 0.4f;
		drawThisOne(logo, 0.4);
	}

	private void drawThisOne(Image logo, double v) {
		width = logo.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		height = logo.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		posX = PZGUI.getWidth()  /2 - width/2;
		posY = PZGUI.getHeight() * (float)(v) - height/2;
		edgeX = posX + width;
		edgeY = posY + height;
		logo.draw(posX, posY, width, height);
	}

	// Start Button
	public void startButton(GameContainer gameContainer,
							StateBasedGame stateBasedGame,
							Graphics graphics) throws SlickException {
		rate = 0.9f;
		drawThisOne(playButton, 0.7);
		if (	Mouse.getX() >= posX && 
				Mouse.getX() <= edgeX && 
				PZGUI.getHeight() - Mouse.getY() >= posY	&& 
				PZGUI.getHeight() - Mouse.getY() <= edgeY) {
			playButton.draw(posX, posY, width, height, new Color(100, 100, 100, 60));
			
			if (Mouse.isButtonDown(0)) {
				stateBasedGame.enterState(1);
				sSound.stop();
			}
		}
	}

	// BackGround
	public void showBackGround() throws SlickException {
		background.draw(0, 0, PZGUI.getWidth(), PZGUI.getHeight());
	}

	
	// Render
	/**
	 * SplashScreen render
	 */
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		showBackGround();
		startButton(gameContainer, stateBasedGame, graphics);
		setLogo(gameContainer,stateBasedGame,graphics);
		//DebugTool.showMousePosition(g);
	}	
	
	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) {
	}

	public int getID() {
		return 0;
	}
}
