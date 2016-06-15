package ru.evrnsky.chapter2.start;

import ru.evrnsky.chapter2.models.*;

/**
	This class uses for interacting with user and execute command from his
*/
public class MenuTracker {

	private Tracker tracker;
	private IO io;
	private UserAction[] actions = new UserAction[8];
	
	/**
		Constructor for this class
		@param: io - implement of input/output interface
				tracker - instance of tracker API
	*/
	public MenuTracker(IO io, Tracker tracker){
		this.tracker = tracker;
		this.io = io;
	}
	
	/**
		Fill actions array by creating new instance of actions
	*/
	public void fillActions(){
		actions[0] = new AddItem();
		actions[1] = new RemoveItem();
		actions[2] = new ShowAllItems();
		actions[3] = new EditItem();
		actions[4] = new CommentItem();
		actions[5] = new ShowComments();
		actions[6] = new FilteringByTextData();
		actions[7] = new FilteringByTime();
	}
	
	/**
		This method select a action from array and call from action method execute 
		It is give command to action
	*/
	public void select(int key){
		this.actions[key].execute(io, tracker);
	}
	
	/**
		This method using for show user all possible action
	*/
	public void show(){
		for(UserAction act : actions) {
			if(act != null)
				io.println(act.info());
		}
	}
	
	/**
		Implementation of adding item
	*/
	private class AddItem implements UserAction {
	
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
		public int key(){
			return 0;
		}
		
		/**
			Execute command from user by interacting with him
			And ask about item which will added to tracker
			@param: input - implementation of input/output interface
					tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker) {
			String name = io.ask("Enter a name of the new item: ");
			String description = io.ask("Enter a description of the new item: ");
			tracker.addItem(new Item(name, description));
		}
		
		/**
			Info about operation. Using for generate menu for user
			@return: String - info about information and his unique key
		*/
		public String info() {
			return String.format("%s. %s", this.key(), "Add a new item");
		}
	}
	
	/**
		Implement of remove option
	*/
	private class RemoveItem implements UserAction {
		
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
		public int key(){
			return 1;
		}
		
		/**
			Execute a remove item command. Ask user about number of item
			in list. Find it item and remove from tracker
			@param: input - implementation of input/output interface
					tracker - instace of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker){
			String number = io.ask("Enter a number of item in list");
			int position = Integer.valueOf(number);
			Item removeItem = tracker.getAllItems()[position-1];
			tracker.removeItem(removeItem.getId());
		}
		
		/**
			Info about operation. Using for generate menu for user
			@return: String - info about information and his unique key
		*/
		public String info() {
			return String.format("%s. %s", this.key(), "Remove item");
		}
	}
	
	private class ShowAllItems implements UserAction {
		
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/

		public int key(){
			return 2;			
		}
		
		/**
			Show all items in console
			@param: io - implement of input/output interface, in this method not use
					tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker) {
			for(Item item: tracker.getAllItems()){
				if(item != null)
					io.println(item);
			}
		}
		
		/**
			Info about operation. Using for generate menu for user
			@return: String - info about information and his unique key
		*/
		public String info(){
			return String.format("%s. %s", this.key(), "Show all items");
		}
	}
	
	/**
		Implementation of edit item option
	*/
	private class EditItem implements UserAction {
		
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
	
		public int key(){
			return 3;
		}
		
		/**
			Ask user about number of item in list.
			Further find item and edit by set new name and description
			@param: io - implementation of input/output interface
					tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker) {
			String number = io.ask("Enter a number of item in list: ");
			int position = Integer.valueOf(number);
			Item item = tracker.getAllItems()[position-1];
			item.setName(io.ask("Type new name for item :"));
			item.setDescription(io.ask("Type new description: "));
			tracker.editItem(item);
		}
		
		/**
			Info about operation. Using for generate menu for user
			@return: String - info about information and his unique key
		*/
		public String info(){
			return String.format("%s. %s", this.key(), "Edit item");
		}
	}
	
	/**
		Implementation of commenting option
	*/
	private class CommentItem implements UserAction {
		
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
		public int key(){
			return 4;
		}
		
		/**
			Ask user about item and find. Further show comments about item
			@param:io - implementation of input/output interface
				   tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker) {
			String number = io.ask("Enter a number of item in list: ");
			int position = Integer.valueOf(number);
			Item item = tracker.getAllItems()[position-1];
			tracker.addComment(item, new Comment(io.ask("Enter your comment for item: ")));
		}
		
		/**
			Info about operation. Using for generate menu for user
			@return: String - info about information and his unique key
		*/
		public String info(){
			return String.format("%s. %s", this.key(), "Comment item");
		}
	}
	
	/**
		Implementation of show comments options
	*/
	private class ShowComments implements UserAction {
		
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
		public int key(){
			return 5;
		}
		
		/**
			Ask user about item and find it. Further show comment for this item
			@param: io - implementation of input/output interface
					tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker) {
			String number = io.ask("Enter a number of item in list");
			int position = Integer.valueOf(number);
			Item item = tracker.getAllItems()[position-1];
			for(Comment comment : item.getComments())
				io.println(comment);
		}
		/**
			Info about operation. Using for generate menu for user
			@return: String - info about information and his unique key
		*/
		public String info(){
			return String.format("%s. %s", this.key(), "Show comments");
		}
	}
	
	/**
		Implement of filtering by text data option
	*/
	private class FilteringByTextData implements UserAction {
		
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
		public int key(){
			return 6;
		}
		
		/**
			Ask user about text which he want find and items and try to find items
			@param: io - implementation of input/output interface
					tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker){
			String search = io.ask("Enter a text for search: ");
			Item[] result = tracker.getItemsFilteredByText(search);
			for(Item item : result) {
				if(item != null) {
				io.println(item);
				}
			}
		}
		
		/**
			Info about operation. Using for generate menu for user
			@return: String - info about information and his unique key
		*/
		public String info(){
			return String.format("%s. %s", this.key(), "Search by text data");
		}
	}
	
	private class FilteringByTime implements UserAction {
		
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
		public int key(){
			return 7;
		}
		
		/**
			Ask user about time of item which he want find and try to find it
			@param: input - implementation of input/output interface
					tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker){
			String stringTime = io.ask("Enter a time for search: ");
			long time = Long.valueOf(stringTime);
			Item[] result = tracker.getItemsFilteredByTime(time);
			for(Item item : result)
				io.println(item);
		}
		
		/**
			Info about operation. Using for generate menu for user
			@return: String - info about information and his unique key
		*/
		public String info(){
			return String.format("%s. %s", this.key(), "Search by time");
		}
	}
	
}