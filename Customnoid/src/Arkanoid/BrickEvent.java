package Arkanoid;

public class BrickEvent {
	Brick brick;

	public BrickEvent(Brick brick) {
		super();
		this.brick = brick;
	}

	public Brick getBrick() {
		return brick;
	}

	public void setBrick(Brick brick) {
		this.brick = brick;
	}
	
}
