import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Algorithm_floatData {
	public static void main(String[] args)
	{
		//define size to generate data doc that contains the total number of size data
		String filepath = System.getProperty("user.dir");	
		int size = 2000;
		filepath +=("\\data_float_7digits_"+size+".txt");
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
			
			//generate random number
			Random random = new Random();
			//set size of the file
			for(int i=0;i<size;i++)
			{	
				//random number 
				int pow = (int) Math.pow(10, 2); //define max decimal digits (2 in this case)
				float randfloat = (float) (Math.floor((Math.random() * 99998 + 1) * pow) / pow);		
				//write it in 
				bw.write(String.valueOf(randfloat));		
				//new line
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
