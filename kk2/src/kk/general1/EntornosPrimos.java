package kk.general1;

public class EntornosPrimos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tresprimos=getTresUltimosPrimos(50000);
		for(int i=0;i<3;i++) {
			System.out.println(tresprimos[i]);
		}

	}

	private static int[] getTresUltimosPrimos(int limiteSuperior){
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
	
	private static boolean esPrimo(int num) {
		boolean primo=true;
		for(int i=2;i<num;i++) {
			if(num %i==0) {
				primo=false;
			}
		}
		return primo;
	}
}
