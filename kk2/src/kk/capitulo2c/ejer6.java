package kk.capitulo2c;

import javax.swing.JOptionPane;

public class ejer6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJERCICIO 6
		String str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num1 = Integer.parseInt(str);

		if(num1%2==0) {
			System.out.println("El numero es par");
		}else {
			System.out.println("El numero es impar");
		}

	}

}
