/**
 * Generates random results, and modifies the values in the game object accordingly
 */

//import java.lang.*;
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
			tempValue = (Math.abs(roller.nextInt()) % multipler + 1) * 2;
			goodLuck = false;
		}
		else
			tempValue = Math.abs(roller.nextInt()) % multipler + 1;
		if(badLuck){
			if(house)
				multipler = 8;
			else
				multipler = 6;
		}
		return tempValue;
	}

	/**
	 * Rolls a die that can only provide wood
	 * @param mult value rolled from multiplier die
	 * @param config game containing the resource information
	 * @return string with the outcome of the roll
	 */
	public String rollWood(int mult, Game config){ //Access game class
		int value = Math.abs(roller.nextInt(6)) % DICE_SIZE + 1;
		String tmp = "";
		if(value <= 4){
			config.updateWood(mult);
			tmp = "The mill has produced " + mult + " wood!";
		}
		return tmp;
	}

	/**
	 * Rolls a die that can only provide stone
	 * @param mult value rolled from multiplier die
	 * @param config game containing the resource information
	 * @return string with the outcome of the roll
	 */
	public String rollStone(int mult, Game config){ //Access game class
		int value = Math.abs(roller.nextInt()) % DICE_SIZE + 1;
		String tmp = "";
		if(value <= 4){
			config.updateStone(mult);
			tmp = "The mine has produced " + mult + " stone!";
		}
		return tmp;
	}

	/**
	 * Rolls the starting die, that can provide various boons and banes
	 * @param mult value rolled from multiplier die
	 * @param config game containing the resource information
	 * @return string with the outcome of the roll
	 */
	public String rollBase(int mult, Game config){ //Access Game Class
		int value = Math.abs(roller.nextInt()) % DICE_SIZE + 1;
		String output = "";
		switch (value){
		case 1:
			config.updateWood(mult);
			output = "The workers have produced " + mult + " wood!";
			break;
		case 2:
			config.updateStone(mult);
			output = "The workers have produced " + mult + " stone!";
			break;
		case 3:
			output = rollDespair(mult, config);
			break;
		case 4:
			output = rollSkill(mult, config);
			break;
		case 5:
		case 6:
			config.updateFood(mult);
			output = "The workers have produced " + mult + " food!";
			break;
		}
		return output;
	}

	/**
	 * If despair is rolled on base die, this triggers something bad to happen
	 * @param mult value rolled from multiplier die
	 * @param config game containing the resource information
	 * @return string with the outcome of the roll
	 */
	private String rollDespair(int mult, Game config){ //Access Game Class
		if(fence){
			mult = mult/2;
		}
		String output = "";
		int value = Math.abs(roller.nextInt()) % DICE_SIZE + 1;
		
		switch (value){
		case 1:
			config.updateWood(-mult);
			output = "The thief has stolen " + mult + " wood!";
			break;
		case 2:
			config.updateStone(-mult);
			output = "The thief has stolen " + mult + " stone!";
			break;
		case 3:
			config.updateFood(-mult);
			output = "The thief has stolen " + mult + " food!";
			break;
		case 4:
			config.updateWood(-mult);
			config.updateStone(-mult);
			config.updateFood(-mult);
			output = "The thief has stolen " + mult + " of everything!";
			break;
		case 5:
		case 6:
			multipler = 4;
			badLuck = true;
			output = "The clouds darken the sky. Tomorrow will not be a productive day.";
			break;
		}
		return output;
	}

	/**
	 * If skill is rolled on base die, this triggers something good to happen
	 * @param mult value rolled from multiplier die
	 * @param config game containing the resource information
	 * @return string with the outcome of the roll
	 */
	private String rollSkill(int mult, Game config){ //Access Game Class
		int value = Math.abs(roller.nextInt()) % DICE_SIZE + 1;
		String output = "";
		
		switch (value){
		case 1:
			output = "Fate favors you, and the gods have increased current wood by 50%";
			config.setWood((int)(config.getWood()*1.5));
			break;
		case 2:
			output = "Fate favors you, and the gods have increased current stone by 50%";
			config.setStone((int)(config.getStone()*1.5));
			break;
		case 3:
			output = "Fate favors you, and the gods have increased food by 10%.";
			config.setFood((int)(config.getFood()*1.1));
			break;
		case 4:
			output = "Fate favors you, and the gods have increased everything by " + mult;
			config.updateWood(mult);
			config.updateStone(mult);
			config.updateFood(mult);
			break;
		case 5:
		case 6:
			output = "The sky looks bright. Tomorrow will be a very productive day.";
			goodLuck = true;
			break;
		}
		return output;
	}

	/**
	 * When a house is built, the multiplier die becomes a d8 instead of a d6
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

	/**
	 * Getter method for the completion status of the house
	 * @return true/false depending if the house is built or not
	 */
	public boolean getHouse(){
		return house;
	}

	/**
	 * Getter method for the completion status of the fence
	 * @return true/false depending if the house is built or not
	 */
	public boolean getFence(){
		return fence;
	}

	/**
	 * Getter method for the status of goodLuck
	 * @return true/false depending on the value of goodLuck
	 */
	public boolean getGoodLuck(){
		return goodLuck;
	}

	/**
	 * Getter method for the status of badLuck
	 * @return true/false depending on the value of badLuck
	 */
	public boolean getBadLuck(){
		return badLuck;
	}
}