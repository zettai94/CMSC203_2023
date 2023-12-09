
public class Customer {
	
	//attributes
	private String name;
	private int age;
	
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	//copy constructor
	public Customer(Customer c)
	{
		this.name = c.name;
		this.age = c.age;
	}
	
	//getter
	public int getAge()
	{
		return this.age;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	//setter
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		//String representation of the customer includes the name and age of the customer.
		return "Customer information: " + this.name + "," + this.age;
	}

}
