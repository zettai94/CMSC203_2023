import java.util.Scanner;
public class MovieDriver_Task1 {
	public static void main(String[] args)
	{
		//create new object type Scanner that reads from keyboard
		Scanner keyboard = new Scanner(System.in);
		
		//create new movie object
		Movie m1 = new Movie();
		
		//prompt user for title
		System.out.println("Enter the name of a movie: ");
		
		//read user's input and store as title
		String movieTitle = keyboard.nextLine();
		m1.setTitle(movieTitle);
		
		//prompt movie rating and read user's input as rating
		System.out.println("Enter the rating of the movie: ");
		String rating = keyboard.nextLine();
		m1.setRating(rating);
		
		//prompt user for ticket sold and read user's input as sold
		System.out.println("Enter the number of tickets sold for this movie: ");
		int sold = keyboard.nextInt();
		m1.setSoldTickets(sold);
		keyboard.nextLine();
		
		//display movie's information with toString
		System.out.println(m1);
		
		System.out.println("Goodbye");
		keyboard.close();
	}
}