import java.util.ArrayList;
import java.util.Collections;



public class SortList{
	
	public static void main(String []args)
	{
		ArrayList<Stats> list = new ArrayList<Stats>();
		list.add(new Stats("GregJ", 1,2,6,10));
		list.add(new Stats("GregI", 0,3,5,10));
		list.add(new Stats("GregH", 0,3,1,0));
		list.add(new Stats("GregG", 1,3,6,10));
		list.add(new Stats("GregF", 1,1,6,10));
		list.add(new Stats("GregE", 1,3,8,5));
		list.add(new Stats("GregD", 0,3,12,0));
		list.add(new Stats("GregC", 1,3,6,10));
		list.add(new Stats("GregB", 1,1,6,10));
		list.add(new Stats("GregA", 1,3,12,4));
		
		Collections.sort(list);
		for (Stats stat: list)
			System.out.println(stat);
	}
}

class Stats implements Comparable<Stats>{
	
	private String player;
	private int win;
	private int time;
	private int properties;
	private int supplies; 
	
	Stats(String player,int win, int time, int properties, int supplies)
	{
		this.player = player;
		this.win = win;
		this.time = time;
		this.properties = properties;
		this.supplies = supplies;
	}
	public String getPlayer()
	{
		return this.player;
	}
	public int getWin()
	{
		return this.win;
	}
	public int getTime()
	{
		return this.time;
	}
	public int getProperties()
	{
		return this.properties;
	}
	public int getSupplies()
	{
		return this.supplies;
	}
	@Override
	public int compareTo(Stats compareStat){
		
		int compareVictory = compareStat.getWin();
		if(compareVictory != this.win)
		{
			return compareVictory-this.win;
		}
		else //compareVictory == this.win
		{
			int compareTime = compareStat.getTime();
		
			if(compareTime != this.time){
				return compareTime-this.time;
			}
			else //compareVictory == this.win && compareTime == this.time
			{
				int compareProperties = compareStat.getProperties();
				
				if(compareProperties != this.properties){
					return compareProperties-this.properties;
				}
				else{ //compareVictory == this.win && compareTime == this.time && compareProperties == this.properties
					int compareSupplies = compareStat.getSupplies();
					if(compareSupplies != this.supplies){
						return compareSupplies-this.supplies;
					}
					else{ // all fields are the same.  Put in alphabetical order by player name
						String playerString = compareStat.getPlayer();
						return (1-playerString.compareTo(this.player));
					
					}
				}	
			}
		}
	}
	
	@Override
	public String toString(){
		return "[ name=" + this.player + ", win=" + this.win + ", time=" + this.time + ", properties=" + this.properties
				+ ", supplies=" + this.supplies + " ]";
	}
}


