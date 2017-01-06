import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//                     Problem 3 – Lego Blocks
//You are given two jagged arrays. Each array represents a Lego block containing integers.
//Your task is first to reverse the second jagged array and then check if it would fit 
//perfectly in the first jagged array.  

// First Jagged array    Second Jagget array     Reversed Second Array     Matched Arrays
//1 1 1 1 1 1            1 1                                1 1            1 1 1 1 1 1 1 1   
//2 1 1 3                2 2 2 3                        3 2 2 2            2 1 1 3 3 2 2 2  
//2 1 1 2 3              3 3 3                            3 3 3            2 1 1 2 3 3 3 3
//7 7 7 5 3 2            44                                 4 4            7 7 7 5 3 2 4 4

//The picture above shows exactly what fitting arrays mean. If the arrays fit perfectly
//you should print out the newly made rectangular matrix. If the arrays do not match 
//(they do not form a rectangular matrix) you should print out the number of cells in 
//the first array and in the second array combined. The examples below should help you
//understand more the assignment.
//Input
//The first line of the input comes as an integer number n saying how many rows are
//there in both arrays. Then you have 2 * n lines of numbers separated by whitespace(s).
//
//The first n lines are the rows of the first jagged array; the next n lines are the
//rows of the second jagged array. There might be leading and/or trailing whitespace(s).
//Output
//You should print out the combined matrix in the format:
//[elem, elem, …, elem]
//[elem, elem, …, elem]
//[elem, elem, …, elem]
//If the two arrays do not fit you should print out : The total number of cells is: count
//Constraints
//•	The number n will be in the range [2…10].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	                              Output
//2                             [1, 1, 1, 1, 1, 1, 1, 1]
//1 1 1 1 1 1                   [2, 1, 1, 3, 3, 2, 2, 2]
//2 1 1 3
//1 1
//2 2 2 3	
//
//2                            The total number of cells is: 14
//1 1 1 1 1
//1 1 1
//1
//1 1 1 1 1	

public class p3LegoBlocks {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = Integer.parseInt(scanner.nextLine());

	        ArrayList<ArrayList<Integer>> firstArr = new ArrayList<>();
	        ArrayList<ArrayList<Integer>> secondArr = new ArrayList<>();

	        readInputMatrix(scanner, n, firstArr);
	        readInputMatrix(scanner, n, secondArr);

	        mergeMatrices(firstArr, secondArr);

	        boolean isRectangular = false;
	        int size = firstArr.get(0).size();
	        for (int i = 1; i < firstArr.size(); i++) {
	            if(size == firstArr.get(i).size()) {
	                isRectangular = true;
	            } else {
	                isRectangular = false;
	                break;
	            }
	        }

	        if (isRectangular) {
	            for (ArrayList<Integer> integers : firstArr) {
	                System.out.println(integers);
	            }
	        } else {
	            int count = 0;
	            for (ArrayList<Integer> integers : firstArr) {
	                count += integers.size();
	            }
	            System.out.printf("The total number of cells is: %d", count);
	        }
	    }

	    private static void mergeMatrices(ArrayList<ArrayList<Integer>> firstArr, ArrayList<ArrayList<Integer>> secondArr) {
	        for (int i = 0; i < firstArr.size(); i++) {
	            Collections.reverse(secondArr.get(i));
	            firstArr.get(i).addAll(secondArr.get(i));
	        }
	    }

	    private static void readInputMatrix(Scanner scanner, int n, ArrayList<ArrayList<Integer>> arr) {
	        for (int i = 0; i < n; i++) {
	            arr.add(new ArrayList<>());
	            String[] numsAsStrings = scanner.nextLine().trim().split("\\s+");
	            for (String numsAsString : numsAsStrings) {
	                arr.get(i).add(Integer.parseInt(numsAsString));
	            }
	        }
	    }
}






















