package com.techelevator;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import com.techelevator.io.IOResources;


public class WordSearch {
	private String searchWord;
	private File filePath;
	private Map<Integer, String> linesFound = new HashMap<Integer, String>();
	private Boolean ranSearch = false;

	public WordSearch(String searchWord, File filePath) {
		this.searchWord = searchWord;
		this.filePath = filePath;
	}
	
	public String getSearchWord() {
		return searchWord;
	}
	
	public File getFilePath() {
		return filePath;
	}
	
	public Map<Integer, String> getLinesFound(boolean isCaseSensitive) {
		
		if (ranSearch) {
			return linesFound;
		}else {
			if (filePath != null ) {
				int lineNumber = 0;
				String line;
				
				Scanner in = IOResources.getScannerFileInput(filePath);
				
				while(in.hasNextLine()) {
					lineNumber++;
					line = in.nextLine();
					
					if (!isCaseSensitive) {
						if (line.toLowerCase().contains(searchWord.toLowerCase())) {
							linesFound.put(lineNumber, line);
						}
		
					}else {
						if (line.contains(searchWord)) {
							linesFound.put(lineNumber, line);
						}
					}
					
				}
				ranSearch = true;
				return linesFound;
			}
			
		}
		
		return linesFound;
	}
}			