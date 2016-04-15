import java.util.ArrayList;

//Version Apr 10.1
public class StatisticsTester{
	public static void main(String []args)
	{
		ArrayList<Stats> arrayList; //include this in driver class, it is used for sorting
		
		// hard-coding player name for testing purposes
		String playerName = "Greg Benjamin";
		
		//*****Note: player name cannot contain '~'
		Statistics statObj = new Statistics(playerName); // use this constructor after you get player name.
		
		
		// hard-coding the following values for testing purposes
		int victory = 1; // this is either 1 or 0.  Did they win or did they lose?
		int days = 22; // how many days did player survive?
		int buildings = 4; // how many buildings did player get?
		int resources = 8; // how many resources did player get?
		
		//set stats when player achieves them
		statObj.setVictory(victory);
		statObj.setDays(days);
		statObj.setBuildings(buildings);
		statObj.setResources(resources);
		
		//always do these three consecutively.  Used for obtaining file info, sorting file info, and overwriting file with sorted data 
		statObj.writeToFile();
		arrayList = statObj.makeArrayList();
		statObj.writeListToFile(arrayList);
		
		//When you need to print the file
		//(that is, user selects "View Stats")
		// note: I will more nicely format this when GUI is incorporated
		statObj.printFile();
		
	}
}
