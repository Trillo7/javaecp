package juegolaOca;

public class Principal {
	
	public static void main(String args[]) {
		Tablero tablero=new Tablero();
		tablero.imprimeTablero();
		
		Jugador jugador = new Jugador("Rojo",tablero);
		do {
			jugador.tirarDado();
			jugador.imprimir();
		} while(jugador.getPosicion() < 62);
	}
}