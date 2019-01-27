package Arkanoid;

public class Ball extends Actor {
	protected int vx;
	protected int vy;

	
	public Ball(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"ballBlue.png"});
		setFrameSpeed(35);
	}
	
	public void act() {
		super.act();
		x+=vx;//aumentamos su posicion para que se mueva
		y+=vy;
		if (x < 0 || x > Stage.WIDTH ) { // calcular rebote
			vx = -vx; 	
		}
		if (y < 0 || y > Stage.HEIGHT) { // calcular rebote
			vy = -vy; 	
		}
	}

	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;	}
}
