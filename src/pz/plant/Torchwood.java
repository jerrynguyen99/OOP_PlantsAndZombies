package pz.plant;

import com.Position;
import gui.AnimationLoader;
import pz.Bullet;
import pz.Plant;
import pz.Zombie;
import pz.bullet.BPeashooter;

import java.util.ArrayList;

public class Torchwood extends Plant {

    private static final int hp = 200;
    private static final int damage = 10;
    private static final int attackInterval = 0;

    public Torchwood(Position pos) {
        super("Torchwood", hp, damage, attackInterval, pos);
    }

    @Override
    public void attack(ArrayList<Bullet> bulletList) {
        for (int i = 0; i < bulletList.size(); i++) {
            if (bulletList.get(i).getBoosted == false) {
                if (bulletList.get(i).getPos().x > getPos().x &&
                        bulletList.get(i).getPos().x < getPos().x + getWidth() &&
                        bulletList.get(i).getPos().y > getPos().y &&
                        bulletList.get(i).getPos().y < getPos().y + getHeight() &&
                        bulletList.get(i) instanceof BPeashooter) {
                    bulletList.get(i).setDamage(bulletList.get(i).getDamage() + getDamage());
                    bulletList.get(i).getBoosted = true;
                    bulletList.get(i).setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/Peashooter/Bullet/fire", 150));
                }
            }
        }
    }

    @Override
    public void attackChili(ArrayList<Bullet> bulletArrayList, ArrayList<Zombie> zombies) {

    }

    @Override
    public void move() {
    }

    @Override
    protected void loadAnimation() {
        setAnimation(AnimationLoader.getAnimationFromFolder("res/Plants/Torchwood/Idle", 100));
    }

}
