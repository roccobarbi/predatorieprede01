package predatorieprede01;

public class PlayingField {
	// Static fields
	private final int initialPredators;
	private final int initialPreys;
	private final int height;
	private final int width;
	
	// Private fiels
	private Organismo [] grid;

	// Accessors
	// TODO
	
	// Constructors
	public PlayingField() {
		this(100, 5);
	}
	public PlayingField(int initialPreys, int initialPredators){
		this(initialPreys, initialPredators, 20, 20);
	}
	public PlayingField(int initialPreys, int initialPredators, int height, int width){
		this.initialPredators = initialPredators;
		this.initialPreys = initialPreys;
		this.height = height;
		this.width = width;
		grid = new Organismo[height * width];
		this.setField();
	}
	
	// Private methods
	
	/**
	 * sets up the field or resets it from scratch.
	 */
	private void setField(){
		int predatori = initialPredators, prede = initialPreys;
		for(int i = 0; i < grid.length; i++){ // First, basic zeroing of the grid
			grid[i] = null;
		}
		// TODO: enter predators and preys in a simple, linear fashion
		for(int i = 0; i < grid.length; i++){
			if (predatori > 0 && grid[i] == null){
				grid[i] = new Predatore();
				predatori--;
			} else if (prede > 0 && grid[i] == null) {
				grid[i] = new Preda();
				prede--;
			}
		}
		// Shuffle predators and preys
		Utilities.shuffle(grid);
	}
	
	/**
	 * Cleanly removes dead animals from the playing field.
	 * It works for both predators (who starve) and preys (who are eaten).
	 * @param	name	The name of the elemnt that has died
	 */
	private void removeDead(String name){
		// TODO: removes the dead from the grid and the type-specific array
	}
	
	/**
	 * Cleanly removes dead animals from the playing field.
	 * It works for both predators (who starve) and preys (who are eaten).
	 * @param	fieldIndex	The index of the dead animal in the playing field
	 * @param	speciesIndex	The index of the dead animal in the species-specific array
	 */
	private void removeDead(int fieldIndex, int speciesIndex){
		// TODO: removes the dead from the grid and the type-specific array
	}
	
	/**
	 * Manage an animal
	 */
	private void manageAnimal(int fieldIndex, int speciesIndex){
		// TODO: move, check if anyone died as a result, manage the dead, spawn if needed
	}
	
	/**
	 * Returns a grid that can be used by Organisms to look around.
	 * @param	position	The index of the position around which it should look.
	 * @return	an array of 8 Organismo objects (or null) around a position.
	 */
	private Organismo [] lookAround(int position){
		Organismo around[] = new Organismo[8];
		Predatore filler = new Predatore();
		// TODO: improve and optimise
		// Populate the upper row
		if(position < width){
			for(int k = 0; k < 3; k++) around[k] = filler;
		} else {
			if(position % width == 0){
				around[0] = filler;
				around[1] = grid[position - width];
				around[2] = grid[position - width + 1];
			} else if((position + 1) % width == 0){
				around[0] = grid[position - width - 1];
				around[1] = grid[position - width];
				around[2] = filler;
			} else{
				for(int k = 0; k < 3; k++) around[k] = grid[position - width - 1 + k];
			}
		}
		// Populate the mid section
		if(position % width == 0){
			around[3] = grid[position + 1];
			around[7] = filler;
		} else if((position + 1) % width == 0){
			around[3] = filler;
			around[7] = grid[position - 1];
		} else{
			around[3] = grid[position + 1];
			around[7] = grid[position - 1];
		}
		// Populate the lower row
		if(position > (width * (height - 1) - 1)){
			for(int k = 4; k < 7; k++) around[k] = filler;
		} else {
			if(position % width == 0){
				around[3] = filler;
				around[4] = grid[position + width];
				around[5] = grid[position + width + 1];
			} else if((position + 1) % width == 0){
				around[3] = grid[position + width - 1];
				around[5] = grid[position + width];
				around[5] = filler;
			} else{
				for(int k = 0; k < 3; k++) around[k] = grid[position + width - 1 + k];
			}
		}
		return around;
	}
	
	// Public methods
	
	/**
	 * Manages a turn: movements, spawning and death.
	 * @return	0 if there are still predators and preys, -1 if all animals are extinct, 1 if only preys remained 
	 */
	public int nextTurn(){
		int result = 0;
		Organismo around[];
		// TODO: manage a turn from all points of view
		// Loop through the grid looking for predators
		for(int i = 0; i < grid.length; i++){
			if(grid[i] instanceof Predatore){
				around = lookAround(i);
				grid[i].move(around);
				grid[i].reproduce(around);
			}
		}
		// Loop through the grid looking for preys
		for(int i = 0; i < grid.length; i++){
			if(grid[i] instanceof Preda){
				around = lookAround(i);
				grid[i].move(around);
				grid[i].reproduce(around);
			}
		}
		return result;
	}
	
	/**
	 * prints the grid to the user's screen
	 */
	public void print(){
		for(int i = 0; i < grid.length; i++){
			if(grid[i] == null){
				System.out.print(' ');
			} else {
				grid[i].print();
			}
			if((i + 1) % width == 0){
				System.out.println();
			}
		}
	}

}
