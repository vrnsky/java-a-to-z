package ru.evrnsky.chapter2.start;

import ru.evrnsky.chapter2.models.*;

/*
	At this class look all opportunity API Tracker
*/

public class StartUI
{
	private Input input;
	
	public StartUI(Input input) {
		
		this.input = input;
	}
	/**
		Entry point of application
	*/
	public static void main(String[] args) {
		
		new StartUI(new ConsoleInput()).init();		
	}
	
	public void init() {
		
		Tracker tracker = new Tracker(10);
		String name = input.ask("Enter a name of item: ");
		Item item = new Item(name, "Item description");
		tracker.addItem(item);
		this.showAllItem(tracker.getAllItems());
	}
	
	/*
		Helper method. Display information about items
		@params:items - will be display in console
		@see: method toString in Item.java
	*/
	private void showAllItem(Item[] items)
	{
		for(Item item : items) {
			if(item != null)
			 System.out.println(item);
		}
	}
	
	/**
		Helper method. Display comments for items
		@params:comments - it is given from instance of item
		@see: method toString in Comment.java
	*/
	private void showComment(Comment[] comments)
	{
		for(Comment comment : comments)
			System.out.println(comment);
	}
}