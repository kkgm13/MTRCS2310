package mtr;

public class MTR {

	private static TUI ui;
	private static Controller controller;
	
	public static void main(String[] args) {
		ui = new TUI(controller);
	}
}