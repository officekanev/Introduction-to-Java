import java.util.Scanner;

//Problem 2 – Adding Angles
//In geometry, an angle is the figure formed by two lines, called the sides of the angle, sharing 
//a common endpoint, called the vertex of the angle. A circle is a geometric shape that can be
//equated to exactly 360 degrees or one full rotation of a point around the center of the circle.
//You are given n numbers representing different measurements of angles in degrees. Write a
//program to find among these numbers all sets of three angles that, summed together, give
//full circle (one or more full rotations – 360, 720, 1080,…,i x 360 degrees).
//Input
//The input comes from the console. The first line holds the count n. The next line holds n 
//integer numbers, separated by a space.
//The input data will always be valid and in the format described. There is no need to check 
//it explicitly.
//Output
//Print at the console all sets of three numbers {a,b,c} found in the input sequence in
//format "a + b + c = 360 degrees" (with spaces), each at a separate line. The order of the output lines is not important. Print "No" in case no set of numbers exist, among the input sequence, that makes exact full circle.
//Constraints
//•	The count n will be an integer number in the range [1…50].
//•	The input numbers will be distinct integers in the range [0…9999].
//•	Time limit: 0.5 sec. Memory limit: 16 MB.
//Examples
//Input	       Output                        input                   output
//3           180 + 90 + 90 = 360 degrees    5                    270 + 90 + 0 = 360 degrees
//180 90 90	                                 270 90 270 180 0     270 + 270 + 180 = 720 degrees
//                                                                90 + 270 + 0 = 360 degrees
//
//Input	              Output
//4                     No 
//57 23 46 51
public class p21AddingAngle {
	public static void main(String[] args) {
		// read the input for number of angles and actual angles
		Scanner str = new Scanner(System.in);
		int n = Integer.parseInt(str.nextLine());
		int[] angles = new int[n];
		for (int i = 0; i < angles.length; i++) {
			angles[i] = str.nextInt();
		}
		
		// iterate over the array to find the matching sum
		int count = 0;
		for (int i = 0; i < angles.length; i++) {
			for (int j = i + 1; j < angles.length; j++) {
				for (int k = j + 1; k < angles.length; k++) {
					int a = angles[i];
					int b = angles[j];
					int c = angles[k];
					int sum = a + b + c;
					if (sum % 360 == 0) {
						System.out.printf("%d + %d + %d = %d degrees\n",
								a, b, c, sum);
						count++;
					}
				}
			}
		}
		
		//print "No" if there is no matching sum
		if (count == 0) {
			System.out.println("No");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
