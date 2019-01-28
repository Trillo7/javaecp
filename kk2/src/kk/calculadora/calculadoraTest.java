package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author miguel
 *
 */
class calculadoraTest {

	/**
	 * @throws java.lang.Exception
	 */
	private static calculadora calculadora1;
	private static int resultado;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		calculadora1=new calculadora(5,3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}
;
	/**
	 * Test method for {@link calculadora.calculadora#suma()}.
	 */
	@Test
	void testSuma() {
		resultado=calculadora1.suma();
		assertEquals(8,resultado);
	}

	/**
	 * Test method for {@link calculadora.calculadora#resta()}.
	 */
	@Test
	void testResta() {
		int resultado=calculadora1.resta();
		assertEquals(2,resultado);
	}

	/**
	 * Test method for {@link calculadora.calculadora#multiplica()}.
	 */
	@Test
	void testMultiplica() {
		int resultado=calculadora1.multiplica();
		assertEquals(8,resultado);
	}

	/**
	 * Test method for {@link calculadora.calculadora#divide()}.
	 */
	@Test
	void testDivide() {
		int resultado=calculadora1.divide();
		assertEquals(8,resultado);
	}

}

