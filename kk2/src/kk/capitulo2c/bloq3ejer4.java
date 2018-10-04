package kk.capitulo2c;

import javax.swing.JOptionPane;

public class bloq3ejer4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//monedas de 100, 50, 25, 5, y 1 unidad
		String mesmenu="Caja registradora Trillo 1.3\nIntroduce el dinero: ";
		String str = JOptionPane.showInputDialog(mesmenu);
		String str2 = JOptionPane.showInputDialog("Introduce precio del producto:");
		float pagado=Float.parseFloat(str);
		float precio=Float.parseFloat(str2);
		float unidades=pagado-precio;
		int unid100=0;
		int unid50=0;
		int unid25=0;
		int unid5=0;
		int unid1=0;
		
		unid100=(int) (unidades/100);
		float restosig=(float) unidades%100;
		unid50=(int) (restosig/50);
		restosig= restosig%50; //restosig%=50; para hacerlo directamente, como el ++
		unid25= (int) (restosig/25);
		restosig= restosig%25;
		unid5= (int) (restosig/5);
		restosig=restosig%5; 
		unid1=(int) (restosig/1);
		JOptionPane.showMessageDialog(null, "Cambio:\n"
				+ "Monedas de 100: "+unid100
				+ "\nMonedas de 50: "+unid50
				+ "\nMonedas de 25: "+unid25
				+ "\nMonedas de 5: "+unid5
				+ "\nMonedas de 1: "+unid1);
	}
	// Como sacariamos los centimos: "int decNumberInt = Integer.parseInt(str.substring(str.indexOf('.') + 1));" o restando los euros
}
