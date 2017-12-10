package com.aston.compScis.mvc;

import com.aston.compScis.controller.RequestHandler;
import com.aston.compScis.model.MTRMetro;
import com.aston.compScis.view.TUI;

/**
 * <h1>ExecuteApplication</h1>
 * <br>
 * This is the MVC class which will run the program
 * 
 * @author Team CompSci's
 * @version 1.0
 */
public class MTR {

	// Textual UI
	private static TUI tui;
	// MTR Controller Class
	private static RequestHandler mtr;

	public static void main(String[] args){
		mtr = new RequestHandler();
		tui = new TUI(mtr);
	}
}
