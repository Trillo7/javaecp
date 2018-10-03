package kk.capitulo2c;

import javax.swing.JOptionPane;

public class bloq2ejer1 {

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
				negativos=negativos+introd;
			}else {
				if(introd>=0 && introd<=25) {
					bajos=bajos+introd;
				}else {
					if(introd>=26 && introd<=250) {
						medios=medios+introd;
					}else {
						mayores=mayores+introd;
					}
				}
			}
			
		}
		System.out.println("La suma de los negativos son: "+negativos);
		System.out.println("La suma de los bajos son: "+bajos);
		System.out.println("La suma de los medios son: "+medios);
		System.out.println("La suma de los mayores son: "+mayores);



	}

}
