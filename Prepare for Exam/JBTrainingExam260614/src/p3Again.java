import java.util.Scanner;

public class p3Again {
  public static void main(String[] args) {
	   Scanner scan = new Scanner(System.in);
		String[] elements = scan.nextLine().split("[^0-9.]+");
		int [] digit = new int[elements.length - 1];
		for (int i = 1; i < elements.length; i++) {
			digit[i - 1] = Integer.parseInt(elements[i]);
		}
		scan.close();
		int MaxArea = 0;	
		for (int i = 0; i < digit.length; i+=2) {
			if (i >= digit.length - 4) {
				break;
			}
			int curr = ((digit[i] * digit[i+1]) + (digit[i+2] * digit[i+3]) +
					(digit[i+4] * digit[i+5]));
			if (curr > MaxArea) {
				MaxArea = curr;				
			}
		}
		System.out.println(MaxArea);
 }
}
