




public class StatisticsTester{
	public static void main(String []args)
	{
		System.out.println("Begin test");
		Statistics fileObj = new Statistics("Optimus Prime");
		fileObj.setVictory(1);
		fileObj.setDays(23);
		fileObj.setBuildings(3);
		fileObj.setResources(3);
		fileObj.writeToFile();
		System.out.println("Printing file:");
		fileObj.printFile();
		
	}
}