//        Problem 7.	Combine Lists of Letters
//Write a program that reads two lists of letters l1 and l2 and combines them:
//appends all letters c from l2 to the end of l1, but only when c does not appear 
//in l1. Print the obtained combined list. All lists are given as sequence of 
//letters separated by a single space, each at a separate line. Use ArrayList<Character>
//of chars to keep the input and output lists. Examples:
//Input	                                                   Output
//h e l l o                                                h e l l o w
//l o w	
//a b c d
//x y z	                                                   a b c d x y z

//a b a                                                    a b a
//b a b a	

//w e l c o m e t o s o f t u n i                   w e l c o m e t o s o f t u n i j a v a p r g r a g
//j a v a p r o g r a m m i n g	


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p7countSubstringOccurences {	 	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line1 = input.nextLine();	
		String line2 = input.nextLine();
		input.close();
		String outputString = "";
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < line1.length(); i++) {
			char curr = line1.charAt(i);
			list.add(curr);
		}
		outputString += line1;
		for (int i = 0; i < line2.length(); i++) {
			char currr = line2.charAt(i);
			if (list.contains(currr)) {
				continue;
			} else {
				outputString += " " + currr;
			}
		}
		System.out.println(outputString);
   }	
}
