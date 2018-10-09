package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq2ejer4{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int numintrod, resultado=0;
		str=JOptionPane.showInputDialog("Introduce un numero");
		numintrod=Integer.parseInt(str);
		str=JOptionPane.showInputDialog("Límite de múltiplos: ");
		int limite=Integer.parseInt(str);
		for(int i=0;resultado<limite-1;i++) {
			resultado=numintrod*i;
			System.out.println("Multiplos de "+numintrod+": "+resultado);
		}
	
	}
}
