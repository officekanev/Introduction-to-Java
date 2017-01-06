import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//                                                    Problem 4 – Dragon Army
//Heroes III is the best game ever. Everyone loves it and everyone plays it all the time. Stamat is no exclusion to this rule. 
//His favorite units in the game are all types of dragons – black, red, gold, azure etc… He likes them so much that he gives them 
//names and keeps logs of their stats: damage, health and armor. The process of aggregating all the data is quite tedious, so he
//would like to have a program doing it. Since he is no programmer, it’s your task to help him
//You need to categorize dragons by their type. For each dragon, identified by name, keep information about his stats. Type is 
//preserved as in the order of input, but dragons are sorted alphabetically by name. For each type, you should also print the
//average damage, health and armor of the dragons. For each dragon, print his own stats. 
//There may be missing stats in the input, though. If a stat is missing you should assign it default values. Default values are
//as follows: health 250, damage 45, and armor 10. Missing stat will be marked by null.
//The input is in the following format {type} {name} {damage} {health} {armor}. Any of the integers may be assigned null value.
//See the examples below for better understanding of your task.
//If the same dragon is added a second time, the new stats should overwrite the previous ones. Two dragons are considered equal
//if they match by both name and type.
//Input
//•	On the first line, you are given number N -> the number of dragons to follow
//•	On the next N lines you are given input in the above described format. There will be single space separating each element.
//Output
//•	Print the aggregated data on the console
//•	For each type, print average stats of its dragons in format {Type}::({damage}/{health}/{armor})
//•	Damage, health and armor should be rounded to two digits after the decimal separator
//•	For each dragon, print its stats in format -{Name} -> damage: {damage}, health: {health}, armor: {armor}
//Constraints
//•	N is in range [1…100]
//•	The dragon type and name are one word only, starting with capital letter.
//•	Damage health and armor are integers in range [0 … 100000] or null
//Examples
//Input                                             Output
//5                                        Red::(160.00/2350.00/30.00)
//Red Bazgargal 100 2500 25        -Bazgargal -> damage: 100, health: 2500, armor: 25         
//Black Dargonax 200 3500 18       -Obsidion -> damage: 220, health: 2200, armor: 35
//Red Obsidion 220 2200 35          Black::(200.00/3500.00/18.00)
//Blue Kerizsa 60 2100 20           -Dargonax -> damage: 200, health: 3500, armor: 18
//Blue Algordox 65 1800 50	        Blue::(62.50/1950.00/35.00)
//                                  -Algordox -> damage: 65, health: 1800, armor: 50
//                                  -Kerizsa -> damage: 60, health: 2100, armor: 20

//Input	                                              Output
//4                                 Gold::(223.75/826.25/17.50)
//Gold Zzazx null 1000 10           -Ardrax -> damage: 100, health: 1055, armor: 50
//Gold Traxx 500 null 0             -Traxx -> damage: 500, health: 250, armor: 0
//Gold Xaarxx 250 1000 null         -Xaarxx -> damage: 250, health: 1000, armor: 10
//Gold Ardrax 100 1055 50	        -Zzazx -> damage: 45, health: 1000, armor: 10
public class p4Dragonarmy {
  private static final int DEFAULT_DMG = 45;
    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] tokens = scn.nextLine().split(" ");
        String type = tokens[0];
        String name = tokens[1];
        int damage = tokens[2].equals("null") ? DEFAULT_DMG : Integer.parseInt(tokens[2]);
        int health = tokens[3].equals("null") ? DEFAULT_HEALTH : Integer.parseInt(tokens[3]);
        int armor = tokens[4].equals("null") ? DEFAULT_ARMOR : Integer.parseInt(tokens[4]);

        if (!dragons.containsKey(type)) {
            dragons.put(type, new TreeMap<>());
        }
        if (!dragons.get(type).containsKey(name)) {
            dragons.get(type).put(name, new int[3]);
        }

        dragons.get(type).get(name)[0] = damage;
        dragons.get(type).get(name)[1] = health;
        dragons.get(type).get(name)[2] = armor;
    }

    for (Map.Entry<String, TreeMap<String, int[]>> typeInfo : dragons.entrySet()) {
        double[] average = calculateAverage(typeInfo.getValue());
        System.out.printf("%s::(%.2f/%.2f/%.2f)\n", typeInfo.getKey(), average[0], average[1], average[2]);
        for (Map.Entry<String, int[]> dragonInfo : typeInfo.getValue().entrySet()) {
            System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                    dragonInfo.getKey(),
                    dragonInfo.getValue()[0],
                    dragonInfo.getValue()[1],
                    dragonInfo.getValue()[2]);
        }
    }
    scn.close();
}

private static double[] calculateAverage(TreeMap<String, int[]> map) {
    double totalEntries = map.size();
    int totalDamage = 0;
    int totalHealth = 0;
    int totalArmor = 0;

    for (Map.Entry<String, int[]> entry : map.entrySet()) {
        totalDamage += entry.getValue()[0];
        totalHealth += entry.getValue()[1];
        totalArmor += entry.getValue()[2];
    }

    return new double[] {
            totalDamage / totalEntries,
            totalHealth / totalEntries,
            totalArmor / totalEntries
    };
}
}




















