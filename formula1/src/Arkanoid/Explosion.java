package Arkanoid;

import java.util.List;

import Arkanoid.soundUtils.PlaySound;

public class Explosion extends Actor {
	protected int vx;
	private int lives;
	
	public Explosion() {
		super();
		setSpriteNames( new String[] {"exp1.png","exp2.png","exp3.png"});
		setFrameSpeed(10);
	}
		
}
