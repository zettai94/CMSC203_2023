import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {
	
	Smoothie smooth1, smooth2, smooth3;

	@BeforeEach
	void setUp() throws Exception {
		smooth1 = new Smoothie("Banana Smoothie", Size.SMALL, 1, false);
		smooth2 = new Smoothie("Strawberry Smoothie", Size.LARGE, 5, false);
		smooth3 = new Smoothie("Mixed Berry Smoothie", Size.MEDIUM, 4, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		smooth1 = null;
		smooth2 = null;
		smooth3 = null;
	}

	@Test
	void testToString() {
		String expected = "Banana Smoothie (SMALL), No Protein Powder, 1 fruits: $2.5";
		String line1 = smooth1.toString();
		String expected3 = "Mixed Berry Smoothie (MEDIUM), With Protein Powder, 4 fruits: $6.5";
		System.out.println(smooth3);
		String line3 = smooth3.toString();
		assertTrue(expected.equals(line1));
		assertTrue(expected3.equals(line3));
	}

	@Test
	void testEqualsObject() {
		Smoothie another = new Smoothie("Strawberry Smoothie", Size.LARGE, 5, false);
		Smoothie another1 = new Smoothie("Strawberry Smoothie", Size.SMALL, 5, false);
		assertTrue(smooth2.equals(another));
		assertFalse(smooth3.equals(another));
		assertFalse(another1.equals(another));
	}

	@Test
	void testCalcPrice() {
		assertEquals(2.5, smooth1.calcPrice());
		assertEquals(6.5, smooth2.calcPrice());
		assertEquals(6.5, smooth3.calcPrice());
	}

	@Test
	void testGetNumOfFruits() {
		assertEquals(1, smooth1.getNumOfFruits());
		assertEquals(5, smooth2.getNumOfFruits());
		assertEquals(4, smooth3.getNumOfFruits());
	}

	@Test
	void testGetAddProtein() {
		assertFalse(smooth1.getAddProtein());
		assertFalse(smooth2.getAddProtein());
		assertTrue(smooth3.getAddProtein());
	}


}
