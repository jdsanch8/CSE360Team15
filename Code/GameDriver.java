import java.util.Scanner;
import java.util.ArrayList;

public class GameDriver {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ArrayList<Stats> arrayList; //include this in driver class, it is used for sorting stats
		
		Scanner in = new Scanner(System.in);
		int continuePlaying = 1;
		while (continuePlaying == 1){
			System.out.print("Please enter your name: ");
			String playerName = in.next();
			Game myGame = new Game(playerName);
			
			Statistics statObj = new Statistics(playerName); //*****Note: player name cannot contain '~'
			// hard-coding the following values for testing purposes only:
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
		
			//When you need to print the file content
			//(that is, user wants to "View Stats")
			// note: I will more nicely format this when GUI is incorporated
			statObj.printFile();
			
			
			continuePlaying = myGame.gameController();
		}
	}
}
