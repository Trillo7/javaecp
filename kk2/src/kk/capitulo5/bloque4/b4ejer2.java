package kk.capitulo5.bloque4;

public class b4ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] usoarray=new int[21];

		for(int i=0;i<usoarray.length;i++) {
			int aleat=(int) Math.round(Math.random() * ((10) - 0) + 0);
			usoarray[i]=aleat;
			System.out.println(i+" "+usoarray[i]);
		}
		notasarray(usoarray);
		
	}
	
	public static void notasarray(int[] elarray) {
		float aprobadas=0;
		float suspensas=0;
		for(int i=0;i<elarray.length;i++) {
			if(elarray[i]>=5) {
				aprobadas++;
			}else {
				suspensas++;
			}
		}
		float poraprobadas=aprobadas*100/elarray.length;
		float porsuspensas=suspensas*100/elarray.length;
		System.out.println("Hay aprobadas: "+poraprobadas+"%");
		System.out.println("Hay suspensas: "+porsuspensas+"%");
	}
}
