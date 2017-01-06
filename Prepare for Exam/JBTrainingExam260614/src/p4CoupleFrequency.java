import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

//                                                      Problem 4 – Couples Frequency
//Couple	Occurrences	Percentage
//3 4	3 times	30.00%
//4 2	2 times	20.00%
//2 3	2 times	20.00%
//2 1	1 times	10.00%
//1 12	1 times	10.00%
//12 2	1 times	10.00%
//Write a program that reads a sequence of n integers and calculates and prints the frequencies of all couples of two consecutive
//numbers. For example, for the input sequence { 3 4 2 3 4 2 1 12 2 3 4 }, we have 10 couples (6 distinct), shown on the right 
//with their occurrence counts and frequencies (in percentage).
//Input
//The input data should be read from the console. At the first line, we have the input sequence of integers, separated by a space.
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//Print all distinct couples of two consecutive numbers (without duplicates) found in the input sequence (from left to right) 
//along with their frequency of appearance in the input sequence (in percentages, with two decimal digits, with traditional 
//		rounding). Use the format: "couple -> percentage" (see the examples below). Beware of formatting!
//Constraints
//•	All input numbers will be integers in the range [-100 000 … 100 000].
//•	The count of the numbers will be in the range [2..1000].
//•	Time limit: 0.5 sec. Memory limit: 16 MB.
//Examples
//Input		                             Input		                                Input
//3 4 2 3 4 2 1 12 2 3 4     5 10 5 10 10 5 5 10 5 10 10 5		              10 20 10 10 10
//Output		                        Output		                                Output
//3 4 -> 30.00%                      5 10 -> 36.36%                           10 20 -> 25.00%
//4 2 -> 20.00%                      10 5 -> 36.36%                           20 10 -> 25.00%
//2 3 -> 20.00%                      10 5 -> 36.36%                           10 10 -> 50.00%
//2 1 -> 10.00%                      5 5 -> 9.09%
//1 12 -> 10.00%
//12 2 -> 10.00%				
public class p4CoupleFrequency {
public static void main(String[] args) {
		
		// Read the input numbers
		Scanner input = new Scanner(System.in);
		String sequence = input.nextLine();
		String[] numsStr = sequence.split(" ");
		int[] nums = new int[numsStr.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(numsStr[i]);
		}
		
		// Calculate number of occurrences of each two consecutive numbers
		HashMap<String, Integer> counts = new HashMap<>();
		for (int i = 1; i < nums.length; i++) {
			int first = nums[i-1];
			int second = nums[i];
			String key = first + " " + second;
			Integer count = counts.get(key);
			if (count == null) {
				count = 0;
			}
			count++;
			counts.put(key, count);
		}

		// Calculate the frequencies and print them in percentages
		HashSet<String> printedCouples = new HashSet<>();
		for (int i = 1; i < nums.length; i++) {
			int first = nums[i-1];
			int second = nums[i];
			String key = first + " " + second;
			if (! printedCouples.contains(key)) {
				int count = counts.get(key);
				float frequency = (float)count / (nums.length - 1);
				System.out.printf("%s -> %.2f%%\n", key, frequency*100);
				printedCouples.add(key);
			}			
		}
		input.close();
	}
}


























