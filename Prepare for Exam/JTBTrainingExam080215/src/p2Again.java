import java.util.Scanner;

public class p2Again {
 public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] inputLine = scan.nextLine().split("[ ]+");//split("\\s+")
	double result = 0;
	for (String currentSequence : inputLine) {		
		double number = Double.parseDouble(currentSequence.substring(1, currentSequence.length() - 1));
		if (Character.isUpperCase(currentSequence.charAt(0))) {
			 number /= giveValueInEnglishAlphabet(currentSequence.charAt(0));
		}else {
			number *= giveValueInEnglishAlphabet(currentSequence.charAt(0));
		}
		if (Character.isUpperCase(currentSequence.charAt(currentSequence.length()-1))) {
			number -= giveValueInEnglishAlphabet(currentSequence.charAt(currentSequence.length()-1));
		}else {
			number += giveValueInEnglishAlphabet(currentSequence.charAt(currentSequence.length()-1));
		}
		result += number;
	}
	scan.close();
	System.out.printf("%.2f",result);
 }
 public static double giveValueInEnglishAlphabet(char character){
	 if (Character.isUpperCase(character)) {  
			return ((int) character - (int) 'A') + 1;
		} else {
			return ((int) character - (int) 'a') + 1;
		}
 }
}
