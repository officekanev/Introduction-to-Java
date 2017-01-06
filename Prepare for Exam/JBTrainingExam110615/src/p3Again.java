import java.util.Scanner;

public class p3Again {
  public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int lineLenght = Integer.parseInt(scan.nextLine());
	char[][] labirintDash = new char[lineLenght][];
	for (int i = 0; i < lineLenght; i++) {
		labirintDash[i] = scan.nextLine().toCharArray();
	}
	char[] moveDirections = scan.nextLine().toCharArray();
	scan.close();
	int startRow = 0;
	int starCol = 0;
	int tempRow = 0;
	int tempCol = 0;
	int stepCount = 0;
	int defaultLives = 3;
	for (int i = 0; i < moveDirections.length; i++) {
		char directin = moveDirections[i];
		switch (directin) {
		case 'v': tempRow++; break;
		case '^': tempRow--; break;	
		case '<': tempCol--; break;
		case '>': tempCol++; break;	
		}		
		char currentChar = labirintDash[tempRow][tempCol];
		if (currentChar == '_' || currentChar == '|') {
			tempRow = startRow;
			tempCol = starCol;
			System.out.println("Bumped a wall.");
		}else if (currentChar == '@' || currentChar == '#' || currentChar == '*') {
			System.out.printf("Ouch! That hurt! Lives left: %d\n",--defaultLives);
			stepCount++;
			 if (defaultLives <= 0) {				 			
				 System.out.println("No lives left! Game Over!"); break;
			}
		}else if (currentChar == '$') {
			System.out.printf("Awesome! Lives left: %d\n",++defaultLives);
			labirintDash[tempRow][tempCol]= '.';
			stepCount++;
		}else if (currentChar == ' ' || tempRow > lineLenght - 1 ||  tempRow < 0) {
			System.out.printf("Fell off a cliff! Game Over!\n");
			stepCount++;			
			break;
		}else if (currentChar == '.') {
			System.out.printf("Made a move!\n");
			stepCount++;
		}
		startRow = tempRow;
		starCol = tempCol;
	 }
	System.out.printf("Total moves made: %d",stepCount);
	
 }
}
