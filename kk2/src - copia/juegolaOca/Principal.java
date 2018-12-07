package juegolaOca;

public class Principal {
	
	public static void main(String args[]) {
		Tablero.getTablero().imprimeTablero();
		int tiradas1=0, tiradas2=0,tiradas3=0,tiradas4=0;
		System.out.println("TABLERO MOSTRADO");
		Jugador jugador = new Jugador("Trillo");
		do {
			jugador.tirarDado();
			jugador.imprimir();
			tiradas1++;
		} while(jugador.getPosicion() < 62);
		
		Jugador jugador2 = new Jugador("Antonio");
		do {
			jugador2.tirarDado();
			jugador2.imprimir();
			tiradas2++;
		} while(jugador2.getPosicion() < 62);
		if(tiradas1>tiradas2) {
			System.out.println("El ganador es: "+jugador2.getNombre());
		}else {
			System.out.println("El ganador es: "+jugador.getNombre());
		}
	}
}