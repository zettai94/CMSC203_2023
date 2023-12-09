import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {

	BevShop shop;
	
	@BeforeEach
	void setUp() throws Exception {
		shop = new BevShop();
		shop.startNewOrder(10, Day.SATURDAY, "June", 25);
	}

	@AfterEach
	void tearDown() throws Exception {
		shop = null;
	}

	@Test
	void testIsValidTime() {
		assertFalse(shop.isValidTime(6));
		assertFalse(shop.isValidTime(24));
		assertTrue(shop.isValidTime(12));
	}

	@Test
	void testIsMaxFruit() {
		assertTrue(shop.isMaxFruit(5));
		assertTrue(shop.isMaxFruit(8));
		assertFalse(shop.isMaxFruit(4));
	}

	@Test
	void testIsEligibleForMore() {
		assertFalse(shop.isEligibleForMore());
		
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		assertTrue(shop.isEligibleForMore());
	}

	@Test
	void testGetNumOfAlcoholDrink() {
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		assertEquals(2, shop.getNumOfAlcoholDrink());
	}

	@Test
	void testIsValidAge() {
		assertFalse(shop.isValidAge(15));
		assertTrue(shop.isValidAge(25));
		
	}


	@Test
	void testFindOrder() {
		int num = shop.getCurrentOrder().getOrderNo();
		assertEquals(0, shop.findOrder(num));
		assertEquals(-1, shop.findOrder(99));
	}

	@Test
	void testTotalOrderPrice() {
		int num = shop.getCurrentOrder().getOrderNo();
		shop.processCoffeeOrder("Mocha", Size.LARGE, true, true);
		shop.processCoffeeOrder("Mocha", Size.LARGE, true, true);
		assertEquals(10, shop.totalOrderPrice(num));
	}

	@Test
	void testTotalMonthlySale() {
		shop.processCoffeeOrder("Mocha", Size.LARGE, true, true);
		shop.processCoffeeOrder("Mocha", Size.LARGE, true, true);
		shop.startNewOrder(10, Day.MONDAY, "June", 25);
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		assertEquals(12, shop.totalMonthlySale());
		
	}

	@Test
	void testTotalNumOfMonthlyOrders() {
		shop.processCoffeeOrder("Mocha", Size.LARGE, true, true);
		shop.processCoffeeOrder("Mocha", Size.LARGE, true, true);
		shop.startNewOrder(10, Day.MONDAY, "June", 25);
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		assertEquals(3, shop.totalNumOfMonthlyOrders());
	}

	@Test
	void testGetCurrentOrder() {
		
		String name = "June";
		assertTrue(name.equals(shop.getCurrentOrder().getCustomer().getName()));
	}

	@Test
	void testGetOrderAtIndex() {
		int num = shop.getCurrentOrder().getOrderNo();
		shop.processCoffeeOrder("Mocha", Size.LARGE, true, true);
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		shop.startNewOrder(10, Day.MONDAY, "June", 25);
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		String name = "June";
		assertTrue(name.equals(shop.getOrderAtIndex(1).getCustomer().getName()));
	}

	@Test
	void testSortOrders() {
		
		shop.getCurrentOrder().setOrderNum(2);
		shop.startNewOrder(10, Day.MONDAY, "Aemy", 36);
		shop.getCurrentOrder().setOrderNum(1);
		String firstCust = "June";
		String secondCust = "Aemy";
		//list on the list is "June" with OrderNum = 2
		assertTrue(firstCust.equals(shop.getOrderAtIndex(0).getCustomer().getName()));
		shop.sortOrders();
		//now first on the list is "Aemy" with OrderNum = 1
		assertFalse(firstCust.equals(shop.getOrderAtIndex(0).getCustomer().getName()));
		assertTrue(secondCust.equals(shop.getOrderAtIndex(0).getCustomer().getName()));
	}

	@Test
	void testToString() {
		shop.processCoffeeOrder("Mocha", Size.LARGE, true, true);
		shop.startNewOrder(10, Day.MONDAY, "June", 25);
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		String expected = "Order number: " + shop.getOrderAtIndex(0).getOrderNo() + "\n"
				+ "Order time: 10\n"
				+ "Order day: SATURDAY\n"
				+ "Customer information: June,25\n"
				+ "__________________________________\n"
				+ "Mocha (LARGE), Extra Shot, Add Syrup: $5.0\n"
				+ "\n"
				+ "Order number: " + shop.getOrderAtIndex(1).getOrderNo()+ "\n"
				+ "Order time: 10\n"
				+ "Order day: MONDAY\n"
				+ "Customer information: June,25\n"
				+ "__________________________________\n"
				+ "Mohito (SMALL), Normal Price: $2.0\n"
				+ "\n"
				+ "Total sales this month: $7.0";
		System.out.println(shop);
		System.out.println(expected);
		assertTrue(expected.equals(shop.toString()));
		
	}

}
