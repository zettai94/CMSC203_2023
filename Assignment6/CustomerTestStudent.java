import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {
	
	Customer cust1, cust2;

	@BeforeEach
	void setUp() throws Exception {
		cust1 = new Customer("Catherine", 18);
		cust2 = new Customer("Joseph", 30);
	}

	@AfterEach
	void tearDown() throws Exception {
		cust1 = null;
		cust2 = null;
	}

	@Test
	void testGetAge() {
		assertEquals(18, cust1.getAge());
		assertEquals(30, cust2.getAge());
		
	}

	@Test
	void testGetName() {
		String name = "Catherine";
		String another = "John";
		assertTrue(name.equals(cust1.getName()));
		assertFalse(another.equals(cust2.getName()));
	}

	@Test
	void testSetAge() {
		assertEquals(18, cust1.getAge());
		cust1.setAge(20);
		assertEquals(20, cust1.getAge());
	}

	@Test
	void testSetName() {
		assertTrue(cust1.getName().equals("Catherine"));
		String name = "Jupiter";
		cust1.setName(name);
		assertTrue(name.equals(cust1.getName()));
	}

	@Test
	void testToString() {
		String expected = "Customer information: Catherine,18";
		String expected2 = "Customer information: Joseph,30";
		assertTrue(expected.equals(cust1.toString()));
		assertTrue(expected2.equals(cust2.toString()));
		
	}

}
