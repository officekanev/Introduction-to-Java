import java.util.Scanner;

public class p1Again {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String line = scan.nextLine();
	long SumAllTime = 0;
	while (!line.contains("End")) {		
		String[]elements = line.split(":");
		SumAllTime += Long.parseLong(elements[0]) * 3600; 
		SumAllTime += Long.parseLong( elements[1]) * 60;
		line = scan.nextLine();
	}
	int minutues = (int)(SumAllTime % 3600 / 60);
	int hours = (int)(SumAllTime / 3600);
	System.out.printf("%d:%s", 
			hours, 
			minutues < 10 ? "0" + minutues : "" + minutues); 
			
	scan.close();
  }
}
