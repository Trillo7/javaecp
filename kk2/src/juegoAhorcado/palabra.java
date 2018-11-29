package juegoAhorcado;

public class palabra {
	private static palabra Palabras = null;
	private char separadas[]=new char[1000];
	
	public void separar() {
		String aseparar=baseMuneco.getJuego().getPalabraElegida();
		for (int i=0;i<aseparar.length();i++) {
			separadas[i]=aseparar.charAt(i);
		}
	}
	
	
	
	/**
	 * @return the separadas
	 */
	public char[] getSeparadas() {
		return separadas;
	}



	/**
	 * @param separadas the separadas to set
	 */
	public void setSeparadas(char[] separadas) {
		this.separadas = separadas;
	}



	/**
	 * @param palabra_char
	 */

	/**
	 * 
	 */
	public palabra() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the palabra_char
	 */



	/**
	 * @param palabra_char the palabra_char to set
	 */


	public static palabra getPalabras() {
		if (Palabras == null) {
			Palabras= new palabra();
		}
		return Palabras;
	}
}
