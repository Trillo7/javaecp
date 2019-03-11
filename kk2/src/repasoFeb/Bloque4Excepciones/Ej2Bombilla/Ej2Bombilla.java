package repasoFeb.Bloque4Excepciones.Ej2Bombilla;

import javax.swing.JOptionPane;

public class Ej2Bombilla {

	public static void main(String[] args) throws ExcepcionEspacios{
		// TODO Auto-generated method stub
		String frase=JOptionPane.showInputDialog("Introduce una frase: ");
		if(!frase.contains(" ")) {
			throw new ExcepcionEspacios("Excepcion de espacios");
		}
	}

}
