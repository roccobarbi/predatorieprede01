package predatorieprede01;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		PlayingField gioco = new PlayingField();
		boolean keepPlaying = true;
		char selection = ' ';
		String userInput;
		
		System.out.println("Per cambiare turno premi invio.");
		System.out.println("Per terminare il gioco scrivi Exit e premi invio.");
		
		gioco.print();
		
		while(keepPlaying){
			gioco.nextTurn();
			gioco.print();
			userInput = keyboard.nextLine().toLowerCase();
			if(userInput.length() > 0 && userInput.charAt(0) == 'e') keepPlaying = false;
		}
	}

}
