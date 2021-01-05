package com.techelevator.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOResources {
	private static Scanner in = new Scanner(System.in);
	public static Scanner getScannerInput() {
		if (in == null) {
			in = new Scanner(System.in);
		}
		return in;
	}
	public static void closeScannerInput() {
		if (in != null) {
			in.close();
		}
	}
	public static Scanner getScannerFileInput(File fileName) {
		if (in != null) {
			closeScannerInput();
		}
		try {
			in = new Scanner(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
	}
}
