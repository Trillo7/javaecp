package eventosNumeros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	static List<NumeroEspecialIntroducidoListener> numeroImparIntroducidoListeners = 
			new ArrayList<NumeroEspecialIntroducidoListener>();

	/**
	 * 
	 * @param listener
	 */
	public static void addNumeroImparIntroducidoListener (NumeroEspecialIntroducidoListener listener) {
		numeroImparIntroducidoListeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removeNumeroImparIntroducidoListener (NumeroEspecialIntroducidoListener listener) {
		numeroImparIntroducidoListeners.remove(listener);
	}

	/**
	 * 
	 * @param e
	 */
	public static void fireNumeroImparIntroducidoListener (NumeroEspecialIntroducidoEvent e) {
		for (NumeroEspecialIntroducidoListener listener : numeroImparIntroducidoListeners) {
			listener.numeroImparIntroducido(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public static void fireNumeroPrimoIntroducidoListener (NumeroEspecialIntroducidoEvent e) {
		for (NumeroEspecialIntroducidoListener listener : numeroImparIntroducidoListeners) {
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
			int numIntroducido =  Integer.parseInt(JOptionPane.showInputDialog("Introduzca n�mero: "));
			System.out.println("N�mero introducido: " + numIntroducido);
			
			// Notifico a los listeners
			if (numIntroducido % 2 == 1) {
				NumeroEspecialIntroducidoEvent event = new NumeroEspecialIntroducidoEvent(numIntroducido);
				fireNumeroImparIntroducidoListener(event);
			}
			
			// Notifico n�mero primo
			boolean esPrimo =true;
			for (int i = 2; i == numIntroducido - 1; i++) {
				if (numIntroducido % i == 0) {
					esPrimo = false;
				}
			}
			if (esPrimo) fireNumeroPrimoIntroducidoListener(new NumeroEspecialIntroducidoEvent(numIntroducido));
			
		}

	}

}
