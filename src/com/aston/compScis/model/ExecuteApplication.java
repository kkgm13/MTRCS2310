package com.aston.compScis.model;

import java.io.FileNotFoundException;

import com.aston.compScis.Controller.MTR;
import com.aston.compScis.view.TUI;

public class ExecuteApplication {

		private static TUI tui;
		private static MTR mtr = new MTR();
	public static void main(String[] args) throws FileNotFoundException {
		
		tui = new TUI(mtr);

	}
}
