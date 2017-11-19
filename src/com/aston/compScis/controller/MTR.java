package com.aston.compScis.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.aston.compScis.model.MTRLine;
import com.aston.compScis.view.TUI;
import com.aston.compScis.controller.ReadFile;

/**
 * <h1>MTR</h1>
 * <br>
 * 
 * This will allow the Program to set all information to present to the user.
 * <br>This also implements the Controller interface.
 * 
 * @see Controller
 * @author Team CompSci's
 * @version 1.0
 *
 */
public class MTR implements Controller {

	private static TUI ui;
	private static Controller controller;
	private static MTRLine mtrline;
	
		/*
		 * Explain the logic in having a main in MTR class, if main() is 
		 * already in ExecuteApplication Class and will be executed from there
		 */
//	public static void main(String[] args) throws FileNotFoundException {
//		ui = new TUI(controller);
//
//	}

@Override
public String listAllTermini() {
	// TODO Auto-generated method stub
	
	String termini="hello" ;
	return termini;
	
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