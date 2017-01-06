//                                                 Problem 3 – Dragon Trap

//Our statistics show that SoftUni students LOVE matrices and they also enjoy rotating stuff, that’s why we decided to make you
//happy by giving you a problem in which you have to rotate elements inside a matrix. You’re welcome!
//So, what’s the story? The town of Pernik is being harassed by a dragon. Meatball Sasho (a.k.a. "Sasho Kyufteto"), has the 
//		ultimate weapon, an elbow (a.k.a. "vinkel"), but he needs time to go home and take it. Meanwhile, the crafty townsfolk 
//		of Pernik need to distract the dragon by running in circles around him; that way, the dragon won’t know which house or
//		person to attack. Eventually Sasho will come to the rescue.
//You’ll be given a rectangular matrix of characters which represents the townsfolk – each person is represented by the first 
//character of their name; Pernik is a weird place, so names can start with any ASCII character. On the first line of input you’ll
//
//receive the number of rows N of the matrix and on each of the next N rows – a string representing the specified row.
//On the next lines, until you receive the string "End", you’ll be given a series of commands in 
//format: "({row} {column}) {radius} {rotations}". {row} and {column} are the coordinates of the dragon (center of rotation),
//{radius} is the radius and {rotations} tells you how many times and in which direction to rotate the people (characters).
//The top-left corner of the matrix has coordinates (0, 0). Rotation occurs only within the matrix, on the outside of a square 
//defined by the center and the radius (check out the examples to grasp the concept). If the number of rotations is positive,
//rotate the characters clockwise, otherwise rotate them counterclockwise.
//When the "End" command is given, print back the rotated matrix and on the last line, print how many cells have changed values 
//(compared to the original matrix) after all rotations are complete in format: "Symbols changed: {countOfSymbols}". Note 
//that if two people are represented by the same character and one replaces the other, the cell doesn’t change value.
//Input
//•	The input data should be read from the console.
//•	On the first line, you’ll be given a number N representing the number of rows of the matrix.
//•	On the next N lines you’ll be given the rows of the matrix as strings.
//•	On the following lines, until the command "End" is received, you’ll be given commands in the format described above.
//•	The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//•	The output should be printed on the console. It should consist of N + 1 lines.
//•	On the first N lines, print back the rotated matrix.
//•	On the last line, print the number of cells which have changed values in the following
//format: "Symbols changed: {countOfSymbols}".
//Constraints
//•	The number of rows N of the matrix will be in the range [1 … 20].
//•	The matrix will contain ASCII characters.
//•	The number of rotating commands will be between 1 and 50, including the "End" command.
//•	The {row} and {column} will be integers in the range [-10 … 10].
//•	The {radius} will be an integer in the range [1 … 20].
//•	{rotations} will be an integer in the range [-231 … 231 – 1].
//•	Allowed working time for your program: 0.1 seconds. Allowed memory: 16 MB.
//Examples
//Input	        Output	               Comments
//3              dab              The center is (1 1) which is the character 'e'. The radius is 1, so all shaded 
//abc            gec              characters should be rotated. Note, we only rotate the 8 characters around
//def            hif              'e', but not the center (or any other cells inside the formed square). {rotations} 
//ghi         Symbols changed: 8  is 1, which means we rotate the characters once clockwise: 'a'
//(1 1) 1 1                        replaces 'b', 'b' replaces 'c', 'c' replaces 'f', etc.
//End	
	  
//3               abc             The square defined by the center and radius overlaps the matrix at the three shaded 
//abc             ebf              cells. Rotate once clockwise: one 'b' replaces the other 'b', and 'b' replaces 'e'
//bef             ghi             and 'e' replaces a 'b'. Cell (0, 1) is still 'b', so in total, 2 symbols were changed.
//ghi          Symbols changed: 2
//(-1 -1) 2 1
//End	
	 
//3               abc            The rotation square doesn’t overlap the matrix, so no characters are rotated.
//abc             def
//def             ghi
//ghi         Symbols changed: 0
//(1 1) 2 1
//End		
import java.util.ArrayList;
import java.util.Scanner;

public class p3DragonTrap {
	   private static  ArrayList<Character> symbolsToRotate = new ArrayList<Character>();
	    private static ArrayList<Cell> cellsToRotate = new ArrayList<Cell>();

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        int numberOfRows = Integer.parseInt(scanner.nextLine());
	        String[] originalMatrix = new String[numberOfRows];
	        char[][] rotatedMatrix = new char[numberOfRows][];

	        readMatrix(scanner, numberOfRows, originalMatrix, rotatedMatrix);

	        String command = scanner.nextLine();
	        while (!command.equals("End")) {
	            String[] tokens = command
	                    .replaceAll("[\\s()]+", " ")
	                    .trim()
	                    .split(" ");

	            int centerRow = Integer.parseInt(tokens[0]);
	            int centerCol = Integer.parseInt(tokens[1]);
	            int radius = Integer.parseInt(tokens[2]);
	            int rotations = Integer.parseInt(tokens[3]);

	            getSymbolsToRotate(rotatedMatrix, centerRow, centerCol, radius);

	            if (symbolsToRotate.size() > 0) {
	                rotations %= symbolsToRotate.size();

	                if (rotations != 0) {
	                    int index = rotations < 0 ? -rotations : symbolsToRotate.size() - rotations;

	                    for (Cell cell : cellsToRotate) {
	                        rotatedMatrix[cell.getRow()][cell.getColumn()] = symbolsToRotate.get(index);
	                        index = (index + 1) % symbolsToRotate.size();
	                    }
	                }
	            }

	            symbolsToRotate.clear();
	            cellsToRotate.clear();
	            command = scanner.nextLine();
	        }

	        printOutput(originalMatrix, rotatedMatrix);
	    }

	    private static void readMatrix(Scanner scanner, int numberOfRows, String[] originalMatrix, char[][] rotatedMatrix) {
	        for (int i = 0; i < numberOfRows; i++) {
	            String input = scanner.nextLine();

	            originalMatrix[i] = input;
	            rotatedMatrix[i] = input.toCharArray();
	        }
	    }

	    private static void getSymbolsToRotate(char[][] rotatedMatrix, int centerRow, int centerCol, int radius) {
	        int startRow = centerRow - radius;
	        int startCol = centerCol - radius;
	        int endCol = centerCol + radius;
	        int endRow = centerRow + radius;
	        int row;
	        int col;

	        for (col = startCol, row = startRow; col <= endCol; col++) {
	            if (isInsideMatrix(row, col, rotatedMatrix)) {
	                symbolsToRotate.add(rotatedMatrix[row][col]);
	                cellsToRotate.add(new Cell(row, col));
	            }
	        }

	       for (row = startRow + 1, col = endCol; row <= endRow; row++) {
	            if (isInsideMatrix(row, col, rotatedMatrix)) {
	                symbolsToRotate.add(rotatedMatrix[row][col]);
	                cellsToRotate.add(new Cell(row, col));
	            }
	        }

	        for (col = endCol - 1, row = endRow; col >= startCol; col--) {
	            if (isInsideMatrix(row, col, rotatedMatrix)) {
	                symbolsToRotate.add(rotatedMatrix[row][col]);
	                cellsToRotate.add(new Cell(row, col));
	            }
	        }

	        for (row = endRow - 1, col = startCol; row > startRow; row--) {
	            if (isInsideMatrix(row, col, rotatedMatrix)) {
	                symbolsToRotate.add(rotatedMatrix[row][col]);
	                cellsToRotate.add(new Cell(row, col));
	            }
	        }
	    }

	    private static boolean isInsideMatrix(int currentRow, int currentCol, char[][] matrix) {

	        return 0 <= currentRow
	                && currentRow < matrix.length
	                && 0 <= currentCol
	                && currentCol < matrix[currentRow].length;
	    }

	    private static void printOutput(String[] originalMatrix, char[][] rotatedMatrix) {
	        int changedSymbols = 0;

	        for (int i = 0; i < rotatedMatrix.length; i++) {
	            for (int j = 0; j < rotatedMatrix[i].length; j++) {
	                if (rotatedMatrix[i][j] != originalMatrix[i].charAt(j)) {
	                    changedSymbols++;
	                }

	                System.out.print(rotatedMatrix[i][j]);
	            }

	            System.out.println();
	        }

	        System.out.printf("Symbols changed: %d", changedSymbols);
	    }
	}

	class Cell {
	    int row;
	    int column;

	    public Cell(int row, int column) {
	        this.row = row;
	        this.column = column;
	    }

	    public int getRow() {
	        return this.row;
	    }

	    public int getColumn() {
	        return this.column;
	    }
}
