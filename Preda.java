package predatorieprede01;

public class Preda extends Organismo {
	// Private fields
	private final int originalNextOffspring; // This is a constant for each individual in the species.

	// Constructors
	public Preda() {
		this("noName", "noSpecies", 'o');
	}
	public Preda(String name){
		this(name, "noSpecies", 'o');
	}
	public Preda(String name, char representation){
		this(name, "noSpecies", representation);
	}
	public Preda(String name, String species, char representation){
		super(name, species, representation);
		this.nextOffspring = 3;
		this.originalNextOffspring = 3;
	}
	public Preda(String name, String species, char representation, int nextOffspring){
		super(name, species, representation);
		this.nextOffspring = nextOffspring;
		this.originalNextOffspring = nextOffspring;
	}
	public Preda(Preda parent){
		this(parent.getName(), parent.getSpecies(), parent.getRepresentation());
	}
	
	/**
	 * If the organism can reproduce (nextOffspring == 0 && ci sono spazi liberi), it does in an available cell.
	 * @param	grid	the 8 adjacent cells, starting from the top left clockwise, represented as chars (space = empty).
	 * @return	-1 if no offspring is born, or the direction (0 = N, 1 = E, 2 = S, 3 = W)
	 */
	public int reproduce(Organismo[] grid){
		int offspring = -1;
		int available = 0;
		int destination = 0;
		if(nextOffspring == 0){
			for(int i = 1; i < 8; i +=2){
				if(grid[i] == null) available++; // check if the cell is empty and flag it as available
			}
			// If there are available cells, chose one and spawn there
			if(available > 0){
				destination = (int)(Math.random() * available); // 0, 1, 2 or 3
				for(int i = 1; i < 8 && destination >= 0; i += 2){ 
					if(destination == 0) offspring = i;
					if(grid[i] == null) destination--;
				}
			}
			nextOffspring = originalNextOffspring;
		} else {
			nextOffspring--;
		}
		return offspring;
	};

}
