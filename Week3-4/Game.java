//package gui;
import java.util.Scanner;
import java.util.ArrayList;


public class Game{
	private static Scanner in = new Scanner(System.in);
	private String playerName;
	private int victory;
	private int environment;
	private int days;
	private int food;
	private int buildings;
	private int wood;
	private int stone;
	private Dice dieClass;
	private String[] builtBuildings;
	int buildingCount;
	int foodDec;
	private ArrayList<Stats> statisticsList;
	private Buildings myBuildings;
	private Statistics gameStats;

	/**
	 * Constructor method
	 * @param playerNameIn entered name of user
	 */
	public Game(String playerNameIn){
		setName(playerNameIn);
		setDays(0);
		setFood(45);
		setBuildings(0);
		setWood(0);
		setStone(0);
		dieClass = new Dice();
		myBuildings = new Buildings();
		gameStats = new Statistics(playerNameIn);
		builtBuildings = new String[6];
		buildingCount = 0;
		foodDec = -3;
	}


	public int rollMult(){
		return dieClass.rollMultiplier();
	}

	public String rollMill(int mult){
		String out = "";
		if(myBuildings.getMill()){
			out = dieClass.rollWood(mult, this);
		}
		return out;
	}

	public String rollMine(int mult){
		String out = "";
		if(myBuildings.getMine()){
			out = dieClass.rollStone(mult, this);
		}
		return out;
	}

	public String rollEvent(int mult){
		String out = "";
		out = dieClass.rollBase(mult, this);
		setDays(getDays() + 1);
		updateFood(foodDec);
		return out;
	}


	/**
	 * Provides an explanation on how to play the game

	private void helpScreen(){
		System.out.println("Game Objective\n\nThe objective of the game is to build a farm. In order to gain the ability to do this,\n"
				+ "you first need to build a house, a well, and a fence. You can build these structures by using your resources of,\n"
				+ "wood and stone, which are acquired through each dice roll. If you choose to build the optional structures, mill\n"
				+ "and mine, you can receive additional resources on each dice roll. The mill will provide additional wood and the\n"
				+ "mine will provide additional stone. Additionally, on each dice roll, you consume food and once you run out of food\n"
				+ "the game ends. You can limit your food losses by building a well. A fence will limit your resource losses in the\n"
				+ "event that your roll yields a disaster and a house will increase your acquired resources in the event that your roll\n"
				+ "yields food, wood or stone. Let's get building!");
	}



	/**
	 * Builds a building depending on the users choice
	 * @param choice number corresponding with the building they want, given to them by print buildings
	 */

	public boolean buildMine(){
		if(!myBuildings.getMine()){
			if(myBuildings.buildMine(wood))	{
				wood -= 5;
				builtBuildings[buildingCount] = "Mine";
				buildingCount++;
				return true;
			}
		}
		return false;
	}

	public boolean buildMill(){
		if(!myBuildings.getMill()){
			if(myBuildings.buildMill(stone)){
				stone -= 5;
				builtBuildings[buildingCount] = "Mill";
				buildingCount++;
				return true;
			}
		}
		return false;
	}

	public boolean buildHouse(){
		if(!myBuildings.getHouse()){
			if(myBuildings.buildHouse(stone, wood)){
				stone -= 5;
				wood -= 5;
				dieClass.upGradeMulti();
				builtBuildings[buildingCount] = "House";
				buildingCount++;
				return true;
			}
		}
		return false;
	}

	public boolean buildFence(){
		if(!myBuildings.getFence()){
			if(myBuildings.buildFence(stone, wood)){
				stone -= 2;
				wood -= 5;
				dieClass.deGradeDespairMulti();
				builtBuildings[buildingCount] = "Fence";
				buildingCount++;
				return true;
			}
		}
		return false;
	}

	public boolean buildWell(){
		if(!myBuildings.getWell()){
			if(myBuildings.buildWell(stone, wood)){
				stone -= 5;
				wood -= 2;
				builtBuildings[buildingCount] = "Well";
				buildingCount++;
				foodDec = -2;
				return true;
			}
		}
		return false;
	}

	public boolean buildFarm(){
		if(myBuildings.getHouse() && myBuildings.getFence() && myBuildings.getWell()){
			if(myBuildings.buildFarm(stone, wood, food)) {
				stone -= 3;
				wood -= 3;
				food -= 3;
				builtBuildings[buildingCount] = "Farm";
				buildingCount++;
				victory = 1;
				updateRecord();
				gameStats.writeToFile();
				statisticsList = gameStats.makeArrayList();
				gameStats.writeListToFile(statisticsList);
				return true;
			}
		}
		return false;
	}

	private void updateRecord(){
		gameStats.setVictory(victory);
		gameStats.setDays(days);
		gameStats.setBuildings(buildingCount);
		gameStats.setResources(wood + stone + food);
	}

	/**
	 * Setter Method for name
	 * @param nameIn name of Player
	 */
	private void setName(String nameIn){
		playerName = nameIn;
	}

	/**
	 * Setter method for enviroment
	 * @param environmentIn chosen enviroment
	 */
	private void setEnvironment(int environmentIn){
		environment = environmentIn;
	}

	/**
	 * Setter method for days
	 * @param daysIn number of days
	 */
	public void setDays(int daysIn){
		days = daysIn;
	}

	/**
	 * Setter method for food
	 * @param foodIn number of food
	 */
	public void setFood(int foodIn){
		food = foodIn;
	}

	/**
	 * Setter method for buildings
	 * @param buildingsIn number of buildings
	 */
	public void setBuildings(int buildingsIn){
		buildings = buildingsIn;
	}

	/**
	 * Setter method for wood
	 * @param woodIn number of wood
	 */
	public void setWood(int woodIn){
		wood = woodIn;
	}

	/**
	 * Setter method for Stone
	 * @param stoneIn number of stone
	 */
	public void setStone(int stoneIn){
		stone = stoneIn;
	}

	/**
	 * Getter method for name
	 * @return User' Name
	 */
	public String getName(){
		return playerName;
	}

	/**
	 * Getter method for enviroment
	 * @return number corresponding with chosen enviroment
	 */
	public int getEnvironment(){
		return environment;
	}

	/**
	 * Getter method for days
	 * @return number of days that have passed
	 */
	public int getDays(){
		return days;
	}

	/**
	 * Getter Method for food
	 * @return amount of food
	 */
	public int getFood(){
		return food;
	}

	/**
	 * Getter method for buildings
	 * @return number of buildings
	 */
	public int getBuildings(){
		return buildings;
	}

	/**
	 * Getter method for wood
	 * @return amount of wood
	 */
	public int getWood(){
		return wood;
	}

	/**
	 * Getter method for stone
	 * @return amount of stone
	 */
	public int getStone(){
		return stone;
	}

	public void updateStone(int stoneIn){
		stone = stone + stoneIn;
		if (stone < 0){
			stone = 0;
		}
	}

	public void updateWood(int woodIn){
		wood = wood + woodIn;
		if (wood < 0){
			wood = 0;
		}
	}

	public void updateFood(int foodIn){
		food = food + foodIn;
		if (food < 0){
			food = 0;
		}
	}

	public Dice getDice(){
		return dieClass;
	}
}