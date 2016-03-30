import java.util.Arrays;
import java.util.Scanner;

//               Problem 2.	Sort array with stream API
//Use the .sorted() method to sort an array of integers. The first line of input is 
//the array. The second is the sorting order.
//   Input	                              Output
//6 8 3 1 7 2 2 5                      1 2 2 3 5 6 7 8
//Ascending	

//6 8 3 1 7 2 2 5                      8 7 6 5 3 2 2 1
//Descending	
public class p2SortArrayWithStreamAPI {
   public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
	 String line = scan.nextLine();
	 String order = "";
	 while (!line.isEmpty()) {
		String[] digit = line.split("[ ]+");
		Integer[] num = new Integer[digit.length];
		for (int i = 0; i < digit.length; i++) {
			num[i] = Integer.parseInt(digit[i]);
		}
		order = scan.nextLine();
		if (order.equals("Ascending")) {
			Arrays.stream(num).sorted().forEach(System.out::println);
		} else {
			Arrays.stream(num).sorted((num1,num2) -> num2.compareTo(num1)).forEach(System.out::println);
		}
		line = scan.nextLine();
	}
   }
}
