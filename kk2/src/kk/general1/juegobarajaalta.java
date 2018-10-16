package kk.general1;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class juegobarajaalta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Generar numeros aleatorios sin repetir
		String msg="";
		int palohuman=(int) ((Math.random() * ((4 - 1) + 1)) + 1);
		int palobot=(int) ((Math.random() * ((4 - 2) + 1)) + 1);
		while(palohuman==palobot) {
			palobot=(int) ((Math.random() * ((4 - 2) + 1)) + 1);
		}
		
		int barajahuman=(int) ((Math.random() * ((14 - 2) + 1)) + 2);
		int barajabot=(int) ((Math.random() * ((14 - 2) + 1)) + 2);
		while(barajahuman==barajabot) {
			barajabot=(int) ((Math.random() * ((14 - 2) + 1)) + 2);
		}
		
		if(barajahuman==barajabot) {
			if(palohuman>palobot) {
				msg="Has ganado con: ";
			}else {
				msg="Has perdido con: ";
			}
			
		}else {
			if(barajahuman>barajabot) {
				msg="Has ganado con: ";
			}else {
				msg="Has perdido con: ";
			}
		}
		if(barajahuman>10 && barajahuman<=14) {
			switch (barajahuman) {
			case 11:
				msg=msg+" J de";
				break;
			case 12:
				msg=msg+" Q de";
				break;
			case 13:
				msg=msg+" K de";
				break;
			case 14:
				msg=msg+" As de";
				break;
			default:
				break;
			}
		}else {
			msg=msg+barajahuman+" de";
		}
		switch (palohuman) {
		case 1:
			msg=msg+" picas ";
			break;
		case 2:
			msg=msg+" diamantes ";
			break;
		case 3:
			msg=msg+" tréboles ";
			break;
		case 4:
			msg=msg+" corazones ";
			break;
		default:
			break;
		}
		
		System.out.println(palobot);
		System.out.println(palohuman);
		System.out.println(barajahuman);
		System.out.println(barajabot);
		JOptionPane.showMessageDialog(null, msg);
	}
}
