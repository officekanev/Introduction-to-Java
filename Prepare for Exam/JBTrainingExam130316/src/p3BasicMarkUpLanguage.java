import java.util.Scanner;

public class p3BasicMarkUpLanguage {
  public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int countLine = 1;
		int linee = 0;
		int count = 0;
		while (true) {
			String[] elements = line.split("[<>/\"= ]+");
			String command = elements[1];
			if (command.contains("stop")) {
				break;
			}
			String word = elements[elements.length -1];
			String value = "";
			int valuee = 0;			
			if (command.contains("repeat")) {
				value = elements[3];
				valuee = Integer.parseInt(value);
			}						
			switch (command) {
			case "inverse" : System.out.printf("%d. ",countLine);
			   inverseWord(word); countLine++; break;			   
			case "reverse" :System.out.printf("%d. ",countLine);			
			 StringBuffer a = new StringBuffer(word);
				System.out.println(a.reverse()); countLine++; break;
			case "repeat" : if (count == 0) {
				             linee =  repeatWord(word,valuee,countLine);
				            count++; break;	
			               } else {
			            	   repeatWord(word,valuee,linee);  
			               }			
			default:
				break;
			}
			line = scan.nextLine();
		}
		scan.close();
	}
    
    public static void inverseWord(String word){
    	StringBuilder inverse = new StringBuilder();
    	for (int i = 0; i < word.length(); i++) {
			char curr = word.charAt(i);
			if (Character.isUpperCase(curr)) {
				inverse.append(Character.toLowerCase(curr));
			}else {
				inverse.append(Character.toUpperCase(curr));
			}
		}
    	System.out.println(inverse);
    }
    
    public static int repeatWord(String word, int  valuee, int countLine){
    	for (int i = 0; i < valuee; i++) {
    		System.out.printf("%d. ",countLine++);
			System.out.println(word);
		}
    	int line = countLine;
    	return line;
    }
}
