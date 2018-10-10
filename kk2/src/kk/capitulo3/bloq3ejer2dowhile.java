package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq3ejer2dowhile{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int numintrod=1, i=0,resultado=0;
	
		
		 do{
			str=JOptionPane.showInputDialog("Introduce un numero: (0 para salir)");
			numintrod=Integer.parseInt(str);
			resultado=resultado+numintrod;
			i++;
		}while(numintrod!=0);
		System.out.println("Suma de numeros: "+resultado/(i-1));
	}
}
