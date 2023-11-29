package theProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;//main test 


public class Read {
	
	public ALCollection<String> ReadAndStore (int s, String p) {
    	int dataSize = s;
    	String path = p;
    	
    	//for string 
    	ALCollection <String> storage = new ALCollection (dataSize);
    	
    	String output = "";
    	String line [] =new String[dataSize];
    	
    	readTxt mytxt = new readTxt();
    	output = mytxt.readFile(path);
    	line = output.split("\n");
    	int length = output.split("\n").length;
    	for (int i = 0; i < length; i++ ) {
    		String temp = (String) line[i];
    		storage.add(temp);
    	}

    	System.out.println("Data have been stored.");
    	System.out.println("Check the data below: \n");
    	System.out.println("Total number of the collection: " + storage.size());
    	for (int m=0; m<dataSize; m++ ) {
    		System.out.println("No."+(m+1)+" Element: "+storage.get(m));
    	}
		System.out.println();
		
		return storage;
	}
	
	public ALCollection<Float> ReadAndStoreF (int s, String p) throws NumberFormatException, IOException {
    	int dataSize = s;
    	String path = p;
    	
    	//for string 

    	ALCollection <Float> storageFloat = new ALCollection (dataSize);
		
		float temp1 = 0;
		BufferedReader br1 = new BufferedReader(new FileReader(new File(path)));
		
		 String t = "";
	     while ((t = br1.readLine()) != null) {
	         
	         temp1  = Float.parseFloat(t);
	         storageFloat.add(temp1);
	     }   

    	System.out.println("Data have been stored.");
    	System.out.println("Check the data below: \n");
    	System.out.println("Total number of the collection: " + storageFloat.size());
    	for (int m=0; m<dataSize; m++ ) {
    		System.out.println("No."+(m+1)+" Element: "+storageFloat.get(m));
    	}
		System.out.println();
		
		return storageFloat;
	}
	
	public ALCollection<Integer> ReadAndStoreI (int s, String p) throws NumberFormatException, IOException {
    	int dataSize = s;
    	String path = p;
    	
		ALCollection <Integer> storageInt = new ALCollection (dataSize);
		
		int temp = 0;
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		
		 String o = "";
	     while ((o = br.readLine()) != null) {
	         
	         temp  = Integer.parseInt(o);
	         storageInt.add(temp);
	     }   

    	System.out.println("Data have been stored.");
    	System.out.println("Check the data below: \n");
    	System.out.println("Total number of the collection: " + storageInt.size());
    	for (int m=0; m<dataSize; m++ ) {
    		System.out.println("No."+(m+1)+" Element: "+storageInt.get(m));
    	}
		System.out.println();
		
		return storageInt;
	}
	
	
}
