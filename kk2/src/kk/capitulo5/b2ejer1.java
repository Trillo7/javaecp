package kk.capitulo5;

import javax.swing.JOptionPane;

public class b2ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[150];
		int sumapares=0,sumaimpares=0;
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*(100-(-100))+-100));
			System.out.print(" "+numeros[i]);
		}
		// Cambiamos el signo
		System.out.println("");
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=numeros[i]*-1;
			System.out.print(" "+numeros[i]);
		}
		
	}
}