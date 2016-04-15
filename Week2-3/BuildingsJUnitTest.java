import static org.junit.Assert.*;

import org.junit.Test;

/** Tests the Buildings class for different cases.
 * @author Team 15
 * @version April 11, 2016
 * 
 */
public class BuildingsJUnitTest {

	/** Checks if an object was created  */
	@Test
	public void testBuildings() {
		Buildings structure = new Buildings();
		assertNotNull(structure);
	}
	
	/** Tests if the house will build given enough resources  */
	@Test
	public void testBuildHouse() {
		Buildings structure = new Buildings();
		assertTrue(structure.buildHouse(5, 6));
	}
	
	/** Tests if the house will fail construction given insufficient resources  */
	@Test
	public void testBuildHouse2() {
		Buildings structure = new Buildings();
		assertFalse(structure.buildHouse(4,5));
	}
	
	/** Tests if the house is built with one already constructed  */
	@Test
	public void testBuildHouse3() {
		Buildings structure = new Buildings();
		structure.buildHouse(5,5);
		assertFalse(structure.buildHouse(5,5));
	}

	/** Tests if the fence will build given enough resources  */
	@Test
	public void testBuildFence() {
		Buildings structure = new Buildings();
		assertTrue(structure.buildFence(2, 5));
	}
	
	/** Tests if the fence will fail construction given insufficient resources  */
	@Test
	public void testBuildFence2() {
		Buildings structure = new Buildings();
		assertFalse(structure.buildFence(4, 1));
	}
	
	/** Tests if the fence is built with one already constructed  */
	@Test
	public void testBuildFence3() {
		Buildings structure = new Buildings();
		structure.buildFence(2,6);
		assertFalse(structure.buildFence(5,5));
	}

	/** Tests if the well will build given enough resources  */
	@Test
	public void testBuildWell() {
		Buildings structure = new Buildings();
		assertTrue(structure.buildWell(6, 2));
	}
	
	/** Tests if the well will fail construction given insufficient resources  */
	@Test
	public void testBuildWell2() {
		Buildings structure = new Buildings();
		assertFalse(structure.buildWell(1, 1));
	}
	
	/** Tests if the well is built with one already constructed  */
	@Test
	public void testBuildWell3() {
		Buildings structure = new Buildings();
		structure.buildWell(5, 2);
		assertFalse(structure.buildWell(5,5));
	}

	/** Tests if the Mill will build given enough resources  */
	@Test
	public void testBuildMill() {
		Buildings structure = new Buildings();
		assertTrue(structure.buildMill(6));
	}
	
	/** Tests if the Mill will fail construction given insufficient resources  */
	@Test
	public void testBuildMill2() {
		Buildings structure = new Buildings();
		assertFalse(structure.buildMill(1));
	}
	
	/** Tests if the Mill is built with one already constructed  */
	@Test
	public void testBuildMill3() {
		Buildings structure = new Buildings();
		structure.buildMill(5);
		assertFalse(structure.buildMill(6));
	}

	/** Tests if the Mine will build given enough resources  */
	@Test
	public void testBuildMine() {
		Buildings structure = new Buildings();
		assertTrue(structure.buildMine(6));
	}
	
	/** Tests if the Mine will fail construction given insufficient resources  */
	@Test
	public void testBuildMine2() {
		Buildings structure = new Buildings();
		assertFalse(structure.buildMine(1));
	}
	
	/** Tests if the Mine is built with one already constructed  */
	@Test
	public void testBuildMine3() {
		Buildings structure = new Buildings();
		structure.buildMine(5);
		assertFalse(structure.buildMine(6));
	}

	/** Tests if the Farm will build given enough resources and prerequisite buildings  */
	@Test
	public void testBuildFarm() {
		Buildings structure = new Buildings();
		structure.buildHouse(5, 5);
		structure.buildFence(5, 5);
		structure.buildWell(5, 5);
		assertTrue(structure.buildFarm(3, 3, 4));
	}
	
	/** Tests if the Farm will fail construction given insufficient resources with prerequisite buildings  */
	@Test
	public void testBuildFarm2() {
		Buildings structure = new Buildings();
		structure.buildHouse(5, 5);
		structure.buildFence(5, 5);
		structure.buildWell(5, 5);
		assertFalse(structure.buildFarm(1, 0 , 3));
	}
	
	/** Tests if the Farm will fail construction given sufficient resources with insufficient prerequisite buildings  */
	@Test
	public void testBuildFarm3() {
		Buildings structure = new Buildings();
		structure.buildHouse(5, 5);
		structure.buildFence(5, 5);
		assertFalse(structure.buildFarm(5, 5 , 5));
	}
	
	/** Tests retrieving the house value when false  */
	@Test
	public void testGetHouse() {
		Buildings structure = new Buildings();
		assertFalse(structure.getHouse());
	}
	
	/** Tests retrieving the house value when true  */
	@Test
	public void testGetHouse2() {
		Buildings structure = new Buildings();
		structure.buildHouse(5,5);
		assertTrue(structure.getHouse());
	}

	/** Tests retrieving the fence value when false  */
	@Test
	public void testGetFence() {
		Buildings structure = new Buildings();
		assertFalse(structure.getFence());
	}
	
	/** Tests retrieving the fence value when true  */
	@Test
	public void testGetFence2() {
		Buildings structure = new Buildings();
		structure.buildFence(5,5);
		assertTrue(structure.getFence());
	}

	/** Tests retrieving the well value when false  */
	@Test
	public void testGetWell() {
		Buildings structure = new Buildings();
		assertFalse(structure.getWell());
	}
	
	/** Tests retrieving the well value when true  */
	@Test
	public void testGetWell2() {
		Buildings structure = new Buildings();
		structure.buildWell(5,5);
		assertTrue(structure.getWell());
	}

	/** Tests retrieving the Mill value when false  */
	@Test
	public void testGetMill() {
		Buildings structure = new Buildings();
		assertFalse(structure.getMill());
	}
	
	/** Tests retrieving the Mill value when true  */
	@Test
	public void testGetMill2() {
		Buildings structure = new Buildings();
		structure.buildMill(5);
		assertTrue(structure.getMill());
	}

	/** Tests retrieving the Mine value when false  */
	@Test
	public void testGetMine() {
		Buildings structure = new Buildings();
		assertFalse(structure.getMine());
	}
	
	/** Tests retrieving the Mine value when true  */
	@Test
	public void testGetMine2() {
		Buildings structure = new Buildings();
		structure.buildMine(5);
		assertTrue(structure.getMine());
	}

	/** Tests retrieving the Farm value when false  */
	@Test
	public void testGetFarm() {
		Buildings structure = new Buildings();
		assertFalse(structure.getFarm());
	}
	
	/** Tests retrieving the Farm value when true  */
	@Test
	public void testGetFarm2() {
		Buildings structure = new Buildings();
		structure.buildHouse(5, 5);
		structure.buildFence(5, 5);
		structure.buildWell(5, 5);
		structure.buildFarm(3, 3, 3);
		assertTrue(structure.getFarm());
	}

}
