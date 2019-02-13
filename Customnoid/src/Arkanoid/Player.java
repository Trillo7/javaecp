package Arkanoid;

import java.awt.event.KeyEvent;

public class Player extends Actor {
	protected static final int PLAYER_SPEED = 6;
	protected int vx;
	protected int vy;
	public static boolean hit=false;
	public int lives;
	public int myscore;
	private boolean up,down,left,right;
		
	
	public Player(int lives) {
		super();
		this.lives=lives;
		setSpriteNames( new String[] {"paddleBlue.png"});
		setFrameSpeed(40);
	}
	
	public void act() {
		super.act();
		if(hit) {
			setSpriteNames( new String[] {"paddleRed.png"});
		}else {
			setSpriteNames( new String[] {"paddleBlue.png"});
		}
		x+=vx;
		y+=vy;
		if (x < 0 ) 
		  x = 0;
		if (x > Arkanoid.WIDTH - getWidth())
		  x = Arkanoid.WIDTH - getWidth();
		if (y < 0 )
		  y = 0;
		if ( y > Arkanoid.PLAY_HEIGHT-getHeight())
		  y = Arkanoid.PLAY_HEIGHT - getHeight();
	}

	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
 	public int getVy() { return vy; }
 	public void setVy(int i) {vy = i;	}
  
  
	protected void updateSpeed() {
	  	vx=0;vy=0;
	  	//if (down) vy = PLAYER_SPEED;
	  	//if (up) vy = -PLAYER_SPEED;
	  	if (left) vx = -PLAYER_SPEED;
	  	if (right) vx = PLAYER_SPEED;
	}
	  
	public void keyReleased(KeyEvent e) {
	   	switch (e.getKeyCode()) {
	  		case KeyEvent.VK_DOWN : down = false;break;
			case KeyEvent.VK_UP : up = false; break;
			case KeyEvent.VK_LEFT : left = false; break; 
			case KeyEvent.VK_RIGHT : right = false;break;
	   	}
	   	updateSpeed();
	}
	  
	public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
	  		case KeyEvent.VK_UP : up = true; break;
			case KeyEvent.VK_LEFT : left = true; break;
			case KeyEvent.VK_RIGHT : right = true; break;
			case KeyEvent.VK_DOWN : down = true;break;
	  	}
	  	updateSpeed();
	}
 
}
