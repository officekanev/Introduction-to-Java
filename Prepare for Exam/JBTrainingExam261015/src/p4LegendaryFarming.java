import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

//                                                             Problem 4 – Legendary Farming
//You’ve beaten all the content and the last thing left to accomplish is own a legendary item. However, it’s a tedious process
//and requires quite a bit of farming. Anyway, you are not too pretentious – any legendary will do. The possible items are:
//•	Shadowmourne – requires 250 Shards;
//•	Valanyr – requires 250 Fragments;
//•	Dragonwrath – requires 250 Motes;
//Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as 
//2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race. At that point, 
//print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes, ordered by quantity in
//descending order, each on a new line. Finally, print the collected junk items, in alphabetical order.
//Input
//•	Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}
//Output
//•	On the first line, print the obtained item in format {Legendary item} obtained!
//•	On the next three lines, print the remaining key materials in descending order by quantity
//o	If two key materials have the same quantity, print them in alphabetical order
//•	On the final several lines, print the junk items in alphabetical order
//o	All materials are printed in format {material}: {quantity}
//o	All output should be lowercase, except the first letter of the legendary
//Constraints
//•	The quantity-material pairs are between 1 and 25 per line.
//•	The number of lines is in range [1..10]
//•	All materials are case-insensitive.
//•	Allowed working time: 0.25s
//•	Allowed memory: 16 MB
//Examples
//input                                       Output                      Input	                             Output
//3 Motes 5 stones 5 Shards               Valanyr obtained!    123 silver 6 shards 8 shards 5 motes     Dragonwrath obtained!
//6 leathers 255 fragments 7 Shards	      fragments: 5         9 fangs 75 motes 103 MOTES 8 Shards      shards: 22
//                                        shards: 5            86 Motes 7 stones 19 silver              motes: 19
//                                        motes: 3                                                      fragments: 0
//                                        leathers: 6                                                   fangs: 9
//                                        stones: 5                                                     silver: 123
public class p4LegendaryFarming {
 private static final int WIN_QUANTITY = 250;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<String, Integer>() {{
            put("fragments", 0);
            put("motes", 0);
            put("shards", 0);
        }};
        TreeMap<String, Integer> junk = new TreeMap<>();
        String keyMaterialCollectedFirst = "";

        while (true) {
            String[] items = scn.nextLine().split(" ");
            for (int i = 0; i < items.length; i += 2) {
                int quantity = Integer.parseInt(items[i]);
                String item = items[i + 1].toLowerCase();

                if (keyMaterials.containsKey(item)) {
                    keyMaterials.put(item, keyMaterials.get(item) + quantity);

                    if (keyMaterials.get(item) >= WIN_QUANTITY) {
                        keyMaterials.put(item, keyMaterials.get(item) - WIN_QUANTITY);
                        keyMaterialCollectedFirst = item;
                        break;
                    }

                } else {
                    if (!junk.containsKey(item)) {
                        junk.put(item, 0);
                    }

                    junk.put(item, junk.get(item) + quantity);
                }
            }

            if (keyMaterialCollectedFirst.length() > 0) {
                break;
            }
        }
         scn.close();
        System.out.println(getLegendary(keyMaterialCollectedFirst) + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        junk.entrySet().forEach(j -> System.out.println(j.getKey() + ": " + j.getValue()));
    }

    private static String getLegendary(String material) {
        if (material.equals("shards")) return "Shadowmourne";
        if (material.equals("fragments")) return "Valanyr";

        return "Dragonwrath";
    }
}

















