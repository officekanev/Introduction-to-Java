import java.util.Scanner;

//                      Problem 9.	*Hit the Target
//Write a program that takes as input an integer – the target – and outputs to the
//console all pairs of numbers between 1 and 20, which, if added or subtracted,
//result in the target.
//Target	      Output            Target       Output
//          	1 + 4 = 5                        15 + 20 = 35
//              2 + 3 = 5                        16 + 19 = 35
// 5            3 + 2 = 5             35         17 + 18 = 35
//              …                                18 + 17 = 35
//              19 - 14 = 5                      19 + 16 = 35
//              20 - 15 = 5                      20 + 15 = 35
public class HitTheTarget {
   public static void main(String[] args) {
	  Scanner scan = new Scanner(System.in);
	  System.out.println("Please enter integer number target");
	  int target = scan.nextInt();
	  scan.close();
	  for (int i = 1; i <= 20; i++) {
		for (int j = 1; j <= 20; j++) {
			int num1 = i;
			int num2 = j;
			if ((num1 + num2 == target)) {
				System.out.printf("%1$d + %2$d = %3$d",num1,num2,target);
				System.out.println();
			} else if((num1 - num2 == target)) {
				System.out.printf("%1$d - %2$d = %3$d",num1,num2,target);
				System.out.println();
			}
		}
	  }
   }
}
