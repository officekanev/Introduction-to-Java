import java.util.Scanner;

//                                    Problem 1 – Count Beers
//Nakov is keen football fàn and he is passionate about the upcoming FIFA World Cup tournament.
//A month before the tournament Nakov started his preparations with a few stacks of beer and a
//few single beer bottles. You are given a list of Nakov's stacks and Nakov's single beers. 
//Help him to count how many stacks of beer and how many additional single bottles he has
//for the tournament. Assume that a stack of beer holds 20 beers.
//Input
//The input comes from the console as list of beers and stacks of beer, each at a single line,
//ending with the text "End" at the last line. Each line (except the last) come in format 
//"count measure" where count is a positive integer and measure is either "stacks" or "beers" 
//(see the examples below).
//The input data will always be valid and in the format described. There is no need to check 
//it explicitly.
//Output
//Print at the console the total number of stacks and the number of single beers that Nakov 
//has in the following format: "x stacks + y beers", where x is an integer number and y is 
//an integer number, less than 20.
//Constraints
//•	The count will be an integer number in the range [1…99].
//•	The measure is either "stacks" or "beers".
//•	The number of input lines will be in the range [1..999].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples

//   Input	            Output		                 Input                   	Output
//4 stacks             6 stacks + 3 beers           41 beers            End	4 stacks + 0 beers
//12 beers                                          1 stacks
//10 beers                                          19 beers
//1 stacks
//1 beers
//End			

public class p1CountBeers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int countStacks = 0;
		int countBeers = 0;
		while (!line.contains("End")) {
			String[] elements = line.split(" ");
			int measure = Integer.parseInt(elements[0]);
			String stackOrBeers = elements[1];
			if (stackOrBeers.contains("stacks")) {
				countStacks += measure;
			}else {
				countBeers += measure;
			}
			line = scan.nextLine();
		}
		scan.close();
		countStacks += countBeers / 20;
		 int beer = countBeers % 20;
		 System.out.printf("%d stacks + %d beers",countStacks,beer);
	}
}

























