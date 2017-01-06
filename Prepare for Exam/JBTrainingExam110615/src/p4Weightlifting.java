import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

//                                             Problem 4 – Weightlifting
//Soon there will be a world championship on Weightlifting and all the famous players are preparing for it.
//As a coach of an international team, your job is to ensure each player has sufficient training, but is 
//not exhausted more than he should. Every day you prepare a list of exercises and at the end of the day 
//you want to know how much the players have trained. The list will be a sequence of N lines holding the 
//exercises of the players in your team for that day.
//Write a program that prints all players in alphabetical order. For each player, the program should print
//the type of exercise and the total weight the player has lifted doing that exercise. The exercises should 
//be ordered alphabetically for each player.
//Input
//The input comes from the console. The first line holds the length of the input list N. 
//On the next N lines, there will be information about the exercises for that day in the following format:
//	“<player> <exercise> <weight> kg”. 
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//Print at the console one line for each player in the following format: <player> : <exercise> - <weight> kg,
//<exercise> - <weight> kg,…
//Constraints
//•	The count N will be an integer number in the range [1…50].
//•	The weight will be a positive integer number.
//•	The input lines may hold any ASCII character.
//•	Time limit: 0.2 sec. Memory limit: 16 MB.
//Examples
//Input	                                                              Output
//6                                                Jack : Deadlift - 120 kg, Squat - 200 kg
//Jack Squat 200 kg                                John : Benchpress 200 kg, Deadlift - 220 kg, Squat - 290 kg
//John Deadlift 220 kg
//John Squat 150 kg
//Jack Deadlift 120 kg
//John Benchpress 200 kg
//John Squat 140 kg 	


//Input	                                                              Output
//5                                               John Squat 200 kg	John : Deadlift - 220 kg, Squat - 200 kg
//Mark Squat 500 kg                               Mark : Deadlift - 120 kg, Squat - 550 kg
//John Deadlift 220 kg
//Mark Squat 50 kg
//Mark Deadlift 120 kg
public class p4Weightlifting {
   public static void main(String[] args) {
	   Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		read.nextLine();
		
		// Filling up our TreeMap with nested LinkedHashMap
		TreeMap<String, TreeMap<String, Long>> weightlifting = new TreeMap<String, TreeMap<String, Long>>();
		for (int i = 0; i < n; i++) {
			String line = read.nextLine(); 
			String[] inputs = line.split(" ");
			String name = inputs[0];
			String exercise = inputs[1];
			Long weights = Long.parseLong(inputs[2]);
			//Checking if our Maps contain the current keys(name and exercise)
			if(!weightlifting.containsKey(name)){
				weightlifting.put(name,new TreeMap<String, Long>()); 
				weightlifting.get(name).put(exercise, weights);
			} else {
				if(!weightlifting.get(name).containsKey(exercise)){
					weightlifting.get(name).put(exercise, weights);
				} else {
					long oldWeights = weightlifting.get(name).get(exercise);
					weightlifting.get(name).put(exercise,weights + oldWeights);
				}
				
			}
		}
		// Keeping our keys in a new variable, so we can iterate through the TreeMap
		Set<String> keys = weightlifting.keySet();
		
		for (String name : keys) {
			TreeMap<String, Long> results = weightlifting.get(name);
			System.out.printf("%s : ",name);
			// Keeping our keys in a new variable, so we can iterate through the LinkedHashMap
			Set<String> exercises = results.keySet();
			//Setting up a boolean variable, so we can put the right number of commas
			boolean isFirst = true;
			for (String exercise : exercises) {
				long totalWeights = results.get(exercise);
				if (!isFirst) {
					System.out.print(", ");
				}
				
				isFirst = false;
				System.out.printf("%s - %d kg",exercise, totalWeights);

				
			}
			System.out.println();
		}
   }
}























