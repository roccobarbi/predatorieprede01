package predatorieprede01;

public abstract class Organismo {
	// Private fields
	private String name;
	private String species;
	private int age;
	private char representation; // a character that represents this organism on the screen
	
	// Protected fields
	protected int nextOffspring;

	// Accessors
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the character used to represent this organism on screen
	 */
	public char getRepresentation() {
		return representation;
	}
	/**
	 * @param	representation	the representation to set
	 */
	public void setRepresentation(char representation) {
		this.representation = representation;
	}
	
	// Constructors
	public Organismo(){
		this("noName", "noSpecies", 'g');
	}
	public Organismo(String name){
		this(name, "noSpecies", 'g');
	}
	public Organismo(String name, char representation){
		this(name, "noSpecies", representation);
	}
	public Organismo(String name, String species, char representation){
		this.name = name;
		this.species = species;
		this.representation = representation;
	}
	
	// Public methods
	/**
	 * If the organism wants to move (50% of the time), it moves in a random direction chosen from the available ones.
	 * @param	grid	the 8 adjacent cells, starting from the top left clockwise, represented as chars (space = empty).
	 * @return	-1 if no move is made, or the direction (0 = N, 1 = E, 2 = S, 3 = W)
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
					if(destination == 0) move = i;
					if(grid[i] == null) destination--;
				}
			}
		}
		return move;
	};
	/**
	 * It prints on screen the character that represents this organism.
	 */
	public void print(){
		System.out.print(this.getRepresentation());
	}
	
	// Abstract methods
	public abstract int reproduce(Organismo[] grid);
}
