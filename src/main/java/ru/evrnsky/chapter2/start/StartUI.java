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
		Tracker tracker = new Tracker(10);
		StartUI userInterface = new StartUI();
		Item addFeatures = new Item("Development", "Add new features");
		Item startNewProject = new Item("Launch new Java Project", "Keep your mind");
		Item customerChanges = new Item("Customer send changes", "Add more function");

		System.out.println("=================ADDING NEW ITEMS====================");
		tracker.addItem(addFeatures);
		tracker.addItem(startNewProject);
		tracker.addItem(customerChanges);
		userInterface.showAllItem(tracker.getAllItems());

		System.out.println("=================REMOVING ITEMS========================");
		tracker.removeItem(addFeatures.getId());
		userInterface.showAllItem(tracker.getAllItems());

		System.out.println("=================EDITING ITEMS==========================");
		startNewProject.setName("You win!");
		startNewProject.setDescription("This ticket is edited");
		tracker.editItem(addFeatures);
		userInterface.showAllItem(tracker.getAllItems());

		System.out.println("=================COMMENT ITEMS===========================");
		tracker.addComment(startNewProject, new Comment("value"));
		userInterface.showComment(tracker.getComments(startNewProject));


		System.out.println("=================FILTERING BY TEXT DATA===================");
		userInterface.showAllItem(tracker.getItemsFilteredByText("win"));

		System.out.println("=================FILTERING BY TIME=========================");
		userInterface.showAllItem(tracker.getItemsFilteredByTime(1L));
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