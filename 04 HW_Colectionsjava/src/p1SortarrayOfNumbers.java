import java.util.Scanner;

//Problem 1.	Sort Array of Numbers
//Write a program to enter a number n and n integer numbers and sort and print them. 
//Keep the numbers in array of integers: int[]. Examples:
//Input	              Output
//7                     -3 4 4 5 6 10 120
//6 5 4 10 -3 120 4	
//
//3                     8 9 10
//10 9 8	
//1                     999
//999	

public class p1SortarrayOfNumbers {
   public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
	 int numberOfDigit = scan.nextInt();
	 scan.nextLine();
	int[] digit = new int[numberOfDigit];
	for (int i = 0; i < numberOfDigit; i++) {
		digit[i] = scan.nextInt();
	}
	 scan.close();	 
	 // var 1 to sorting
	 
	// Arrays.sort(digit);
	 
	  // var 2 to Sorting
	 for (int i = 0; i < digit.length; i++) {
		for (int j = i + 1; j < digit.length; j++) {
			int curr = digit[i];
			int next = digit[j];
			int temp = digit[i];
			if (curr > next) {
				digit[i] = digit[j];
				digit[j] = temp;
			}
		} 		
	 }
	 for (int i = 0; i < digit.length; i++) {
		System.out.print(digit[i] + " ");
	}
  }  
}















