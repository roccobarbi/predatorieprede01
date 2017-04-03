package predatorieprede01;

import static org.junit.Assert.*;

import org.junit.Test;

public class PredaTest {
	Organismo [] grid = new Organismo[8];
	
	@Test
	public void testReproduce001() {
		Preda preda1 = new Preda("preda1", "specie1", 'o', 0);
		for(int i = 0; i < 8; i++) grid[i] = null;
		int spawn = preda1.reproduce(grid);
		System.out.println("Spawn result = " + spawn);
		assertTrue("Preda didn't spawn even if the whole grid was null!", spawn > -1);
		assertTrue("Preda spawned in an invalid direction", spawn == 1 || spawn == 3 || spawn == 5 || spawn == 7);
	}
	
	@Test
	public void testReproduce002() {
		Preda preda2 = new Preda("preda2", "specie2", 'o', 0);
		for(int i = 0; i < 8; i++) grid[i] = null;
		int spawn = preda2.reproduce(grid);
		System.out.println("Spawn result = " + spawn);
		assertTrue("Preda spawned in an invalid direction", spawn == 1 || spawn == 3 || spawn == 5 || spawn == 7);
	}
	
	@Test
	public void testReproduce003() {
		Preda preda3 = new Preda("preda3", "specie3", 'o', 0);
		Preda preda4 = new Preda("preda4", "specie4", 'o', 0);
		for(int i = 0; i < 8; i++) grid[i] = preda4;
		int spawn = preda3.reproduce(grid);
		System.out.println("Spawn result = " + spawn);
		assertTrue("Preda spawned with full grid", spawn == -1);
	}
	
	@Test
	public void testReproduce004() {
		Preda preda5 = new Preda("preda5", "specie5", 'o', 0);
		Preda preda6 = new Preda("preda6", "specie6", 'o', 0);
		for(int i = 0; i < 8; i++) grid[i] = preda5;
		grid[5] = null;
		int spawn = preda6.reproduce(grid);
		System.out.println("Spawn result = " + spawn + " with slot 5 = " + (grid[5] == null ? "null" : grid[5]));
		assertTrue("Preda didn't spawn in the only available slot", spawn == 5);
	}

	@Test
	public void testMove001() {
		Preda preda1 = new Preda("preda1", "specie1", 'o', 0);
		for(int i = 0; i < 8; i++) grid[i] = null;
		int k = 0;
		int move = 0;
		while(k < 100){
			move += preda1.move(grid) > -1 ? 1 : 0;
			k++;
		}
		System.out.println("Moved " + move + " times");
		assertTrue("Preda moved less than 25% of times", move > (k / 4));
	}
	
	@Test
	public void testMove002() {
		Preda preda1 = new Preda("preda1", "specie1", 'o', 0);
		for(int i = 0; i < 8; i++) grid[i] = null;
		int k = 0;
		int move = 0;
		System.out.print("Moves: ");
		while(k < 100){
			move = preda1.move(grid);
			System.out.print(" " + move);
			assertTrue("Preda moved at invalid location", move == -1 || move == 1 || move == 3 || move == 5 || move == 7);
			k++;
		}
		System.out.println();
	}
	
	@Test
	public void testMove003() {
		Preda preda1 = new Preda("preda1", "specie1", 'o', 0);
		Preda preda2 = new Preda("preda2", "specie2", 'o', 0);
		for(int i = 0; i < 8; i++) grid[i] = preda2;
		int k = 0;
		int move = 0;
		while(k < 100){
			move = preda1.move(grid);
			assertTrue("Preda moved with full grid", move == -1);
			k++;
		}
	}
	
	@Test
	public void testMove004() {
		Preda preda1 = new Preda("preda1", "specie1", 'o', 0);
		Preda preda2 = new Preda("preda2", "specie2", 'o', 0);
		for(int i = 0; i < 8; i++) grid[i] = preda2;
		grid[5] = null;
		int move = 0, theMove = 0;
		int k = 0;
		while(k < 100){
			theMove = preda1.move(grid);
			move += theMove == 5 ? 1 : 0;
			assertTrue("Invalid move", theMove == 5 || theMove == -1);
			k++;
		}
		System.out.println("Moved " + move + " times in the available slot");
		assertTrue("Preda moved less than 25% of times in the available slot", move > (k / 4));
	}


}
