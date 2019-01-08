package tresenraya;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.naming.InitialContext;

public class Principal {
	
	private static Jugador jugadores[] = new Jugador[2];
	private static int indiceJugadorActivo = 0;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ventana ventana = new Ventana();
		
		initJugadores();
		
	}

	
	/**
	 * 
	 */
	private static void initJugadores () {
		jugadores[0] = new Jugador ("Sandra", 1) {
			@Override
			public void paint(Graphics g, int offsetX, int offsetY) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setStroke(GuiUtil.WIDE_STROKE);
				g2d.setColor(Color.gray);
				g2d.drawLine(offsetX + Celda.PADDING, offsetY + Celda.PADDING, offsetX + Celda.LADO - Celda.PADDING, offsetY + Celda.LADO - Celda.PADDING);
				g2d.drawLine(offsetX + Celda.LADO - Celda.PADDING, offsetY + Celda.PADDING, offsetX + Celda.PADDING, offsetY + Celda.LADO - Celda.PADDING);
			}
		};
		
		jugadores[1] = new Jugador ("Rafa", 2) {
			@Override
			public void paint(Graphics g, int offsetX, int offsetY) {
				g.setColor(Color.gray);
				g.fillOval(offsetX + Celda.PADDING, offsetY + Celda.PADDING, Celda.LADO - 2 * Celda.PADDING, Celda.LADO - 2 * Celda.PADDING);
			}
		};
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Jugador getJugadorTurnoActivo () {
		return jugadores[indiceJugadorActivo];
	}
	
	/**
	 * 
	 */
	public static void avanzaTurno () {
		if (indiceJugadorActivo == 0) {
			indiceJugadorActivo = 1;
		}
		else {
			indiceJugadorActivo = 0;
		}
	}
}
