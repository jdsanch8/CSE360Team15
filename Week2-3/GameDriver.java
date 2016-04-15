import java.util.Scanner;
/**
 * GameDriver class is the driver for the game. It prompts for the player's name and
 * instantiates a Game object to begin the game.
 * @author Team15
 */
public class GameDriver {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean continuePlaying = true;
		
		System.out.print("Please enter your name: ");
		String playerName = in.next();
		
		while (continuePlaying){
			Game myGame = new Game(playerName);
			continuePlaying = myGame.gameController();
		}
		
		in.close();
	}
}