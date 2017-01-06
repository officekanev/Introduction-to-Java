import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p1ArangeNumbers {
  public static void main(String[] args) {
	  Scanner scan = new Scanner(System.in);
		 String[] numbers = scan.nextLine().split("[ ,]+");
		 Map<String, Integer> sortedNumbers = new HashMap<String, Integer>();
		 scan.close();
		 String resultWord = "";
		 for (int i = 0; i < numbers.length; i++) {
			String currentNumber = numbers[i];
			for (int j = 0; j < currentNumber.length(); j++) {
				char current = currentNumber.charAt(j);
				switch (current) {
				case '0': resultWord += "zero" + "-"; break;
				case '1': resultWord += "one" + "-"; break;
				case '2': resultWord += "two" + "-"; break;
				case '3': resultWord += "three" + "-"; break;
				case '4': resultWord += "four" + "-"; break;
				case '5': resultWord += "five" + "-"; break;
				case '6': resultWord += "six" + "-"; break;
				case '7': resultWord += "seven" + "-"; break;
				case '8': resultWord += "eight" + "-"; break;
				case '9': resultWord += "nine" + "-"; break;								
				default:
					break;
				}
			}
			int parseNum = Integer.parseInt(currentNumber);
			sortedNumbers.put(resultWord, parseNum);
			resultWord = "";
		}
		 int numberOfElements = numbers.length;
		 Map<String, Integer> sortedMapByKeys = new TreeMap<String,Integer>();
	     sortedMapByKeys.putAll(sortedNumbers);
	     for(Map.Entry<String,Integer> entry : sortedMapByKeys.entrySet()) {
	    	 Integer value = entry.getValue();
			System.out.print(value);
			if (numberOfElements == 1) {
				break;
			}
			System.out.print( ", ");
			numberOfElements--;
		}
 }
}
