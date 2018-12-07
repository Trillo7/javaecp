package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq3ejer6{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int numintrod=1, i=0,menor=0,mayor=0;
	
		for(i=0;numintrod!=0;i++) {
			str=JOptionPane.showInputDialog("Introduce un numero: (0 para salir)");
			numintrod=Integer.parseInt(str);
			for(int x=0;x<=10;x++) {
				System.out.println(numintrod*x);
			}
			
		}
		
	}
}
