
import java.util.Scanner;

//                           Problem 1.	Rectangle Area
//Write a program that enters the sides of a rectangle (two integers a and b) 
//and calculates and prints the rectangle's area. Examples:
// Input	Output
//  7 20	 140
//  5 12	 60
public class RectangleArea {
   public static void main(String[] args) {
	 Scanner scan =new Scanner(System.in);
	 System.out.println("Please enter value of the side 'a' and side 'b' separate with space");
	 int a = scan.nextInt();
	 int b = scan.nextInt();
	 scan.close();
	 int rectangleArea = a * b;
	 System.out.println(rectangleArea);
   }
}
