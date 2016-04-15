import static org.junit.Assert.*;

import org.junit.Test;

public class GameJUnitTest {

	@Test
	public void nameTest() { //Ensures name is read in properly
		Game driver = new Game("Team15");
		assertEquals("Team15", driver.getName());	
	}
	
	@Test
	public void startDay(){ //Ensures days start at 0
		Game driver = new Game("Team15");
		assertEquals(0, driver.getDays());
	}
	
	@Test
	public void testBuildMine(){ //Ensures mine takes resources and is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(1);
		assertTrue(driver.getStone() == 15 && driver.getWood() == 10);
	}
	
	@Test
	public void testBuildMill(){ //Ensures mill takes resources and is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(2);
		assertTrue(driver.getStone() == 10 && driver.getWood() == 15);
	}
	
	@Test
	public void testBuildHouse(){ //Ensures House takes resources and is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(3);
		assertTrue(driver.getStone() == 10 && driver.getWood() == 10);
	}
	
	@Test
	public void testBuildFence(){ //Ensures Fence takes resources and is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(4);
		assertTrue(driver.getStone() == 13 && driver.getWood() == 10);
	}
	
	@Test
	public void testBuildWell(){ //Ensures well takes resources and is built correctly
		Game driver = new Game("Team15");
		driver.setStone(15);
		driver.setWood(15);
		driver.build(5);
		assertTrue(driver.getStone() == 10 && driver.getWood() == 13);
	}
}
