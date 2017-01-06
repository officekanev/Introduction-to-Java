import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p4Nuts {
   public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int numberOfLines = Integer.parseInt(scan.nextLine());
	Map<String, Map<String, Integer>> ordersMap = new TreeMap<>();
	for (int i = 0; i < numberOfLines; i++) {
		String[] elements = scan.nextLine().split(" ");
		String kompanyName = elements[0];
		String kindNuts = elements[1];
		int weight = Integer.parseInt(elements[2].substring(0, elements[2].length() - 2));
		if (ordersMap.get(kompanyName) == null) {
			ordersMap.put(kompanyName, new LinkedHashMap<>());
			ordersMap.get(kompanyName).put(kindNuts, weight);
		}else {
			if (ordersMap.get(kompanyName).get(kindNuts) == null) {
				ordersMap.get(kompanyName).put(kindNuts, weight);
			}else {
				int oldWeight = ordersMap.get(kompanyName).get(kindNuts);
				ordersMap.get(kompanyName).put(kindNuts, weight + oldWeight);
			}
		}
	}
	scan.close();
	for (String key : ordersMap.keySet()) {
		String result = key + ": ";
		Map<String,Integer> innerMap = ordersMap.get(key);
		for (String innerKey : innerMap.keySet()) {
			result += String.format("%s-%dkg, ", innerKey,innerMap.get(innerKey));
		}
		System.out.println(result.substring(0, result.length()-2));
	}
  }
}











