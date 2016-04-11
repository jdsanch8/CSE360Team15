public class Buildings {
	
	//variables
	private boolean house;
	private boolean fence;
	private boolean well;
	private boolean mill;
	private boolean mine;
	private boolean farm;
	
	//constructor
	public Buildings()
	{
		house = false;
		fence = false;
		well = false;
		mill = false;
		mine = false;
		farm = false;
	}
	
	//setters
	public boolean buildHouse(int stone, int wood)
	{
		if(stone >= 5 && wood >= 5)
			house = true;
		return house;
	}
	
	public boolean buildFence(int stone, int wood)
	{
		if(stone >= 2 && wood >= 5)
			fence = true;
		return house;
	}
	
	public boolean buildWell(int stone, int wood)
	{
		if(stone >= 5 && wood >= 2)
			well = true;
		return well;
	}
	
	public boolean buildMill(int stone, int wood)
	{
		if(stone >= 5)
			mill = true;
		return mill;
		
	}
	
	public boolean buildMine(int stone, int wood)
	{
		if(wood >= 5)
			mine = true;
		return mine;
	}
	
	public boolean buildfarm(int stone, int wood, int food)
	{
		if(stone >= 3 && wood >= 3 && food >= 3)
			farm = true;
		return farm;
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
	
	public boolean getFarm()
	{
		return farm;
	}
	
}
