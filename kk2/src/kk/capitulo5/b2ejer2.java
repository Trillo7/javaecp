package kk.capitulo5;

import javax.swing.JOptionPane;

public class b2ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array1[]=new int[150];
		int array2[]=new int[150];
		int array3[]=new int[150];
		
		for(int i=0;i<array1.length;i++) {
			array1[i]=(int) Math.round((Math.random()*100));
			if(i%2!=0) {
				array3[i]=array1[i];
				System.out.print(" "+array1[i]);

			}
		}
		System.out.println(" ");
		for(int i=0;i<array2.length;i++) {
			array2[i]=(int) Math.round((Math.random()*100));
			if(i%2==0) {
				array3[i]=array2[i];
				System.out.print(" "+array2[i]);

			}
		}
		System.out.println(" ");
		// Recorremos tercer array
		for(int i=0;i<array3.length;i++) {
			System.out.print(" "+array3[i]);
		}
		
	}
}