package Arkanoid;

import java.awt.Color;

/**
 * Clase que implementa la primera fase del juego
 * @author R
 *
 */
public class Fase02 extends Fase {
	// Propiedades est�ticas de la fase
	public static final int[][]  arraymap={	{0,0,0,4,5,6,6,6,6,4,5,0,0},
											{0,2,3,4,1,2,3,5,5,5,0,0,0},
											{0,2,3,4,5,6,2,3,4,5,6,0,0},
											{0,0,0,0,5,2,1,2,3,5,6,0,0},
											{0,0,0,4,0,0,0,0,0,0,4,0,0},
											{0,0,3,0,0,0,0,0,2,0,2,5,6}};
	private int initX=5;
	private int initY=10;
	
	/**
	 * Inicializaci�n de la fase, es la implementaci�n de un m�todo abstracto en el supertipo
	 */
	@Override
	public void inicializaFase() {

		// Creamos Bricks verdes
//		for (int i = 0; i < 12; i++){
//		  Brick l = new Brick(3);
//		  l.setX(5+(i * 58) );
//		  l.setY(10);
//		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
//		  actors.add(l);
//		}
//		// creamos Bricks azules
//		for (int i = 0; i < 12; i++){
//		  Brick l = new Brick(5);
//		  l.setX(5+(i * 58) );
//		  l.setY(50);
//		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
//		  actors.add(l);
//		}
		
		for (int i = 0; i < arraymap.length-1; i++) {
		    for (int j = 0; j < arraymap[i].length-1; j++) {
		    	System.out.println("crea ladrillo"+arraymap[i][j]);
		    	Brick l = new Brick(arraymap[i][j]);
		    	l.setX(initX+(i*58));
		    	l.setY(initY);
				actors.add(l);
		    }
		    initY+=40;
		}
		
	}

}
