import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {
	
	Order order1, order2;

	@BeforeEach
	void setUp() throws Exception {
		order1 = new Order(8, Day.SATURDAY, new Customer("Mary", 18));
		order2 = new Order(12, Day.TUESDAY, new Customer("John", 25));
	}

	@AfterEach
	void tearDown() throws Exception {
		order1 = null;
		order2 = null;
	}

	@Test
	void testGenerateOrder() {
		Order order3 = new Order(8, Day.SATURDAY, new Customer("Luke", 18));
		int orderNum3 = order3.getOrderNo();
		assertEquals(orderNum3, order3.getOrderNo());
	}

	@Test
	void testGetOrderNo() {
		int orderNum = order1.getOrderNo();
		assertEquals(orderNum, order1.getOrderNo());
	}

	@Test
	void testGetOrderTime() {
		assertEquals(8, order1.getOrderTime());
		assertEquals(12, order2.getOrderTime());
	}

	@Test
	void testGetOrderDay() {
		assertTrue(Day.SATURDAY.equals(order1.getOrderDay()));
		assertFalse(Day.WEDNESDAY.equals(order2.getOrderDay()));
		
	}

	@Test
	void testGetCustomer() {
		Customer samePerson = order1.getCustomer();
		assertTrue(samePerson.getName().equals(order1.getCustomer().getName()));
		assertEquals(samePerson.getAge(), (order1.getCustomer().getAge()));
	}

	@Test
	void testGetDay() {
		Day one = order1.getDay();
		Day two = order2.getDay();
		assertEquals(Day.SATURDAY, one);
		assertEquals(Day.TUESDAY, two);
	}

	@Test
	void testIsWeekend() {
		boolean weekend = order1.isWeekend();
		assertEquals(true, weekend);
	}

	@Test
	void testGetBeverage() {
		order1.addNewBeverage("Strawberry" , Size.SMALL, 2, false);
		assertEquals("Strawberry", order1.getBeverage(0).getBevName());
		assertEquals(Size.SMALL, order1.getBeverage(0).getSize());
		assertEquals(Type.SMOOTHIE, order1.getBeverage(0).getType());
	}

	@Test
	void testGetTotalItems() {
		order1.addNewBeverage("Strawberry" , Size.SMALL, 2, false);
		order1.addNewBeverage("Strawberry" , Size.SMALL, 2, false);
		order1.addNewBeverage("Strawberry" , Size.SMALL, 2, false);
		assertEquals(3, order1.getTotalItems());
		order2.addNewBeverage("Mocha" , Size.SMALL, false, false);
		order2.addNewBeverage("Strawberry" , Size.SMALL, 2, false);
		assertEquals(2, order2.getTotalItems());
	}

	@Test
	void testAddNewBeverageStringSizeBooleanBoolean() {
		order1.addNewBeverage("Banana" , Size.LARGE, 2, false);
		assertEquals(1, order1.getTotalItems());
		assertEquals(0, order2.getTotalItems());
		order1.addNewBeverage("Mohito", Size.SMALL);
		assertEquals(2, order1.getTotalItems());
		assertEquals(0, order2.getTotalItems());
		order2.addNewBeverage("Mocha" , Size.SMALL, false, false);
		assertEquals(2, order1.getTotalItems());
		assertEquals(1, order2.getTotalItems());
	}


	@Test
	void testCalcOrderTotal() {
		order1.addNewBeverage("Banana" , Size.LARGE, 2, false);
		order1.addNewBeverage("Banana" , Size.LARGE, 2, false);
		order1.addNewBeverage("Banana" , Size.LARGE, 2, false);
		order1.addNewBeverage("Banana" , Size.LARGE, 2, false);
		assertEquals(20, order1.calcOrderTotal());
	}

	@Test
	void testFindNumOfBeveType() {
		order1.addNewBeverage("Banana" , Size.LARGE, 2, false);
		order1.addNewBeverage("Banana" , Size.LARGE, 2, false);
		order1.addNewBeverage("Banana" , Size.LARGE, 2, false);
		order1.addNewBeverage("Mocha" , Size.SMALL, false, false);
	
		assertEquals(3, order1.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1, order1.findNumOfBeveType(Type.COFFEE));
		assertEquals(0, order1.findNumOfBeveType(Type.ALCOHOL));
		
	}

	@Test
	void testToString() {
		String line = order1.toString();
		String expected = "Order number: " + order1.getOrderNo()+"\n"
				+ "Order time: 8" + "\n"
				+ "Order day: SATURDAY" + "\n"
				+ "Customer information: Mary,18"
				+ "\n__________________________________\n";
		assertTrue(expected.equals(line));
		
	}

	@Test
	void testCompareTo() {
		assertEquals(0, order1.compareTo(order1));
	}

}
