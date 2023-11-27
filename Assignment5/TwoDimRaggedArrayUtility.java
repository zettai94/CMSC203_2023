import java.io.*;
import java.util.Scanner;
/*
 * Class: CMSC203 
 * Instructor: Professor Khandan Monshi
 * Description: Create utility class that creates and reads sales report into array
 * Due: 28th Nov 2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Silvia Lim Siew Ling
*/


public class TwoDimRaggedArrayUtility {
	
	//max row and column = 10
	private final double ROW = 10;
	private final double COL = 10;
	
	public TwoDimRaggedArrayUtility()
	{
		
	}
	
	public static double[][] readFile(File file) throws IOException
	{
		double[][] data;
		Scanner scan = new Scanner(file);
		int row = 0;
		String[][] line;
		
		while(scan.hasNextLine())
		{
			row++;
			scan.nextLine();
		}
		scan.close();
		
		//read for column
		Scanner scan2 = new Scanner(file);
		line = new String[row][];
		data = new double[row][];
		int col;
		
		//read for token with rowLine.split
		String[] token;
		String rowLine;
		
		if(scan2.hasNextLine())
		{
			for(int i = 0; i < line.length; i++)
			{
				//read whole line as rowLine; assign with split to token
				rowLine = scan2.nextLine();
				//token is reset each round with content from new line
				token = rowLine.split(" ");
				//col assign with token's length; assign col to line
				col = token.length;
				line[i] = new String[col];
				for(int j = 0; j < line[i].length; j++)
				{
					//assign token with token
					line[i][j] = token[j];
				}
			}
			
		
			for(int i = 0; i < data.length; i++)
			{
				data[i] = new double[line[i].length];
				for(int j = 0; j < data[i].length; j++)
				{
					data[i][j] = Double.parseDouble(line[i][j]);
				}
			}
		}
		
		scan2.close();
		return data;
	}
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter write = new PrintWriter(outputFile);
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++)
			{
				write.print(data[i][j]);
				//while not last column of the row; add space in between
				if(j < data[i].length-1)
				{
					write.print(" ");
				}
			}
			write.println();
		}
		write.close();
	}
	
	public static double getAverage(double[][] data)
	{
		int element = 0;
		double total = getTotal(data);
		double average;
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				element++;
			}
		}
		
		average = total/element;
		return average;
	}
	
	public static double getTotal(double[][] data)
	{
		double total = 0;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				total += data[row][col];
			}
		}
		
		return total;
	}
	
	public static double getRowTotal(double[][] data, int row)
	{
		double totalRow = 0;
		for(int c = 0; c < data[row].length; c++)
		{
			totalRow += data[row][c];
		}
		return totalRow;
	}
	
	public static double getColumnTotal(double[][] data, int col)
	{
		double totalCol = 0;
		for(int r = 0; r < data.length; r++)
		{
			//count only the row that has column array
			if (col < data[r].length)
			{
				totalCol += data[r][col];
			}
		}
		return totalCol;
	}
	
	public static double getHighestInRow(double[][] data, int row)
	{
		double highest = data[row][0];
		
		for(int c = 0; c < data[row].length; c++)
		{
			if(c < data[row].length)
			{
				if(highest < data[row][c])
				{
					highest = data[row][c];
				}
			}
		}
		
		return highest;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		//initiate indexC as first column of row
		int indexC = 0;
		double highest = data[row][0];
		
		for(int c = 0; c < data[row].length; c++)
		{
			if(c < data[row].length)
			{
				if(highest < data[row][c])
				{
					highest = data[row][c];
					indexC = c;
				}
				
			}
		}
		
		return indexC;
	}
	
	public static double getLowestInRow(double[][] data, int row)
	{
		//initiate lowest as first element of row in data
		double lowest = data[row][0];
		
		for(int c = 0; c < data[row].length; c++)
		{
			if(c < data[row].length)
			{
				if(lowest > data[row][c])
				{
					lowest = data[row][c];
				}
			}
		}
		
		return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		int indexC = 0;
		double lowest = data[row][0];
		
		for(int c = 0; c < data[row].length; c++)
		{
			if(c < data[row].length)
			{
				if(lowest > data[row][c])
				{
					lowest = data[row][c];
					indexC = c;
				}
			}
		}
		
		return indexC;
	}
	
	public static double getHighestInColumn(double[][] data, int col)
	{
		int row = 0;
		
		while(!(data[row].length > col))
		{
			row++;
		}
		
		double highest = data[row][col];
		
		for(int r = 0; r < data.length; r++)
		{
			if(col < data[r].length)
			{
				if(highest < data[r][col])
				{
					highest = data[r][col];
				}
			}
		}
		
		return highest;
	}
	
	public static int getHighestInColumnIndex (double[][] data, int col)
	{
		int row = 0;
		
		while(!(data[row].length > col))
		{
			row++;
		}
		
		double highest = data[row][col];
		int indexR = row;
		for(int r = 0; r < data.length; r++)
		{
			if(col < data[r].length)
			{
				if(highest < data[r][col])
				{
					highest = data[r][col];
					indexR = r;
				}
			}
		}
		
		return indexR;
	}
	
	public static double getLowestInColumn(double[][] data, int col)
	{
		int row = 0;
		
		while(!(data[row].length > col))
		{
			row++;
		}
		
		double lowest = data[row][col];
		
		for(int r = 0; r < data.length; r++)
		{
			if(col < data[r].length)
			{
				if(lowest > data[r][col])
				{
					lowest = data[r][col];
				}
			}
		}
		
		return lowest;
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		int row = 0;
		
		while(!(data[row].length > col))
		{
			row++;
		}
		
		double lowest = data[row][col];
		int indexR = row;
		for(int r = 0; r < data.length; r++)
		{
			if(col < data[r].length)
			{
				if(lowest > data[r][col])
				{
					lowest = data[r][col];
					indexR = r;
				}
			}
		}
		
		return indexR;
	}
	
	public static double getHighestInArray(double[][] data)
	{
		double highest = data[0][0];
		int col;
		
		for(int r = 0; r < data.length; r++)
		{
			col = data[r].length;
			for (int c = 0; c < col; c++)
			{
				if(highest < data[r][c])
				{
					highest = data[r][c];
				}
			}
		}
		
		return highest;
	}
	
	public static double getLowestInArray(double[][] data)
	{
		double lowest = data[0][0];
		int col;
		
		for(int r = 0; r < data.length; r++)
		{
			col = data[r].length;
			for (int c = 0; c < col; c++)
			{
				if(lowest > data[r][c])
				{
					lowest = data[r][c];
				}
			}
		}
		
		return lowest;
	}

}
