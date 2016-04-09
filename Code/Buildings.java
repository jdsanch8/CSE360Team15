public class Buildings {
	
	//variables
	private boolean house;
	private boolean fence;
	private boolean well;
	private boolean mill;
	private boolean mine;
	
	//constructor
	public Buildings()
	{
		house = false;
		fence = false;
		well = false;
		mill = false;
		mine = false;
	}
	
	//setters
	public void buildHouse(int stone, int wood)
	{
		if(stone == 5 && wood == 5)
			house = true;
	}
	
	public void buildFence(int stone, int wood)
	{
		if(stone == 2 && wood == 5)
			fence = true;
	}
	
	public void buildWell(int stone, int wood)
	{
		if(stone == 5 && wood == 2)
			well = true;
	}
	
	public void buildMill(int stone, int wood)
	{
		if(stone == 5 && wood == 0)
			mill = true;
	}
	
	public void buildMine(int stone, int wood)
	{
		if(stone == 0 && wood == 5)
			mine = true;
	}
	
	//getters
	public boolean getHouse()
	{
		return house;
	}
	
	public boolean getFence()
	{
		return fence;
	}
	
	public boolean getWell()
	{
		return well;
	}
	
	public boolean getMill()
	{
		return mill;
	}
	
	public boolean getMine()
	{
		return mine;
	}
	
}
