package ejerEventos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	static List<IntStringIntroducidoListener> varIntStringIntroducidoListeners = 
			new ArrayList<IntStringIntroducidoListener>();

	/**
	 * 
	 * @param listener
	 */
	public static void addNumeroImparIntroducidoListener (IntStringIntroducidoListener listener) {
		varIntStringIntroducidoListeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void addStringIntroducidoListener (IntStringIntroducidoListener listener) {
		varIntStringIntroducidoListeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removeNumeroImparIntroducidoListener (IntStringIntroducidoListener listener) {
		varIntStringIntroducidoListeners.remove(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removeStringIntroducidoListener (IntStringIntroducidoListener listener) {
		varIntStringIntroducidoListeners.remove(listener);
	}
	/**
	 * 
	 * @param e
	 */
	public static void fireNumeroImparIntroducidoListener (IntStringEspecialIntroducidoEvent e) {
		for (IntStringIntroducidoListener listener : varIntStringIntroducidoListeners) {
			listener.numeroImparIntroducido(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public static void fireStringIntroducidoListener (IntStringEspecialIntroducidoEvent e) {
		for (IntStringIntroducidoListener listener : varIntStringIntroducidoListeners) {
			listener.stringIntroducido(e);
		}
	}
	
	/**
	 * 
	 * @param e
	 */
	public static void fireNumeroPrimoIntroducidoListener (IntStringEspecialIntroducidoEvent e) {
		for (IntStringIntroducidoListener listener : varIntStringIntroducidoListeners) {
			listener.numeroPrimoIntroducido(e);
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Carlos carlos = new Carlos();
		Fran fran = new Fran();
		addNumeroImparIntroducidoListener(fran);
		
		
		
		while (true) {
			int opcion=  Integer.parseInt(JOptionPane.showInputDialog("Numeros(1) o Letras(2): "));
			if(opcion==1) {
				int numIntroducido =  Integer.parseInt(JOptionPane.showInputDialog("Introduzca n�mero: "));
				System.out.println("N�mero introducido: " + numIntroducido);
				
				// Notifico a los listeners
				if (numIntroducido % 2 == 1) {
					IntStringEspecialIntroducidoEvent event = new IntStringEspecialIntroducidoEvent(numIntroducido);
					fireNumeroImparIntroducidoListener(event);
				}
				
				// Notifico n�mero primo
				boolean esPrimo =true;
				for (int i = 2; i == numIntroducido - 1; i++) {
					if (numIntroducido % i == 0) {
						esPrimo = false;
					}
				}
				if (esPrimo) fireNumeroPrimoIntroducidoListener(new IntStringEspecialIntroducidoEvent(numIntroducido));
				
			}else {
				String stringIntroducido=JOptionPane.showInputDialog("Introduce una palabra o frase: ");

				// Notifico palabra secreto
				if(stringIntroducido.contains("avioneta")) {
					IntStringEspecialIntroducidoEvent event = new IntStringEspecialIntroducidoEvent(stringIntroducido);
					fireStringIntroducidoListener(event);
				}
				
			}
			
			
		}

	}

}
