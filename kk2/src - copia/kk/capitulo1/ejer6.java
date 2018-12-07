package kk.capitulo1;

import javax.swing.JOptionPane;

public class ejer6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//float euribor=(float) -0.167;
		//float diferencial=(float)0.89;
		//int capital= 500000;
		//int meses=120;
		
		String str = JOptionPane.showInputDialog("Introduce el euribor: ");
		float euribor = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduce el diferencial: ");
		float diferencial = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduce el capital: ");
		int capital = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduce los meses: ");
		int meses = Integer.parseInt(str);
		
		float interesAnual=(float) euribor+diferencial;
		float interesMensual=(float) (interesAnual/12)/100;
		float cuotaMensual=(float) (capital * ((interesMensual* Math.pow(1+interesMensual,meses))/(Math.pow(1+interesMensual, meses)-1)));
		System.out.println("La cuota mensual es: "+cuotaMensual);
	
	}
}
