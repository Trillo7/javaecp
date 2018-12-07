package kk.examen;

public class exa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = new int[100];
		int suma=0;
		// Introducimos aleatorios en el array
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 1000);
		}
		// Mostramos array
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		//Sumamos y mostramos
		for(int i=0;i<array.length;i++) {
			suma+=array[i];
		}
		System.out.println(" ");
		System.out.println(suma);
		//Media y mostramos
		int media=suma/array.length;
		System.out.println(media);
		// Maximo y mostramos
		int maximo=array[0];
		for(int i=1; i<array.length;i++) {
			if(array[i]>maximo) { //Recorremos el array y vamos quedándonos con el mayor
				maximo=array[i];
			}
		}
		System.out.println(maximo);
		// Mínimo y mostramos
		int mínimo=array[0];
		for(int i=1; i<array.length;i++) {
			if(array[i]<mínimo) { //Recorremos el array y vamos quedándonos con el menor
				mínimo=array[i];
			}
		}
		System.out.println(mínimo);
		
	}
}
