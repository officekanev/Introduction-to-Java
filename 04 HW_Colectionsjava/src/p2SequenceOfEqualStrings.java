import java.util.Scanner;

//Problem 2.	Sequences of Equal Strings
//Write a program that enters an array of strings and finds in it all sequences of equal elements.
//The input strings are given as a single line, separated by a space. Examples:
//  Input	                    Output
//hi yes yes yes bye	         hi
//                              yes yes yes
//                               bye

//SoftUni softUni softuni	    SoftUni
//                              softUni
//                              softuni

//1 1 2 2 3 3 4 4 5 5	        1 1
//                              2 2
//                              3 3
//                              4 4
//                              5 5

//a b b xxx c c c	            a
//                              b b
//                              xxx
//                              c c c

//hi hi hi hi hi	           hi hi hi hi hi

//hello	                       hello

//Note: the count of the input strings is not explicitly specified, so you might need to read the 
//first input line as a string and split it by a space.

public class p2SequenceOfEqualStrings {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] arr = scan.nextLine().split(" ");
	scan.close();
	String prev = "";
	String curr = "";
	for (int i = 0; i < arr.length; i++) {
		if (i == 0) {
			System.out.print(arr[i] + " ");
			continue;
		}
		prev = arr[i - 1];
		curr = arr[i];
		if (curr.contains(prev)) {
			System.out.print(curr + " ");
		} else {
			System.out.println();
			System.out.print(curr + " ");
		}
	}
  }
}




















