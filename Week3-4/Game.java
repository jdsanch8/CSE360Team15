//package gui;
//import java.util.Scanner;
import java.util.ArrayList;

/**
 * Game manager that interfaces all the gameplay functions.
 * Team 15
 */
public class Game{
	//private static Scanner in = new Scanner(System.in);
	private String playerName;
	private int victory;
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

	/**
	 * Rolls the multiplier die
	 * @return the value rolled
	 */
	public int rollMult(){
		return dieClass.rollMultiplier();
	}

	/**
	 * Rolls the mill die
	 * @param mult the value that the result of the mill die will be multiplied by
	 * @return string with the outcome of rolling the mill die
	 */
	public String rollMill(int mult){
		String out = "";
		if(myBuildings.getMill()){
			out = dieClass.rollWood(mult, this);
		}
		return out;
	}

	/**
	 * Rolls the mine die
	 * @param mult the value that the result of the mine die will be multiplied by
	 * @return string with the outcome of rolling the mine die
	 */
	public String rollMine(int mult){
		String out = "";
		if(myBuildings.getMine()){
			out = dieClass.rollStone(mult, this);
		}
		return out;
	}

	/**
	 * Rolls the event die
	 * @param mult the value that the result of the mine die will be multiplied by
	 * @return string with the outcome of rolling the mine die
	 */
	public String rollEvent(int mult){
		String out = "";
		out = dieClass.rollBase(mult, this);
		setDays(getDays() + 1);
		updateFood(foodDec);
		return out;
	}

	/**
	 * Builds a Mine
	 * @return true or false depending on if the mine was built or not
	 */
	public boolean buildMine(){
		boolean built = false;
		if(!myBuildings.getMine()){
			if(myBuildings.buildMine(wood))	{
				wood -= 5;
				builtBuildings[buildingCount] = "Mine";
				buildingCount++;
				built = true;
			}
		}
		return built;
	}

	/**
	 * Builds a Mill
	 * @return true or false depending on if the mill was built or not
	 */
	public boolean buildMill(){
		boolean built = false;
		if(!myBuildings.getMill()){
			if(myBuildings.buildMill(stone)){
				stone -= 5;
				builtBuildings[buildingCount] = "Mill";
				buildingCount++;
				built = true;
			}
		}
		return built;
	}

	/**
	 * Builds a House
	 * @return true or false depending on if the house was built or not
	 */
	public boolean buildHouse(){
		boolean built = false;
		if(!myBuildings.getHouse()){
			if(myBuildings.buildHouse(stone, wood)){
				stone -= 5;
				wood -= 5;
				dieClass.upGradeMulti();
				builtBuildings[buildingCount] = "House";
				buildingCount++;
				built = true;
			}
		}
		return built;
	}

	/**
	 * Builds a Fence
	 * @return true or false depending on if the fence was built or not
	 */
	public boolean buildFence(){
		boolean built = false;
		if(!myBuildings.getFence()){
			if(myBuildings.buildFence(stone, wood)){
				stone -= 2;
				wood -= 5;
				dieClass.deGradeDespairMulti();
				builtBuildings[buildingCount] = "Fence";
				buildingCount++;
				built = true;
			}
		}
		return built;
	}

	/**
	 * Builds a Well
	 * @return true or false depending on if the well was built or not
	 */
	public boolean buildWell(){
		boolean built = false;
		if(!myBuildings.getWell()){
			if(myBuildings.buildWell(stone, wood)){
				stone -= 5;
				wood -= 2;
				builtBuildings[buildingCount] = "Well";
				buildingCount++;
				foodDec = -2;
				built = true;
			}
		}
		return built;
	}
	
	/**
	 * Prints the completion status of the required buildings to build a farm
	 * @return a string containing the buildings that still need to be built
	 */
	public String requiredBuildingsStatus(){
		String unbuiltBuildings = "";
		if (!myBuildings.getWell()){
			unbuiltBuildings += "Well ";
		}
		if (!myBuildings.getFence()){
			unbuiltBuildings += "Fence ";
		}
		if (!myBuildings.getHouse()){
			unbuiltBuildings += "House ";
		}
		return unbuiltBuildings;
	}

	/**
	 * Records the results of the current game before its terminated
	 */
	public void endGame(){
		updateRecord();
		gameStats.writeToFile();
		statisticsList = gameStats.makeArrayList();
		gameStats.writeListToFile(statisticsList);
	}

	/**
	 * Builds a Farm
	 * @return true or false depending on if the farm was built or not
	 */
	public boolean buildFarm(){
		boolean built = false;
		if(myBuildings.getHouse() && myBuildings.getFence() && myBuildings.getWell()){
			if(myBuildings.buildFarm(stone, wood, food)) {
				stone -= 3;
				wood -= 3;
				food -= 3;
				builtBuildings[buildingCount] = "Farm";
				buildingCount++;
				victory = 1;
				endGame();
				built = true;
			}
		}
		return built;
	}

	/**
	 * Sends the final results of the game to that Statistics object to be stored permanently
	 */
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

	/**
	 * Updates the player's stone resources
	 * @param stoneIn the value to update the stone resources by
	 */
	public void updateStone(int stoneIn){
		stone = stone + stoneIn;
		if (stone < 0){
			stone = 0;
		}
	}

	/**
	 * Updates the player's wood resources
	 * @param stoneIn the value to update the wood resources by
	 */
	public void updateWood(int woodIn){
		wood = wood + woodIn;
		if (wood < 0){
			wood = 0;
		}
	}

	/**
	 * Updates the player's food resources
	 * @param stoneIn the value to update the food resources by
	 */
	public void updateFood(int foodIn){
		food = food + foodIn;
		if (food < 0){
			food = 0;
		}
	}

	/**
	 * Provides a die for JUnit testing
	 * @return a Dice object
	 */
	public Dice getDice(){
		return dieClass;
	}
}