import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

//                                                 Problem 4 – School system
//Write a program that reads a list of student grade entries and prints the average grade of every subject for each student.
//For example, we are given the following entries:
//Ivan Ivanov history 5
//Ivan Ivanov math 3
//Ivan Ivanov math 4
//Peter Petrov physics 2
//There are two students – Ivan Ivanov and Peter Petrov. Ivan has an average grade in history of 5.00 and in math of 3.50. Peter 
//has an average grade in physics of 2.00. We print the students, sorted alphabetically by fullname. The subjects of each student
//should also be sorted alphabetically. The result is:
//Ivan Ivanov: [history – 5.00, math – 3.50]
//Peter Petrov: [physics – 2.00]
//Input
//The input comes from the console. At the first line a number n stays which says how many lines will follow.  Each of the next
//n lines holds information in format:
// <First name> <Last name> <subject> <score>
//The input data will always be valid and in the format described. There is no need to check it explicitly.
//Output
//Print on the console in a row for each student in the following format:
//<First name> <Last name>: [<subject> - <average score>, <subject> - <average score>, …]
//The subjects of each student should be printed in alphabetical order. Students should be printed in alphabetical order of their
//full name. The average grade should be rounded to the second decimal.
//Constraints
//•	The count of the entry lines n is in the range [1…1000].
//•	Time limit: 0.3 sec. Memory limit: 16 MB.
//Examples
//Input                                    	Output
//4                                Ivan Ivanov: [history – 5.00, math – 3.50]
//Ivan Ivanov history 5            Peter Petrov: [physics – 2.00]
//Ivan Ivanov math 3
//Ivan Ivanov math 4
//Peter Petrov physics 2	
public class p4SchoolSystem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();

		TreeMap<String, TreeMap<String, ArrayList<Integer>>> students = new TreeMap<String, TreeMap<String, ArrayList<Integer>>>();
		for (int i = 0; i < n; i++) {
			String[] inputAsArray = input.nextLine().split(" ");
			
			String fullName = inputAsArray[0] + " " + inputAsArray[1];
			String subject = inputAsArray[2];
			int mark = Integer.parseInt(inputAsArray[3]);
			
			TreeMap<String, ArrayList<Integer>> subjects = new TreeMap<String, ArrayList<Integer>>();
			if (students.containsKey(fullName)) {
				subjects = students.get(fullName);
				if (!subjects.containsKey(subject)) {
					subjects.put(subject, new ArrayList<>());
				}

				subjects.get(subject).add(mark);
			} else {
				ArrayList<Integer> marks = new ArrayList<>();
				marks.add(mark);
				subjects.put(subject, marks);
				students.put(fullName, subjects);
			}			
		}
		
		for ( Entry<String, TreeMap<String, ArrayList<Integer>>> student : students.entrySet() ) {
			String studentName = student.getKey();
			TreeMap<String, ArrayList<Integer>> subjects = student.getValue();
			String output  = studentName + ": [";
			ArrayList<Double> avrgMarks = new ArrayList<>();
			for (Entry<String, ArrayList<Integer> >subject : subjects.entrySet()) {
				String subjectName = subject.getKey();
				Object[] marks = subject.getValue().toArray();
			    output += subjectName + " - " + String.format("%.2f", averageOf(marks)) + ", ";
			    avrgMarks.add(averageOf(marks));
			}
			
			output = output.substring(0, output.length() - 2) + "]";
			System.out.print(output + "\n");
		}
		input.close();
	}
	

	public static double averageOf(Object[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (int)arr[i];
		}

		double average = sum / arr.length;

		return average;
	}
}
