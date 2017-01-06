import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class p2ThreeLargestNumbersAgain {
 public static void main(String[] args) {
//	 Scanner scan = new Scanner(System.in);          // 60 points
//	 int numberInputDigit = Integer.parseInt(scan.nextLine());
//	 List<BigDecimal> sorted = new ArrayList<BigDecimal>();
//	 for (int i = 0; i < numberInputDigit; i++) {
//		sorted.add(new BigDecimal(scan.nextLine()));
//	 }	 
//	 scan.close();
//	 Collections.sort(sorted);
//	 if (sorted.size() < 3) {
//		for (int i = sorted.size()-1; i >= 0; i--) {
//			System.out.println(sorted.get(i));
//		}
//	 }else {
//		 int count = 0;
//		 for (int i = sorted.size()-1; i > 0; i--) {
//			 if (count == 3) {
//				break;
//			 }
//				System.out.println(sorted.get(i));
//				count++;
//			}
//	 }
	 
	    Locale.setDefault(Locale.ROOT);
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		BigDecimal[] nums = new BigDecimal[n];
		for (int i = 0; i < nums.length; i++) {
			String num = input.nextLine();
			nums[i] = new BigDecimal(num);
		}
		Arrays.sort(nums);
		input.close();
		int count = 3;
		for (int i = nums.length-1; i >= 0 && count > 0; i--, count--) {
			System.out.println(nums[i].toPlainString());
		}
	
 }
}
