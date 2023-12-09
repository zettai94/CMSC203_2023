import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

	Alcohol al, al2;
	
	@BeforeEach
	void setUp() throws Exception {
		al = new Alcohol("Mohito", Size.LARGE, false);
		al2 = new Alcohol("Mohito", Size.SMALL, true);

	}

	@AfterEach
	void tearDown() throws Exception {
		al = null;
		al2 = null;
	}

	@Test
	void testToString() {
		String expected = "Mohito (LARGE), Normal Price: $4.0";
		String line = al.toString();
		String expected2 = "Mohito (SMALL), Weekend Price: $2.6";
		String line2 = al2.toString();
		assertTrue(expected.equals(line));
		assertTrue(expected2.equals(line2));
	}

	@Test
	void testEqualsObject() {
		Alcohol al3 = new Alcohol("Mohito", Size.LARGE, false);
		assertFalse(al.equals(al2));
		assertTrue(al.equals(al3));
	}

	@Test
	void testCalcPrice() {
		assertEquals(4.0, al.calcPrice());
		assertEquals(2.6, al2.calcPrice());
	}

	@Test
	void testIsWeekend() {
		assertFalse(al.isWeekend());
		assertTrue(al2.isWeekend());
	}

}
