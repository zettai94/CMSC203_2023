/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: Write a class named Procedure that represents a medical procedure that has been performed on a patient.
 * Due: 09/26/223
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Silvia Lim Siew Ling
*/

public class Procedure
{
	//field/attribute
	private String procName, procDate, drName;
	private double price;
	
	//no arg constructor
	public Procedure()
	{
		
	}
	
	//parametrized constructor that initializes procedure's name, date to given values
	public Procedure(String pName, String date)
	{
		this.procName = pName;
		this.procDate = date;
	}
	
	//parametrized constructor that initializes all attributes of the procedure to given values
	public Procedure(String pName, String date, String docName, double p)
	{
		this.procName = pName;
		this.procDate = date;
		this.drName = docName;
		this.price = p;
	}
	
	//accessors for all attributes
	public String getProcName()
	{
		return procName;
	}
	
	public String getProcDate()
	{
		return procDate;
	}

	public String getDrName()
	{
		return drName;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	//mutators for all attributes
	public void setProcName(String pName)
	{
		this.procName = pName;
	}
	public void setProcDate(String pDate)
	{
		this.procDate = pDate;
	}

	public void setDrName(String docName)
	{
		this.drName = docName;
	}

	public void setPrice(double p)
	{
		this.price = p;
	}

	//toString method that display all information of a procedure
	public String toString()
	{
		String line;
		line = "\n\t\tProcedure: " + procName + "\n\t\tProcedure Date: " + procDate + "\n\t\tPractitioner: " + drName + "\n\t\tCharges: "
				+ price;
		return line;
	}

}
