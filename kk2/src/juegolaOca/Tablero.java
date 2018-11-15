package juegolaOca;

public class Tablero {

	Casilla casillas[] = new Casilla[63];
	
	/**
	 * 
	 */
	public Tablero() {
		super();
		inicializacasillas(casillas);
	}
	public void imprimeTablero() {

		for(int i=0;i<casillas.length;i++) {
			System.out.println("["+casillas[i].getOrden()+" - "+casillas[i].getNombre()+"]");
		}
	}
	private void inicializacasillas(Casilla casillas[]) {
		// Mensajes
		String mensajeOca="De Oca en Oca y tiro porque me toca";
		
		// Estructa basica del casillas
		
		casillas[0] = new Casilla(1, "Inicio");
		casillas[1] = new Casilla(2, "Caballo");
		casillas[2] = new Casilla(3, "Pez");
		casillas[3] = new Casilla(4, "Payaso");
		casillas[4] = new Casilla(5, "Oca", null, 1, mensajeOca);
		casillas[5] = new Casilla(6, "Puente", null, 1, "De puente a puente y tiro porque me da la corriente");
		casillas[6] = new Casilla(7, "Tortuga");
		casillas[7] = new Casilla(8, "Silla");
		casillas[8] = new Casilla(9, "Oca", null, 1, mensajeOca);
		casillas[9] = new Casilla(10, "Raton", null, 1, "De oca a oca y tiro porque me toca");
		casillas[10] = new Casilla(11, "Rana", null, 1, "De oca a oca y tiro porque me toca");
		casillas[11] = new Casilla(12, "Puente", null, 1, "De oca a oca y tiro porque me toca");
		casillas[12] = new Casilla(13, "Huevo", null, 1, "De oca a oca y tiro porque me toca");
		casillas[13] = new Casilla(14, "Oca", null, 1, mensajeOca);
		casillas[14] = new Casilla(15, "Helado", null, 1, "De oca a oca y tiro porque me toca");
		casillas[15] = new Casilla(16, "Oso", null, 1, "De oca a oca y tiro porque me toca");
		casillas[16] = new Casilla(17, "Bebe", null, 1, "De oca a oca y tiro porque me toca");
		casillas[17] = new Casilla(18, "Oca", null, 1, mensajeOca);
		casillas[18] = new Casilla(19, "Tunel", null, 1, "De oca a oca y tiro porque me toca");
		casillas[19] = new Casilla(20, "Cohete", null, 1, "De oca a oca y tiro porque me toca");
		casillas[20] = new Casilla(21, "Tarta", null, 1, "De oca a oca y tiro porque me toca");
		casillas[21] = new Casilla(22, "Casa", null, 1, "De oca a oca y tiro porque me toca");
		casillas[22] = new Casilla(23, "Oca", null, 1, "De oca a oca y tiro porque me toca");
		casillas[23] = new Casilla(24, "Ramo de flores", null, 1, "De oca a oca y tiro porque me toca");
		casillas[24] = new Casilla(25, "Leon", null, 1, "De oca a oca y tiro porque me toca");
		casillas[25] = new Casilla(26, "Dados", null, 1, "De oca a oca y tiro porque me toca");
		casillas[26] = new Casilla(27, "Oca", null, 1, "De oca a oca y tiro porque me toca");
		casillas[27] = new Casilla(28, "Bicicleta", null, 1, "De oca a oca y tiro porque me toca");
		casillas[28] = new Casilla(29, "Delfin", null, 1, "De oca a oca y tiro porque me toca");
		casillas[29] = new Casilla(30, "Dragon", null, 1, "De oca a oca y tiro porque me toca");
		casillas[30] = new Casilla(31, "Pozo", null, 1, "De oca a oca y tiro porque me toca");
		casillas[31] = new Casilla(32, "Oca", null, 1, "De oca a oca y tiro porque me toca");
		casillas[32] = new Casilla(33, "Mariposa", null, 1, "De oca a oca y tiro porque me toca");
		casillas[33] = new Casilla(34, "Moto", null, 1, "De oca a oca y tiro porque me toca");
		casillas[34] = new Casilla(35, "Osito", null, 1, "De oca a oca y tiro porque me toca");
		casillas[35] = new Casilla(36, "Oca", null, 1, "De oca a oca y tiro porque me toca");
		casillas[36] = new Casilla(37, "Elefante", null, 1, "De oca a oca y tiro porque me toca");
		casillas[37] = new Casilla(38, "Ciervo", null, 1, "De oca a oca y tiro porque me toca");
		casillas[38] = new Casilla(39, "Conejo", null, 1, "De oca a oca y tiro porque me toca");		
		casillas[39] = new Casilla(40, "Cesta de fresas", null, 1, "De oca a oca y tiro porque me toca");
		casillas[40] = new Casilla(41, "Oca", null, 1, "De oca a oca y tiro porque me toca");
		casillas[41] = new Casilla(42, "Laberinto", null, 1, "De oca a oca y tiro porque me toca");
		casillas[42] = new Casilla(43, "Caballo", null, 1, "De oca a oca y tiro porque me toca");
		casillas[43] = new Casilla(44, "Sombrilla", null, 1, "De oca a oca y tiro porque me toca");
		casillas[44] = new Casilla(45, "Oca", null, 1, "De oca a oca y tiro porque me toca");
		casillas[45] = new Casilla(46, "Conejo grande", null, 1, "De oca a oca y tiro porque me toca");
		casillas[46] = new Casilla(47, "Muñeco de nieve", null, 1, "De oca a oca y tiro porque me toca");
		casillas[47] = new Casilla(48, "Mariposa rosa", null, 1, "De oca a oca y tiro porque me toca");
		casillas[48] = new Casilla(49, "Tren", null, 1, "De oca a oca y tiro porque me toca");
		casillas[49] = new Casilla(50, "Oca", null, 1, "De oca a oca y tiro porque me toca");
		casillas[50] = new Casilla(51, "Buho", null, 1, "De oca a oca y tiro porque me toca");
		casillas[51] = new Casilla(52, "Carcel", null, 1, "De oca a oca y tiro porque me toca");
		casillas[52] = new Casilla(53, "Dados", null, 1, "De oca a oca y tiro porque me toca");
		casillas[53] = new Casilla(54, "Oca", null, 1, "De oca a oca y tiro porque me toca");
		casillas[54] = new Casilla(55, "Gorrion", null, 1, "De oca a oca y tiro porque me toca");
		casillas[55] = new Casilla(56, "Delfin", null, 1, "De oca a oca y tiro porque me toca");
		casillas[56] = new Casilla(57, "Perro", null, 1, "De oca a oca y tiro porque me toca");
		casillas[57] = new Casilla(58, "Muere", null, 1, "De oca a oca y tiro porque me toca");
		casillas[58] = new Casilla(59, "Oca", null, 1, "De oca a oca y tiro porque me toca");
		casillas[59] = new Casilla(60, "Dos mariposas", null, 1, "De oca a oca y tiro porque me toca");
		casillas[60] = new Casilla(61, "Gato", null, 1, "De oca a oca y tiro porque me toca");
		casillas[61] = new Casilla(62, "Cisne", null, 1, "De oca a oca y tiro porque me toca");
		casillas[62] = new Casilla(63, "Fin", null, 1, "De oca a oca y tiro porque me toca");
		
		// Destinos de las casillas especiales
		casillas[4].setDestino(casillas[8]);
		casillas[5].setDestino(casillas[11]);
		casillas[11].setDestino(casillas[5]);
		casillas[8].setDestino(casillas[13]);
		casillas[13].setDestino(casillas[17]);
		casillas[17].setDestino(casillas[22]);
		casillas[22].setDestino(casillas[26]);
		casillas[25].setDestino(casillas[52]);
		casillas[52].setDestino(casillas[25]);
		casillas[26].setDestino(casillas[31]);
		casillas[31].setDestino(casillas[35]);
		casillas[35].setDestino(casillas[40]);
		casillas[40].setDestino(casillas[44]);
		casillas[41].setDestino(casillas[29]);
		casillas[44].setDestino(casillas[49]);
		casillas[49].setDestino(casillas[53]);
		casillas[53].setDestino(casillas[58]);
		casillas[57].setDestino(casillas[0]);
		casillas[58].setDestino(casillas[62]);
	}
}