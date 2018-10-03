package kk.capitulo2c;

import javax.swing.JOptionPane;

public class bloq2ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EJERCICIO 1
		int negativos=0;
		int bajos=0;
		int medios=0;
		int mayores=0;
		int introd=0;

		for(int i=0;i<5;i++) {
			String str = JOptionPane.showInputDialog("Introduce un numero: ");
			introd = Integer.parseInt(str);
			
			if(introd<0) {
				i=5;
			}else {
				if(introd>=0 && introd<=25) {
					bajos++;
				}else {
					if(introd>=26 && introd<=250) {
						medios++;
					}else {
						mayores++;
					}
				}
			}
		}
		
		System.out.println("Bajos introducidos: "+bajos);
		System.out.println("Medios introducidos: "+medios);
		System.out.println("Mayores introducidos: "+mayores);
	}

}
