package kk.general1;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class tiramoneda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numintrod=0, contabot=0,contahuman=0;
		String str;
		do {
			int numerorandom= (int) Math.round((Math.random()));
			numintrod=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero:\n0-> Cara \n1-> Cruz "));
			if(numintrod==numerorandom) {
				contahuman++;
				str="Punto para ti\n"+contabot+" a "+contahuman;
				JOptionPane.showMessageDialog(null, str);
				System.out.println(str);
			}else {
				contabot++;
				str="Punto para el bot\n"+contabot+" a "+contahuman;
				JOptionPane.showMessageDialog(null, str);
				System.out.println(str);
			}
		}while(contabot<3 && contahuman<3);
		
		if(contahuman>contabot) {
			JOptionPane.showMessageDialog(null, "El ganador es el humano");
		}else {
			JOptionPane.showMessageDialog(null, "Gana el bot");

		}
	}
}
