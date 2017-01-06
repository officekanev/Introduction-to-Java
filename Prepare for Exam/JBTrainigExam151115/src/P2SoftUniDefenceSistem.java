import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2SoftUniDefenceSistem {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String line = scan.nextLine();
	Pattern pattern = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]+[A-Z]).*?([0-9]+L)");
	while (!line.contains("OK KoftiShans")) {
		Matcher match = pattern.matcher(line);
		while (match.find()) {
			String name = match.group(1);
			String alcoholName = match.group(2);
			String amountAlcohol = match.group(3).substring(0, match.group(3).length()-1);
			String result = String.format("%s brought %s liters of %s!", name,amountAlcohol,alcoholName.toLowerCase());
			System.out.println(result);
		}
		line = scan.nextLine();
	}
	scan.close();
 }
}
