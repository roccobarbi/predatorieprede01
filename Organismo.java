package predatorieprede01;

public abstract class Organismo {
	// Private fields
	private String name;
	private String species;
	private int age;
	private int nextOffspring;

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
	
	// Public methods
	/**
	 * If the organism wants to move (50% of the time), it moves in a random direction chosen from the available ones.
	 * @param	grid	the 8 adjacent cells, starting from the top left clockwise, represented as chars (space = empty).
	 * @return	-1 if no move is made, or the direction (0 = N, 1 = E, 2 = S, 3 = W)
	 */
	public int move(char[] grid){
		boolean wantsToMove = Math.random() < 0.5;
		int available = 0;
		int destination = 0;
		int move = -1;
		if(wantsToMove){
			// Odd cells in the grid are those where the organism can move
			for(int i = 1; i < 8; i += 2){ 
				if(grid[i] == ' ') available++;
			}
			// If there are available cells, chose one and move there
			if(available > 0){
				destination = (int)(Math.random() * available); // 0, 1, 2 or 3
				for(int i = 1; i < 8 && destination >= 0; i += 2){ 
					move++;
					if(grid[i] == ' ') destination--;
				}
			}
		}
		return move;
	};
	
	// Abstract methods
	public abstract void reproduce();
}
