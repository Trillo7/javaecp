package Arkanoid;

import java.util.List;

import Arkanoid.soundUtils.PlaySound;

public class Brick extends Actor {
	protected int vx;
	private int lives;
	
	public Brick(String color) {
		super();
		if(color=="blue") {
			setSpriteNames( new String[] {"element_blue_rectangle.png","element_blue_rectangle_glossy.png"});
		}
		if(color=="purple") {
			setSpriteNames( new String[] {"element_purple_rectangle.png","element_purple_rectangle_glossy.png"});
		}
		if(color=="green") {
			setSpriteNames( new String[] {"element_green_rectangle.png","element_green_rectangle_glossy.png"});
		}
		if(color=="grey") {
			setSpriteNames( new String[] {"element_grey_rectangle.png","element_grey_rectangle_glossy.png"});
		}
		if(color=="red") {
			setSpriteNames( new String[] {"element_red_rectangle.png","element_red_rectangle_glossy.png"});
		}
		if(color=="yellow") {
			setSpriteNames( new String[] {"element_yellow_rectangle.png","element_yellow_rectangle_glossy.png"});
		}
		setFrameSpeed(35);
	}
		
    public void remove(List<Actor> actors, int i) {
    	if(lives>0) {
    		lives--;
    	}else {
        	actors.remove(i);
        	Explosion exp = new Explosion();
        	exp.setX(this.getX() );
        	exp.setY(this.getY());
        	Arkanoid.getInstancia().getExplosionlist().add(exp);
        	PlaySound.getSound().explosionSound();
        	//Arkanoid.getInstancia().getExplosionlist().remove(i);
    	}

    }
	
	//getter and setters
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
}
