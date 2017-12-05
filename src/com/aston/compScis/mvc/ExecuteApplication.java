package com.aston.compScis.mvc;

import com.aston.compScis.controller.MTR;
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
public class ExecuteApplication {

	private static TUI tui;
	private static MTR mtr;
	private static MTRMetro metroData;

	public static void main(String[] args){
		mtr = new MTR();
		metroData = new MTRMetro();
		tui = new TUI(mtr);
	}
}
