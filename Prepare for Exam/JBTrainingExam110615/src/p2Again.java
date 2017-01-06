import java.util.Arrays;
import java.util.Scanner;

public class p2Again {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] carsFace = {"*","*","2","3","4","5","6","7","8","9","10","*","J","Q","K","A"};
	String[] cards = scan.nextLine().split(" ");
	String oddOrEven = scan.nextLine();
	String magicCard = scan.nextLine();
	scan.close();
	String magicKard =  magicCard.substring(0, magicCard.length()-1);
	char magicFace = magicCard.charAt(magicCard.length()-1);
	int startIndex = oddOrEven.equals("even") ? 0 : 1;
	int result = 0;
	for (int i = startIndex; i < cards.length; i+=2) {
		String currentCardFace = cards[i].substring(0, cards[i].length()-1);
		char currentCardSuite = cards[i].charAt(cards[i].length()-1);
		int value = Arrays.asList(carsFace).indexOf(currentCardFace) * 10;
		if (currentCardFace.contains(magicKard)) {
			value *= 3;
		}
		if (magicFace == currentCardSuite) {
			value *= 2;
		}
		result += value;
	}
	System.out.println(result);
 }
}
