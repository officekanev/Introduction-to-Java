import java.util.Scanner;

//                  Problem 6.	Convert from base-7 to decimal
//Write a program that converts from a base-7 number to its decimal representation
//   Base-7	    Decimal
//    13	      10
//    10	       7
//    234	      123
//    2626	      1000
//     1	        1
public class ConvertFromBase7ToDecimal {
   
   public static void main(String[] args) {
        System.out.println("Please enter the integer number ");
        Scanner scan = new Scanner(System.in);
        String number= scan.next();
        scan.close();
        Integer decimal = Integer.valueOf(number, 7);
        System.out.println(decimal);       
    }
  
}
