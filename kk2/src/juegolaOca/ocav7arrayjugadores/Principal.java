package juegolaOca.ocav7arrayjugadores;

import javax.swing.JOptionPane;

public class Principal {   

	/**
	 * 
	 */
	public static void main (String args[]) {
		String nombresJugadores[] = new String[] {"Rafa", "Joaqu�n", "Pedro", "Marta", "Sof�a", "Laura"};
		
		Jugador jugadores[] = new Jugador[4];
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador(nombresJugadores[i]);
		}
		
		
		// Prueba de uso del primer jugador
		do {
			for (int i = 0; i < jugadores.length; i++) {
				if (!jugadores[i].isTerminado()) {
					System.out.println(jugadores[i].getNombre());
					jugadores[i].tirarDado();
				}
			}
		} while (!estaJuegoTerminado(jugadores));
		
		System.out.println("\n\n\tHAS GANADO EL JUEGO DE LA OCA");
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private static boolean estaJuegoTerminado (Jugador jugadores[]) {
		for (int i = 0; i < jugadores.length; i++) {
			if (!jugadores[i].isTerminado()) {
				return false;
			}
		}
		return true;
	}
}
