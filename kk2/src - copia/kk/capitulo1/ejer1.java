package kk.capitulo1;

import javax.swing.JOptionPane;

public class ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJERCICIO 3
		String str = JOptionPane.showInputDialog("Introduce un numero entero: ");
		int num1 = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce un numero flotante: ");
		float num2 = Float.parseFloat(str);
		str = JOptionPane.showInputDialog("Introduce un numero doble: ");
		double num3 = Double.parseDouble(str);
		
		System.out.println("Numero entero: " + num1);
		System.out.println("Numero flotante: " + num2);
		System.out.println("Numero doble: " + num3);
	}

}
