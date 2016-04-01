import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Problem 5.	Extract words
//Write a program that extracts words from a string. Words are sequences of characters that are at 
//least two symbols long and consist only of English alphabet letters. Use regex.
//Words	                                              Output
//Az&76sym&&samo&cvqt&lilav	                 Az sym samo cvqt lilav

//Shoot18297the1231023dwarves!	               Shoot the dwarves

//1798No(*&Girls)*(09Allowed	                  No Girls Allowed
public class p5ExtractWords {
   public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in); 
		String line = scan.nextLine();
		scan.close();
		String pattern = "[a-zA-Z]+";
		Pattern patrn  = Pattern.compile(pattern);
		Matcher match = patrn.matcher(line);
		while (match.find()) {
		
			System.out.print(match.group() + " ");
		}
   }
}
