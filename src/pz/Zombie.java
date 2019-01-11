package pz;

import java.util.ArrayList;

import com.Position;
import gui.PZGUI;
import pz.plant.Chili;


public abstract class Zombie extends Character {
	
	private float scaleFactor = 1.3f;

	public void setScaleFactor (float scaleFactor){
		this.scaleFactor= scaleFactor;
	}
	
	/**
	 * Zombie contructor
	 * @param name	Name of instance (optional)
	 * @param hp	Health power
	 * @param damage	Damage
	 * @param attackInterval	attack interval
	 * @param pos	Position
	 */
	public Zombie(String name, int hp, int damage, int attackInterval, float speed, Position pos, float scaleFactor) {
		super(name, hp, damage, attackInterval, pos);
		setScaleFactor(scaleFactor);
		setSpeed(speed);
		loadAnimation();
	}
	
	@Override
	public float getWidth() {return getAnimation().getWidth() * scaleFactor * PZGUI.getResolutionRateWidth() ;}
	@Override
	public float getHeight() {return getAnimation().getHeight() * scaleFactor * PZGUI.getResolutionRateHeight() ;}
	
	public void draw(boolean updateImg) {
		getAnimation().setAutoUpdate(updateImg);
		getAnimation().draw(getPos().x, getPos().y, getWidth(), getHeight());
	}
	
	public abstract void attack(Plant[][] plant, ArrayList<Bullet> bulletList);
	public abstract void attackChili(Chili plant, ArrayList<Bullet> bulletList);
}
