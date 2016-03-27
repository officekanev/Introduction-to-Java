import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//            Problem 10.	Cards Frequencies
//We are given a sequence of N playing cards from a standard deck. The input consists of
//several cards (face + suit), separated by a space. Write a program to calculate and print 
//at the console the frequency of each card face in format "card_face -> frequency". The frequency
//is calculated by the formula appearances / N and is expressed in percentages with exactly 2
//digits after the decimal point. The card faces with their frequency should be printed in the
//order of the card face's first appearance in the input. The same card can appear multiple
//times in the input, but it's face should be listed only once in the output. Examples:
//Input                                              	Output
//8♥ 2♣ 4♦ 10♦ J♥ A♠ K♦ 10♥ K♠ K♦	                        8 -> 10.00%
//                                                          2 -> 10.00%
//                                                          4 -> 10.00%
//                                                          10 -> 20.00%
//                                                          J -> 10.00%
//                                                          A -> 10.00%
//                                                          K -> 30.00%

//J♥ 2♣ 2♦ 2♥ 2♦ 2♠ 2♦ J♥ 2♠	                            J -> 22.22%
//                                                          2 -> 77.78%

//10♣ 10♥	                                               10 -> 100.00%

public class p10CardsFrequencies {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] elements = scan.nextLine().split("[ ♠♥♦♣]+");
	scan.close();
	int elementsCount = elements.length;
	int appearsCount = 1;
	String elem1;
	List<String> checkingCard = new ArrayList<String>();
	for (int i = 0; i < elements.length; i++) {
		 elem1 = elements[i];
		 if (checkingCard.contains(elem1)) {
			continue;
		}
		for (int j = i + 1; j < elements.length; j++) {			
			String elem2 = elements[j];
			if (elem1.contains(elem2)) {
				appearsCount++;
			}
		}
		double result =  ((double)appearsCount * 100) /  elementsCount;
		System.out.printf(elem1 + " -> %.2f",result);
		System.out.println("%");
		appearsCount = 1;
		checkingCard.add(elem1);
	 }
  }
}
