import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Note: the count of the input strings is not explicitly specified, so you might need to read
//the first input line as a string and split it by a space
//                      Problem 1.	Filter Array
//Write a program that filters an array of strings, leaving only the strings with length greater
//than 3 characters. Use .filter()
//Input	                                                       Output
//Gosho gos pesho pes blabla bla	                         Gosho pesho blabla
//
//Kogato cyfnat nalymite.                                	Kogato cyfnat nalymite.
// 
//To be, or not to be.	                               (empty)
public class P1FilterArray {
   public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
	 String line = scan.nextLine();
//	 !!! Finaly you must enter a blank line to exit the while loops  !!!
	 while (!line.isEmpty()) {
		String[] elements = line.split("[ ]+");	
		int count = 0;
		List<String> arrayList = new ArrayList<String>(Arrays.asList(elements));		
		//arrayList.stream().filter(word -> word.length() > 3).forEach(System.out::println);
		List<String> filtered =  arrayList.stream().filter(word -> word.length() > 3).collect(Collectors.toList());
		count = filtered.size();
		if (count == 0) {
			System.out.println("(empty)");
		}else {
			for (String word : filtered) {
				System.out.print(word + " ");
			}
		}
		System.out.println();	
		line = scan.nextLine();
	}
	 scan.close();
   }
}




































