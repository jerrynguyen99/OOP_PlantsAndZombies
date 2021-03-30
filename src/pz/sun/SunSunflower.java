package pz.sun;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import pz.Sun;

public class SunSunflower extends Sun {

    private float x;
    private float y = 0;
    private final float initX;
    private final float initY;
    private static final float speed = 0.1f;
    private static final float height = 40f;

    public SunSunflower(Animation ani, float posX, float posY) throws SlickException {
        super(ani, posX, posY, 0);
        initX = posX;
        initY = posY;
        x = (float) Math.sqrt(height - 1);
    }

    @Override
    public void updateSun() {
        clickOn();
        if (!isClicked()) {
            y = -x * x + height;
            if (y >= 0) {
                x -= speed;
                setPosX(initX + x);
                setPosY(initY - y);
            } else {
                if (getFramePass() <= getStayTimeInFrame())
                    setFramePass(getFramePass() + 1);
                else
                    setDone(true);
            }
        } else {
            if (getPosX() > 30f) {
                setPosX(getPosX() - getPosX() / 20f);
                setPosY(getPosY() - getPosY() / 20f);
            } else
                setDone(true);
        }
    }

}
