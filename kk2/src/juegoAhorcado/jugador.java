package juegoAhorcado;

public class jugador {
	private String nombreJugador;
	private String palabraJugador;
	private int numintentos=0;
	private static jugador elJugador = null;
	
	
	/**
	 * 
	 */
	public jugador() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the numintentos
	 */
	public int getNumintentos() {
		return numintentos;
	}


	/**
	 * @param numintentos the numintentos to set
	 */
	public void setNumintentos(int numintentos) {
		this.numintentos = numintentos;
	}


	/**
	 * @param nombreJugador
	 * @param palabraJugador
	 */
	public jugador(String nombreJugador, String palabraJugador) {
		super();
		this.nombreJugador = nombreJugador;
		this.palabraJugador = palabraJugador;
	}


	/**
	 * @return the nombreJugador
	 */
	public String getNombreJugador() {
		return nombreJugador;
	}




	/**
	 * @param nombreJugador the nombreJugador to set
	 */
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	/**
	 * @return the palabraJugador
	 */
	public String getPalabraJugador() {
		return palabraJugador;
	}


	/**
	 * @param palabraJugador the palabraJugador to set
	 */
	public void setPalabraJugador(String palabraJugador) {
		this.palabraJugador = palabraJugador;
	}

	//singleton
	public static jugador getJugador() {
		if (elJugador == null) {
			elJugador = new jugador();
		}
		return elJugador;
	}
	
	
}
