import java.util.Scanner;

//                        Problem 3.	Count Specified Word
//Write a program to find how many times a word appears in given text. The text is given at the
//first input line. The target word is given at the second input line. The output is an integer
//number. Please ignore the character casing. Consider that any non-letter character is a word separator. Examples:
//Input                                           	                                                           Output
//Welcome to the Software University (SoftUni)! Welcome to programming.                                          2
//welcome	

//I am coming...                                                                                                 0
//hello	

//It's OK, I'm in.                                                                                               1
//i	

//Java is a set of several computer software products and specifications from Oracle Corporation                 2
//that provides a system for developing application software and deploying it in a cross-platform 
//computing environment. Java is used in a wide variety of computing platforms from embedded
//devices and mobile phones on the low end, to enterprise servers and supercomputers on the high end.
//is	
public class p3CountSpecifiedWord {
   public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[]elements = scan.nextLine().toLowerCase().split("[ :,.')(!@#$]+");
	String targetWord = scan.nextLine();
	scan.close();
	int countMatches = 0;
	for (int i = 0; i < elements.length; i++) {
		String currentElement = elements[i];
		if (targetWord.equals(currentElement)) {
			countMatches++;
		}
	}
	System.out.println(countMatches);
   }
}
