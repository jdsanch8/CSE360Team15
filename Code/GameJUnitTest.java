import static org.junit.Assert.*;

import org.junit.Test;

public class GameJUnitTest {

	@Test
	public void nameTest() {
		Game driver = new Game("Team15");
		assertEquals("Team15", driver.getName());
	}
	
	@Test
	public void diceRoller(){		
		Dice roller = new Dice();
		int testNum = roller.rollMultiplier();
		assertTrue(testNum >= 1 && testNum <= 6);
	}
	
	@Test
	public void diceRollerBigger(){
		Dice roller = new Dice();
		roller.upGradeMulti();
		int testNum = roller.rollMultiplier();
		assertTrue(testNum >= 1 && testNum <= 8);
	}
	
	@Test
	public void startDay(){
		Game driver = new Game("Team15");
		assertEquals(0, driver.getDays());
	}
	
	@Test
	public void testBuildMine(){
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(1);
		assertTrue(driver.getStone() == 15 && driver.getWood() == 10);
	}
	
	@Test
	public void testBuildMill(){
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(2);
		assertTrue(driver.getStone() == 10 && driver.getWood() == 15);
	}
	
	@Test
	public void testBuildHouse(){
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(3);
		assertTrue(driver.getStone() == 10 && driver.getWood() == 10);
	}
	
	@Test
	public void testBuildFence(){
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(4);
		assertTrue(driver.getStone() == 13 && driver.getWood() == 10);
	}
	
	@Test
	public void testBuildWell(){
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(5);
		assertTrue(driver.getStone() == 10 && driver.getWood() == 13);
	}
	
	@Test
	public void testFenceDice(){
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(4);
		Dice tempDie = driver.getDice();
		assertTrue(tempDie.getFence()); 
	}
	
	@Test
	public void testHouseDice(){
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(3);
		Dice tempDie = driver.getDice();
		assertTrue(tempDie.getHouse()); 
	}

}
