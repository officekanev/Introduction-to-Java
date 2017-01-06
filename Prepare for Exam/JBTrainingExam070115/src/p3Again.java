import java.util.Scanner;

public class p3Again {
 public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int numberOfRows = Integer.parseInt(scan.nextLine());
	char[][] matrix = new char[numberOfRows][];
	for (int i = 0; i < numberOfRows; i++) {
		matrix[i] = scan.nextLine().toCharArray();
	}	
	scan.close();
	boolean hasMove = true;
    while (hasMove) {
    	hasMove = false;
		for (int row = 0; row < numberOfRows; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				char current = matrix[row][col];				
				if (current != 'o') {
					int currentRow = row, currentCol = col;
					int dirRow = 0 ,dirCol = 0,
					    nextRow = 0, nextCol = 0;;
					switch (current) {
					case '<': dirCol--; break;
					case '>': dirCol++; break;
					case '^': dirRow--; break;
					case 'v': dirRow++; break;				
					}
					nextRow = currentRow + dirRow;
					nextCol = currentCol + dirCol;					
					if (nextRow >= 0 && nextRow < numberOfRows &&
						nextCol >= 0 && nextCol < matrix[row].length &&
						matrix[nextRow][nextCol] == 'o') {
						
						matrix[nextRow][nextCol] = current;						
						matrix[row][col] = 'o';
						hasMove = true;
					}
				}
			}
		}		
	}
    PrintMatrix(matrix);
 }
 public static void PrintMatrix(char [][] matrix ){
	 for (int row = 0; row < matrix.length; row++) {
		for (int col = 0; col < matrix[row].length; col++) {
			System.out.print(matrix[row][col]);
		}
		System.out.println();
	}
 }
}
