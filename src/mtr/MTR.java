package mtr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		String line = "";
		String cvsSplitby = ",";
	
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] stations = line.split(cvsSplitBy);

                System.out.println("Line: " + stations[0]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
}