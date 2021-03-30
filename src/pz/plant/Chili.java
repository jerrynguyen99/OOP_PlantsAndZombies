package pz.plant;

import com.Position;
import gui.AnimationLoader;
import org.newdawn.slick.Image;
import pz.Bullet;
import pz.Plant;
import pz.Zombie;

import java.util.ArrayList;

/**
 * @author Nguyen Truong Dat
 */
public class Chili extends Plant {
    private static final int _hp = 100;
    private static final int _damage = 10;
    private static final int _attackInterval = 100;
    private static boolean _attackCooldown = false;
    private Position pos;

    public Chili(Position pos) {
        super("Chili", _hp, _damage, _attackInterval, pos);
    }

    @Override
    public void setPos(Position pos) {
        this.pos = pos;
    }

    @Override
    public Position getPos() {
        return this.pos;
    }

    @Override
    protected void loadAnimation() {
        setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/chili/Idle", 30));
    }


    public void attackChili(ArrayList<Bullet> bulletArrayList, ArrayList<Zombie> zombies) {
        for (Zombie z : zombies) {
//		if (getFramePassed() > getAttackInterval()) {
            if (!_attackCooldown) {
                bulletArrayList.add(new pz.bullet.BChili((getPos().x + getWidth() * 0.8f),
                        (getPos().y + getHeight() * 0.15f),
                        getDamage()));
                setFramePassed(0);
                _attackCooldown = true;
            }

            if (getAnimation().getFrame() == 18) {
                _attackCooldown = false;
            }
            setFramePassed(getFramePassed() + 1);
        }
    }

    @Override
    public void move() {
        setSpeed(20);
        setPos(getPos().x + getSpeed(), getPos().y);
    }

    @Override
    public void attack(ArrayList<Bullet> bulletArrayList) {
    }

    public void drawChili(Image img) {
        setSpeed(20);
        img.draw(this.getPos().x + getSpeed(), this.getPos().y);
    }
}
