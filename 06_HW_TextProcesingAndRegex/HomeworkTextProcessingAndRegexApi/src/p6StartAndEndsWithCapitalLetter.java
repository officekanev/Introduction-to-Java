import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Problem 6.	 Starts and Ends With Capital Letter
//Write a program that takes as input an array of strings are prints only the words that start
//and end with capital letter. Words are only strings that consist of English alphabet letters. Use regex.
//Words	                                                           Output
//GoshO blabla NqmaSm1saL KvoStaA	                               GoshO KvoStaA

//AZ AK 47 RoBoT noWayouT	                                         AZ AK RoBoT

//DrakonI Navsekyde	                                                  DrakonI
public class p6StartAndEndsWithCapitalLetter {
   public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] elements = scan.nextLine().split("[ ]+");
	scan.close();
	String pattern0 = "[A-Z][A-Z]";
	String pattern1 = "[A-Z][a-z]+[A-Z]";
	String pattern2 = "[A-Z][a-z]+[A-Z][a-z]+[A-Z]";
	Pattern patrn  = Pattern.compile(pattern0);	
	for (int i = 0; i < elements.length; i++) {
		String currentElemnt = elements[i];
		Matcher match = patrn.matcher(currentElemnt);
		if (match.find()) {			
				System.out.print(match.group() + " ");			
		}
	}
	 patrn  = Pattern.compile(pattern1);	
	for (int i = 0; i < elements.length; i++) {
		String currentElemnt = elements[i];
		Matcher match = patrn.matcher(currentElemnt);
		if (match.find()) {
			if (currentElemnt.length() == match.group().length()) {
				System.out.print(match.group() + " ");
			}
		}
	}
	patrn  = Pattern.compile(pattern2);	
	for (int i = 0; i < elements.length; i++) {
		String currentElemnt = elements[i];
		Matcher match = patrn.matcher(currentElemnt);
		if (match.find()) {			
				System.out.print(match.group() + " ");			
		}
	}
   }
}
