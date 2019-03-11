package repasoFeb.Bloque4Excepciones.Ej2Frases;

import javax.swing.JOptionPane;

public class Ej2Bombilla {

	public static void main(String[] args) throws ExcepcionEspacios, ExcepcionInferiora3, ExcepcionSinBombilla, ExcepcionFiltroSoez{
		// TODO Auto-generated method stub
		String frase=JOptionPane.showInputDialog("Introduce una frase: ");
		if(!frase.contains(" ")) {
			throw new ExcepcionEspacios("Excepcion de espacios");
		}else if(cuentaLetra(frase,' ')<=3){
			throw new ExcepcionInferiora3("Excepcion de menos de 3 palabras");
		}else if(!frase.contains(frase)) {
			throw new ExcepcionSinBombilla("Excepcion no contiene la palabra bombilla");
		}else if(frase.contains("tonto") || frase.contains("tonta") || frase.contains("idiota")  ){
			throw new ExcepcionFiltroSoez("Excepion palabra censurada");
		}
	}

	public static int cuentaLetra(String str, char toCheck) {
		
	    int count = 0;

	    for (char ch: str.toCharArray()) { 
	        if (ch == toCheck) {
	            count++;
	        }
	    }
	    return count;
	}
}
