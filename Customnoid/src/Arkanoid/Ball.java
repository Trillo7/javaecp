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
		if(vspeed <= 7) {
			vspeed+=0.002;
		}
		if (trayectoria == null) {
			trayectoria = new TrayectoriaRecta(2.8f,coordenadas,false);
		}
		coordenadas = trayectoria.getPuntoADistanciaDePunto(coordenadas, vspeed);
		x=(int) coordenadas.x;
		y=(int) coordenadas.y;
		// calcular rebote lados
		if (x < 0 || x > Arkanoid.WIDTH-18 ) { 
			trayectoria.reflejarHorizontalmenteRespectoAPunto(coordenadas);
		}
		// calcular rebote techo
		if (y < 0) { 
			trayectoria.reflejarHaciaAbajo(coordenadas);
		}
		// calcular rebote con fin del juego abajo
		// FIN DEL JUEGO
		if (y > Arkanoid.HEIGHT) { 
			if(player.lives<=0) {
				Arkanoid.getInstance().setMenu(1);
				Arkanoid.gameOver=true;
				PlaySound.getSound().startSound("long-bowser.wav");
				PlaySound.getSound().stopcustomLoop();
				PlaySound.getSound().customLoop("rex-nosferatu.wav");
			}else {
				player.lives--;
        		player.myscore+=-25;
				trayectoria.reflejarVerticalmenteRespectoAPunto(coordenadas);
			}
		
		}
		// Colision de la bola con la nave
		Rectangle rectplayer = new Rectangle(player.x,player.y, player.width, player.height); // dimension nave
		Rectangle rectball = new Rectangle(this.x, this.y, 22,22);
		if(rectball.intersects(rectplayer)) {
			Player.hit=true;// para que la nave cambie de color al rebotar
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
			
			
			//trayectoria.reflejarVerticalmenteRespectoAPunto(coordenadas);
		
			CacheRecursos.getInstancia().playSonido("woosh.wav");
		}
	}
	
	//Colisiona (con ladrillos)
	public void collisioned(String hitSide) {
		CacheRecursos.getInstancia().playSonido("woosh.wav");
		// Para detectar donde hemos colisionado
		if(hitSide=="sup") {
			trayectoria.reflejarHaciaArriba(coordenadas);
		}else if(hitSide=="der") {
			trayectoria.reflejarHaciaDerecha(coordenadas);
		}else if(hitSide=="izq") {
			trayectoria.reflejarHaciaIzquierda(coordenadas);
		}else if(hitSide=="inf") {
			trayectoria.reflejarHaciaAbajo(coordenadas);
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
