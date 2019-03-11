package repasoFeb.Bloque2Math;

import javax.swing.JOptionPane;

public class b2ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float a=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero a: "));
		float b=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero b: "));
		float c=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero c: "));
		float result=(float) (-b + Math.sqrt((b*b)-(4*a*c)))/(2*a);
		
		if(result<0) {
			System.out.println("La ecuacion no tiene soluciones");
		}
	
	}

}
