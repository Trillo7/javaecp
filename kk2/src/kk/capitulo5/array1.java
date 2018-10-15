package kk.capitulo5;

import javax.swing.JOptionPane;

public class array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[100];
		int superior=0, inferior=0,suma=0,media=0,mayor=0,menor=0;
		superior=Integer.parseInt(JOptionPane.showInputDialog("Valor máximo de número aleatorio: "));
		inferior=Integer.parseInt(JOptionPane.showInputDialog("Valor mínimo de número aleatorio: "));
		for(int i=0;i<numeros.length;i++) {
			numeros[i]=(int) (Math.random()*((superior+1)-inferior)+inferior);
			System.out.println(numeros[i]);
			suma=suma+numeros[i];
			//mayor
			if(i==0) {
				mayor=numeros[i];
				menor=numeros[i];
			}
			if(numeros[i]>mayor) {
				mayor=numeros[i];
			}
			if(numeros[i]<menor) {
				menor=numeros[i];
			}
		}
		media=suma/100;
		System.out.println("La suma es: "+suma);
		System.out.println("La media es: "+media);
		System.out.println("El mayor es: "+mayor);
		System.out.println("El menor es: "+menor);
	}
}