package kk.capitulo1;

import javax.swing.JOptionPane;

public class ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJERCICIO 3
		String str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num1 = Integer.parseInt(str);
		System.out.println("N�mero introducido: " + num1);
		String str2 = JOptionPane.showInputDialog("Introduce un numero: ");
		int num2 = Integer.parseInt(str2);
		System.out.println("N�mero introducido: " + num2);
		String str3 = JOptionPane.showInputDialog("Introduce un numero: ");
		int num3 = Integer.parseInt(str3);
		int suma=num1+num2+num3;
		System.out.println("N�mero introducido: " + num3);
		System.out.println("La suma es: " + suma);	
	}

}
