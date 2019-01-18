package kk.capitulo5.bloque5;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JOptionPane;

public class b5ej1Editortxt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> linea = new ArrayList<String>();	
		List<String> lineasACortar = new ArrayList<String>();		

		int opcion=500;
		while(opcion!=0) {
			//INICIO MENU
			opcion=Integer.parseInt(JOptionPane.showInputDialog("Introduce una opcion: \n"+   
					"1) Añadir una línea al texto. \n" + 
					"2) Insertar una línea en cualquier posición del texto.\n" + 
					"3) Editar una línea (reescribir su contenido).\n" + 
					"4) Borrar una línea.\n" + 
					"5) Cortar un conjunto de líneas, (marcadas por su posición inicial y final).\n" + 
					"6) Pegar un conjunto de líneas cortadas en una determinada posición.\n" + 
					"7) Imprimir el texto. Cada línea aparecerá numerada.\n"+
					"0) Salir"));
			//FIN MENU
			switch(opcion) {
			case 1:
				String nuevotexto=JOptionPane.showInputDialog("Introduce el texto: ");
				linea.add(nuevotexto);
				break;
			case 2:
				int posicion=Integer.parseInt(JOptionPane.showInputDialog("En que línea quieres escribir: ")); 
				nuevotexto=JOptionPane.showInputDialog("Introduce el texto: ");
				if(posicion>=1) {posicion--;} // porque 0 es uno en la posicion
				if(posicion>linea.size()) {
					linea.add(nuevotexto);

				}else {
					linea.add(posicion, nuevotexto);
				}// para el error index out of bounds
				break;
			case 3:
				posicion=Integer.parseInt(JOptionPane.showInputDialog("Que línea quieres editar: ")); 
				nuevotexto=JOptionPane.showInputDialog("Introduce el texto: ");
				if(posicion>=1) {posicion--;} // porque 0 es uno en la posicion
				if(posicion>linea.size()) {
					linea.set(linea.size(),nuevotexto);

				}else {
					linea.set(posicion, nuevotexto);
				}// para el error index out of bounds
				break;
			case 4:
				posicion=Integer.parseInt(JOptionPane.showInputDialog("Que línea quieres editar: ")); 
				if(posicion>=1) {posicion--;} // porque 0 es uno en la posicion
				linea.remove(posicion);
				break;
			case 5:
				int posicion1=Integer.parseInt(JOptionPane.showInputDialog("Primera línea a cortar: ")); 
				int posicion2=Integer.parseInt(JOptionPane.showInputDialog("Última línea a cortar: ")); 
				if(posicion1>=1) {posicion1--;} // para que introduzcan las lineas desde el 1
				if(posicion2>=1) {posicion2--;}
				int borrar = posicion1; // para aprovechar que mueve el arraylist
				for(int i=posicion1;i<=posicion2;i++) {
					lineasACortar.add(linea.get(borrar));
					linea.remove(borrar);
				}
				break;
			case 6:
				posicion=Integer.parseInt(JOptionPane.showInputDialog("Asegúrate de cortar primero. ¿En qué línea quieres pegar?: ")); 
				if(posicion>=1) {posicion--;} 
				for(int i=0;i<lineasACortar.size();i++) {
					linea.add(posicion, lineasACortar.get(i));
				}
				break;
			case 7:
				System.out.println(" ");
				for(int i=0;i<linea.size();i++) {
					System.out.println(linea.get(i));
				}
				break;
			}
		}

	}

}
