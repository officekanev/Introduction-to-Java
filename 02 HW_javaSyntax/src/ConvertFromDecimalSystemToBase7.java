import java.util.Scanner;

//          Problem 5.	Convert from decimal system to base-7
//Write a program that takes an integer number and converts it to base-7
//Decimal	Base-7
//  10	     13
//   7	     10
//  123	    234
// 1000	    2626
public class ConvertFromDecimalSystemToBase7 {
	 public static void main(String[] args) {
	        System.out.println("Enter the number");
	        Scanner scan = new Scanner(System.in);
	        Integer number = scan.nextInt();	       
	        scan.close();
	        System.out.print(Integer.toString(number, 7));	      	        
	    }
}
