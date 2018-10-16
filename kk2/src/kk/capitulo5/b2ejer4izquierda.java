package kk.capitulo5;

import javax.swing.JOptionPane;

public class b2ejer4izquierda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[4];
		int copia=0;
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*100));
			System.out.print(" "+numeros[i]);

		}
		
		int guarda=numeros[0];
		for(int i=0;i<numeros.length-1;i++) {
			numeros[i]=numeros[i+1];
		}
		numeros[numeros.length-1]=guarda;
		
		System.out.println(" ");
		for(int i=0;i<numeros.length;i++) {
			System.out.print(" "+numeros[i]);
		}
	}
}