import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//                              Problem 4 – Activity Tracker
//You are part of the server side application team of brand new and promising activity tracking
//company. Their product “The Spy” is constantly sending data to the server. The data represents
//the distance walked in meters for every user in format:
//•	24/07/2014 Angel 4600
//•	24/07/2014 Pesho 3200
//•	25/07/2014 Angel 6500
//•	01/08/2014 Pesho 5600
//•	03/08/2014 Ivan 11400
//Write a program to aggregate the data and print the activity of each user per month. The months
//should be represented in ascending order. The users should be ordered alphabetically and the
//data should be represented in the following way: <month>: <user>(<distance>), <user>(<distance>),…
//For the data above the output should be:
//•	7: Angel(11100), Pesho(3200)
//•	8: Ivan(11400), Pesho(5600)
//Input
//The input comes from the console. At the first line a number n stays which says how many data 
//lines will follow. Each of the next n lines holds a data in format <date> <user> <distance>. 
//The input data will always be valid and in the format described. There is no need to check it
//explicitly.
//Output
//Print one line for each month (months are in ascending order). For each month print the users
//and the sum of distances for each one of them, in descending order in
//format <month>: <user>(<distance>), <user>(<distance>),…
//Constraints
//•	The count of the data lines n is in the range [1…1000].
//•	The <date> is a standard date in format dd/mm/yyyy where dd is the day of the month,
//mm is the numeric representation of the month and yyyy is
//the full numeric represenation of the year.
//•	The <user> consists of only of Latin characters, with length of [1…20].
//•	The <distance> is floating point number in the range [1…1000].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Example
//  input             	  Output	                     Input	                 Output
//   5                   7: Angel(11100),                3                       7: Nakov(23642)
//4/07/2014 Angel 4600     Pesho(3200)                  10/07/2014 Nakov 10345
//24/07/2014 Pesho 3200   8: Ivan(11400), Pesho(5600)   15/07/2014 Nakov 8765
//25/07/2014 Angel 6500                                 20/07/2014 Nakov 4532
//01/08/2014 Pesho 5600
//03/08/2014 Ivan 11400

public class p4ActivityTracker {
    public static void main(String[] args) {
    	//read the input for the number of data lines
    			Scanner str = new Scanner(System.in);
    			int n = Integer.parseInt(str.nextLine());
    			
    			//create the construct to hold the data
    			TreeMap<Integer, TreeMap<String, Integer>> months = new TreeMap<>();

    			//populate the data in the construct
    			for (int i = 0; i < n; i++) {
    				String[] input = str.nextLine().split(" ");
    				String[] date = input[0].split("/");
    				
    				//create temporary variables for the current data line
    				int month = Integer.parseInt(date[1]);
    				String user = input[1];
    				int distance = Integer.parseInt(input[2]);
    				
    				//check if the month is already present or not and act accordingly
    				if (!months.containsKey(month)) {
    					TreeMap<String, Integer> users = new TreeMap<>();
    					users.put(user, distance);
    					months.put(month, users);
    				}
    				else {
    					//check if the user is already present or not and act accordingly
    					TreeMap<String, Integer> users = months.get(month);
    					if (!users.containsKey(user)) {
    						users.put(user, distance);
    					}
    					else {
    						int tempDistance = users.get(user);
    						tempDistance += distance;
    						users.put(user, tempDistance);
    					}
    					months.put(month, users);
    				}
    			}
    			str.close();
    			
    			//print the output as needed
    			for (Iterator it = months.entrySet().iterator(); it.hasNext();) {
    				Map.Entry month = (Map.Entry) it.next();
    				
    				String outputLine = month.getKey() + ": ";

    				TreeMap users = (TreeMap) month.getValue();
    				for (Iterator it2 = users.entrySet().iterator(); it2.hasNext();) {
    					Map.Entry user = (Map.Entry) it2.next();
    					
    					outputLine += user.getKey() + "(" + user.getValue() + "), ";
    				}

    				outputLine = outputLine.substring(0, outputLine.length() - 2);
    				System.out.println(outputLine);
    			}
   }       
}
