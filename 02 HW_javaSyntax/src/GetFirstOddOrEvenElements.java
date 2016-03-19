import java.util.Scanner;

//                      Problem 11.	 Get First Odd or Even Elements
//Write a method that returns the first N odd/even elements from a collection.
//Return as many as you can.
//Format: [Get <number of elements> <odd/even>]
//Input	               Output
//1 2 3 4 5            1 3 5
//Get 3 odd 

//11 6 2 8 1 0         6 2 8 0
//Get 8 even	
public class GetFirstOddOrEvenElements {
   public static void main(String[] args) {
	  Scanner scan = new Scanner(System.in);
	  String[] elements = scan.nextLine().split("[ ]+");
	  String[] targetNumbers = scan.nextLine().split("[ ]+");
	  scan.close();
	  int requireNum = Integer.parseInt(targetNumbers[1]);
	  String oddOrEven = targetNumbers[2];
	  String rezult = returnsOddOrEvenSequence(elements, requireNum, oddOrEven);
	  System.out.println(rezult);
   }
   
   public static String returnsOddOrEvenSequence(String[] elemnts, int requireNum,String oddOrEven){
	   String rezult = "";
	   int count = 0;
	   if (oddOrEven.contains("odd")) {
			 for (int i = 0; i < elemnts.length; i++) {
				if (count == requireNum) {
						break;
				}
				int currentNum = Integer.parseInt(elemnts[i]);
				if (currentNum % 2 != 0) {
					rezult += currentNum + " ";
					count++;
				}				
		     } 
		 } else {
			 for (int i = 0; i < elemnts.length; i++) {
				if (count == requireNum) {
					break;
				}
				int currentNum = Integer.parseInt(elemnts[i]);
				if (currentNum % 2 == 0) {
					rezult += currentNum + " ";
					count++;
				}				
			 }
		 }	  		
	   return rezult;
   }
}






























