package Arkanoid;

public class Ladrillo extends Actor {
	protected int vx;

	
	public Ladrillo(Stage stage) {
		super(stage);
		setSpriteNames( new String[] {"element_purple_rectangle.png","element_purple_rectangle_glossy.png"});
		setFrameSpeed(35);
	}
	
	public void act() {
		super.act();
		x+=vx;// para que se mueva
		if (x < 0 || x > Stage.WIDTH) { // calcular rebote
			vx = -vx; 	
		}
		  
	}

	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
}
