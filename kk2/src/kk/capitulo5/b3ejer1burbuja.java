package kk.capitulo5;

import javax.swing.JOptionPane;

public class b3ejer1burbuja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[4];
		int guarda=0;
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*1000));
			System.out.print(" "+numeros[i]);
		}
		
		for(int i=0;i<numeros.length;i++) {
			for(int j=0;j<numeros.length;j++) {
				if(numeros[i]>numeros[j]) {
					guarda=numeros[j];
					numeros[j]=numeros[i];
					numeros[i]=guarda;
				}
			}
		}
		
		System.out.println(" ");
		for(int i=0;i<numeros.length;i++) {
			System.out.print(" "+numeros[i]);
		}
	}
}