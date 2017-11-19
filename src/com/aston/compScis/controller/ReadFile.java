package com.aston.compScis.controller;

import java.io.File;
import java.io.FileNotFoundException;
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
	 * 
	 * @throws FileNotFoundException
	 */
	public void fileInfo() throws FileNotFoundException {
		
		String fileName = "MTRsystem_partial.csv";
		File file = new File (fileName);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter(",");
		
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();
		
	}
	
	/*	private static void fileInfo() {
	String fileName = "MTRsystem_partial.csv";
	String line = "";
	String cvsSplitby = ",";

    String cvsSplitBy = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] stations = line.split(cvsSplitBy);

            System.out.println("Line: " + stations[0] + "- First termini: " + stations[1] + "-last termini " + stations[5] );

        }

    } catch (IOException e) {
        e.printStackTrace();
    }*/
	
}