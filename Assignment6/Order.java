import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{

	private int orderNum;
	private int time;
	private Day day;
	Customer cust;
	ArrayList<Beverage> beverages = new ArrayList<>();
	
	private final int MIN = 10000;
	private final int MAX = 90000;
	
	//constructors
	public Order(int orderTime, Day orderDay, Customer cust)
	{
		this.time = orderTime;
		this.day = orderDay;
		this.cust = cust;
		this.orderNum = generateOrder();
	}
	
	//setter, may not be necessary but Rubric asked for them
	public void setOrderNum(int num)
	{
		this.orderNum = num;
	}
	
	public void setOrderTime(int time)
	{
		this.time = time;
	}
	
	public void setOrderDay(Day day)
	{
		this.day = day;
	}
	
	public int generateOrder()
	{
		Random random = new Random();
		int range = MAX-MIN+1;
		int num = random.nextInt(range) + MIN;
		
		return num;
	}
	
	public void setBeverages(ArrayList<Beverage> beverages)
	{
		this.beverages = beverages;
	}
	
	//getter
	public int getOrderNo()
	{
		return this.orderNum;
	}
	
	public int getOrderTime()
	{
		return this.time;
	}
	
	public Day getOrderDay()
	{
		return this.day;
	}
	
	public Customer getCustomer()
	{
		//return deep copy of the customer
		return new Customer(this.cust.getName(), this.cust.getAge());
	}
	
	public ArrayList<Beverage> getBeverages()
	{
		return beverages;
	}
	
	//this seems to serve same function as getOrderDay
	public Day getDay()
	{
		return this.day;
	}
	
	public boolean isWeekend()
	{
		switch(day)
		{
			case SATURDAY:
			case SUNDAY:
				return true;
			default:
				return false;
		}
	}
	
	public Beverage getBeverage(int itemNo)
	{
		return this.beverages.get(itemNo);
	}
	
	public int getTotalItems()
	{
		int count = this.beverages.size();
		return count;
	}
	
	//add coffee
	public void  addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
			
	}
		
	//add alcohol
	public void  addNewBeverage( String bevName, Size size)
	{
		beverages.add(new Alcohol(bevName, size, this.isWeekend()));
	}
		
	//add smoothie
	public void  addNewBeverage( String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	public double calcOrderTotal()
	{
		int length = this.beverages.size();
//		if (length == 0)
//		{
//			return 0;
//		}
		double total = 0;
		for(int i = 0; i < length; i++)
		{
			total += beverages.get(i).calcPrice();
		}
		return total;
	}
	
	public int findNumOfBeveType(Type type)
	{
		//assume that checking for this.beverages
		int sameType = 0;
		for(int i = 0; i < this.beverages.size(); i++)
		{
			if(this.beverages.get(i).getType()==type)
			{
				sameType++;
			}
		}
		return sameType;
	}
		
	
	@Override
	public String toString()
	{
		//String representation of the order, Includes order number, time , day, customer name and age and the list of beverages
		String line = "Order number: " + this.orderNum + "\n"
						+ "Order time: " + this.time + "\n"
						+ "Order day: " + this.day + "\n"
						+ this.cust
						+ "\n__________________________________\n";
		for(int i = 0; i < beverages.size(); i++)
		{
			line += beverages.get(i) + "\n";
		}
		return line;
	}
	
	@Override
	public int compareTo(Order anotherOrder)
	{
		int result;
		if(this.orderNum == anotherOrder.orderNum)
		{
			result = 0;
		}
		else if(this.orderNum > anotherOrder.orderNum)
		{
			result = 1;
		}
		else
		{
			result = -1;
		}
		return result;
	}

}
