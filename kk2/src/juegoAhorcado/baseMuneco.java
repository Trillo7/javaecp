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
		System.out.println(bdPalabras[randElige]);
		for(int i=0;i<bdPalabras[randElige].length();i++) {
			palRellenar[i]='_';
		}
		muestraEstado();
		this.setPalabraElegida(bdPalabras[randElige]);
		jugador.getJugador().setNumintentos(6);
	}
	
	public void muestraEstado() {
		System.out.println("");

		for(int i=0;i<baseMuneco.getJuego().getPalabraElegida().length()-1;i++) {
			System.out.print(palRellenar[i]+" ");
		}
	}
	public void iniciaJugada() {
		do {
			int acierto=1;
			// Pide palabra
			String palabraJugador=JOptionPane.showInputDialog("Introduce una letra o una palabra: ");
			jugador.getJugador().setPalabraJugador(palabraJugador);
			System.out.println(palabraJugador.charAt(0));
			// Comprobamos si la letra es correcta
			for(int i=0;i<baseMuneco.getJuego().getPalabraElegida().length();i++) {
				if(palabraJugador.charAt(0)==palabra.getPalabras().getSeparadas()[i]) {
					palRellenar[i]=palabra.getPalabras().getSeparadas()[i];
					muestraEstado();
				}else {
					acierto=0;
				}
			}
			if(acierto==0) {
				jugador.getJugador().setNumintentos(jugador.getJugador().getNumintentos()-1);
			}
	
		}while(!isTerminado()&& jugador.getJugador().getNumintentos()>0); // Terminamos al acertar la palabra
		System.out.println("");
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
