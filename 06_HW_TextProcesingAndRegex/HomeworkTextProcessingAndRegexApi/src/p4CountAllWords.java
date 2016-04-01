import java.util.Scanner;

//Problem 4.	Count All Words
//Write a program to count the number of words in given sentence.
//Use any non-letter character as word separator.
//Examples:
//Input                                                                                         	 Output
//Welcome to the Software University (SoftUni)!                                                      	6

//I am coming...	                                                                                    3

//It's OK, I'm in.	                                                                                    6

//Java is a set of several computer software products and specifications                               60
//from Oracle Corporation that provides a system for developing application software and deploying
//it in a cross-platform computing environment. Java is used in a wide variety of computing platforms
//from embedded devices and mobile phones on the low end, to enterprise servers and supercomputers on the high end.	
public class p4CountAllWords {
   public static void main(String[] args) {
	   Scanner scan = new Scanner(System.in);
		String[]elements = scan.nextLine().toLowerCase().split("[ :,.')-_(!@#$]+");
		scan.close();
		int countMatches = elements.length;
		System.out.println(countMatches);
   }
}
