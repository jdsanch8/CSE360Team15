import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//Version Apr 10.2
public class Statistics {
	
	private String playerName;
	
	private int victory;	
	private int days;
	private int buildings;
	private int resources;
    // note: file will be created (if it doesn't already exist)  Will be placed in project FOLDER
	private String filename = "g15.txt";
	private String workingDirectory = System.getProperty("user.dir");
	private File file = new File(workingDirectory, filename);
	
	public Statistics(String playerName) 
	{
		this.victory = 0;
		this.days = 0;
		this.buildings = 0;
		this.resources = 0;
		this.playerName = playerName;
		
		if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void printFile()
	{
		String line = null;

		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}   
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) { System.out.println("Unable to open file '" +  file.getName() + "'.");                
		}
		catch(IOException ex) {System.out.println("Error reading file '"  + file.getName() + "'.");                  
		}
	}
	
	public void setVictory (int victory)
	{
		this.victory = victory;
	}
	
	public void setDays (int days)
	{
		this.days = days;
	}
	
	public void setBuildings (int buildings)
	{
		this.buildings = buildings;
	}
	
	public void setResources (int resources)
	{
		this.resources = resources;
	}
	
	public void writeToFile()
	{
		
		try {
			
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true); //true is append

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(this.playerName);
            bufferedWriter.write("-");
            bufferedWriter.write(Integer.toString(this.victory));
            bufferedWriter.write("-");
            bufferedWriter.write(Integer.toString(this.days));
            bufferedWriter.write("-");
            bufferedWriter.write(Integer.toString(this.buildings));
            bufferedWriter.write("-");
            bufferedWriter.write(Integer.toString(this.resources));
            bufferedWriter.newLine();
           
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println( "Error writing to file '" + file.getName() + "'.");
        }
	}
	
	public ArrayList<Stats> makeArrayList()
	{
		ArrayList<Stats> list = new ArrayList<Stats>();
		String token [];
		String player; int win; int time; int properties; int supplies;

		String line = null;

		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {

				//parse out each term.  put in an index of arrayList
				token = line.split("-");
				player = token[0];

				win = Integer.parseInt(token[1]);
				time = Integer.parseInt(token[2]);
				properties = Integer.parseInt(token[3]);
				supplies = Integer.parseInt(token[4]);

				list.add(new Stats(player, win,time, properties, supplies));

				//debug
				/*
				for(int i = 0; i < token.length; i++)
				{
					System.out.println("token[" + i + "] = " + token[i]);
				}
				*/
			}   
			bufferedReader.close();   
			Collections.sort(list);
		}
		catch(FileNotFoundException ex) { System.out.println("Unable to open file '" +  file.getName() + "'.");                
		}
		catch(IOException ex) {System.out.println("Error reading file '"  + file.getName() + "'.");                  
		}   
		return list;
	}

	public void writeListToFile(ArrayList<Stats> arrayList){

		try {

			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), false); //append is false

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for(Stats stat: arrayList)
			{
				bufferedWriter.write(stat.getPlayer());
				bufferedWriter.write("-");
				bufferedWriter.write(Integer.toString(stat.getWin()));
				bufferedWriter.write("-");
				bufferedWriter.write(Integer.toString(stat.getTime()));
				bufferedWriter.write("-");
				bufferedWriter.write(Integer.toString(stat.getProperties()));
				bufferedWriter.write("-");
				bufferedWriter.write(Integer.toString(stat.getSupplies()));
				bufferedWriter.newLine();
			}          

			bufferedWriter.close();
		}
		catch(IOException ex) {
			System.out.println( "Error writing to file '" + file.getName() + "'.");
		}

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
