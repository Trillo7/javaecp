package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq3ejer5{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int numintrod=1, i=0,menor=0,mayor=0;
	
		for(i=0;numintrod!=0;i++) {
			str=JOptionPane.showInputDialog("Introduce un numero: (0 para salir)");
			numintrod=Integer.parseInt(str);
			
			if(i==0) {
				menor=numintrod;
				mayor=numintrod;
			}
			if(numintrod==0) {
				
			}else {
				if(numintrod<menor) {
					menor=numintrod;
				}
				if(numintrod>mayor) {
					mayor=numintrod;
				}
			}
		}
		System.out.println("Numero mayor: "+mayor);
		System.out.println("Numero menor: "+menor);
	}
}
