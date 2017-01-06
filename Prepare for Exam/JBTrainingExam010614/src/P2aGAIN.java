import java.util.Scanner;

public class P2aGAIN {
  public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	String[] cardFase = {"*","*","2","3","4","5","6","7","8","9",
//			"10","*","J","Q","K","A"};
//	String[] card = scan.nextLine().split(" ");
//	int result = 0;
//	for (int i = 0; i < card.length; i++) {
//		if (i == card.length - 1) {
//			String prev = card[i - 1].substring(0, card[i - 1].length() -1);
//			String curr = card[i].substring(0, card[i].length() -1);
//			String next = "";
//			int value = giveValue(cardFase,curr);			
//			result += reppeatSEquence(value,prev,curr,next);
//			break;
//		}else if (i == 0) {
//			String prev = "";
//			String curr = card[i].substring(0, card[i].length() -1);
//			String next = card[i + 1].substring(0, card[i + 1].length() -1);
//			int value = giveValue(cardFase,curr);
//			result += reppeatSEquence(value,prev,curr,next);
//		}else {
//			String prev = card[i - 1].substring(0, card[i - 1].length() -1);
//			String curr = card[i].substring(0, card[i].length() -1);
//			String next = card[i + 1].substring(0, card[i + 1].length() -1);
//			int value = giveValue(cardFase,curr);
//			result += reppeatSEquence(value,prev,curr,next);
//		}		
//	}
//	scan.close();
//	System.out.println(result);
//  }
//  
//  public static int giveValue(String[] cardFase,String curr){
//	  
//	  return Arrays.asList(cardFase).indexOf(curr);
//  }
//  
//  public static int reppeatSEquence(int value,String prev,
//		  String curr,String next){	  
//	    if (curr.equals(prev) || curr.equals(next)) {
//			return value * 2;
//		}else {
//			return value ;
//		} 
//  }
	  
	  // avt 
	  
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
