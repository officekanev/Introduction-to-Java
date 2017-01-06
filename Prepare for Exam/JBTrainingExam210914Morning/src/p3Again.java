import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p3Again {
 public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String line = scan.nextLine().trim().replaceAll("[\\/\\\\\\)\\(\\|\\s]+", "");
	ArrayList<String> matcheingResult = new ArrayList<>();	
	Pattern pattern = Pattern.compile("[a-zA-Z]+");
	 Matcher match = pattern.matcher(line);
	 while (match.find()) {
	  matcheingResult.add(match.group());		
	}	
	scan.close();
	int maxValue = 0;
	String[] output = new String[2];
	for (int i = 1; i < matcheingResult.size(); i++) {
		int val1 = giveWordValue(matcheingResult.get(i - 1));
		int val2 = giveWordValue(matcheingResult.get(i));
		if (val1 + val2 >= maxValue) {
			maxValue = val1 + val2;
			output[0] =  matcheingResult.get(i - 1);
			output[1] =  matcheingResult.get(i);
		}
	}
	for (String string : output) {
		System.out.println(string);
	}
 }
 public static int giveWordValue(String firstWord){
	 int value = 0;
	 for (int i = 0; i < firstWord.length(); i++) {
		 if (Character.isUpperCase(firstWord.charAt(i))) {  
			 value += ((int) firstWord.charAt(i) - (int) 'A') + 1;
			} else {
			 value += ((int) firstWord.charAt(i) - (int) 'a') + 1;
			}
	}
	 return value;
 }
}
