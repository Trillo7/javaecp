package kk.EntornosED;

public class EntornosPrimos3p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tresprimos=getTresUltimosPrimos(50);
		for(int i=0;i<3;i++) {
			System.out.println(tresprimos[i]);
		}
		int[] mayorymenos=mayormenor(3,7,2);

	}

	public static int[] getTresUltimosPrimos(int limiteSuperior){
		int ultimosPrimos[]=new int[] {-1,-1,-1};
		int contador=0;
		
		for(int i=limiteSuperior;i>0;i--) {
			if(esPrimo(i)) {
				ultimosPrimos[contador]=i;
				contador++;
			}
			if(contador==3) {
				return ultimosPrimos;
			}
		}
		return ultimosPrimos;
	}
	
	public static boolean esPrimo(int num) {
		boolean primo=true;
		for(int i=2;i<num;i++) {
			if(num %i==0) {
				primo=false;
			}
		}
		return primo;
	}
	public static int[] mayormenor(int num1,int num2, int num3){
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
		int[] mayorymenor= {mayor,menor};
		System.out.println("El mayor es: "+mayor);
		System.out.println("El menor es: "+menor);
		return mayorymenor;
	}

}
