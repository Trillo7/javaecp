package kk.general1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EntornosPrimos3p2Test {

	@Test
	void testMain() {
		int[] tresprimos=EntornosPrimos3p2.getTresUltimosPrimos(50);
		assertArrayEquals(new int[]{47,43,41},tresprimos);
	}


}
