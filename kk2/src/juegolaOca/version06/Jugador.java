package juegolaOca.version06;

import javax.swing.JOptionPane;

public class Jugador {   
	private String nombre;
	private Casilla casilla;

	/**
	 * 
	 */
	public Jugador() {
		super();
	}
	
	/**
	 * @param nombre
	 * @param posicion
	 */
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
		this.casilla = Tablero.getPrimeraCasillaEnTablero();
	}
	
	
	/**
	 * 
	 */
	public void tirarDado () {
		// Imprimo en la consola la casilla, antes del movimiento		
		System.out.println(this.casilla);

		// Utilizamos el azar para conseguir un dado virtual
		int dado = (int) Math.round(Math.random()*(6-1)+1);
		System.out.println("\tDado: " + dado); 

		this.casilla = Tablero.getCasillaDestino(this.casilla, dado);
		//		JOptionPane.showMessageDialog(null, "alto");
		
	}
	

	/**
	 * 
	 * @return
	 */
	public boolean isTerminado () {
		if (this.casilla.equals(Tablero.getUltimaCasillaEnTablero())) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the casilla
	 */
	public Casilla getCasilla() {
		return casilla;
	}

	/**
	 * @param casilla the casilla to set
	 */
	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}

	
}
