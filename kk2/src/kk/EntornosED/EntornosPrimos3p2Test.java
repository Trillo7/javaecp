package kk.EntornosED;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EntornosPrimos3p2Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testGetTresUltimosPrimos() {
		int[] tresprimos=EntornosPrimos3p2.getTresUltimosPrimos(50);
		assertArrayEquals(new int[]{47,43,41},tresprimos);
	}

	@Test
	void testMayormenor() {
		//fail("Not yet implemented");
		int[] mayorymenor=EntornosPrimos3p2.mayormenor(3,7,2);
		assertArrayEquals(new int[]{7,2},mayorymenor);// esperadoros, resultado de la prueba

	}

}
