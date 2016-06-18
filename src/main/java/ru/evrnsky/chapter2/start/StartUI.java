package ru.evrnsky.chapter2.start;

import ru.evrnsky.chapter2.models.*;
import java.util.Scanner;

/**
	At this class look all opportunity API Tracker
*/

public class StartUI
{
	private IO io;
	private Tracker tracker;
	
	public StartUI(IO io) {
		this.io = io;
		tracker = new Tracker();
	}
	/**
		Entry point of application
	*/
	public static void main(String[] args) {
		new StartUI(new Validator()).init();		
	}
	
	/**
		At this method user choose command and app execute it
	*/
	public void init() {
		MenuTracker menuTracker = new MenuTracker(this.io, this.tracker);
		menuTracker.fillActions();
		int start = menuTracker.getIdFirstCommand();
		int finish = menuTracker.getIdLastCommand();
		
		do {
			menuTracker.show();
			int key = io.ask("Type a command: ", start, finish);
			menuTracker.select(key);
		} while (!"y".equals(io.ask("Exit(y): ")));
	}
}