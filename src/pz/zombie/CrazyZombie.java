package pz.zombie;

import com.Position;
import gui.AnimationLoader;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import pz.Bullet;
import pz.Plant;
import pz.Zombie;
import pz.plant.Chili;

import java.util.ArrayList;

public class CrazyZombie extends Zombie {

    private static final int hp = 300;
    private static final int damage = 10;
    private static final int attackInterval = 50;
    private static final float speed = 0.33f;

    private final Animation attackAni;
    private final Animation walkAni;
    private final Image ChiliBurn;

    private static final float scaleFactor = 1.3f;

    public CrazyZombie(Position pos) throws SlickException {
        super("CrazyZombie", hp, damage, attackInterval, speed, pos, scaleFactor);
        attackAni = AnimationLoader.getAnimationFromFolder("res/ZombieTest/CrazyZombie/attack", 110);
        walkAni = getAnimation();
        ChiliBurn = new Image("res/Plants/chili/Bullet/1.png");
    }

    @Override
    public void move() {
        setPos(getPos().x - getSpeed(), getPos().y);
    }

    @Override
    protected void loadAnimation() {
        setAnimation(AnimationLoader.getAnimationFromFolder("res/ZombieTest/CrazyZombie/walk", 110));
    }

    @Override
    public void attack(Plant[][] plant, ArrayList<Bullet> bulletList) {
        boolean hit = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (plant[i][j] != null) {
                    if (Position.isInteract(this, plant[i][j])) {
                        hit = true;
                        setSpeed(0);
                        setAnimation(attackAni);
                        setScaleFactor(0.6f);
                        //System.out.println("touched");
                        if (getFramePassed() >= getAttackInterval()) {
                            plant[i][j].setHp(plant[i][j].getHp() - getDamage());
                            setFramePassed(0);
                        }
                        setFramePassed(getFramePassed() + 1);
                        return;
                    }
                }
            }
        }
        if (!hit) {
            setScaleFactor(1.3f);
            setAnimation(walkAni);
            setSpeed(speed);
        }
    }

    @Override
    public void attackChili(Chili plant, ArrayList<Bullet> bulletList) {
        boolean hit = false;
        if (plant != null) {
            if (Position.isInteractChili(this, plant)) {
                hit = true;

                setAnimation(attackAni);
                setScaleFactor(0.6f);
                //System.out.println("touched");
                if (getFramePassed() >= getAttackInterval()) {
                    plant.move();
                    plant.drawChili(ChiliBurn);
                    setFramePassed(0);
                }
                setFramePassed(getFramePassed() + 1);
                return;
            }
        }
    }

}

