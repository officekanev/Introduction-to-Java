import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P3ValidUsername {
  public static void main(String[] args) {
//	  Scanner scan = new Scanner(System.in);	  
//	  Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");	  
//	  Matcher match = pattern.matcher(scan.nextLine());
//	  scan.close();
//	  List<String> sirviveUsername = new ArrayList<String>();
//	  while (match.find()) {
//          String userName = match.group();
//          if (Character.isDigit(userName.charAt(0))) {
//			continue;
//		  }else if (userName.length() < 3 || userName.length() > 25) {
//			continue;
//		  }else {
//			  sirviveUsername.add(userName);
//		  }	 		
//	  }
//	  int maxLenght = 0;
//	  String winerFirstUserName ="";
//	  String winerSecondUserName ="";
//	  for (int i = 1; i < sirviveUsername.size(); i++) {
//		  int currentLength = 0;
//		String prevv = sirviveUsername.get(i - 1);
//		String current = sirviveUsername.get(i);
//		currentLength = prevv.length() + current.length();
//		if (currentLength > maxLenght) {
//			winerFirstUserName = prevv;
//			winerSecondUserName = current;
//			maxLenght = currentLength;
//		}
//	 }
//	  System.out.println(winerFirstUserName);
//	  System.out.println(winerSecondUserName);
	  
	  //  avt
	  
	    Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String[] usernames = inputString.split("[\\s()/\\\\]+");
		ArrayList<String> validUserNames = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("\\b[a-zA-Z][\\w_]{2,25}\\b");
		for (String str : usernames) {
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()) {
				validUserNames.add(str);
			}
		}
		
		int maxLenght = 0;
		String[] longestTwoWords = new String[2];
		for (int i = 0; i < validUserNames.size()-1; i++) {
			int currentLenght = validUserNames.get(i).length() +
					validUserNames.get(i+1).length();
			if (currentLenght > maxLenght) {
				maxLenght = currentLenght;
				longestTwoWords[0] = validUserNames.get(i);
				longestTwoWords[1] = validUserNames.get(i+1);
			}
		}
		
		for (String string : longestTwoWords) {
			System.out.println(string);
		}
		input.close();
 }
}
