import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	Coffee coffee1, coffee2;
	
	@BeforeEach
	void setUp() throws Exception {
		coffee1 = new Coffee("Mocha", Size.LARGE, true, true);
		coffee2 = new Coffee("Latte", Size.SMALL, false, false);
	}

	@AfterEach
	void tearDown() throws Exception {
		coffee1 = null;
		coffee2 = null;
	}

	@Test
	void testToString() {
		String expected1 = "Mocha (LARGE), Extra Shot, Add Syrup: $5.0";
		String expected2 = "Latte (SMALL), No Extra Shot, No Syrup: $2.0";
		String line1 = coffee1.toString();
		String line2 = coffee2.toString();
		assertTrue(expected1.equals(line1));
		assertTrue(expected2.equals(line2));
		
	}

	@Test
	void testEqualsObject() {
		Coffee coffee3 = new Coffee("Mocha", Size.LARGE, true, true);
		assertTrue(coffee1.equals(coffee3));
		assertFalse(coffee1.equals(coffee2));
	}

	@Test
	void testCalcPrice() {
		assertEquals(5.0, coffee1.calcPrice());
		assertEquals(2.0, coffee2.calcPrice());
	}

	@Test
	void testGetExtraShot() {
		assertTrue(coffee1.getExtraShot());
		assertFalse(coffee2.getExtraShot());
	}

	@Test
	void testGetExtraSyrup() {
		assertTrue(coffee1.getExtraSyrup());
		assertFalse(coffee2.getExtraSyrup());
	}

}
