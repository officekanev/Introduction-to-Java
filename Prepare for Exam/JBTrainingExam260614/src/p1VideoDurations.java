import java.util.Scanner;

//                           Problem 1 – Video Durations

//Peter watches videos every day. Once he wanted to calculate how many time he spends
//watching videos. He extracted a list of all videos he watched but he was unable to
//sum their durations because they were in format hours:minutes. Write a program to
//help Peter sum the durations of the videos he watched and print them in format
//hours:minutes (where minutes should be in the range 0...59).
//Input
//
//The input data should be read from the console. It consists of several input lines,
//each holding a video duration in format hours:minutes. At the last line the string
//"End" stays to indicate the end of the movie durations list.
//The input data will always be valid and in the format described. There is no need
//to check it explicitly.
//Output
//Print at the console the sum of the durations of all videos in format hours:minutes.
//The minutes should always be in two digits format (from "00" to "59").
//Constraints
//•	The hours will be an integer number in the range [0…999].
//•	The minutes will be an integer number in the range [0…59].
//•	The count of video durations will be in the range [0..999].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	  Output		Input	Output		Input	Output		Input	Output		Input	Output
//1:40    24:38         0:02    1:01        0:00    1:00        5:55    15:23       1:03    1:03
//2:25                  0:59                0:59                4:44                End	
//17:35                 End                 0:01                3:33
//0:01                                      End	                1:11
//2:57                                                          End	
//End						
public class p1VideoDurations {
  
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		long rezult = 0;
		while (!line.contains("End")) {
			String[] time = line.split(":");
			long seconds = Long.parseLong(time[1]);
			long minutes = Long.parseLong(time[0]);
			rezult += (seconds + minutes * 60);
			line = scan.nextLine();
		}
		scan.close();
		int secondRezult = (int)(rezult % 60);
		int minutesRezult = (int)(rezult / 60);
		System.out.printf("%s:%s",minutesRezult ,
				secondRezult < 10 ? "0" + secondRezult : "" + secondRezult);
	}
}














