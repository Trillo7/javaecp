package kk.capitulo5;

import javax.swing.JOptionPane;

public class b1ejer4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[150];
		int sumapares=0,sumaimpares=0;
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*100));
			if(numeros[i]%2==0) {
				sumapares+=numeros[i];
			}else {
				sumaimpares+=numeros[i];
			}
		}
		
		System.out.println("Hay impares: "+sumaimpares);
		System.out.println("Hay pares: "+sumapares);
		
	}
}