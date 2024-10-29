/*Name: Silvia Lim Siew Ling
 * Student ID: M21154781
 * Class: CMSC 203
 * Project: 4
 * Due date: 4th Nov 2023*/
public class ManagementCompany {
	//attributes public static final
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_DEPTH = 10;
	public static final int MGMT_WIDTH = 10;
	
	private String name;
	private String taxID;
	double feeRate;
	Property[] properties;
	Plot plot;
	
	//creates ManagementCompany object using empty string, default Plot with max width, depth, initialize Property[]
	public ManagementCompany()
	{
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	//creates object using given values, create default Plot with max width,depth and initialize Property[]
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.feeRate = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	//creates object & Plot using given values; initialize Property[]. Call appropriate existing constructor
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		//call constructor with (name, taxID and mgmFee) that has a default plot and an initialized Property[]
		this(name, taxID, mgmFee);
		//create new plot with given values
		//REPLACE CONSTRUCTOR'S PLOT WITH GIVEN VALUES
		//validate xwidth and ydepth to make sure they're within range
		if ((x+width) <= MGMT_WIDTH && (y+depth) <= MGMT_DEPTH)
		{
			this.plot = new Plot(x, y, width, depth); 
		}
		//DO NOT NEED TO INITIALIZE PROPERTY[] AGAIN SINCE IT'S ALREADY DONE DURING CONSTRUCTOR CALL
	}
	
	//creates new object with given ManagementCompany object. Call appropriate existing constructor
	public ManagementCompany(ManagementCompany otherCompany)
	{
		//create new ManagementCompany copy of given ManagementCompany
		//Constructor should call an appropriate existing constructor
		this(otherCompany.getName(), otherCompany.getTaxID(), otherCompany.getMgmFeePer());
		//assume otherCompany already validated their plot
		this.plot = new Plot(otherCompany.getPlot());
		//since constructor already initialize Property[] in thisConstructor, do not need to reinitialize
	}
	
	//3 addProperty methods (overload)
	//parameter: property's name, city, rental, owner
	public int addProperty(String name, String city, double rent, String owner)
	{
		//return -1 if array is full, -2 if Property object is null, -3 if Management company doesnt encompass property plot
		//-4 if property plot overlaps ANY properties in array,
		//otherwise return the index of of array where the property was added.
		
		//get last count from property array
		int index = this.getPropertiesCount();
		//setup a temp plot with given values
		Property temp = new Property(name, city, rent, owner);
		if(this.isPropertiesFull() == true)
		{
			return -1;
		}
		
		if(properties==null)
		{
			return -2;
		}
		
		//if not within Management's managing property range
		if(plot.encompasses(temp.getPlot())==false)
		{
			return -3;
		}
		
		//validate if temp plot overlap existing plots within properties array;
		for(int i = 0; i < index; i++)
		{
			if(temp.getPlot().overlaps(properties[i].getPlot()))
			{
				return -4;
			}
		}
		
		//add new Property to array when temp passes all conditions
		properties[index] = new Property(temp);
		return index;
		//checked
	}
	
	//parameter: property's name, city, rent, owner, plot's values
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		//-1 if the array is full,
		//-2 if the Property object is null, 
		//-3 if management company does not encompass the property plot,
		//-4 if property plot overlaps ANY of properties in array, otherwise return the index of the array where the property was added.
		int index = this.getPropertiesCount();
		//create temp property with values from parameter
		Property temp = new Property(name, city, rent, owner, x, y, width, depth);
		if(this.isPropertiesFull() == true)
		{
			return -1;
		}
		
		if(properties==null)
		{
			return -2;
		}
		
		if(plot.encompasses(temp.getPlot())==false)
		{
			return -3;
		}
		
		//validate if temp plot overlap existing plots within properties array;
		for(int i = 0; i < index; i++)
		{
			if(temp.getPlot().overlaps(properties[i].getPlot()))
			{
				return -4;
			}
		}
		
		//add new Property to array when temp passes all conditions
		properties[index] = new Property(temp);
		return index;
		//checked
		
	}
	
	//parameter: Property object
	public int addProperty(Property property)
	{
		//-1 if the array is full
		//-2 if the Property object is null, 
		//-3 if management company does not encompass the property plot,
		//-4 if property plot overlaps ANY of properties in array, otherwise return the index of the array where the property was added.
		int index = this.getPropertiesCount();
		Property temp = new Property(property);
		if(this.isPropertiesFull() == true)
		{
			return -1;
		}
		
		if(properties==null)
		{
			return -2;
		}
		
		if(plot.encompasses(property.getPlot())==false)
		{
			return -3;
		}
		
		//validate if temp plot overlap existing plots within properties array;
		for(int i = 0; i < index; i++)
		{
			if(temp.getPlot().overlaps(properties[i].getPlot()))
			{
				return -4;
			}
		}
		
		//add new Property to array when temp passes all conditions
		properties[index] = new Property(temp);
		return index;
	}
	
	public void removeLastProperty()
	{
		//removes nullifies LAST property in properties array
		int last = this.getPropertiesCount() - 1;
		//only null if last is bigger than or equal to 0
		if (last >= 0)
		{
			properties[last] = null;
		}
	}
	

	public boolean isPropertiesFull()
	{
		//check if properties reached max capacity
		//return true if properties array is full, false if otherwise
		if(properties[properties.length-1]==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public int getPropertiesCount()
	{
		//get num of existing properties in the array and return the number of existing properties in array
		int i = 0;
		while (i < MAX_PROPERTY && properties[i] != null)
		{
			i++;
		}
		
		return i;
	}
	
	//return total rent of in all properties array
	public double getTotalRent()
	{
		int i = 0;
		//initialize accumulator
		double totalRental = 0;
		while(i < MAX_PROPERTY && properties[i] != null)
		{
			totalRental += properties[i].getRentalAmount();
			i++;
		}
		return totalRental; //CHECKED
	}
	
	//return Property object with highest rent
	public Property getHighestRentProperty()
	{
		int i = 0;
		//initialize highestRent with first array
		double highestRent = properties[i].getRentalAmount();
		//initialize highestProperty with object in first array
		Property highestProperty = properties[i];
		while(properties[i] != null && i < properties.length)
		{
			//if rent from array is higher than highestRent, highestRent is object's rentalAmount and highestProperty is object in array
			if (highestRent < properties[i].getRentalAmount())
			{
				highestRent = properties[i].getRentalAmount();
				highestProperty = properties[i];
			}
			i++;
		}
		return highestProperty;
	}
	
	//check if management fee is within 0 to 100
	public boolean isManagementFeeValid()
	{
		//true if valid, else false
		if(this.feeRate < 0 || this.feeRate > 100)
		{
			return false;
		}
		else
		{
			return true;
		}
		//checked
	}
	
	//accessors
	public String getName()
	{
		return this.name;
	}
	
	public String getTaxID()
	{
		return this.taxID;
	}
	
	public Property[] getProperties()
	{
		return this.properties;
	}
	
	public double getMgmFeePer()
	{
		//dont think this should be percentage 
		//since fee entered is not percentage
		return this.feeRate;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	//toString method display all properties within management company in properties array
	public String toString()
	{
		String line;
		line = "List of the properties for " + this.name + ", taxID: " + this.taxID + "\n" +
				"______________________________________________________\n"; 
		for (int i = 0; i < properties.length; i++)
		{
			if(properties[i]!=null)
			{
				line += "Property Name: " + properties[i].getPropertyName() + "\n" 
						+ "Located in " + properties[i].getCity() + "\n"
						+ "Belonging to: " + properties[i].getOwner() + "\n"
						+ "Rent Amount: " + properties[i].getRentalAmount() +"\n";
			}
		}
		line += "______________________________________________________\n"
				+ "\n total management Fee: " + (this.getTotalRent()*this.getMgmFeePer()/100);
		return line;
				
		//include each management company's name, taxID, property name, city, owner and rental amount
	}
}
