package kk.capitulo5;

import javax.swing.JOptionPane;

public class b1ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[150];
		boolean encontrado=false;
		
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*100));
			System.out.println(numeros[i]);
		}
		int buscar=Integer.parseInt(JOptionPane.showInputDialog("Que valor quieres buscar: "));
		
		for(int i=0;i<numeros.length && encontrado==false;i++) {
			if(buscar==numeros[i]) {
				System.out.println("Lo hemos encontra en: "+i);
				encontrado=true;
			}
		}
		if(encontrado==false) {
			System.out.println("Número no encontrado");
		}
	}
}