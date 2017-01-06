import java.util.Scanner;

public class p2Monopoly {
	public static int countTotalMoney = 50;
	public static int countBoughtHotel = 0;
	public static int countTurnsInJail = 2;
	public static int countTurns = 0;
	public static boolean isItInJail = false; 
  public static void main(String[] args) {
	  Scanner scan = new Scanner(System.in);
		int lengthRow = scan.nextInt();
		scan.nextLine();
		String[] lines = new String[lengthRow];
		for (int i = 0; i < lengthRow; i++) {
			 lines[i] =  scan.nextLine();
		}	
		scan.close();
		for (int i = 0; i < lines.length; i++) {
			String currentRow = lines[i];	
			if (i % 2 == 0) {
				for (int j = 0; j < currentRow.length(); j++) {
					if (isItInJail) {
						countTurns ++;
						countTotalMoney += countBoughtHotel * 10;
						countTurnsInJail--;
						j--;
						if (countTurnsInJail == 0) {
							isItInJail = false;
						}					
					    continue;				    
					}
					char currentObject = currentRow.charAt(j);
					switch (currentObject) {
					case 'H': countBoughtHotel++;
					System.out.printf("Bought a hotel for %d. Total hotels: %d.",countTotalMoney,countBoughtHotel);
					System.out.println();
					countTotalMoney = 0;  countTurns ++;				         
						countTotalMoney  += countBoughtHotel * 10; break;
					case 'J': countTurnsInJail = 2; isItInJail = true;								        
					          System.out.printf("Gone to jail at turn %d.",countTurns);
					          System.out.println();    countTurns ++;
					    countTotalMoney += countBoughtHotel * 10;  break;
					case 'F': countTurns ++;		          
			            countTotalMoney += countBoughtHotel * 10; break;
					case 'S': countTurns ++;		          
		            countTotalMoney += countBoughtHotel * 10;
		            int spendMoney = (i+1 * j + 1);
		            countTotalMoney -= spendMoney; 
		            System.out.printf("Spent %d money at the shop.",spendMoney);
		            System.out.println();break;
					default:
						break;
					}
				}
			}else {
	             for (int j = currentRow.length()- 1; j >= 0 ; j--) {
	            		if (isItInJail) {
	    					countTurns ++;
	    					countTotalMoney += countBoughtHotel * 10;
	    					countTurnsInJail--;
	    					j--;
	    					if (countTurnsInJail == 0) {
	    						isItInJail = false;
	    					}   					
	    				    continue;				    
	    				}
	            		char currentObject = currentRow.charAt(j);
	    				switch (currentObject) {
	    				case 'H': countBoughtHotel++;
	    				System.out.printf("Bought a hotel for %d. Total hotels: %d.",countTotalMoney,countBoughtHotel);
	    				System.out.println();
	    				countTotalMoney = 0;  countTurns ++;				         
	    					countTotalMoney  += countBoughtHotel * 10; break;
	    				case 'J': countTurnsInJail = 2; isItInJail = true;   				       
	    				          System.out.printf("Gone to jail at turn %d.",countTurns);
	  				              System.out.println(); countTurns ++;
	    				    countTotalMoney = countBoughtHotel * 10;  break;
	    				case 'F': countTurns ++;		          
	    		            countTotalMoney += countBoughtHotel * 10; break;
	    				case 'S': countTurns ++;		          
	    	            countTotalMoney += countBoughtHotel * 10;
	    	            int spendMoney = (i+1 * j + 1);
	    	            countTotalMoney -= spendMoney; 
	    	            System.out.printf("Spent %d money at the shop.",spendMoney);
	    	            System.out.println(); break;
	    				default:
	    					break;
	    				}
				 }
			}		
		}
		System.out.printf("Turns %d",countTurns);
		System.out.println();
		System.out.printf("Money %d",countTotalMoney);
	  }    
}
