package Arkanoid;

import java.awt.Rectangle;

import Arkanoid.soundUtils.PlaySound;

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
			PlaySound.getSound().wooshSound();
			//CacheRecursos.getInstancia().playSonido("woosh.wav");
		}
		if (y < 0 || y > Arkanoid.HEIGHT) { // calcular rebote
			vy = -vy; 	
			// BUG 2 PORQUE GETINSTANCE CREA OTRA VENTANA
			// Bug 1 sonido file java
			//Arkanoid.getInstance().setMenu(1);
			Arkanoid.menu=1;
		}
		
		Rectangle rectplayer = new Rectangle(xplayer,yplayer, 104, 24); // dimension nave
		Rectangle rectball = new Rectangle(this.x, this.y, 22,22);
		if(rectball.intersects(rectplayer)) {
			vy = -vy; 
			PlaySound.getSound().wooshSound();
			//CacheRecursos.getInstancia().playSonido("woosh.wav");

		}
	}

    
	
	//getter and setters
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;	}
}
