import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: JUnit testing for HolidayBonus
 * Due: 28th Nov 2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Silvia Lim Siew Ling
*/

class HolidayBonusTestStudent {

	double[][] data1 = {{1, 9, 3} , {2, 7}, {8, 6, 5, 4}};
	double[][] data2 = {{1.65, 4.5, 2.36, 7.45, 3.44, 6.22}, {2.22, -3.24, -1.66, -5.48 , 3.46},
						{4.23, 2.29, 5.29}, {2.76, 3.76, 4.29, 5.48, 3.43}, {3.38, 3.36, 3.76},
						{2.46, 3.34, 2.38, 8.26, 5.34}};
	
	
	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
		data1 = null;
		data2 = null;
	}

	@Test
	void testCalculateHolidayBonus() {
		double[] result1 = HolidayBonus.calculateHolidayBonus(data1);
		double[] result2 = HolidayBonus.calculateHolidayBonus(data2);
		
		//calculate for result1
		assertEquals(result1[0], 7000);
		assertEquals(result1[1], 4000);
		assertEquals(result1[2], 16000);
		
		//calculate for result2
		assertEquals(result2[0], 17000);
		assertEquals(result2[1], 4000);
		assertEquals(result2[2], 12000);
		assertEquals(result2[3], 9000);
		assertEquals(result2[4], 6000);
		assertEquals(result2[5], 16000);
		
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		double result1 = HolidayBonus.calculateTotalHolidayBonus(data1);
		double result2 = HolidayBonus.calculateTotalHolidayBonus(data2);
		assertEquals(result1, 27000);
		assertEquals(result2, 64000);
	}

}
