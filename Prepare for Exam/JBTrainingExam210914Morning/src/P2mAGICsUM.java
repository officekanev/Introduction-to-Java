import java.util.ArrayList;
import java.util.Scanner;

public class P2mAGICsUM {
public static void main(String[] args) {
//	Scanner scan = new Scanner(System.in);    /// 10 points
//	int magicDivideNumber = Integer.parseInt(scan.nextLine());
//	List<Integer> elements = new ArrayList<Integer>();
//	String line = scan.nextLine();
//	while (!line.contains("End")) {
//		int current = Integer.parseInt(line);
//		elements.add(current);
//		line = scan.nextLine();
//	}
//	scan.close();
//	int maxDivideNum = 0;
//	boolean noMagicSum = false;
//	String result ="";
//	for (int i = 0; i < elements.size(); i++) {
//		int firstNum = elements.get(i);		
//		for (int j = i+1; j < elements.size(); j++) {
//			int secondNum = elements.get(j);
//			for (int k = j+1; k < elements.size(); k++) {
//				int thirdNum = elements.get(k);				
//					int sum = firstNum + secondNum + thirdNum;
//					if (sum % magicDivideNumber == 0 && sum > maxDivideNum) {													
//							noMagicSum = true;
//							maxDivideNum = sum;	
//							result = String.format("(%d + %d + %d) %% %d = 0",elements.get(i),
//									elements.get(j),elements.get(k),magicDivideNumber);
//					}				
//			}
//		}
//	}	
//	if (!noMagicSum) {
//		System.out.println("No");
//	}
	
	// avt 
	Scanner input = new Scanner(System.in);
	ArrayList<Integer> inputNumbers = new ArrayList<>();
	int divider = Integer.parseInt(input.nextLine());
	
	while (true) {
		String inputLine = input.nextLine();
		if (inputLine.equals("End")) {
			break;
		}
		inputNumbers.add(Integer.parseInt(inputLine));
	}

	long maxSum = Integer.MIN_VALUE;
	String result = "";
	int resultCounter = 0;
	for (int i = 0; i < inputNumbers.size(); i++) {
		for (int i1 = i+1; i1 < inputNumbers.size(); i1++) {
			for (int i2 =i1 +1; i2 < inputNumbers.size(); i2++) {
				long sum = inputNumbers.get(i) + inputNumbers.get(i1) + inputNumbers.get(i2);
				
				if (sum % divider == 0 && sum > maxSum) {
					maxSum = sum;
					result = String.format("(%d + %d + %d) %% %d = 0",
							inputNumbers.get(i), inputNumbers.get(i1), inputNumbers.get(i2), divider);
					resultCounter++;
				}
			}
		}
	}
	
	if (resultCounter == 0) {
		System.out.println("No");
	} else {
		System.out.println(result);
	}
	input.close();
}
}