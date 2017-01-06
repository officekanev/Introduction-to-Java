import java.util.Scanner;

//                   Problem 3 – Largest 3 Rectangles

//We are given a sequence of rectangles in the following format:
//[a1 x b1] [a2 x b2] … [an x bn]
//where a1…an and b1…bn are the sides of the rectangles (positive integers). Our goal is to find 
//three consecutive rectangles with largest total area. For example, in the following sequence of
//6 rectangles we have marked as bold the largest 3 rectangles, that have total area 31 
//(4*3 + 1*4 + 5*3 = 31):
//	[3 x 3] [3 x 2] [4 x 3] [1 x 4] [5 x 3] [3 x 1]
//			
//Write a program that reads a sequence of rectangles (at least 3) in the specified above format 
//and calculates and prints the total area of the largest 3 rectangles.
//Input
//The input data should be read from the console. At the first line, we have the input sequence
//of rectangles in the specified format. Each rectangle is surrounded in square brackets [ ].
//The sides of each rectangle are given as two numbers with the 'x' sign between them. Anywhere
//around the numbers and around the other characters we could have spaces (one or more space).
//The input data will always be valid and in the format described. There is no need to check
//it explicitly.
//Output
//At the only output line print the total area of the largest sequence of 3 rectangles.
//Constraints
//•	The sides of the rectangles will be integers in the range [1…999].
//•	The count of the rectangles will be in the range [3..100].
//•	The input line will consist of the following
//characters: '[', ']', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'x' and ' '.
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	                                              Output	               Comments
//[3 x 3] [3 x 2] [4 x 3] [1 x 4] [5 x 3] [3 x 1]     	31	         4*3 + 1*4 + 5*3 = 31
//
//  [12x7][3x5][10x12]  [4x3][1x8]  	                219	        12*7 + 3*5 + 10*12 = 219
//  
//[2x2][3x3][4x4][5x5][6x6][7x7][8x8][9x9][10x10]	    245	        8*8 + 9*9 + 10*10 = 245
//
// [   300  x  200 ]  [50x  50][ 30 x  20 ]	           63100	  300*200 + 50*50 + 30*20 = 63100

public class p3Largest3Rectangle {
    public static void main(String[] args) {
    }
                    // moe iskarva 80 points
    
		Scanner scan = new Scanner(System.in);
		String[] elements = scan.nextLine().split("[^0-9.]+");
		int [] digit = new int[elements.length];

    
     //  avt  
    
 // Parse the rectangles and collect their areas
// 		Scanner input = new Scanner(System.in);
// 		String rectangles = input.nextLine();
// 		rectangles = rectangles.replace("[", "");
// 		rectangles = rectangles.replace(" ", "");
// 		String[] rects = rectangles.split("]");
// 		
// 		int[] areas = new int[rects.length];
// 		for (int i = 0; i < rects.length; i++) {
// 			// Process each rectangle
// 			String rect = rects[i];
// 			rect = rect.replace("[", "");
// 			String[] sides = rect.split("x");
// 			int firstSide = Integer.parseInt(sides[0]);
// 			int secondSide = Integer.parseInt(sides[1]);
// 			areas[i] = firstSide * secondSide;
// 		}
// 		
// 		// Calculate the max sequence of 3 rectangle areas
// 		int max = Integer.MIN_VALUE;
// 		for (int j = 2; j < areas.length; j++) {
// 			int sum = areas[j-2] + areas[j-1] + areas[i];
// 			if (sum > max) {
// 				max = sum;
// 			}
// 		}
// 		
// 		System.out.println(max);
//    }
}


















