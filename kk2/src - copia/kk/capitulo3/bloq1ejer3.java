package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq1ejer3{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int introdnum;
		int suma=0;
		int negativos=0;
		int positivos=0;
		str=JOptionPane.showInputDialog("¿Cuantos numeros quieres introducir?");
		int numerosfor=Integer.parseInt(str);
		
		for(int i=0;i<numerosfor;i++) {
			str=JOptionPane.showInputDialog("Introduce el numero "+(i+1));
			introdnum=Integer.parseInt(str);
			if(introdnum>=0) {
				positivos++;
			}else {
				negativos++;
			}
		}
		JOptionPane.showMessageDialog(null, "Numeros positivos: "+positivos+"\nNumeros negativos: "+negativos);
	}
}
