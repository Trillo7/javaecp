package repasoFeb.Bloque7Eventos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class Ej1MainDigitos {
	private static List<Ej1Listener> digitoEncontradoListeners = 
			new ArrayList<Ej1Listener>();
	
	public static void addDigitoEncontradoListener (Ej1Listener listener) {
		digitoEncontradoListeners.add(listener);
	}
	
	public static void removeDigitoEncontradoListener (Ej1Listener listener) {
		digitoEncontradoListeners.remove(listener);
	}
	
	public static void fireDigitoEncontradoListener (Ej1DigitoEncontradoEvent evento) {
		for (Ej1Listener listener : digitoEncontradoListeners) {
			listener.EncuentraDigito(evento);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addDigitoEncontradoListener(new BuscaDigitos());
		
		do {
			String fraseuser=JOptionPane.showInputDialog("Introduce una frase: ");
			for(int i=0;i<fraseuser.length();i++) {
				if(Character.isDigit(fraseuser.charAt(i))) {
					Ej1DigitoEncontradoEvent evento=new Ej1DigitoEncontradoEvent(fraseuser.charAt(i)-48);
					fireDigitoEncontradoListener(evento);
				}

			}
		}while(true);
	}

}
