package calculadora;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	calculadoraTestDivide.class, 
	calculadoraTestMultiplica.class, 
	calculadoraTestResta.class,
	calculadoraTestSuma.class })
public class AllTests {

}
