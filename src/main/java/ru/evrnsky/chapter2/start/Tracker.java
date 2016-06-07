package ru.evrnsky.chapter2.start;

import ru.evrnsky.chapter2.models.*;

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
	    @return: item - it is removed item
	*/
	public Item removeItem()
	{
		Item result = items[position];
		items[position--] = null;
		return result;
	}
	
	/**
		Find item which id is equals for given string
		@param: findId - it is id for searching
		@return: Item - it is item which id equals findId, if item not found return null
	*/
	private Item findById(String findId)
	{
		Item result = null;
		for(Item item : items)
		{
			if(item.getId().equals(findId))
				result = item;
		}
		
		return result;
	}
	
	/**
		Edit item by set name and desc given parameters
		@params: String name - it is new name of item
				 String desc - it is new description of item
		@return: Item item - edited item
	*/
	public Item editItem(String name, String desc)
	{
		Item item = items[--position];
		item.setName(name);
		item.setDescription(desc);
		return item;
	}
	
	/**
		Return all items of tracker
		@return: Item[] - it is all items
	*/
	public Item[] getAllItems()
	{
		return items;
	}
	
	/**
		Return all items which name or description contain given string
		@return Item[] - it is array of item which name or description contain given string
	*/
	public Item[] getItemsFilteredByText(String find)
	{
		Item[] result = null;
		int size = 0;
		
		for(Item item : items)
		{
			if(item != null)
			{
				if(item.getName().contains(find) || item.getDescription().contains(find))
					size++;
			}
		}

		result = new Item[size];
		for(int index = 0; index < size; index++)
		{
			Item current = items[index];
			if(current != null)
			{
				if(current.getName().contains(find) || current.getDescription().contains(find))
					result[index] = current;
			}
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
		
		for(Item item : items)
		{
			if(item != null)
			{
				if(item.getCreateTime() > createTime)
					size++;
			}
		}
		
		result = new Item[size];
		
		for(int index = 0; index < size; index++)
		{
			Item current = items[index];
			if(current != null)
			{
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
	public Comment addComment(Comment comment)
	{
		items[--position].addComment(comment);
		return comment;
	}
	
	/**
		Return array of comment for current item
		@return: Comment[] it is array of all not null comments
	*/
	public Comment[] getComments()
	{
		return items[position].getComments();
	}
	
}