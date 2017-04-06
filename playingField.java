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
		initialPredators = 5;
		initialPreys = 100;
		width = 20;
		height = 20;
	}
	public playingField(int initialPreys, int initialPredators){
		this.initialPredators = initialPredators;
		this.initialPreys = initialPreys;
		this.width = 20;
		this.height = 20;
	}
	public playingField(int initialPreys, int initialPredators, int height, int width){
		this.initialPredators = initialPredators;
		this.initialPreys = initialPreys;
		this.height = height;
		this.width = width;
	}
	
	// Private methods
	
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
