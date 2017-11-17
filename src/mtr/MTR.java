package mtr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MTR {

	private static TUI ui;
	private static Controller controller;
	
	
	public static void main(String[] args) {
		fileInfo();
		//ui = new TUI(controller);
	}
	
	private static void fileInfo() {
		String fileName = "MTRsystem_partial.csv";
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			inputStream.useDelimiter(",");
			while (inputStream.hasNext()) {
				String data =inputStream.next();
			//	String[] values = data.split(",");
				System.out.println(data);
			}
			inputStream.close();
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
}