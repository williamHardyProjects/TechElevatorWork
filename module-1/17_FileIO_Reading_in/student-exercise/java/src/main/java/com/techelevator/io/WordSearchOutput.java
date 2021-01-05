package com.techelevator.io;

import java.util.Map;

public class WordSearchOutput {
	public static void displayLinesFound(Map<Integer, String> lines) {
		if (lines.isEmpty()) {
			System.out.println("word not found!");
		}else {
			for (Map.Entry<Integer, String> entry: lines.entrySet()) {
				System.out.println(entry.getKey() + ") " + entry.getValue());
			}
		}
	}
}
