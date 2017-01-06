import java.util.Scanner;

public class P3wEIRDSrings {
  public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);
//	String[] temp = scan.nextLine().split("[ \\/|)(]+"); 
//	String afterJunk = "";
//	List<String> surviveElements = new ArrayList<String>();
//	for (int i = 0; i < temp.length; i++) {
//		afterJunk += temp[i];
//	}	
//	Pattern pattern = Pattern.compile("[a-zA-Z]+");
//	Matcher match = pattern.matcher(afterJunk);
//	while (match.find()) {		
//		surviveElements.add(match.group());
//	}
//	int maxSum = 0;
//	String S1 ="";
//	String S2 ="";
//	for (int i = 1; i < surviveElements.size(); i++) {
//		int beforWord = giveValue(surviveElements.get(i -1));
//		int afterWord = giveValue(surviveElements.get(i));
//		if (beforWord + afterWord > maxSum) {
//			maxSum = beforWord + afterWord;
//			S1 = surviveElements.get(i -1);
//			S2 = surviveElements.get(i);
//		}
//	}
//	scan.close();
//	System.out.println(S1);
//	System.out.println(S2);
//  }
//  
//  public static int giveValue(String word){
//	  int result = 0;
//	  for (int i = 0; i < word.length(); i++) {
//		  if (Character.isUpperCase(word.charAt(i))) {
//			  result += (((int)word.charAt(i) - (int) 'A') + 1);
//		 }else {
//			  result += (((int)word.charAt(i) - (int) 'a') + 1);
//		 }
//		
//	 }
//	  return result;
	  
	  // avt
	  
	    Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		inputString = inputString.replaceAll("[\\/\\|\\(\\)\\s]+", "");
		String[] words = inputString.split("[^a-zA-Z]+");		

		int maxWeight = 0;		
		String[] longestTwoWords = new String[2];
		for (int i = 0; i < words.length-1; i++) {
			String currentCouple = (words[i] + words[i+1]).toLowerCase();
			int currentWeight = 0;
			for (int j = 0; j < currentCouple.length(); j++) {
				currentWeight += currentCouple.charAt(j) - ('a'-1);
			}
			
			if (currentWeight >= maxWeight) {
				maxWeight = currentWeight;
				longestTwoWords[0] = words[i];
				longestTwoWords[1] = words[i+1];
			}
		}
		
		for (String string : longestTwoWords) {
			System.out.println(string);
		}
		input.close();
  }
}
