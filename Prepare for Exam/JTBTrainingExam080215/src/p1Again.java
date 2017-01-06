import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p1Again {
 public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int GandalfStartMood = Integer.parseInt(scan.nextLine());
	Pattern pattern = Pattern.compile("([a-z]+)");
	String line = scan.nextLine().toLowerCase();
	ArrayList<String> matches = new ArrayList<>();
	 Matcher match = pattern.matcher(line);
	 while (match.find()) {		
		 matches.add(match.group());
	}
	scan.close();
	for (String food : matches) {
		switch (food) {
		case "cram" : GandalfStartMood += 2; break;
		case "lembas" : GandalfStartMood += 3; break;
		case "apple" : GandalfStartMood += 1; break;
		case "melon" : GandalfStartMood += 1; break;
		case "honeycake" : GandalfStartMood += 5; break;
		case "mushrooms" : GandalfStartMood -= 10; break;
		default : GandalfStartMood -= 1; break;			
		}
	}
	if (GandalfStartMood < -5) {
		System.out.println(GandalfStartMood);
		System.out.println("Angry");
	}else if (GandalfStartMood >= -5 && GandalfStartMood < 0) {
		System.out.println(GandalfStartMood);
		System.out.println("Sad");
	}else if (GandalfStartMood >= 0 && GandalfStartMood < 15) {
		System.out.println(GandalfStartMood);
		System.out.println("Happy");
	}else if (GandalfStartMood >= 15) {
		System.out.println(GandalfStartMood);
		System.out.println("Special JavaScript mood");
	}
 }
}
