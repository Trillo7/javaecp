package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq2ejer1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int introdnum;
		int suma=0;
		str=JOptionPane.showInputDialog("Cuantos numeros quieres introducir?");
		int numerosfor=Integer.parseInt(str);
		
		for(int i=0;i<numerosfor;i++) {
			str=JOptionPane.showInputDialog("Introduce el numero "+(i+1));
			introdnum=Integer.parseInt(str);
			suma=suma+introdnum;
		}
		JOptionPane.showMessageDialog(null, "La media es: "+suma/numerosfor);
	}
}
