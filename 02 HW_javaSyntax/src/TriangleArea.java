import java.util.Scanner;

//         Problem 2.	Triangle Area
//Write a program that enters 3 points in the plane (as integer x and y coordinates),
//calculates and prints the area of the triangle composed by these 3 points. Round 
//the result to a whole number. In case the three points do not form a triangle,
//print "0" as result. Examples:
//  Input	    Output		Input	  Output		Input	  Output
//  -5 10        575        53 18     86             1 1       0
//  25 30                   56 23                    2 2
//  60 15			        24 27                    3 3				
public class TriangleArea {
   public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int Ax = scan.nextInt();
	int Ay = scan.nextInt();
	scan.nextLine();
	int Bx = scan.nextInt();
	int By = scan.nextInt();
	scan.nextLine();
	int Cx = scan.nextInt();
	int Cy = scan.nextInt();
	scan.close();
	Double triangleArea = ((Ax * (By - Cy)) + (Bx * (Cy - Ay)) + (Cx *(Ay - By))) / (double)2;
	int rezult = triangleArea.intValue();
	if (rezult < 0) {
		System.out.println(rezult * -1);
	} else {
		System.out.println(rezult);
	}
	
   }
}
