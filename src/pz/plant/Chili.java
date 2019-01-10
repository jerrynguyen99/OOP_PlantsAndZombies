package pz.plant;

import com.Position;
import gui.AnimationLoader;
import pz.Bullet;
import pz.Plant;
import pz.Zombie;

import java.util.ArrayList;

public class Chili extends Plant {
    private static int _hp = 100;
    private static int _damage = 10;
    private static int _attackInterval = 100;
    private static boolean _attackCooldown = false;

    public Chili (Position pos) {
        super("Chili", _hp, _damage, _attackInterval, pos);
    }

    @Override
    protected void loadAnimation() {
        setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/chili/Idle", 30));
    }


    public void attackChili(ArrayList<Bullet> bulletArrayList, ArrayList<Zombie> zombies) {
        for (Zombie z : zombies) {
//		if (getFramePassed() > getAttackInterval()) {
            if (Position.isInteract(z, this) && _attackCooldown == false) {
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
    }

    @Override
    public void move() {
        setPos(getPos().x + getSpeed(), getPos().y);
    }

    @Override
        public void attack(ArrayList<Bullet> bulletArrayList) {

        }
}
