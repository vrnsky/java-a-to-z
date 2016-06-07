package ru.evrnsky.chapter2.start;

import ru.evrnsky.chapter2.models.*;

/*
	At this class look all opportunity API Tracker
*/

public class StartUI
{
	/**
		Entry point of application
	*/
	public static void main(String[] args)
	{
		//Creata an instance of tracker for using its API
		Tracker tracker = new Tracker();
		Item[] allItems = tracker.getAllItems();
		StartUI userInterface = new StartUI();
		
		//Use addItem method for adding to tracker items, bugs or tasks
		System.out.println("==============ADDING NEW ITEM, BUG OR TASK TO TRACKER");
		tracker.addItem(new Item("Add new feature", "Develop new feature"));
		tracker.addItem(new Task("Pass the project", "Customer sent changes"));
		tracker.addItem(new Item("Serious bug", "Float bug"));
		userInterface.showAllItem(allItems);
		System.out.println("=============END OPERATION================");
		System.out.println();
		
		//Use editItem for editing elemenent in tracker
		System.out.println("==============EDITING ITEMS===================");
		tracker.editItem("Test new function", "Check new function");
		userInterface.showAllItem(allItems);
		System.out.println("==============END OPERATION===============");
		System.out.println();
		
		//Use removeItem for remove item from tracker
		System.out.println("==============REMOVE ITEM=================");
		tracker.removeItem();
		userInterface.showAllItem(allItems);
		System.out.println("==============END OPERATION===============");
		System.out.println();
		
		//Use getItemsFilteredByText for find all items which contains text in name OR description
		System.out.println("==============FIND ITEM WHICH CONTAINS SOME TEXT DATA");
		Item[] filteredByText = tracker.getItemsFilteredByText("feature");
		userInterface.showAllItem(filteredByText);
		System.out.println("==============END OPERATION=======================");
		System.out.println();
		
		//Use getItemsFilteredByTime for find all items which were created after given time
		System.out.println("=============FIND ITEM WHICH CREATED AFTER SOME TIME");
		Item[] filteredByTime = tracker.getItemsFilteredByTime(1L);
		userInterface.showAllItem(filteredByTime);
		System.out.println("=============END OPERATION========================");
		System.out.println();
		
		//Use addComment method for adding comment to last item
		System.out.println("=============COMMENT=====================");
		tracker.addComment(new Comment("Cutomer require new feature and bug fixes"));
		userInterface.showComment(tracker.getComments());
		
	}
	
	/*
		Helper method. Display information about items
		@params:items - will be display in console
		@see: method toString in Item.java
	*/
	private void showAllItem(Item[] items)
	{
		for(Item item : items)
		{
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