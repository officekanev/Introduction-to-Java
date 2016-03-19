import java.util.Scanner;

//Problem 3.	Formatting Numbers
//Write a program that reads 3 numbers: an integer a (0 ≤ a ≤ 500), a floating-point b and a floating-point 
//c and prints them in 4 virtual columns on the console. Each column should have a width of 10 characters. The
//number a should be printed in hexadecimal, left aligned; then the number a should be printed in binary form,
//padded with zeroes, then the number b should be printed with 2 digits after the decimal point, right aligned;
//the number c should be printed with 3 digits after the decimal point, left aligned. Examples:

public class FormattingNumbers {
   public static void main(String[] args) {
	     Scanner scan = new Scanner(System.in);
	     System.out.println("PLease enter every number in the new line");
		int a = scan.nextInt();
		int aBinary = Integer.parseInt(Integer.toBinaryString(a));
		scan.nextLine();
		double b = Double.parseDouble(scan.nextLine());		
		double c = Double.parseDouble(scan.nextLine());
		scan.close();

		System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|", a, aBinary, b, c);
   }
}
