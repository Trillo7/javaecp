package kk.capitulo5.bloque4;

public class b4ejer4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] usoarray=new int[5][5];

		//Ejer 1
		rellenamatriz(usoarray);
		//Ejer2
		imprimeMatriz(usoarray);
		//Ejer 3
		System.out.println("La matriz es positiva: "+isPositiva(usoarray));
		//Ejer 4
		if(isDiagonal(usoarray)) {
			System.out.println("La matriz es diagonal");
		}else {
			System.out.println("No es diagonal");
		}
		//Ejer 5
		System.out.println("La matriz es simetrica: "+isSimetrica(usoarray));
		//Ejer 6
		int[][] matriz2=new int[][] {
				{1,0,0,0,0},
				{0,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,1,0},
				{0,0,0,0,1}
				};
		
		System.out.println("La matriz es simetrica: "+isTriangular(matriz2));

	}
	
	public static void rellenamatriz(int[][] usoarray) {
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				int aleat=(int) Math.round(Math.random() * ((100) - -5) + -5);
				usoarray[i][x]=aleat;
			}
		}
		System.out.println("Array rellenado");
	}
	
	public static void imprimeMatriz(int[][] usoarray){
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				System.out.print("["+usoarray[i][x]+"]\t");
			}
			System.out.println(" ");
		}
	}
	
	public static boolean isPositiva(int[][] usoarray){
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				if(usoarray[i][x]<0) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isDiagonal(int[][] usoarray){
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				if(i==x) {
					
				}else {
					if(usoarray[i][x]!=0) {
						return false;
					}
				}
				
			}
		}
		return true;
	}
	
	private static boolean isSimetrica (int usoarray[][]) {

		for (int i = 0; i < usoarray.length; i++) {
			for (int j = 0; j < usoarray[i].length; j++) {
				if (usoarray[i][j] != usoarray[j][i])
					return false;
			}
		}
		return true;
	}
	
	public static boolean isTriangular(int[][] usoarray){
		int contador=0;
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				if(x<=contador) {
						if(usoarray[i][x]!=0) {
							return false;
						}
				}
				
			}
			contador++;
		}
		return true;
	}
}


