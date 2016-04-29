/** Allows buildings to be constructed given set circumstances, and tracks which buildings are built
 * @author Team 15
 * @version April 11, 2016 *
 */

public class Buildings {

	private boolean house;
	private boolean fence;
	private boolean well;
	private boolean mill;
	private boolean mine;
	private boolean farm;

	private boolean houseBuilt;
	private boolean fenceBuilt;
	private boolean wellBuilt;
	private boolean millBuilt;
	private boolean mineBuilt;

	public Buildings(){

		// Sets the variables to start as false
		house = false;
		fence = false;
		well = false;
		mill = false;
		mine = false;
		farm = false;

		houseBuilt = false;
		fenceBuilt = false;
		wellBuilt = false;
		millBuilt = false;
		mineBuilt = false;
	}

	/** Sets house variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 *  @return boolean depending on if the house was built or not
	 */
	public boolean buildHouse(int stone, int wood){

		// Checks if it is already built
		boolean built = false;
		if(houseBuilt){
			built = false;
		}
		else{
			// Checks if the necessary resources are available for construction
			if(stone >= 5 && wood >= 5){
				house = true;
				houseBuilt = true;
			}
			built = house;
		}
		return built;
	}

	/** Sets fence variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 *  @return boolean depending on if the fence was built or not
	 */
	public boolean buildFence(int stone, int wood){

		// Checks if it is already built
		boolean built = false;
		if(fenceBuilt){
			built = false;
		}
		else{

			// Checks if the necessary resources are available for construction
			if(stone >= 2 && wood >= 5){
				fence = true;
				fenceBuilt = true;
			}
			built = fence;
		}
		return built;
	}

	/** Sets well variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 *  @return boolean depending on if the well was built or not
	 */
	public boolean buildWell(int stone, int wood){

		// Checks if it is already built
		boolean built = false;
		if(wellBuilt){
			built = false;
		}
		else{
			// Checks if the necessary resources are available for construction
			if(stone >= 5 && wood >= 2){
				well = true;
				wellBuilt = true;
			}
			built = well;
		}
		return built;
	}

	/** Sets mill variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 *  @return boolean depending on if the mill was built or not
	 */
	public boolean buildMill(int stone){

		// Checks if it is already built
		boolean built = false;
		if(millBuilt){
			built = false;
		}
		else{
			// Checks if the necessary resources are available for construction
			if(stone >= 5){
				mill = true;
				millBuilt = true;
			}
			built = mill;
		}
		return built;
	}

	/** Sets mine variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 *  @return boolean depending on if the mine was built or not
	 */
	public boolean buildMine(int wood){

		// Checks if it is already built
		boolean built = false;
		if(mineBuilt){
			built = false;
		}
		else{
			// Checks if the necessary resources are available for construction
			if(wood >= 5){
				mine = true;
				mineBuilt = true;
			}
			built = mine;
		}
		return built;
	}

	/** Sets farm variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 *  @param food		integer resource checked
	 *  @return boolean depending on if the farm was built or not
	 */
	public boolean buildFarm(int stone, int wood, int food){

		// Checks if required buildings are already built
		if(houseBuilt && fenceBuilt && wellBuilt){

			// Checks if the necessary resources are available for construction
			if(stone >= 3 && wood >= 3 && food >= 3){
				farm = true;
			}
		}
		return farm;
	}

	/**
	 * Getter method for the completion status of the house
	 * @return boolean depending on the value of house
	 */
	public boolean getHouse(){
		return house;
	}

	/**
	 * Getter method for the completion status of the fence
	 * @return boolean depending on the value of fence
	 */
	public boolean getFence(){
		return fence;
	}

	/**
	 * Getter method for the completion status of the well
	 * @return boolean depending on the value of well
	 */
	public boolean getWell(){
		return well;
	}

	/**
	 * Getter method for the completion status of the mill
	 * @return boolean depending on the value of mill
	 */
	public boolean getMill(){
		return mill;
	}

	/**
	 * Getter method for the completion status of the mine
	 * @return boolean depending on the value of mine
	 */
	public boolean getMine(){
		return mine;
	}

	/**
	 * Getter method for the completion status of the farm
	 * @return boolean depending on the value of farm
	 */
	public boolean getFarm(){
		return farm;
	}

}