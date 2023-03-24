package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cycler {

	public Cycler() {}

	public ArrayList<String> cycle(ArrayList<String> lines) {
		//String temp = "";
		ArrayList<String> cycledLines = new ArrayList<>();
		ArrayList<String> wordsInLine = new ArrayList<>();
		// split lines into words in ArrayList
		for (var line : lines) {
			String[] words = line.split(" ", 0);
			List<String> wordsList = Arrays.asList(words);
			wordsInLine = new ArrayList<>(wordsList);
			//temp = wordsInLine.get(0);
			int count = wordsInLine.size();
			/* for (var a : wordsInLine) {
				System.out.println(a);
			} */
			// Cycle words in arrayList and add each new string to cycleLines arraylist
			int i = 0;
			while (i < count) {
				//System.out.println("inside cycler");
				cycledLines.add(String.join(" ", wordsInLine));
				Collections.rotate(wordsInLine, 1);
				i++;
			}
		}
		return cycledLines;
	}
}