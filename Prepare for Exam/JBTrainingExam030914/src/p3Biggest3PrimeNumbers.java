import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//                          Problem 3 – Biggest 3 Prime Numbers
//You are given n numbers in format (a1) (a2) … (an). Write a program to find the sum of the
//3 biggest non-repeating prime numbers inside the input sequence. A prime number is a natural
//number greater than 1 that has no positive divisors other than 1 and itself.
//Input
//The input comes from the console. It consists of a single line holding the input sequence 
//of numbers. All numbers are in brackets. Spaces can be put anywhere between the numbers,
//even at the sequence start and at the sequence end. The input data will always be valid 
//and in the format described. There is no need to check it explicitly.
//Output
//Print the sum of the 3 biggest non-repeating prime numbers at the console. If there are
//no 3 non-repeating prime numbers in the sequence, print “No”.
//Constraints
//•	The input numbers will be integers in the range [-100…100].
//•	The count of the input numbers will be in the range [1…1000].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	                                                                 Output
//(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)	                                     15
//    (  -3  ) (2) (  1)	                                             No
//( ) (-10 ) ( 7 ) (5) (3) ( 5 ) ( 7 )(-3) ( 1) ( 17)	                 29
//(11 )   (-21   ) (  31 ) ( 41 ) (  51  )	                             83
//(11)(3)(8)(4)(-6)                                                      No

public class p3Biggest3PrimeNumbers {
	   public static void main(String[] args) {
		Scanner str = new Scanner(System.in);
		String input = str.nextLine();
		String pattern = "[0-9]+";
		Pattern r = Pattern.compile(pattern);	
		TreeSet<Integer> numberSet = new TreeSet<>(Collections.reverseOrder());
		 Matcher m = r.matcher(input);
		   while (m.find( )) {
			   int number = Integer.parseInt(m.group( ));
			   numberSet.add(number);
		      }		
		int primesCount = 0;
		int primeSum = 0;
		for (Integer possiblePrime : numberSet) {
			//exclude the numbers below 1 or all numbers after reaching sum of 3 prime numbers
			if (possiblePrime <= 1 || primesCount == 3) {
				break;
			}
			//check if the current number is prime number
			boolean isPrime = true;
			for (int i = 2; i < possiblePrime; i++) {
				if (possiblePrime % i == 0) {
					isPrime = false;
				}
			}
			//add the prime number to the sum and incrementing the primesCount
			if (isPrime) {
				primeSum += possiblePrime;
				primesCount ++;
			}
		}
		//print the result
		if (primesCount == 3) {
			System.out.println(primeSum);
		} else {
			System.out.println("No");
		}
		str.close();
		
	}
}
