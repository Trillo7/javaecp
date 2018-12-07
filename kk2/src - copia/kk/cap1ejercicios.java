package kk;

import javax.swing.JOptionPane;

public class cap1ejercicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJERCICIO 3
		String str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num1 = Integer.parseInt(str);
		System.out.println("Número introducido: " + num1);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num2 = Integer.parseInt(str);
		System.out.println("Número introducido: " + num2);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num3 = Integer.parseInt(str);
		int suma=num1+num2+num3;
		System.out.println("Número introducido: " + num3);
		System.out.println("La suma es: " + suma);
		
		/// EJERCICIO 4
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		num1 = Integer.parseInt(str);
		System.out.println("Número introducido: " + num1);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		num2 = Integer.parseInt(str);
		System.out.println("Número introducido: " + num2);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		num3 = Integer.parseInt(str);
		System.out.println("Número introducido: " + num3);
		float media=(float) ((num1+num2+num3)/3.0);
		System.out.println("La media es: " + media);				
	}

}