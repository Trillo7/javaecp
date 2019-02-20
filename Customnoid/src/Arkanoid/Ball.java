package Arkanoid;

import java.awt.Rectangle;

import Arkanoid.soundUtils.PlaySound;

public class Ball extends Actor {
	private float vspeed;
	// La bola se moverá en una determinada recta (trayectoria) con una determinada velocidad
	public TrayectoriaRecta trayectoria = null;
	// Para el control preciso del aumento de la velocidad de la bola constante utilizo unas coordenadas flotantes
	// aunque eso no quita que sigan existiendo las coordenades x e y del supertipo Actor. De hecho, cada vez que
	// actualizamos las coordenadas flotantes también actualizaré las coordenadas enteras.
	private PuntoAltaPrecision coordenadas = null;
	private static final float maxSpeed = 7.3f;

	public Ball(int x, int y, float vspeed) {
		super();
		setSpriteNames( new String[] {"ballGrey.png"});
		setFrameSpeed(35);
		this.coordenadas = new PuntoAltaPrecision(x, y);
		this.x=x;
		this.y=y;
		this.vspeed=vspeed;
	}
	
	public void act(Player player) {
		super.act();		//Velocidad maxima, que va aumentando
		if(vspeed <= maxSpeed) {
			vspeed+=0.002;
		}
		if (trayectoria == null) {
			this.iniciarMovimiento(-1, -1);
		}
		//System.out.println("ball speed: "+vspeed);
		// Calculo del nuevo punto de la trayectoria de la bola
		PuntoAltaPrecision nuevoPuntoEnLaTrayectoria = this.trayectoria.getPuntoADistanciaDePunto(this.coordenadas, this.vspeed);
		this.coordenadas = nuevoPuntoEnLaTrayectoria;
		// Actualizo las coordenadas enteras del supertipo Actor, ya que es conforme a estas con las que se pinta en pantalla
		// y se detectan las colisiones.
		this.x = Math.round(this.coordenadas.x);
		this.y = Math.round(this.coordenadas.y);
		
		// Calcular rebote LADOS
		if (x < 0 ) { 
			trayectoria.reflejarHaciaDerecha(coordenadas);
		}
		if (x > Arkanoid.WIDTH-18 ) { 
			trayectoria.reflejarHaciaIzquierda(coordenadas);
		}
		// Calcular rebote TECHO
		if (y < 0) { 
			trayectoria.reflejarHaciaAbajo(coordenadas);
		}
		// Calcular fin juego rebote SUELO
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
			if(!Arkanoid.getInstance().godmode) {
				trayectoria=null;
				this.setX(player.getX()+40);
				this.setY(player.getY()-24);
				Arkanoid.initPauseTime=System.currentTimeMillis(); // Porque si no initPause lo quita al instante
				Arkanoid.getInstance().setInitPause(true);
			}

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
    
	/**
	 * Principio del movimiento de la bola
	 * @param xDestino
	 * @param yDestino
	 */
	private void iniciarMovimiento (int xDestino, int yDestino) {
		if (trayectoria == null) {
			// Si los valores del punto de destino son "-1" indica ue debemos hacer una trayectoria por defecto
			if (xDestino == -1 && yDestino == -1) {
				this.trayectoria = new TrayectoriaRecta(-3f, this.coordenadas, true);
			}
			// En caso contrario debemos trazar la trayectoria desde el punto actual de la bola hasta el punto
			// que nos indican
			else {
				// Establecemos una mínima distancia en el eje X entre la situación de la bola y el punto que nos
				// indican. De esa manera evitamos que la pelota se pueda poner completamente vertical
				int minimaDistanciamientoEntreX = 20;
				if (Math.abs(xDestino - this.getX()) < minimaDistanciamientoEntreX) {
					// Trayectoria a derecha
					if (xDestino < this.getX()) {
						xDestino = this.getX() - minimaDistanciamientoEntreX;
					}
					else {
						// Trayectoria a izquierda
						xDestino = this.getX() + minimaDistanciamientoEntreX;
					}
				}
				// Determinamos la dirección a seguir en la trayectoria en función del signo de la pendiente que 
				// esperamos
				boolean direccionCreciente = (xDestino > this.getX())? true : false;
				// Creamos la trayectoria.
				this.trayectoria = new TrayectoriaRecta(new PuntoAltaPrecision(this.x, this.y), new PuntoAltaPrecision(xDestino, yDestino), direccionCreciente);
			}
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
