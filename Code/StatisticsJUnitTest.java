import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class StatisticsJUnitTest {
	@Test
	public void testStatisticsConstructor() {
		String playerName = "";
		assertNotNull(playerName); // name is parameter in constructor

		Statistics stat = new Statistics(playerName);
		assertNotNull(stat); // case: object is instantiated

		String filename = "g.txt";
		assertNotNull(filename); //make sure file name has value

		String workingDirectory = System.getProperty("user.dir");
		assertNotNull(workingDirectory); //make sure path has value

		boolean created = false; // check if create new file works

		File file = new File(workingDirectory, filename);
		assertNotNull(file); // make sure file is instantiated 
		assertTrue(!file.exists());

		if (!file.exists()){
			try {
				created = file.createNewFile();
				assertTrue(created); // case: check if new file created
			} catch (IOException e) {
				e.printStackTrace();
				assertNull(e); // check that exception object not instantiated
			}
		}
		assertTrue(file.exists()); // case: check that file now exists
		assertTrue(file.canWrite()); // check that are able to write file
		assertTrue(file.canRead()); // check that are able to read file
		assertEquals("g.txt",file.getName()); //check that file name is correct


		assertEquals(playerName, stat.getPlayerName()); // case: default constructor is called
		assertEquals(0, stat.getVictory()); // case: default constructor is called
		assertEquals(0, stat.getDays()); // case: default constructor is called
		assertEquals(0, stat.getBuildings()); // case: default constructor is called
		assertEquals(0, stat.getResources()); // case: default constructor is called

		assertTrue(file.delete()); // making sure deleting test file from user's computer works
	}
	@Test
	public void testPrintFile() {
		//note: to avoid duplicating JUnit tests, see testStatisticsConstructor() for test of this block of code found throughout this JUnit Test
		String filename = "t.txt";
		String workingDirectory = System.getProperty("user.dir");
		File file = new File(workingDirectory, filename);
		if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String line = null;
		assertNull(line); // string to hold line data from file initially Null

		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());
			assertNotNull(fileReader); //check that object is instantiated;
			assertTrue(file.exists()); // case: check that file now exists
			assertTrue(file.canWrite()); // check that are able to write file
			assertTrue(file.canRead()); // check that are able to read file

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			assertNotNull(bufferedReader); //check that object is instantiated;
			assertNull(bufferedReader.readLine()); // check that empty file has no content to read

			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {                 
		}
		catch(IOException ex) {                 
		}

		file.delete();

		//test FileNotFoundException
		File file1 = new File(workingDirectory, filename);
		try {
			FileReader fileReader = new FileReader(file1.getAbsoluteFile()); 
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.close();    
		}
		catch(FileNotFoundException ex) {  
			assertNotNull(ex); // make sure exception object instantiated
		}
		catch(IOException ex) { 
			assertNull(ex);
		}     
		file1.delete();

		//test IOException
		File file2 = new File(workingDirectory, filename);
		try {
			FileReader fileReader = new FileReader(file2.getAbsoluteFile()); 
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.close();    
		}
		catch(IOException ex) {;
		assertNotNull(ex);
		}  
		file2.delete();
	}
	@Test
	public void testSetVictory(){
		Statistics stat = new Statistics("");
		stat.setVictory(2);
		assertEquals(2, stat.getVictory()); //testing get and set methods
		stat.setVictory(5);
		assertEquals(5, stat.getVictory()); //testing get and set methods
	}
	@Test
	public void testSetDays(){
		Statistics stat = new Statistics("");
		stat.setDays(2);
		assertEquals(2, stat.getDays()); //testing get and set methods
	}
	@Test
	public void testSetBuildings(){
		Statistics stat = new Statistics("");
		stat.setBuildings(6);
		assertEquals(6, stat.getBuildings());//testing get and set methods
	}
	@Test
	public void testSetResources(){
		Statistics stat = new Statistics("");
		stat.setResources(6);
		assertEquals(6, stat.getResources());//testing get and set methods
	}
	@Test
	public void testWriteToFile(){
		String filename = "z.txt";
		String workingDirectory = System.getProperty("user.dir");
		File file = new File(workingDirectory, filename);
		if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			//writing two lines to file.  Testing correctness with assert functions
			bufferedWriter.write("Testing");
			bufferedWriter.write("-");
			bufferedWriter.write(Integer.toString(1));
			bufferedWriter.write("-");
			bufferedWriter.write(Integer.toString(2));
			bufferedWriter.write("-");
			bufferedWriter.write(Integer.toString(3));
			bufferedWriter.write("-");
			bufferedWriter.write(Integer.toString(4));
			bufferedWriter.newLine();
			bufferedWriter.write("UnitTesting");
			bufferedWriter.write("-");
			bufferedWriter.write(Integer.toString(4));
			bufferedWriter.write("-");
			bufferedWriter.write(Integer.toString(3));
			bufferedWriter.write("-");
			bufferedWriter.write(Integer.toString(2));
			bufferedWriter.write("-");
			bufferedWriter.write(Integer.toString(1));
			bufferedWriter.newLine();
			bufferedWriter.close();
		}
		catch(IOException ex) {
			assertNull(ex); //test to make sure IOException object is not instantiated
		}
		String content = null;
		
		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			content = bufferedReader.readLine();
			assertEquals("Testing-1-2-3-4", content); //checking sure file matches what was written
			content = bufferedReader.readLine();
			assertEquals("UnitTesting-4-3-2-1", content);//checking sure file matches what was written
			content = bufferedReader.readLine();
			assertNull(content); //checking to make sure end of file content
			
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {                
		}
		catch(IOException ex) {                 
		}
		file.delete();
	}
	@Test
	public void testMakeArrayList(){
		ArrayList<Stats> list = new ArrayList<Stats>();
		String token [];
		String player; 
		String win; 
		String time; 
		String properties; 
		String supplies;
		String line = "PlayerName-1-2-3-4"; //test line of text from txt file

		token = line.split("-");
		player = token[0];
		assertEquals("PlayerName", player); //test parse of string
		win = token[1];
		assertEquals("1", win);//test parse of string
		time = token[2];
		assertEquals("2", time);//test parse of string
		properties = token[3];
		assertEquals("3", properties);//test parse of string
		supplies = token[4];
		assertEquals("4", supplies);//test parse of string

		list.add(new Stats(player, Integer.parseInt(win),Integer.parseInt(time), Integer.parseInt(properties), Integer.parseInt(supplies)));
		assertEquals("name=PlayerName, win=1, time=2, properties=3, supplies=4", list.get(0).toString()); //testing that correct content added to arrayList
		list.add(new Stats("Name",1,1,1,1));
		assertEquals("name=Name, win=1, time=1, properties=1, supplies=1", list.get(1).toString()); //testing that correct content added to arrayList
		list.add(new Stats("Name Failure",0,9,9,9)); //these two entries in list show that the first integer has greatest precedence
		list.add(new Stats("Name Highscore",1,7,7,7)); //this will appear first in sorted list, failure will be last
		list.add(new Stats("NameA",1,4,9,9));//of these two entries, NameB appears first in sorted list, b/c 7>4
		list.add(new Stats("NameB",1,7,4,9));//showing precedence of second integer
		list.add(new Stats("NameZ",1,4,4,9));//of these two entries, NameX appear first in sorted list, b/c 5>4
		list.add(new Stats("NameX",1,4,5,1));//showing second to last integer precedence
		list.add(new Stats("NameG",1,2,5,1));//of these two entries, NameH will appear first in sorted list, b/c 3>1
		list.add(new Stats("NameH",1,2,5,3));//showing precedence of last integer
		list.add(new Stats("Name Zz",0,10,10,10));//of these two entries Name Aa will appear first in sorted list b/c name comes first alphabetically
		list.add(new Stats("Name Aa",0,10,10,10));//when all entries are the same, order is alphabetical.
		
		Collections.sort(list);
		// Collections.sort(list) will test CompareTo method too! (B/c sorting list based on entries uses compareTo @Override)
		assertEquals("name=Name Highscore, win=1, time=7, properties=7, supplies=7", list.get(0).toString());
		assertEquals("name=NameB, win=1, time=7, properties=4, supplies=9", list.get(1).toString());//testing correctness of arrayList sort
		assertEquals("name=NameA, win=1, time=4, properties=9, supplies=9", list.get(2).toString());//testing correctness of arrayList sort
		assertEquals("name=NameX, win=1, time=4, properties=5, supplies=1", list.get(3).toString());//testing correctness of arrayList sort
		assertEquals("name=NameZ, win=1, time=4, properties=4, supplies=9", list.get(4).toString());//testing correctness of arrayList sort
		assertEquals("name=NameH, win=1, time=2, properties=5, supplies=3", list.get(5).toString());//testing correctness of arrayList sort
		assertEquals("name=NameG, win=1, time=2, properties=5, supplies=1", list.get(6).toString());//testing correctness of arrayList sort
		assertEquals("name=PlayerName, win=1, time=2, properties=3, supplies=4", list.get(7).toString());//testing correctness of arrayList sort
		assertEquals("name=Name, win=1, time=1, properties=1, supplies=1", list.get(8).toString());//testing correctness of arrayList sort
		assertEquals("name=Name Aa, win=0, time=10, properties=10, supplies=10", list.get(9).toString());//testing correctness of arrayList sort
		assertEquals("name=Name Zz, win=0, time=10, properties=10, supplies=10", list.get(10).toString());//testing correctness of arrayList sort
		assertEquals("name=Name Failure, win=0, time=9, properties=9, supplies=9", list.get(11).toString());//testing correctness of arrayList sort
	}
	@Test
	public void testWriteListToFile(){
		String filename = "i.txt";
		String workingDirectory = System.getProperty("user.dir");
		File file = new File(workingDirectory, filename);
		if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//creating list contents to add to file for testing purposes
		ArrayList<Stats> list = new ArrayList<Stats>();
		list.add(new Stats("List",1,7,2,1)); 
		list.add(new Stats("Writing",1,10,2,3)); 
		list.add(new Stats("To",0,9,6,6)); 
		list.add(new Stats("File",0,4,9,9));
		
		try {

			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), false); 
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			//writing list content to file
			for(Stats stat: list){
				bufferedWriter.write(stat.getPlayer());
				bufferedWriter.write("-");
				bufferedWriter.write(Integer.toString(stat.getWin()));
				bufferedWriter.write("-");
				bufferedWriter.write(Integer.toString(stat.getTime()));
				bufferedWriter.write("-");
				bufferedWriter.write(Integer.toString(stat.getProperties()));
				bufferedWriter.write("-");
				bufferedWriter.write(Integer.toString(stat.getSupplies()));
				bufferedWriter.newLine();
			}          
			bufferedWriter.close();
		}
		catch(IOException ex) {
		}
		
		String content = null;
		
		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			content = bufferedReader.readLine();
			assertEquals("List-1-7-2-1", content); //testing if list correctly written to file
			content = bufferedReader.readLine();
			assertEquals("Writing-1-10-2-3", content); //testing if list correctly written to file
			content = bufferedReader.readLine();
			assertEquals("To-0-9-6-6", content); //testing if list correctly written to file
			content = bufferedReader.readLine();
			assertEquals("File-0-4-9-9", content); //testing if list correctly written to file
			content = bufferedReader.readLine();
			assertNull(content); //testing that list correctly stopped writing to file at its end
			
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) { ;                
		}
		catch(IOException ex) {;                  
		}
		file.delete(); 
	}
	@Test
	public void testStatsConstructor(){
		Stats stat = new Stats("test",2,3,4,5);
		assertNotNull(stat); //testing that object is instantiated
	}
	@Test
	public void testGetPlayer(){
		Stats stat = new Stats("test",2,3,4,5);
		assertEquals("test", stat.getPlayer()); //testing correctness of get and set functions
	}
	@Test
	public void testGetWin(){
		Stats stat = new Stats("test",2,3,4,5);
		assertEquals(2, stat.getWin()); //testing correctness of get and set functions
	}
	@Test
	public void testGetTime(){
		Stats stat = new Stats("test",2,3,4,5);
		assertEquals(3, stat.getTime()); //testing correctness of get and set functions
	}
	@Test
	public void testGetProperties(){
		Stats stat = new Stats("test",2,3,4,5);
		assertEquals(4, stat.getProperties()); //testing correctness of get and set functions
	}
	@Test
	public void testGetSupplies(){
		Stats stat = new Stats("test",2,3,4,5);
		assertEquals(5, stat.getSupplies()); //testing correctness of get and set functions
	}
}
