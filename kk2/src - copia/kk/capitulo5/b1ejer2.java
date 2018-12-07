package kk.capitulo5;

import javax.swing.JOptionPane;

public class b1ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[150];
		
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*100));
		}
		
		for(int i=numeros.length-1;i>0;i--) {
			System.out.println("iteración "+i+": "+numeros[i]);
			
		}
	}
}