import static org.junit.jupiter.api.Assertions.assertEquals;

public class testingPlot {
	public static void main (String[]args)
	{
		//Plot p1 = new Plot(2,2,6,6); 
		//Plot p2 = new Plot(3,4,4,3);
		//System.out.println(p1.encompasses(p2));//returns true, checked
		//System.out.println(p2.encompasses(p1));//returns false, checked
		
        Plot plot1 = new Plot(2,2,6,6); 
        Plot plot5 = new Plot(3,4,4,3);
        Plot plot3 = new Plot(1,1,3,2);
        //System.out.println(plot3.encompasses(plot1)); //false, plot3's x and y smaller than plot1's x and y, checked
        //System.out.println(plot1.encompasses(plot3)); //false, checked
        
        Plot plot4 = new Plot(6,1,4,2);
        //System.out.println(plot3.overlaps(plot4));//should return false, checked
        //Plot plot6 = new Plot(6,5,3,1);
//        System.out.println(plot1.overlaps(plot6));//should be true, checked
//        System.out.println(plot6.overlaps(plot1));//should be true, checked
//        System.out.println(plot1.overlaps(plot4));//should return true,checked
//        System.out.println(plot4.overlaps(plot1));//should return true,checked
//        System.out.println(plot4.overlaps(plot3));//should be false,checked
//        Plot  plot10 = new Plot(9,2,2,2);
//        System.out.println(plot1.overlaps(plot10));
//        System.out.println(plot10.overlaps(plot1));
//        System.out.println(plot1.overlaps(plot5));
 //       System.out.println(plot5.overlaps(plot1));
        
        //Property prop1 = new Property("Myhouse", "MD", 200, "Silvia", 2, 2, 4, 5);
        //System.out.println(prop1.getPlot());
        //ManagementCompany property = new ManagementCompany("Testing", "110", 5);
        Property sampleProperty;
        sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);
        //Property sample2 = new Property("MyHome", "MD", 2000, "PotatoL", 8,8,1,1);
    	ManagementCompany mangementCo; 
    	
    	mangementCo= new ManagementCompany("Railey", "555555555",6);
    	//System.out.println(mangementCo.addProperty(sampleProperty));
    	//add multiple different property
    	Property sample2 = new Property("Property1", "Gaithersburg", 1550, "Me", 5, 7, 2, 1);
    	//System.out.println(mangementCo.addProperty("Property1", "Gaithersburg", 1550, "Me", 5, 7, 2, 1) + " property count: " + mangementCo.getPropertiesCount());
    	//if overlaps
    	//Property sample3 = new Property("Property2", "Rockville", 2000, "You", 5, 7, 2, 1);
    	//System.out.println(mangementCo.addProperty("Property2", "Rockville", 2000, "You", 2,5,2,2) + " property count: " + mangementCo.getPropertiesCount());
    	//System.out.println(mangementCo.addProperty("Suntex", "Kuching", 1500, "Potato") + " the property count = " + mangementCo.getPropertiesCount());
    	//System.out.println(mangementCo.getPropertiesCount());
    	//System.out.println(mangementCo.addProperty(sampleProperty));
    	mangementCo.addProperty(sample2);
    	mangementCo.addProperty(sampleProperty);
//    	System.out.println("List of the properties for Railey, taxID: 555555555\n"
//				+ "______________________________________________________\n"
//				+ "Sunsational,Beckman,BillyBob Wilson,2613.0\n"
//				+ "______________________________________________________\n"
//				+"\n"
//				+ " total management Fee: 156.78");
//		
    	
    	System.out.println(mangementCo);
        //System.out.println(mangementCo.getPropertiesCount());
    
    	//overloading the array
    	Property s1 = new Property("Property1", "A", 100, "Me", 1, 1, 1, 1);
    	Property s2 = new Property("Property2", "B", 200, "Me", 3, 1, 1, 1);
    	Property s3 = new Property("Property3", "C", 900, "Me", 6, 1, 1, 1);
    	Property s4 = new Property("Property4", "D", 400, "Me", 1, 3, 2, 1);
    	Property s5 = new Property("Property5", "E", 500, "Me", 8, 6, 1, 2);
    	Property s6 = new Property("Property6", "F", 600, "Me", 5, 8, 2, 1);
//    	System.out.println(mangementCo.addProperty(s1));
//    	System.out.println(mangementCo.addProperty(s2));
//    	System.out.println(mangementCo.addProperty(s3));
//    	//System.out.println(mangementCo.addProperty(s4));
//    	//System.out.println(mangementCo.addProperty(s5));
//    	//System.out.println(mangementCo.addProperty(s6));
//    	System.out.println(mangementCo.getHighestRentProperty() + " " + mangementCo.getPlot());
//    	System.out.println(mangementCo.getTotalRent());
//   
	}
		

}
