import java.util.Scanner;

//Problem 5.	* Print a Character Triangle
//Create a triangle of characters, based on input. Learn about java.util.Scanner
//and Integer.parseInt (). Test your program with integers up to 26. Think why.
//Input	Ouput               Input	Ouput
//5	      a                   3      a
//        a b                        a b
//        a b c                      a b c
//        a b c d                    a b
//        a b c d e                  a
//        a b c d
//        a b c
//        a b
//        a


public class PrintACharacterTriangle {
     public static void main(String[] args) {
    	 
    	                //  case printing digits
    	 
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter number of line");
		int lineNumbers = scan.nextInt();
		scan.close();
		int countLines = 1;
		for (int i = 0; i < lineNumbers; i++) {			
			for (int j = 0; j < countLines; j++) {
				System.out.print(j + " ");				
			}
			countLines++;
			System.out.println();
		}
		countLines = lineNumbers - 1;//because we already print center line,and next line is one digit less 
		for (int i = lineNumbers; i > 0; i--) {			
			for (int j = 0; j < countLines; j++) {
				System.out.print(j + " ");				
			}
			countLines--;
			System.out.println();
		}
		
		                //     case printing alphabet 
    	 
//		char[] array = {'a','b','c','d','e','f','g','h','i','j',
//				 'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//		int countLines = 1;
//		for (int i = 0; i < array.length; i++) {			
//			for (int j = 0; j < countLines; j++) {
//				System.out.print(array[j] + " ");				
//			}
//			countLines++;
//			System.out.println();
//		}
//		countLines = array.length - 1;//because we already print center line,and next line is one digit less 
//		for (int i = array.length - 1; i > 0; i--) {			
//			for (int j = 0; j < countLines; j++) {
//				System.out.print(array[j] + " ");				
//			}
//			countLines--;
//			System.out.println();
//		}
	}
}
