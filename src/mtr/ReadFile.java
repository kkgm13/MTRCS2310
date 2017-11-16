package mtr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {
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
