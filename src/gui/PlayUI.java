package gui;

import com.Controller;
import com.Position;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import pz.Zombie;
import pz.plant.Chili;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author Nguyen Truong Dat & Tran To Que Phuong
 */
public class PlayUI {

    private static Image pauseButton;
    private static Image playButton;
    private static Image exitGameButton;
    private static Image Chili;
    private static Image speedUpButton;

    private static Image shovel;
    public static ArrayList<Chili> ChiliList;

    private static final Text sunView = new Text(35.0f);
    private static final Text gamePausedText = new Text(70.0f);

    private static boolean isSpeedUpClicked = false;
    private static boolean isShovelClicked = false;

    private static final float plantZonePosX = 432 * PZGUI.getResolutionRateWidth();
    private static final float plantZonePosY = 142 * PZGUI.getResolutionRateHeight();
    private static final float cellW = 110 * PZGUI.getResolutionRateWidth();
    private static final float cellH = 130 * PZGUI.getResolutionRateHeight();

    private static final float seedZonePosX = 10 * PZGUI.getResolutionRateWidth();
    private static final float seedZonePosY = 120 * PZGUI.getResolutionRateHeight();
    private static final float seedZoneW = 140 * PZGUI.getResolutionRateWidth();
    private static final float seedZoneH = 90 * PZGUI.getResolutionRateHeight();

    private static final float pauseButtonPosX = 1400 * PZGUI.getResolutionRateWidth();
    private static final float pauseButtonPosY = 10 * PZGUI.getResolutionRateHeight();
    private static final float pauseButtonWidth = 60 * PZGUI.getResolutionRateWidth();
    private static final float pauseButtonHeight = 60 * PZGUI.getResolutionRateHeight();

    private static final float exitGameButtonPosX = 1460 * PZGUI.getResolutionRateWidth();
    private static final float exitGameButtonPosY = 10 * PZGUI.getResolutionRateHeight();
    private static final float exitGameButtonWidth = 120 * PZGUI.getResolutionRateWidth();
    private static final float exitGameButtonHeight = 60 * PZGUI.getResolutionRateHeight();

    private static final float chiliPosX = 390 * PZGUI.getResolutionRateWidth();
    private static final float chiliPosY = 150 * PZGUI.getResolutionRateHeight();
    private static final float chiliWidth = 40 * PZGUI.getResolutionRateWidth();
    private static final float chiliHeight = 100 * PZGUI.getResolutionRateHeight();
    private static final float speedUpButtonPosX   = 1460 * PZGUI.getResolutionRateWidth();
    private static final float speedUpButtonPosY   = 10   * PZGUI.getResolutionRateHeight();
    private static final float speedUpButtonWidth  = 60   * PZGUI.getResolutionRateWidth();
    private static final float speedUpButtonHeight = 60   * PZGUI.getResolutionRateHeight();

    private static final float shovelButtonPosX = 1500 * PZGUI.getResolutionRateWidth();
    private static final float shovelButtonPosY = 800 * PZGUI.getResolutionRateHeight();
    private static final float shovelButtonWidth = 87 * PZGUI.getResolutionRateWidth();
    private static final float shovelButtonHeight = 83.75f * PZGUI.getResolutionRateHeight();

    public static boolean isShovelClicked() {
        return isShovelClicked;
    }

    public static float getPlantZonePosX() {
        return plantZonePosX;
    }

    public static float getPlantZonePosY() {
        return plantZonePosY;
    }

    public static float getCellW() {
        return cellW;
    }

    public static float getCellH() {
        return cellH;
    }

    public static float getSeedZonePosX() {
        return seedZonePosX;
    }

    public static float getSeedZonePosY() {
        return seedZonePosY;
    }

    public static float getSeedZoneW() {
        return seedZoneW;
    }

    public static float getSeedZoneH() {
        return seedZoneH;
    }

    public static void setShovelClicked(boolean isShovelClicked) {
        PlayUI.isShovelClicked = isShovelClicked;
    }

    public static Image ChiliBurn;

    /**
     * Initialize images for PlayUI
     *
     * @throws SlickException
     */
    public static void init() throws SlickException {
        pauseButton = new Image("res/UI/pause.png");
        playButton = new Image("res/UI/play.png");
        speedUpButton = new Image("res/UI/speedUp.png");
        exitGameButton = new Image("res/UI/GOver_ExitGame_Button.png");
        shovel = new Image("res/UI/Shovel.png");
        Chili = new Image("res/Plants/chili/Idle/fire0.png");
        ChiliBurn = new Image("res/Plants/chili/Bullet/fire1.png");
    }


    /**
     * Draw SunCollected grid
     *
     * @param gameContainer  GameContainer
     * @param stateBasedGame StateBasedGame
     * @param graphics       Graphics
     * @throws SlickException
     */
    public static void showSunCollectedGrid(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        float posX = 10 * PZGUI.getResolutionRateWidth();
        float posY = 20 * PZGUI.getResolutionRateHeight();
        float W = 200 * PZGUI.getResolutionRateWidth();
        float H = 45 * PZGUI.getResolutionRateHeight();
        graphics.drawRect(posX, posY, W, H);
    }

    /**
     * Draw sun collected
     *
     * @param gameContainer  GameContainer
     * @param stateBasedGame StateBasedGame
     * @param graphics   Graphics
     * @throws SlickException
     */
    public static void showSunCollected(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        float iconPosX = 10 * PZGUI.getResolutionRateWidth();
        float iconPosY = 5 * PZGUI.getResolutionRateHeight();
        float iconW = 80 * PZGUI.getResolutionRateWidth();
        float iconH = 80 * PZGUI.getResolutionRateHeight();

        float textPosX = 120 * PZGUI.getResolutionRateWidth();
        float textPosY = 22 * PZGUI.getResolutionRateHeight();

        float posX = 60 * PZGUI.getResolutionRateWidth();
        float posY = 20 * PZGUI.getResolutionRateHeight();
        float W = 150 * PZGUI.getResolutionRateWidth();
        float H = 45 * PZGUI.getResolutionRateHeight();

        graphics.setColor(new Color(0, 0, 0, 150));
        graphics.fillRoundRect(posX, posY, W, H, 20);
        SunUI.drawIcon(iconPosX, iconPosY, iconW, iconH);

        sunView.render(textPosX, textPosY, SunUI.getSunCollected().toString(), Color.white);
        graphics.setColor(new Color(255, 255, 255));
    }

    // Show Seed Zone

    /**
     * Draw seedZone's grid
     *
     * @param gc  GameContainer
     * @param sbg StatedBaseGame
     * @param g   Graphics
     * @throws SlickException
     */
    public static void showSeedZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        for (int i = 0; i < 8; i++)
            g.drawRect(seedZonePosX, seedZonePosY + seedZoneH * i, seedZoneW, seedZoneH);
    }

    // Show Plant Zone

    /**
     * Draw plant zone
     *
     * @param gc  GameContainer
     * @param sbg StateBasedGame
     * @param g   Graphics
     * @throws SlickException
     */
    public static void showPlantZoneGrid(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 9; j++)
                g.drawRect(plantZonePosX + cellW * j, plantZonePosY + cellH * i, cellW, cellH);
    }

    public static void showChili(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

    }

    // Pause button

    /**
     * Draw Pause button
     *
     * @param gc GameContainer
     * @param g  Graphics
     * @throws SlickException
     */
    public static void showPauseButton(GameContainer gc, Graphics g) throws SlickException {
        pauseButton.draw(pauseButtonPosX, pauseButtonPosY, pauseButtonWidth, pauseButtonHeight);

        if (Controller.mouseInArea(pauseButtonPosX, pauseButtonPosY, pauseButtonPosX + pauseButtonHeight,
                pauseButtonPosY + pauseButtonHeight)) {
            pauseButton.draw(pauseButtonPosX, pauseButtonPosY, pauseButtonWidth, pauseButtonHeight, new Color(0, 0, 0, 50));

            if (Mouse.getEventButtonState() && Mouse.getEventButton() == 0) {
                gc.setPaused(!gc.isPaused());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void showExitGameButton(GameContainer gc, Graphics g) throws SlickException {

        exitGameButtonHandler(gc, exitGameButton, exitGameButtonPosX, exitGameButtonPosY, exitGameButtonWidth, exitGameButtonHeight);
    }

    static void exitGameButtonHandler(GameContainer gc, Image exitGameButton, float exitGameButtonPosX, float exitGameButtonPosY, float exitGameButtonWidth, float exitGameButtonHeight) {
        exitGameButton.draw(exitGameButtonPosX, exitGameButtonPosY, exitGameButtonWidth, exitGameButtonHeight);

        if (Controller.mouseInArea(exitGameButtonPosX, exitGameButtonPosY, exitGameButtonPosX + exitGameButtonWidth, exitGameButtonPosY + exitGameButtonHeight)) {
            exitGameButton.draw(exitGameButtonPosX, exitGameButtonPosY, exitGameButtonWidth, exitGameButtonHeight, new Color(0, 0, 0, 100));
            if (Mouse.getEventButtonState() && Mouse.getEventButton() == 0) {
                gc.exit();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // Speed Up button
    /**
     * Show speedUp button
     * @param gc    GameContainer
     * @param g    Graphics
     * @throws SlickException
     */
    public static void showSpeedUpButton(GameContainer gc, Graphics g) throws SlickException {
    	speedUpButton.draw(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonWidth, speedUpButtonHeight);

    	if (Controller.mouseInArea(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonPosX + speedUpButtonWidth,
    								speedUpButtonPosY + speedUpButtonHeight)) {
    		speedUpButton.draw(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonWidth, speedUpButtonHeight,
    							new Color(0, 0, 0, 50));
    		if (Mouse.getEventButtonState() && Mouse.getEventButton() == 0) {
    			gc.setTargetFrameRate(isSpeedUpClicked==false?180:60);
    			gc.setVSync(isSpeedUpClicked);
    			isSpeedUpClicked = !isSpeedUpClicked;
    			try {
    				TimeUnit.MILLISECONDS.sleep(100);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	if (isSpeedUpClicked == false) {
    		speedUpButton.draw(speedUpButtonPosX, speedUpButtonPosY, speedUpButtonWidth, speedUpButtonHeight, new Color(0, 0, 0, 100));
    	}

    }


    /**
     * Show play button
     *
     * @param gc GameContainer
     * @param g  Graphics
     */
    public static void showPlayButton(GameContainer gc, Graphics g) {
        if (gc.isPaused()) {
            g.setColor(new Color(1, 1, 1, 100));
            g.fillRect(0, 0, PZGUI.getWidth(), PZGUI.getHeight());
            gamePausedText.render((PZGUI.getWidth() / 2 - 170) * PZGUI.getResolutionRateWidth(), 300 * PZGUI.getResolutionRateHeight(), "Game is Paused!");
            playButton.draw(pauseButtonPosX, pauseButtonPosY, pauseButtonWidth, pauseButtonHeight);
        }
    }

    /**
     * Show Shovel button
     *
     * @param gameContainer GameContainer
     * @param graphics  Graphics
     */
    public static void showShovel(GameContainer gameContainer, Graphics graphics) {
        shovel.draw(shovelButtonPosX, shovelButtonPosY, shovelButtonWidth, shovelButtonHeight);
        if (Controller.mouseInArea(shovelButtonPosX, shovelButtonPosY, shovelButtonPosX + shovelButtonWidth, shovelButtonPosY + shovelButtonHeight)) {
            shovel.draw(shovelButtonPosX, shovelButtonPosY, shovelButtonWidth, shovelButtonHeight, new Color(0, 0, 0, 100));
            if (Mouse.getEventButtonState() && Mouse.getEventButton() == 0) {
                isShovelClicked = !isShovelClicked;
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (isShovelClicked) {
            shovel.draw(Controller.getMouseX() - (20 * PZGUI.getResolutionRateWidth()),
                    Controller.getMouseY() - (30 * PZGUI.getResolutionRateHeight()),
                    shovelButtonWidth,
                    shovelButtonHeight);
        }
    }

    public static void showChili(GameContainer gameContainer, Graphics graphics) {
        int j = 0;
        Chili c = new Chili(new Position(chiliPosX, chiliPosY));

        for (int i = 0; i < 5; i++) {
            while (ChiliList != null && ChiliList.size() < 5) {
                j++;
                System.out.println("Debugging: "+ c);
                ChiliList.add(j, c);
                System.out.println("Debugging: " + "add chili " + c);
                System.out.println("Debugging: " + ChiliList);
                c.setPos(new Position(chiliPosX, chiliPosY + cellH * i));
                Chili.draw(chiliPosX, chiliPosY + cellH * i, chiliWidth, chiliHeight);
            }
        }
    }

    public static void burn(Zombie zombie, Chili chili) {
        for (int i = 0; i < 9; i++) {

            chili.drawChili(ChiliBurn);
            chili.move();

        }
        zombie.setHp(0);
//				chili.remove();
    }

}


