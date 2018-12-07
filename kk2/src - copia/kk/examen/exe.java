package kk.examen;

import javax.swing.JOptionPane;

public class exe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = new int[20];
		//Introducimos numeros aleatorios
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 40); // Generamos un aleatorio
			for(int x=0;x<i;x++) {
				if(array[i]==array[x]) { // Si el numero generado esta repetido, volvemos al anterior para que lo vuelva a generar
					i--;
				}
			}
		}
		//Mostramos el array
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	

	}
}
