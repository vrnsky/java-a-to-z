package ru.evrnsky.chapter2.start;

import ru.evrnsky.chapter2.models.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
	Unit test of MenuTracker.java
*/
public class MenuTrackerTest {
	
	//id of command for menu tracker, which type all items from tracker
	private static final int SHOW_ALL_ITEMS = 2;
	
	/**
		When we show user menu it must correct menu
	*/
	@Test
	public void whenWeShowUserMenuShouldShowCorrectMenu(){
		
		//Assign block
		String[] answer = new String[]{""}; //In this test answer from stub not use
		StubIO stubIO = new StubIO(answer);
		MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
		String expected = "0. Add a new item\n1. Remove item\n2. Show all items\n3. Edit item\n4. Comment item\n5. Show comments\n6. Search by text data\n7. Search by time\n";
		
		//Act block
		menuTracker.fillActions();
		menuTracker.show();
		
		//Action block
		assertThat(stubIO.getOut(), is(expected));
	}
	
	/**
		When try add item to tracker across menu tracker should add item to tracker
	*/
	@Test
	public void whenTryAddItemToTrackerUseMenuTrackerShouldAddItem(){
		
		/** Assing block
			Which command will execute - see variable answer:
			0 - key for add operation
			It is my first item - name of item
			Item - description for item
		*/
		String[] answer = new String[]{"0","It is my first", "Item"};
		StubIO stubIO = new StubIO(answer);
		MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
		String expected = "Name:It is my first\nDesc:Item\n";
		
		//Act block
		menuTracker.fillActions();
		String command = stubIO.ask("Type a command for Tracker: ");
		int comm = Integer.valueOf(command);
		menuTracker.select(comm);
		menuTracker.select(SHOW_ALL_ITEMS);
		
		//Act block
		assertThat(stubIO.getOut(), containsString(expected));
	}
	
	/**
		When try remove item from tracker across menu tracker should remove item from tracker
	*/
	@Test
	public void whenTryRemoveItemFromTrackerShouldRemoveItemFromTracker(){
		
		/** Assign block
			Which command will execute - see variable answer
			0 - key for add operation
			It is my second item - name for item
			Item - description for item
			1 - key for remove operation
			1 - position of items which will remove
		*/
		String[] answer = new String[]{"0", "It is my second item", "Item","1","1","y"};
		StubIO stubIO = new StubIO(answer);
		MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
		String expected = "";
		
		//Act block
		menuTracker.fillActions();
		int start = menuTracker.getIdFirstCommand();
		int finish = menuTracker.getIdLastCommand();
		int comm = stubIO.ask("Type a command for Tracker: ", start, finish);
		menuTracker.select(comm);
		comm = stubIO.ask("Type a command for Tracker: ", start, finish);
		menuTracker.select(comm);
		menuTracker.select(SHOW_ALL_ITEMS);
		
		//Action block
		assertThat(stubIO.getOut(), is(expected));		
	}

	/**
		When try edit item in tracker across menu tracker should edited item
		And update in tracker. It is checking by show all items in tracker
	*/
	@Test
	public void whenTryToEditItemFromTrackerShouldEditedAndReturnToTrackerItem(){
		
		/** Assign block
			Which command will execute - see variable answer:
			0 - key for add operation
			It is my third item - name for item
			Item - description for item
			3 - key for editing operation
			1 - position of editing items in list, which show user
			Update - new name for item
			Update - new description for item
		*/
		String[] answer = new String[]{"0","It is my third item", "Item", "3","1", "Update", "Update item"};
		StubIO stubIO = new StubIO(answer);
		MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
		String expected = "Name:Update\nDesc:Update item\n";
		
		//Act block
		menuTracker.fillActions();
		int command = Integer.valueOf(stubIO.ask("Type a command for Tracker: "));
		menuTracker.select(command);
		command = Integer.valueOf(stubIO.ask("Type a command for Tracker: "));
		menuTracker.select(command);
		menuTracker.select(SHOW_ALL_ITEMS);
		
		//Action block
		assertThat(stubIO.getOut(), containsString(expected));
	}
	
	/**
		When try to comment item should execute command and check that it is success
		Check by show comment for item
	*/
	@Test
	public void whenTryCommentItemShouldCommentItemAndSaveToTracker() {
		
		/** Assign block
			Which command will execute - see variable answer:
			0 - key for add operation
			First item - name for item
			First desc - description for item
			4 - key for commenting operation
			1 - position of editing items in list, which show user
			It is my first comment - comment for item
			5 - key for show comments operation
			1 - position of item in list which show user
		*/
		String[] answer = new String[]{"0", "First item", "First desc", "4","1","It is my first comment","5","1"};
		StubIO stubIO = new StubIO(answer);
		MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
		String expected = "Comment: It is my first comment\n";
		
		//Act block
		menuTracker.fillActions();
		int command = Integer.valueOf(stubIO.ask("Type a command for Tracker: "));
		menuTracker.select(command);
		command = Integer.valueOf(stubIO.ask("Type a command for Tracker: "));
		menuTracker.select(command);
		command = Integer.valueOf(stubIO.ask("Type a command for Tracker: "));
		menuTracker.select(command);
		
		//Action block
		assertThat(stubIO.getOut(), is(expected));
	}
	
	/**
		When try to get items filtered by text data should
		show all item which contains string given text data
	*/
	@Test
	public void whenTryGetItemsFilteredByTextDataShouldShowItemsWithGivenTextData() {
		
		/** Assign block
			Which command will execute - see variable answer:
			0 - key for add operation
			Item for search - name for item
			Please, find me - description for item
			6 - key for find by text operation
			find - text for search
		*/
		String[] answer = new String[]{"0", "Item for search", "Please, find me!", "6", "find"};
		StubIO stubIO = new StubIO(answer);
		MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
		String expected = "find me";
		
		//Act block
		menuTracker.fillActions();
		int command = Integer.valueOf(stubIO.ask("Type a command for Tracker: "));
		menuTracker.select(command);
		command = Integer.valueOf(stubIO.ask("Type a command for Tracker: "));
		menuTracker.select(6);
		
		//Action block
		assertThat(stubIO.getOut(), containsString(expected));
	}
	
	/**
		When try get items filtered by time should
		Show items with given time
	*/
	@Test
	public void whenTryGetItemsFilteredByTimeShouldShowItemsWithGivenTime() {
		
		/** Assign block
			Which command will execute - see variable answer:
			0 - key for add operation
			Time item - name for item
			Time item - description for item
			7 - key for find by time operation
			1 - time for user
		*/
		String[] answer = new String[]{"0", "Time item", "Time item", "7", "1"};
		StubIO stubIO = new StubIO(answer);
		MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
		String expected = "Time item";
		
		//Act block
		menuTracker.fillActions();
		int command = Integer.valueOf(stubIO.ask("Type a command for tracker: "));
		menuTracker.select(command);
		command = Integer.valueOf(stubIO.ask("Type a command for tracker: "));
		menuTracker.select(command);
		
		//Act block
		assertThat(stubIO.getOut(), containsString(expected));
	}
	
	/**
		When try get id of first command should return id of first command
	*/
	@Test
	public void whenTryGetIdFirstCommandShouldReturnIdOfFirstCommand() {
		
		//Assign block
		String[] answer = new String[] {"Answer"};
		StubIO stubIO = new StubIO(answer);
		MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
		int expected = 0;
		
		//Act block
		menuTracker.fillActions();
		int actual = menuTracker.getIdFirstCommand();
		
		//Action block
		assertThat(actual, is(expected));
	}
	
	/**
		When try get id of last command should return id of last command
	*/
	@Test
	public void whenTryGetIdLastCommandShouldReturnIdOfLastCommand() {
		String[] answer = new String[]{"answer"};
		StubIO stubIO = new StubIO(answer);
		MenuTracker menuTracker = new MenuTracker(stubIO, new Tracker());
		int expected = 7;
		
		menuTracker.fillActions();
		int actual = menuTracker.getIdLastCommand();
		
		assertThat(actual, is(expected));
	}
}