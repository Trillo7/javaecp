package kk.general1;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class diezmilnumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int suma=0,media=0, numgen=0;
		for(int i=0;i<10000;i++) {
			numgen=(int) Math.round((Math.random()*1000));
			suma=suma+numgen;
		}
		System.out.println("La suma es "+suma);
		System.out.println("La media es "+(suma/10000));
	}
}
