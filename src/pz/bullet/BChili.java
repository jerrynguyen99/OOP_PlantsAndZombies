package pz.bullet;

import com.Position;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import pz.Bullet;
import pz.Zombie;

import java.util.ArrayList;

/**
 * @author Nguyen Truong Dat
 */
public class BChili extends pz.Bullet {
    private static int damage = 1000;
    private static float speed = 4f;
    //private static Animation ani = new Animation();

    protected void loadAnimation() {
        try {
            getAnimation().addFrame(new Image("res/Plants/chili/Bullet"), 10);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public BChili(float x, float y) {
        super(damage, speed, new Position(x, y));
        loadAnimation();
    }

    public BChili(float x, float y, int _damage, float _speed) {
        super(_damage, _speed, new Position(x, y));
        loadAnimation();
    }

    public BChili(float f, float y, int _damage) {
        super(_damage, speed, new Position(f, y));
        loadAnimation();
    }

    public BChili(Position pos) {
        super(damage, speed, pos);
        loadAnimation();
    }

    public BChili(Position pos, int _damage, int _speed) {
        super(_damage, _speed, pos);
        loadAnimation();
    }

    public void move() {
        setPos(getPos().x + getSpeed(), getPos().y);
    }

    @Override
    public void attack(ArrayList<Zombie> zombieList, ArrayList<Bullet> bulletList) {
        for (Zombie z : zombieList) {
            //if (z == null) continue;
            if (Position.isIntersect(this, z)) {
                z.setHp(z.getHp() - z.getHp());
                bulletList.remove(this);
                return;
            }
        }
    }
}
