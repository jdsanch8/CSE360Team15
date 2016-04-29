import static org.junit.Assert.*;

import org.junit.Test;

public class DiceJUnitTest {

	@Test
	public void diceCreate(){		//Ensures that dice object is created
		Dice roller = new Dice();
		assertNotNull(roller);
	}
	
	@Test
	public void diceRoller(){		//Ensures value are within range
		Dice roller = new Dice();
		int testNum = roller.rollMultiplier();
		assertTrue(testNum >= 1 && testNum <= 6);
	}
	
	@Test
	public void diceRollerBigger(){ //Ensures upgraded values stay within range
		Dice roller = new Dice();
		roller.upGradeMulti();
		int testNum = roller.rollMultiplier();
		assertTrue(testNum >= 1 && testNum <= 8);
	}
/*	
	@Test
	public void diceModifyWood(){ //Ensures methods Dice uses to change wood works
		Game driver = new Game("Team15");
		driver.setWood(10);
		driver.updateWood(5);
		assertEquals(15, driver.getWood());
	}
	
	@Test
	public void diceRollWood(){ //Ensures method rollWood returns a string from the inputs
		Game driver = new Game("Team15");
		Dice die = new Dice();
		assertEquals("The mill has produced 3 wood!", die.rollWood(3, driver));
	}
	
	@Test
	public void diceRollStone(){ //Ensures method rollStone returns a string from the inputs
		Game driver = new Game("Team15");
		Dice die = new Dice();
		assertEquals("The mine has produced 2 stone!", die.rollStone(2, driver));
	}
	
	@Test
	public void diceBase(){ //Ensures methods rollBase case 1 functions correctly
		Game driver = new Game("Team15");
		Dice die = new Dice();
		assertEquals("The workers have produced 1 wood!", die.rollBase(1, driver));
	}
*/	
	@Test
	public void diceModifyFood(){ //Ensures methods Dice uses to change food works
		Game driver = new Game("Team15");
		driver.setFood(10);
		driver.updateFood(5);
		assertEquals(15, driver.getFood());
	}
	
	@Test
	public void diceModifyStone(){ //Ensures methods Dice uses to change stone works
		Game driver = new Game("Team15");
		driver.setStone(10);
		driver.updateStone(5);
		assertEquals(15, driver.getStone());
	}
	
	@Test
	public void testFenceDice(){	//Ensures that when the fence is build, the Dice class knows
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.buildFence();
		Dice tempDie = driver.getDice();
		assertTrue(tempDie.getFence()); 
	}
	
	@Test
	public void testHouseDice(){	//Ensures when house is built, the multiplier gets upgraded
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.buildHouse();
		Dice tempDie = driver.getDice();
		assertTrue(tempDie.getHouse()); 
	}

}