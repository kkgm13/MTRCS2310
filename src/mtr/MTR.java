package mtr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MTR implements Controller {

	private static TUI ui;
	private static Controller controller;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//fileInfo();
		ui = new TUI(controller);

	}
	
//	private static void fileInfo() {
//		String fileName = "MTRsystem_partial.csv";
//		String line = "";
//		String cvsSplitby = ",";
//	
//        String cvsSplitBy = ",";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//
//            while ((line = br.readLine()) != null) {
//
//                // use comma as separator
//                String[] stations = line.split(cvsSplitBy);
//
//                System.out.println("Line: " + stations[0] + "- First termini: " + stations[1] + "-last termini " + stations[5] );
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    
	
private static void fileInfo() throws FileNotFoundException {
	
	String fileName = "MTRsystem_partial.csv";
	File file = new File (fileName);
	Scanner scanner = new Scanner(file);
	
	while (scanner.hasNext()) {
		System.out.println(scanner.next());
	}
	
}

@Override
public String listAllTermini() {
	// TODO Auto-generated method stub
	
	String hello = "hello";
	return hello;
}

@Override
public String listStationsInLine(String line) {
	// TODO Auto-generated method stub
	return "hello";
}

@Override
public String listAllDirectlyConnectedLines(String line) {
	// TODO Auto-generated method stub
	return "hello";
}

@Override
public String showPathBetween(String stationA, String stationB) {
	// TODO Auto-generated method stub
	return "hello";
}


}