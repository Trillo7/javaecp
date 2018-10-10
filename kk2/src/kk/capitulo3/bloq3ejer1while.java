package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq3ejer1while{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int numintrod=1, resultado=0;
	
		
		while(numintrod!=0) {
			str=JOptionPane.showInputDialog("Introduce un numero: (0 para salir)");
			numintrod=Integer.parseInt(str);
			resultado=resultado+numintrod;
		}
		System.out.println("Suma de numeros: "+resultado);
	}
}
