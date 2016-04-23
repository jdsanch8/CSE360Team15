
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

	/**
	 * Acts as the main menu, with various options including play now, view stats, and see help
	 */
	public int gameController(){
		int continuePlaying = 0;
		System.out.println("---------------------------");
		System.out.println("Mayor's Town");
		startScreen();
		int menuChoice = getMenuChoice();

		while (menuChoice != 1 && menuChoice != 2 && menuChoice != 3 && menuChoice != 0){
			System.out.println("*** Invalid menu choice! Please enter 1, 2, 3, or 0 ***");
			startScreen();
			menuChoice = getMenuChoice();
		}

		switch(menuChoice){
		case 1:
			continuePlaying = 1;
			startGame();
			break;
		case 2:
			gameStats.printFile();
			gameController();
			break;
		case 3:
		//	helpScreen();
			gameController();
			break;
		case 0:
			System.out.println("Exiting game. Goodbye.");
			continuePlaying = 0;
			break;
		default:
			break;
		}

		return continuePlaying;
	}

	/**
	 * Prints out menu explaining options
	 */
	private void startScreen(){
		System.out.println("----------------------------");
		System.out.println("Hello, " + getName() + ", please select an option(Enter digit):");
		System.out.println("1) Start Game");
		System.out.println("2) View Stats");
		System.out.println("3) Help");
		System.out.println("0) Exit Game");
	}

	/**
	 * Reads in input until a valid response is received
	 * @return integer containing user choice
	 */
	private static int getMenuChoice()
	{
		System.out.print("---> ");

		while(! in.hasNextInt() )
		{
			in.nextLine();
			System.out.print("---> ");
		}

		int menuChoice = in.nextInt();
		return menuChoice;
	}

	/**
	 * Calls methods that begin the game
	 */
	private void startGame(){
		setupEnvironment();
		inGameOptions();
	}

	/**
	 * Contains a list of choices the player can make during the course of the game
	 */
	private void inGameOptions(){
		displayCurrentGameStats();
		displayInGameOptions();
		int mult;

		int menuChoice = getMenuChoice();

		while (menuChoice != 1 && menuChoice != 2 && menuChoice != 3 && menuChoice != 0){
			System.out.println("*** Invalid menu choice! Please enter 1, 2, 3, or 0 ***");
			displayInGameOptions();
			menuChoice = getMenuChoice();
		}

		switch(menuChoice){
		case 1:
			mult = dieClass.rollMultiplier();

			if(myBuildings.getMill()){
				dieClass.rollWood(mult, this);
			}

			if(myBuildings.getMine()){
				dieClass.rollStone(mult, this);
			}

			dieClass.rollBase(mult, this);
			setDays(getDays() + 1);
			updateFood(foodDec);

			if(getFood() > 0){
				inGameOptions();
			}

			else{
				System.out.println("You lose due to a lack of food!");
				victory = 0;
				updateRecord();
				gameStats.writeToFile();
				statisticsList = gameStats.makeArrayList();
				gameStats.writeListToFile(statisticsList);
			}

			break;

		case 2:
		//	printBuildings();
			int choice = getMenuChoice();
		//	build(choice);
			if(myBuildings.getFarm()){
				System.out.println("You win!");
				victory = 1;
				updateRecord();
				gameStats.writeToFile();
				statisticsList = gameStats.makeArrayList();
				gameStats.writeListToFile(statisticsList);
			}
			else{
				inGameOptions();
			}
			break;

		case 3:
			displayInGameHelp();
			inGameOptions();
			break;

		case 0:
			break;

		default:
			break;
		}
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


	public void rollDice(){
		int mult = dieClass.rollMultiplier();

		if(myBuildings.getMill()){
			dieClass.rollWood(mult, this);
		}

		if(myBuildings.getMine()){
			dieClass.rollStone(mult, this);
		}

		dieClass.rollBase(mult, this);
		setDays(getDays() + 1);
		updateFood(foodDec);
	}

	/**
	 * Prints the menu for the player containing their options
	 */
	private void displayInGameOptions(){
		System.out.println("----------------------------");
		System.out.println("1) Let's Rock & Roll");
		System.out.println("2) Build");
		System.out.println("3) Help");
		System.out.println("0) Quit Current Game");
	}

	/**
	 * Allows the player to choose their inital starting conditions, granting them a boon
	 */
	private void setupEnvironment(){
		System.out.println("Select your environment.\nForest will provide you with 5 wood to start and Mountains will provide you with 5 stone to start.\nWhat will it be?(1 = Forest, 2 = Mountains)");
		int menuChoice = getMenuChoice();
		while (menuChoice != 1 && menuChoice != 2){
			System.out.println("*** Invalid menu choice! Please enter 1 or 2 ***");
			menuChoice = getMenuChoice();
		}
		if (menuChoice == 1){
			setWood(5);
			setEnvironment(1);
		}
		else{
			setStone(5);
			setEnvironment(2);
		}
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
 */
	/**
	 * New Line
	 */
	private void displayInGameHelp(){
		System.out.println("");
	}

	/**
	 * Prints a list of unbuilt buildings, and the cost to build them

	private void printBuildings(){
		if(!myBuildings.getMine()){
			System.out.println("1. Mine. Cost: 5 Wood, 0 Stone");
		}
		if(!myBuildings.getMill()){
			System.out.println("2. Mill. Cost: 0 Wood, 5 Stone");
		}
		if(!myBuildings.getHouse()){
			System.out.println("3. House. Cost: 5 Wood, 5 Stone");

		}
		if(!myBuildings.getFence()){
			System.out.println("4. Fence. Cost: 5 Wood, 2 Stone");
		}
		if(!myBuildings.getWell()){
			System.out.println("5. Well. Cost: 2 Wood, 5 Stone");
		}
		if(myBuildings.getHouse() && myBuildings.getFence() && myBuildings.getWell()){
			System.out.println("6. Farm. Cost: 3 Wood, 3 Stone, 3 Food");
		}
	}*/

	/**
	 * Builds a building depending on the users choice
	 * @param choice number corresponding with the building they want, given to them by print buildings
	 */

	public void buildMine(){
		if(!myBuildings.getMine()){
			if(myBuildings.buildMine(wood))	{
				wood -= 5;
				builtBuildings[buildingCount] = "Mine";
				buildingCount++;
			}
		}
	}

	public void buildMill(){
		if(!myBuildings.getMill()){
			if(myBuildings.buildMill(stone)){
				stone -= 5;
				builtBuildings[buildingCount] = "Mill";
				buildingCount++;
			}
		}
	}

	public void buildHouse(){
		if(!myBuildings.getHouse()){
			if(myBuildings.buildHouse(stone, wood)){
				stone -= 5;
				wood -= 5;
				dieClass.upGradeMulti();
				builtBuildings[buildingCount] = "House";
				buildingCount++;
			}
		}
	}

	public void buildFence(){
		if(!myBuildings.getFence()){
			if(myBuildings.buildFence(stone, wood)){
				stone -= 2;
				wood -= 5;
				dieClass.deGradeDespairMulti();
				builtBuildings[buildingCount] = "Fence";
				buildingCount++;
			}
		}
	}

	public void buildWell(){
		if(!myBuildings.getWell()){
			if(myBuildings.buildWell(stone, wood)){
				stone -= 5;
				wood -= 2;
				builtBuildings[buildingCount] = "Well";
				buildingCount++;
				foodDec = -2;
			}
		}
	}

	public void buildFarm(){
		if(myBuildings.getHouse() && myBuildings.getFence() && myBuildings.getWell()){
			if(myBuildings.buildFarm(stone, wood, food)) {
				stone -= 3;
				wood -= 3;
				food -= 3;
				builtBuildings[buildingCount] = "Farm";
				buildingCount++;
			}
		}
	}

	private void updateRecord(){
		gameStats.setVictory(victory);
		gameStats.setDays(days);
		gameStats.setBuildings(buildingCount);
		gameStats.setResources(wood + stone + food);
	}

	/**
	 * Displays their current resources, days, and buildings
	 */
	private void displayCurrentGameStats(){
		System.out.println("Name: " + playerName);
		System.out.println("Days: " + days);
		System.out.println("Food: " + food + "\t Wood: " + wood + "\t Stone: " + stone);
		System.out.println("Built Buildings:");
		for (int loop = 0; loop < buildingCount; loop++){
			System.out.println(builtBuildings[loop]);
		}
		System.out.println();
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