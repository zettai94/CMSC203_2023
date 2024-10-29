/*Name: Silvia Lim Siew Ling
 * Student ID: M21154781
 * Class: CMSC 203
 * Project: 4
 * Due date: 4th Nov 2023*/
public class Property {
	//attributes
	private String pName;
	private String city;
	double rental;
	private String landlord;
	private Plot plot;
	
	//creates new Property using empty String
	public Property()
	{
		this.pName = "";
		this.city = "";
		this.rental = 0;
		this.landlord = "";
		//create default plot
		this.plot = new Plot();
	}
	
	//creates new Property object using given values, also creates a default plot
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.pName = propertyName;
		this.city = city;
		this.rental = rentAmount;
		this.landlord = owner;
		//create default plot
		this.plot = new Plot();
	}
	
	//creates new Property objects using given values and creates plot using given values
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.pName = propertyName;
		this.city = city;
		this.rental = rentAmount;
		this.landlord = owner;
		//create plot with given values
		this.plot = new Plot(x, y, width, depth);
	}
	
	//creates a NEW copy of given property object
	public Property(Property otherProperty)
	{
		this.pName = otherProperty.getPropertyName();
		this.city = otherProperty.getCity();
		this.rental = otherProperty.getRentalAmount();
		this.landlord = otherProperty.getOwner();
		//create new plot with given values, getPlot contains: x,y,width,depth from toString(Plot)
		this.plot = new Plot(otherProperty.getPlot());
	}
	
	//5 accessors
	public String getCity()
	{
		return this.city;
	}
	
	public String getOwner()
	{
		return this.landlord;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	public String getPropertyName()
	{
		return this.pName;
	}
	
	public double getRentalAmount()
	{
		return this.rental;
	}
	
	//toString method format: propertyName,city,owner,rentAmount
	public String toString()
	{
		String line;
		line = this.pName + "," + this.city + "," + this.landlord + "," + rental;
		return line;
	}
}
