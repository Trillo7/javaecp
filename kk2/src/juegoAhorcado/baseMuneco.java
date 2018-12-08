package juegoAhorcado;

public class baseMuneco {
	private String palabraElegida=null;
	private static baseMuneco juego = null;
	private char palRellenar[]=new char[1000]; // palabraRellenar es el array del juego, _ _ _ que se usa luego para sustituir al acertar la palabra _ j e m _ l o 

	public baseMuneco() {
		super();
	}

	public baseMuneco(String palabraElegida, int numintentos) {
		super();
		this.palabraElegida = palabraElegida;
	}

	public void cargaJuego() {
		// TODO Auto-generated method stub
		palabra.getPalabras().generaPalabra();
		// Separamos la palabra en char
		palabra.getPalabras().separar();
		muestraEstado();
	}
	
	public void muestraEstado() {
		int vidas=jugador.getJugador().getNumintentos();
		String formaPalabraJuego="";
		// Juntamos el array de palabra _ _ _ (adivinacion actual) para setearla en Ventana como String
		for(int i=0;i<baseMuneco.getJuego().getPalabraElegida().length();i++) {
			formaPalabraJuego+=palRellenar[i]+" ";
		}
		Ventana.getVentana().setPalabraAdivinar(formaPalabraJuego); // mandamos cada vez la palabra formada
		//System.out.println(formaPalabraJuego);
		Ventana.getVentana().repaint();
	}
	
	public void iniciaJugada() {
		do {
			int acierto=0;
			jugador.getJugador().pidePalabraJugador();
			// Juego normal. Comprobamos si la letra es correcta
			// Procesamos según sea palabra o letra
			if(jugador.getJugador().getPalabraJugador().length()>1) {
				if(jugador.getJugador().getPalabraJugador().equals(this.palabraElegida)) {
					acierto=1;
				}
			}else {
				for(int i=0;i<this.palabraElegida.length();i++) {
					char arrayPalabras[]=palabra.getPalabras().getSeparadas();
					if(jugador.getJugador().getPalabraJugador().charAt(0)==arrayPalabras[i]) {
						palRellenar[i]=palabra.getPalabras().getSeparadas()[i];
						acierto=1;
					}
				}
			}
			//Quitamos intento si has fallado
			if(acierto==0) {
				if(jugador.getJugador().getGodmodeStatus()==0) {
					jugador.getJugador().setNumintentos(jugador.getJugador().getNumintentos()-1); // quitamos un intento pues ha usado hint
				}
				if(jugador.getJugador().getPalabraJugador().length()>1 /**&& !palabraJugador.equals("verano")*/) {
					jugador.getJugador().setPalabrasFallidas(jugador.getJugador().getPalabrasFallidas()+jugador.getJugador().getPalabraJugador()+" ");
				}else {
					jugador.getJugador().setPalabrasFallidas(jugador.getJugador().getPalabrasFallidas()+jugador.getJugador().getPalabraJugador().charAt(0)+" ");
				}
			}
			// Si fallas por una palabra de cambio de temporada devolvemos 1 intento
			if(acierto==0 &&( jugador.getJugador().getPalabraJugador().equals("oeste") ||jugador.getJugador().getPalabraJugador().equals("navidad") ||jugador.getJugador().getPalabraJugador().equals("verano"))) {
				Ventana.getVentana().setTemporada(jugador.getJugador().getPalabraJugador());
				jugador.getJugador().setNumintentos(jugador.getJugador().getNumintentos()+1);
			}
			acierto=0;
			muestraEstado();
		}while(!isTerminado()&& jugador.getJugador().getNumintentos()>0); // Terminamos al acertar la palabra
	
		// Al acabar el juego, mostramos dependiendo si por victoria o por derrota (Actualmente solo se utiliza para pintar la cara pues fue cambiado)
		if(jugador.getJugador().getNumintentos()>=1) {
			Ventana.getVentana().setTextoFinal("Victoria");			
		}else {
			Ventana.getVentana().setTextoFinal("Has muerto");
		}
		// Al acabar el juego sustituimos los atinos _ por la palabra entera y mostramos la ventana emergente
		Ventana.getVentana().setPalabraAdivinar(palabraElegida);
		VentanaEmergente.muestraVentanaEmergente("");
	}
	
	public boolean isTerminado () { // si la palabra introducida por el jugador es igual a la Elegida, isterminado es trues
		if (jugador.getJugador().getPalabraJugador().equals(getPalabraElegida())) {
			return true;
		}
		return false;
	}

	/**
	 * @return the palabraElegida
	 */
	public String getPalabraElegida() {
		return palabraElegida;
	}

	/**
	 * @param palabraElegida the palabraElegida to set
	 */
	public void setPalabraElegida(String palabraElegida) {
		this.palabraElegida = palabraElegida;
	}

	/**
	 * @return the palRellenar
	 */
	public char[] getPalRellenar() {
		return palRellenar;
	}

	/**
	 * @param palRellenar the palRellenar to set
	 */
	public void setPalRellenar(char[] palRellenar) {
		this.palRellenar = palRellenar;
	}
	
	// Single-ton de base Muneco
		public static baseMuneco getJuego() {
			if (juego == null) {
				juego = new baseMuneco();
			}
			return juego;
		}
	
	
	
}
