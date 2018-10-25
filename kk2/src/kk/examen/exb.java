package kk.examen;

public class exb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = new int[100];
		int x=0;
		//Introducimos los numeros del 99 al 0 en el array
		for(int i=99;i>0;i--) {
			array[x]=i;
			x++;
		}
		//Mostramos el array
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		
	}
}
