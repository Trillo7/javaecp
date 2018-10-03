package kk.capitulo2c;

import javax.swing.JOptionPane;

public class ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJERCICIO 3
		String str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num1 = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num2 = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num3 = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num4 = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num5 = Integer.parseInt(str);
		int mayor=0;
		int menor=num1;
		
		if(num1<menor) {
			menor=num1;
		}
		if(num2<menor) {
			menor=num2;
		}
		if(num3<menor) {
			menor=num3;
		}
		if(num4<menor) {
			menor=num4;
		}
		if(num5<menor) {
			menor=num5;
		}
			
		if(mayor<num1) {
			mayor=num1;
		}
		if(mayor<num2) {
			mayor=num2;
		}
		if(mayor<num3) {
			mayor=num3;
		}
		if(mayor<num4) {
			mayor=num4;
		}
		if(mayor<num5) {
			mayor=num5;
		}
		
		System.out.println("Numero mayor es: " + mayor);
		System.out.println("Numero menor es: " + menor);

	}

}
