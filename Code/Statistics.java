import java.io.*;
import java.util.ArrayList;

public class Statistics {
	
	private String playerName;
	
	private int victory;	
	private int days;
	private int buildings;
	private int resources;
    // note: create txt file of this name and place in same package
	private File file = new File(getClass().getResource("gameStats-group15.txt").getFile());
	// nested class acting like a struct.  What can I say, I'm more of a C/C++ kind of guy...
	private class Stats {
		
		private String player;
		private int win;
		private int time;
		private int properties;
		private int supplies; 
		
		private Stats(String player,int win, int time, int properties, int supplies)
		{
			this.player = player;
			this.win = win;
			this.time = time;
			this.properties = properties;
			this.supplies = supplies;
		}
		private String getPlayer()
		{
			return this.player;
		}
		
		private int getWin()
		{
			return this.win;
		}
		private int getTime()
		{
			return this.time;
		}
		private int properties()
		{
			return this.properties;
		}
		private int supplies()
		{
			return this.supplies;
		}
	}
	
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
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" +  file.getName() + "'.");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '"  + file.getName() + "'.");                  
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
			
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());

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
           
            sortFile();
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println( "Error writing to file '" + file.getName() + "'.");
        }
	}
	
	private void sortFile()
	{
		ArrayList<Stats> list = new ArrayList<Stats>();
		String player = "";
		int win = 0;
		int time = 0;
		int properties = 0;
		int supplies = 0;
		String [] token;

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
				//Stats st = list.get(0);// get doesn't remove, like "peek"
				//int v = st.getWin();	
			}   
			bufferedReader.close();         
		}
		//To do: look at each index of arrayList.  and put in weighted order
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" +  file.getName() + "'.");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '"  + file.getName() + "'.");                  
		}
		
		
		
		
		
	}
}
