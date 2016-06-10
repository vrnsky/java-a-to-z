package ru.evrnsky.chapter2.start;

import ru.evrnsky.chapter2.models.*;

/**
	Use this class for testing API & UID
*/
public class StartUITest {
	
	private Input input;
	
	
	/**
		Constructor for this class
		@params: Input input - class which implement input interface
	*/
	public StartUITest(Input input) {
		this.input = input;
	}
	
	/**
		At this method test user input by StubInput
	*/
	public void init() {
	
		Tracker tracker = new Tracker(10);
		String name = input.ask("Enter a name of item: ");
		Item item = new Item(name, "Item description");
		tracker.addItem(item);
		
		for(Item element : tracker.getAllItems()) {
			System.out.println(element);
		}
	}
	
	/**
		Entry point. Launch testing by calling init method
	*/
	public static void main(String[] args) {
		
		String[] answer = new String[] {"Enter other name for this task"};
		new StartUITest(new StubInput(answer)).init();
	}
}