import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//                                              Problem 4 – Orders
//You are given a sequence of n orders in format <customer> <amount> <product>. Example:
//•	steve 8 apples
//•	maria 3 bananas
//•	kiro 3 bananas
//•	kiro 9 apples
//•	maria 2 apples
//•	steve 4 apples
//•	kiro 1 bananas
//•	kiro 1 apples
//Write a program that prints all products in the order of their first appearance. For each product print the customers and their
//aggregated ordered amounts. Order the customers by name alphabetically. Print the result in the following 
//format: <product>: <customer> <amount>, <customer> <amount>, … For the orders above the output should be:
//•	apples: kiro 10, maria 2, steve 12
//•	bananas: kiro 4, maria 3
//Input
//The input comes from the console. At the first line the number n stays alone. At the next n lines, we have n orders in 
//format <customer> <amount> <product>.
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//Print one line for each product. Product lines should be ordered in the same way in which the products first appear
//in the input. For each product print the customers ordered this product in alphabetical order, along with the total
//ordered amount for each customer in format <product>: <customer> <amount>, <customer> <amount>, …
//Constraints
//•	The count of the order lines n will be in the range [1…100].
//•	The <customer> and <product> will consist of only of Latin characters, with length of [1…20].
//•	The <amount> will be integer number in the range [1…100].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	                     Output	                     	    Input	                  Output
//8                   apples: kiro 10, maria 2, steve 12   bob 3 whiskeys        beers: alex 5, bob 10, kiro 1, mimi 2
//steve 8 apples      bananas: kiro 4, maria 3             kiro 1 beers          vodkas: kiro 1
//maria 3 bananas                                          mimi 2 beers
//kiro 3 bananas                                           alex 4 beers
//kiro 9 apples                                            alex 1 beers
//maria 2 apples                                           kiro 1 vodkas
//steve 4 apples                                           bob 10 beers
//kiro 1 bananas
//kiro 1 apples	
public class p4Orders {
	public static void main(String[] args) {

		// Process the input orders and put them in a map
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		LinkedHashMap<String, TreeMap<String, Integer>> orders =
				new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String customer = input.next();
			int amount = input.nextInt();
			String product = input.next();
			if (!orders.containsKey(product)) {
				orders.put(product, new TreeMap<String, Integer>());
			}
			TreeMap<String, Integer> amounts = orders.get(product);
			int oldAmount = 0;
			if (amounts.containsKey(customer)) {
				oldAmount = amounts.get(customer);
			}
			amounts.put(customer, oldAmount + amount);			
		}
		
		// Print the products and their customers and amounts
		for (String product : orders.keySet()) {
			System.out.print(product + ": ");
			TreeMap<String, Integer> amounts = orders.get(product);
			boolean first = true;
			for (Map.Entry<String, Integer> pair : amounts.entrySet()) {
				if (!first) {
					System.out.print(", ");
				}
				first = false;
				String customer = pair.getKey();
				int amount = pair.getValue();
				System.out.print(customer + " " + amount);
			}
			System.out.println();
		}
	}
}
