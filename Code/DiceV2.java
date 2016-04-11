//Test1

import java.util.Random;

public class Dice{

	Random roller;
	private int multipler;
	private final int DICE_SIZE = 6;
	boolean badLuck;
	boolean house;
	boolean fence;

	public Dice(){
		roller = new Random();
		multipler = 6;
		badLuck = false;
		house = false;
		fence = false;
	}

	public int rollMultiplier(){ //Returns Multiplier
		int tempValue = 0;
		if(goodLuck){
			tempValue = (roller.nextInt() % multipler + 1) * 2;
			goodLuck = false;
		}
		else
			tempValue = roller.nextInt() % multipler + 1;
		if(badLuck){
			if(house)
				multiplier = 8;
			else
				multipler = 6;
		}
		System.out.println("\nYou've rolled" + tempValue);
		return tempValue;
	}

	public void rollWood(int mult, Game config){ //Access game class
		int value = roller.nextInt() % DICE_SIZE + 1;
		if(value <= 4){
			Sytem.out.println("The mill has produced " + mult + " wood!");
			config.setWood(mult);
		}
	}

	public void rollStone(int mult, Game config){ //Access game class
		int value = roller.nextInt() % DICE_SIZE + 1;
			if(value <= 4){
				config.setStone(mult);
				Sytem.out.println("The mine has produced " + mult + " stone!");
			}
	}

	public void rollBase(int mult, Game config){ //Access Game Class
		int value = roller.nextInt() % DICE_SIZE + 1;
		switch (value)
		case 1:
			config.setWood(mult);
			Sytem.out.println("The workers have produced " + mult + " wood!");
			break;
		case 2:
			config.setStone(mult);
			Sytem.out.println("The workers have produced " + mult + " stone!");
			break;
		case 3:
			rollDespair(mult);
			break;
		case 4:
			rollSkill(mult);
			break;
		case 5:
		case 6:
			config.setFood(mult);
			Sytem.out.println("The workers have produced " + mult + " food!");
			break;

	}

	private void rollDespair(int mult, Game config){ //Access Game Class
		if(fence)
			mult = mult/2;
		int value = roller.nextInt() % DICE_SIZE + 1;
				switch (value)
				case 1:
					Sytem.out.println("The thief has stolen " + mult + " wood!");
					config.setWood(-mult);
					break;
				case 2:
					Sytem.out.println("The thief has stolen " + mult + " stone!");
					config.setStone(-mult);
					break;
				case 3:
					Sytem.out.println("The thief has stolen " + mult + " food!");
					config.setFood(-mult);
					break;
				case 4:
					Sytem.out.println("The thief has stolen " + mult + " of everything!");
					config.setWood(-mult);
					config.setStone(-mult);
					config.setFood(-mult);
					break;
				case 5:					
				case 6:
					System.out.println("The clouds darken the sky. Tomorrow will not be a productive day.");
					multiplier = 4;
					badLuck = true;
					break;
	}

	private void rollSkill(int mult, Game config){ //Access Game Class
		int value = roller.nextInt() % DICE_SIZE + 1;
		switch (value)
		case 1:
			System.out.println("Fate favors you, and the gods have increased current wood by 50%");
			config.setWood((int)config.getWood()*1.5);
			break;
		case 2:
			System.out.println("Fate favors you, and the gods have increased current stone by 50%");
			config.setStone((int)config.getStone()*1.5);
			break;
		case 3:
			config.setFood(mult);
			break;
		case 4:
			System.out.println("Fate favors you, and the gods have increased everything by " + mult);
			config.setWood(mult);
			config.setStone(mult);
			config.setFood(mult);
			break;
		case 5:			
		case 6:
			System.out.println("The sky looks bright. Tomorrow will be a very productive day.")
			goodLuck = true;
			break;
	}

	public void upGradeMulti(){ //When house is built
		multipler += 2;
		house = true;
	}

	public void deGradeDespairMulti(){ //When fence is built
		fence = true;
	}
}