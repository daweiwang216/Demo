package theProject;
import java.io.*;

public class readTxt {
	String pathname = "";
	String output ="";
	
	public String readFile(String pathname) {
		this.pathname=pathname;
		try (FileReader reader = new FileReader(pathname);
			BufferedReader br = new BufferedReader(reader)){
			String line;
			while((line=br.readLine())!=null) {
				output=output+line+"\n";
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
}
