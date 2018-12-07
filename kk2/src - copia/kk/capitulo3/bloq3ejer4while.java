package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq3ejer4while{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int numintrod=1, i=0,menor=0;
	
		
		while(numintrod!=0) {
			str=JOptionPane.showInputDialog("Introduce un numero: (0 para salir)");
			numintrod=Integer.parseInt(str);
			
			if(i==0) {
				menor=numintrod;
			}
			if(numintrod==0) {
				
			}else if(numintrod<menor) {
				menor=numintrod;
			}
			i++;
		}
		System.out.println("Numero menor: "+menor);
	}
}
