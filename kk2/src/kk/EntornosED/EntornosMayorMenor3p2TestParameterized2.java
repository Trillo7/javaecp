package kk.EntornosED;


import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;

@RunWith (Parameterized.class)
public class EntornosMayorMenor3p2TestParameterized2 {
	private int num1,num2,num3;
	private int[] numtest;
	
	public EntornosMayorMenor3p2TestParameterized2(int num1,int num2,int num3, int[] numtest) {
		this.num1=num1;
		this.num2=num2;
		this.num3=num3;
		this.numtest=numtest;
	}
	@Parameters
	public static Collection<Object[]> numeros(){
		return Arrays.asList(new Object[][] {{3,7,2, new int[] {7,2}}, {3,7,2,  new int[] {7,2}}     });
	}
	
	@Test
	public void testMayormenor() {
		//fail("Not yet implemented");
		int[] mayorymenor=EntornosPrimos3p2.mayormenor(num1,num2,num3);
		assertArrayEquals(numtest,mayorymenor);// esperados, resultado de la prueba

	}

}
