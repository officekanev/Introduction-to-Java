//                              Problem 4.	 Print Characters
//Print the characters from ‘a’ to ‘z’ on the console on a single line,
//separated by a space. Use a for-loop. Note: you can directly declare 
//and increment char in the for-loop. for (char c = ‘a’; …)
//Output
//a b c d e f g h i j k l m n o p q r s t u v w x y z

public class PrintCharacters {
   public static void main(String[] args) {
	 char[] array = {'a','b','c','d','e','f','g','h','i','j',
			 'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	 for (int i = 0; i < array.length; i++) {
		System.out.print(array[i] + " ");
	}
   }
}
