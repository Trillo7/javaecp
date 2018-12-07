package kk.capitulo3;

import javax.swing.JOptionPane;

public class bloq3ejer4dowhile{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int numintrod=1, i=0,menor=0;
	
		
		do {
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
		}while(numintrod!=0);
		System.out.println("Numero menor: "+menor);
	}
}
