package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {

	private Image background;
	private Image button;
	public Menu(int state) {
			
	}

	public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
		background = new Image("res/Mode.png");
		button = new Image("res/StarAdventurebutton.png");
	}
	
	public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
		showBackGround();
		adventureButton(gameContainer, stateBasedGame, graphics);
	}

	public void adventureButton(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws  SlickException {

		float rate = 1.99f;
		float width = button.getWidth() * PZGUI.getResolutionRateWidth() * rate;
		float height = button.getHeight() * PZGUI.getResolutionRateHeight() * rate;
		float posX = PZGUI.getWidth() * (float)(0.7138)  - width/2;
		float posY = PZGUI.getHeight() * (float)(0.205) - height/2;
		float edgeX = posX + width;
		float edgeY = posY + height;
		button.draw(posX, posY, width, height);
		if (	Mouse.getX() >= posX &&
				Mouse.getX() <= edgeX &&
				PZGUI.getHeight() - Mouse.getY() >= posY	&&
				PZGUI.getHeight() - Mouse.getY() <= edgeY) {
			button.draw(posX, posY, width, height, new Color(100, 100, 100, 60));
			if (Mouse.isButtonDown(0)) {
				stateBasedGame.enterState(2);
//				sSound.stop();
			}
		}
	}

	public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
	}

	public void showBackGround() throws SlickException {
		background.draw(0, 0, PZGUI.getWidth(), PZGUI.getHeight());
	}
	public int getID() {
		return 1;
	}
}
