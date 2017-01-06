import java.util.Scanner;

//Problem 2 – Sum Cards
//Nakov is keen card player and he is now learning a new game. The game uses a 
//standard deck of 52 cards. The card faces are: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K and A.
//The cards suits are denoted by the letters S (spades), H (hearts), D (diamonds) and C (clubs).
//The player is given a hand of cards and he needs to count their sum. Card values are the
//following:
//2 -> 2, 3 -> 3, 4 -> 4, 5 -> 5, 6 -> 6, 7 -> 7, 8 -> 8,
//9 -> 9, 10 -> 10, J -> 12, Q -> 13, K -> 14, A -> 15 (the card suits are ignored).
//When two or more cards of the same face come sequentially, their values are counted twice.
//For example, the hand "2C 2H 2D AS 10H 10C 2S KD" has value
//(2 + 2 + 2) * 2 + 15 + (10 + 10) * 2 + 2 + 14 = 83.
//Write a program that takes a hand of cards and counts their sum.
//Input
//The input comes from the console as a single line, holding the hand of cards. Cards are 
//separated by a space.
//The input data will always be valid and in the format described. There is no need to 
//check it explicitly.
//Output
//Print at the console a single number: the value of the hand.
//Constraints
//•	The count the cards will be in the range [1…99].
//•	Card faces will be one of the following values: [2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A].
//•	Card suits will be one of the following values: [S, H, D, C].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples

//Input	                                                                   Output
//2C 2H 2D AS 10H 10C 2S KD	                                                83

//AS KH 10C	                                                                39

//2S 2C 2D 2H	                                                            16

//AS 10C KS KH KD 9H JH QS 3H QD QH 8S 10D 10S 7C JD	                    265

public class p2SumCard {

//	public static void main(String[] args) {                               ----- 90 points
//		Scanner scan = new Scanner(System.in);		
//		String[] inputCards = scan.nextLine().split(" ");
//		String[] sameValueOfTheCard = new String[inputCards.length];
//		for (int i = 0; i < sameValueOfTheCard.length; i++) {
//			String card = inputCards[i].substring(0, inputCards[i].length() -1);
//			sameValueOfTheCard[i] = card;
//		}
//		int coutPontRezult = 0;
//		String card ="";
//		String nextCard ="";
//		String previostCard ="";
//		for (int i = 0; i < sameValueOfTheCard.length; i++) {
//			if (i == 0) {
//				card = sameValueOfTheCard[i];
//				nextCard = sameValueOfTheCard[i + 1];
//				if (card.contains(nextCard)) {
//					int valueOfTheCard = sameValueOfTheCard(card);
//					coutPontRezult += valueOfTheCard * 2;
//				} else {
//					int valueOfTheCard = sameValueOfTheCard(card);
//					coutPontRezult += valueOfTheCard;
//				}				
//			} else if(i == sameValueOfTheCard.length - 1) {
//				card = sameValueOfTheCard[i];
//				previostCard = sameValueOfTheCard[i - 1];
//				if (card.contains(previostCard)) {
//					int valueOfTheCard = sameValueOfTheCard(card);
//					coutPontRezult += valueOfTheCard * 2;
//				} else {
//					int valueOfTheCard = sameValueOfTheCard(card);
//					coutPontRezult += valueOfTheCard;
//				}
//			} else {
//				card = sameValueOfTheCard[i];
//				previostCard = sameValueOfTheCard[i - 1];
//				nextCard = sameValueOfTheCard[i + 1];
//				if ((card.contains(previostCard)) || (card.contains(nextCard))) {
//					int valueOfTheCard = sameValueOfTheCard(card);
//					coutPontRezult += valueOfTheCard * 2;
//				} else {
//					int valueOfTheCard = sameValueOfTheCard(card);
//					coutPontRezult += valueOfTheCard;
//				}
//			}
//		}
//		scan.close();
//		System.out.println(coutPontRezult);
//	}
//	 
//	public static int sameValueOfTheCard(String card) {
//		int value = 0;
//		switch (card) {
//		case "2"  : value += 2; break;
//		case "3"  : value += 3; break;
//		case "4"  : value += 4; break;
//		case "5"  : value += 5; break;
//		case "6"  : value += 6; break;
//		case "7"  : value += 7; break;
//		case "8"  : value += 8; break;
//		case "9"  : value += 9; break;
//		case "10" : value += 10; break;
//		case "J"  : value += 12; break;
//		case "Q"  : value += 13; break;
//		case "K"  : value += 14; break;		
//		case "A"  : value += 15; break;						
//		default: break;			
//		}
//		return value;
//	}
	
	    // avtorsko
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String cardsSequence = input.nextLine();
		String[] cards = cardsSequence.split(" ");
		int sum = 0;
		int prevValue = -1;
		int count = 0;
		for (String card : cards) {
			int value = getCardValue(card);
			if (value == prevValue) {
				count++;
			} else {
				count = 1;
			}
			sum = sum + value;
			if (count == 2){
				sum = sum + 2 * value;
			}
			if (count > 2) {
				sum = sum + value;
			}
			prevValue = value;
		}
		input.close();
		System.out.println(sum);
	}

	private static int getCardValue(String card) {
		if (card.startsWith("2")) return 2;
		if (card.startsWith("3")) return 3;
		if (card.startsWith("4")) return 4;
		if (card.startsWith("5")) return 5;
		if (card.startsWith("6")) return 6;
		if (card.startsWith("7")) return 7;
		if (card.startsWith("8")) return 8;
		if (card.startsWith("9")) return 9;
		if (card.startsWith("10")) return 10;
		if (card.startsWith("J")) return 12;
		if (card.startsWith("Q")) return 13;
		if (card.startsWith("K")) return 14;
		if (card.startsWith("A")) return 15;
		throw new IllegalArgumentException("Invalid card: " + card);
	}
	
	

}
