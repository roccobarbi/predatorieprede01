package predatorieprede01;

public class Utilities {

	public Utilities() {
		// Do nothing
	}
	
	// Public methods
	
	/**
	 * Shuffles an array in place.
	 * @param array
	 */
	public static <T> void shuffle(T [] a){
		int newNumber = 0;
    	T temp;
    	for(int i = 0; i < a.length - 1; i++){
    		newNumber = i + (int) (Math.random() * (a.length - i));
    		temp = a[i];
    		a[i] = a[newNumber];
    		a[newNumber] = temp;
    	}
	}

}
