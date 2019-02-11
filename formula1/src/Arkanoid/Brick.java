package Arkanoid;

import java.util.List;

import Arkanoid.soundUtils.PlaySound;

public class Brick extends Actor {
	protected int vx;
	private int lives;
	
	public Brick(String color,int lives) {
		super();
		if(color=="blue") {
			setSpriteNames( new String[] {"lazul.png","lazul-glossy.png"});
		}
		if(color=="purple") {
			setSpriteNames( new String[] {"lmorado.png","lmorado-glossy.png"});
		}
		if(color=="green") {
			setSpriteNames( new String[] {"lverde.png","lverde-glossy.png"});
		}
		if(color=="grey") {
			setSpriteNames( new String[] {"lgris.png","lgris-glossy.png"});
		}
		if(color=="red") {
			setSpriteNames( new String[] {"lrojo.png","lrojo-glossy.png"});
		}
		if(color=="yellow") {
			setSpriteNames( new String[] {"lamarillo.png","lamarillo-glossy.png"});
		}
		this.lives=lives;
		setFrameSpeed(35);
	}
		
    public void remove(List<Actor> actors, int i) {
    	if(lives>1) {
    		lives--;
    		CacheRecursos.getInstancia().playSonido("chirrido-arka.wav");
    	}else {
        	actors.remove(i);
        	Explosion exp = new Explosion();
        	exp.setX(this.getX()+10);
        	exp.setY(this.getY());
        	CacheRecursos.getInstancia().playSonido("woosh.wav");
        	Arkanoid.getInstance().getExplosionlist().add(exp);
        	PlaySound.getSound().explosionSound();
    	}

    }
	
	//getter and setters
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
}
