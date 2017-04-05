package predatorieprede01;

import static org.junit.Assert.*;

import org.junit.Test;

public class PredatoreTest {
	Organismo [] grid = new Organismo[8];
	
	@Test
	public void testReproduce001() {
		Predatore predatore1 = new Predatore("predatore1", "specie1", 1000, 'X', 0);
		for(int i = 0; i < 8; i++) grid[i] = null;
		int spawn = predatore1.reproduce(grid);
		System.out.println("Spawn result = " + spawn);
		assertTrue("Preda didn't spawn even if the whole grid was null!", spawn > -1);
		assertTrue("Preda spawned in an invalid direction", spawn == 1 || spawn == 3 || spawn == 5 || spawn == 7);
	}

	@Test
	public void testReproduce002() {
		Predatore predatore1 = new Predatore("predatore1", "specie1", 1000, 'X', 0);
		Predatore predatore2 = new Predatore("predatore1", "specie1", 1000, 'X', 0);
		for(int i = 0; i < 8; i++) grid[i] = predatore2;
		int spawn = predatore1.reproduce(grid);
		System.out.println("Spawn result = " + spawn);
		assertTrue("Preda spawned with full grid", spawn == -1);
	}
	
	@Test
	public void testReproduce003() {
		Predatore predatore1 = new Predatore("predatore1", "specie1", 1000, 'X', 0);
		Predatore predatore2 = new Predatore("predatore1", "specie1", 1000, 'X', 0);
		for(int i = 0; i < 8; i++) grid[i] = predatore2;
		grid[5] = null;
		int spawn = predatore1.reproduce(grid);
		System.out.println("Spawn result = " + spawn + " with slot 5 = " + (grid[5] == null ? "null" : grid[5]));
		assertTrue("Preda didn't spawn in the only available slot", spawn == 5);
	}
	
	@Test
	public void testSetIsAlive() {
		Predatore predatore1 = new Predatore();
		predatore1.setIsAlive(false);
		assertFalse("Predatore should be dead, but it looks alive instead", predatore1.getIsAlive());
		predatore1.setIsAlive(true);
		assertFalse("Predatore should stay dead, but it looks like it has been revived", predatore1.getIsAlive());
	}

	@Test
	public void testMove001() {
		Predatore predatore1 = new Predatore("predatore1", "specie1", 1000, 'X', 0);
		Preda preda1 = new Preda("preda1", "specie1", 'o', 0);
		for(int i = 0; i < 8; i++) grid[i] = null;
		grid[5] = preda1;
		int move = predatore1.move(grid);
		System.out.println("Move result = " + move);
		assertTrue("Preda didn't move to attack the prey!", move == 5);
	}
}
