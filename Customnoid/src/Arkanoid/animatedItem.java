package Arkanoid;

import java.util.List;

import Arkanoid.soundUtils.PlaySound;

public class animatedItem extends Actor {
	protected int vx;
	private int lives;
	private int animRepeat=3;
	
	public animatedItem() {
		super();
		setSpriteNames( new String[] {"cursor1.png"});
		setFrameSpeed(7);
	}

	/**
	 * @return the animRepeat
	 */
	public int getAnimRepeat() {
		return animRepeat;
	}

	/**
	 * @param animRepeat the animRepeat to set
	 */
	public void setAnimRepeat(int animRepeat) {
		this.animRepeat = animRepeat;
	}
	
}
