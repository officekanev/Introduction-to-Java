import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class p4Again {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int inputLine = Integer.parseInt(scan.nextLine());
	TreeMap<String,TreeMap<String,Long>> fillInput = new TreeMap<String,TreeMap<String,Long>>();
	for (int i = 0; i < inputLine; i++) {
		String[] line = scan.nextLine().split(" ");
		String name = line[0] + " " + line[1];
		String subject = line[2];
		Long assessment = Long.parseLong(line[3]);
		if (!fillInput.containsKey(name)) {
			fillInput.put(name, new TreeMap<String,Long>());
			fillInput.get(name).put(subject, assessment);
		}else {
			fillInput.get(name).put(subject, assessment);
		}
	}
	scan.close();
	Set<String> keys = fillInput.keySet();
	
	for (String name : keys) {
		TreeMap<String,Long> result = fillInput.get(name);
		System.out.printf("%s : [",name);
		Set<String> subject = result.keySet();
		long resultt = 0,count = 0,countIterations = 0,lengthCount = 0;
		String current ="";
		for (String kilogrami : subject) {
			int length = subject.size();
			lengthCount++;
			long ocenka = result.get(kilogrami);
			if (countIterations == 0) {
				current = kilogrami;
				 resultt += ocenka;
				 count++;
			}else {
				if (!subject.equals(current)) {
					if (lengthCount == length) {
						System.out.printf("current - %.2f\n]",resultt/count);
					}else {
						System.out.printf("current - %.2f,",resultt/count);
						current = kilogrami;
						resultt = 0; count = 0;
					}
				}else {
					 current = kilogrami;
					 resultt += ocenka;
					 count++;
				}
			}								    
		} 		
	}
  }
}
