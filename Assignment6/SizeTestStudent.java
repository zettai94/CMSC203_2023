import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SizeTestStudent {

	Size size, size2, size3;
	
	@BeforeEach
	void setUp() throws Exception {
		size = Size.SMALL;
		size2 = Size.MEDIUM;
		size3 = Size.LARGE;
	}

	@AfterEach
	void tearDown() throws Exception {
		size = null;
		size2 = null;
		size3 = null;
	}

	@Test
	void test() {
		assertEquals(3, Size.values().length);
		assertEquals(Size.SMALL, size);
		assertTrue(Size.MEDIUM.equals(size2));
		assertFalse(Size.SMALL.equals(size3));
	}

}
