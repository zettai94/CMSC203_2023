/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: Write a class named PatientDriverApp that creates an instance for Patient class and 3 instances for Procedure class.
 * Due: 09/26/223
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Silvia Lim Siew Ling
*/

public class PatientDriverApp 
{
	public static void main(String[] args)
	{
		//instance for patient class
		Patient p1 = new Patient("Jenny", "Elaine", "Santori", "123 Main Street", "MyTown", "CA", "01234",
									"Bill Santori", "100-222-3456", "777-555-1212");
			
		//3 instances for procedure class, use each procedure constructor
		Procedure proc1 = new Procedure("Physical Exam", "07/20/2019", "Dr. Irvine", 3250.00);
		
		Procedure proc2 = new Procedure();
		proc2.setProcName("X-ray");
		proc2.setProcDate("07/20/2019");
		proc2.setDrName("Dr. Jamison");
		proc2.setPrice(5500.43);
		
		Procedure proc3 = new Procedure("Blood Test", "07/20/2019");
		proc3.setDrName("Dr. Smith");
		proc3.setPrice(1400.75);
		
		
		//call methods
		displayPatient(p1);
		displayProcedure(proc1);
		displayProcedure(proc2);
		displayProcedure(proc3);
		System.out.printf("\nTotal Charges: %,.2f", calculateTotalCharges(proc1, proc2, proc3));
		//display total charges of procedures in comma separated with 2 decimal points
				
		//student name, MC number and due date
		String studentName = "Silvia Lim Siew Ling";
		String mcNumber = "M21157481";
		String dueDate = "09/26/2023";
		System.out.println("\n\nStudent Name: " + studentName + "\nMC#: " + mcNumber + "\nDue Date: " + dueDate);
				 	
	}
			
	//displayPatient method given patient object, display patient's information
	public static void displayPatient(Patient p1)
	{	
		System.out.println("Patient info: ");
		System.out.println(p1);		
	}
			
	//displayProcedure method given procedure object, display procedure's information
	public static void displayProcedure(Procedure proc)
	{
			System.out.println(proc); 
	}
	
	//calculateTotalCharges method that takes 3 procedures as parameter and return total charges of these procedures		
	public static double calculateTotalCharges(Procedure proc1, Procedure proc2, Procedure proc3 )
	{
		double totalPrice = (proc1.getPrice() + proc2.getPrice() + proc3.getPrice());
		return totalPrice;
	}
	
}