package com.techelevator.io;

import java.util.Map;
import static java.util.Map.entry;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordSearchInput {
	public static String getSearchWord(String prompt) {
		
		Scanner in = IOResources.getScannerInput();
		while (true) {
			
			System.out.println(prompt);
			String searchWord = formatSearchInput(in.nextLine());
			
			Map<String, Object> checkSearch = checkSearchWord(searchWord);
			
			if ((Boolean) checkSearch.get("isValid")) {
				return searchWord;
			}else {
				
				System.out.println("Search word contained " + (String) checkSearch.get("error") + " which is invalid");
				System.out.println("Press C to [C]ontinue or E to [E]xit");
				
				String decision = formatSearchInput(in.nextLine());
				
				if (decision.toLowerCase().equals("c")) {
					continue;
				}else {
					break;
				}
			}
		}
		
		return "";
	}
	
	public static File getFilePath() {
		Scanner in = IOResources.getScannerInput();
		
		while (true) {
			System.out.println("What is the file that should be searched?");
			String fileName = formatSearchInput(in.nextLine());
			
			Map<String, Object> checkFile = checkSearchFile(fileName);
			File searchFile = (File) checkFile.get("searchFile");
			String error = (String) checkFile.get("errorMessage");
			
			if (error.equals("")) {
				return searchFile;
			}else {
				System.out.println(error);
				System.out.println("Press C to [C]ontinue or E to [E]xit");
				
				String decision = formatSearchInput(in.nextLine());
				if (decision.toLowerCase().equals("c")) {
					continue;
				}else {
					break;
				}
			}
		}
		return null;
	}
	
	public static Map<String, Object> checkSearchFile(String fileName) {
		
		File filePath = new File(fileName);
		Boolean fileExist = filePath.exists();
		Boolean canReadFile = filePath.canRead();
		Boolean isHidden = filePath.isHidden();
		String errorMessage = "";
		
		if (!fileExist) {
			errorMessage += "The file: " + filePath.getAbsolutePath() + " does not exist in this project ";
		}
		if (!canReadFile) {
			errorMessage += "You do not have permission to read this file ";
		}
		if (isHidden) {
			errorMessage += "You do not have permission to read this file ";
		}
		Map<String, Object> checkFileMap = Map.ofEntries(
				entry("searchFile", filePath),
				entry("errorMessage", errorMessage)
		);
		return checkFileMap;
	}
	
	public static String formatSearchInput(String searchWord) {
		return searchWord.trim();
	}
	
	public static Map<String, Object> checkSearchWord(String searchWord) {
		
		Pattern errorRegex = Pattern.compile("[^a-zA-Z]");
		Matcher match = errorRegex.matcher(searchWord);
		Boolean hasError = match.find();
		String error = "";
		
		if (hasError) {
			error = match.group();
		}
		 
		Map<String, Object> checkMap = Map.ofEntries(
				entry("isValid", !hasError),
				entry("error", error)
		);
		
		return checkMap;
	}
}
