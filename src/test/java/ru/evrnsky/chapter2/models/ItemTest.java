package ru.evrnsky.chapter2.models;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;

/**
	Unit test for Item
*/
public class ItemTest {


	/**
		When create item should check it is not null
	*/
	@Test
	public void whenCreateItemShouldCheckItIsNotNull() {
		
		//Assign block
		Item item = new Item("It is my first item", "It is my first item");
		boolean expected = true;
		
		//Act block
		boolean actual = item != null;
		
		//Assign block
		assertThat(actual, is(expected));
	}
	
	/**
		When create item should check the name of item saved
	*/
	@Test
	public void whenCreateItemShouldCheckItemSaveData() {
		
		//Assign block
		Item item = new Item("first item", "It is my first item");
		String expected = "first item";
		
		//Act block
		String actual = item.getName();
		
		//Action block
		assertThat(actual, is(expected));
	}
	
	/**
		When create item should check the desc is saved
	*/
	@Test 
	public void whenCreateItemShouldCheckItemSaveDescription() {
		
		//Assign block
		Item item = new Item("asd", "item");
		String expected = "item";
		
		//Act block
		String actual = item.getDescription();
		
		//Action block
		assertThat(actual, is(expected));
	}
	
	/**
		When update itme shoud check item saved
	*/
	@Test
	public void whenUpdateItemNameShouldCheckItSaved() {
		
		//Assign block
		Item item = new Item();
		String expected = "It is name";
		
		//Act block
		item.setName("It is name");
		String actual = item.getName();
		
		//Action block
		assertThat(actual, is(expected));
	}
	
	/**
		When update item description should check it saved
	*/
	@Test
	public void whenUpdateItemDescShouldCheckItSaved() {
		
		//Assign block
		Item item = new Item();
		String expected = "It is desc";
		
		//Act block
		item.setDescription("It is desc");
		String actual = item.getDescription();
		
		//Action block
		assertThat(actual, is(expected));
	}
	
	/**
		When create item should check than generateTime works correct
	*/
	@Test
	public void whenCreateItemShouldCheckTimeOfCreateCorrect() {
		
		//Assign block
		Item item = new Item();
		boolean expected = true;
		
		//Act block
		long time = item.getCreateTime();
		boolean actual = time > 1L;
		
		//Action block
		assertThat(actual, is(expected));
	}
	
	/**
		When try attach comment to item should check the comment is saved
	*/
	@Test
	public void whenTryAttachCommentToItemShouldCheckCommentSave() {
		
		//Assign block
		Item item = new Item();
		Comment comm = new Comment("It is my first comment:");
		String expected = "Comment: It is my first comment:";
		
		//Act block
		item.addComment(comm);
		Comment actual = item.getComments()[0];
		
		//Action block
		assertThat(actual.toString(), is(expected));
	}
	
	
}