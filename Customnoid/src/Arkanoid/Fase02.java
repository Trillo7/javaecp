package Arkanoid;

import java.awt.Color;

import Arkanoid.Brick;

/**
 * Clase que implementa la primera fase del juego
 * @author R
 *
 */
public class Fase02 extends Fase {
	// Propiedades est�ticas de la fase
	public static final int[][]  arraymap={	{1,0,1,2,0,2,4,4,4,2,2,2},
											{1,0,1,2,0,2,4,0,4,2,0,0},
											{1,1,1,2,0,2,4,4,4,2,2,0},
											{1,1,1,2,0,2,4,0,4,2,0,0},
											{1,0,1,0,2,0,4,4,4,2,2,2}};
	private int initX=7;
	private int initY=7;
	private int lcount=0;
	
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
		
		for (int i = 0; i < arraymap.length; i++) {
		    for (int j = 0; j < arraymap[i].length; j++) {
		    	if(arraymap[i][j]!=0) {
			    	Brick l = new Brick(arraymap[i][j]);
			    	l.setX(initX);
			    	l.setY(initY);
					actors.add(l);
		    	}
		    	initX+=57;
		    }
		    initX=7;
		    initY+=38;
		}
		
	}
	
	@Override
	public String getGameplaySound() {
		// TODO Auto-generated method stub
		return super.getGameplaySound();
	}


	@Override
	public String getBackgroundImg() {
		// TODO Auto-generated method stub
		return super.getBackgroundImg();
	}
	
}
