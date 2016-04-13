import java.util.Scanner;

public class GameDriver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your name: ");
		String playerName = in.next();
		Game myGame = new Game(playerName);
		myGame.gameController();
	}

}
