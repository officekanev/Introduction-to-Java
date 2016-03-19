import java.util.Scanner;

//                              Problem 8.	*Odd and Even Pairs
//You are given an array of integers as a single line, separated by a space.
//Write a program that checks consecutive pairs and prints if both are odd/even
//or not. Note that the array length should also be an even number
//Input              	Output
//1 2 3 4	             1, 2 -> different
//                       3, 4 -> different

//2 8 11 15 3 2	         2, 8 -> both are even
//                       11, 15 -> both are odd
//                       3, 2 -> different

//1 8 11 1 2	         Invalid length
public class OddAndEvenPairs {
  public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
	 String[] numbers = scan.nextLine().split("[ ]+");
	 scan.close();
	 if (numbers.length % 2 != 0) {
		System.out.println("Invalid length");		
	 } else {
		 for (int i = 0; i < numbers.length - 1; i+=2) {
			int firstNum = Integer.parseInt(numbers[i]);
			int secondNum = Integer.parseInt(numbers[i + 1]);
			if ((firstNum % 2 == 0) && (secondNum % 2 == 0)) {
				System.out.printf("%1$d, %2$d -> both are even",firstNum,secondNum);
				System.out.println();
			} else if((firstNum % 2 != 0) && (secondNum % 2 != 0)) {
				System.out.printf("%1$d, %2$d -> both are odd",firstNum,secondNum);
				System.out.println();
			} else {
				System.out.printf("%1$d, %2$d -> different",firstNum,secondNum);
				System.out.println();
			}
		}
	 }
  }
}
