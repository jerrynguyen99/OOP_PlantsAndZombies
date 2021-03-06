package pz.plant;

import com.Position;
import gui.AnimationLoader;
import gui.SunUI;
import org.newdawn.slick.SlickException;
import pz.Bullet;
import pz.Zombie;
import pz.sun.SunSunflower;

import java.util.ArrayList;

public class Sunflower extends pz.Plant {

    private static final int hp = 100;
    private static final int attackInterval = 500;

    public Sunflower(Position pos) {
        super("Sunflower", hp, 0, attackInterval, pos);
    }

    protected void loadAnimation() {
        setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/SunFlower/Idle", 50));
    }

    public void attack(ArrayList<Bullet> bulletArrayList) {
        if (getFramePassed() > getAttackInterval()) {
            try {
                SunUI.getSunManager().add(new SunSunflower(SunUI.getSunAni(), getPos().x, getPos().y + getHeight() / 3f));
            } catch (SlickException e) {
                e.printStackTrace();
            }
            setFramePassed(0);
        }
        setFramePassed(getFramePassed() + 1);
    }

    @Override
    public void attackChili(ArrayList<Bullet> bulletArrayList, ArrayList<Zombie> zombies) {

    }

    @Override
    public void move() {
        // TODO Auto-generated method stub

    }

}
