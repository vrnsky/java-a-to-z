package start;


import models.*;

/**
* This class uses for interacting with user and execute command from his
*/
public class MenuTracker {

	/**
	 * Instance of API Tracker.
	 */
	private Tracker tracker;
	/**
	 * Instance of IO system for handle input and show data to user.
	 */
	private IO io;

	/**
	 * Actions which do user.
	 */
	private UserAction[] actions = new UserAction[8];

	/**
	 * For correct add new action in actions array should use pointer.
	 */
	int position = 0;
	
	/**
	* Constructor for this class.
	* @param io  implement of input/output interface.
	* @param tracker  instance of tracker API.
	*/
	public MenuTracker(IO io, Tracker tracker){
		this.tracker = tracker;
		this.io = io;
	}
	
	/**
	* Fill actions array by creating new instance of actions
	* and fill array ranges for correct using menu.
	*/
	public void fillActions(){
		actions[position++] = new AddItem("Add a new item");
		actions[position++] = new RemoveItem("Remove item");
		actions[position++] = new ShowAllItems("Show all items");
		actions[position++] = new EditItem("Edit item");
		actions[position++] = new CommentItem("Comment item");
		actions[position++] = new ShowComments("Show comments");
		actions[position++] = new FilteringByTextData("Search by text data");
		actions[position++] = new FilteringByTime("Search by time");
	}
	
	/**
	* In near future will be add feature for adding
	* your actions to actions array. Now this N/A for correct working.
	* Don't use this!
	* @param  action  it is kid of BaseAction class
	*/
	public void addAction(BaseAction action) {
		actions[position++] = action;
	}
	
	/**
	* This method select a action from array and call from action method execute.
	*/
	public void select(int key){
		this.actions[key].execute(io, tracker);
	}
	
	/**
	* Return id of first not null action.
	* @return position of first command in actions array.
	*/
	public int getIdFirstCommand() {
		int result = -1;
		for(int index = 0; index != actions.length; index++) {
			if(actions[index] != null) {
				result = index;
				break;
			}
		}
		return result;
	}
	
	/**
	* Return id of last not null action.
	* @return - it is last not null action in array actions.
	*/
	public int getIdLastCommand() {
		int result = -1;
		for(int index = actions.length-1; index >= 0; index--) {
			if(actions[index] != null) {
				result = index;
				break;
			}
		}
		return result;
	}
	
	
	/**
	* This method using for show user all possible action.
	*/
	public void show(){
		for(UserAction act : actions) {
			if(act != null)
				io.println(act.info());
		}
	}
	
	/**
	*	Implementation of adding item.
	*/
	private class AddItem extends BaseAction {
	
		/**
		* Init new action by calling constructor from parent.
		* @param name it is name of action.
		*/
		AddItem(String name) {
			super(name);
		}
		
		/**
		* Use for determine position in actions array.
		* @return position in the actions array.
		*/
		public int key(){
			return 0;
		}
		
		/**
		* Execute command from user by interacting with him
		* And ask about item which will added to tracker.
		* @param io  implementation of input/output interface.
		* @param tracker instance of Tracker API.
		*/
		public	void execute(IO io, Tracker tracker) {
			String name = io.ask("Enter a name of the new item: ");
			String description = io.ask("Enter a description of the new item: ");
			tracker.addItem(new Item(name, description));
		}
		
	}
	
	/**
	* Implement of remove option.
	*/
	private class RemoveItem extends BaseAction {
		
		/**
		*	Init a new action - remove item
		*	@param  name name of action.
		*/
		RemoveItem(String name) {
			super(name);
		}
		
		/**
		* Use for determine position in actions array.
		* @return position in the actions array.
		*/
		public int key(){
			return 1;
		}
		
		/**
		* Execute a remove item command. Ask user about number of item
		* in list. Try find it item and if found remove from tracker
		* Otherwise show user message about tracker was empty or user choose wrong number.
		* @param io implementation of input/output interface.
		* @param tracker  instance of Tracker API.
		*/
		@Override
		public void execute(IO io, Tracker tracker){
			int start = tracker.getStart();
			int finish = tracker.getFinish();
			Item[] items = tracker.getAllItems();
			if(items.length == 0) {io.println("Nothing to delete!"); return; }
			int position = io.ask("Type a number of item in list: ", start, finish);
			Item removeItem = items[position-1];
			tracker.removeItem(removeItem.getId());
		}
		
	}

	/**
	 * Implementation of show all items action.
	 */
	private class ShowAllItems extends BaseAction {
		
		
		/**
		*	Init a new action - it is show all items action
		*	@param: String name - it string for naming this action
		*/
		ShowAllItems(String name) {
			super(name);
		}
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
	}
	
	/**
		Implementation of edit item option
	*/
	private class EditItem extends BaseAction {
		
		/**
			Init a new action by calling constructor from the parent
			@param: String name - it is name of action
		*/
		EditItem(String name) {
			super(name);
		}
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
	
		public int key(){
			return 3;
		}
		
		/**
			Ask user about number of item in list and try find item.
			If item was found try edit item, otherwise return and show user about problem
			Further find item and edit by set new name and description
			@param: io - implementation of input/output interface
					tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker) {
			Item[] items = tracker.getAllItems();
			if(items.length == 0) { io.println("Nothing to edit!"); return; }
			int start = tracker.getStart();
			int finish = tracker.getFinish();
			int position = io.ask("Enter a number of item in list: ", start, finish);
			Item item = items[position-1];
			item.setName(io.ask("Type new name for item :"));
			item.setDescription(io.ask("Type new description: "));
			tracker.editItem(item);
		}
	}
	
	/**
		Implementation of commenting option
	*/
	private class CommentItem extends BaseAction {
		
		/**
			Init a new action comment item by calling constructor from the parent
			@param: String name - it is name of action
		*/
		CommentItem(String name) {
			super(name);
		}
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
		public int key(){
			return 4;
		}
		
		/**
			Ask user about item and try find it, if not found return. 
			Further attach comments about item to the item
			@param:io - implementation of input/output interface
				   tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker) {
			Item[] items = tracker.getAllItems();
			if(items.length == 0) {io.println("Nothing to comment!"); return; }
			int start = tracker.getStart();
			int finish = tracker.getFinish();
			int position = io.ask("Enter a number of item in list", start, finish);
			Item item = items[position-1];
			tracker.addComment(item, new Comment(io.ask("Enter your comment for item: ")));
		}
	}
	
	/**
		Implementation of show comments options
	*/
	private class ShowComments extends BaseAction {
		
		/**
			Init a new action - show comments by calling constructor from the parent
			@param: String name - it is name of action
		*/
		ShowComments(String name) {
			super(name);
		}
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
		public int key(){
			return 5;
		}
		
		/**
			Ask user about item and try find it if not found return. 
			Further show comment for this item
			@param: io - implementation of input/output interface
					tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker) {
			Item[] items = tracker.getAllItems();
			if(items.length == 0) { io.println("Nothing to show, item list is empty!"); return; }
			int start = tracker.getStart();
			int finish = tracker.getFinish();
			int position = io.ask("Choose item to show comments: ", start, finish);
			Item item = tracker.getAllItems()[position-1];
			for(Comment comment : item.getComments())
				io.println(comment);
		}
	}
	
	/**
		Implement of filtering by text data option
	*/
	private class FilteringByTextData extends BaseAction {
		
		/**
			Init a new action - filtering by text data by calling constructor from the parent
			@param: String name - it is name for action
		*/
		FilteringByTextData(String name) {
			super(name);
		}
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
			if(result.length == 0) { io.println("Items with given text not found!"); return;}
			for(Item item : result) {
				if(item != null) {
				io.println(item);
				}
			}
		}
	}
	
	private class FilteringByTime extends BaseAction {
		
		/**
			Init a new action - filtering by time by calling constructor from the parent
			@param: String name - it is name of action
		*/
		FilteringByTime(String name) {
			super(name);
		}
		/**
			Use for determine position in actions array
			@param: int - position in the actions array
		*/
		public int key(){
			return 7;
		}
		
		/**
			Ask user about time of item which he want find and try to find it
			@param: io - implementation of input/output interface
					tracker - instance of Tracker API
		*/
		@Override
		public void execute(IO io, Tracker tracker){
			long time = io.askForLong("Enter a time for search");
			Item[] result = tracker.getItemsFilteredByTime(time);
			if(result.length == 0) { io.println("Items with given time not found!"); return; }
			for(Item item : result)
				io.println(item);
		}
		
	}
	
}