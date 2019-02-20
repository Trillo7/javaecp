package Arkanoid;

import java.util.List;

import Arkanoid.soundUtils.PlaySound;

public class itemAnimation extends Actor {
	protected int vx;
	private int lives;
	
	public itemAnimation() {
		super();
		setSpriteNames( new String[] {"explosion0.png","explosion1.png","explosion2.png","explosion3.png","explosion4.png","explosion5.png","explosion6.png","explosion7.png"});
		setFrameSpeed(7);
	}
		
}
