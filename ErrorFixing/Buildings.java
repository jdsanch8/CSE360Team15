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
	 */
	public boolean buildFarm(int stone, int wood, int food){

		// Checks if it is already built
		if(houseBuilt && fenceBuilt && wellBuilt){

			// Checks if the necessary resources are available for construction
			if(stone >= 3 && wood >= 3 && food >= 3){
				farm = true;
			}
		}
		return farm;
	}

	/** Returns the house variable */
	public boolean getHouse(){
		return house;
	}

	/** Returns the fence variable */
	public boolean getFence(){
		return fence;
	}

	/** Returns the well variable */
	public boolean getWell(){
		return well;
	}

	/** Returns the mill variable */
	public boolean getMill(){
		return mill;
	}

	/** Returns the mine variable */
	public boolean getMine(){
		return mine;
	}

	/** Returns the farm variable */
	public boolean getFarm(){
		return farm;
	}

}
