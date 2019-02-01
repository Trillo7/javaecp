package Arkanoid;

import java.util.List;

import Arkanoid.soundUtils.PlaySound;

public class Explosion extends Actor {
	protected int vx;
	private int lives;
	
	public Explosion() {
		super();
		setSpriteNames( new String[] {"exp1.png","exp2.png","exp3.png"});
		setFrameSpeed(35);
	}
		
    public void remove(List<Actor> actors, int i) {
     
    }
	
	//getter and setters
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
}
