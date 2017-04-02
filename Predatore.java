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
	 * The organism is always looking for food and it wants to move.
	 * If there is a prey inside an adjacent cell, it moves there.
	 * Otherwise, if there is a pray in an angle cell, it moves to the nearest movable cell.
	 * Otherwise, it moves in a random direction chosen from the available ones.
	 * @param	grid	the 8 adjacent cells, starting from the top left clockwise, represented as chars (space = empty).
	 * @return	-1 if no move is made, -10 if the predator is dead, or the direction (0 = N, 1 = E, 2 = S, 3 = W)
	 */
	public int move(Organismo[] grid){
		boolean wantsToMove = Math.random() < 0.5;
		int available = 0;
		int destination = 0;
		int move = -1;
		if(wantsToMove){
			// Odd cells in the grid are those where the organism can move
			for(int i = 1; i < 8; i += 2){ 
				if(grid[i] == null) available++;
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
