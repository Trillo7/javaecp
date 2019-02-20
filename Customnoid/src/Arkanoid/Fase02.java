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
	public static final int[][]  arraymap={	{1,0,1,2,0,2,3,3,0,2,2,2},
											{4,0,1,2,0,2,3,0,3,2,0,0},
											{1,4,1,2,0,2,3,4,0,2,2,0},
											{1,0,4,2,0,2,3,0,3,2,0,0},
											{1,0,1,0,2,0,3,3,3,2,2,2}};
	private int initX=7;
	private int initY=7;

	
	
	/**
	 * Inicializaci�n de la fase, es la implementaci�n de un m�todo abstracto en el supertipo
	 */
	@Override
	public void inicializaFase() {
		
		maxPills=5;
		for (int i = 0; i < arraymap.length; i++) {
		    for (int j = 0; j < arraymap[i].length; j++) {
		    	if(arraymap[i][j]!=0) {
			    	Brick l = new Brick(arraymap[i][j]);
			    	l.setX(initX);
			    	l.setY(initY);
					actors.add(l);
					if(arraymap[i][j]==6) {
						numIrrompibles++;
					}
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
		return "stormsound.wav";
	}


	@Override
	public String getBackgroundImg() {
		// TODO Auto-generated method stub
		return "skycloudbg.png";
	}
	
}
