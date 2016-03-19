import java.util.Random;
import java.util.Scanner;

//Problem 7.	Randomize numbers from N to M
//Write a program that takes as input two integers N and M,
//and randomizes the numbers between them. Note that M may be smaller than or equal to N.
//N	            M	            Randomized (your output may be different : ))
//13	        10	            10 12 13 11
//10	        20	            12 13 20 10 11 18 15 17 14 19 16 
//5	            5	            5

public class RandomizeNumbersfromNtoM {
   public static void main(String[] args) {
	   System.out.println("Please enter two integer numbers in separate line");
	   Scanner scan = new Scanner(System.in);
	   int startNum = scan.nextInt();
	   scan.nextLine();
	   int endNum = scan.nextInt();
	   scan.close();
	   Random rand = new Random();
	   int lengthOfGenerateNumbers = endNum - startNum;
	   if (lengthOfGenerateNumbers < 0) {
		   lengthOfGenerateNumbers *= -1;
	   } else if(lengthOfGenerateNumbers == 0){
		   lengthOfGenerateNumbers = 1;
	   }
	   for (int i = 0; i < lengthOfGenerateNumbers + 1; i++) {
		   int  Result = rand.nextInt(endNum-startNum) + startNum;
		   System.out.print(Result + " ");
	   }
	  
	 
   }
}
