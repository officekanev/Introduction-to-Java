import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//                   Problem 9.	Most Frequent Word
//Write a program to find the most frequent word in a text and print it, as well as how many 
//times it appears in format "word -> count". Consider any non-letter character as a word separator.
//Ignore the character casing. If several words have the same maximal frequency, print all of them 
//in alphabetical order. Examples:
//Input	                                                                                 Output
//in the middle of the night                                              	          the -> 2 times

//Welcome to SoftUni. Welcome to Java. Welcome everyone.	                          welcome -> 3 times

//Hello my friend, hello my darling. Come on, come here. Welcome, welcome darling.	  come -> 2 times
//                                                                                    darling -> 2 times
//                                                                                    hello -> 2 times
//                                                                                    my -> 2 times
//                                                                                    welcome -> 2 times
public class p9MostFrequentWord {
  public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);	 
	 String[] elemnts = scan.nextLine().toLowerCase().split("[ .,:?#@!-+=]+");
	 List<String> appears = new ArrayList<String>();
	 List<String> ignoreWord = new ArrayList<String>();
	 scan.close();
	 int maxAppears = 1;
	 int currentAppears = 1;	 
	 for (int i = 0; i < elemnts.length; i++) {
		String word = elemnts[i];
		for (int j = 0; j < elemnts.length; j++) {
			if (i == j) {
				continue;
			}
			if (ignoreWord.contains(word)) {
				continue;
			}
			String nextWord = elemnts[j];
			if (word.equals(nextWord)) {
				currentAppears++;
			}
		}
		ignoreWord.add(word);
		if (currentAppears > maxAppears  ) {
			appears.clear();
			appears.add(word);
			maxAppears = currentAppears;
			currentAppears = 1;
		} else if(currentAppears == maxAppears && currentAppears > 1){
			appears.add(word);
			currentAppears = 1;
		}
	}
	 Collections.sort(appears);
	 for (String element : appears) {
		System.out.printf(element + " -> %d times",maxAppears);
		System.out.println();
	}
	 
	 
  }
}
