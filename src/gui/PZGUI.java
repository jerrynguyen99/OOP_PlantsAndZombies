package gui;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Nguyen Truong Dat & Tran To Que Phuong
 *
 */
public class PZGUI extends StateBasedGame {
	
	private static int width 	= 1600; 	
	private static int height 	= 900;
	
//	public static int width		= 800;
//	public static int height	= 450;
	
	private static int 	   targetFPS = 65;
	private static boolean showFPS 	 = true;
	private static boolean fullScreen = false;
	
	private static final String gameName = "Pass this course, please";
	private static final int splashScreen = 0;
	private static final int menu = 1;
	private static final int play = 2;
	@SuppressWarnings("unused")
	private static final int gameOver = 3;
	
	private static float resolutionRateWidth;
	private static float resolutionRateHeight;
	
	private static int defaultWidth = 1600;
	private static int defaultHeight = 900;
	
	/**
	 * INITIALIZE GAME WITH DEFAULT NAME
	 * @param gameName	Game title
	 */
	public PZGUI(String gameName) {
		super(gameName);
		try {
			Ini ini = new Ini(new File("config.ini"));
//			width      = Integer.parseInt	  (ini.get("DISPLAY", "width"	  ));
//			height     = Integer.parseInt	  (ini.get("DISPLAY", "height"	  ));
			targetFPS  = Integer.parseInt	  (ini.get("DISPLAY", "targetFPS" ));
			showFPS    = Boolean.parseBoolean (ini.get("DISPLAY", "showFPS"	  ));
			fullScreen = Boolean.parseBoolean (ini.get("DISPLAY", "fullScreen"));

			
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
			this.loadDefaultSettings();
			
		} catch (IOException e) {
			e.printStackTrace();
			this.loadDefaultSettings();
		}
		this.addState(new SplashScreen(splashScreen));
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new GameOver(gameOver));
	}
	
	/**
	 * Load default settings for game
	 * targetFPS=60
	 * showFPS=true
	 * fullScreen=false
	 * vSync=true
	 * AA=true
	 */
	private void loadDefaultSettings() {
		width      = defaultWidth;
		height     = defaultWidth;
		targetFPS  = 60;
		showFPS    = true;
		fullScreen = true;

	}
	
	/**
	 * Initialize game State
	 */
	public void initStatesList(GameContainer gameContainer) {
		//this.getState(splashScreen).init(gc, this);
		//this.getState(menu).		  init(gc, this);
		//this.getState(play).		  init(gc, this);
		//this.getState(gameOver).	  init(gc, this);
		this.enterState(splashScreen, new FadeInTransition(), new EmptyTransition()); // show SplashScreen first	
	}
	
	/**
	 * Main process
	 * @param args Arguments
	 */
	public static void main(String[] args){
		AppGameContainer appGameContainer;
		try {
			appGameContainer = new AppGameContainer(new PZGUI(gameName));
			appGameContainer.setShowFPS(showFPS);
			
			if (fullScreen == true){
				width = appGameContainer.getScreenWidth();
				height  = appGameContainer.getScreenHeight();
			}			
			appGameContainer.setDisplayMode(width, height, fullScreen);
			appGameContainer.setUpdateOnlyWhenVisible(true);
			appGameContainer.setTargetFrameRate(targetFPS);
			appGameContainer.setSmoothDeltas(true);
			appGameContainer.setAlwaysRender(true);
			resolutionRateHeight = (float)appGameContainer.getHeight() / (float)defaultHeight;
			resolutionRateWidth  = (float)appGameContainer.getWidth() / (float)defaultWidth;
			
			appGameContainer.start(); //Begin thread game
		} 
		catch(SlickException e) {
			e.printStackTrace();
		}
	}


	public static int 	  getWidth() 				{return width;}
	public static void 	  setWidth(int width) 		{PZGUI.width = width;}

	public static int 	  getHeight() 				{return height;}
	public static void    setHeight(int height)     {PZGUI.height = height;}

	public static float   getResolutionRateWidth()  {return resolutionRateWidth;}
	public static float   getResolutionRateHeight() {return resolutionRateHeight;}
	
}
