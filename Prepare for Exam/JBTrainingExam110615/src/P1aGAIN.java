import java.util.Scanner;

public class P1aGAIN {
 public static void main(String[] args) {
//	 Scanner scan = new Scanner(System.in);
//	 int lengthLine = Integer.parseInt(scan.nextLine());
//	 for (int i = 0; i < lengthLine; i++) {
//		 String line = scan.nextLine();		
//		 int lengthString = line.replaceAll("\\s*\\d*","").length();//\\S* - its all whitespace
//		 lengthString /= 2;                                        //\\d* - its all digits
//		  for (int j = 0; j < line.length(); j++) {			  
//				 if (!Character.isDigit(line.charAt(j))) {
//					 if (line.charAt(j) ==' ') {
//						 System.out.print(" ");
//					} else {
//						int calculateX = (int)line.charAt(j);
//						System.out.print((char)(calculateX + lengthString)) ;
//					}					 
//				}else{
//					System.out.print(line.charAt(j));
//				}
//		  }	
//		  System.out.println();	
//	}
//	 scan.close();
	 
	 
	 // moe again
	 
	 Scanner scan = new Scanner(System.in);
	 int inputLines = Integer.parseInt(scan.nextLine());		 
	 for (int i = 0; i < inputLines; i++) {
		 String result ="";
		 String line = scan.nextLine().trim();		 
		 int length = line.replaceAll(" ", "").length() / 2;		
		 for (int j = 0; j < line.length(); j++) {
			if (!Character.isSpaceChar(line.charAt(j))) {
				 result += (char)(line.charAt(j) + length);
			}else if (Character.isDigit(line.charAt(j))) {
				result += (char)(line.charAt(j));
			}else {
				result += " ";
			}
		}
		System.out.println(result);
	
	}
	 scan.close();
 }
}
