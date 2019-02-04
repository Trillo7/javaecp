package Arkanoid;

import java.awt.Rectangle;

public class Ball extends Actor {
	protected int vx;
	protected int vy;

	
	public Ball() {
		super();
		setSpriteNames( new String[] {"ballGrey.png"});
		setFrameSpeed(35);
	}
	
	public void act(int yplayer, int xplayer) {
		super.act();
		x+=vx;//aumentamos su posicion para que se mueva
		y+=vy;
		if (x < 0 || x > Arkanoid.WIDTH-18 ) { // calcular rebote
			vx = -vx; 	
		}
		if (y < 0 || y > Arkanoid.HEIGHT) { // calcular rebote
			vy = -vy; 	
		}
		
		Rectangle rectplayer = new Rectangle(xplayer,yplayer, 104, 24); // dimension nave
		Rectangle rectball = new Rectangle(this.x, this.y, 22,22);
		if(rectball.intersects(rectplayer)) {
			vy = -vy; 
		}
	}

    
	
	//getter and setters
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;	}
}
