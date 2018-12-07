package kk.capitulo5;

import javax.swing.JOptionPane;

public class b1ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[150];
		int sumapares=0,sumaimpares=0;
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*100));
			if(i%2==0) {
				sumapares+=numeros[i];
			}
		}
		
		System.out.println("Suma índice par: "+sumapares);
		
	}
}