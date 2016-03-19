import java.util.Scanner;

//                                 Problem 10.	 Character Multiplier
//Create a method that takes two strings as arguments and returns the sum of their
//character codes multiplied (multiply str1.charAt (0) with str2.charAt (0) and add
//		to the total sum). Then continue with the next two characters. If one of
//the strings is longer than the other, add the remaining character codes to the 
//total sum without multiplication.
//    Input	                     Output
//  Gosho Pesho	                 53253
//   123   522	                  7647
//   a     aaaa	                  9700
public class CharacterMultiplier {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] arguments = scan.nextLine().split("[ ]+");
	scan.close();
	String argument1 =  arguments[0];
	String argument2 =  arguments[1];
	int rezult = sumCharacters(argument1,argument2);
	System.out.println(rezult);	
  }
  
  public static int sumCharacters(String argument1, String argument2) {
	  int rezult = 0;
	  int lengthArgument1 = argument1.length();
	  int lengthArgument2 = argument2.length();
	if (lengthArgument1 == lengthArgument2) {
		for (int i = 0; i < argument1.length(); i++) {
			char argum1 = argument1.charAt(i);
			char argum2 = argument2.charAt(i);
			rezult += (argum1 * argum2);
		}
	} else if(lengthArgument1 > lengthArgument2){
		for (int i = 0; i < argument1.length(); i++) {
			if (i > lengthArgument2 - 1 ) {
				char argum1 = argument1.charAt(i);
				rezult += argum1 ;
			}  else {
				char argum1 = argument1.charAt(i);
				char argum2 = argument2.charAt(i);
				rezult += (argum1 * argum2);
			}			
		}
	} else {
		for (int i = 0; i < argument2.length(); i++) {
			if (i > lengthArgument1 - 1 ) {
				char argum2 = argument2.charAt(i);
				rezult += argum2 ;
			}  else {
				char argum1 = argument1.charAt(i);
				char argum2 = argument2.charAt(i);
				rezult += (argum1 * argum2);
			}			
		}
	}
	  return rezult;
  }
}
