/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: Calculate Holiday Bonus from passed array
 * Due: 28th Nov 2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Silvia Lim Siew Ling
*/

public class HolidayBonus {

	private static final double HIGHEST = 5000;
	private static final double LOWEST = 1000;
	private static final double AVERAGE = 2000;
	
	public HolidayBonus()
	{
		
	}
	
	//calculate holiday bonus for each store
	public static double[] calculateHolidayBonus(double[][] data)
	{
		//parameter 2 dimensional array of store sales
		//return an array of the bonus for each store
		int col;
		double[][] bonusArray = new double[data.length][];
		for(int r = 0; r < data.length; r++)
		{
			col = data[r].length;
			bonusArray[r] = new double[col];
			
			//only assign when data's value is bigger than 0
			for (int c = 0; c < col; c++)
			{
				if(data[r][c] == TwoDimRaggedArrayUtility.getHighestInColumn(data, c))
				{
					if(data[r][c] > 0)
					{
						bonusArray[r][c] = HIGHEST;
					}
				}
				else if(data[r][c] == TwoDimRaggedArrayUtility.getLowestInColumn(data, c))
				{
					if(data[r][c] > 0)
					{
						bonusArray[r][c] = LOWEST;
					}
				}
				else
				{
					if(data[r][c] > 0)
					{
						bonusArray[r][c] = AVERAGE;
					}
				}
			}
		}
		
		double[] bonusByStore = new double[data.length];
		double total;
		for(int r = 0; r < data.length; r++)
		{
			total = 0;
			col = data[r].length;
			for(int c = 0; c < col; c++)
			{
				total += bonusArray[r][c];
			}

			bonusByStore[r] = total;
		}
		
		return bonusByStore;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		////parameter 2 dimensional array of store sales
		//return total of all holiday bonuses
		double[] storeBonus = HolidayBonus.calculateHolidayBonus(data);
		double totalBonus = 0;
		for (int i = 0; i < storeBonus.length; i++)
		{
			totalBonus += storeBonus[i];
		}
		
		return totalBonus;
	}
}
