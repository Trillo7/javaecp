package juegoAhorcado;

import javax.swing.JOptionPane;

public class jugador {
	private String nombreJugador;
	public String palabraJugador;
	private int numintentos=6;
	private static jugador elJugador = null;
	private String palabrasFallidas="";
	private int hint=0;
	private int godmodeStatus=0;
	private int rondas=1;
	private int cambiotemporada=0;  // para saber si es un nuevo cambio
	
	public jugador() {
		super();
		// TODO Auto-generated constructor stub
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

	public void pidePalabraJugador() {
		int controlPista=0;
		// Pide palabra y la inserta en su jugador
		String palabraJugador=JOptionPane.showInputDialog("Introduce una letra o una palabra: ");
		jugador.getJugador().setPalabraJugador(palabraJugador);
		
		//comprobamos si vamos a hacer el cambio de temporada
		if(palabraJugador.equals("oeste")||palabraJugador.equals("navidad")||palabraJugador.equals("verano")) {
			jugador.getJugador().setCambiotemporada(1);
			Ventana.getVentana().setTemporada(palabraJugador);
			jugador.getJugador().setPalabraJugador(baseMuneco.getJuego().getPalabraElegida()); // le damos la victoria para que el juego acabe y empieze de nuevo con la nueva temporada
		}
		// Comprobamos si es algun evento especial
		if(palabraJugador.equals("godmode")) {
			jugador.getJugador().setGodmodeStatus(1);
		}
		if(palabraJugador.equals("hint")&& jugador.getJugador().getHint()==0) {
			palabraJugador=""; // vaciamos el hint introducido por jugador, y para que no de error al juntar con separadas
			int randomPista=1;
			while(controlPista ==0 ) {
				randomPista=(int) Math.round(Math.random() * ((baseMuneco.getJuego().getPalabraElegida().length()) - 0) + 0);
				if(baseMuneco.getJuego().getPalRellenar()[randomPista]=='_') {
					baseMuneco.getJuego().getPalRellenar()[randomPista]=palabra.getPalabras().getSeparadas()[randomPista];
					if(jugador.getJugador().getGodmodeStatus()==0) {
						jugador.getJugador().setNumintentos(jugador.getJugador().getNumintentos()-1); // quitamos un intento pues ha usado hint
					}
					controlPista=1; // control repeticion, para que elija una letra aleatoria no adivinada
					jugador.getJugador().setHint(1); // para que el jugador no pueda usar mas pistas
				}
			}
			// en la palabra del jugador metemos una letra correcta elegida
			palabraJugador+=palabra.getPalabras().getSeparadas()[randomPista];
		}
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
	 * @return the hint
	 */
	public int getHint() {
		return hint;
	}


	/**
	 * @param hint the hint to set
	 */
	public void setHint(int hint) {
		this.hint = hint;
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
	
	/**
	 * @return the palabrasFallidas
	 */
	public String getPalabrasFallidas() {
		return palabrasFallidas;
	}


	/**
	 * @param palabrasFallidas the palabrasFallidas to set
	 */
	public void setPalabrasFallidas(String palabrasFallidas) {
		this.palabrasFallidas = palabrasFallidas;
	}

	
	public int getGodmodeStatus() {
		return godmodeStatus;
	}


	public void setGodmodeStatus(int godmodeStatus) {
		this.godmodeStatus = godmodeStatus;
	}


	public int getRondas() {
		return rondas;
	}


	public void setRondas(int rondas) {
		this.rondas = rondas;
	}
	
	
	/**
	 * @return the cambiotemporada
	 */
	public int getCambiotemporada() {
		return cambiotemporada;
	}


	/**
	 * @param cambiotemporada the cambiotemporada to set
	 */
	public void setCambiotemporada(int cambiotemporada) {
		this.cambiotemporada = cambiotemporada;
	}


	//singleton
	public static jugador getJugador() {
		if (elJugador == null) {
			elJugador = new jugador();
		}
		return elJugador;
	}
	
	
}
