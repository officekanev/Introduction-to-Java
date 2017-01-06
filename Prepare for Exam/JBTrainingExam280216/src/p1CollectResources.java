import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p1CollectResources {
public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);                        // 30 point
//	String[] resources = scan.nextLine().split("[ ]+");
//	int numberOfColectionsPaths = Integer.parseInt(scan.nextLine());
//	int MaxResult = 0;
//	int tempResult = 0;
//    for (int i = 0; i < numberOfColectionsPaths; i++) {
//		String[] currentPath = scan.nextLine().split("[ ]+");
//		int startPozition = Integer.parseInt(currentPath[0]);
//		int stepLength = Integer.parseInt(currentPath[1]);
//		String[] resourcesCopy = resources.clone();
//		for (int j = startPozition;true; j = (j +  stepLength) % resources.length ) {
//			if (resourcesCopy[j].contains("^")) {
//				break;
//			}			
//			String[] currentResource = resourcesCopy[j].split("[_]+");
//			resourcesCopy[j] = "^" + resourcesCopy[j];
//			if (currentResource.length < 2) {
//				if (currentResource[0].contains("stone") || currentResource[0].contains("gold") ||
//						currentResource[0].contains("wood") || currentResource[0].contains("food")) {
//					tempResult += 1;
//				}
//			}else {
//				if (currentResource[0].contains("stone") || currentResource[0].contains("gold") ||
//						currentResource[0].contains("wood") || currentResource[0].contains("food")) {
//					tempResult += Integer.parseInt(currentResource[1]);
//				}
//			}
//		}
//		if (tempResult > MaxResult) {
//			MaxResult = tempResult;
//			tempResult = 0;
//		}
//	}
//	scan.close();
//	System.out.println(MaxResult);
	
	// atv
	
	Scanner scanner = new Scanner(System.in);
	
	String[] inputResources = scanner.nextLine().split(" ");
	Integer numberOfPaths = Integer.parseInt(scanner.nextLine());
	ArrayList<Integer> quantities = new ArrayList<Integer>();
	
	Integer sumedResources = 0;
	
	for (int i = 0; i < numberOfPaths; i++) {
		String[] arguments = scanner.nextLine().split(" ");
		Integer startIndex = Integer.parseInt(arguments[0]);
		Integer step = Integer.parseInt(arguments[1]);
		String[] currentResources = inputResources.clone();
		
		for (int j = startIndex; true; j = (j + step) % currentResources.length) {

			String[] resource = currentResources[j].split("_");
			if(resource[0].contains("@")){
				break;
			}
			
			if(resource[0].equals("wood") || resource[0].equals("gold") || resource[0].equals("stone") || resource[0].equals("food")){
				if(resource.length < 2){
					currentResources[j] = "@" + currentResources[j];
					sumedResources += 1;
				}
				else{
					currentResources[j] = "@" + currentResources[j];
					sumedResources += Integer.parseInt(resource[1]);
				}
			}
		}
		
		quantities.add(sumedResources);
		sumedResources = 0;
	}
	scanner.close();
	System.out.println(Collections.max(quantities));
 }
}
