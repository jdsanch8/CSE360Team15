/** Allows buildings to be constructed given set circumstances, and tracks which buildings are built
 * @author 
 * @version April 11, 2016
 * 
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
		if(!houseBuilt){
			
			// Checks if the necessary resources are available for construction
			if(stone >= 5 && wood >= 5){
				house = true;
			}
		}
		return house;
	}

	/** Sets fence variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 */
	public boolean buildFence(int stone, int wood){
		
		// Checks if it is already built
		if(!fenceBuilt){
			
			// Checks if the necessary resources are available for construction
			if(stone >= 2 && wood >= 5){
				fence = true;
			}
		}
		return house;
	}
	
	/** Sets well variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 */
	public boolean buildWell(int stone, int wood){
		
		// Checks if it is already built
		if(!wellBuilt){
			
			// Checks if the necessary resources are available for construction
			if(stone >= 5 && wood >= 2){
				well = true;
			}
		}
		return well;
	}
	
	/** Sets mill variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 */
	public boolean buildMill(int stone, int wood){
		
		// Checks if it is already built
		if(!millBuilt){
			
			// Checks if the necessary resources are available for construction
			if(stone >= 5){
				mill = true;
			}
		}
			return mill;		
	}
	
	/** Sets mine variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 */
	public boolean buildMine(int stone, int wood){
		
		// Checks if it is already built
		if(!mineBuilt){
			
			// Checks if the necessary resources are available for construction
			if(wood >= 5){
				mine = true;
			}
		}
		return mine;
	}
	
	/** Sets farm variable to true if the requirements are met
	 *  @param stone	integer resource checked
	 *  @param wood		integer resource checked
	 *  @param food		integer resource checked
	 */
	public boolean buildfarm(int stone, int wood, int food){
		
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