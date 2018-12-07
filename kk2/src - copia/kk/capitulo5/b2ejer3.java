package kk.capitulo5;

import javax.swing.JOptionPane;

public class b2ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[150];
		int multiplica=Integer.parseInt(JOptionPane.showInputDialog("Que número quieres multiplicar"));
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*100));
			numeros[i]=numeros[i]*multiplica;
			System.out.println(numeros[i]);
		}
	}
}