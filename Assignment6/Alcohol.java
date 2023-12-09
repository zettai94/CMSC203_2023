
public class Alcohol extends Beverage{
	
	//attributes
	private boolean weekend;
	private final double WEEKEND_PRICE = 0.6;
	
	//constructor
	public Alcohol(String bevName, Size size, boolean isWeekend)
	{
		super(bevName, Type.ALCOHOL, size);
		this.weekend = isWeekend;
	}
	
	@Override
	public String toString()
	{
		//String includes the name, size, whether or not beverage is offered in weekend and the price
		String line = super.toString();
		if(isWeekend()==true)
		{
			line+= ", Weekend Price: $";
		}
		else
		{
			line+= ", Normal Price: $";
		}
		line += this.calcPrice();
		return line;
	}
	
	@Override
	public boolean equals(Object anotherBev)
	{
		Alcohol alc = (Alcohol) anotherBev;
		return super.equals(anotherBev) && this.weekend==alc.weekend;
	}
	
	//is actually getter for weekend
	public boolean isWeekend()
	{
		return this.weekend;
	}
	
	//implementing setter coz Rubric asked for it
	public void setWeekend(boolean isWeekend)
	{
		this.weekend = isWeekend;
	}
	
	public double calcPrice()
	{
		//calculate price of alcohol; return price of alchohol
		//specified by calcPrice in Beverage
		double price = super.addSizePrice();
		if(this.weekend)
		{
			price += WEEKEND_PRICE;
		}
		return price;
	}

}
