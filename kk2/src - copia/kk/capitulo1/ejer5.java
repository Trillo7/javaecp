package kk.capitulo1;

import javax.swing.JOptionPane;

public class ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJERCICIO 3
		String str = JOptionPane.showInputDialog("Introduce variable A: ");
		int vara = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Introduce variable B: ");
		int varb = Integer.parseInt(str);
		System.out.println("Variable A: " + vara);
		System.out.println("Variable B: " + varb);
		int auxiliar=vara;
		vara=varb;
		varb=auxiliar;
		System.out.println("Variable A: " + vara);
		System.out.println("Variable B: " + varb);
	}

}
