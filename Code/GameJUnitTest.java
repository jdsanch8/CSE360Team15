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
	
	
	

}
