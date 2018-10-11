package kk.general1;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class paresonones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int manohuman1=0,manohuman2=0,manobot1=0,manobot2=0,manohuman=0,manobot=0;
		int eleccionhuman=Integer.parseInt(JOptionPane.showInputDialog("Pares->0\nNones->1"));
		manohuman1=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: "));
		manohuman2=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: "));
		manobot1=(int) (Math.random()*6);
		manobot2=(int) (Math.random()*6);
		manohuman=manohuman1+manohuman2;
		manobot=manobot1+manobot2;
		int acalcular=manohuman1+manohuman2+manobot1+manobot2;
		int victoria=acalcular%2;
		
		if(eleccionhuman==victoria) {
			System.out.println("Has ganado");
		}else {
			System.out.println("Has perdido");
		}
	}
}
