package kk.capitulo5.bloque5;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class b5ej1Editortxt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> linea = new ArrayList<Integer>();		
		int opcion=500;
		while(opcion!=0) {
			opcion=Integer.parseInt(JOptionPane.showInputDialog("Introduce una opcion: \n"+   
					"1) Añadir una línea al texto. \n" + 
					"2) Insertar una línea en cualquier posición del texto.\n" + 
					"3) Editar una línea (reescribir su contenido).\n" + 
					"4) Borrar una línea.\n" + 
					"5) Cortar un conjunto de líneas, (marcadas por su posición inicial y final).\n" + 
					"6) Pegar un conjunto de líneas cortadas en una determinada posición.\n" + 
					"7) Imprimir el texto. Cada línea aparecerá numerada.\n"+
					"0) Salir"));

		}
		
		
	}

}
