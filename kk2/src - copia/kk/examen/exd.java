package kk.examen;

import javax.swing.JOptionPane;

public class exd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = new int[100];
		int elegido=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: "));
		//Introducimos numeros aleatorios
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}
		//Mostramos el array
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println(" "); // Salto de linea para el siguiente numero
		for(int i=0;i<array.length;i++) {
			if(array[i]%10==elegido) { // Mostramos el número si el resto es el número introducido
				System.out.print(" "+array[i]); 
			}
		}
	}
}
