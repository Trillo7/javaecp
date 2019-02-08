package Arkanoid;

import java.awt.Rectangle;

import Arkanoid.soundUtils.PlaySound;

public class Ball extends Actor {
	protected int vx;
	protected int vy;
	PuntoAltaPrecision coordenadas=new PuntoAltaPrecision(this.x,this.y);
	private TrayectoriaRecta trayectoria = null;

	
	public Ball(int x, int y) {
		super();
		setSpriteNames( new String[] {"ballGrey.png"});
		setFrameSpeed(35);
		this.x=x;
		this.y=y;
	}
	
	public void act(int yplayer, int xplayer) {
		super.act();
		if (trayectoria == null) {
			trayectoria = new TrayectoriaRecta(2.8f,coordenadas,false);
		}
		coordenadas = trayectoria.getPuntoADistanciaDePunto(coordenadas, 3);
		x=(int) coordenadas.x;
		y=(int) coordenadas.y;
		// calcular rebote lados
		if (x < 0 || x > Arkanoid.WIDTH-18 ) { 
			trayectoria.reflejarHorizontalmenteRespectoAPunto(coordenadas);
		}
		// calcular rebote con fin del juego abajo
		if (y > Arkanoid.HEIGHT) { 
			Arkanoid.getInstance().setMenu(1);
			Arkanoid.gameOver=1;
		}
		//Colision de la bola con la nave
		Rectangle rectplayer = new Rectangle(xplayer,yplayer, 104, 24); // dimension nave
		Rectangle rectball = new Rectangle(this.x, this.y, 22,22);
		if(rectball.intersects(rectplayer)) {
			trayectoria.reflejarVerticalmenteRespectoAPunto(coordenadas);
			CacheRecursos.getInstancia().playSonido("woosh.wav");

		}
	}
	//Colisiona (con ladrillos)
	public void collisioned() {
		trayectoria.reflejarVerticalmenteRespectoAPunto(coordenadas);
		CacheRecursos.getInstancia().playSonido("woosh.wav");

	}
    
	
	
	
	/* (non-Javadoc)
	 * @see Arkanoid.Actor#setX(int)
	 */
	@Override
	public void setX(int i) {
		super.setX(i);
		this.coordenadas.x = i;
	}

	/* (non-Javadoc)
	 * @see Arkanoid.Actor#setY(int)
	 */
	@Override
	public void setY(int i) {
		super.setY(i);
		this.coordenadas.y = i;
	}

	//getter and setters
	public int getVx() { return vx; }
	public void setVx(int i) {vx = i;	}
	public int getVy() { return vy; }
	public void setVy(int i) {vy = i;	}
}
