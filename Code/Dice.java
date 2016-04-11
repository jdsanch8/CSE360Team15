//Test

import java.util.Random;

public class Dice{

	Random roller;
	private int multipler;
	private final int DICE_SIZE = 6;
	boolean badLuck;
	boolean house;

	public Dice(){
		roller = new Random();
		multipler = 6;
		badLuck = false;
		house = false;
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
		return tempValue;
	}

	public void rollWood(int mult, Game config){ //Access game class
		int value = roller.nextInt() % DICE_SIZE + 1;
		if(value <= 4)
			config.setWood(mult);
	}

	public void rollStone(int mult, Game config){ //Access game class
		int value = roller.nextInt() % DICE_SIZE + 1;
			if(value <= 4)
				config.setStone(mult);
	}

	public void rollBase(int mult, Game config){ //Access Game Class
		int value = roller.nextInt() % DICE_SIZE + 1;
		switch (value)
		case 1:
			config.setWood(mult);
			break;
		case 2:
			config.setStone(mult);
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
			break;

	}

	private void rollDespair(int mult, Game config){ //Access Game Class
		int value = roller.nextInt() % DICE_SIZE + 1;
				switch (value)
				case 1:
					config.setWood(-mult);
					break;
				case 2:
					config.setStone(-mult);
					break;
				case 3:
					config.setFood(-mult);
					break;
				case 4:
					config.setWood(-mult);
					config.setStone(-mult);
					config.setFood(-mult);
					break;
				case 5:					
				case 6:
					multiplier = 4;
					badLuck = true;
					break;
	}

	private void rollSkill(int mult, Game config){ //Access Game Class
		int value = roller.nextInt() % DICE_SIZE + 1;
		switch (value)
		case 1:
			config.setWood(-mult);
			break;
		case 2:
			config.setStone(-mult);
			break;
		case 3:
			config.setFood(-mult);
			break;
		case 4:
			config.setWood(-mult);
			config.setStone(-mult);
			config.setFood(-mult);
			break;
		case 5:
			goodLuck = true;
		case 6:
			//config.setFood(mult);
			break;
	}

	public void upGradeMulti(){ //When house is built
		multipler += 2;
		house = true;
	}

	public void deGradeDespairMulti(){ //When fence is built

	}
}