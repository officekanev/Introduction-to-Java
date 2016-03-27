//                 Problem 3.	Largest Sequence of Equal Strings
//Write a program that enters an array of strings and finds in it the largest sequence of equal 
//elements. If several sequences have the same longest length, print the leftmost of them. The
//input strings are given as a single line, separated by a space. Examples:
//Input	                                            Output
//hi yes yes yes bye	                           yes yes yes
//SoftUni softUni softuni	                       SoftUni
//1 1 2 2 3 3 4 4 5 5	                           1 1
//a b b xxx c c c	                               c c c
//hi hi hi hi hi	                               hi hi hi hi hi
//hello	                                           hello
import java.util.Scanner;

public class p3LargestSequenceOfEqualStrings {
   public static void main(String[] args) {
	   Scanner scan = new Scanner(System.in);
		String[] arr = scan.nextLine().split(" ");
		scan.close();
		String prev = "";
		String curr = "";
		int maxLength = 0;
		int currLength = 0;
		int endIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				currLength++;				
				continue;
			}
			prev = arr[i - 1];
			curr = arr[i];
			if (curr.contains(prev)) {
				currLength++;
				if (currLength > maxLength) {
					maxLength = currLength;					
					endIndex = i;
				}
			} else {
				if (currLength > maxLength) {
					maxLength = currLength;
					currLength = 1;
					endIndex = i;
				} else {
					currLength = 1;
				}
			}
		}
		if (maxLength == 1 || maxLength == 0) {
			System.out.print(arr[0] + " ");
		} else {
			//endIndex -= maxLength + 1;
			for (int i = 0; i < maxLength; i++) {
				System.out.print(arr[endIndex--] + " ");
			}
		}
		
  }
}
