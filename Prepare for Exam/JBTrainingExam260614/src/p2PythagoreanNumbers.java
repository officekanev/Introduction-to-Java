import java.util.Scanner;

//                         Problem 2 – Pythagorean Numbers
//George likes math. Recently he discovered an interesting property of the Pythagorean
//Theorem: there are infinite number of triples of integers a, b and c (a ≤ b),
//such that a2 + b2 = c2. Write a program to help George find all such triples 
//(called Pythagorean numbers) among a set of integer numbers.
//Input
//The input data should be read from the console. At the first line, we have a
//number n – the count of the input numbers. At the next n lines we 
//have n different integers.
//The input data will always be valid and in the format described. There is no
//need to check it explicitly.
//Output
//Print at the console all Pythagorean equations a2 + b2 = c2 (a ≤ b), which can 
//be formed by the input numbers. Each equation should be printed in the following
//format: "a*a + b*b = c*c". The order of the equations is not important. Beware 
//of spaces: put spaces around the "+" and "=". In case of no Pythagorean numbers
//found, print "No".
//Constraints
//•	All input numbers will be unique integers in the range [0…999].
//•	The count of the input numbers will be in the range [1..100].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	     Output		            Input	    Output		                 Input	Output
//8       5*5 + 12*12 = 13*13         5       3*3 + 4*4 = 5*5                  3      No
//41      9*9 + 40*40 = 41*41         3       0*0 + 3*3 = 3*3                 10
//5       3*3 + 4*4 = 5*5            12       0*0 + 12*12 = 12*12             20
//9                                   5       0*0 + 5*5 = 5*5                 30
//12                                  0       0*0 + 0*0 = 0*0  
//4                                   4       0*0 + 4*4 = 4*4
//13
//40
//3	

public class p2PythagoreanNumbers {
  
	public static void main(String[] args) {		
	Scanner scan = new Scanner(System.in);	
		int lengthElements = scan.nextInt();
		scan.nextLine();
		int[] digits = new int[lengthElements];
		for (int i = 0; i < lengthElements; i++) {
			digits[i] = Integer.parseInt(scan.nextLine());
		}
		scan.close();
		int leftSide = 0; int a = 0; int b = 0;
		int rightSide = 0; int c = 0; 
		boolean checkMatch = false;
		for (int i = 0; i < digits.length; i++) {
			a = digits[i];
			for (int j = 0; j < digits.length; j++) {
				b = digits[j];
				if ((a < b)||(a == b)) {
					for (int g = 0; g < digits.length; g++) {
						c = digits[g];												
							leftSide = (a * a) + (b * b);
							rightSide = c * c;
							if (leftSide == rightSide) {
								checkMatch = true;
								System.out.printf("%1$d*%1$d + %2$d*%2$d = %3$d*%3$d",a,b,c);
								System.out.println();
							}						
					}
				}
									
			}
		}
		if (!checkMatch) {
			System.out.println("No");
		}
		
		// avt
//		Scanner input = new Scanner(System.in);
//		int n = input.nextInt();
//		int[] nums = new int[n];
//		for (int i = 0; i < nums.length; i++) {
//			nums[i] = input.nextInt();
//		}
//		HashSet<Integer> squares = new HashSet<>();
//		for (int num : nums) {
//			squares.add(num * num);
//		}
//		int count = 0;
//		for (int a : nums) {
//			for (int b : nums) {
//				int cSquare = a*a + b*b; 
//				if (a <= b && squares.contains(cSquare)) {
//					int c = (int)Math.sqrt(cSquare);
//					System.out.printf(
//						"%d*%d + %d*%d = %d*%d\n",
//						a, a, b, b, c, c);
//					count++;
//				}
//			}
//		}
//		if (count == 0) {
//			System.out.println("No");
//		}
	}
}


























