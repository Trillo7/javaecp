package kk.examen;

public class exc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = new int[20];
		//Introducimos numeros aleatorios
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}
		//Mostramos el array
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i]+" Sus divisores: "); // Mostramos el numero
			for(int x=1;x<array[i];x++) {
				if(array[i]%x==0) { // Si es divisor lo mostramos
					System.out.print(" "+x);
				}
			}
			System.out.println(" "); // Salto de linea para el siguiente numero
		}
		
	}
}
