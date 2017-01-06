import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class p1MirrorNUmber {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	List<Integer> elements = new ArrayList<Integer>();
	List<Integer> scrapelements = new ArrayList<Integer>();
	int inputNumbers = Integer.parseInt(scan.nextLine());
	for (int i = 0; i < inputNumbers; i++) {
		String current = scan.next();
		int num = Integer.parseInt(current);
		elements.add(num);
	}
	scan.close();
	for (Integer digit : elements) {
	   int number = digit;
	   int num = digit;
	   int digit1,digit2,digit3,digit4 = 0;
	   digit4 = digit % 10; digit = digit / 10;
	   digit3 = digit % 10; digit = digit / 10;
	   digit2 = digit % 10; digit = digit / 10;
	   digit1 = digit % 10;
	   if (digit1 == digit2 && digit3 == digit4 && digit1 == digit4) {
		continue;
	   }
	   int reversenum = 0;
	   if (!scrapelements.contains(number)) {
		      while( num != 0 )
		      {
		          reversenum = reversenum * 10;
		          reversenum = reversenum + num%10;
		          num = num/10;
		      }
		      if (elements.contains(reversenum)) {		   
				   System.out.println(number + "<!>" +reversenum);
				   scrapelements.add(number);
				   scrapelements.add(reversenum);
			  }
	   }	  
	}
	if (scrapelements.size() == 0) {
		System.out.println("No");
	}
 }
}
