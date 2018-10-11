package kk.general1;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class juegobarajaalta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Generar numeros aleatorios sin repetir
		int palohuman=(int) ((Math.random() * ((4 - 1) + 1)) + 1);
		int palobot=(int) ((Math.random() * ((4 - 2) + 1)) + 1);
		int barajahuman=(int) ((Math.random() * ((14 - 2) + 1)) + 2);
		int barajabot=(int) ((Math.random() * ((14 - 2) + 1)) + 2);
		
		if(barajahuman==barajabot) {
			
			
		}else {
			if(barajahuman>barajabot) {
				
			}
		}
		
		System.out.println(palobot);
		System.out.println(palohuman);
		System.out.println(barajahuman);
		System.out.println(barajabot);
	}
}
