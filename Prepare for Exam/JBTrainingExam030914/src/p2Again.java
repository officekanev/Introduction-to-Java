import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p2Again {
 public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int inputNUmber = Integer.parseInt(scan.nextLine());
	int[] digits = new int[inputNUmber];
	for (int i = 0; i < digits.length; i++) {
		digits[i] = scan.nextInt();
	}
	scan.close();
	String res = "";                         // ne e vqrno 10 points
	List<String> trashMatches = new ArrayList<String>();
	boolean noMatch = false;
	for (int i = 0; i < digits.length; i++) {
		for (int j = 0; j < digits.length; j++) {
			for (int j2 = 0; j2 < digits.length; j2++) {
				int result =  digits[i] + digits[j] + digits[j2];
				res = String.format("%d + %d + %d = %d degrees\n", digits[i],digits[j],
						digits[j2],result);
				if (result % 360 == 0 && !trashMatches.contains(res)) {
					System.out.printf("%d + %d + %d = %d degrees\n",digits[i],digits[j],
							 digits[j2],result);
					noMatch = true;
					trashMatches.add(res);
				}
			}
		}
	}
	if (!noMatch) {
		System.out.println("No");
	}
	 

 }
}
