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
	private String userCommand = "";
	
	public StartUI(IO io) {
		this.io = io;
		tracker = new Tracker();
	}
	/**
		Entry point of application
	*/
	public static void main(String[] args) {
		new StartUI(new ConsoleIO(new Scanner(System.in),System.out)).init();		
	}
	
	/**
		At this method user choose command and app execute it
	*/
	public void init() {
		Tracker tracker = new Tracker();
		MenuTracker menuTracker = new MenuTracker(this.io, this.tracker);
		menuTracker.fillActions();
		
		do {
			menuTracker.show();
			int key = Integer.valueOf(io.ask("Type a command: "));
			menuTracker.select(key);
		} while (!"y".equals(io.ask("Exit(y): ")));
	}
}