public abstract class Beverage {
	
	//attributes
	private String bevName;
	private Type type;
	private Size size;
	private final double BASE = 2.0;
	private final double UPSIZE = 1.0;
	
	//constructor
	public Beverage (String bevName, Type type, Size size)
	{
		//create beverage with these values
		this.bevName = bevName;
		this.type = type;
		this.size = size;
		
	}
	
	public double getBasePrice()
	{
		//return base price
		return this.BASE;
	}
	
	public Type getType()
	{
		//return type of beverage
		return this.type;
	}
	
	public String getBevName()
	{
		//return beverage name
		return this.bevName;
	}
	
	public Size getSize()
	{
		//return size of beverage
		return this.size;
	}
	
	public double addSizePrice()
	{
		//calc new price by adding size price to base price
		//no addition to small
		//base price is 2, upsize will be 1 (affect medium and large)
		// medium will be 3 and large will be 4
		//return new price by adding size price to base price
		double total = 0;
		switch (this.size)
		{
			case SMALL:
				total = BASE;
				break;
			case MEDIUM:
				total = BASE + UPSIZE;
				break;
			case LARGE:
				total = BASE + (UPSIZE *2);
				break;
		}
		
		return total;
		
	}
	
	@Override
	public String toString()
	{
		//return String representation bevName,size
		return this.bevName + " (" + this.size + ")";
	}
	
	@Override
	public boolean equals(Object anotherBev)
	{
		//return true if name, size true
		//else return false
		Beverage bev = (Beverage) anotherBev;
		if (this.getBevName().equals(bev.getBevName()) && this.getSize().equals(bev.getSize())
				&& this.getType().equals(bev.getType()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public abstract double calcPrice();
		//calculate and return beverage price
		//must be overriden in subclass
	
	

}