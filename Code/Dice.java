/**
 * Generators random results, and modifies the values in the game object accordingly
 */

import java.util.Random;

public class Dice{

	Random roller;
	private int multipler;
	private final int DICE_SIZE = 6;
	boolean goodLuck;
	boolean badLuck;
	boolean house;
	boolean fence;
	
	/**
	 * Constructor, sets initial values to false, and multiplier to 6
	 */
	public Dice(){
		roller = new Random();
		multipler = 6;
		badLuck = false;
		house = false;
		fence = false;
		goodLuck = false;
	}
	/**
	 * Rolls a die, depending on size of multipler, and returns the result
	 * @return the randomly generated integer value
	 */
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
				multipler = 8;
			else
				multipler = 6;
		}
		System.out.println("\nYou've rolled" + tempValue);
		return tempValue;
	}

	/**
	 * Rolls a die that can only provide wood
	 * @param mult value rolled from multipler die
	 * @param config game containing the resource information
	 */
	public void rollWood(int mult, Game config){ //Access game class
		int value = roller.nextInt() % DICE_SIZE + 1;
		if(value <= 4){
			System.out.println("The mill has produced " + mult + " wood!");
			config.setWood(mult);
		}
	}

	/**
	 * Rolls a die that can only provide stone
	 * @param mult value rolled from multipler die
	 * @param config game containing the resource information
	 */
	public void rollStone(int mult, Game config){ //Access game class
		int value = roller.nextInt() % DICE_SIZE + 1;
			if(value <= 4){
				config.setStone(mult);
				System.out.println("The mine has produced " + mult + " stone!");
			}
	}

	/**
	 * Rolls the starting die, that can provide various boons and banes
	 * @param mult value rolled from multipler die
	 * @param config game containing the resource information
	 */
	public void rollBase(int mult, Game config){ //Access Game Class
		int value = roller.nextInt() % DICE_SIZE + 1;
		switch (value){
		case 1:
			config.setWood(mult);
			System.out.println("The workers have produced " + mult + " wood!");
			break;
		case 2:
			config.setStone(mult);
			System.out.println("The workers have produced " + mult + " stone!");
			break;
		case 3:
			rollDespair(mult, config);
			break;
		case 4:
			rollSkill(mult, config);
			break;
		case 5:
		case 6:
			config.setFood(mult);
			System.out.println("The workers have produced " + mult + " food!");
			break;
		}

	}
	
	/**
	 * If despiar is rolled on base die, this triggers something bad to happen
	 * @param mult value rolled from multipler die
	 * @param config game containing the resource information
	 */
	private void rollDespair(int mult, Game config){ //Access Game Class
		if(fence)
			mult = mult/2;
		int value = roller.nextInt() % DICE_SIZE + 1;
				switch (value){
				case 1:
					System.out.println("The thief has stolen " + mult + " wood!");
					config.setWood(-mult);
					break;
				case 2:
					System.out.println("The thief has stolen " + mult + " stone!");
					config.setStone(-mult);
					break;
				case 3:
					System.out.println("The thief has stolen " + mult + " food!");
					config.setFood(-mult);
					break;
				case 4:
					System.out.println("The thief has stolen " + mult + " of everything!");
					config.setWood(-mult);
					config.setStone(-mult);
					config.setFood(-mult);
					break;
				case 5:
				case 6:
					System.out.println("The clouds darken the sky. Tomorrow will not be a productive day.");
					multipler = 4;
					badLuck = true;
					break;
				}
	}
	
	/**
	 * If skill is rolled on base die, this triggers something good to happen
	 * @param mult value rolled from multipler die
	 * @param config game containing the resource information
	 */
	private void rollSkill(int mult, Game config){ //Access Game Class
		int value = roller.nextInt() % DICE_SIZE + 1;
		switch (value){
		case 1:
			System.out.println("Fate favors you, and the gods have increased current wood by 50%");
			config.setWood((int)(config.getWood()*1.5));
			break;
		case 2:
			System.out.println("Fate favors you, and the gods have increased current stone by 50%");
			config.setStone((int)(config.getStone()*1.5));
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
			System.out.println("The sky looks bright. Tomorrow will be a very productive day.");
			goodLuck = true;
			break;
		}
	}

	/**
	 * When a house is built, the mutiplier die becomes a d8 instead of a d6
	 */
	public void upGradeMulti(){ //When house is built
		multipler += 2;
		house = true;
	}

	/**
	 * When a fence is built, it reduces the effects of the despair
	 */
	public void deGradeDespairMulti(){ //When fence is built
		fence = true;
	}
}