package predatorieprede01;

public class Predatore extends Organismo {
	// Private fields
	private final int originalNextOffspring; // This is a constant for each individual in the species.
	private int daysUntilStarve;
	private final int originalDaysUntilStarve; // This is a constant for each individual in the species.
	private boolean isAlive;
	
	// Accessors
	/**
	 * @return true if alive, false if not
	 */
	public boolean getIsAlive() {
		return isAlive;
	}
	/**
	 * Kills the predator, otherwise it ignores any request to revive it.
	 * @param life true is alive, false if dead
	 */
	public void setName(boolean isAlive) {
		if (!isAlive) this.isAlive = false;
	}
	
	// Constructors

	public Predatore() {
		this("noName", "noSpecies", 'X');
	}

	public Predatore(String name) {
		this(name, "noSpecies", 'X');
	}

	public Predatore(String name, char representation) {
		this(name, "noSpecies", representation);
	}

	public Predatore(String name, String species, char representation) {
		super(name, species, representation);
		this.nextOffspring = 8;
		this.originalNextOffspring = 8;
		this.daysUntilStarve = 3;
		this.originalDaysUntilStarve = 3;
		this.isAlive = true;
	}
	
	public Predatore(String name, String species, int daysUntilStarve, char representation) {
		super(name, species, representation);
		this.daysUntilStarve = daysUntilStarve;
		this.originalDaysUntilStarve = daysUntilStarve;
		this.nextOffspring = 8;
		this.originalNextOffspring = 8;
		this.isAlive = true;
	}
	
	public Predatore(String name, String species, int daysUntilStarve, char representation, int nextOffspring){
		super(name, species, representation);
		this.nextOffspring = nextOffspring;
		this.originalNextOffspring = nextOffspring;
		this.daysUntilStarve = daysUntilStarve;
		this.originalDaysUntilStarve = daysUntilStarve;
		this.isAlive = true;
	}
	
	// Private methods
	/**
	 * It resets the days before starvation.
	 * @param	move	the direction where the beast moves to hunt
	 * @return	the direction where the beast moved to hund
	 */
	private int hunt(int move){
		daysUntilStarve = originalDaysUntilStarve;
		return move;
	}

	// Public methods
	/**
	 * If the organism can reproduce (nextOffspring == 0 && ci sono spazi liberi), it does in an available cell.
	 * @param	grid	the 8 adjacent cells, starting from the top left clockwise, represented as chars (space = empty).
	 * @return	-1 if no offspring is born, or the direction (0 = N, 1 = E, 2 = S, 3 = W)
	 */
	public int reproduce(Organismo[] grid){
		int offspring = -1;
		int available = -1;
		int destination = -1;
		if(nextOffspring == 0){
			for(int i = 1; i < 8; i +=2){
				if(grid[i] == null) available++; // check if the cell is empty and flag it as available
			}
			// If there are available cells, chose one and spawn there
			if(available > 0){
				destination = (int)(Math.random() * available); // 0, 1, 2 or 3
				for(int i = 1; i < 8 && destination >= 0; i += 2){ 
					offspring++;
					if(grid[i] == null) destination--;
				}
			}
			nextOffspring = originalNextOffspring;
		} else {
			nextOffspring--;
		}
		return offspring;
	};
	
	/**
	 * The predator is always looking for food and it wants to move.
	 * If there is a prey inside an adjacent cell, it moves there.
	 * Otherwise it's a naive predator: it moves in a random direction chosen from the available ones.
	 * @param	grid	the 8 adjacent cells, starting from the top left clockwise, represented as chars (space = empty).
	 * @return	-1 if no move is made, -10 if the predator is dead, or the direction (0 = N, 1 = E, 2 = S, 3 = W)
	 */
	public int move(Organismo[] grid){
		int available = 0;
		int destination = 0;
		int move = -10; // Default: the beast is dead and should be removed or managed
		if(isAlive){
			move = -1; // New default: no move.
			// Odd cells in the grid are those where the predator can move
			for(int i = 1; i < 8; i += 2){ 
				if(grid[i] == null) available++;
				if(grid[i] instanceof Preda) return hunt(i); // Prey found, let's go for the kill!
			}
			// If there are available cells, chose one and move there
			if(available > 0){
				destination = (int)(Math.random() * available); // 0, 1, 2 or 3
				for(int i = 1; i < 8 && destination >= 0; i += 2){ 
					move++;
					if(grid[i] == null) destination--;
				}
			}
		}
		return move;
	};

}
