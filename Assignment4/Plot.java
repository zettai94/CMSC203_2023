/*Name: Silvia Lim Siew Ling
 * Student ID: M21154781
 * Class: CMSC 203
 * Project: 4
 * Due date: 4th Nov 2023*/
public class Plot {
	//attributes
	private int width;
	private int depth;
	private int x;
	private int y;
	
	//default constructor with width and depth of 1
	public Plot()
	{
		this.width = 1;
		this.depth = 1;
	}
	
	//creates a Plot using given values
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y= y;
		this.width = width;
		this.depth = depth;
	}
	
	//creates a new plot given another plot, copy constructor
	public Plot(Plot otherPlot)
	{
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
		this.x = otherPlot.x;
		this.y = otherPlot.y;
	}
	
	//determine if given plot is emcompassed (contained within) this plot
	public boolean encompasses(Plot plot)
	{
		int plotWidth = plot.getX() + plot.getWidth();
		int plotDepth = plot.getY() + plot.getDepth();
		
		int thisWidth = this.x + this.width;
		int thisDepth = this.y + this.depth;
		
		//if x is smaller/equal to plot's x, but x+width is bigger than plot's x+width
		//and y is smaller/equal to plot's y, but y+depth is bigger than plot's y+depth
		if (this.x <= plot.getX() && thisWidth >= plotWidth && this.y <= plot.getY() && thisDepth >= plotDepth)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//4 accessors
	public int getDepth()
	{
		return this.depth;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	//check if this plot overlaps plot in parameter
	public boolean overlaps(Plot plot)
	{
		int thisWidth = this.x + this.width;
		int thisDepth = this.y + this.depth;
		int plotWidth = plot.getX() + plot.getWidth();
		int plotDepth = plot.getY() + plot.getDepth();
		boolean plotXOverlap;
		boolean plotYOverlap;
		
		//if (x) smaller than (plot's x+width) AND also (x+width) bigger than (plot's x)
		//if both false, condition will equal true
		if (this.x < plotWidth && thisWidth > plot.getX())
		{
			plotXOverlap = true;
		}
		else
		{
			plotXOverlap = false;
		}
		
		//apply same thing to y
		if(this.y < plotDepth && thisDepth > plot.getY())
		{
			plotYOverlap = true;
		}
		else
		{
			plotYOverlap = false;
		}
		
		return (plotXOverlap && plotYOverlap);
	
	}
	
	//4 mutators
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	//toString method format: x,y,width,depth
	public String toString()
	{
		String line = this.x + "," + this.y + "," + this.width + "," + this.depth;
		return line;
	}
}
