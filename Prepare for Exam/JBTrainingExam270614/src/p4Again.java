import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p4Again {
  public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
	LinkedHashMap<String,TreeMap<String,Integer>> orders =
			new LinkedHashMap<>();
	for (int i = 0; i < n; i++) {
		String customer = input.next();
		int amount = input.nextInt();
		String product = input.next();
		if (!orders.containsKey(product)) {
			orders.put(product, new TreeMap<String,Integer>());
		}
		TreeMap<String,Integer> amounts = orders.get(product);
		int oldAmount = 0;
		if (amounts.containsKey(customer)) {
			oldAmount = amounts.get(customer);
		}
		amounts.put(customer, oldAmount + amount);
	}
	input.close();
	for (String product : orders.keySet()) {
		System.out.println(product + ": ");
		TreeMap<String,Integer> amounts = orders.get(product);
		boolean first = true;
		for (Map.Entry<String, Integer> pair : amounts.entrySet()) {
			if (!first) {
				System.out.println(", ");
			}
			first = false;
			String customer = pair.getKey();
			int amount = pair.getValue();
			System.out.println(customer + " " + amount);
		}
		System.out.println();
	}
 }
}
