package kk.capitulo2c;

import javax.swing.JOptionPane;

public class bloq3ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String mesmenu="MENU\n"
					+ "1: Suma\n"
					+ "2: Resta\n"
					+ "3: Multiplicaci�n\n"
					+ "4: Divisi�n\n"
					+ "5: Raices\n"
					+ "6: Potencias\n"
					+ "7: Resto divisi�n\n"
					+ "8: Raíz n-ésima ";
			String str = JOptionPane.showInputDialog(mesmenu);
			int opcion=Integer.parseInt(str);
			float num1=0;
			float num2=0;
			if(opcion==5) {
				str = JOptionPane.showInputDialog("Introduce un numero: ");
				num1=Float.parseFloat(str);
			}else {
				str = JOptionPane.showInputDialog("Introduce un numero: ");
				num1=Float.parseFloat(str);
				str = JOptionPane.showInputDialog("Introduce un numero: ");
				num2=Float.parseFloat(str);
			}
		
			float resultado=0;
			switch(opcion) {
			case 1: 
				resultado=num1+num2;
				break;
			case 2:
				resultado=num1-num2;
				break;
			case 3:
				resultado=num1*num2;
				break;
			case 4:
				resultado=num1/num2;
				break;
			case 5:
				resultado=(float) Math.sqrt(num1);
				break;
			case 6:
				resultado=(float) Math.pow(num1, num2);
				break;
			case 7:
				resultado=num1%num2;
				break;
			case 8:
				resultado=(float) Math.pow(num2,1/num1);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Error. Introduce una opci�n del men�.");
				System.exit(1);
			}
			
			JOptionPane.showMessageDialog(null, "Resultado: "+resultado);
	}

}
