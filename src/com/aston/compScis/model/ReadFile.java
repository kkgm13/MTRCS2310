package com.aston.compScis.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * <h1>ReadFile</h1>
 * <br>
 * 
 * This allows to present the CSV file's information. This would come from the MTRsystem_partial.csv file.
 * 
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class ReadFile {
	
	/**
	 * <h2>FileInfo</h2>
	 * This allows to grab information from the CSV file.
	 * @return 
	 * 
	 * @throws FileNotFoundException
	 */
//	public void fileInfo() throws FileNotFoundException {
//		
//		String fileName = "MTRsystem_partial.csv";
//		File file = new File (fileName);
//		Scanner scanner = new Scanner(file);
//		scanner.useDelimiter(",");
//		
//		while (scanner.hasNext()) {
//			System.out.println(scanner.next());
//		}
//		scanner.close();
//		
//	}
	
	public String getFirstAndLastTermini() {
		
		String line = getLine();
		
		return line;
	
	
}
	
	private String getLine() {
		
		String fileName = "MTRsystem_partial.csv";
		String line = "";
		String cvsSplitby = ",";
	    String result = "";

	    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

	        while ((line = br.readLine()) != null) {

	            // use comma as separator
	            String[] stations = line.split(cvsSplitby);

	            // Result presentation 1
	            /*
	             * result += ("Train Line: " + stations[0] + "\n");
	             * result += ("\tFirst termini:\t " + stations[1] + "\n");
	             * result += ("\tLast termini:\t " + stations[stations.length-1] + "\n\n");
	             */
	            
	            //Result presentation 2
	            result += ("Train Line: " + stations[0] + "\n");
	            result += ("\tThis train goes from:\t " + stations[1] + " --- " + stations[stations.length-1] + "\n\n");
	            
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return result;
		
	}
		
}
