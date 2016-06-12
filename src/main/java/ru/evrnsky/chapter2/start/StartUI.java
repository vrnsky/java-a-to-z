package ru.evrnsky.chapter2.start;

import ru.evrnsky.chapter2.models.*;

/*
	At this class look all opportunity API Tracker
*/

public class StartUI
{
	private Input input;
	private Tracker tracker;
	private String userCommand = "";
	
	public StartUI(Input input) {
		this.input = input;
		tracker = new Tracker();
	}
	/**
		Entry point of application
	*/
	public static void main(String[] args) {
		new StartUI(new ConsoleInput()).init();		
	}
	
	/**
		At this method user choose command and app execute it
	*/
	public void init() {
		while(true) {
			this.showMenu();
			userCommand = input.ask("Type a command: ");
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
					break;
				case "6":
					System.exit(0);
					break;
			}

			this.showAllItem(tracker.getAllItems());
			System.out.println("==================END FLAG. USE FOR MORE READABLE IN CONSOLE==================");
		}
	}
	
	/**
		Helper method. Display information about items
		@params:items - will be display in console
		@see: method toString in Item.java
	*/
	private void showAllItem(Item[] items)
	{
		System.out.println("============ITEMS LIST STARTS=================");
		for(Item item : items) {
			if(item != null) {
			  System.out.println(item);
			  System.out.println("___________________");
			}
		}
	}
	
	/**
		Help method. Display comments for items
		@params:comments - it is given from instance of item
		@see: method toString in Comment.java
	*/
	private void showComment(Comment[] comments) {
		for(Comment comment : comments)
			System.out.println(comment);
	}
	
	/**
		Ask user about data for item and adding item to the tracker
	*/
	private void addItem() {
		String name = input.ask("Enter a name of item: ");
		String description = input.ask("Enter a description of item: ");
		tracker.addItem(new Item(name, description));
	}
	
	/**
		Ask user about number of item in list which he want to delete
		And delete its from tracker
	*/
	private void removeItem() {
		int position = getPosition("Enter a number of item in list: ");
		Item removedItem = tracker.getAllItems()[position];
		tracker.removeItem(removedItem.getId());
	}
	
	/**
		Ask user about item which he want to edit and find it in tracker
		Edit and edited item return to the tracker
	*/
	private void editItem() {
		int position = getPosition("Enter a number of item in list: ");
		Item editItem = tracker.getAllItems()[position];
		editItem.setName(input.ask("Type new name for item: "));
		editItem.setDescription(input.ask("Type new description for item: "));
		tracker.editItem(editItem);
	}
	
	/**
		Ask user about item which he want to comment and find it in tracker
		Ask user string for comment and add to item
	*/
	private void addComment(){
		int position = getPosition("Enter a number of item in list: ");
		Item item = tracker.getAllItems()[position];
		tracker.addComment(item, new Comment(input.ask("Enter a comment: ")));
	}
	
	/**
		Ask user about which item for show comment and show its
	*/
	private void showComments(){
		System.out.println("=====SHOW COMMENTS====");
		int position = getPosition("Enter a number of item in list: ");
        Item item = tracker.getAllItems()[position];
		System.out.println(item);
		for(Comment comment : item.getComments())
			System.out.println(comment);
	}
	
	/**
		Help method for action with user and compute position of the item
	*/
	private int getPosition(String question) {
		String numberItem = input.ask(question);
		return Integer.valueOf(numberItem) - 1;
	}
	
	/**
		Show menu for user
	*/
	private void showMenu() {
		System.out.println("1.Add new item");
		System.out.println("2.Remove item");
		System.out.println("3.Editing item");
		System.out.println("4.Add comment");
		System.out.println("5.Show comments");
		System.out.println("6.Exit");
	}
}