//                        Problem 4.Longest Increasing Sequence
//Write a program to find all increasing sequences inside an array of integers. The integers are
//given in a single line, separated by a space. Print the sequences in the order of their appearance
//in the input array, each at a single line. Separate the sequence elements by a space. Find also 
//the longest increasing sequence and print it at the last line. If several sequences have the same 
//longest length, print the leftmost of them. Examples:
//Input	                        Output
//2 3 4 1 50 2 3 4 5	           2 3 4
//                                 1 50
//                                 2 3 4 5
//                                 Longest: 2 3 4 5

//8 9 9 9 -1 5 2 3	               8 9
//                                  9
//                                  9
//                                 -1 5
//                                  2 3
//                                 Longest: 8 9

//1 2 3 4 5 6 7 8 9	               1 2 3 4 5 6 7 8 9
//                                 Longest: 1 2 3 4 5 6 7 8 9

//5 -1 10 20 3 4	               5
//                               -1 10 20
//                                3 4
//                                Longest: -1 10 20

//10 9 8 7 6 5 4 3 2 1	          10
//                                9
//                                8
//                                7
//                                6
//                                5
//                                4
//                                3
//                                2
//                                1
//                               Longest: 10
//Note: the count of the input numbers is not explicitly specified, so you might need to read 
//the sequence as string, then split it by a space and finally parse the obtained 
//tokens to take their integer values.
import java.util.Scanner;

public class p4LongestIncreasingSequence {

	public static void main(String[] args) {
		
		   Scanner scan = new Scanner(System.in);
			String[] arr = scan.nextLine().split(" ");
			int[] parseNum = new int[arr.length];
			for (int i = 0; i < parseNum.length; i++) {
				parseNum[i] = Integer.parseInt(arr[i]);
			}
			scan.close();
			int prev = 0;
			int curr = 0;
			int maxLength = 0;
			int currLength = 0;					
			int startIndex1 = 0;				
			for (int i = 0; i < arr.length; i++) {
				if (i == 0) {
					System.out.print(arr[0] + " ");		
					currLength++;				
					continue;
				}
				prev = parseNum[i - 1];
				curr = parseNum[i];
				if (curr > prev) {
					currLength++;
					System.out.print(curr + " ");
					if (currLength > maxLength) {
						maxLength = currLength;	
						startIndex1 = i - maxLength + 1;						
					}		
				} else {
					System.out.println();
					System.out.print(curr + " ");							
				    currLength = 1;					
				}
			}
			if (maxLength == 1 || maxLength == 0) {
				System.out.print("Longest: " + arr[0] + " ");
			} else {
				System.out.println();
				System.out.print("Longest: ");								
				for (int i = 0; i < maxLength; i++) {
					System.out.print(arr[startIndex1++] + " ");
				}
		   }
   }
}
