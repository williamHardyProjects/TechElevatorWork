package com.techelevator.app;
import com.techelevator.WordSearch;
import java.io.File;
import java.util.Map;

import com.techelevator.io.IOResources;
import com.techelevator.io.WordSearchInput;
import com.techelevator.io.WordSearchOutput;

public class WordSearchApp {
	public static void run() {
		
		String searchWord = WordSearchInput.getSearchWord("What is the search word you are looking for?");
		String caseSensitive = WordSearchInput.getSearchWord("Should the search be case sensitive? (Y\\N)");
		File filePath = WordSearchInput.getFilePath();
		boolean isCaseSensitive = false;
		if (caseSensitive.equalsIgnoreCase("y")) {
			isCaseSensitive = true;
		}
		if (filePath != null && searchWord.length() > 0) {
			WordSearch wordSearch = new WordSearch(searchWord, filePath);
			Map<Integer, String> lines = wordSearch.getLinesFound(isCaseSensitive);
			
			WordSearchOutput.displayLinesFound(lines);
		}
		
		IOResources.closeScannerInput();
	}
}
