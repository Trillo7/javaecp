package kk.capitulo5;

import javax.swing.JOptionPane;

public class b2ejer4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[4];
		int copia=0;
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*100));
		}
		
		for(int i=0;i<numeros.length;i++) {
			copia=numeros[i+1];
			numeros[i+1]=numeros[i];
			numeros[i]=copia;
		}
	}
}