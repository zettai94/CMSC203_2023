import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	//#Task #2: create test class for GradeBook
	private GradeBook g1;
	private GradeBook g2;
	private GradeBook g3;
	
	
	@BeforeEach
	void setUp() throws Exception {
		//Task #3: create at least 2 objects of GradeBook to hold 5 scores,
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g3 = new GradeBook(1);
		
		
		//Task #3: call addScore method for each of GradeBook objects at least twice (no more than 5 times)
		// to add some random scores of your choice to the GradeBook objects
		g1.addScore(50);
		g1.addScore(75);
		g2.addScore(90);
		g2.addScore(80);
		g2.addScore(100);
		g2.addScore(70);
		g3.addScore(95);

	}

	@AfterEach
	void tearDown() throws Exception {
		//Task #3: set two objects of the GradeBook to null
		g1 = null;
		g2 = null;
		g3 = null;
	}

	@Test
	void testAddScore() {
		//Task 4: use toString method to compare the content of what is in scores array
		//vs what is expected in the scores array
		assertTrue(g1.toString().equals("50.0 75.0 "));
		assertTrue(g2.toString().equals("90.0 80.0 100.0 70.0 "));
		assertTrue(g3.toString().equals("95.0 "));
	}

	@Test
	void testSum() {
		//Task 4: compare what is returned by sum of the score entered
		assertEquals(125, g1.sum(), .0001);
		assertEquals(340, g2.sum(), .0001);
		assertEquals(95, g3.sum(), .0001);
	}

	@Test
	void testMinimum() {
		//Task #4: compare what is returned by minimum to the expected minimum of scores entered
		assertEquals(50, g1.minimum(), .001);
		assertEquals(70, g2.minimum(), .001);
		assertEquals(95, g3.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		//Task #4: Compare what is returned by finalScore to the expected finalScores of the scores entered
		//finalScores of the sum of the scores with the lowest score dropped if there are at least 2 scores,
		//or 0 if there are no scores
		assertEquals(75, g1.finalScore());
		assertEquals(270, g2.finalScore());
		assertEquals(95, g3.finalScore());
	}

	@Test
	void testGetScoreSize() {
		//Task 4: compare scoreSize to the expected number of scores entered
		assertEquals(2, g1.getScoreSize());
		assertEquals(4, g2.getScoreSize());
		assertEquals(1, g3.getScoreSize());
	}

	@Test
	void testToString() {
		assertTrue(g1.toString().equals("50.0 75.0 "));
		assertTrue(g2.toString().equals("90.0 80.0 100.0 70.0 "));
		assertTrue(g3.toString().equals("95.0 "));
	}

}
