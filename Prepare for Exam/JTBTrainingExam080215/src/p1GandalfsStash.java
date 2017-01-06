import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//                    Problem 1 – Gandalf`s Stash
//Gandalf the Gray is a great wizard but he also loves to eat. When he is hungry he gets angry.
//These are some of Gandalf's favorite types of food: 
//•	Cram: 2 points of happiness;
//•	Lembas: 3 points of happiness;
//•	Apple: 1 point of happiness;
//•	Melon: 1 point of happiness;
//•	HoneyCake: 5 points of happiness;
//•	Mushrooms: -10 points of happiness;
//•	Everything else: -1 point of happiness;
//Gandalf moods are:
//•	Angry - below -5 points of happiness;
//•	Sad - from -5 to 0 points of happiness;
//•	Happy - from 0 to 15 points of happiness;
//•	Special JavaScript mood - when happiness points are more than 15;
//Input
//The input comes from the console. It will holds two lines: first - Gandalf`s first mood.
//On the second line will be described the foods that Gandalf will eat, separated with different
//symbols or whitespace(s).  Comparing the input is case-insensitive. The input data will always
//be valid and in the format described. There is no need to check it explicitly.
//Output
//Print on the console Gandalf`s happiness points and mood after he drinks his beers.
//Constraints
//•	The characters in the input string will be no more than: 1000.
//•	The food count would be in the range [1…100].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input                                                      	                                   Output
//-10                                                                                                7
//Cram, banica,Melon!_,HonEyCake,	!HoneYCake,hoNeyCake_;	                                       Happy

//-30                                                                                               -27
//gosho, pesho, meze, Melon, HoneyCake@;	                                                       Angry

//-3                                                                                                47
//HoneyCake honeyCake honeyCake HoneyCakE HoneYCake HonEyCake HoneyCake HoneyCake HoneyCake    Special JavaScript mood
//HoNeyCake	

//-2                                                                                                -2
//mELon, AMelon, beer,cRam, nacepin	                                                                Sad
public class p1GandalfsStash {
   public static void main(String[] args) {
	 Scanner scan = new Scanner(System.in);
	 int startPoints = scan.nextInt();
	 scan.nextLine();
	 String line = scan.nextLine().toLowerCase();
	 scan.close();
	 String pattern = "[a-z]+";
	 Pattern  patr = Pattern.compile(pattern);
	 Matcher match = patr.matcher(line);
	 List<String> elements = new ArrayList<String>();
	 while (match.find()) {
		elements.add(match.group());		
	 }
	 for (String elem : elements) {
		int point = givePoints(elem);
		startPoints += point;
	}
	 if (startPoints < -5) {
		System.out.println(startPoints);
		System.out.println("Angry");
	}else if (startPoints >= -5 && startPoints <= -1) {
		System.out.println(startPoints);
		System.out.println("Sad");
	}else if (startPoints >= 0 && startPoints <= 15) {
		System.out.println(startPoints);
		System.out.println("Happy");
	}else {
		System.out.println(startPoints);
		System.out.println("Special JavaScript mood");
	}
	
   }
   
   public static int givePoints(String elem){
	   int point = 0;
	   switch (elem) {
	case "cram": point = 2; break;
	case "lembas": point = 3; break;
	case "apple": point = 1; break;
	case "melon": point = 1; break;
	case "honeycake": point = 5; break;
	case "mushrooms": point = -10; break;			
	default: point = -1; break;		
	}
	   return point;
   }
}








