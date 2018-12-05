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
	public void generaPalabra() {
	// Creamos el String de las palabras
		String bdPalabras []= new String [] {"libreria","mayordomo","paleta","serrucho","bate","pelota","futbol","baloncesto","ordenador","juego","trabajo","nuclear","uniforme","avion","coche"};
		int randElige=(int) Math.round(Math.random() * ((bdPalabras.length-1) - 0) + 0);
		baseMuneco.getJuego().setPalabraElegida(bdPalabras[randElige]);
		System.out.println(baseMuneco.getJuego().getPalabraElegida()); // Mostramos la palabra seleccionada (trampa)
		System.out.println(""); // salto de linea
		for(int i=0;i<bdPalabras[randElige].length();i++) {
			baseMuneco.getJuego().getPalRellenar()[i]='_';
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

	public palabra() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static palabra getPalabras() {
		if (Palabras == null) {
			Palabras= new palabra();
		}
		return Palabras;
	}
}
