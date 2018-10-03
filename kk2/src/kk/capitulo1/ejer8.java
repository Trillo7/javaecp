package kk.capitulo1;

import javax.swing.JOptionPane;

public class ejer8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num1 = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num2 = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce un numero: ");
		int num3 = Integer.parseInt(str);
		int mayor=0;
		int menor=0;
		
		if(num1>num2) {
			if(num1 > num3) {
				mayor=num1;
				if(num2>num3) {
					menor=num3;
				}else {
					menor=num2;
				}
			}else {
				 mayor=num3;
				 menor=num2;
			}
		}else {
			if(num2>num3) {
				mayor=num2;
				if(num1>num3) {
					menor=num3;
				}else {
					menor=num1;
				}
			}
		}
		
		System.out.println("El numero mayor es: "+mayor);
		System.out.println("El numero menor es: "+menor);

	}
}
