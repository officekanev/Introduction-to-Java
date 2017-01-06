import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//                               Problem 2 – Weird Script
//After exploring all of Outland, the next adventure that awaits you is Northrend. It is a long-forgotten land holding
//many secrets about the ancients. The wizards of Dalaran moved there, too. They’ve found an ancient tablet, but they
//cannot decipher it.
//You quickly notice that there is a key in the tablet – a number that corresponds to an English letter. The mapping is
//quite simple 1-26 are lowercase a-z, 27-52 are uppercase A-Z, 53-78 are a-z again, 79-104 are A-Z, and so on … The 
//first task is to find the key letter. Next, construct the key – it is done by joining two letters together. For instance,
//if the key letter is B, the key is BB. The second task is to find all strings that are located between two keys. For 
//instance, in the string asdadBBdoomiscomingBBasda, the string to search for is doomiscoming. Find all strings located 
//between two keys and print them to the console, each on a new line.
//Do not print empty strings!
//Input
//•	On the first line you are given a number N – the key number
//•	Until the command “End” is reached, you are given a series of strings, each on a new line.
//Output
//•	Print each string found on a new line.
//Constraints
//•	The number of strings is in range [2 … 100]
//•	Each string length is in range [1 … 100] and can contain any ASCII character.
//•	A string between two keys has length in range [0 .. 50]
//•	N is in range [1 … 231 – 1]
//•	Allowed memory: 16MB
//•	Allowed working time: 0.25s
//Examples
//Input	                          Output	                          Comments
//14                              Tremble,                14 is lowercase n. The key is nn. We extract all the strings
//ajhdnnTremble,nn                mortals,                between two keys and print them to the console.
//nnmortals,nnand87             and despair!
//12783nnand despair!nn
//End
	
//Input	                          Output	                         Comments
//79                                that's                    79 is A. The key is AA.
//AAthat'sAAAA                   One big string !
//One big string !AA
//End
public class p2WeirdScript {
  public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);    //20 point
//		int targetLETTER = Integer.parseInt(scan.nextLine());
//		char letter = ' ';
//		if (targetLETTER >= 1 && targetLETTER <= 26) {
//			 letter = findLetter(targetLETTER);
//		}else if (targetLETTER >= 27 && targetLETTER <= 52) {
//			 letter = Character.toUpperCase(findLetter(targetLETTER - 26));		
//		}else if (targetLETTER >= 53 && targetLETTER <= 78) {
//			 letter = findLetter(targetLETTER - 52);
//		}else if (targetLETTER >= 79 && targetLETTER <= 104) {
//			 letter = Character.toUpperCase(findLetter(targetLETTER - 78));
//		}
//		String line = scan.nextLine();
//		int starIndex = 0;
//		int endIndex = 0; int count = 0;
//		while (!line.contains("End")) {
//			for (int i = 0; i < line.length(); i++) {
//				if (i == line.length()-1) {
//					break;
//				}
//				char current = line.charAt(i);
//				char nextChar = line.charAt(i + 1);
//				if (current == letter && nextChar == letter) {				
//					count++;
//					if (count == 1) {
//						starIndex = i + 2;
//						if (i == line.length()-2) {
//							String result = line.substring(0, starIndex - 2);
//							System.out.println(result); break;
//						}
//					}else{
//						endIndex = i;
//						String result = line.substring(starIndex, endIndex);
//						System.out.println(result); count = 0;				
//							break;					
//					}
//				}			
//			}	
//			line = scan.nextLine();
//		}
//		scan.close();
	//  }
	//  
	//  public static char findLetter(int targetLETTER){
//		  char letter =' ';
//		  switch (targetLETTER) {
//		case 1 : letter ='a'; break;
//		case 2 : letter ='b'; break;	
//		case 3 : letter ='c'; break;	
//		case 4 : letter ='d'; break;
//		case 5 : letter ='e'; break;
//		case 6 : letter ='f'; break;
//		case 7 : letter ='g'; break;
//		case 8 : letter ='h'; break;
//		case 9 : letter ='i'; break;
//		case 10 : letter ='j'; break;
//		case 11 : letter ='k'; break;	
//		case 12 : letter ='l'; break;	
//		case 13 : letter ='m'; break;
//		case 14 : letter ='n'; break;
//		case 15 : letter ='o'; break;
//		case 16 : letter ='p'; break;
//		case 17 : letter ='q'; break;
//		case 18 : letter ='r'; break;
//		case 19 : letter ='s'; break;
//		case 20 : letter ='t'; break;	
//		case 21 : letter ='u'; break;	
//		case 22 : letter ='v'; break;
//		case 23 : letter ='w'; break;
//		case 24 : letter ='x'; break;
//		case 25 : letter ='y'; break;
//		case 26 : letter ='z'; break;
//		}
//		  return letter;
	//  }
		  
		  // var 2
		  
		  Scanner scn = new Scanner(System.in);

	      int keyNumber = Integer.parseInt(scn.nextLine());
	      keyNumber = keyNumber - 1;
	      int charCode = keyNumber % 26;

	      char keyLetter = (keyNumber / 26) % 2 == 0
	              ? (char)('a' + charCode)
	              : Character.toUpperCase((char)('a' + charCode));

	      String key = "" + keyLetter + keyLetter;
	      StringBuilder sb = new StringBuilder();

	      String line = scn.nextLine();
	      while (!line.equals("End")) {
	          sb.append(line);
	          line = scn.nextLine();
	      }

	      String message = sb.toString();
	      String pattern = key + "(.*?)" + key;
	      Pattern pat = Pattern.compile(pattern);
	      Matcher match = pat.matcher(message);

	      while (match.find()) {
	          if (match.group(1).length() > 0) {
	              System.out.println(match.group(1));
	          }
	      }
  }
}
