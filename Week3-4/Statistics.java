import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTextArea;



/**
 * Class Statistics collects player name, statistic of a win or loss by player, days survived by player, buildings made by player, and 
 * resources made by player.  The class creates or appends a data file of these statistics in the folder of the java project.  More specifically,
 * the class writes to the data text file with a specific order of sorting.  That is, a victory has the highest weight for sorting (a 1 always
 * scores higher than a 0).  The next highest weight for sorting is for days. For example, if multiple players have victory = 1, the player who completes 
 * the game the quickest will have a higher rank (i.e., smallest day value).  Conversely, if multiple players have losses (victory = 0), then the player 
 * that survives the longest will have a higher rank (i.e., the largest day value).  The next highest weight for sorting is for buildings made (if victory and days are the same, the player
 * with more buildings will be ranked higher).  The least weighted statistic is resources (if all other statistics are the same, resources
 * are looked at).  Lastly, if all statistics are the same, the listing is done in alphabetical order.
 * 
 * @author Gregory Benjamin 
 * @version April 13, v.3
 */

public class Statistics {

	private String playerName;
	private int victory;	
	private int days;
	private int buildings;
	private int resources;
	private String filename = "group15stats.txt";// note: file will be created (if it doesn't already exist.)  Will be placed in project FOLDER
	private String workingDirectory = System.getProperty("user.home");
	private File file = new File(workingDirectory, filename );

	/**
	 * Statistics constructor sets player name, victory (will become 1 for win, 0 for lose), days survived, buildings built, and resources collected
	 * during gameplay. 
	 * @param playerName is player's name, inputed by player
	 * @throws IOException if file doesn't exist and is unable to be created
	 */

	public Statistics(String playerName) {

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

	
	public void viewStatsInGUI(JTextArea text)
	{
		String token []; // holds parsed statistics obtained from line of txt file
		String player; 
		String win; 
		int winInt;
		String time; 
		String properties; 
		String supplies;
		String line = null; //holds line of txt file
		String toGUI;
		int ranking = 1;
		String rankingStr;

		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				token = line.split("~");
				
				player = String.format("%-25s",token[0]);
				winInt =Integer.parseInt( token[1]);
				if(winInt == 1){
					win = String.format("%-7s","Yes");
				}
				else {
					win = String.format("%-7s","No");
				}
				time = String.format("%-8s", token[2]);
				properties = String.format("%-8s", token[3]);
				supplies = String.format("%-8s", token[4]);
				rankingStr =String.format("%s",ranking);
				rankingStr = rankingStr.concat(".");
				rankingStr = String.format("%-5s",rankingStr);
				toGUI = player + win + time + properties + supplies;
				
				text.append(rankingStr + toGUI +"\n");
				ranking++;
			}   
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) { 
			System.out.println("Unable to open file '" +  file.getName() + "'.");                
		}
		catch(IOException ex) {
			System.out.println("Error reading file '"  + file.getName() + "'.");                  
		}
	}
	
	/**
	 * printFile() gets file and reads it line by line and prints line by line
	 * @throws FileNotFoundException if file is unable to open
	 * @throws IOException if there is error reading file
	 */

	public void printFile(){

		String line = null; //holds line of txt file

		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}   
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) { 
			System.out.println("Unable to open file '" +  file.getName() + "'.");                
		}
		catch(IOException ex) {
			System.out.println("Error reading file '"  + file.getName() + "'.");                  
		}
	}

	/**
	 * setVictory passes in a victory (1) or a loss (0) depending on game play result.
	 * @param victory is either 1 for win or 0 for loss.
	 */

	public void setVictory (int victory){
		this.victory = victory;
	}

	/**
	 * setDays passes in days player has survived in game.
	 * @param days integer that player has survived.
	 */

	public void setDays (int days){
		this.days = days;
	}

	/**
	 * setBuildings passes in integer number of buildings made during game play
	 * @param buildings integer of buildings made during game
	 */

	public void setBuildings (int buildings){
		this.buildings = buildings;
	}

	/**
	 * setResources passes in integer number of resources collected during game play
	 * @param resources integer of resources collected during game.
	 */

	public void setResources (int resources){
		this.resources = resources;
	}

	//for JUnit testing purposes only
	public String getPlayerName() {
		return this.playerName;
	}
	public int getVictory (){
		return victory;
	}
	public int getDays (){
		return days;
	}
	public int getBuildings (){
		return buildings;
	}
	public int getResources (){
		return resources;
	}
	//end methods solely for unit testing (in real scenario, these stats will be obtained from reading file, not get() methods)
	
	/**
	 * writeListToFile writes (appends, if file already has content) newly collected statistics from game play.
	 * @exception IOException if unable to write to file
	 */
	 
	public void writeToFile(){

		try {
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true); //true is append
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(this.playerName);
			bufferedWriter.write("~");
			bufferedWriter.write(Integer.toString(this.victory));
			bufferedWriter.write("~");
			bufferedWriter.write(Integer.toString(this.days));
			bufferedWriter.write("~");
			bufferedWriter.write(Integer.toString(this.buildings));
			bufferedWriter.write("~");
			bufferedWriter.write(Integer.toString(this.resources));
			bufferedWriter.newLine();
			bufferedWriter.close();
		}
		catch(IOException ex) {
			System.out.println( "Error writing to file '" + file.getName() + "'.");
		}
	}

	/**
	 * makeArrayList reads in file line by line and parses out each statistic.  The parsed statistics from a single line of the text file
	 * are placed in one element of an arrayList.  The sorting of the arrayList is done by weighting described in Statistics class description.  
	 * @return ArrayList of sorted Stats Class objects.
	 * @exception FileNotFoundException if file is not found
	 * @exception IOException if there is error reading file
	 */

	public ArrayList<Stats> makeArrayList(){
		
		ArrayList<Stats> list = new ArrayList<Stats>();
		String token []; // holds parsed statistics obtained from line of txt file
		String player; 
		int win; 
		int time; 
		int properties; 
		int supplies;
		String line = null; //holds line of txt file

		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {

				//parse out each term.  put in an index of arrayList
				token = line.split("~");
				player = token[0];
				win = Integer.parseInt(token[1]);
				time = Integer.parseInt(token[2]);
				properties = Integer.parseInt(token[3]);
				supplies = Integer.parseInt(token[4]);
				list.add(new Stats(player, win,time, properties, supplies));
			}   
			bufferedReader.close();   
			Collections.sort(list); //sort list using overrided CompareTo method
		}
		catch(FileNotFoundException ex) { 
			System.out.println("Unable to open file '" +  file.getName() + "'.");                
		}
		catch(IOException ex) {
			System.out.println("Error reading file '"  + file.getName() + "'.");                  
		}   
		return list;
	}

	/**
	 * writeListToFile overwrites file with sorted data stored in ArrayList
	 * @param ArrayList of sorted elements of Stats Class objects.
	 * @exception IOException if unable to write to file
	 */

	public void writeListToFile(ArrayList<Stats> arrayList){

		try {
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), false); //append is false
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			for(Stats stat: arrayList){
				bufferedWriter.write(stat.getPlayer());
				bufferedWriter.write("~");
				bufferedWriter.write(Integer.toString(stat.getWin()));
				bufferedWriter.write("~");
				bufferedWriter.write(Integer.toString(stat.getTime()));
				bufferedWriter.write("~");
				bufferedWriter.write(Integer.toString(stat.getProperties()));
				bufferedWriter.write("~");
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

/**
 * Class Stats is similar to the Statistics class.  The difference is the Stats class is designed for ArrayList use only.
 * ArrayList is of type Stats for ease of sorting: this class implements Comparable.
 * @author Gregory Benjamin 
 * @version April 10 v.4
 */

class Stats implements Comparable<Stats>{

	private String player;
	private int win;
	private int time;
	private int properties;
	private int supplies; 

	/**
	 * Stats constructor sets player name, win (will become 1 for win, 0 for lose), time survived, properties built, and supplies collected
	 * during gameplay. 
	 * @param playerName is player's name
	 * @param win is integer 1 for win and 0 for loss
	 * @param time is integer for days survived
	 * @param properties is integer for buildings built
	 * @param supplies is integer for resources collected
	 */
	
	Stats(String player,int win, int time, int properties, int supplies){
		this.player = player;
		this.win = win;
		this.time = time;
		this.properties = properties;
		this.supplies = supplies;
	}
	
	/**
	 * getPlayer obtains player name
	 * @return player String of player's name
	 */
	
	public String getPlayer(){
		return this.player;
	}
	
	/**
	 * getWin obtains if player won or lost
	 * @return win integer that is 1 for win, 0 for loss
	 */
	
	public int getWin(){
		return this.win;
	}
	
	/**
	 * getTime obtains duration of time that player survived game
	 * @return time integer that is time of survival
	 */
	
	public int getTime(){
		return this.time;
	}
	
	/**
	 * getProperties obtains number of buildings that player made
	 * @return properties integer number of buildings built
	 */
	
	public int getProperties(){
		return this.properties;
	}
	
	/**
	 * getSupplies obtains number of resources that player accumulated
	 * @return supplies integer number of resources accumulated by player 
	 */
	
	public int getSupplies(){
		return this.supplies;
	}

	/**
	 * compareTo overrides compareTo function for use that is specific to this program's requirements:
	 * A victory has the highest weight for sorting (a 1 always scores higher than a 0).  
	 * The next highest weight for sorting is for days. For example, if multiple players have victory = 1, the player who completes 
	 * the game the quickest will have a higher rank (i.e., smallest day value).  Conversely, if multiple players have losses (victory = 0), then the player 
	 * that survives the longest will have a higher rank (i.e., the largest day value).  The next highest weight for sorting is for buildings made 
	 * (if victory and days are the same, the player with more buildings will be ranked higher).  The least weighted statistic is resources 
	 * (if all other statistics are the same, resources are looked at).  Lastly, if all statistics are the same, the listing is done in alphabetical order.  
	 * @param compareStat of type Stats is being compared to the instance of Stats class that is associated with the compareTo method.
	 */

	@Override
	public int compareTo(Stats compareStat){

		int compareVictory = compareStat.getWin(); // victory has the highest weight for sorting
		if(compareVictory != this.win){
			return compareVictory - this.win;
		}
		else{ //compareVictory == this.win
			int compareTime = compareStat.getTime(); // days has the next highest weight for sorting

			if(compareTime != this.time){
				if (compareVictory == 0){
					return compareTime - this.time; // if player has victory = 0, the player with the higher amount of days has higher rank
				}
				else{ // compareVictory = 1
					return this.time - compareTime; // if player has victory = 1, the player with the smaller amount of days has higher rank
				}
			}
			else{ //compareVictory == this.win && compareTime == this.time

				int compareProperties = compareStat.getProperties();  // buildings have the next highest weight for sorting

				if(compareProperties != this.properties){
					return compareProperties - this.properties;
				}
				else{ //compareVictory == this.win && compareTime == this.time && compareProperties == this.properties
					int compareSupplies = compareStat.getSupplies();  // resources have the next highest weight for sorting
					if(compareSupplies != this.supplies){
						return compareSupplies - this.supplies;
					}
					else{ // all fields are the same.  Put in alphabetical order by player name
						String playerString = compareStat.getPlayer();
						return (1 - playerString.compareTo(this.player));
					}
				}	
			}
		}
	}

	//For JUnit testing purposes only
	@Override
	public String toString(){
		return "name=" + this.player + ", win=" + this.win + ", time=" + this.time + ", properties=" + this.properties
				+ ", supplies=" + this.supplies;
	} 
}
