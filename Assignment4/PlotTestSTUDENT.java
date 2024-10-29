import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*Name: Silvia Lim Siew Ling
 * Student ID: M21154781
 * Class: CMSC 203
 * Project: 4
 * Due date: 4th Nov 2023*/
class PlotTestSTUDENT {

	private Plot p1, p2, p3, p4, p5, p6, p7, p8;
	
	@BeforeEach
	void setUp() throws Exception {
		 p1 = new Plot(2,2,6,6); 
         p2 = new Plot(1,1,3,2);
         p3 = new Plot(6,1,4,2);
         p4 = new Plot(3,4,4,3);
         p5 = new Plot(6,5,3,1);
         p6 = new Plot(1,4,2,1);
         p7 = new Plot(9,2,2,2);
         p8 = new Plot(2,2,2,1);
	}

	@AfterEach
	void tearDown() throws Exception {
		 p1 = null;
         p2 = null;
         p3 = null;
         p4 = null;
         p5 = null;
         p6 = null;
         p7 = null;
         p8 = null;
	}

	@Test
	void testPlot1() {
		 assertTrue(p1.overlaps(p2)); //p2 overlaps the lower left corner of p1
         assertTrue(p2.overlaps(p1));
	}


	@Test
	void testEncompasses() {
        assertTrue(p1.encompasses(p4)); //p5 within p1
        assertFalse(p4.encompasses(p1));
        assertTrue(p1.encompasses(p8)); //p8 within p1
        assertFalse(p8.encompasses(p1)); 
        assertFalse(p2.encompasses(p1)); //p2 does not encompass p1
        assertFalse(p1.encompasses(p2)); //p1 does not encompass p2
	}

	@Test
	void testOverlaps() {
		assertTrue(p1.overlaps(p2)); //p1 overlaps the lower left corner of p2
        assertTrue(p2.overlaps(p1));
        assertTrue(p1.overlaps(p3)); //p1 overlaps the lower right corner of p3
        assertTrue(p3.overlaps(p1));
	}
	
	@Test
	void testOverlaps2() {
       assertTrue(p1.overlaps(p6)); //p6 overlaps the left side of p1
       assertTrue(p6.overlaps(p1));
       assertTrue(p1.overlaps(p5)); //p5 overlaps the right side of p1
       assertTrue(p5.overlaps(p1));
	}

	@Test
	void testToString() {
		String expected = "2,2,6,6";
		assertTrue(expected.equals(p1.toString()));
	}

}
