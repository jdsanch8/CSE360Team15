import java.util.Random;

public class Dice{

	Random roller;
	private int multipler;
	private final int DICE_SIZE = 6;

	public Dice(){
		roller = new Random();
		multipler = 6;
	}

	public int rollMultiplier(){ //Returns Multiplier
		return roller.nextInt() % multipler + 1;
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
					//rollDespair(mult);
					break;
				case 4:
					//rollSkill(mult);
					break;
				case 5:
				case 6:
					//config.setFood(mult);
			break;
	}

	private void rollSkill(int mult, Game config){ //Access Game Class

	}

	public void upGradeMulti(){ //When house is built
		multipler += 2;
	}

	public void deGradeDespairMulti(){ //When fence is built

	}
}