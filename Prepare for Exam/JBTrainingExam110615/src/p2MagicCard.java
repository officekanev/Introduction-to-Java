import java.util.Arrays;
import java.util.Scanner;

//                                 Problem 2 – Magic Card
//Sashko loves to play card games. He even invented his own game. The game uses a standard deck of 52 cards.
//The card faces are: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K and A. The cards suits are denoted by the letters S
//(spades), H (hearts), D (diamonds) and C (clubs). The player is given a hand of cards, a string 
//(“odd” or “even”), and a magic card. You need to count the sum of all cards at odd or even positions 
//(positions start from 0). Card values are the following: 2 -> 20, 3 -> 30, 4 -> 40, 5 -> 50, 6 -> 60,
//7 -> 70, 8 -> 80, 9 -> 90, 10 -> 100, J -> 120, Q -> 130, K -> 140, A -> 150. When a card’s suit is 
//the same as the suit of the magic card its value is doubled. When a card’s face is the same as the 
//face of the magic card its value is tripled. The input hand will not contain the magic card.
//For example, if Sashko gets the hand "2C 2D 2H AS 10H 10C 2S 3S 5D KD", the string “odd” and a magic
//card “AD”. The value of the hand is 20 * 2 + 150 * 3 + 100 + 30 + 140 * 2 = 900.
//Write a program that takes a hand of cards and counts the sum.
//Input
//The input comes from the console. The first line is holding the hand of cards. Cards are separated by a space.
//The second line is holding a string – “odd” or “even”. The third line is holding the magic card.
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//Print at the console a single number: the value of the hand.
//Constraints
//•	The count of the cards will be in the range [1…99].
//•	Card faces will be one of the following values: [2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A].
//•	Card suits will be one of the following values: [S, H, D, C].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input                                                        Output
//2C 2D 2H AS 10H 10C 2S 3S 5D KD                               900
//odd
//AD

//AS KH 10C                                                     250
//even
//KD	

//AS 10C KS KH KD 9H JH QS 3H QD QH 8S 10D 10S 7C JD           1180
//even
//3D	
public class p2MagicCard {
   public static void main(String[] args) {
	   
	   // moe 100
	   
	Scanner scan = new Scanner(System.in);
	String[] cards = scan.nextLine().split(" ");
	String oddOrEven = scan.nextLine();
	String magicCard = scan.nextLine();	
	int result = 0;
	for (int i = 0; i < cards.length; i++) {
		if (oddOrEven.contains("odd")) {
			if (i % 2 != 0) {			
				 String cardFase = cards[i].substring(0, cards[i].length()-1);
				 String magicCardFase = magicCard.substring(0, magicCard.length()-1);
				 char cardSuit = cards[i].charAt(cards[i].length()-1);
				 char magicCardSuit = magicCard.charAt(magicCard.length()-1);
				if (cardFase.contains(magicCardFase)) {
					result += returnValue(cardFase) * 3;					
				} else if (cardSuit == magicCardSuit) {
					result += returnValue(cardFase) * 2;
				} else {
					result += returnValue(cardFase);
				}
			}
		}else {
			if (i % 2 == 0) {
				 String cardFase = cards[i].substring(0, cards[i].length()-1);
				 String magicCardFase = magicCard.substring(0, magicCard.length()-1);
				 char cardSuit = cards[i].charAt(cards[i].length()-1);
				 char magicCardSuit = magicCard.charAt(magicCard.length()-1);
				 if (cardFase.contains(magicCardFase)) {
					result += returnValue(cardFase) * 3;					
				 } else if (cardSuit == magicCardSuit) {
					result += returnValue(cardFase) * 2;
				 } else {
					result += returnValue(cardFase);
				 }
			}
		}		
	}
	System.out.println(result);
	result = 0;	
   }
   
   public static int returnValue(String cardFace){
	   int value = 0;
	   switch (cardFace) {
	   case "2"  :  value = 20; break;
	   case "3"  :  value = 30; break;
	   case "4"  :  value = 40; break;
	   case "5"  :  value = 50; break;
	   case "6"  :  value = 60; break;
	   case "7"  :  value = 70; break;
	   case "8"  :  value = 80; break;
	   case "9"  :  value = 90; break;
	   case "10" : value = 100; break;
	   case "J" :  value = 120; break;
	   case "Q" :  value = 130; break;
	   case "K" :  value = 140; break;
	   case "A" :  value = 150; break;
	default:
		break;
	}
	   return value;
   }
   
	   
   // avt
//	Scanner input = new Scanner(System.in);
//	
//	String[] cards = input.nextLine().split(" ");
//	String[] values = {"*", "*", "2", "3", "4", "5", "6", "7", "8", "9",
//	"10", "*", "J", "Q", "K", "A" };
//	String oddEven = input.nextLine();
//	String magicCard = input.nextLine();
//	int sum = 0;
//	
//	String magicCardFace = magicCard.substring(0, magicCard.length() - 1);
//	String magicCardSuit = magicCard.substring(magicCard.length() - 1, magicCard.length());
//	int cardsCount = cards.length;
//	int startPosition = oddEven.equals("odd") ? 1 : 0;
//			
//	for(int i = startPosition ; i < cardsCount ; i += 2) {
//		
//		String card = cards[i];
//		String cardFace = card.substring(0, card.length() - 1);
//		String cardSuit = card.substring(card.length() - 1, card.length());
//		int value = Arrays.asList(values).indexOf(cardFace) * 10;
//		
//		if(cardFace.equals(magicCardFace)) {
//			value *= 3;
//		}
//		else if(cardSuit.equals(magicCardSuit)) {
//			value *= 2;
//		}
//		
//		sum += value;
//	}
//	
//	System.out.println(sum);
//	
//	input.close();
//   }
}

































