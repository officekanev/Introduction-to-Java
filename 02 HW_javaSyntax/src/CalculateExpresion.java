import java.util.Scanner;

//                               Problem 4.	Calculate expression
//Write a program that reads three floating point numbers from the console and calculates their result
//with the following formulae: 
//((a2 + b2) / (a2 – b2))(a + b + c) / √c             (a2 + b2 - c3)(a – b)
//Then calculate the difference between the average of the three numbers and the average of the two
//formulae. Average (a, b, c) – Average (f1, f2)
//a            	b              	c	                          result
//5	            2	            3	         F1 result: 6.45; F2 result: 8.00; Diff: 3.89
//3.8	           2.5	           1.2	         F1 result: 569.60; F2 result: 45.84; Diff: 305.22
//1.25	       1.22	           1.24	         F1 result: 239530.27; F2 result: 1.00; Diff: 119764.40
//3.21         	1           	2.1          F1 result: 2.33; F2 result: 4.85; Diff: 1.49
//0	            0	             0           F1 result: NaN; F2 result: 1.00; Diff: NaN
public class CalculateExpresion {
   public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);	
	System.out.println("Please enter every value in new line");
	double a = Double.parseDouble(scan.nextLine());
	double b = Double.parseDouble(scan.nextLine());
	double c = Double.parseDouble(scan.nextLine());
	scan.close();
	double F1 =  Math.pow(((a * a) + (b * b)) / ((a * a) - (b * b)) , ((a + b + c ) / Math.sqrt(c)));
	double F2 = Math.pow((((a * a) + (b * b)) - (c * c * c)) , (a - b));	
	double average = ((a + b + c) / 3) - ((F1 + F2) / 2);
	if (average < 0) {
		average *= -1;
	}
     System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",F1,F2,average);
	
   }
}
