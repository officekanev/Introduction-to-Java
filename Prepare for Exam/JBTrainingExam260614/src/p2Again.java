import java.util.Scanner;

public class p2Again {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = Integer.parseInt(scan.nextLine());
	int[] digits = new int[n];
	for (int i = 0; i < n; i++) {
		digits[i] = Integer.parseInt(scan.nextLine());
	}
	scan.close();
	boolean noMatch = false;
	for (int i = 0; i < digits.length; i++) {
		for (int j = 0; j < digits.length; j++) {
			for (int j2 = 0; j2 < digits.length; j2++) {
				if (digits[i] <= digits[j]) {
					 boolean check = (digits[i] * digits[i]) + (digits[j] * digits[j])
							 == (digits[j2] * digits[j2]);
						 if (check) {
							System.out.printf("%d*%d + %d*%d = %d*%d\n",digits[i],digits[i],
									digits[j],digits[j],digits[j2],digits[j2]);
							 noMatch = true;
						 }
				}
								
			}
	   }
	}
	if (!noMatch) {
		System.out.println("No");
	}
  }
}
