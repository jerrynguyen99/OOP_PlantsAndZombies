package pz;

import com.Position;
import gui.PZGUI;
import org.newdawn.slick.Animation;

public class DeadBody {

    private final Animation ani = new Animation();
    private final Position pos;

    public DeadBody(Class _class, Position pos) {
        this.pos = pos;
        loadAnimation(_class);
    }

    private float getWidth() {
        return ani.getWidth() * PZGUI.getResolutionRateWidth();
    }

    private float getHeight() {
        return ani.getHeight() * PZGUI.getResolutionRateHeight();
    }

    /**
     * Draw the animation in only one drame cycle, return whether end of one cycle or not
     *
     * @return True when still be in draw cycle, false at the end of cycle
     */
    public boolean draw() {
        if (ani.getFrame() < ani.getFrameCount()) {
            ani.draw(pos.x, pos.y, getWidth(), getHeight());
            return true;
        }
        return false;
    }

    protected void loadAnimation(Class _class) {
        //setAnimation(ani);

    }


}
