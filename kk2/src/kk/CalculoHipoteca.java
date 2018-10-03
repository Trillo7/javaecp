package kk;

public class CalculoHipoteca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float euribor=(float) -0.167;
		float diferencial=(float)0.89;
		int capital= 500000;
		int meses=120;
		
		float interesAnual=(float) euribor+diferencial;
		float interesMensual=(float) (interesAnual/12)/100;
		float cuotaMensual=(float) (capital * ((interesMensual* Math.pow(1+interesMensual,meses))/(Math.pow(1+interesMensual, meses)-1)));
		System.out.println("La cuota mensual es: "+cuotaMensual);
	
	}
}
