package kk.capitulo4;

import javax.swing.JOptionPane;

public class b1ejer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ejer 1
		System.out.println(Utilsb1.ejer1b1(3,8,5,3));
		// Ejer 2
		int ejer1nummin=Integer.parseInt(JOptionPane.showInputDialog("Numero minimo: "));
		int ejer1nummax=Integer.parseInt(JOptionPane.showInputDialog("Numero máximo: "));
		Utilsb1.ejer2b1(ejer1nummin, ejer1nummax);
	}
}
		