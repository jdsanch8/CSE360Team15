import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


// getting the comparable interface going to sort arrayList
public class SortList{
	
	public static void main(String []args)
	{
		ArrayList<Stats> list = new ArrayList<Stats>();
		list.add(new Stats("GregA", 1,2,6,10));
		list.add(new Stats("GregB", 0,3,5,10));
		list.add(new Stats("GregC", 0,3,1,0));
		list.add(new Stats("GregD", 1,3,6,10));
		list.add(new Stats("GregE", 1,1,6,10));
		list.add(new Stats("GregF", 1,3,8,4));
		
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
	public int properties()
	{
		return this.properties;
	}
	public int supplies()
	{
		return this.supplies;
	}
	@Override
	public int compareTo(Stats compareStat){
		
		int compareVictory = ((Stats)compareStat).getWin();
		return compareVictory-this.win;
	}
	
	@Override
	public String toString(){
		return "[ name=" + this.player + ", win=" + this.win + ", time=" + this.time + ", properties=" + this.properties
				+ ", supplies=" + this.supplies + " ]";
	}
}


