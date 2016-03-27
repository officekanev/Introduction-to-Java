import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Problem 6.	Count Specified Word
//Write a program to find how many times a word appears in given text. The text is given at the first input 
//line. The target word is given at the second input line. The output is an integer number. Please ignore
//the character casing. Consider that any non-letter character is a word separator. Examples:
//Input	                                                                          Output
//Welcome to the Software University (SoftUni)! Welcome to programming.              2
//welcome	

//I am coming...                                                                     0
//hello	
 
//It's OK, I'm in.                                                                   1
//i	
//Java is a set of several computer software products and specifications from        2
//Oracle Corporation that providesa system for developing application software
//and deploying it in a cross-platform computing environment.Java is used in a 
//wide variety of computing platforms from embedded devices and mobile phones 
//on the low end,to enterprise servers and supercomputers on the high end.
//is	

public class p6CountSpecificWord {
   public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);		
		int result = 0;
		String chekingText = input.nextLine();			 
	     String pattern = "[a-zA-z]+";
		Pattern r = Pattern.compile(pattern);
		 Matcher math = r.matcher(chekingText);
		 List<String> elements = new ArrayList<String>();
		// !!!!!!!!  I think that the condition or results are written nekorektno.
		// Because if first inspection check for word with minuscule result is 
		 // zero, not 2. Save it did not say the word (letter) either whole should
		 //be independent or contained as part of a word as the third proverka.Because
		 //look as if only a little letter 'and' the result will be zero rather than 1 au. !!!!!
		 String target = input.nextLine();
		 while (math.find( )) {				
			 elements.add(math.group());
		}
		 for (String word : elements) {
			if (target.equals(word) && (target.length() == word.length())) {
				result++;
			}
		}
		System.out.println(result);
		input.close();
											
   }
}
