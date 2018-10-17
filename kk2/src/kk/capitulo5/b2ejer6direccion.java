package kk.capitulo5;

import javax.swing.JOptionPane;

public class b2ejer6direccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[4];
		int direccion=0;
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) Math.round((Math.random()*100));
			System.out.print(" "+numeros[i]);

		}
		direccion=Integer.parseInt(JOptionPane.showInputDialog("Derecha (0) o Izquierda(1)"));
		int mueve=Integer.parseInt(JOptionPane.showInputDialog("Cuantas posiciones quieres mover: "));
		for(int x=0;x<mueve;x++) {
			if(direccion==0) {
				int guarda=numeros[numeros.length-1]; //guardamos el ultimo porque lo sustituimos
				for(int i=numeros.length-2;i>=0;i--) { //empezando por atrás cogemos y lo movemos a la derecha
					numeros[i+1]=numeros[i];
				}
				numeros[0]=guarda;
			}else {
				int guarda=numeros[0];
				for(int i=0;i<numeros.length-1;i++) {
					numeros[i]=numeros[i+1];
				}
				numeros[numeros.length-1]=guarda;
			}
		}
		System.out.println(" ");
		for(int i=0;i<numeros.length;i++) {
			System.out.print(" "+numeros[i]);
		}
	}
}