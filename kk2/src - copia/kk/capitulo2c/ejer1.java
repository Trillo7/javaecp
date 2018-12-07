package kk.capitulo2c;

import javax.swing.JOptionPane;

public class ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJERCICIO 1
		String str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num1 = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num2 = Integer.parseInt(str);
		int mayor=0;
		
		if(num1>num2) {
		mayor=num1;
			
		}else {
			mayor=num2;
		}
		
		
		
		System.out.println("Numero mayor es: " + mayor);


	}

}
