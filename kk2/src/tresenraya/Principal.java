package tresenraya;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.naming.InitialContext;
import javax.swing.JOptionPane;

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
		String str = JOptionPane.showInputDialog("Nombre del jugador 1: ");
		jugadores[0] = new Jugador (str, 1) {
			@Override
			public void paint(Graphics g, int offsetX, int offsetY) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setStroke(GuiUtil.STROKE);
				g2d.setColor(Color.blue);
				g2d.drawLine(offsetX + Celda.PADDING, offsetY + Celda.PADDING, offsetX + Celda.LADO - Celda.PADDING, offsetY + Celda.LADO - Celda.PADDING);
				g2d.drawLine(offsetX + Celda.LADO - Celda.PADDING, offsetY + Celda.PADDING, offsetX + Celda.PADDING, offsetY + Celda.LADO - Celda.PADDING);
			}
		};
		str = JOptionPane.showInputDialog("Nombre del jugador 2: ");
		jugadores[1] = new Jugador (str, 2) {
			@Override
			public void paint(Graphics g, int offsetX, int offsetY) {
				g.setColor(Color.pink);
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
			JOptionPane.showMessageDialog(null, "Le tocal al jugador "+jugadores[1].getNombre());
		}
		else {
			indiceJugadorActivo = 0;
			JOptionPane.showMessageDialog(null, "Le tocal al jugador "+jugadores[0].getNombre());

		}
	}
}
