package repasoFeb.Bloque2Math;

public class b2ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(float x=0.0001f;x<1;x+=0.0001) {
			float y1=(float) Math.sqrt(x);
			System.out.println("x: "+x+", y1: "+y1);
			float y2=(float)(0 - Math.log(x));
			System.out.println("x: "+x+", y2= -ln(x): "+y2);
			
			if(Math.abs(y2-y1)<0.0001) {
				System.out.println("Solución encontrada en x="+x+", y="+y1);
				break;
			}
		}
	}
}
