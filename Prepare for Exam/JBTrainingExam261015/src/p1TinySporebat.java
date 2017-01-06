import java.util.Scanner;

//                                            Problem 1 – Tiny Sporebat
//Exploring Outland, you find yourself in the murky waters of Zangarmarsh. It’s a fascinating land inhabited by mystical
//creatures. Perhaps the strangest of all are the sporelings – a nation of friendly mushroom-like people. They keep 
//sporebats as pets – little cute flying thingies. You’d like to own one, but this will be a bit tricky – sporelings do
//	not accept regular money, their currency is a special kind of mushroom called a Glowcap. Your task is to collect as
//	many Glowcaps as possible and buy the desired pet. So you go out of their capital – Sporeggar – collecting Glowcaps.
//The Glowcaps are represented as a digit at the end of a string. For instance, abcdef9 means that there are 9 Glowcaps 
//ready to be collected behind some enemies. The enemies are abcdef. To reach the Glowcaps, you must pass through those
//enemies. Each one of them does damage to you – equal to the ASCII value of the character. For example, ‘a’ does 97
//damage to you. The only special character is uppercase ‘L’ – this is Lifebloom, healing you for 200 points. Your 
//starting health is 5800 points. If you pass through all the enemies, you collect the Glowcaps, and continue.
//The game ends in two cases – you reach Sporeggar, or your health drops to zero or below. Reaching Sporeggar is 
//described by the string Sporeggar, which also signifies the end of input. If your health drops to zero, you are dead.
//If you reach Sporeggar, check if you can buy the sporebat. Its cost is 30 glowcaps. There are three kinds of output:
//•	If you are well and alive in Sporeggar:
//o	Print the remaining health: “Health left: {h}”, where h is the remaining health
//o	If you can buy the sporebat: “Bought the sporebat. Glowcaps left: {n}”, where n is the number of remaining glowcaps
//o	 If you cannot buy it: “Safe in Sporeggar, but another {n} Glowcaps needed.”, n is the number of additional glowcaps
//required
//•	If you die: “Died. Glowcaps: {n}”, n is the number of glowcaps collected.
//Input
//•	Until the string Sporeggar is reached, you are given a series of strings – each with a number at the end
//Output
//•	The output is according to the description above. Check the examples for further understanding.
//Constraints
//•	The number of strings is in range [2 .. 50]
//•	The length of each string is [1 … 20]. It can contain ANY ASCII character.
//•	The number of glowcaps is an integer in range [0 … 9]
//•	Allowed memory: 16 MB
//•	Allowed time: 0.25s
//Examples
//Input                      	Output
//Abcdef5                   Health left: 4853
//^&^*(8                    Safe in Sporeggar, but another 14 Glowcaps needed.
//J3
//Sporeggar	

//Input                       	Output
//Asdkha6                  Health left: 299
//Ashdasjh9                Bought the sporebat. Glowcaps left: 7
//A;sljajk9
//A;slkdjad2
//Lkdjgjkkj2
//A;lksjdakjsd3
//A;lksjd6
//Sporeggar	

//Input	                         Output
//zyzyxyzxyzyxzzzxxxz5       Died. Glowcaps: 6
//zyzh;lakja;kldjaksjdak1
//Klasdhasdajksdjasjdjasd2
//Sporeggar	
public class p1TinySporebat {
  public static void main(String[] args) {
	  
	            // moe 80 points
//		Scanner scan = new Scanner(System.in);                   //  80 point
//		String line = scan.nextLine();
//		boolean pointIsPositive = true;
//		int health = 5800;
//		int Glowcap = 0;
//		while (!line.contains("Sporeggar") && pointIsPositive) {
//			for (int i = 0; i < line.length(); i++) {
//				char current = line.charAt(i);
//				if (current =='L') {
//					health += 200;
//				}else if (current >= '0' && current <= '9') {
//					Glowcap += (current - 48);
//				}else {												
//				   health -= current;
//				}
//				if (health <= 0) {
//					pointIsPositive = false;
//					break;
//				}
//			}
//			line = scan.nextLine();
//		}
//		scan.close();
//		int growBuy = Glowcap - 30;
//		if (health <= 0) {
//			System.out.printf("Died. Glowcaps: %d",Glowcap);
//		}else if (growBuy >= 0) {
//			System.out.printf("Health left: %d\n",health);
//			System.out.printf("Bought the sporebat. Glowcaps left: %d",Glowcap - 30);
//		}else {
//			System.out.printf("Health left: %d\n",health);
//			System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.",30 - Glowcap);
//		}
	            // avt 100 point
	  
	  Scanner scn = new Scanner(System.in);
	     int startingHealth = 5800;
	     int tinySporebatCost = 30;
	     long totalGlowcaps = 0;

	     String line = scn.nextLine();
	     while (!line.equals("Sporeggar")) {
	         int glowcaps = line.charAt(line.length() - 1) - '0';
	         char[] enemies = line.substring(0, line.length() - 1).toCharArray();
	         for (char enemy : enemies) {
	             if (enemy != 'L') {
	                 startingHealth -= enemy;
	                 if (startingHealth <= 0) {
	                     System.out.println("Died. Glowcaps: " + totalGlowcaps);
	                     return;
	                 }
	             } else {
	                 startingHealth += 200;
	             }
	         }
	         totalGlowcaps += glowcaps;
	         line = scn.nextLine();
	     }

	     System.out.println("Health left: " + startingHealth);

	     if (totalGlowcaps >= tinySporebatCost) {
	         System.out.println("Bought the sporebat. Glowcaps left: " + (totalGlowcaps - tinySporebatCost));
	     } else {
	         System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", (tinySporebatCost - totalGlowcaps));
	     }
  }
}



















