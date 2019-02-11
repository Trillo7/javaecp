package Arkanoid;

import java.awt.Color;

/**
 * Clase que implementa la primera fase del juego
 * @author R
 *
 */
public class Fase01 extends Fase {
	// Propiedades est�ticas de la fase
	public static final int ESPACIO_SUPERIOR_SOBRE_LADRILLOS = 60;

	
	/**
	 * Inicializaci�n de la fase, es la implementaci�n de un m�todo abstracto en el supertipo
	 */
	@Override
	public void inicializaFase() {

//		// Creamos Bricks verdes
//		for (int i = 0; i < 12; i++){
//		  Brick l = new Brick("green",1);
//		  l.setX(5+(i * 58) );
//		  l.setY(10);
//		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
//		  actors.add(l);
//		}
//		// creamos Bricks azules
//		for (int i = 0; i < 12; i++){
//		  Brick l = new Brick("blue",1);
//		  l.setX(5+(i * 58) );
//		  l.setY(50);
//		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
//		  actors.add(l);
//		}
//		
//		for (int i = 0; i < 12; i++){
//		  Brick l = new Brick("grey",1);
//		  l.setX(5+(i * 58) );
//		  l.setY(90);
//		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
//		  actors.add(l);
//		}
//		for (int i = 0; i < 12; i++){
//		  Brick l = new Brick("purple",1);
//		  l.setX(5+(i * 58) );
//		  l.setY(130);
//		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
//		  actors.add(l);
//		}
//		for (int i = 0; i < 12; i++){
//		  Brick l = new Brick("red",1);
//		  l.setX(5+(i * 58) );
//		  l.setY(170);
//		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
//		  actors.add(l);
//		}
		for (int i = 0; i < 1; i++){
		  Brick l = new Brick("yellow",1);
		  l.setX(195+(i * 58) );
		  l.setY(210);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
	}

}
