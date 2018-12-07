package juegoAhorcado;

import javax.swing.JOptionPane;

public class baseMuneco {
	private String palabraElegida=null;
	private static baseMuneco juego = null;
	private char palRellenar[]=new char[1000]; // es el array del juego, _ _ _ que se usa luego para sustituir al acertar la palabra _ j e m _ l o 

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

	public baseMuneco() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param palabraElegida
	 * @param numintentos
	 */
	public baseMuneco(String palabraElegida, int numintentos) {
		super();
		this.palabraElegida = palabraElegida;
	}

	public void cargaJuego() {
		// TODO Auto-generated method stub
		// Creamos el String de las palabras
		String bdPalabras []= new String [] {"libreria","mayordomo","paleta","serrucho","bate","pelota","futbol","baloncesto","ordenador","juego","trabajo","nuclear","uniforme","avion","coche"};
		int randElige=(int) Math.round(Math.random() * ((bdPalabras.length-1) - 0) + 0);
		this.setPalabraElegida(bdPalabras[randElige]);
		System.out.println(this.palabraElegida); // Mostramos la palabra seleccionada (trampa)
		System.out.println(""); // salto de linea
		for(int i=0;i<bdPalabras[randElige].length();i++) {
			palRellenar[i]='_';
		}
		// Recargamos los intentos
		//jugador.getJugador().setNumintentos(6);
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
		System.out.println(formaPalabraJuego);
		Ventana.getVentana().setPalabraAdivinar(formaPalabraJuego);
		System.out.println(""); // salto de linea
		System.out.println("Vidas: "+vidas);
		Ventana.getVentana().repaint();
		
	}
	
	public void iniciaJugada() {
		do {
			int acierto=0;
			int pista=0;
			// Pide palabra y la inserta en su jugador
			String palabraJugador=JOptionPane.showInputDialog("Introduce una letra o una palabra: ");
			jugador.getJugador().setPalabraJugador(palabraJugador);
			
			// Comprobamos si es algun evento especial
			if(palabraJugador.equals("godmode")) {
				jugador.getJugador().setGodmodeStatus(1);
			}
			if(palabraJugador.equals("hint")&& jugador.getJugador().getHint()==0) {
				palabraJugador=""; // vaciamos el hint introducido por jugador, y para que no de error al juntar con separadas
				int randomPista=1;
				while(pista ==0 ) {
					randomPista=(int) Math.round(Math.random() * ((this.palabraElegida.length()) - 0) + 0);
					if(palRellenar[randomPista]=='_') {
						palRellenar[randomPista]=palabra.getPalabras().getSeparadas()[randomPista];
						if(jugador.getJugador().getGodmodeStatus()==0) {
							jugador.getJugador().setNumintentos(jugador.getJugador().getNumintentos()-1); // quitamos un intento pues ha usado hint
						}
						pista=1; // control repeticion, para que elija una letra aleatoria no adivinada
						jugador.getJugador().setHint(1); // para que el jugador no pueda usar mas pistas
					}
				}
				palabraJugador+=palabra.getPalabras().getSeparadas()[randomPista];
			}
			// Juego normal. Comprobamos si la letra es correcta
			// Procesamos según sea palabra o letra
			if(palabraJugador.length()>1) {
				if(palabraJugador.equals(this.palabraElegida)) {
					acierto=1;
				}
			}else {
				for(int i=0;i<this.palabraElegida.length();i++) {
					char arrayPalabras[]=palabra.getPalabras().getSeparadas();
					if(palabraJugador.charAt(0)==arrayPalabras[i]) {
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
				if(palabraJugador.length()>1 /**&& !palabraJugador.equals("verano")*/) {
					jugador.getJugador().setPalabrasFallidas(jugador.getJugador().getPalabrasFallidas()+palabraJugador+" ");
				}else {
					jugador.getJugador().setPalabrasFallidas(jugador.getJugador().getPalabrasFallidas()+palabraJugador.charAt(0)+" ");
				}
			}
			// Si fallas pero es una temporada devolvemos vida
			if(acierto==0 &&( palabraJugador.equals("oeste") ||palabraJugador.equals("navidad") ||palabraJugador.equals("verano"))) {
				Ventana.getVentana().setTemporada(palabraJugador);
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
		// Al acabar el juego sustituimos los atinos _ por la palabra entera
		Ventana.getVentana().setPalabraAdivinar(palabraElegida);
		VentanaEmergente.muestraVentanaEmergente("");
		
	}
	public boolean isTerminado () { // si la palabra introducida por el jugador es igual a la Elegida, isterminado es true
		
		if (jugador.getJugador().getPalabraJugador().equals(getPalabraElegida())) {
			return true;
		}
		return false;
	}
	
	public static baseMuneco getJuego() {
		if (juego == null) {
			juego = new baseMuneco();
		}
		return juego;
	}
	
	
	
	
}
