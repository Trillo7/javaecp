package kk.capitulo5.bloque4;

import javax.swing.JOptionPane;

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
		//Ejer 5 Triangular
		int[][] matriz2=new int[][] {
				{1,0,0,0,0},
				{0,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,1,0},
				{0,0,0,0,1}
				};
		
		System.out.println("La matriz es simetrica: "+isTriangular(matriz2));
		//Ejer 6 
		rellenaDispersa(usoarray);
		imprimeMatriz(usoarray);
		int[][] matriz3=new int[][] {
			{0,2,2,2,0},
			{2,0,2,0,2},
			{2,2,0,3,4},
			{2,0,2,2,2},
			{1,0,1,5,1}
			};
	
		if(isDispersa(matriz3)) {
			System.out.println("Matriz Dispersa");
		}else {
			System.out.println("No dispersa");
		}
		//Ejer 7
		matriztoarray(usoarray);
		imprimeArray(matriztoarray(usoarray));
		//Ejer 8
		System.out.println("La matriz es simetrica: "+isSimetrica(usoarray));
		//Ejer 9 Traspuesta
		int[][] matriz4=new int[][] {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{6,7,8,9,10},
			};
		imprimeMatriz(matriz4);
		imprimeMatriz(matrizTraspuesta(matriz4));
		//Ejer 10 Opuesta
		imprimeMatriz(usoarray);
		imprimeMatriz(matrizOpuesta(usoarray));
		//Ejer 11 Eliminar fila de array
		imprimeMatriz(usoarray);
		imprimeMatriz(eliminarFila(usoarray));
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
			for(int x=0;x<usoarray[0].length;x++) {
				System.out.print("["+usoarray[i][x]+"]\t");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
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
	
	public static boolean isTriangular(int[][] usoarray){
		int contador=0;
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				if(x<contador) {
						if(usoarray[i][x]!=0) {
							return false;
						}
				}
				
			}
			contador++;
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
	
	public static void rellenaDispersa(int[][] usoarray) {
		for(int i=0;i<usoarray.length;i++) {
			int anulo=(int) Math.round(Math.random() * ((5) - 0) + 0);
			for(int x=0;x<usoarray.length;x++) {
				if(x==anulo) {
					usoarray[i][x]=0;
				}else {
					int aleat=(int) Math.round(Math.random() * ((100) - -5) + -5);
					usoarray[i][x]=aleat;
				}
			}
		}
	}
	public static boolean isDispersa(int[][] usoarray) {
		boolean dispersa=false;
		boolean dispfinal=true;
		int contador=0;
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				if(usoarray[i][x]==0) {
					dispersa=true;
				}
			}
			if(dispersa==true) {
				contador++;
			}
			dispersa=false;
		}
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				if(usoarray[x][i]==0) {
					dispersa=true;
				}
			}
			if(dispersa==true) {
				contador++;
			}
			dispersa=false;
		}
		if(contador==usoarray.length+usoarray[0].length) {
			dispfinal=true;
		}else {
			dispfinal=false;
		}
		System.out.println("contador "+contador);
		return dispfinal;
	}
	public static int[] matriztoarray(int[][]usoarray) {
		int[] arrayconvertido = new int[usoarray.length*usoarray[0].length];
		int h=0;
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				arrayconvertido[h]=usoarray[i][x];
				h++;
			}
		}
		return arrayconvertido;
	}
	public static void imprimeArray(int[] usoarray) {
		for(int i=0;i<usoarray.length;i++) {
			System.out.print("["+usoarray[i]+"] ");
		}
		System.out.println(" ");
	}
	
	public static int[][] matrizTraspuesta(int[][] usoarray){
		int[][] arraytraspuesto=new int[usoarray[0].length][usoarray.length];//[5][2]
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray[0].length;x++) {
				arraytraspuesto[x][i]=usoarray[i][x];
			}
		}
		return arraytraspuesto;
	}
	
	public static int[][] matrizOpuesta(int[][]usoarray) {
		int[][] arrayopuesto = new int[usoarray[0].length][usoarray.length];
	
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				arrayopuesto[i][x]=(usoarray[i][x]*-1);
			}
		}
		return arrayopuesto;
	}
	public static int[][] eliminarFila(int[][]usoarray) {
		boolean eliminada=false;
		int fila=Integer.parseInt(JOptionPane.showInputDialog("Introduce una fila a eliminar: "));
		int[][] arraysinfila = new int[usoarray[0].length-1][usoarray.length];
		for(int i=0;i<usoarray.length;i++) {
			for(int x=0;x<usoarray.length;x++) {
				if(i==fila) {
					eliminada=true; //bandera porque si no da error de outofbounds al escribir en la i con una mas ya que tenemos una fila menos
				}else {
					if(eliminada) {
						arraysinfila[i-1][x]=usoarray[i][x];
					}else {
						arraysinfila[i][x]=usoarray[i][x];
					}
					
				}
				
			}
		}
		return arraysinfila;
	}
}


