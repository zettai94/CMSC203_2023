/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: Write a class named Patient with fields for required data.
 * Due: 09/26/223
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Silvia Lim Siew Ling
*/

public class Patient
{
	//attributes
	private String firstName, midName, lastName, add, city, state, zip, emerName, phone, emerPhone;
	
	//no arg constructor
	public Patient()
	{
		this.firstName = " ";
		this.midName = " ";
		this.lastName = " ";
		this.add = " ";
		this.city = " ";
		this.state = " ";
		this.zip = " ";
		this.emerName = " ";
		this.phone = " ";
		this.emerPhone = " ";
	}
	
	//parameterized constructor initializes patient's first, mid, last name to given values
	public Patient(String fName, String mName, String lName)
	{
		this.firstName = fName;
		this.midName = mName;
		this.lastName = lName;
	}
	
	//parameterized constructor that initializes all attributes to given values
	public Patient(String fName, String mName, String lName, String add, String city, String state, 
					String zip, String emerName, String phone, String emerPhone)
	{
		this.firstName = fName;
		this.midName = mName;
		this.lastName = lName;
		this.add = add;
		this.city= city;
		this.state = state;
		this.zip = zip;
		this.emerName = emerName;
		this.phone = phone;
		this.emerPhone = emerPhone;
	}
	
	//buildFullName method that returns string which is the concatenation of first, mid, last name separated by space
	public String buildFullName()
	{
		String fullName;
		fullName = firstName + " " + midName + " " + lastName + " " + phone;
		return fullName;
	}
	
	//buildAddress method that returns string which is the concatenation of address, city, state and zip separated by space
	public String buildAddress()
	{
		String address;
		address = add + " " + city + " " + state + " " + zip;
		return address;
	}
	
	//buildEmergencyContact method that returns String which is concatenation of emergency number and 
	//emergency phone separated by space
	public String buildEmergencyContact()
	{
		String emerContact;
		emerContact = emerName + " " + emerPhone;
		return emerContact;
	}
	
	/* accessor for first name, mid name, last name,
	 * address, city, state, zip and emergency name*/
	public String getFirstName()
	{
		return firstName;
	}

	public String getMidName()
	{
		return midName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getAddress()
	{
		return add;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public String getZip()
	{
		return zip;
	}
	
	public String getEmerName()
	{
		return emerName;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public String getEmerPhone()
	{
		return emerPhone;
	}
	
	
	/* mutator for first name, mid name, last name,
	 * address, city, state, zip and emergency name*/
	public void setFirstName(String fName)
	{
		this.firstName = fName;
	}
	
	public void setMidName(String mName)
	{
		this.midName = mName;
	}
	
	public void setLastName(String lName)
	{
		this.lastName = lName;
	}
	
	public void setAdd(String add)
	{
		this.add = add;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	
	public void setEmerName(String emerName)
	{
		this.emerName = emerName;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public void setEmerPhone(String emerPhone)
	{
		this.emerPhone = emerPhone;
	}
	
	//toString method that display all information of patient
	public String toString()
	{
		String output = "\tName: " + buildFullName() + "\n\tAddress:  " + buildAddress() + "\n\tEmergency Contact: "
							+ buildEmergencyContact();
		return output;
	}
	
}
