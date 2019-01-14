package kk.capitulo5.bloque4;

public class b4ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] diezarray=new int[5];

		for(int i=0;i<diezarray.length;i++) {
			int aleat=(int) Math.round(Math.random() * ((100) - 0) + 0);
			diezarray[i]=aleat;
			System.out.println(i+" "+diezarray[i]);
		}
		System.out.println(analizarray(diezarray));
		
	}
	
	public static int analizarray(int[] elarray) {
		if(elarray.length%2==0) {
			return -1;
		}else {
			return elarray[elarray.length/2];
		}
	}
}
