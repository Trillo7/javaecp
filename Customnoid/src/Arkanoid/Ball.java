package Arkanoid;

import java.awt.Rectangle;

import Arkanoid.soundUtils.PlaySound;

public class Ball extends Actor {
	private float vspeed;
	PuntoAltaPrecision coordenadas=new PuntoAltaPrecision(this.x,this.y);
	public TrayectoriaRecta trayectoria = null;
	
	public Ball(int x, int y, float vspeed) {
		super();
		setSpriteNames( new String[] {"ballGrey.png"});
		setFrameSpeed(35);
		this.x=x;
		this.y=y;
		this.vspeed=vspeed;
	}
	
	public void act(Player player) {
		super.act();		//Velocidad maxima, que va aumentando
		if(vspeed <= 7.3) {
			vspeed+=0.002;
		}
		if (trayectoria == null) {
			trayectoria = new TrayectoriaRecta(2.8f,coordenadas,false);
		}
		//System.out.println("ball speed: "+vspeed);
		coordenadas = trayectoria.getPuntoADistanciaDePunto(coordenadas, vspeed);
		x=(int) coordenadas.x;
		y=(int) coordenadas.y;
		// Calcular rebote lados
		if (x < 0 ) { 
			trayectoria.reflejarHaciaDerecha(coordenadas);
		}
		if (x > Arkanoid.WIDTH-18 ) { 
			trayectoria.reflejarHaciaIzquierda(coordenadas);
		}
		// Calcular rebote techo
		if (y < 0) { 
			trayectoria.reflejarHaciaAbajo(coordenadas);
		}
		// calcular rebote con fin del juego abajo
		if (this.y > Arkanoid.HEIGHT) { 
			if(player.lives<=0) {
				Arkanoid.getInstance().startGameOver();
			}else {
				if(Arkanoid.getInstance().godmode) {
					PlaySound.getSound().startSound("holy-soundcut.wav");
				}else {
					player.lives--;
	        		player.myscore+=-25;
				}
			}
			trayectoria.reflejarVerticalmenteRespectoAPunto(coordenadas);		
		}
		// Colision de la bola con la nave
		Rectangle rectplayer = new Rectangle(player.x,player.y, player.width, player.height); // dimension nave
		Rectangle rectball = new Rectangle(this.x, this.y, 22,22);
		if(rectball.intersects(rectplayer)) {
			// Para que la nave cambie de color al rebotar en ella
			Player.hit=true;
			Arkanoid.hitTime=System.currentTimeMillis();
			// Detector de colision en que lado
			Rectangle playersup = new Rectangle(player.x,player.y, player.width, 2); // dimension nave
			Rectangle playerder = new Rectangle(player.x+player.width,player.y, 2, player.height); 
			Rectangle playerizq = new Rectangle(player.x,player.y, 2, player.height); 
			Rectangle playerinf = new Rectangle(player.x,player.y+player.height, player.width, 2); 
			if(rectball.intersects(playersup)) {
				trayectoria.reflejarHaciaArriba(coordenadas);
			}else if(rectball.intersects(playerder)) {
				trayectoria.reflejarHaciaDerecha(coordenadas);
			}else if(rectball.intersects(playerizq)) {
				trayectoria.reflejarHaciaIzquierda(coordenadas);
			}else if(rectball.intersects(playerinf)) {
				trayectoria.reflejarHaciaAbajo(coordenadas);
			}		
			CacheRecursos.getInstancia().playSonido("woosh.wav");
		}
		// Fin colision de bola con nave
	}
	
	//Colisiona (con ladrillos)
	public void collisioned(String hitSide) {
		CacheRecursos.getInstancia().playSonido("woosh.wav");
		// Para detectar donde hemos colisionado
		if(hitSide=="sup") {
			trayectoria.reflejarHaciaArriba(coordenadas);
			System.out.println("Hacia arriba");
		}else if(hitSide=="der") {
			trayectoria.reflejarHaciaDerecha(coordenadas);
			System.out.println("Hacia derecha");
		}else if(hitSide=="izq") {
			trayectoria.reflejarHaciaIzquierda(coordenadas);
			System.out.println("Hacia izquierda");
		}else if(hitSide=="inf") {
			trayectoria.reflejarHaciaAbajo(coordenadas);
			System.out.println("Hacia abajo");
		}
		
	}
    
	/* (non-Javadoc)
	 * @see Arkanoid.Actor#setX(int)
	 */
	
	@Override
	public void setX(int i) {
		super.setX(i);
		this.coordenadas.x = i;
	}

	public float getVspeed() {
		return vspeed;
	}

	public void setVspeed(float vspeed) {
		this.vspeed = vspeed;
	}

	/* (non-Javadoc)
	 * @see Arkanoid.Actor#setY(int)
	 */
	@Override
	public void setY(int i) {
		super.setY(i);
		this.coordenadas.y = i;
	}

}
