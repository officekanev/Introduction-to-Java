//Problem 5.	Count All Words
//Write a program to count the number of words in given sentence. Use any non-letter character as word separator.
//Examples:
//Input	                                                                                               Output
//Welcome to the Software University (SoftUni)!	                                                       6

//I am coming...	                                                                                   3

//It's OK, I'm in.	                                                                                   6
 
//Java is a set of several computer software products and specifications from                          60
//Oracle Corporation that provides a system for developing application software and 
//deploying it in a cross-platform computing environment. Java is used in a wide variety of
//computing platforms from embedded devices and mobile phones on the low end, to enterprise 
//servers and supercomputers on the high end.	

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p5CountAllWords {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		int rezult = 0;
		String chekingText;
//  !!!!!   After entering text, you can enter and one blank row to come out the this ' While ' loop !!!!!		
		while (true) {
			chekingText = input.nextLine();
			if (chekingText.isEmpty()) {
				break;
			}			 
		      String pattern = "[a-zA-z]+";
			Pattern r = Pattern.compile(pattern);
			 Matcher math = r.matcher(chekingText);
			 while (math.find( )) {				
				 rezult++;
			}						
		}	
			
		System.out.println(rezult);
		input.close();
	}
}
