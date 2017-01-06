import java.util.Scanner;

//Problem 1 – Dozens of Eggs
//Pencho has a chicken farm and sells eggs to monopolist grocery chains around Bulgaria.
//According to standards, he needs to bundle all his eggs weekly produce in dozens of 12 eggs.
//Help him bundle the eggs and count the final weekly produce.
//Input
//The input comes from the console as list of eggs or dozens, each at a single line. The 
//input always has 7 lines as days of the week. Each line come in format "count measure"
//where count is a positive integer and measure is either "eggs" or "dozens" (see the examples below).
//The input data will always be valid and in the format described. There is no need to
//check it explicitly.
//Output
//Print at the console the total number of dozens and the number of single eggs that 
//Pencho has in the following format: "x dozens + y eggs", where x is an integer number
//and y is an integer number, less than 12.
//Constraints
//•	The count will be an integer number in the range [1…999].
//•	The measure is either "dozens" or "eggs".
//•	The number of input lines will be always 7.
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	           Output		                     Input    	  Output
//2 eggs          2 dozens + 11 eggs                  2 dozens    14 dozens + 8 eggs
//3 eggs                                              23 eggs
//4 eggs                                              3 dozens
//5 eggs                                              19 eggs
//6 eggs                                              2 dozens
//7 eggs                                              21 eggs
//8 eggs			                                  29 eggs
public class p1dozensOfEdds {
	  public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		int dozensCount = 0;
		int eddsCount = 0;
		String line = scan.nextLine();
		while (!line.isEmpty()) {
			String[] elements = line.split(" ");
			if (elements[1].contains("dozens")) {
				dozensCount += Integer.parseInt(elements[0]);
			} else {
				eddsCount += Integer.parseInt(elements[0]);
			}
			line = scan.nextLine();
		}
		scan.close();
		dozensCount += eddsCount / 12;
		int eggs = eddsCount % 12;
		System.out.printf("%1$d dozens + %2$d eggs",dozensCount,eggs);
		
		// avt
		//initialize variables
//		Scanner str = new Scanner(System.in);
//		int eggs = 0;
//		int dozens = 0;
//
//		
//		for (int i = 0; i < 7; i++) {
//			
//			//read the input for actual "eggs" and "dozens"
//			String input = str.nextLine();
//			String[] currLine = input.split(" ");
//			int currEggs = 0;
//			
//			//check the input if it is "eggs" or "dozens"
//			if (currLine[1].toLowerCase().contains("dozen")) {
//				currEggs = Integer.parseInt(currLine[0]) * 12;
//			} else if (currLine[1].toLowerCase().contains("egg")) {
//				currEggs = Integer.parseInt(currLine[0]);
//			}
//			
//			//adding the input to total sum of "eggs"
//			eggs += currEggs;
//		}
//		
//		//calculating "eggs" and "dozens"
//		dozens = eggs / 12;
//		eggs = eggs % 12;
		
	//System.out.println(dozens + " dozens + " + eggs + " eggs");
	}
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
		  
}
