
public class PersonalTesting {
	
	public static void main(String[] args)
	{
		Property s1 = new Property("Property1", "A", 100, "Me", 1, 1, 1, 1);
    	Property s2 = new Property("Property2", "B", 200, "Me", 3, 1, 1, 1);
    	Property s3 = new Property("Property3", "C", 900, "Me", 6, 1, 1, 1);
    	Property s4 = new Property("Property4", "D", 400, "Me", 1, 3, 2, 1);
    	Property s5 = new Property("Property5", "E", 500, "Me", 8, 6, 1, 2);
    	
    	//to exceed array
    	Property s6 = new Property("Property6", "F", 600, "Me", 5, 8, 2, 1);
    	
    	//to overlap s5
    	Property s7 = new Property("Property7", "G", 500, "Me", 8, 6, 1, 2);
    	
    	ManagementCompany comp = new ManagementCompany("Seligman", "123456", 6);
    	
    	//another company with more than 100 fee, change to -1 to validate fee (checked fee validation)
    	ManagementCompany comp2 = new ManagementCompany("Juniper", "998877", 5);
    	ManagementCompany empty = new ManagementCompany(comp); //copy constructor tested
    	empty.addProperty(s1);
    	
//    	System.out.println("List of the properties for Seligman, taxID: 123456\n" +
//							"______________________________________________________\n"
//							+ "Property Name: Property1\n"
//							+ "Located in A\n"
//							+ "Belonging to: Me\n" 
//							+ "Rent Amount: 100\n"
//							+ "______________________________________________________\n"
//							+ "\n total management Fee: 6.0");
    	//
//    	System.out.println(empty.getPropertiesCount());
//    	System.out.println(empty);
//    	System.out.println(empty.getHighestRentProperty());
    	empty.addProperty(s1);
		empty.addProperty(s2);
//		empty.addProperty(s3);
//		empty.addProperty(s4);
		empty.addProperty(s5);
		//System.out.println(empty.getTotalRent());
		
    	//System.out.println(comp2);
    	//System.out.println(comp2.isManagementFeeValid());
    	//System.out.println(s1.getPlot());
		//System.out.println(empty);
    	//empty.removeLastProperty();
    	System.out.println(empty);
    	empty.getProperties();
    	System.out.println(empty.getHighestRentProperty());
	}

}
