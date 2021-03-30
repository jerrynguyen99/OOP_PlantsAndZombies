package pz.plant;

import com.Position;
import gui.AnimationLoader;
import pz.Bullet;
import pz.Zombie;

import java.util.ArrayList;

/**
 * @author Nguyen Truong Dat
 */
public class Peashooter extends pz.Plant {

    private static final int _hp = 100;
    private static final int _damage = 10;
    private static final int _attackInterval = 100;
    private static boolean _attackCooldown = false;

    public Peashooter(Position pos) {
        super("Peashooter", _hp, _damage, _attackInterval, pos);
    }

    @Override
    protected void loadAnimation() {
        setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/PeaShooter/Idle", 30));
    }

    @Override
    public void attack(ArrayList<Bullet> bulletArrayList) {
//		if (getFramePassed() > getAttackInterval()) {
        if (getAnimation().getFrame() == 16 && _attackCooldown == false) {
            bulletArrayList.add(new pz.bullet.BPeashooter((getPos().x + getWidth() * 0.8f),
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

    @Override
    public void attackChili(ArrayList<Bullet> bulletArrayList, ArrayList<Zombie> zombies) {

    }

    @Override
    public void move() {
        setPos(getPos().x + getSpeed(), getPos().y);
    }


}
