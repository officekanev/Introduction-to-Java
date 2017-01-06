import java.util.Scanner;

public class p3Again {
 public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] numbers = scan.nextLine().split("[^-+0-9.]+");
	scan.close();
	Integer[] digits = new Integer[numbers.length -1];
	int CountReppetNumbers = 0;
	for (int i = 1; i < numbers.length; i++) {
		digits[i - 1] = Integer.parseInt(numbers[i]);		
			if (i > 1) {
				if (numbers[1].equals(numbers[i])) {
					CountReppetNumbers++;
				}
			}		
	}
	int maxCount = 0;
	if (CountReppetNumbers == digits.length - 1) {
		System.out.println("1");		
	}else {		
		for (int i = 0; i < digits.length; i++) {
			int count = 0;	
				if (digits[0] % 2 == 0) {
					for (int j = i; j < digits.length; j++) {
						int CurrentNum = digits[j];
						if (CurrentNum == 0) {
							count++;
							continue;
						}else if (j % 2 == 0) {
							if (CurrentNum % 2 == 0) {
								count++;
							}else {
							 break;
							}
						}else {
							if (CurrentNum % 2 != 0) {
								count++;
							}else {
							 break;
							}
						}
					}
				} else {
	                for (int j = i; j < digits.length; j++) {
	                	int CurrentNum = digits[j];
	                	if (CurrentNum == 0) {
	    					count++;
	    					continue;
	    				}else if (j % 2 == 0) {
	    					if (CurrentNum % 2 != 0) {
	    						count++;
	    					}else {
							 break;
							}
	    				}else {
	    					if (CurrentNum % 2 == 0) {
	    						count++;
	    					}else {
							 break;
							}
	    				}
					}
				}														
			if (count > maxCount ) {
				maxCount = count;
			}
		}
		System.out.println(maxCount);
	}				
 }
}
