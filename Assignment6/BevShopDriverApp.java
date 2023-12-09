
public class BevShopDriverApp {
	
	public static void main(String[] args)
	{
		//BevShop and Customer objects
		BevShop shop = new BevShop();
		Customer cust = new Customer("John", 23);
	
		
		System.out.println("The current order in process can have at most " + shop.getMaxOrderForAlcohol()
							+ " alcoholic beverages.");
		System.out.println("The minimum age to order alcohol is " + shop.getMinAgeForAlcohol());
		System.out.println("Start please a new order:");
		shop.startNewOrder(9, Day.MONDAY, cust.getName(), cust.getAge());
		int orderNo = shop.getCurrentOrder().getOrderNo();
		System.out.println("Your Total Order for now is " + shop.getCurrentOrder().calcOrderTotal());
		System.out.println("Would you please enter your name: " + shop.getCurrentOrder().cust.getName());
		System.out.println("Would you please enter your age: " + shop.getCurrentOrder().cust.getAge());
		checkAge(shop);
		System.out.println("Would you please add an alcohol drink");
		shop.processAlcoholOrder("Mohito", Size.SMALL);
		System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
		System.out.println("The Total price on the Order: " + shop.totalOrderPrice(orderNo));
		checkAlc(shop);
		System.out.println("Would you please add a second alcohol drink");
		shop.processAlcoholOrder("Mohito", Size.LARGE);
		System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
		System.out.println("The Total price on the Order: " + shop.totalOrderPrice(orderNo));
		checkAlc(shop);
		System.out.println("Add third alchohol drink");
		shop.processAlcoholOrder("Long Island", Size.SMALL);
		System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
		System.out.println("The Total price on the Order: " + shop.totalOrderPrice(orderNo));
		checkAlc(shop);
		System.out.println("Would you please add a COFFEE to your order:");
		shop.processCoffeeOrder("Latte", Size.MEDIUM, false, false);
		System.out.println("Total items on your oder is " + shop.getCurrentOrder().getTotalItems());
		System.out.println("The Total price on the Order: " + shop.totalOrderPrice(orderNo));
		
		System.out.println("#--------------------------------------------------#");
		
		System.out.println("Would you please start a new order");
		shop.startNewOrder(10, Day.TUESDAY, "Ray", 18);
		int orderNo2 = shop.getCurrentOrder().getOrderNo();
		System.out.println("Would you please enter your name: " + shop.getCurrentOrder().cust.getName());
		System.out.println("Would you please enter your age: " + shop.getCurrentOrder().cust.getAge());
		System.out.println("Your Total Order for now is " + shop.getCurrentOrder().calcOrderTotal());
		System.out.println("Would you please add a SMOOTHIE to order");
		int fruitsNum = 5;
		shop.processSmoothieOrder("Strawberry Smoothie", Size.LARGE, fruitsNum, false);
		System.out.println("Your Total Order for now is " + shop.getCurrentOrder().calcOrderTotal());
		System.out.println("Would you please add a SMOOTHIE to order");
		shop.processSmoothieOrder("Banana Smoothie", Size.SMALL, 0, false); //no fruit
		System.out.println("Would you please add a COFFEE to order");
		shop.processCoffeeOrder("Latte", Size.SMALL, false, false);
		System.out.println("The Total price on the Order: " + shop.totalOrderPrice(orderNo2));
		System.out.println("Would you please add a drink");
		shop.processCoffeeOrder("Cappuccino", Size.SMALL, false, false);
		checkAge(shop);
		System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
		System.out.println("Your Total Order for now is " + shop.getCurrentOrder().calcOrderTotal());
		System.out.println("The total number of fruits is " + fruitsNum);
		checkFruits(shop, fruitsNum);
		System.out.println();
		System.out.println("Total price on the second Order: " + shop.getOrderAtIndex(1).calcOrderTotal());
		System.out.println("Total amount of all Orders: " + shop.totalMonthlySale());
		
	}
	
	public static void checkFruits(BevShop shop, int num)
	{
		if(shop.isMaxFruit(num))
		{
			System.out.println("You reached a Maximum number of fruits");
		}
	}
	
	
	public static void checkAge(BevShop shop)
	{
		if(shop.isValidAge(shop.getCurrentOrder().cust.getAge()))
		{
			System.out.println("Your age is above " + shop.getMinAgeForAlcohol() + " and you are eligible to order alcohol");
		}
		else
		{
			System.out.println("Your Age is not appropriate for alcohol drink!!");
		}
	}
	
	public static void checkAlc(BevShop shop)
	{
		if(shop.getNumOfAlcoholDrink() == shop.getMaxOrderForAlcohol())
		{
			System.out.println("You have a maximum alcohol drinks for this order");
		}
		else
		{
			System.out.println("Your current alcohol drink order is less than " + shop.getMaxOrderForAlcohol());
		}
		
	}

}
