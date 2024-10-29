import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*Name: Silvia Lim Siew Ling
 * Student ID: M21154781
 * Class: CMSC 203
 * Project: 4
 * Due date: 4th Nov 2023*/
public class ManagementCompanyTestSTUDENT {
	Property s1, s2, s3, s4, s5, s6, s7, s8;
	ManagementCompany comp1, comp2, empty;

	@BeforeEach
	void setUp() throws Exception {
		s1 = new Property("Property1", "A", 100, "Me", 1, 1, 1, 1);
    	s2 = new Property("Property2", "B", 200, "Me", 3, 1, 1, 1);
    	s3 = new Property("Property3", "C", 900, "Me", 6, 1, 1, 1);
    	s4 = new Property("Property4", "D", 400, "Me", 1, 3, 2, 1);
    	s5 = new Property("Property5", "E", 500, "Me", 8, 6, 1, 2);
    	
    	//to exceed array
    	s6 = new Property("Property6", "F", 600, "Me", 5, 8, 2, 1);
    	
    	//to overlap s5
    	s7 = new Property("Property7", "G", 500, "Me", 8, 6, 1, 2);
    	comp1 = new ManagementCompany("Seligman", "123456", 6);
    
	}
    	
	@AfterEach
	void tearDown() throws Exception {
		empty = null;
		s8 = null;
	}

	@Test
	void testAddProperty1() {
		empty = new ManagementCompany("TestingCompany", "9988", 8);
		empty.addProperty(s5);
		assertTrue(empty.getPlot().encompasses(s5.getPlot()));//ManagementCompany's plot encompass s5's plot
		assertEquals(empty.addProperty(s7), -4); //property s7's plot overlap s5, was not added successfully
		
	}

	@Test
	void testAddProperty2() {
		empty = new ManagementCompany(comp1);
		s8 = new Property("Testing Property", "Rockville", 650, "June", 20, 2, 1, 1);
		assertEquals(empty.addProperty(s8), -3); //addProperty returns -3 since s8's plot not encompass
	}


	@Test
	void testRemoveLastProperty() {
		empty = new ManagementCompany(comp1);
		assertEquals(empty.addProperty(s1), 0); //indicate property added into index 0
		empty.removeLastProperty(); //delete last property added
		assertEquals(empty.getPropertiesCount(), 0); //last property added successfully delete
	}

	@Test
	void testIsPropertiesFull() {
		empty = new ManagementCompany(comp1);
		empty.addProperty(s1);
		empty.addProperty(s2);
		empty.addProperty(s3);
		empty.addProperty(s4);
		empty.addProperty(s5);
		assertEquals(empty.getTotalRent(), 2100);
		assertEquals(empty.addProperty(s6), -1); //addProperty returns -1; property was not added successfully
	
	}

	@Test
	void testIsManagementFeeValid() {
		empty = new ManagementCompany("Testing", "1122", 1000);
		assertFalse(empty.isManagementFeeValid());
	}

	@Test
	void testToString() {
		empty = new ManagementCompany(comp1);
		assertEquals(empty.addProperty(s1), 0); //indicate property added into index 0
		assertEquals(empty.getPropertiesCount(), 1); //property count now is at 1
		String expected = "List of the properties for Seligman, taxID: 123456\n" +
							"______________________________________________________\n"
							+ "Property Name: Property1\n"
							+ "Located in A\n"
							+ "Belonging to: Me\n" 
							+ "Rent Amount: 100.0\n"
							+ "______________________________________________________\n"
							+ "\n total management Fee: 6.0";
		
		assertEquals(expected, empty.toString());
		
	}

}
