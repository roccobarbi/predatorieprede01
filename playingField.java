package predatorieprede01;

public class playingField {
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
	public playingField() {
		this(5, 100);
	}
	public playingField(int initialPreys, int initialPredators){
		this(initialPreys, initialPredators, 20, 20);
	}
	public playingField(int initialPreys, int initialPredators, int height, int width){
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
		int predatori = initialPredators, prede = initialPreys, loop = 0;
		for(int i = 0; i < grid.length; i++){ // First, basic zeroing of the grid
			grid[i] = null;
		}
		while(predatori > 0 && prede > 0){ // I try until I finish predators and play
			for(int i = 0; i < grid.length; i++){
				if (predatori > 0 && (grid.length % initialPredators) == (0 + loop) && grid[i] == null){
					grid[i] = new Predatore();
					predatori--;
				} else if (prede > 0 && (grid.length % initialPreys) == (0 + loop) && grid[i] == null) {
					grid[i] = new Preda();
					prede--;
				}
			}
		}
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
	
	// Public methods
	
	/**
	 * Manages a turn: movements, spawning and death.
	 * @return	0 if there are still predators and preys, -1 if all animals are extinct, 1 if only preys remained 
	 */
	public int nextTurn(){
		int result = 0;
		// TODO: manage a turn from all points of view
		return result;
	}

}
