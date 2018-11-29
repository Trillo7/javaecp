package juegoAhorcado;

import javax.swing.JOptionPane;

public class baseMuneco {
	private String palabraElegida=null;
	private static baseMuneco juego = null;
	private char palRellenar[]=new char[1000];


	
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
	 * @return the numintentos
	 */


	/**
	 * @param numintentos the numintentos to set
	 */

	/**
	 * 
	 */
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
		// Eligimos una palabra aleatoria
		int randElige=(int) Math.round(Math.random() * ((bdPalabras.length-1) - 0) + 0);
		this.setPalabraElegida(bdPalabras[randElige]);
		System.out.println(this.palabraElegida); // Mostramos la palabra seleccionada (trampa)
		System.out.println(""); // salto de linea
		for(int i=0;i<bdPalabras[randElige].length();i++) {
			palRellenar[i]='_';
		}
		// Recargamos los intentos
		jugador.getJugador().setNumintentos(6);
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
		System.out.println("Partes del cuerpo: "+vidas);
		
		Ventana.getVentana().repaint();
		
	}
	
	public void iniciaJugada() {
		do {
			int acierto=0;
			// Pide palabra
			String palabraJugador=JOptionPane.showInputDialog("Introduce una letra o una palabra: ");
			jugador.getJugador().setPalabraJugador(palabraJugador);
			// Comprobamos si la letra es correcta
			
			for(int i=0;i<this.palabraElegida.length();i++) {
				char arrayPalabras[]=palabra.getPalabras().getSeparadas();
				if(palabraJugador.charAt(0)==arrayPalabras[i]) {
					palRellenar[i]=palabra.getPalabras().getSeparadas()[i];
					acierto=1;
				}
			}// y quitamos intento si has fallado
			if(acierto==0) {
				jugador.getJugador().setNumintentos(jugador.getJugador().getNumintentos()-1);
				jugador.getJugador().setPalabrasFallidas(jugador.getJugador().getPalabrasFallidas()+palabraJugador.charAt(0)+" ");
			}
			acierto=0;
			muestraEstado();
		}while(!isTerminado()&& jugador.getJugador().getNumintentos()>0); // Terminamos al acertar la palabra
	
		// Al acabar el juego, mostramos dependiendo si por victoria o por derrota
		if(jugador.getJugador().getNumintentos()>=1) {
			Ventana.getVentana().setTextoFinal("Enhorabuena has ganado");			
		}else {
			Ventana.getVentana().setTextoFinal("Has muerto");
		}
		// Al acabar el juego sustituimos los atinos _ por la palabra entera
		Ventana.getVentana().setPalabraAdivinar(palabraElegida);

	}
	public boolean isTerminado () {
		
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
