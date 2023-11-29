import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.apache.commons.lang.RandomStringUtils;

public class RandomString {
	public static void main(String[] args)
	{
		//define size to generate data doc that contains the total number of size data
		String filepath = System.getProperty("user.dir");	
		int size = 2000;
		filepath +=("\\data_String_7digits_"+size+".txt");
		System.out.println(filepath);
		
		try 
		{
			File file = new File(filepath);			
			if(!file.exists())
			{	//create data.txt file if not exist
				file.createNewFile();
				System.out.println("data.txt created");				
			}
			FileWriter fw = new FileWriter(file);		
			BufferedWriter bw = new BufferedWriter(fw);

			//set size of the file
			for(int i=0;i<size;i++) {
				//generate random strings
				String temp = RandomStringUtils.randomAlphanumeric(7);
				bw.write(temp);
				bw.newLine();
			}
			bw.close();
			fw.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	} 	
}
