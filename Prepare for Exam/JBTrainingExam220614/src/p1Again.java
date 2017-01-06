import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p1Again {
 public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
		String line = scan.nextLine().trim();
		ArrayList<String> matcheingResult = new ArrayList<>();	
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		 Matcher match = pattern.matcher(line);
		 while (match.find()) {
		  matcheingResult.add(match.group());		
		}	
		scan.close();
		ArrayList<String> trashWord = new ArrayList<>();
		ArrayList<String> outputWord = new ArrayList<>();
		boolean haveMatchs = false;
		for (int i = 0; i < matcheingResult.size(); i++) {
			for (int j = 0; j < matcheingResult.size(); j++) {	
				if (i == j) {
					continue;
				}
				for (int f = 0; f < matcheingResult.size(); f++) {
					String leftSide = matcheingResult.get(i) + matcheingResult.get(j);
					if (leftSide.equals(matcheingResult.get(f))  && !trashWord.contains(matcheingResult.get(f))) {
						outputWord.add(matcheingResult.get(i) + "|" + matcheingResult.get(j) + "=" + matcheingResult.get(f));						
						trashWord.add(matcheingResult.get(f));
						haveMatchs = true;
					}
				}
			}
		}
		if (haveMatchs) {
			for (String outputWords : outputWord) {
				System.out.println(outputWords);
			}
		}else {
			System.out.println("No");
		}		
 }
}
