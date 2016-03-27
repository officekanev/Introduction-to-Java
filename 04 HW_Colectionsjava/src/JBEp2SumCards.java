import java.util.Scanner;

//                                       Problem 2** – Sum Cards
//Nakov is keen card player and he is now learning a new game. The game uses a standard deck of 52 cards. 
//The card faces are: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K and A. The cards suits are denoted by the 
//letters S (spades), H (hearts), D (diamonds) and C (clubs). The player is given a hand of cards 
//and he needs to count their sum. Card values are the following: 2 -> 2, 3 -> 3, 4 -> 4, 5 -> 5, 6 -> 6,
//7 -> 7, 8 -> 8, 9 -> 9, 10 -> 10, J -> 12, Q -> 13, K -> 14, A -> 15 (the card suits are ignored).
//When two or more cards of the same face come sequentially, their values are counted twice.
//For example, the hand "2C 2H 2D AS 10H 10C 2S KD" has value (2 + 2 + 2) * 2 + 15 + (10 + 10) * 2 + 2 + 14 = 83.
//Write a program that takes a hand of cards and counts their sum.
//Input
//The input comes from the console as a single line, holding the hand of cards. Cards are separated by a space.
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//Print at the console a single number: the value of the hand.
//Constraints
//•	The count the cards will be in the range [1…99].
//•	Card faces will be one of the following values: [2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A].
//•	Card suits will be one of the following values: [S, H, D, C].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//      Examples
//Input                                                     	Output
//2C 2H 2D AS 10H 10C 2S KD	                                     83

//AS KH 10C	                                                     39

//2S 2C 2D 2H	                                                 16

//AS 10C KS KH KD 9H JH QS 3H QD QH 8S 10D 10S 7C JD	265
public class JBEp2SumCards {
  public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
     String[] elements = scan.nextLine().split(" ");
     String currentEment = "";
     String prevEment = "";
	 String nextElemnt = "";
	 int totalResult = 0;	 
     for (int i = 0; i < elements.length; i++) {				
		if (i == 0) {
			currentEment = elements[i].substring(0,elements[i].length() -1);
			nextElemnt = elements[i + 1].substring(0,elements[i].length() -1);
			if (currentEment.equals(nextElemnt)) {
				int currentResult = ChekingValue(currentEment);
				totalResult += currentResult * 2;
			} else {
				int currentResult = ChekingValue(currentEment);
				totalResult += currentResult;
			}
		} else if (i == elements.length - 1) {
			currentEment = elements[i].substring(0,elements[i].length() -1);
			prevEment = elements[i - 1].substring(0,elements[i].length() -1);
            if (currentEment.equals(prevEment)) {
            	int currentResult = ChekingValue(currentEment);
				totalResult += currentResult * 2;
			} else {
				int currentResult = ChekingValue(currentEment);
				totalResult += currentResult;
			}
		} else {
			currentEment = elements[i].substring(0,elements[i].length() -1);
			nextElemnt = elements[i + 1].substring(0,elements[i].length() -1);
			prevEment = elements[i - 1].substring(0,elements[i].length() -1);
			if ((currentEment.equals(prevEment)) || (currentEment.equals(nextElemnt))) {
				int currentResult = ChekingValue(currentEment);
				totalResult += currentResult * 2;
			} else {
				int currentResult = ChekingValue(currentEment);
				totalResult += currentResult;	
			}
		}
	}
	 scan.close();
	 System.out.println(totalResult);
  }
  
  public static int ChekingValue(String currentEment){
	  int value = 0;
	  switch (currentEment) {
	case  "2" : value +=  2; break;
	case  "3" : value +=  3; break;
	case  "4" : value +=  4; break;
	case  "5" : value +=  5; break;
	case  "6" : value +=  6; break;
	case  "7" : value +=  7; break;
	case  "8" : value +=  8; break;
	case  "9" : value +=  9; break;
	case "10" : value += 10; break;
	case  "J" : value += 12; break;
	case  "Q" : value += 13; break;
	case  "K" : value += 14; break;
	case  "A" : value += 15; break;		
	default:break;		
	}
	  return value;
  }
}





























