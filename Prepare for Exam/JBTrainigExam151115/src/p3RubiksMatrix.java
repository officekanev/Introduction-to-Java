import java.util.Scanner;

public class p3RubiksMatrix {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String[] dimensionOfMatrix = scan.nextLine().split("[ ]+");
	int row = Integer.parseInt(dimensionOfMatrix[0]);
	int col = Integer.parseInt(dimensionOfMatrix[1]);
	int[][] RubiksMatrix = new int[row][col];
	for (int i = 0; i < row * col; i++) {
		RubiksMatrix[i / row ][i % row] = i + 1;
	}
	int N = Integer.parseInt(scan.nextLine());
	for (int i = 0; i < N; i++) {
		String[] swapingComand = scan.nextLine().split(" ");
		int arrayIndex = Integer.parseInt(swapingComand[0]);
		int moves = Integer.parseInt(swapingComand[2]);
		switch (swapingComand[1]) {
		case "left" : moveRow(RubiksMatrix, arrayIndex, moves % col, col);
		     break;
		case "right" : moveRow(RubiksMatrix, arrayIndex, col - moves % col, col);
		     break;
		case "up" :  moveCol(RubiksMatrix, arrayIndex, moves % row, row);
             break;
		case "down": moveCol(RubiksMatrix, arrayIndex, row - moves % row, row);
			 break;
		}
	}
	rearange(RubiksMatrix, row, col);
	scan.close();
 }
  
  private static void moveRow (int[][] matrix, int row, int moves, int col){
	  int[] tempArr = new int[col];
	  for (int i = 0; i < col; i++) {
		tempArr[i] = matrix[row][(i + moves) % col];
	}
	  System.arraycopy(tempArr, 0, matrix[row], 0, tempArr.length);
  }
  
  private static void moveCol(int[][] matrix, int col ,int moves, int row){
	  int[] tempArr = new int[row];
	  for (int i = 0; i < row; i++) {
		tempArr[i] = matrix [(i + moves) % matrix.length][col];
	}
	  for (int i = 0; i < tempArr.length; i++) {
		matrix[i][col] = tempArr[i];
	}
  }
  
  private static void rearange(int[][] matrix, int row, int col){
	  int expected = 1;
	  for (int rol = 0; rol < row; rol++) {
		for (int cols = 0; cols < col; cols++) {
			if (matrix[rol][cols] != expected) {
				for (int x = 0; x < row; x++) {
					for (int y = 0; y < col; y++) {
						if (matrix[x][y] == expected) {
							System.out.printf("Swap (%d, %d) with (%d, %d)\n", rol, cols, x, y);
							int temp = matrix[x][y];
							matrix[x][y] = matrix[rol][cols];
							matrix[rol][cols] = temp;
						}
					}
				}
			}
			else {
				 System.out.println("No swap required");
			}
			 expected++;
		}
	 }
	  
  }
}
