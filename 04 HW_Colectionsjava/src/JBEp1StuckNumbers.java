import java.util.Scanner;

//                                     Problem 1* – Stuck Numbers
//You are given n numbers. Write a program to find among these numbers all sets of 4 numbers {a, b, c, d},
//such that a|b == c|d, where a ≠ b ≠ c ≠ d. Assume that "a|b" means to append the number b after a. We
//call these numbers {a, b, c, d} stuck numbers: if we append a and b, we get the same result like if we
//append c and d. Note that the numbers a, b, c and d should be distinct (a ≠ b ≠ c ≠ d).
//Input
//The input comes from the console. The first line holds the count n. The next line holds n integer numbers,
//separated by a space. The input numbers will be distinct (no duplicates are allowed).
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//Print at the console all stuck numbers {a, b, c, d} found in the input sequence in format "a|b==c|d" 
//(without any spaces), each at a separate line. The order of the output lines is not important. Print "No"
//in case no stuck numbers exist among the input sequence of numbers.
//Constraints
//•	The count n will be an integer number in the range [1…50].
//•	The input numbers will be distinct integers in the range [0…9999].
//•	Time limit: 0.5 sec. Memory limit: 16 MB.
//Examples
//Input	             Output		   Input	              Output		    Input	Output
//5                 2|51==25|1      7                   2|322==23|22         3        No
//2 51 1 75 25	    25|1==2|51   2 22 23 32 322 222 5   23|22==2|322       5 1 20
//		                                                32|22==322|2
//	                                                    32|222==322|22
//                                                      322|2==32|22 
//                                                      322|22==32|222
public class JBEp1StuckNumbers {
   public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);	
	int numberOfElemnts = scan.nextInt();
	scan.nextLine();
	int[] digith = new int[numberOfElemnts];
	for (int i = 0; i < digith.length; i++) {
		digith[i] = scan.nextInt();
	}
	scan.close();
	int a,b,c,d;
	int countMatches = 0;
	String concatSideA = "";
	String concatSideB = "";
	for (int i = 0; i < digith.length; i++) {
		a = digith[i];
		for (int j = 0; j < digith.length; j++) {
			 b = digith[j];
			 if (i != j) {
				 for (int j2 = 0; j2 < digith.length; j2++) {					
						for (int k = 0; k < digith.length; k++) {
							 if ((j2 == k)) {
									continue;
							 }
							c =  digith[j2];
							d = digith[k];
							if ((i != j2) && (i != k) && (b != j2) && (b != k)  ) {
								concatSideA +=  String.valueOf(a);
								concatSideA +=  String.valueOf(b);
								concatSideB +=  String.valueOf(c);
								concatSideB +=  String.valueOf(d);
								if (concatSideA.equals(concatSideB)) {
									System.out.println(a + "|" + b + "==" + c + "|" + d);
									countMatches++;
								}
								concatSideA = "";
								concatSideB = "";
							}
					   }
				}				
			}
			
		}
	}
	if (countMatches == 0) {
		System.out.println("No");
	}
	
   }
}














