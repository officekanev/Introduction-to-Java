import java.util.Scanner;

//                 Problem 6.	 Sum numbers from 1 to N
//Create a Java program that reads a number N from the console and calculates the sum of all 
//numbers from 1 to N (inclusive).
//Input	  Output     Input	Output       Input	Output
// 12	   78         1      1            5	      15
public class SumNumbersFrom1toN {
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberN = scan.nextInt();
		scan.close();
		int sum = 0;
		for (int i = 0; i <= numberN; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
