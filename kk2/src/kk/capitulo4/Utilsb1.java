package kk.capitulo4;

import javax.swing.JOptionPane;

public class Utilsb1 {

	public static float ejer1b1(int numint1,int numint2,int numint3, float numfloat1){
		float suma=numint1+numint2+numint3+numfloat1;
		
		return (suma/4);
	}
	
	public static void ejer2b1(int minimo, int maximo) {
		int minintrod, maxintrod;
	
		do {
			JOptionPane.showMessageDialog(null,"Introduce un numero entre "+minimo+" y "+maximo);
			minintrod=Integer.parseInt(JOptionPane.showInputDialog("Numero minimo 2: "));
			maxintrod=Integer.parseInt(JOptionPane.showInputDialog("Numero máximo 2: "));
		}while(minintrod< minimo || maxintrod>maximo || maxintrod <minimo || minintrod > maximo);

	}
}
