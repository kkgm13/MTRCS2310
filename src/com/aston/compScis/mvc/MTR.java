package com.aston.compScis.mvc;

import com.aston.compScis.controller.RequestHandler;
import com.aston.compScis.view.TUI;

/**
 * <h1>MTR</h1>
 * <br>
 * This is the MVC executable class which will run the program
 * 
 * @author Team CompSci's
 * @version 1.0
 */
public class MTR {

	// Textual UI
	private static TUI tui;
	// MTR Controller Class
	private static RequestHandler rh;

	public static void main(String[] args){
		rh = new RequestHandler();
		tui = new TUI(rh);
	}
}
