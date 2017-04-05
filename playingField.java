package predatorieprede01;

public class playingField {
	// Static fields
	private static final int initialPredators = 8;
	private static final int initialPreys = 30;
	
	// Private fiels
	private Organismo [] grid;
	private Preda [] preys;
	private Predatore [] predators;

	// Accessors
	// TODO
	
	// Constructors
	public playingField() {
		// TODO Auto-generated constructor stub
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
