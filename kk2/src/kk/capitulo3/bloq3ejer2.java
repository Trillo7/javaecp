package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq3ejer2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int numintrod=1, i=0,resultado=0;
	
		
		for(i=0;numintrod!=0;i++) {
			str=JOptionPane.showInputDialog("Introduce un numero: (0 para salir)");
			numintrod=Integer.parseInt(str);
			resultado=resultado+numintrod;
		}
		System.out.println("Suma de numeros: "+resultado/(i-1));
	}
}
