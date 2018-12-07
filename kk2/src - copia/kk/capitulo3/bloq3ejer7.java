package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq3ejer7{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int numintrod=1, i=0,positivos=0,negativos=0;
	
		for(i=0;numintrod!=0;i++) {
			str=JOptionPane.showInputDialog("Introduce un numero: (0 para salir)");
			numintrod=Integer.parseInt(str);
			if(numintrod<0) {
				negativos++;
			}
			if(numintrod>0) {
				positivos++;
			}
			
		}
		System.out.println("Numeros positivos: "+positivos);
		System.out.println("Numeros negativos: "+negativos);
	}
}
