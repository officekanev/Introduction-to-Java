import java.util.HashMap;
import java.util.Scanner;

//                                               Problem 3 – The Heigan Dance
//At last, level 80. And what do level eighties do? Go raiding. This is where you are now – trying not to be wiped by the famous
//		dance boss, Heigan the Unclean. The fight is pretty straightforward - dance around the Plague Clouds and Eruptions, and
//		you’ll be just fine.
//Heigan’s chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center. For each turn, Heigan uses
//a spell that hits a certain cell and the neighboring rows/columns. For example, if he hits (1,1), he also hits (0,0, 0,1, 0,2,
//		1,0 … 2,2). If the player’s current position is within the area of damage, the player tries to move. First he tries to
//move up, if there’s damage/wall, he tries to move right, then down, then left. If he cannot move in any direction, because the
//cell is damaged or there is a wall, the player stays in place and takes the damage.
//Plague cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does 6000 damage when it
//hits. If a spell will hit a player that also has an active Plague Cloud from the previous turn, the cloud damage is applied 
//first. Both Heigan and the player may die in the same turn. If Heigan is dead, the spell he would have casted is ignored.
//The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player does damage to
//Heigan. The fight is over either when the player is killed, or Heigan is defeated.
//Input
//•	On the first line you receive a floating-point number D – the damage done to Heigan each turn
//•	On the next several lines – you receive input in format {spell} {row} {col} – {spell} is either Plague or Eruption
//Output
//•	    On the first line  
//o	If Heigan is defeated: “Heigan: Defeated!”
//o	Else: “Heigan: {remaining}”, where remaining is rounded to two digits after the decimal separator
//•	    On the second line:
//o	If the player is killed: “Player: Killed by {spell}”
//o	Else “Player: {remaining}”
//•	    On the third line: “Final position: {row, col}” -> the last coordinates of the player. 
//Constraints
//•	D is a floating-point number in range [0 … 500000]
//•	A damaging spell will always affect at least one cell
//•	Allowed memory: 16 MB
//•	Allowed working time: 0.25s
//Examples
//Input	            Output                       Input	           Output              Input	         Output
//10000          Heigan: 2960000.00             500000         Heigan: Defeated!      12500.66     Heigan: 2949997.36
//Cloud 7 7     Player: Killed by Eruption      Cloud 7 6      Player: 12500          Cloud 7 7    Player: Killed by Plague Cloud
//Eruption 6 7  Final position: 8, 7            Eruption 7 8   Final position: 7, 11  Cloud 7 7    Final position: 7, 7
//Eruption 8 7                                  Eruption 7 7                          Cloud 7 7
//Eruption 8 7	                                Cloud 7 8                             Cloud 7 7
//                                              Eruption 7 9
//                                              Eruption 6 14
//                                              Eruption 7 11	
public class p3TheHeiganDance {
	private static final int MIN_LIMIT = 0;
    private static final int MAX_LIMIT = 14;
    private static final int CLOUD_DAMAGE = 3500;
    private static final int ERUPTION_DAMAGE = 6000;
    private static HashMap<String, Integer> damagePositions;
    
  public static void main(String[] args) {
	  Scanner scn = new Scanner(System.in);

      double heigan = 3000000d;
      boolean isHeiganDefeated = false;

      int player = 18500;
      boolean isPlayerDefeated = false;
      boolean hasCloud = false;
      String causeOfDeath = "";

      int[] playerPosition = {7, 7};

      double averageDamage = Double.parseDouble(scn.nextLine());
      while (true) {
          String[] attackArgs = scn.nextLine().split(" ");
          int row = Integer.parseInt(attackArgs[1]);
          int col = Integer.parseInt(attackArgs[2]);

          heigan -= averageDamage;
          isHeiganDefeated = heigan <= 0;

          if (hasCloud) {
              player -= CLOUD_DAMAGE;
              hasCloud = false;
              causeOfDeath = "Plague Cloud";
              isPlayerDefeated = player <= 0;
          }

          if (isHeiganDefeated || isPlayerDefeated) {
              break;
          }

          getDamageArea(row, col);
          if (isPlayerInDamageZone(playerPosition)) {
              if (playerPosition[0] > MIN_LIMIT && playerPosition[0] == damagePositions.get("minRow")) {
                  playerPosition[0]--;
              } else if (playerPosition[0] < MAX_LIMIT && playerPosition[0] == damagePositions.get("maxRow")) {
                  playerPosition[0]++;
              } else if (playerPosition[1] > MIN_LIMIT && playerPosition[1] == damagePositions.get("minCol")) {
                  playerPosition[1]--;
              } else if (playerPosition[1] < MAX_LIMIT && playerPosition[1] == damagePositions.get("maxCol")) {
                  playerPosition[1]++;
              }
          }

          if (isPlayerInDamageZone(playerPosition)) {
              if (attackArgs[0].equals("Cloud")) {
                  player -= CLOUD_DAMAGE;
                  hasCloud = true;
                  causeOfDeath = "Plague Cloud";
              } else {
                  player -= ERUPTION_DAMAGE;
                  causeOfDeath = "Eruption";
              }
          }

          isPlayerDefeated = player <= 0;

          if (isPlayerDefeated) {
              break;
          }
      }

      if (isHeiganDefeated) {
          System.out.println("Heigan: Defeated!");
      } else {
          System.out.printf("Heigan: %.2f\n", heigan);
      }

      if (isPlayerDefeated) {
          System.out.println("Player: Killed by " + causeOfDeath);
      } else {
          System.out.println("Player: " + player);
      }

      System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
      scn.close();
  }

  private static void getDamageArea(int row, int col) {
      damagePositions = new HashMap<>();
      damagePositions.put("minRow", row - 1);
      damagePositions.put("maxRow", row + 1);
      damagePositions.put("minCol", col - 1);
      damagePositions.put("maxCol", col + 1);
  }

  private static boolean isPlayerInDamageZone(int[] playerPosition) {
      boolean isInHitRow = playerPosition[0] >= damagePositions.get("minRow") &&
              playerPosition[0] <= damagePositions.get("maxRow");
      boolean isInHitCol = playerPosition[1] >= damagePositions.get("minCol") &&
              playerPosition[1] <= damagePositions.get("maxCol");

      return isInHitRow && isInHitCol;
  }
}
























