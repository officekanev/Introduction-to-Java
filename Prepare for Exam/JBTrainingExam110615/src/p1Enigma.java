import java.util.Scanner;

//                                            Problem 1 – Enigma
//You are given n lines of encrypted messages. The messages will contain ASCII characters. In each message,
//only the Latin letters and special characters will be encrypted. The numbers and whitespace will not be 
//encrypted. Your task is to write a program to decrypt the messages. The formula for the decrypting each 
//letter is X = k + m, where X is the ASCII code of the decrypted letter, k is the ASCII code of the encrypted
//character and m is the integer half of the length of the input line, without the numbers and whitespace.
//(Hint: length()/2)
//Input
//The input comes from the console. The first line holds the count n. After that there are n lines with
//the encrypted messages. 
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//Print at the console the decrypted messages, each on separate line.
//Each message should hold the numbers, whitespace and decrypted letters. See the examples below. 
//Constraints
//The count n will be an integer number in the range [1…50].
//The input lines length will be an integer number in the range [1...35].
//The input lines may hold any ASCII character.
//Time limit: 0.2 sec. Memory limit: 16 MB.
//Examples
//Input	                                                       Output
//1                                                       SoftUni has Great Secret
//Ie\jkd_ ^Wi =h[Wj I[Yh[j	                        The length without whitespaces is 21.
//                                                   Integer division 21/2 = 10. 
//                                                 ASCII(I) = 73. 73 + 10 = 83. 83 = ASCII(S). 
//                                                ASCII(e) = 101. 101 + 10 = 111. 111 = ASCII(o).

//Input	                                                             Output
//3                                                                 Welcome
//Tbi`ljb                                                           to the
//rm rfc                                                            jungle
//grkdib	

//Input	                                                             Output
//1                                                           We have 350 missiles
//P^ aZo^ 350 fbllbe^l	
public class p1Enigma {
   public static void main(String[] args) {
	   
	// moe ne raboti korektno
	   
//	 Scanner scan = new Scanner(System.in);     
//	 int lineNumber = scan.nextInt();
//	 scan.nextLine();
//	 StringBuilder sb = new StringBuilder();
//     for (int i = 0; i < lineNumber; i++) {
//    	 String line =  scan.nextLine();
//    	 String cleanLine = "";   	
//    	 for (int j = 0; j < line.length(); j++) {
//    			char temp = line.charAt(j);
//    			if (!(temp >= 0 && temp <= 9) && (temp != ' ')){
//    				cleanLine += temp;
//    			}
//    		}
//    	 int divideLength = cleanLine.length() / 2;   	
//    	 for (int c = 0; c < cleanLine.length(); c++) {
//    		 int temp = (int)line.charAt(c);
//   		 temp += divideLength;
//
//    		 sb.append((char)temp);
//		}
//    	 System.out.println(sb);
//    	 sb = new StringBuilder();
//	}	
//	 scan.close();
	   
	   // var  2
	   
	   Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());

		String[] lines = new String[n];
		for (int i = 0; i < lines.length; i++) {
			lines[i] = scan.nextLine();
		}

		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String withoutWhitespacesAndNumbers = line.replaceAll("\\s*\\d*","");
			int length = withoutWhitespacesAndNumbers.length() / 2;

			for (int j = 0; j < line.length(); j++) {
				if (Character.isDigit(line.charAt(j))) {
					System.out.print(line.charAt(j));
				}

				else if (line.charAt(j) == ' ') {
					System.out.print(" ");
				}

				else {
					int ascii = (int) line.charAt(j);
					System.out.print((char) (ascii + length));
				}
			}
			
			System.out.println();
			scan.close();
		}
	 
   }
}





































