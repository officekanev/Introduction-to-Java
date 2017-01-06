import java.util.Scanner;

//                                 Problem 2 – Terrorists Win!
//On de_dust2 terrorists have planted a bomb (or possibly several of them)! Write a program
//that sets those bombs off!
//A bomb is a string in the format |...|. When set off, the bomb destroys all characters inside.
//The bomb should also destroy n characters to the left and right of the bomb. n is determined by
//the bomb power (the last digit of the ASCII sum of the characters inside the bomb). Destroyed 
//characters should be replaced by '.' (dot). For example, we are given the following text:
// prepare|yo|dong
//The bomb is |yo|. We get the bomb power by calculating the last digit of the
//sum: y (121) + o (111) = 232. The bomb explodes and destroys itself and 2 characters to the 
//left and 2 characters to the right. The result is:
// prepa........ng
//Input
//The input data should be read from the console. On the first and only input line you will receive the text. 
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//The destroyed text should be printed on the console.
//Constraints
//•	The length of the text will be in the range [1...1000].
//•	The bombs will hold a number of characters in the range [0…100].
//•	Bombs will not be nested (i.e. bomb inside another bomb).
//•	Bomb explosions will never overlap with other bombs.
//•	Time limit: 0.3 sec. Memory limit: 16 MB. 
//Examples
//         Input	                               Output
//       prepare|yo|dong	                  prepa........ng
//	
//         Input	                               Ouput
//de_dust2 |A| the best |BB|map!	 de_d.............bes........p!

public class p2TerroristsWin {
   public static void main(String[] args) {
//	 Scanner scan = new Scanner(System.in);
//	 String line = scan.nextLine();
//	 String[] elements  = line.split("[|]");
//	 scan.close();
//	 int bombPower = 0;
//	 int count = 1;
//	 int ReplaceWordIndex = 0;
//	 int destroyCharacter = 0;
//	 char simbol =' ';
//	 char bombPowLeng = ' ';
//	 String rezult = "";
//	 if (elements.length == 3) {
//		 for (char ch : elements[count].toCharArray()) {
//				bombPower += ch;
//			}
//		 destroyCharacter = bombPower % 10;
//		 int lengthReplaseChar = elements[1].length() + (2 * destroyCharacter) + 2;
//		 rezult += elements[0].substring(0,elements[0].length()- destroyCharacter);
//		 for (int i = 0; i < lengthReplaseChar; i++) {
//			rezult += '.';
//		}
//		 rezult += elements[2].substring(destroyCharacter,elements[2].length() );
//		 
//	 } else {
//		for (int i = 0; i < elements.length; i++) {
//			bombPower = 0;
//			if (count == elements.length - 1) {
//				break;
//			}
//			 for (char ch : elements[count].toCharArray()) {
//					bombPower += ch;
//				}	
//			 destroyCharacter = bombPower % 10;
//			 if (ReplaceWordIndex == elements.length - 1) {	
//				 int countt = destroyCharacter;
//					for (int j2 = rezult.length()-1; j2  > 0; j2--) {
//						if (countt == 0) {
//							break;
//						}
//						rezult = rezult.replace(rezult.charAt(j2), '.');
//						countt--;
//					}	
//					int lengthReplaseChar = elements[count].length() + destroyCharacter + 2;	
//					 for (int g = 0; g < lengthReplaseChar; g++) {
//							rezult += '.';
//						}					
//					 rezult += elements[ReplaceWordIndex].substring(destroyCharacter,elements[ReplaceWordIndex].length());
//			}
//			 int lengthReplaseChar = elements[count].length() + (2 * destroyCharacter) + 2;
//			 rezult += elements[ReplaceWordIndex].substring(0,elements[ReplaceWordIndex].length()- destroyCharacter);
//			 ReplaceWordIndex+=2;		
//			 for (int g = 0; g < lengthReplaseChar; g++) {
//				rezult += '.';
//			}
//			 rezult += elements[ReplaceWordIndex].substring(destroyCharacter,elements[ReplaceWordIndex].length());
//			 ReplaceWordIndex+=2;
//			 count += 2;
//		}
//	 }
	   
	   
	   //  avt
	   
		Scanner input = new Scanner(System.in);
		StringBuilder text = new StringBuilder(input.nextLine());
		
		int currentIndex = 0,
			bombStartIndex = 0,
			bombEndIndex;
		
		while ((bombStartIndex = text.indexOf("|", currentIndex)) != -1) {
			bombEndIndex = text.indexOf("|", bombStartIndex + 1);
			String bombContent = text.substring(bombStartIndex + 1, bombEndIndex);
			
			int bombPower = getBombPower(bombContent),
				startIndex = Math.max(0, bombStartIndex - bombPower),
				endIndex = Math.min(text.length() - 1, bombEndIndex + bombPower);
			
			while (startIndex <= endIndex) {
				text.setCharAt(startIndex, '.');
				startIndex++;
			}
			
			currentIndex = bombEndIndex + 1;
		}
		
		System.out.println(text);
		input.close();
	}
	
	private static int getBombPower(String bombContent) {
		int bombPower = 0;
		for (char ch : bombContent.toCharArray()) {
			bombPower += ch;
		}
		
		return bombPower % 10;
	

	
   }
}




























