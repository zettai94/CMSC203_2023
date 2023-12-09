
public class Smoothie extends Beverage{
	
	//attributes
	private int fruits;
	private boolean withPro;
	private final double PRO_PRICE = 1.5;
	private final double FRUIT_PRICE = 0.5;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		super(bevName, Type.SMOOTHIE, size);
		this.fruits = numOfFruits;
		this.withPro = addProtein;
	}
	
	//getter
	public int getNumOfFruits()
	{
		return this.fruits;
	}
	
	public boolean getAddProtein()
	{
		return this.withPro;
	}
	
	//setter
	public void setNumOfFruits(int fruits)
	{
		this.fruits = fruits;
	}
	
	public void setAddProtein(boolean withPro)
	{
		this.withPro = withPro;
	}
	
	@Override
	public String toString()
	{
		//returns the string representation of a Smoothie drink.
		//Contains the name , size, whether or not protein added , number of fruits and price
		String line = super.toString();
		if(this.getAddProtein() == true)
		{
			line += ", With Protein Powder, ";
		}
		else
		{
			line += ", No Protein Powder, ";
		}
		
		line += this.fruits + " fruits: $" + this.calcPrice();
		return line;
	}
	
	@Override
	public double calcPrice()
	{
		double price = super.addSizePrice() + (this.fruits * FRUIT_PRICE);
		if (this.withPro)
		{
			price += PRO_PRICE;
		}
		return price;
		
	}
	
	@Override
	public boolean equals(Object anotherBev)
	{
		//true if the name, type, size and base price, 
		//number of Fruits and add protein are the same, false otherwise
		Smoothie smooth = (Smoothie) anotherBev;
		return super.equals(anotherBev) && this.fruits==smooth.fruits &&
				this.withPro==smooth.withPro;
	}

}
