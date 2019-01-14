package kk.capitulo5.bloque4;

public class b4ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float[] usoarray=new float[20];

		for(int i=0;i<usoarray.length;i++) {
			int aleat=(int) Math.round(Math.random() * ((100) - 0) + 0);
			float aleadec=(float) Math.random();
			usoarray[i]=aleat+aleadec;
			System.out.println(i+" "+usoarray[i]);
		}
		cuantosdecimales(usoarray);
		
	}
	
	public static void cuantosdecimales(float[] elarray) {
		int contador=0;
		for(int i=0;i<elarray.length;i++) {
			int entera=(int) elarray[i];
			float decimal=elarray[i]-entera;
			if(decimal>=0 && decimal<0.49) {
				contador++;
			}
		}
		System.out.println("Partes decimales comprendidas entre .00 y .49: "+contador);
	}
}
