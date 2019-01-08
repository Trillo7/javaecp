package tresenraya;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Celda {
	
	private int x, y;
	private Jugador jugador = null;
	private Ventana ventana = null;
	private boolean moving = false;
	public static final int LADO = 200;
	public static final int PADDING = 10;
	
	public Celda (int x, int y, Ventana ventana) {
		this.x = x;
		this.y = y;
		this.ventana = ventana;
	}

	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		g.setColor((this.moving)? Color.YELLOW : Color.WHITE);
		g.fillRect(this.x, this.y, LADO, LADO);
		
		if (this.jugador != null) {
			this.jugador.paint(g, this.x, this.y);
		}
	}
	
	
	
	public boolean isEnCoordenadas(int xPunto, int yPunto) {
		if (xPunto > this.x && xPunto < (this.x + LADO) 
				&&
				yPunto > this.y && yPunto < (this.y + LADO)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 */
	public void mouseClicked () {
		
		if (this.jugador != null && !this.jugador.equals(Principal.getJugadorTurnoActivo())) {
			JOptionPane.showMessageDialog(null, "Esta casilla no te pertenece");
			return;
		}
		
		if (this.jugador != null) {
			this.moving = !moving;
		}
		
		this.jugador = Principal.getJugadorTurnoActivo();

		Matriz.getInstance().getMatriz()[this.y/LADO][this.x/LADO] = this.jugador.getCodigo();
		Matriz.getInstance().print();
		System.out.println();
		
		Principal.avanzaTurno();
		
		ventana.revalidate();
		ventana.repaint();
		
		if (Matriz.getInstance().isJuegoTerminado()) {
			JOptionPane.showMessageDialog(null, "Juego Terminado");
		}
	}
	
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	
	
}
