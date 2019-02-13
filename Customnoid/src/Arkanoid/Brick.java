package Arkanoid;

import java.util.List;

import Arkanoid.soundUtils.PlaySound;

public class Brick extends Actor {
	protected int vx;
	private int lives;
	private int lscore;
	
	public Brick(int lid) {
		super();
		this.lid=lid;
		if(lid==1) {
			setSpriteNames( new String[] {"lverde.png","lverde-glossy.png"});
			this.lives=1;
			this.lscore=3;
		}
		if(lid==2) {
			setSpriteNames( new String[] {"lazul.png","lazul-glossy.png"});
			this.lives=1;
			this.lscore=3;

		}
		if(lid==3) {
			setSpriteNames( new String[] {"lrojo.png","lrojo-glossy.png"});
			this.lives=1;
			this.lscore=3;

		}
		if(lid==4) {
			setSpriteNames( new String[] {"lamarillo.png","lamarillo-glossy.png"});
			this.lives=2;
			this.lscore=5;

		}
		if(lid==5) {
			setSpriteNames( new String[] {"lmorado.png","lmorado-glossy.png"});
			this.lives=3;
			this.lscore=8;
		}
	
		if(lid==6) {
			setSpriteNames( new String[] {"lgris.png","lgris-glossy.png"});
			this.lives=9;
			this.lscore=0;
		}
		setFrameSpeed(35);
	}
	@Override	
    public void removeActor(List<Actor> actors, int i, Player player) {
    	if(lives>1) {
    		if(this.lid!=6) {
        		lives--;
    		}
    		CacheRecursos.getInstancia().playSonido("chirrido-arka.wav");
    	}else {
    		player.myscore+=this.lscore;
        	actors.remove(i);
        	Explosion exp = new Explosion();
        	exp.setX(this.getX()+10);
        	exp.setY(this.getY());
        	CacheRecursos.getInstancia().playSonido("woosh.wav");
        	Arkanoid.getInstance().getExplosionlist().add(exp);
        	PlaySound.getSound().explosionSound();
    	}

    }
	// Cada ladrillo da puntos
	// Cada fase dara puntos 
	// Cada vida menos quita puntos
	//getter and setters
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
}
