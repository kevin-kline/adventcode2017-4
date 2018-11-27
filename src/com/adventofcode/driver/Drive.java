package com.adventofcode.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Drive {

	public static final String FILE_INPUT_PATH = "input.txt";
	public static ArrayList<String> textLinesFromInput;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//Step 1: Read through the .txt file and add it to an arraylist
		
		File file = new File(FILE_INPUT_PATH);
		Scanner scanner = new Scanner(file);
		textLinesFromInput = new ArrayList<String>();
		
		int totalValidPassphrases = 0;
		
		while(scanner.hasNextLine()) {
			
			String line = scanner.nextLine();
			textLinesFromInput.add(line);
			
		}
		scanner.close();
		
		for(String s : textLinesFromInput) {
			
			String[] sArray = s.split("\\s+");
			
			int numberOfDuplicatesInArray = 0;
			
			for(int i = 0; i < sArray.length; i++) {
				
				for(int j = 0; j < sArray.length; j++) {
					
					if(sArray[i] != sArray[j]) {
						
						if(sArray[i].equals(sArray[j])) {
							numberOfDuplicatesInArray += 1;
						}
					}
					
				}
			}
			if(numberOfDuplicatesInArray == 0) {
				totalValidPassphrases += 1;
			}
		}
		
		System.out.println("Total passphrases: " + textLinesFromInput.size());
		System.out.println("Total valid passphrases: " + totalValidPassphrases);
				
	}

}
