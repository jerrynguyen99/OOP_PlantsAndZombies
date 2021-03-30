package gui;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * @author Nguyen Truong Dat & Tran To Que Phuong
 */
public class PZGUI extends StateBasedGame {

    private static int width = 1600;
    private static int height = 900;

//	public static int width		= 800;
//	public static int height	= 450;

    private static int targetFPS = 65;
    private static boolean showFPS = true;
    private static boolean fullScreen = false;

    private static final String gameName = "Pass this course, please";
    private static final String iconRef = "../res/other/Plants-Vs-Zombies.png";
    private static final int splashScreen = 0;
    private static final int menu = 1;
    private static final int play = 2;

    private static final int gameOver = 3;

    private static float resolutionRateWidth;
    private static float resolutionRateHeight;

    private static final int defaultWidth = 1600;
    private static final int defaultHeight = 900;

    /**
     * INITIALIZE GAME WITH DEFAULT NAME
     *
     * @param gameName Game title
     */
    public PZGUI(String gameName) {
        super(gameName);
        try {
            Ini ini = new Ini(new File("config.ini"));
            width = Integer.parseInt(ini.get("DISPLAY", "width"));
            height = Integer.parseInt(ini.get("DISPLAY", "height"));
            targetFPS = Integer.parseInt(ini.get("DISPLAY", "targetFPS"));
            showFPS = Boolean.parseBoolean(ini.get("DISPLAY", "showFPS"));
            fullScreen = Boolean.parseBoolean(ini.get("DISPLAY", "fullScreen"));


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
        width = defaultWidth;
        height = defaultHeight;
        targetFPS = 60;
        showFPS = true;
        fullScreen = true;

    }

    public static ByteBuffer[] loadIcon(String filepath, AppGameContainer app)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(Objects.requireNonNull(app.getClass().getClassLoader().getResource(filepath)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        ByteBuffer[] buffers = new ByteBuffer[3];
        assert image != null;
        buffers[0] = loadIconInstance(image, 128);
        buffers[1] = loadIconInstance(image, 32);
        buffers[2] = loadIconInstance(image, 16);
        return buffers;
    }

    private static ByteBuffer loadIconInstance(BufferedImage image, int dimension)
    {
        BufferedImage scaledIcon = new BufferedImage(dimension, dimension, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaledIcon.createGraphics();
        double ratio;
        ratio = (double) (scaledIcon.getWidth()) / image.getWidth();
        if(image.getHeight() > scaledIcon.getHeight())
        {
            double r2 = (double) (scaledIcon.getHeight()) / image.getHeight();
            if(r2 < ratio)
            {
                ratio = r2;
            }
        }
        else
        {
            int r2 = scaledIcon.getHeight() / image.getHeight();
            if(r2 < ratio)
            {
                ratio = r2;
            }
        }
        double width = image.getWidth() * ratio;
        double height = image.getHeight() * ratio;
        g.drawImage(image, (int) ((scaledIcon.getWidth() - width) / 2), (int) ((scaledIcon.getHeight() - height) / 2),
                (int) (width), (int) (height), null);
        g.dispose();

        byte[] imageBuffer = new byte[dimension*dimension*4];
        int counter = 0;
        for(int i = 0; i < dimension; i++)
        {
            for(int j = 0; j < dimension; j++)
            {
                int colorSpace = scaledIcon.getRGB(j, i);
                imageBuffer[counter] =(byte)((colorSpace << 8) >> 24 );
                imageBuffer[counter + 1] =(byte)((colorSpace << 16) >> 24 );
                imageBuffer[counter + 2] =(byte)((colorSpace << 24) >> 24 );
                imageBuffer[counter + 3] =(byte)(colorSpace >> 24 );
                counter += 4;
            }
        }
        return ByteBuffer.wrap(imageBuffer);
    }


    /**
     * Initialize game State
     */
    public void initStatesList(GameContainer gameContainer) {
        //this.getState(splashScreen).init(gameContainer, this);
        //this.getState(menu).		  init(gameContainer, this);
        //this.getState(play).		  init(gameContainer, this);
        //this.getState(gameOver).	  init(gameContainer, this);
        this.enterState(splashScreen, new FadeInTransition(), new EmptyTransition()); // show SplashScreen first
    }

    /**
     * Main process
     *
     * @param args Arguments
     */
    public static void main(String[] args) {
        AppGameContainer appGameContainer;
        try {
            appGameContainer = new AppGameContainer(new PZGUI(gameName));
            appGameContainer.setShowFPS(showFPS);
            Display.setIcon(loadIcon(iconRef, appGameContainer));

            if (fullScreen) {
                width = appGameContainer.getScreenWidth();
                height = appGameContainer.getScreenHeight();
            }
            appGameContainer.setDisplayMode(width, height, fullScreen);
            appGameContainer.setUpdateOnlyWhenVisible(true);
            appGameContainer.setTargetFrameRate(targetFPS);
            appGameContainer.setSmoothDeltas(true);
            appGameContainer.setAlwaysRender(true);
            resolutionRateHeight = (float) appGameContainer.getHeight() / (float) defaultHeight;
            resolutionRateWidth = (float) appGameContainer.getWidth() / (float) defaultWidth;

            appGameContainer.start(); //Begin thread game
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        PZGUI.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        PZGUI.height = height;
    }

    public static float getResolutionRateWidth() {
        return resolutionRateWidth;
    }

    public static float getResolutionRateHeight() {
        return resolutionRateHeight;
    }

}
