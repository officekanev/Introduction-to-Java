import java.math.BigDecimal;
import java.util.Scanner;

//You are given an arithmetic expression, consisting of positive numbers and '+' 
//and '-' between them. Write a program to calculate the value of the expression.
//Input
//The input comes from the console. It consists of a single line holding the 
//arithmetic expression. It consists of positive numbers and '+' and '-' between
//them. Anywhere around the numbers spaces could appear.
//Output
//Print the value of the input expression at the console with a precision of 7 
//decimal digits. Don't use scientific notation in the output! This means that 
//if the output is 0.15, it will be considered correct if it is printed as 0.1500,
//as .15 or as 0.150, but not as 1.5e-1.
//Constraints
//•	The input numbers will be standard floating-point values in the range 
//[-1010…1010] with no more than 10 digits. Use the "." symbol as decimal separator.
//The scientific notation (e.g. 1.5e-12) may not be used in the input numbers.
//•	The output numbers will be standard floating-point values in the range 
//[-1015…1015] with no more than 30 digits. Use the "." symbol as decimal separator. 
//The scientific notation (e.g. 1.5e-12) may not be used in the output numbers.
//Optionally, the output numbers can be rounded up to 7 digits after the decimal 
//point.
//•	The count of the input numbers will be less than 1000.
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	                                  Output	         Comments
//  5 -33   + 12 -  55-  1  - 2+6	         -68	         -68.0 is also correct
//1.5 + 2.5	                             4.0	         4 and 4.00 are also correct
//0.05+0.01 - 1	                         -0.94	        -0.9400000 is also corect
//    1         +        2	               3	         3.0 is also corect
//9876543210 + 0.987654321	   9876543210.987654321	     9876543210.9876543 is also correct

public class p3SimpleExpresin {

	public static void main(String[] args) {
//		Locale.setDefault(Locale.ROOT);
//		Scanner input = new Scanner(System.in);
//		String expression = input.nextLine();
//		
//		BigDecimal result = new BigDecimal(0.0);
//		
//		int startIndex = 0;
//		int endIndex = 1;
//		char tempSign;
//		char sign = ' ';
//		char blabla;
//		
//		for (int i = 0; i < expression.length(); i++) {
//		blabla = expression.charAt(i);
//		if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
//			endIndex = i;
//			tempSign = expression.charAt(i);
//			String numberStr = expression.substring(startIndex, endIndex).trim();
//			BigDecimal number = new BigDecimal(numberStr);
//			if (startIndex == 0) {
//				result = result.add(number);
//			} else {
//				switch (sign) {
//				case '+': result = result.add(number); break;
//				case '-': result = result.subtract(number);
//				default: break;
//				}
//			}
//			startIndex = endIndex + 1;
//			sign = tempSign;
//		} else if (i == expression.length() - 1) {
//			String numberStr = expression.substring(startIndex).trim();
//			BigDecimal number = new BigDecimal(numberStr);
//			switch (sign) {
//			case '+': result = result.add(number); break;
//			case '-': result = result.subtract(number);
//			default: break;
//			}
//		}
//	}
//	System.out.printf("%.7f", result);			
//	}
		
	// AVT 2
		
		Scanner scan = new Scanner(System.in);
		String expression = scan.nextLine();
		expression = expression.replace(" ", "");
		String[] numbers = expression.split("[^0-9.]+");
		String[] operators = expression.split("[0-9.]+");
		BigDecimal sum = new BigDecimal(numbers[0]);
		scan.close();
		for (int i = 1; i < operators.length; i++) {
			BigDecimal number = new BigDecimal(numbers[i]);
			if (operators[i].equals("+")) {
				sum = sum.add(number);
			} else if (operators[i].equals("-")) {
				sum = sum.subtract(number);
			} else {
				throw new IllegalArgumentException(
					"Invalid operator: " + operators[i]);
			}
		}		
		System.out.println(sum.toPlainString());
		
	}	
}
