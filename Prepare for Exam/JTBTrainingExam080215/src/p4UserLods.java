//                                                        Problem 4 – User Logs
//Marian is a famous system administrator. The person to overcome the security of his servers has not yet been born. However, 
//there is a new type of threat where users flood the server with messages and are hard to be detected since they change their
//IP address all the time. Well, Marian is a system administrator and is not so into programming. Therefore, he needs a skillful
//programmer to track the user logs of his servers. You are the chosen one to help him!
//You are given an input in the format:
//IP=(IP.Address) message=(A&sample&message) user=(username)
//Your task is to parse the ip and the username from the input and for every user, you have to display every ip from which the 
//corresponding user has sent a message and the count of the messages sent with the corresponding ip. In the output, the 
//usernames must be sorted alphabetically while their IP addresses should be displayed in the order of their first appearance.
//The output should be in the following format:
//username: 
//IP => count, IP => count.
//For example, given the following input - IP=192.23.30.40 message='Hello&derps.' user=destroyer, you have to get the username 
//destroyer and the IP 192.23.30.40 and display it in the following format:
//destroyer: 
//192.23.30.40 => 1.
//The username destroyer has sent a message from ip 192.23.30.40 once.
//Check the examples below. They will further clarify the assignment.
//Input
//The input comes from the console as varying number of lines. You have to parse every command until the command that follows
//is end. The input will be in the format displayed above, there is no need to check it explicitly.
//Output
//For every user found, you have to display each log in the format:
//username: 
//IP => count, IP => count…
//The IP addresses must be split with a comma, and each line of IP addresses must end with a dot.
//Constraints
//•	The number of commands will be in the range [1..50]
//•	The IP addresses will be in the format of either IPv4 or IPv6.
//•	The messages will be in the format: This&is&a&message
//•	The username will be a string with length in the range [3..50]
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input	                                                             Output
//IP=192.23.30.40 message='Hello&derps.' user=destroyer             destroyer:
//IP=192.23.30.41 message='Hello&yall.' user=destroyer        192.23.30.40 => 2, 192.23.30.41 => 1, 192.23.30.42 => 1.
//IP=192.23.30.40 message='Hello&hi.' user=destroyer
//IP=192.23.30.42 message='Hello&Dudes.' user=destroyer
//end	  
 //                                                                               Output
//IP=FE80:0000:0000:0000:0202:B3FF:FE1E:8329 message='Hey&son' user=mother        child0: 
//IP=192.23.33.40 message='Hi&mom!' user=child0                                   192.23.33.40 => 1.
//IP=192.23.30.40 message='Hi&from&me&too' user=child1                            child1:
//IP=192.23.30.42 message='spam' user=destroyer                                   192.23.30.40 => 1.
//IP=192.23.30.42 message='spam' user=destroyer                                   destroyer:
//IP=192.23.50.40 message='' user=yetAnotherUsername                              192.23.30.42 => 2.
//IP=192.23.50.40 message='comment' user=yetAnotherUsername                       mother:
//IP=192.23.155.40 message='Hello.' user=unknown                                  FE80:0000:0000:0000:0202:B3FF:FE1E:8329 => 1.
//end	                                                                          unknown: 
//                                                                                192.23.155.40 => 1.
//                                                                                yetAnotherUsername: 
//                                                                                 192.23.50.40 => 2.
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p4UserLods {
  public static void main(String[] args) {
	  
	  // moe nedovyrsheno
	  	  
//		Scanner scan = new Scanner(System.in);		
//		// Parse the input log files and aggregate them
//		TreeMap<String, Integer> appearss = new TreeMap<>();
//		HashMap<String, TreeSet<String>> ipAddresses = new HashMap<>();
//		String line = scan.nextLine();
//		 while (!line.contains("end")) {			
//			String[] input = line.split("[=']+");
//			String ip = input[1].replace("message", "").trim();
//			String user = input[4];
//			int appears = 1;			
//			// Aggregate the user's sessions durations
//			Integer oldDuration = appearss.get(user);
//			if (oldDuration == null) {
//				oldDuration = 0;
//			}
//			appearss.put(user, oldDuration + appears);			
//			// Collect the IP addresses for the user
//			TreeSet<String> ipSet = ipAddresses.get(user);
//			if (ipSet == null) {
//				ipSet = new TreeSet<>();
//			}
//			ipSet.add(ip);
//			ipAddresses.put(user, ipSet);
//			
//			line = scan.nextLine();
//		}									
//		// Print the output in format <user>: <duration> [<IP1>, <IP2>, �]
//		for (Entry<String, Integer> userAndDuration : appearss.entrySet()) {
//			String user = userAndDuration.getKey();
//			int duration = userAndDuration.getValue();
//			TreeSet<String> ipSet = ipAddresses.get(user);
//			System.out.println(user + ": " + duration + " " + ipSet);
//		}
	  
	  
	  // avtorsko
	  
		TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
		
		Scanner scan = new Scanner(System.in);
		
		String command = scan.nextLine();
		
		while (!command.equals("end")) {
			String input[] = command.split(" ");
			
			String[] ipElements = input[0].split("=");
			String ip = ipElements[1];
			
			String[] userElements = input[2].split("="); 
			String user = userElements[1];
			
			insertData(data, ip, user);
			
			command = scan.nextLine();
		}
		
		printData(data);
		scan.close();
	}

	private static void insertData(
			TreeMap<String, LinkedHashMap<String, Integer>> data,
			String ip,
			String user) {
		
		if (!data.containsKey(user)) {
			data.put(user, new LinkedHashMap<String, Integer>());
			data.get(user).put(ip, 1);
		}
		else {
			Integer count = 0;
			if (data.get(user).containsKey(ip)) {
				count = data.get(user).get(ip);
			}
			
			data.get(user).put(ip, count + 1);
		}
	}
	
	private static void printData(
			TreeMap<String, LinkedHashMap<String, Integer>> data) {
		
		for(Map.Entry<String,LinkedHashMap<String, Integer>> entry : data.entrySet()) {
			  String user = entry.getKey();
			  LinkedHashMap<String, Integer> hashMap = entry.getValue();

			  System.out.println(user + ": ");
			  
			  for(Map.Entry<String,Integer> secondEntry : hashMap.entrySet()) {
				  String ip = secondEntry.getKey();
				  Integer count = secondEntry.getValue();

				  System.out.print(ip + " => " + count);
				  String lastKey = getLastKey(hashMap);
				  
				  if (ip.equals(lastKey)) {
					  System.out.print(".");
				  }
				  else {
					  System.out.print(", ");  
				  }
			  }
			  
			  System.out.println();
		}
	}
	
	public static String getLastKey(LinkedHashMap<String, Integer> hashMap) {
		  String out = "";
		  for (String key : hashMap.keySet()) {
		    out = key;
		  }
		  return out;
	
    }
}
