//Problem 7.	 ***Magic exchangeable words
//Write a method that takes as input two strings of equal length, and returns Boolean if they 
//are exchangeable or not. Exchangeable are words where the characters in the first string can
//be replaced to get the second string. Example: egg and add are exchangeable, but aabbccbb and
//nnooppzz are not. (First bb corresponds to oo, but second bb corresponds to zz)
//Input	                                        Output

//gosho hapka	                                true

//aabbaa ddeedd	                                true

//foo bar	                                    false

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p7MagicExangeableWords {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");
        scan.close();
        char[] word1 = words[0].toCharArray();
        char[] word2 = words[1].toCharArray();       
        if (word1.length != word2.length) {
        	System.out.println("false");       	
        } else {
        	boolean isTrue = false;
        	 List<Character> wor1 = new ArrayList<Character>();
             List<Character> wor2 = new ArrayList<Character>();
             int CountLengthWord = 0;
             for (int i = 0; i < word1.length; i++) {
            	 CountLengthWord++;
            	 char w1currentChar = word1[i];
            	 char w2currentChar = word2[i];
				if (!wor1.contains(w1currentChar)) {
					wor1.add(w1currentChar);
					wor2.add(w2currentChar);
				} else if(wor1.contains(w1currentChar)){
					int index = wor1.indexOf(word1[i]);
					if (wor2.get(index) != w2currentChar) {
						System.out.println("false"); 
						 isTrue = true ;
						break;
					}
				}
			}
             if (CountLengthWord == word1.length && (!isTrue)) {
            	 System.out.println("true");
			}
        }                              
	}
}
