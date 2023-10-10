import java.util.ArrayList;

public class GradeBook
{
   private double[] scores;
   private int scoresSize = 0;

   /**
      Constructs a gradebook with no scores and a given capacity.
      @capacity the maximum number of scores in this gradebook
   */
   public GradeBook(int capacity)
   {
      scores = new double[capacity];
      scoresSize = 0;
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;      
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }
      
   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
      if (scoresSize == 0) return 0;
      double smallest = scores[0];
      for (int i = 1; i < scoresSize; i++)
      {
         if (scores[i] < smallest)
         {
            smallest = scores[i];
         }
      }
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if 
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore() 
   {
      if (scoresSize == 0)
         return 0;
      else if (scoresSize == 1)
         return scores[0];
      else
         return sum() - minimum();
   }
   
   
   //Task#1: add getScoreSize() method which returns scoresSize
   public int getScoreSize()
   {
	   return this.scoresSize;
   }
   
   //Task#1: add toString() method that returns a string with each score in scores, separated by space
   public String toString()
   {
	   //create an array for line with the size of scoresSize
	   String[] line = new String [scoresSize];
	   int start = 0;
	   
	   //initiate array line with values from the array scores, separated by space
	   while (start < scoresSize)
	   {
		   line[start] = scores[start] + " ";
		   start++;
	   }
	   
	   //initiate String complete with first element of array line
	   String complete = line[0];
	   //return String complete if there's only 1 element
	   if (scoresSize ==0)
	   {
		   return complete;
	   }
	   
	   //loop through to form String complete with all the values in array line
	   for(int i = 1; i < scoresSize; i++)
	   {
		   complete+= line[i];
	   }
	   return complete;
   }
}

