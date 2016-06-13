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
		Tracker tracker = new Tracker();
		MenuTracker menuTracker = new MenuTracker(this.input, tracker);
		menuTracker.fillActions();
		
		do {
			menuTracker.show();
			int key = Integer.valueOf(input.ask("Type a command: "));
			menuTracker.select(key);
		} while (!"y".equals(input.ask("Exit(y): ")));
	}
}