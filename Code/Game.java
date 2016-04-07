import java.util.Scanner;

public class Game{
	private static Scanner in = new Scanner(System.in);
	private String playerName;
	private int environment;
	private int days;
	private int food;
	private int buildings;
	private int wood;
	private int stone;
	//private Dice eventDie = new Dice(event);
	//private Dice multiplierDie = new Dice(multiplier);
	//private Buildings myBuildings = new Buildings();
	//private Stats gameStats = new Stats();

	public Game(String playerNameIn){
		setName(playerNameIn);
		setDays(0);
		setFood(0);
		setBuildings(0);
		setWood(0);
		setStone(0);
	}

	public void gameController(){
		System.out.println("Enter Dice Game Name Here!");
		startScreen();
		int menuChoice = getMenuChoice();
		while (menuChoice != 1 && menuChoice != 2 && menuChoice != 3 && menuChoice != 0){
			System.out.println("*** Invalid menu choice! Please enter 1, 2, 3, or 0 ***");
			startScreen();
			menuChoice = getMenuChoice();
		}
		switch(menuChoice){
		case 1:
			startGame();
			gameController();
			break;
		case 2:
			//gameStats.viewStats();
			//gameController();
			break;
		case 3:
			helpScreen();
			gameController();
			break;
		case 0:
			System.out.println("Exiting game. Goodbye.");
			break;
		default:
			break;
		}
	}

	private void startScreen(){
		System.out.println("----------------------------");
		System.out.println("Hello, " + getName() + ", please select an option(Enter digit):");
		System.out.println("1) Start Game");
		System.out.println("2) View Stats");
		System.out.println("3) Help");
		System.out.println("0) Exit Game");
	}

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

	private void startGame(){
		setupEnvironment();
		inGameOptions();
	}

	private void inGameOptions(){
		displayCurrentGameStats();
		displayInGameOptions();
		int menuChoice = getMenuChoice();
		while (menuChoice != 1 && menuChoice != 2 && menuChoice != 3 && menuChoice != 0){
			System.out.println("*** Invalid menu choice! Please enter 1, 2, 3, or 0 ***");
			displayInGameOptions();
			menuChoice = getMenuChoice();
		}
		switch(menuChoice){
		case 1:
			//event(eventDie.rollDice());
			setDays(getDays() + 1);
			inGameOptions();
			break;
		case 2:
			//updateResources(myBuildings.build());
			inGameOptions();
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

	private void displayInGameOptions(){
		System.out.println("----------------------------");
		System.out.println("1) Let's Rock & Roll");
		System.out.println("2) Build");
		System.out.println("3) Help");
		System.out.println("0) Quit Current Game");
	}

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

	private void helpScreen(){
		System.out.println("Game Objective\n\nThe objective of the game is to build a farm. In order to gain the ability to do this, "
				+ "you first need to build a house, a well, and a fence. You can build these structures by using your resources of, "
				+ "wood and stone, which are acquired through each dice roll. If you choose to build the optional structures, mill "
				+ "and mine, you can receive additional resources on each dice roll. The mill will provide additional wood and the "
				+ "mine will provide additional stone. Additionally, on each dice roll, you consume food and once you run out of food "
				+ "the game ends. You can limit your food losses by building a well. A fence will limit your resource losses in the "
				+ "event that your roll yields a disaster and a house will increase your acquired resources in the event that your roll "
				+ "yields food, wood or stone. Let's get building!");
	}

	private void displayInGameHelp(){
		System.out.println("");
	}

	private void event(int eventIn){
		switch(eventIn){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 6:
			break;
		default:
			break;
		}
	}

	private void displayCurrentGameStats(){
		//System.out.println("Name: " + getName() + "\t\tDays:" + getDays() + "\t\tFarm: " + myBuildings.getStructureStatus(farm) + "\t\tHouse: " + myBuildings.getStructureStatus(house) + 
		//"\t\tWell: " + myBuildings.getStructureStatus(well) + "\t\tFence: " + myBuildings.getStructureStatus(fence) + "\t\tMill: " + myBuildings.getStructureStatus(mill) + "\t\tMine: " 
		//+ myBuildings.getStructureStatus(Mine));
	}

	private void setName(String nameIn){
		playerName = nameIn;
	}

	private void setEnvironment(int environmentIn){
		environment = environmentIn;
	}

	public void setDays(int daysIn){
		days = daysIn;
	}

	public void setFood(int foodIn){
		food = foodIn;
	}

	public void setBuildings(int buildingsIn){
		buildings = buildingsIn;
	}

	public void setWood(int woodIn){
		wood = woodIn;
	}

	public void setStone(int stoneIn){
		stone = stoneIn;
	}

	public String getName(){
		return playerName;
	}

	public int getEnvironment(){
		return environment;
	}

	public int getDays(){
		return days;
	}

	public int getFood(){
		return food;
	}

	public int getBuildings(){
		return buildings;
	}

	public int getWood(){
		return wood;
	}

	public int getStone(){
		return stone;
	}
}
