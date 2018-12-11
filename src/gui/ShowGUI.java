package gui;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;

public class ShowGUI extends StateBasedGame {

    //Windows Size
    protected static int width 	= 1600;
    protected static int height 	= 900;
    protected static int defaultWidth = 1600;
    protected static int defaultHeight = 900;

    protected static int targetFPS = 65;
    protected static boolean showFPS 	 = true;
    protected static boolean fullScreen = false;
    protected static boolean vSync 	 = true;
    protected static boolean AA		 = true;

    protected static float resolutionRateWidth;
    protected static float resolutionRateHeight;

    private void loadDefaultSettings() {
        width      = defaultWidth;
        height     = defaultWidth;
        targetFPS  = 60;
        showFPS    = true;
        fullScreen = false;
        vSync      = true;
        AA         = true;
    }


    protected static final String gameName = "PASS THIS COURSE, PLEASE";
    /**
     * INITIALIZE GAME WITH DEFAULT NAME
     * @param gameName	Game title
     */

    private static final int introScreen = 0;

    public ShowGUI(String gameName) throws java.io.IOException{
        super(gameName);
        try {
            Ini iniFile = new Ini(new File("config.ini"));
//            targetFPS  = Integer.parseInt	  (iniFile.get("DISPLAY", "targetFPS" ));
            showFPS    = Boolean.parseBoolean (iniFile.get("DISPLAY", "showFPS"	  ));
            fullScreen = Boolean.parseBoolean (iniFile.get("DISPLAY", "fullScreen"));
            vSync      = Boolean.parseBoolean (iniFile.get("DISPLAY", "vSync"	  ));
            AA         = Boolean.parseBoolean (iniFile.get("DISPLAY", "AA"	  ));
        } catch (InvalidFileFormatException i) {
            i.printStackTrace();
            this.loadDefaultSettings();
        }

    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new MaleZombie());
    }
}
