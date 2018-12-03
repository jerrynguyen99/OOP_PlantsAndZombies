package gui;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import java.io.IOException;

public class MainHere {

    /**
     * Main process
     * @param args Arguments
     */
    public static void main (String[] args) throws SlickException, IOException {
        AppGameContainer appgc = new AppGameContainer(new ShowGUI(ShowGUI.gameName));
        try {
            appgc.setShowFPS(ShowGUI.showFPS);
            if (ShowGUI.fullScreen == true) {
                ShowGUI.height = appgc.getScreenHeight();
                ShowGUI.width = appgc.getScreenWidth();
            }
            appgc.setDisplayMode(ShowGUI.width, ShowGUI.height, ShowGUI.fullScreen);
            appgc.setUpdateOnlyWhenVisible(true);
            appgc.setTargetFrameRate(ShowGUI.targetFPS);
            appgc.setVSync(ShowGUI.vSync);
            appgc.setSmoothDeltas(true);
            appgc.setAlwaysRender(true);
            ShowGUI.resolutionRateHeight = (float) appgc.getHeight() / (float) ShowGUI.defaultHeight;
            ShowGUI.resolutionRateWidth = (float) appgc.getWidth() / (float) ShowGUI.defaultWidth;

            appgc.start();
        } catch (SlickException e){
            e.printStackTrace();
        }
    }
}
