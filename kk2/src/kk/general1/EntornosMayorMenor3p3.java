package kk.general1;

public class EntornosMayorMenor3p3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mayormenor(3,7,2);

	}

	private static void mayormenor(int num1,int num2, int num3){
		int mayor=0;
		int menor=0;
		//Mayor
		if(num1>num2) {
			if(num1>num3) {
				mayor=num1;
			}else {
				mayor=num3;
			}
		}else {
			if(num2>num3) {
				mayor=num2;
			}else {
				mayor=num3;
			}
		}
		//Menor
		if(num1<num2) {
			if(num1<num3) {
				menor=num1;
			}else {
				menor=num3;
			}
		}else {
			if(num2<num3) {
				menor=num2;
			}else {
				menor=num3;
			}
		}
		System.out.println("El mayor es: "+mayor);
		System.out.println("El menor es: "+menor);
	}
	
}
