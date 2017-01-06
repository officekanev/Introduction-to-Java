import java.util.Scanner;

//Problem 3 - Fire the Arrows
//We are given a matrix containing arrows that need to be moved. The arrows are
//the following: '<' (ASCII code 60), '>' (ASCII code 62), '^' (ASCII code 94), 
//'v' (ASCII code 118). Respectively pointing left, right, up and down. There
//are also blank spaces that are indicated by 'o' (ASCII code 111). There will
//be no other characters in the matrix. 
//Your task is to move all arrows, one at a time, in the direction they point
//to until there are no more possible moves.
// 
//The arrows should be moved in the following order: first the ones in the 
//uppermost row and the leftmost column.
//Note: Arrows cannot move if their way is blocked by other arrows or if 
//they reach the end of the matrix.
//Input
//The input data should be read from the console. At the first input line
//you will be given a number n specifying how many rows after it will follow. 
//At the next n lines you will be given the matrix with the arrows that
//need to be moved.
//The input data will always be valid and in the format described. There
//is no need to check it explicitly.
//Output
//The output should be the new matrix with all the arrows moved to the 
//direction they're facing.
//Constraints
//•	The count of the rows will be in the range [1…10].
//•	The only characters that will be present in the matrix will
//be '<', '>', '^', 'v' and 'o'.
//•	Time limit: 0.3 sec. Memory limit: 16 MB. 
//Examples
//Input	Output		Input	Output		Input	Output
//3       <^oo          3     oov           4     ^<oo
//voo<    ooo>        oov     <o^         ooo<    oooo
//oo>o    vooo        oo<     ooo         oovo    oovo
//o^oo	              oo^	              ^ooo    oo^o
//                                        ^ooo		
public class p3FireTheArrows {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows = Integer.parseInt(input.nextLine());
		char[][] matrix = new char[rows][];
		
		for (int i = 0; i < rows; i++) {
			String line = input.nextLine();
			matrix[i] = line.toCharArray();
		}
		
		boolean hasMoved = true;
		while (hasMoved) {
			hasMoved = false;
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[row].length; col++) {
					int currentRow = row, currentCol = col;
					char symbol = matrix[currentRow][currentCol];
					if (symbol != 'o') {
						int dirRow = 0, dirCol = 0, 
							nextRow = 0, nextCol = 0;
						
						switch (symbol) {
							case '^':
								dirRow = -1;
								break;
							case '>':
								dirCol = 1;
								break;
							case '<':
								dirCol = -1;
								break;
							case 'v':
								dirRow = 1;
								break;
							default:
								break;
						}
						
						nextRow = currentRow + dirRow;
						nextCol = currentCol + dirCol;
						if (nextCol >= 0 && nextCol < matrix[currentRow].length
								&& nextRow >= 0 && nextRow < matrix.length
								&& matrix[nextRow][nextCol] == 'o') {
							
							matrix[nextRow][nextCol] = symbol;
							matrix[currentRow][currentCol] = 'o';
							hasMoved = true;
						} 
					}
				}
			}
		}
		input.close();
		printMatrix(matrix);
	}
	
	private static void printMatrix(char[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				System.out.print(matrix[r][c]);
			}
			System.out.println();
		}
	}
}
	
	
	
	
	
	
	
	