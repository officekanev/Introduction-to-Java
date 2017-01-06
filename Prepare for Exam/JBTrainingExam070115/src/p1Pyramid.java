import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//                                     Problem 1 – Pyramid
//You are a given pyramid of integer numbers. Your task is to print a growing sequence of integers, 
//starting from the top of the pyramid. For example, we are given the following pyramid:
//    2
//  5  8
//4  9 10
//The first number from the top is 2. Going bottom, on the second row, the closest number larger
//than 2 is 5. On the third row, the closest number larger than 5 is 9. The resulting sequence is {2, 5, 9}.
//If a row does not contain a number larger than the previous one, we go to the next row and search
//for a number greater than the previous number + 1. For example:
//   6
// 5  3
//4 9 7
//The first number is 6. On the second row we have no number greater than 6, so we go to the next row, 
//where we look for the nearest number larger than 7 (6 + 1 = 7), which is 9. The resulting sequence is {6, 9}.
//Input
//The input will be read from the console. 
//•	On the first line, you will get the number of lines N. 
//•	On the next N you will get the rows of the pyramid. The numbers in each row are separated by one
//or more spaces. There will be a different number of spaces at the beginning of each line. 
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//Print on the console all numbers of the sequence separated by a comma and a space.
//Constraints
//•	The first row will contain only 1 number.
//•	The rows of the pyramid will be in the range [2 … 1000].
//•	The numbers in the pyramid will be integers in the range [-2147483648 … 2147483647].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	          Output	  Input	        Output		      Input        	Output
// 3            2, 5, 9	       3            6, 9              5             6, 9, 12
//   2                        6                                 6
 // 5  8                     5  3                           11   9
// 4 9 10		             4 9 10                         5  5   5
 //                                                         0 0 0   0   
//                                                        9 10 11 12 13			   
public class p1Pyramid {
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lengthLine = scan.nextInt();
		scan.nextLine();
		int firstNum = 0;
		for (int i = 0; i < lengthLine; i++) {
			String input = scan.nextLine();
			String pattern = "[-+0-9]+";
			Pattern r = Pattern.compile(pattern);	
			List<Integer> elements = new ArrayList<Integer>();
			 Matcher m = r.matcher(input);
			   while (m.find( )) {
				   int number = Integer.parseInt(m.group( ));
				   elements.add(number);
			      }
			   Collections.sort(elements);			   
			if (i == 0) {
				firstNum = elements.get(i);
				System.out.print(firstNum );				
			} else {
				for (int j = 0; j < elements.size(); j++) {
					if (elements.get(j) >= firstNum) {
						System.out.print(", " + elements.get(j));
						firstNum = elements.get(j);
						break;
					} else {
						continue;
					}
				}
			}
			firstNum++;
		}
		scan.close();
	}
    
     //  avt 
//	Scanner input = new Scanner(System.in);
//	int n = input.nextInt();
//	input.nextLine();
//	String firstLine = input.nextLine();
//
//	int currentNumber = Integer.parseInt(firstLine.trim());
//	String output = "" + currentNumber;
//
//	for (int i = 1; i < n; i++) {
//		String nextLine = input.nextLine();
//		String[] numbersAsString = nextLine.trim().split("[ ]+");
//		int[] numbers = new int[numbersAsString.length];
//		for (int j = 0; j < numbersAsString.length; j++) {
//			numbers[j] = Integer.parseInt(numbersAsString[j]);
//		}
//
//		Arrays.sort(numbers);
//		boolean isBreak = false;
//		for (int j = 0; j < numbersAsString.length; j++) {
//			if (numbers[j] > currentNumber) {
//				currentNumber = numbers[j];
//				output += ", " + currentNumber;
//				isBreak = true;
//				break;
//			}
//		}
//
//		if (!isBreak) {
//			currentNumber++;
//		}
//	}
//
//	System.out.print(output);
//}
}























