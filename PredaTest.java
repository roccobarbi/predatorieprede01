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
	public void testMove() {
		fail("Not yet implemented");
	}

}
