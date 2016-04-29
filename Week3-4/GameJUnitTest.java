import static org.junit.Assert.*;

import org.junit.Test;

/** Tests the Game class for different cases.
 * @author Team 15
 * @version April 29, 2016
 */
public class GameJUnitTest {

	@Test
	public void objectCreation() { //Ensures Game object is created
		Game driver = new Game("Team15");
		assertNotNull(driver);	
	}
	
	@Test
	public void nameTest() { //Ensures name is read in properly
		Game driver = new Game("Team15");
		assertEquals("Team15", driver.getName());	
	}
	
	@Test
	public void rollMultReturn() { //Ensures a roll multiplier is being returned
		Game driver = new Game("Team15");
		assertNotNull(driver.rollMult());	
	}
	
	@Test
	public void rollMillReturn() { //Ensures a mill roll is being returned
		Game driver = new Game("Team15");
		assertNotNull(driver.rollMill(5));	
	}
	
	@Test
	public void rollMineReturn() { //Ensures a mine roll is being returned
		Game driver = new Game("Team15");
		assertNotNull(driver.rollMine(5));	
	}
	
	@Test
	public void rollEventReturn() { //Ensures an event roll is being returned
		Game driver = new Game("Team15");
		assertNotNull(driver.rollEvent(5));	
	}
	
	@Test
	public void startDay(){ //Ensures days start at 0
		Game driver = new Game("Team15");
		assertEquals(0, driver.getDays());
	}
	
	@Test
	public void testBuildMineCost(){ //Ensures mine takes resources correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.buildMine();
		assertTrue(driver.getStone() == 15 && driver.getWood() == 10);
	}
	
	@Test
	public void testBuildMine(){ //Ensures mine is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		assertTrue(driver.buildMine());
	}
	
	@Test
	public void testBuildMillCost(){ //Ensures mill takes resources correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.buildMill();
		assertTrue(driver.getStone() == 10 && driver.getWood() == 15);
	}
	
	@Test
	public void testBuildMill(){ //Ensures mill is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		assertTrue(driver.buildMill());
	}
	
	@Test
	public void testBuildHouseCost(){ //Ensures house takes resources correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.buildHouse();
		assertTrue(driver.getStone() == 10 && driver.getWood() == 10);
	}
	
	@Test
	public void testBuildHouse(){ //Ensures house is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		assertTrue(driver.buildHouse());
	}
	
	@Test
	public void testBuildFenceCost(){ //Ensures fence takes resources correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.buildFence();
		assertTrue(driver.getStone() == 13 && driver.getWood() == 10);
	}
	
	@Test
	public void testBuildFence(){ //Ensures fence is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		assertTrue(driver.buildFence());
	}
	
	@Test
	public void testBuildWellCost(){ //Ensures well takes resources correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.buildWell();
		assertTrue(driver.getStone() == 10 && driver.getWood() == 13);
	}
	
	@Test
	public void testBuildWell(){ //Ensures well is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		assertTrue(driver.buildWell());
	}
	
	@Test
	public void testRequiredBuildingsNotBuilt(){ //Ensures that the unbuilt buildings are being returned
		Game driver = new Game("Team15");
		assertEquals("Well Fence House ", driver.requiredBuildingsStatus());
	}
	
	@Test
	public void testRequiredBuildingsBuilt(){ //Ensures that the built buildings are being returned as blank
		Game driver = new Game("Team15");
		driver.setStone(50);
		driver.setWood(50);
		driver.buildHouse();
		driver.buildFence();
		driver.buildWell();
		assertEquals("", driver.requiredBuildingsStatus());
	}
	
	@Test
	public void testBuildFarmCost(){ //Ensures farm takes resources correctly
		Game driver = new Game("Team15");
		
		driver.setStone(50);
		driver.setWood(50);
		driver.buildHouse();
		driver.buildFence();
		driver.buildWell();
		driver.setStone(5);
		driver.setWood(5);
		driver.setFood(5);
		driver.buildFarm();
		assertTrue(driver.getStone() == 2 && driver.getWood() == 2 && driver.getFood() == 2);
	}
	
	@Test
	public void testBuildFarm(){ //Ensures farm is built correctly
		Game driver = new Game("Team15");
		
		driver.setStone(50);
		driver.setWood(50);
		driver.buildHouse();
		driver.buildFence();
		driver.buildWell();
		driver.setStone(5);
		driver.setWood(5);
		driver.setFood(5);
		assertTrue(driver.buildFarm());
	}
	
	@Test
	public void testSetDays(){ //Ensures setDays works correctly
		Game driver = new Game("Team15");
		driver.setDays(2);
		assertEquals(2, driver.getDays());
	}
	
	@Test
	public void testSetFood(){ //Ensures setFood works correctly
		Game driver = new Game("Team15");
		driver.setFood(2);
		assertEquals(2, driver.getFood());
	}
	
	@Test
	public void testSetBuildings(){ //Ensures setBuildings works correctly
		Game driver = new Game("Team15");
		driver.setBuildings(1);
		assertEquals(1, driver.getBuildings());
	}
	
	@Test
	public void testSetWood(){ //Ensures setWood works correctly
		Game driver = new Game("Team15");
		driver.setWood(3);
		assertEquals(3, driver.getWood());
	}
	
	@Test
	public void testSetStone(){ //Ensures setStone works correctly
		Game driver = new Game("Team15");
		driver.setStone(1);
		assertEquals(1, driver.getStone());
	}
	
	@Test
	public void testGetEnvironment(){ //Ensures getEnvironment works correctly
		Game driver = new Game("Team15");
		assertEquals(0, driver.getEnvironment());
	}
	
	@Test
	public void testGetDays(){ //Ensures getDays works correctly
		Game driver = new Game("Team15");
		assertEquals(0, driver.getDays());
	}
	
	@Test
	public void testGetFood(){ //Ensures getFood works correctly
		Game driver = new Game("Team15");
		assertEquals(45, driver.getFood());
	}
	
	@Test
	public void testGetBuildings(){ //Ensures getBuildings works correctly
		Game driver = new Game("Team15");
		assertEquals(0, driver.getBuildings());
	}
	
	@Test
	public void testGetWood(){ //Ensures getWood works correctly
		Game driver = new Game("Team15");
		assertEquals(0, driver.getWood());
	}
	
	@Test
	public void testGetStone(){ //Ensures getStone works correctly
		Game driver = new Game("Team15");
		assertEquals(0, driver.getStone());
	}
	
	@Test
	public void testUpdateStone(){ //Ensures updateStone works correctly
		Game driver = new Game("Team15");
		driver.updateStone(2);
		assertEquals(2, driver.getStone());
	}
	
	@Test
	public void testUpdateWood(){ //Ensures updateWood works correctly
		Game driver = new Game("Team15");
		driver.updateWood(2);
		assertEquals(2, driver.getWood());
	}
	
	@Test
	public void testUpdateFood(){ //Ensures updateFood works correctly
		Game driver = new Game("Team15");
		driver.updateFood(2);
		assertEquals(47, driver.getFood());
	}
	
	@Test
	public void testGetDice(){ //Ensures a return from Dice class
		Game driver = new Game("Team15");
		assertNotNull(driver.getDice());
	}

}