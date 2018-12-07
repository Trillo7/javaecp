package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq2ejer2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int introdnum, mayor=0, menor=0;
		str=JOptionPane.showInputDialog("Cuantos numeros quieres introducir?");
		int numerosfor=Integer.parseInt(str);
		
		for(int i=0;i<numerosfor;i++) {
			str=JOptionPane.showInputDialog("Introduce el numero "+(i+1));
			introdnum=Integer.parseInt(str);
			if(i==0) {
				mayor=introdnum;
				menor=introdnum;
			}
			if(introdnum>mayor) {
				mayor=introdnum;
			}
			if(introdnum<menor) {
				menor=introdnum;
			}
		}
		JOptionPane.showMessageDialog(null, "El mayor es: "+mayor+"\nEl menor es: "+menor);
	}
}
