import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p3Ag {
 public static void main(String[] args) {
	Scanner scan = new Scanner (System.in);
	String [] elem = scan.nextLine().split("[^-+0-9.]+");
	List<Integer> surviveDigit = new ArrayList<Integer>();
	for (int i = 1; i < elem.length; i++) {
		double current = Double.parseDouble(elem[i]);
		int plock = (int)current;
		if (surviveDigit.contains(plock)) {
			continue;
		}
		if (current < 0 || current % 1 != 0 ||
				current % 2 == 0 || current % 3 == 0 && current != 3 ) {
			continue;
		}
		surviveDigit.add((int)current);
	}
	scan.close();
	int MaxSum = 0;
	if (surviveDigit.size() <= 2) {
		System.out.println("No");
	}else {
		for (int i = 0; i < surviveDigit.size(); i++) {
			for (int j = i + 1; j < surviveDigit.size(); j++) {
				for (int j2 = j + 1; j2 < surviveDigit.size(); j2++) {
					if (surviveDigit.get(i) + surviveDigit.get(j) +
							surviveDigit.get(j2) > MaxSum) {
						MaxSum = surviveDigit.get(i) + surviveDigit.get(j) +
								surviveDigit.get(j2);
					}
				}
			}
		}
		System.out.println(MaxSum);
	}
 }
}
