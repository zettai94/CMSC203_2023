
public class Coffee extends Beverage{
	
	//attribute
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SHOT = 0.5;
	private final double SYRUP = 0.5;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		//create a new Coffee object using given values
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	//setter
	public void setExtraShot(boolean extraShot)
	{
		this.extraShot = extraShot;
	}
	
	public void setExtraSyrup(boolean extraSyrup)
	{
		this.extraSyrup = extraSyrup;
	}
	
	//getter
	public boolean getExtraShot()
	{
		//indicate whether or not extra shot needed
		//return extrashot
		return this.extraShot;
	}
	
	public boolean getExtraSyrup()
	{
		//Indicates whether or not extra syrup is added
		//return extrasyrup
		return this.extraSyrup;
	}
	
	@Override
	public double calcPrice()
	{
		//calculate price of beverage and return price
		double total = super.addSizePrice();
		if(this.extraShot == true)
		{
			total += SHOT;
		}
		
		if(this.extraSyrup == true)
		{
			total += SYRUP;
		}
		return total;
		
	}
	
	@Override
	public String toString()
	{
		//String format: name,size, whether it contains extra shot, 
		//extra syrup and the price
		String line = super.toString();
		if(this.getExtraShot()==true)
		{
			line += ", Extra Shot, ";
		}
		else
		{
			line += ", No Extra Shot, ";
		}
		
		if (this.getExtraSyrup()==true)
		{
			line += "Add Syrup: $";
		}
		else
		{
			line += "No Syrup: $";
		}
		line +=  this.calcPrice();
		return line;
	}
	
	@Override
	public boolean equals(Object anotherBev)
	{
		//true if the name, type, size and base price
		//and whether or not it contains extra shot and extra syrup false otherwise
		Coffee cof = (Coffee) anotherBev;
		return super.equals(anotherBev) && this.extraShot==cof.extraShot 
				&& this.extraSyrup==cof.extraSyrup;
	}

}