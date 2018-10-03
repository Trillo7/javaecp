package kk.capitulo2c;

import javax.swing.JOptionPane;

public class bloq3ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String mesmenu="MENU\n"
					+ "1- Hipotenusa de un triangulo\n"
					+ "2- Superficie de una circunferencia\n"
					+ "3- Perímetro de una circunferencia\n"
					+ "4- Área de un rectángulo\n"
					+ "5- Área de un triángulo\n"
					+ "0- Salir de aplicación";
			String str = JOptionPane.showInputDialog(mesmenu);
			int opcion=Integer.parseInt(str);
			float num1=0;
			float num2=0;
			if(opcion==2) {
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
				resultado=(float) Math.pow(num1, 2)+ (float)Math.pow(num2, 2) ;
				break;
			case 2:
				resultado=(float) (num1*3.14);
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
