package pz.plant;

import com.Position;
import gui.AnimationLoader;
import pz.Bullet;
import pz.Zombie;

import java.util.ArrayList;

public class Wallnut extends pz.Plant {

    private static final int hp = 2000;
    private static final int attackInterval = 0;

    public Wallnut(Position pos) {
        super("Wallnut", hp, 0, attackInterval, pos);
    }

    @Override
    public void attack(ArrayList<Bullet> bulletList) {

    }

    @Override
    public void attackChili(ArrayList<Bullet> bulletArrayList, ArrayList<Zombie> zombies) {

    }

    @Override
    public void move() {

    }

    @Override
    protected void loadAnimation() {
        setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/WallNut/Idle2", 100));
    }

}
