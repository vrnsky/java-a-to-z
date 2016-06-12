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
		while(true) {	
			this.showMenu();
			switch(userCommand) {
				case "1":
					this.addItem();	
					break;
				case "2":
					this.removeItem();
					break;
				case "3":
					this.editItem();
					break;
				case "4":
					this.addComment();
					break;
				case "5":
					this.showComments();
				case "6":
					System.exit(0);
					break;
				
			}
			
			userCommand = input.ask("");
			this.showAllItems();
			System.out.println("====================END FLAG. USE FOR MORE READABLE IN CONSOLE=================");
		}
	}
	
	/**
		Entry point. Launch testing by calling init method
	*/
	public static void main(String[] args) {
		
		/**
		  User actual do next thing
		  1.Add 3 items
		  2.Commenting
		  3.See comments
		  4.Editing item
		  5.Removing item
		  6.Exit from app
		*/
		String[] answer = new String[] {
										 "1", "Fix bugs", "You must to fix bugs",
										 "1", "Buy new macbook", "You have to buy macbook",
										 "1", "Visit to the customer", "Meeting with customer",
										 "4", "1", "It is my first comment",
										 "5","1",
										 "3", "2", "New name of this item", "New description for this item",
										 "2", "2",
										 "6"
									
		};
		new StartUITest(new StubInput(answer)).init();
	}
	
	
	/**
		Get data from input stub and add new item to the tracker
	*/
	private void addItem(){
		String name = input.ask("");
		String description = input.ask("");
		tracker.addItem(new Item(name, description));
	}
	
	/**
		Get data of editing item and edited and set in the tracker
	*/
	private void editItem() {
		int position = getPosition("Enter a number of item for editing: ");
		Item item = tracker.getAllItems()[position];
		item.setName(input.ask("Type new name"));
		item.setDescription(input.ask("Type new description"));
		tracker.editItem(item);
	}
	
	/**
		Get number in list of item and remove it from tracker
	*/
	private void removeItem() {
		int position = getPosition("Number item in list: ");
		Item item = tracker.getAllItems()[position];
		tracker.removeItem(item.getId());
	}
	
	/**
		Ask about number of item in array and add to it comment
	*/
	private void addComment() {
		int position = getPosition("Number item in list for commenting: ");
		Item item = tracker.getAllItems()[position];
		String comment = input.ask("Enter a comment");
		tracker.addComment(item, new Comment(comment));
	}
	
	/**
		Ask number of item in list and show comments for it
	*/
	private void showComments() {
		int position = getPosition("Number item in list: ");
		Item item = tracker.getAllItems()[position];
		System.out.println(item);
		for(Comment comment : item.getComments())
			System.out.println(comment);
	}
	
	/**
		Show all items which no null
	*/
	private void showAllItems(){
		for(Item item : tracker.getAllItems()) {
			if(item != null)
			System.out.println(item);
		}
	}
	
	/**
	   Help method for compute a number of item in list
	   @String: it is string which will not show to user 
	   @return: position in list of items
	*/
	private int getPosition(String question){
		String itemNumber = input.ask(question);
		return Integer.valueOf(itemNumber)-1;
	}
	
	/**
		Show menu for user
	*/
	private void showMenu(){
		System.out.println("1.Add new item");
		System.out.println("2.Remove item");
		System.out.println("3.Editing item");
		System.out.println("4.Add comment");
		System.out.println("5.Show comments");
		System.out.println("6.Exit");
	}
}