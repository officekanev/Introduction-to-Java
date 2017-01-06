import java.util.Scanner;

//Problem 1 – Stuck Numbers
//You are given n numbers. Write a program to find among these numbers all sets of
//4 numbers {a, b, c, d}, such that a|b == c|d, where a ≠ b ≠ c ≠ d. Assume that "a|b" 
//means to append the number b after a. We call these numbers {a, b, c, d} stuck 
//numbers: if we append a and b, we get the same result like if we append c and d.
//Note that the numbers a, b, c and d should be distinct (a ≠ b ≠ c ≠ d).
//Input
//The input comes from the console. The first line holds the count n. The next line
//holds n integer numbers, separated by a space. The input numbers will be distinct
//(no duplicates are allowed).
//The input data will always be valid and in the format described. There is no need 
//to check it explicitly.
//Output
//Print at the console all stuck numbers {a, b, c, d} found in the input sequence in
//format "a|b==c|d" (without any spaces), each at a separate line. The order of the 
//output lines is not important. Print "No" in case no stuck numbers exist among the 
//input sequence of numbers.
//Constraints
//•	The count n will be an integer number in the range [1…50].
//•	The input numbers will be distinct integers in the range [0…9999].
//•	Time limit: 0.5 sec. Memory limit: 16 MB.
//Examples

//Input	                Output	  Input	                   Output		 Input	  Output
//5                   2|51==25|1   7                      2|322==23|22   3         No
//2 51 1 75 25	     25|1==2|51    2 22 23 32 322 222 5  23|22==2|322    5 1 20
//		                                                 32|22==322|2 
//	                                                     32|222==322|22
//                                                      322|2==32|22
//                                                      322|22==32|222
	
public class p1StuckNumbers {

// public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	int n = scan.nextInt();
//	scan.nextLine();
//	String[] elements = new String[n];
//	for (int i = 0; i < n; i++) {
//		String curr = scan.next();
//		elements[i] = curr;
//	}
//	int count = 0;
//	scan.close();
//	String A;String B;String C;String D;
//	String firstElementsConcatenate = "";
//	String secondElementsConcatenate = "";
//	for (int a = 0; a < elements.length; a++) {
//		A = elements[a];
//		for (int b = 0; b < elements.length; b++) {
//			 B = elements[b];
//			if (!A.contains(B)) {
//				for (int c = 0; c < elements.length; c++) {
//					C = elements[c];
//					for (int d = 0; d < elements.length; d++) {
//						D = elements[d];
//						count ++;
//						if (!C.contains(D)) {
//							if ( (C != A) && (C != B)
//									&& (D != A) && (D != B)) {
//								firstElementsConcatenate += A;
//								firstElementsConcatenate += B;
//								secondElementsConcatenate += C;
//								secondElementsConcatenate += D;
//								if (firstElementsConcatenate.contains(secondElementsConcatenate)) {
//									System.out.printf("%s|%s==%s|%s",A,B,C,D);
//									System.out.println();
//									firstElementsConcatenate ="";
//									secondElementsConcatenate ="";
//								} else {
//									firstElementsConcatenate ="";
//									firstElementsConcatenate ="";
//									secondElementsConcatenate ="";
//									secondElementsConcatenate ="";
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//	}
	
	        //   var    2
	
 public static void main(String[] args) {
		
		// Read the input sequence of n integers
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scanner.nextInt();
		}
		scanner.close();
		// Find and print all stuck numbers {a, b, c, d}
		int count = 0;
		for (int num1 = 0; num1 < nums.length; num1++) {
			for (int num2 = 0; num2 < nums.length; num2++) {
				for (int num3 = 0; num3 < nums.length; num3++) {
					for (int num4 = 0; num4 < nums.length; num4++) {
						int a = nums[num1];
						int b = nums[num2];
						int c = nums[num3];
						int d = nums[num4];
						if (a != b && a != c & a != d && 
							b != c && b != d && c != d) {
							String first = "" + a + b;
							String second = "" + c + d;
							if (first.equals(second)) {
								System.out.printf("%d|%d==%d|%d\n",
									a, b, c, d);
								count++;
							}
						}
					}
				}				
			}
		}
		
		if (count == 0) {
			System.out.println("No");
		}
	}
}	
	
 	

	
		

