package calculadora;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;

@RunWith (Parameterized.class)
public class calculadoraTestResta {
	private int numero1;
	private int numero2;
	private int resultado;
	
	public calculadoraTestResta(int numero1, int numero2, int resultado) {
	this.numero1=numero1;
	this.numero2=numero2;
	this.resultado=resultado;
	}

	@Parameters
	public static Collection<Object[]> numeros(){
	return Arrays.asList(new Object[][] {{6,3,3},{6,-3,9},{6,4,3}});
}

	@Test
	public void calculadoraTestResta() {
		calculadora calculadora1=new calculadora(numero1,numero2);
		int result=calculadora1.resta();
		assertEquals(resultado,result);
	}
}
	