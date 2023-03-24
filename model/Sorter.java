package model;

import java.util.ArrayList;
import java.util.Collections;

public class Sorter {

	ArrayList<String> lines;
	ArrayList<String> sortedList = new ArrayList<>();
	char[] alphabet = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P','q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z'};
	public Sorter () {}

	public ArrayList<String> sortOutput(ArrayList<String> lines) {
		//ascii a-z = 97-122
		//ascii A-Z = 65-90
		this.lines = lines;
		Collections.sort(lines);

		for(var c : alphabet) {
			for(var l : lines) {
				if(l.charAt(0) == c) {
					sortedList.add(l);
				}
			}
		}
		return sortedList;
	}
}