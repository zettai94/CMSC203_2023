import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayTest {
	
	Day day, day2, day3;

	@BeforeEach
	void setUp() throws Exception {
		day = Day.SATURDAY;
		day2 = Day.MONDAY;
		day3 = Day.FRIDAY;
	}

	@AfterEach
	void tearDown() throws Exception {
		day = null;
		day2= null;
		day3 = null;
	}

	@Test
	void test() {
		assertEquals(7, Day.values().length);
		assertFalse(Day.TUESDAY.equals(day));
		assertTrue(Day.MONDAY.equals(day2));
		assertFalse(Day.SATURDAY.equals(day3));
		assertTrue(Day.FRIDAY.equals(day3));
	}

}
