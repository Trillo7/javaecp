package kk.EntornosED;


import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;

@RunWith (Parameterized.class)
public class EntornosPrimos3p2TestParameterized {
	private int num1;
	private int num3[];

	public EntornosPrimos3p2TestParameterized(int num1, int[] num3) {
		this.num1=num1;
		this.num3=num3;
	}
	
	@Parameters
	public static Collection<Object[]> numeros(){
	return Arrays.asList(new Object[][] {{50, new int[] {47,43,41}}, {50, new int[] {47,43,41}}     });
	}
	
	@Test
	public void testGetTresUltimosPrimos() {
		int[] tresprimos=EntornosPrimos3p2.getTresUltimosPrimos(num1);
		assertArrayEquals(num3,tresprimos);
	}

}
