package kk.capitulo5;

import javax.swing.JOptionPane;

public class b2ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[4];
		int copia=0;
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*100));
			System.out.print(" "+numeros[i]);

		}
		
		int elfinal=numeros[numeros.length-1];
		for(int i=0;i<(numeros.length-2);i++) {
			
			numeros[i+1]=numeros[i];
		}
		numeros[0]=elfinal;
		System.out.println(" ");
		for(int i=0;i<numeros.length;i++) {
			System.out.print(" "+numeros[i]);
		}
	}
}