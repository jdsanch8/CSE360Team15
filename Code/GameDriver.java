import java.util.Scanner;

public class GameDriver {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean continuePlaying = true;
		
		System.out.print("Please enter your name: ");
		String playerName = in.next();
		
		while (continuePlaying){
			Game myGame = new Game(playerName);
			continuePlaying = myGame.gameController();
		}
	}
}