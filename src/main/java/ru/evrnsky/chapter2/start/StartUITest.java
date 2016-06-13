package ru.evrnsky.chapter2.start;

import ru.evrnsky.chapter2.models.*;

/**
	Use this class for testing API & UI
*/
public class StartUITest {
	
	private Input input;
	private Tracker tracker;
	private String userCommand = "";
	
	/**
		Constructor for this class
		@params: Input input - class which implement input interface
	*/
	public StartUITest(Input input) {
		this.input = input;
		tracker = new Tracker();
	}
	
	/**
		At this method test user input by StubInput
	*/
	public void init() {
		
		MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
		menuTracker.fillActions();
		
		do{
			menuTracker.show();
			int key = Integer.valueOf(input.ask("Type a command:"));
			menuTracker.select(key);		
		} while(!"y".equals(input.ask("Exit(y): ")));
	}
	
	/**
		Entry point. Launch testing by calling init method
	*/
	public static void main(String[] args) {
		
		/**
		  User actual do next thing
		  1.Add 3 items
		  2.Ask show all items
		  3.Commeting second items
		  4.Show comment for second items
		  5.Edit second items
		  6.Removing item
		  7.Show all items
		  8.Add item
		  9.Exit from app
		*/
		String[] answer = new String[] {
										 "0", "Fix bugs", "You must to fix bugs", "n",
										 "0", "Buy new macbook", "You have to buy macbook", "n",
										 "0", "Visit to the customer", "Meeting with customer", "n",
										 "2","n",
										 "4", "2", "New comment for this item", "n",
										 "5", "2", "n",
										 "3", "2", "Launch linux", "Time for launch linux on our server","n",
										 "1","1","n",
										 "2","n",
										 "0", "Current item", "Current item",
										 "y"
		                                };
		new StartUITest(new StubInput(answer)).init();
	}
}