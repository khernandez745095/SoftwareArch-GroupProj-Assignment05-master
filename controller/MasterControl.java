package controller;

import model.Cycler;
import model.Sorter;
import view.ConsoleWindow;

public class MasterControl {
	Cycler cycler = new Cycler();
	Sorter sorter = new Sorter();
	ConsoleWindow window;

	MasterControl(ConsoleWindow window){
		this.window = window;
	}

	public void init() {
		window.init();
	}
	
	
}
