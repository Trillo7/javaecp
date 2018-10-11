package kk.general1;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class adivinanumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numerorandom= (int) Math.round((Math.random()*100)), numintrod=0;
		String str;
		
		do {
			numintrod=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero:"));
			if(numintrod>numerorandom) {
				str="El número premio es más pequeño";
				JOptionPane.showMessageDialog(null, str);
				System.out.println(str);
			}else if(numintrod<numerorandom) {
				str="El número premio es más grande";
				JOptionPane.showMessageDialog(null, str);
				System.out.println(str);
			}else {
				str="Enhorabuena, has ganado: "+numerorandom;
				JOptionPane.showMessageDialog(null, str);
				System.out.println("Enhorabuena, has ganado: "+numerorandom);
			}
		}while(numintrod!=numerorandom);
	}
}
