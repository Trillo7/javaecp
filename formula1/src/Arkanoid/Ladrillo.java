package Arkanoid;

public class Ladrillo extends Actor {
	protected int vx;

	
	public Ladrillo(Stage stage, String color) {
		super(stage);
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
	
	public void act() {
		super.act();
		//x+=vx;// para que se mueva
		if (x < 0 || x > Stage.WIDTH) { // calcular rebote
			vx = -vx; 	
		}
		  
	}

	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
}
