package kk.capitulo1;

import javax.swing.JOptionPane;

public class ejer4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/// EJERCICIO 4
		String str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num1 = Integer.parseInt(str);
		System.out.println("N�mero introducido: " + num1);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num2 = Integer.parseInt(str);
		System.out.println("N�mero introducido: " + num2);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num3 = Integer.parseInt(str);
		float media=(float) ((num1+num2+num3)/3.0);
		System.out.println("N�mero introducido: " + num3);
		System.out.println("La media es: " + media);
		
		
	}

}
