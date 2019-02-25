package EjerCap6;

public class b2ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float x=(float) 0.001;
		
		while(Math.sqrt(x)!=Math.log(x) || (-Math.log(x)-Math.sqrt(x)<0.001)) {
			x+=0.001;
			System.out.println(x);

		}
		System.out.println(x);
	}

}
