import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	
	private int MIN_AGE_FOR_ALCOHOL = 21;  
	private int MAX_ORDER_FOR_ALCOHOL= 3;   
										
	private int MIN_TIME= 8;				
	private int MAX_TIME= 23;				
	private int MAX_FRUIT = 5;	
	
	//variable for current Alcohol order
	private int numOfAlc;
	
	//list to keep track of Orders
	private Order currentOrder;
	private ArrayList<Order> orders = new ArrayList<>();
	
	public BevShop()
	{
		
	}
	
	public boolean isValidTime(int time)
	{
		//true if times is within the range of 8 to 23 , false otherwise
		boolean open;
		if(time >= MIN_TIME && time <= MAX_TIME)
		{
			open = true;
		}
		else
		{
			open = false;
		}
		return open;
	}
	
	public int getMaxNumOfFruits()
	{
		//returns the constant value for the max fruits
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol()
	{
		//returns the constant value for the Maximum age for offering Alcohol drink
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public boolean isMaxFruit(int numOfFruits)
	{
		//returns true if the passed parameter exceeds the Maximum FRUIT allowed
		if(numOfFruits >= MAX_FRUIT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getMaxOrderForAlcohol()
	{
		//returns constant maximum number of alcohol beverages/per order offered by the beverage shop
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public boolean isEligibleForMore()
	{
		//true if num of alc for current order reached max
		//false otherwise
		if(numOfAlc >=  MAX_ORDER_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getNumOfAlcoholDrink()
	{
		return numOfAlc;
	}
	
	public boolean isValidAge(int age)
	{
		//true if age more than min; else false
		if(age > MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void startNewOrder(int time, Day day, String customerName, int customerAge)
	{
		Customer customer = new Customer(customerName, customerAge);
		currentOrder = new Order(time, day, customer);
		orders.add(currentOrder); 
	}
	
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);		
//		if(orders.size() == 0)
//		{
//			orders.get(0).addNewBeverage(bevName, size, extraShot, extraSyrup);
//		}
//		else
//		{
//			orders.get(orders.size()-1).addNewBeverage(bevName, size, extraShot, extraSyrup);
//		}
	}
	
	public void processAlcoholOrder(String bevName, Size size)
	{
		currentOrder.addNewBeverage(bevName, size);
		numOfAlc = currentOrder.findNumOfBeveType(Type.ALCOHOL);
//		if(orders.size() == 0)
//		{
//			orders.get(0).addNewBeverage(bevName, size);
//			numOfAlc = orders.get(0).findNumOfBeveType(Type.ALCOHOL);
//		}
//		else
//		{
//			orders.get(orders.size()-1).addNewBeverage(bevName, size);
//			numOfAlc = orders.get(orders.size()-1).findNumOfBeveType(Type.ALCOHOL);
//		}
	}
	
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
//		if(orders.size() == 0)
//		{
//			orders.get(0).addNewBeverage(bevName, size, numOfFruits, addProtein);
//		}
//		else
//		{
//			orders.get(orders.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtein);
//		}
		
	}
	
	public int findOrder(int orderNo)
	{
		for (int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getOrderNo() == orderNo)
			{
				return i;
			}
		}
		return -1;
	}
	
	
	public double totalOrderPrice(int orderNo)
	{
		int index = findOrder(orderNo);
		double total = orders.get(index).calcOrderTotal();
		return total;
	}
	
	public double totalMonthlySale()
	{
		double total = 0;
		for (int i = 0; i < orders.size(); i++)
		{
			total += orders.get(i).calcOrderTotal();
		}
		return total;
	}
	
	public int totalNumOfMonthlyOrders()
	{
		int total = 0;
		for(int i = 0; i < orders.size(); i++)
		{
			total += orders.get(i).getTotalItems();
		}
		return total;
	}
	
	public Order getCurrentOrder()
	{
		return currentOrder;
	}
	
	public Order getOrderAtIndex(int index)
	{
		//returns Order in the list of orders at the index 
		//Notes: this method returns the shallow copy of the order
		Order orderInIndex = orders.get(index);
		return orderInIndex;
	}
	
	public void sortOrders()
	{
		for(int i = 0; i < orders.size()-1; i++)
		{
			int index = i;
			for(int j = i+1; j < orders.size(); j++)
			{
				if(orders.get(j).getOrderNo() < orders.get(index).getOrderNo())
				{
					index = j;
				}
			}
			Order temp = orders.get(index);
			orders.set(index, orders.get(i));
			orders.set(i,  temp);
		}
	}
	
	@Override
	public String toString()
	{
		//returns the string representation of all the orders and the total monthly sale
		String allOrders = "";
		for(int i = 0; i < orders.size(); i++)
		{
			allOrders += orders.get(i) + "\n";
		}
		allOrders += "Total sales this month: $" + totalMonthlySale();
		
		return allOrders;
	}

}