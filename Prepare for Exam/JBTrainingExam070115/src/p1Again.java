import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p1Again {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int NumberOfLines = Integer.parseInt(scan.nextLine());
	int StartPiramidNumber = scan.nextInt();
	scan.nextLine();
	ArrayList<Integer> elements;
	ArrayList<Integer> printResult = new ArrayList<>();
	printResult.add(StartPiramidNumber);
	for (int i = 0; i < NumberOfLines - 1; i++) {
		 elements = new ArrayList<>();
		 String[] elem = scan.nextLine().trim().split("[ ]+");
		 for (int j = 0; j < elem.length; j++) {
			 elements.add(Integer.parseInt(elem[j]));
		 }
		 Collections.sort(elements);
		 int count = 0;
		for (Integer number : elements) {
			if (number > StartPiramidNumber) {
				count++;
				printResult.add(number);
				StartPiramidNumber = number;
				break;
			}			
		}
		if (count == 0) {
			StartPiramidNumber++;
		}
    }
	scan.close();
	for (int i = 0; i < printResult.size(); i++) {
		if (i == printResult.size()- 1) {
			System.out.print(printResult.get(i));
			break;
		}
		System.out.printf("%d, ",printResult.get(i));
	}
	
 }
}
