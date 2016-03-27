//                                    Problem 8.	Extract All Unique Words
//At the first line at the console you are given a piece of text. Extract all words from 
//it and print them in alphabetical order. Consider each non-letter character as word separator.
//Take the repeating words only once. Ignore the character casing. Print the result words in a 
//single line, separated by spaces. Examples:
//Input	                                                                           Output
//Welcome to SoftUni. Welcome to Java.	                                     java to softuni welcome

//What is better: Java SE or Java EE?	                                     better ее is java or se what 

//hello	                                                                     hello
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p8ExtractEmails {

	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().toLowerCase().split("[ .?:]+");
		scan.close();
		List<String> inputLines = new ArrayList<String>();
		for (int i = 0; i < input.length; i++) {
			String current = input[i];
			if (!inputLines.contains(current)) {
				inputLines.add(current);
			}
		}
		Collections.sort(inputLines);
//	!!!!	Of the first test are wrong outout because the letter 's' is befor 't'  !!!!!
//           and output must be => java softuni to welcome  
		for (String word : inputLines) {
			System.out.print(word + " ");
		}		
		
	}
}
