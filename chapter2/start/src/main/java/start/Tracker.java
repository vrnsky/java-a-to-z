package start;

import models.*;

/**
	Implementation of tracker application
	In this class implement all functionality of tracker: add, remove, edit and commenting
*/
public class Tracker
{
	
	private Item[] items;
	private int position;
	
	/**
		Default constructor for tracker
		Create tracker app with 10 empty items
	*/
	public Tracker()
	{
		this(10);
	}
	
	/**
		Constructor for tracker
		@param: size - size of items array
	*/
	public Tracker(int size)
	{
		items = new Item[size];
		position = 0;
	}
	
	/**
		Add item to items array
		@param:item - it is ready for adding object, it is also may be bug or task
		@return:item - it is given item
	*/
	public Item addItem(Item item)
	{
		items[position++] = item;
		return item;
	}
	
	/**
		Remove item from items array by set null at the array cell
		@param: String itemId - it is unique string for each item
	    @return: item - it is removed item
	*/
	public Item removeItem(String itemId)
	{
		Item removed = findById(itemId);
		for(int index = 0; index < items.length; index++) {
			if(items[index] != null) {
				if(items[index].getId().equals(removed.getId()))
					items[index] = null;
			}
		}
		//update list item
		position = updateItemsList();
		return removed;
	}
	
	/**
		This method move element in items array by collect not null element at the left
		And null elements to the right. And return new position - it is first null after not null value
		@return: int position - it is correct position for insert new elem
	*/
	private int updateItemsList() {
		for(int index = 0; index < items.length; index++) {
			for(int barrier = index + 1; barrier < items.length; barrier++) {
				if(items[index] == null && items[barrier] != null) {
					items[index] = items[barrier];
					items[barrier] = null;
				}
			}
		}
		
		int result = 0;
		while(items[result] != null) {
			result++;
		}
		
		return result;
	}
	
	/**
		Find item which id is equals for given string
		@param: findId - it is id for searching
		@return: Item - it is item which id equals findId, if item not found return null
	*/
	protected Item findById(String findId)
	{
		Item result = null;
		for(Item item : items) {
			if(item != null) {
				if(item.getId().equals(findId))
					result = item;
			}
		}
		return result;
	}
	
	/**
		Edit item by set name and desc given parameters
		@params: Item item - item which need update
		@return: Item item - update item
	*/
	public Item editItem(Item item)
	{
		update(item);
		return item;
	}

	/**
	 * Find item in array and set given item
	 * @param item - this will set at its place
     */
	private void update(Item item)
	{
		for(int index = 0; index < items.length; index++) {
			if(items[index] != null) {
				if(items[index].getId().equals(item.getId()))
					items[index] = item;
			}
		}
	}
	
	/**
		Return all items which not null of tracker
		@return: Item[] - it is all items
	*/
	public Item[] getAllItems()
	{
		int size = 0;
		Item[] result;
		for(int index = 0; index != items.length; index++) {
			if(items[index] != null)
				size++;
		}
		
		int startPosition = 0;
		int index = 0;
		result = new Item[size];
		while(index < items.length && startPosition < size) {
			Item current = items[index];
			if(current != null) {
				result[startPosition] = current;
				startPosition++;
			}
			index++;
		}
		
		return result;
	}
	
	/**
		Return all items which name or description contain given string
		@return Item[] - it is array of item which name or description contain given string
	*/
	public Item[] getItemsFilteredByText(String find)
	{
		Item[] result = null;
		int size = 0;
		
		for(Item item : items) {
			if(item != null) {
				if(item.getName().contains(find) || item.getDescription().contains(find))
					size++;
			}
		}

		result = new Item[size];

		int startPosition = 0;
		int index = 0;
		while(index < items.length && startPosition < size) {
			Item current = items[index];
			if(current != null) {
				if(current.getName().contains(find) || current.getDescription().contains(find)) {
					result[startPosition] = current;
					startPosition++;
				}
			}
			index++;
		}
		
		return result;
	}
	
	/**
		Return array of items which were created after given time
		@params: long createTime - it is time for searching items
		@return: items which be created after create time given in params
	*/
	public Item[] getItemsFilteredByTime(long createTime)
	{
		Item[] result = null;
		int size = 0;
		
		for(Item item : items) {
			if(item != null) {
				if(item.getCreateTime() > createTime)
					size++;
			}
		}
		
		result = new Item[size];
		
		for(int index = 0; index < size; index++) {
			
			Item current = items[index];
			if(current != null) {
				if(current.getCreateTime() > createTime)
					result[index] = current;
			}
		}
		
		return result;
	}
	
	/**
		Add comment to item
		@param:comment - it comment which will be added
		@return: comment - it is given comment
	*/
	public Comment addComment(Item item, Comment comment) {
		
		String id = item.getId();
		for(int index = 0; index < items.length; index++) {
			if(items[index] != null) {
				if(items[index].getId().equals(id))
					items[index].addComment(comment);
			}
		}

		return comment;
	}
	
	/**
		Return array of comment for current item
		@return: Comment[] it is array of all not null comments
	*/
	public Comment[] getComments(Item item) {
		return item.getComments();
	}
	
	/**
		Return a position first position
		@return: int position - first element in array
	*/
	public int getStart() {
		return 0;
	}
	
	/**
		Return position - place which must insert new element
		@return: position of last not null item
	*/
	public int getFinish() {
		return position;
	}
	
}