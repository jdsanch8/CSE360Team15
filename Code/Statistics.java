import java.io.*;

public class Statistics {
	
	private String playerName;
	
	private int victory;	
	private int days;
	private int buildings;
	private int resources;
    // note: create txt file of this name and place in same package
	private File file = new File(getClass().getResource("gameStats-group15.txt").getFile());

	public Statistics(String playerName) 
	{
		this.victory = 0;
		this.days = 0;
		this.buildings = 0;
		this.resources = 0;
		this.playerName = playerName;
		
		if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void printFile()
	{
		String line = null;

		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}   
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" +  file.getName() + "'.");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '"  + file.getName() + "'.");                  
		}
	}
	
	public void setVictory (int victory)
	{
		this.victory = victory;
	}
	
	public void setDays (int days)
	{
		this.days = days;
	}
	
	public void setBuildings (int buildings)
	{
		this.buildings = buildings;
	}
	
	public void setResources (int resources)
	{
		this.resources = resources;
	}
	
	public void writeToFile()
	{
		
		try {
			
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(this.playerName);
            bufferedWriter.write("-");
            bufferedWriter.write(Integer.toString(this.victory));
            bufferedWriter.write("-");
            bufferedWriter.write(Integer.toString(this.days));
            bufferedWriter.write("-");
            bufferedWriter.write(Integer.toString(this.buildings));
            bufferedWriter.write("-");
            bufferedWriter.write(Integer.toString(this.resources));
            bufferedWriter.newLine();
           
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println( "Error writing to file '" + file.getName() + "'.");

        }
	}
}
