package pz;

import com.Position;
import gui.PZGUI;

import java.util.ArrayList;

public abstract class Plant extends Character {

    private final float scaleFactor = 0.2f;
    //===========================

    /**
     * Plant contructor
     *
     * @param name           Name of instance (optional)
     * @param hp             Health power
     * @param damage         Damage
     * @param attackInterval attack interval
     * @param pos            Position
     */
    public Plant(String name, int hp, int damage, int attackInterval, Position pos) {
        super(name, hp, damage, attackInterval, pos);
        loadAnimation();
        setFramePassed(0);
    }

    @Override
    public float getWidth() {
        return getAnimation().getWidth() * scaleFactor * PZGUI.getResolutionRateWidth();
    }

    @Override
    public float getHeight() {
        return getAnimation().getHeight() * scaleFactor * PZGUI.getResolutionRateHeight();
    }

    /**
     * Draw character
     */
    public void draw(boolean updateImg) {
        getAnimation().setAutoUpdate(updateImg);
        getAnimation().draw(getPos().x, getPos().y, getWidth(), getHeight());
    }

    public abstract void attack(ArrayList<Bullet> bulletArrayList);

    public abstract void attackChili(ArrayList<Bullet> bulletArrayList, ArrayList<Zombie> zombies);
}
