import java.util.Scanner;

public class GameDriver {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int continuePlaying = 1;
		while (continuePlaying == 1){
			System.out.print("Please enter your name: ");
			String playerName = in.next();
			Game myGame = new Game(playerName);
			continuePlaying = myGame.gameController();
		}
	}
}