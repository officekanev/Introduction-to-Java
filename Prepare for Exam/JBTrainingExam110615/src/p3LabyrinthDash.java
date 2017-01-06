import java.util.Scanner;

//                                                     Problem 3 – Labyrinth Dash
//Enough hard problems. Let’s play a game! You will be given the layout of a labyrinth (a two-dimensional array)
//and a series of moves. Your task is to navigate the labyrinth and print the outcome of each move.
//On the first line of input you will be given the number N, representing the count of rows of the labyrinth.
//On each of the next N lines you will receive a string, containing the layout of the given row. On the last 
//line of input you will receive a string, containing the moves you need to make. Each move will be one of the
//following symbols: “v” (move down), “^” (move up), “<” (move left) or “>” (move right). The player starts with
//3 lives and begins the journey at position (0, 0). When you make a move, there can be several different outcomes:
//1)	 Hit a wall – a wall is represented by the symbols “_” (underscore) and “|” (pipe). Hitting a wall means 
//the player stays in place; in this case you should print on the console “Bumped a wall.”
//2)	Land on an obstacle – obstacles are the following symbols: “@”, “#”, “*”. If you move to a position
//containing one of these symbols the player loses a life point and you should print “Ouch! That hurt! 
//Lives left: X” on the console. If the player is left with 0 lives, the game ends and you should print 
//“No lives left! Game Over!”
//3)	Get a new life – when you land on the symbol “$” the player receives an additional life point.
//Print “Awesome! Lives left: X” on the console. Additional lives (‘$’) are removed once the player 
//passes through the cell (i.e. they are replaced with dots).
//4)	Drop out of the labyrinth – if you land on an empty cell (one containing a space), or outside
//the boundaries of the array, the game ends and you should print “Fell off a cliff! Game Over!”
//5)	Land on the symbol “.” (dot) – move the player to the new position, nothing else happens; 
//print on the console “Made a move!”
//When the game ends (either the player has lost or all moves were made), print “Total moves made: X”.
//Input
//•	The input data should be read from the console.
//•	On the first line of input you will receive the number N – number of rows of the labyrinth.
//•	On the next N lines you will receive the layout of the labyrinth.
//•	On the last line you will receive the moves you need to make as a string.
//•	The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//•	The output should be printed on the console.
//•	For each outcome print the required output as described above.
//Constraints
//•	The number N will be an integer in the range [1 … 15].
//•	The labyrinth will contain only the symbols – “_”, “|”, “@”, “#”, “*”, “$”, “ “ (single whitespace), “.”.
//•	The string containing the moves will contain only the symbols – “v”, “^”, “<”, and “>”.
//•	Allowed working time for your program: 0.5 seconds. Allowed memory: 16 MB.
//Examples
//Input	                     Output                         	         Comments
//  5                   umped a wall.                    Player starts at (0, 0). First move is “>” (right),
// .|                   Made a move!                     which takes the player into a wall. Next, he moves
// ..|                  Made a move!                     down and right. The next move is right again and
// *.$  .               Bumped a wall.                   he hits another wall. He then moves down twice, on 
// ###...               Made a move!                     the second move he lands on an obstacle (“#”) and
// ______               Ouch! That hurt! Lives left: 2   loses a life point. He then moves right and loses
// >v>>vv>>>^^^<<	    Ouch! That hurt! Lives left: 1   another life. Two moves to the right are followed
//                      Made a move!                     by a move upwards which takes him out of the
//                      Made a move!                     labyrinth (empty cell), so the game is over. The
//                      Fell off a cliff! Game Over!     total number of moves where the player actually
//                      Total moves made: 8              changed position is 8.	       
public class p3LabyrinthDash {
    public static void main(String[] args) {    	   	
   
    
//    	Scanner scan = new Scanner(System.in);
//    	int lineLenght = Integer.parseInt(scan.nextLine());
//    	char[][] labirintDash = new char[lineLenght][];
//    	for (int i = 0; i < lineLenght; i++) {
//    		labirintDash[i] = scan.nextLine().toCharArray();
//    	}
//    	char[] moveDirections = scan.nextLine().toCharArray();
//    	scan.close();
//    	int startRow = 0;
//    	int starCol = 0;
//    	int tempRow = 0;
//    	int tempCol = 0;
//    	int stepCount = 0;
//    	int defaultLives = 3;
//    	boolean  gameOver = false;
//    	for (int i = 0; i < moveDirections.length; i++) {
//    		if (gameOver) {
//    			break;
//    		}
//    		char directin = moveDirections[i];
//    		switch (directin) {
//    		case 'v': tempRow++; break;
//    		case '^': tempRow--; break;	
//    		case '<': tempCol--; break;
//    		case '>': tempCol++; break;	
//    		}		
//    		char currentChar = labirintDash[tempRow][tempCol];
//    		if (currentChar == '_' || currentChar == '|') {
//    			tempRow = startRow;
//    			tempCol = starCol;
//    			System.out.println("Bumped a wall.");
//    		}else if (currentChar == '@' || currentChar == '#' || currentChar == '*') {
//    			System.out.printf("Ouch! That hurt! Lives left: %d\n",--defaultLives);
//    			stepCount++;
//    			 if (defaultLives <= 0) {
//    				 gameOver = true;
//    				 System.out.println("No lives left! Game Over!");
//    			}
//    		}else if (currentChar == '$') {
//    			System.out.printf("Awesome! Lives left: %d\n",++defaultLives);
//    			labirintDash[tempRow][tempCol]= '.';
//    			stepCount++;
//    		}else if (currentChar == ' ' || tempRow > lineLenght - 1 ||  tempRow < 0) {
//    			System.out.printf("Fell off a cliff! Game Over!\n");
//    			stepCount++;
//    			gameOver = true;
//    		}else if (currentChar == '.') {
//    			System.out.printf("Made a move!\n");
//    			stepCount++;
//    		}
//    		startRow = tempRow;
//    		starCol = tempCol;
//    	 }
//    	System.out.printf("Total moves made: %d",stepCount);
    
     // avt
    
    	
    	Scanner scn = new Scanner(System.in);

        int countOfRows = Integer.parseInt(scn.nextLine());
        char[][] labyrinth = new char[countOfRows][];

        for (int i = 0; i < countOfRows; i++) {
            labyrinth[i] = scn.nextLine().toCharArray();
        }

        char[] moves = scn.nextLine().toCharArray();

        int currentRow = 0;
        int currentCol = 0;
        int movesMade = 0;
        int livesLeft = 3;

        for (char move : moves) {
            int initialRow = currentRow;
            int initialCol = currentCol;

            switch (move) {
                case '>':
                    currentCol++;
                    break;
                case '<':
                    currentCol--;
                    break;
                case 'v':
                    currentRow++;
                    break;
                case '^':
                    currentRow--;
                    break;
            }

            if (cellIsOutsideLabyrinth(currentRow, currentCol, labyrinth)) {
                movesMade++;
                System.out.println("Fell off a cliff! Game Over!");
                break;
            } else if (cellIsWall(currentRow, currentCol, labyrinth)) {
                currentRow = initialRow;
                currentCol = initialCol;
                System.out.println("Bumped a wall.");
            } else if (cellIsObstacle(currentRow, currentCol, labyrinth)) {
                movesMade++;
                livesLeft--;
                System.out.printf("Ouch! That hurt! Lives left: %d%n", livesLeft);

                if (livesLeft == 0) {
                    System.out.println("No lives left! Game Over!");
                    break;
                }
            } else if (cellIsLife(currentRow, currentCol, labyrinth)) {
                movesMade++;
                livesLeft++;
                labyrinth[currentRow][currentCol] = '.';
                System.out.printf("Awesome! Lives left: %d%n", livesLeft);
            } else {
                movesMade++;
                System.out.println("Made a move!");
            }
        }

        System.out.printf("Total moves made: %d", movesMade);
        scn.close();
    }

    private static boolean cellIsOutsideLabyrinth(int row, int col, char[][] labyrinth) {
        if (row < 0 || row >= labyrinth.length) {
            return true;
        }

        if (col < 0 || col >= labyrinth[row].length) {
            return true;
        }

        return labyrinth[row][col] == ' ';
    }

    private static boolean cellIsWall(int row, int col, char[][] labyrinth) {
        return labyrinth[row][col] == '|' || labyrinth[row][col] == '_';
    }

    private static boolean cellIsObstacle(int row, int col, char[][] labyrinth) {
        return labyrinth[row][col] == '@' || labyrinth[row][col] == '#' || labyrinth[row][col] == '*';
    }

    private static boolean cellIsLife(int row, int col, char[][] labyrinth) {
        return labyrinth[row][col] == '$';
    }    	
    	    	    	   
}































