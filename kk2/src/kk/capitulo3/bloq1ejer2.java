package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq1ejer2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int introdnum;
		int suma=0;
		
		for(int i=0;i<4;i++) {
			str=JOptionPane.showInputDialog("Introduce el numero "+(i+1));
			introdnum=Integer.parseInt(str);
			if(introdnum>=10) {
				suma=suma+introdnum;
			}
		}
		JOptionPane.showMessageDialog(null, "La suma es: "+suma);
	}
}
