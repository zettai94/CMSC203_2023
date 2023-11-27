import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: JUnit test for TwoDimRaggedArrayUtility
 * Due: 28th Nov 2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Silvia Lim Siew Ling
*/
class TwoDimRaggedArrayUtilityTestStudent {

	double[][] data = {{1.65, 4.5, 2.36, 7.45, 3.44, 6.22}, {2.22, -3.24, -1.66, -5.48 , 3.46},
			{4.23, 2.29, 5.29}, {2.76, 3.76, 4.29, 5.48, 3.43}, {3.38, 3.36, 3.76},
			{2.46, 3.34, 2.38, 8.26, 5.34}};
	
	File read, write;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		data = null;
		read = null;
		
	}
	
	@Test
	void testWriteToFile() throws IOException{
		write = new File("Testing.txt");
		TwoDimRaggedArrayUtility.writeToFile(data, write);
	}

	@Test
	void testReadFile() throws IOException{
		read = new File("Testing.txt");
		double[][] testing = TwoDimRaggedArrayUtility.readFile(read);
		
		//test first element of first row and last element of last row
		assertEquals(1.65, testing[0][0]);
		assertEquals(5.34, testing[5][4]);
	}

	@Test
	void testGetAverage() {
		double result = TwoDimRaggedArrayUtility.getAverage(data);
		assertEquals(3.14, result, .01);
	}

	@Test
	void testGetTotal() {
		double result = TwoDimRaggedArrayUtility.getTotal(data);
		assertEquals(84.73, result);
	}

	@Test
	void testGetRowTotal() {
		double result = TwoDimRaggedArrayUtility.getRowTotal(data, 0);
		double result2 = TwoDimRaggedArrayUtility.getRowTotal(data, 1);
		assertEquals(25.62, result);
		assertEquals(-4.7, result2);
	}

	@Test
	void testGetColumnTotal() {
		double result = TwoDimRaggedArrayUtility.getColumnTotal(data, 1);
		double result2 = TwoDimRaggedArrayUtility.getColumnTotal(data, 3);
		assertEquals(14.01, result);
		assertEquals(15.71, result2);
	}

	@Test
	void testGetHighestInRow() {
		double result = TwoDimRaggedArrayUtility.getHighestInRow(data, 3);
		double result2 = TwoDimRaggedArrayUtility.getHighestInRow(data, 0);
		assertEquals(5.48, result);
		assertEquals(7.45, result2);
	}

	@Test
	void testGetHighestInRowIndex() {
		int result = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 3);
		int result2 = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0);
		assertEquals(3, result);
		assertEquals(3, result2);
	}

	@Test
	void testGetLowestInRow() {
		double result = TwoDimRaggedArrayUtility.getLowestInRow(data, 4);
		double result2 = TwoDimRaggedArrayUtility.getLowestInRow(data, 1);
		assertEquals(3.36, result);
		assertEquals(-5.48, result2);
	}

	@Test
	void testGetLowestInRowIndex() {
		int result = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 4);
		int result2 = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1);
		assertEquals(1, result);
		assertEquals(3, result2);
	}

	@Test
	void testGetHighestInColumn() {
		double result = TwoDimRaggedArrayUtility.getHighestInColumn(data, 5);
		assertEquals(6.22, result);
	}

	@Test
	void testGetHighestInColumnIndex() {
		int result = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 5);
		assertEquals(0, result);
	}

	@Test
	void testGetLowestInColumn() {
		double result = TwoDimRaggedArrayUtility.getLowestInColumn(data, 1);
		assertEquals(-3.24, result);
	}

	@Test
	void testGetLowestInColumnIndex() {
		int result = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1);
		int result2 = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 4);
		assertEquals(1, result);
		assertEquals(3, result2);
	}

	@Test
	void testGetHighestInArray() {
		double highest = TwoDimRaggedArrayUtility.getHighestInArray(data);
		assertEquals(8.26, highest);
	}

	@Test
	void testGetLowestInArray() {
		double lowest = TwoDimRaggedArrayUtility.getLowestInArray(data);
		assertEquals(-5.48, lowest);
	}

}
