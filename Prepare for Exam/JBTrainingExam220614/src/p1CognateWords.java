import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1CognateWords {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] line = scan.nextLine().split("[^a-zA-Z]+");
	List<String> trashResult = new ArrayList<String>();
	boolean haveMatch = false;
	for (int i = 0; i < line.length; i++) {	
		for (int j = 0; j < line.length; j++) {
			if (i == j) {
				continue;
			}
			for (int j2 = 0; j2 < line.length; j2++) {
				if (i == j2 || j == j2) {
					continue;
				}
				String word1 = line[i] + line[j];
				String word2 = line[j2];
				String allWord = line[i] + "|" + line[j] + "=" + word2;
				if (word1.equals(word2) && !trashResult.contains(allWord)) {
					System.out.printf("%s|%s=%s\n",line[i],line[j],line[j2]); 
					trashResult.add(allWord);
					haveMatch = true;
				}
			}
		}
	}
	scan.close();
	if (!haveMatch) {
		System.out.println("No");
	}
  }
}
